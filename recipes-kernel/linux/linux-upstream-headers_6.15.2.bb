SUMMARY = "Vanilla upstream Linux kernel headers"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel-arch pkgconfig multilib_header
require kernel-core.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://allyesconfig"
DEPENDS += "unifdef-native bison-native rsync-native"
PROVIDES += "linux-libc-headers"
FILES:${PN} = "${includedir}/**"
RPROVIDES:${PN} += " \
	linux-libc-headers-dev \
	linux-libc-headers-dbg \
	linux-libc-headers-src \
	linux-libc-headers-staticdev \
	linux-libc-headers-doc \
	^linux-libc-headers-locale-.* \
	linux-libc-headers-locale \
	nativesdk-linux-libc-headers-dev \
	"

EXTRA_OEMAKE = " HOSTCC="${BUILD_CC}" HOSTCPP="${BUILD_CPP}""
do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install() {
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix}
}

BBCLASSEXTEND = "nativesdk"
DEV_PKG_DEPENDENCY = ""
INHIBIT_DEFAULT_DEPS = "1"
RRECOMMENDS:${PN}-dbg = "${PN}-dev (= ${EXTENDPKGV})"
