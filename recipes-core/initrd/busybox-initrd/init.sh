#!/bin/sh

# Supports: root=/dev/${device} root=LABEL=${fslabel} root=UUID=${fsuuid}
# Does NOT support GPT parameters: root=PARTLABEL= root=PARTUUID=
#
# Copyright (C) 2025 Calvin Owens <calvin@wbinvd.org>
#
# Permission to use, copy, modify, and /or distribute this software for
# any purpose with or without fee is hereby granted, provided that the
# above copyright notice and this permission notice appear in all copies.
#
# THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
# WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
# MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
# ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
# WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
# ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
# OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.

set -e
mkdir -p /tmp /run /proc /sys /dev /sysroot
mount -t tmpfs tmpfs /tmp -o mode=1755,nodev,nosuid
mount -t tmpfs tmpfs /run -o mode=0755,nodev,nosuid,strictatime
mount -t proc proc /proc -o nosuid,nodev,noexec
mount -t sysfs sysfs /sys -o nosuid,nodev,noexec
mount -t devtmpfs devtmpfs /dev -o nosuid,noexec
mkdir -p /dev/pts
mount -t devpts devpts /dev/pts -o nosuid,noexec

for kmod in $(find /lib/modules/$(uname -r)/ -name '*.ko*'); do
	kmod_name=$(basename ${kmod} | cut -d'.' -f1)
	if ! grep -qE "^${kmod_name} " /proc/modules; then
		modprobe ${kmod_name}
	fi
done

rootspec="$(grep -oE 'root=\S+' /proc/cmdline | cut -d'=' -f2- | tail -n1)"
if [ -z "${rootspec}" ]; then
	echo -n "FATAL: No root= parameter on kernel command line: "
	cat /proc/cmdline
	exit 1
fi

echo "Waiting for ${rootspec}..."
while [ -z "${rootdev}" ]; do
	sleep 1
	mount -o remount,nosuid,noexec /dev
	rootdev="$(blkid | tr -d '"' | grep -F "${rootspec}" | cut -d':' -f1)"
done

echo "Switching to ${rootdev}..."
mount -o ro ${rootdev} /sysroot
umount /dev/pts /dev /sys /proc /run /tmp
exec switch_root /sysroot /sbin/init
