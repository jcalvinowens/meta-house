SUMMARY = "Prime95 Version 30.19 build 21"
HOMEPAGE = "https://www.mersenne.org/"

LICENSE = "Proprietary"
LICENSE_FLAGS = "mersenne-eula"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fe3b46fa9c1e2d20028cf1bbcb1ef712"
SRC_URI = "https://download.mersenne.ca/gimps/v30/30.19/p95v3019b21.source.zip"
SRC_URI[sha256sum] = "bdc843a547a6f91dc67004a3efbcd99858af7db075ecd77b7188b23e5ac2ce2a"

DEPENDS = "boost curl gmp hwloc openssl"
FILESEXTRAPATHS:prepend := "${THISDIR}/patches:"
SRC_URI += "file://0001-Trivial-fixes-to-support-yocto-and-musl.patch"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

FILES:${PN} += "${bindir}/mprime"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/mprime ${D}${bindir}
}
