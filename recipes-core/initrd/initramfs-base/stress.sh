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

interval="$(grep -Eo 'interval=\d+' /proc/cmdline)"
if [ -z "${interval}" ]; then
	interval=5
fi

fields="$(grep -Eo 'fields=\d+' /proc/cmdline)"
if [ -z "${fields}" ]; then
	fields="Node,Core,CPU,Avg_MHz,Busy%,Bzy_MHz,TSC_MHz,IPC,CorWatt,PkgWatt,CoreTmp,CoreThr,PkgTmp,RAMWatt,GFXWatt,SysWatt"
fi

turbostat -q -i ${interval} -s ${fields} < /dev/null &
mprime -t < /dev/null > /dev/ttyprintk 2> /dev/ttyprintk &

for idev in $(echo /sys/class/input/input*); do
	physid="$(cut -d'/' -f1 ${idev}/phys)"
	if [ "${physid}" == "LNXPWRBN" ]; then
		buttondev="$(echo ${idev} | grep -Eo '\d+$')"
		break;
	fi
done

if [ -z "${buttondev}" ]; then
	echo "Cannot find power button" > /dev/ttyprintk
	while :; do sleep 9999; done
fi

echo "Waiting for power button press (#${buttondev})" > /dev/ttyprintk
input-events -t 99999999 ${buttondev} 2>&1 | grep -q -m0 -F 'KEY POWER pressed'
echo "Power button pressed, shutting down" > /dev/ttyprintk
kill -9 -1
sleep 1
echo "o" > /proc/sysrq-trigger
while :; do sleep 9999; done
