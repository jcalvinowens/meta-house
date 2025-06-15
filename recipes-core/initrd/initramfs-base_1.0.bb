SUMMARY = "Tiny initrd-only stress testing image"
LIC_FILES_CHKSUM = "file://stress.sh;beginline=3;endline=15;md5=4ccbb83d86381652d13b46797a3ee1de"
LICENSE = "ISC"

RDEPENDS:${PN} = "input-utils prime95 turbostat"
FILES:${PN} += "/proc /sys /dev /dev/console /stress /shell"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

SRC_URI += " \
	file://stress.sh \
	file://shell.sh \
	"

do_install() {
	install -d ${D}/proc ${D}/sys ${D}/dev
	install -m 0755 ${S}/stress.sh ${D}/stress
	install -m 0755 ${S}/shell.sh ${D}/shell
	mknod -m 0600 ${D}/dev/console c 5 1
}
