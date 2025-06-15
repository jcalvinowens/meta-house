SUMMARY = "Minimalist nolibc initrd"
LIC_FILES_CHKSUM = "file://init.c;startline=2;endline=14;md5=ed674d7badf67058576385e93189bcb8"
LICENSE = "ISC"

RDEPENDS:${PN} = ""
FILES:${PN} = "/init"
SRC_URI += "file://init.c file://Makefile"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
	install -m 755 ${S}/init ${D}/init
}
