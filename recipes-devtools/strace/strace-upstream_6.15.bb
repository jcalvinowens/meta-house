SUMMARY = "Vanilla strace"
HOMEPAGE = "http://strace.io"
LICENSE = "LGPL-2.1-or-later & GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=1efaf30bb0084b4a17a6f55f9cbcd25b"
S = "${WORKDIR}/strace-${PV}"
SECTION = "console/utils"
PROVIDES += "strace"
RPROVIDES:${PN} += "strace"
FILES:${PN} = "/**"

SRC_URI = "https://github.com/strace/strace/releases/download/v${PV}/strace-${PV}.tar.xz"
SRC_URI[sha256sum] = "8552dfab08abc22a0f2048c98fd9541fd4d71b6882507952780dab7c7c512f51"

inherit autotools

EXTRA_OECONF += "--enable-mpers=no --disable-gcc-Werror --without-libunwind ac_cv_header_bluetooth_bluetooth_h=no"
CFLAGS:append:libc-musl = " -Dsigcontext_struct=sigcontext"
BBCLASSEXTEND = "native"
