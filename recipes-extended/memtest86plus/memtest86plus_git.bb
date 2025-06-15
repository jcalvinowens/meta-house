SUMMARY = "Memtest86+"
HOMEPAGE = "https://memtest.org/"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRC_URI = "git://github.com/jcalvinowens/memtest86plus-llvm;protocol=https;nobranch=1"
SRCREV = "bdbe89e6c2da3efd285e35430e47712a71c8141d"
S = "${WORKDIR}/git"

do_compile() {
	cd ${S}/build/x86_64
	oe_runmake
}

inherit deploy

do_deploy() {
	install -m 755 ${S}/build/x86_64/mt86plus ${DEPLOYDIR}/mt86plus.bin
}

addtask deploy after do_compile
