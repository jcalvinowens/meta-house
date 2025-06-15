SUMMARY = "Tiny initrd-only stress testing image"
LICENSE = "ISC"

RDEPENDS:${PN} = "prime95 turbostat"
FILES:${PN} += "/tmp /run /proc /sys /dev /dev/console /stress /shell"

do_install() {
	install -d ${D}/tmp ${D}/run ${D}/proc ${D}/sys ${D}/dev

	# Use /dev/ttyprintk to inverleave user/kernel logs nicely
	mknod -m 600 ${D}/dev/console c 5 1
	mknod -m 600 ${D}/dev/ttyprintk c 5 3

	cat > ${D}/stress <<-END
	#!/bin/sh

	set -e
	mount -t tmpfs tmpfs /tmp -o mode=1755,nodev,nosuid
	mount -t tmpfs tmpfs /run -o mode=0755,nodev,nosuid,strictatime
	mount -t proc proc /proc -o nosuid,nodev,noexec
	mount -t sysfs sysfs /sys -o nosuid,nodev,noexec
	mount -t devtmpfs devtmpfs /dev -o nosuid,noexec
	turbostat -i 5 -s Node,Core,CPU,Avg_MHz,Busy%,Bzy_MHz,TSC_MHz,IPC,CorWatt,PkgWatt,CoreTmp,CoreThr,PkgTmp,RAMWatt,GFXWatt,SysWatt &
	exec mprime -t < /dev/ttyprintk > /dev/ttyprintk 2> /dev/ttyprintk
	END
	chmod 755 ${D}/stress

	cat > ${D}/shell <<-END
	#!/bin/sh

	mount -t tmpfs tmpfs /tmp -o mode=1755,nodev,nosuid
	mount -t tmpfs tmpfs /run -o mode=0755,nodev,nosuid,strictatime
	mount -t proc proc /proc -o nosuid,nodev,noexec
	mount -t sysfs sysfs /sys -o nosuid,nodev,noexec
	mount -t devtmpfs devtmpfs /dev -o nosuid,noexec
	mkdir -p /dev/pts
	mount -t devpts devpts /dev/pts -o nosuid,noexec
	exec /bin/sh
	END
	chmod 755 ${D}/shell
}
