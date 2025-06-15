#!/bin/sh

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

mount -t proc proc /proc -o nosuid,nodev,noexec
mount -t sysfs sysfs /sys -o nosuid,nodev,noexec
mount -t devtmpfs devtmpfs /dev -o nosuid,noexec

mkdir -p /tmp /run /dev/pts
mount -t tmpfs tmpfs /tmp -o mode=1755,nodev,nosuid
mount -t tmpfs tmpfs /run -o mode=0755,nodev,nosuid,strictatime
mount -t devpts devpts /dev/pts -o nosuid,noexec

exec setsid -c /bin/sh
