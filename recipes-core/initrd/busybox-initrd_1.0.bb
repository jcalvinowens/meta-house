SUMMARY = "Generic initrd with busybox"
LIC_FILES_CHKSUM = "file://init.sh;beginline=6;endline=18;md5=4ccbb83d86381652d13b46797a3ee1de"
LICENSE = "ISC"

RDEPENDS:${PN} = "busybox kmod"
FILES:${PN} += "/sysroot /dev/console /init"
SRC_URI += "file://init.sh"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
	install -d ${D}/sysroot

	install -d ${D}/dev
	mknod -m 600 ${D}/dev/console c 5 1

	install -m 755 ${S}/init.sh ${D}/init
}
