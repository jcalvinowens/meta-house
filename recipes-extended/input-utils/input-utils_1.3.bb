SUMMARY = "Linux Input Utilities"
HOMEPAGE = "https://www.kraxel.org/blog/linux/input/"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=e8feb78a32950a909621bbb51f634b39"
SRC_URI = "https://www.kraxel.org/releases/input/input-${PV}.tar.gz"
SRC_URI[sha256sum] = "9142c34d508f2da4cd53d6348fee77e30b69c35c8dabfadfc5a6db09c4bd8087"
S = "${WORKDIR}/input-${PV}"

DEPENDS = "bash linux-libc-headers"
FILES:${PN} = " \
	${bindir}/lsinput \
	${bindir}/input-events \
	${bindir}/input-kbd \
	${bindir}/input-send \
	${bindir}/input-recv \
	"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 lsinput ${D}${bindir}
	install -m 0755 input-events ${D}${bindir}
	install -m 0755 input-kbd ${D}${bindir}
	install -m 0755 input-send ${D}${bindir}
	install -m 0755 input-recv ${D}${bindir}
}
