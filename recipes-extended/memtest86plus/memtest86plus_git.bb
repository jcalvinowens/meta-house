SUMMARY = "Memtest86+"
HOMEPAGE = "https://memtest.org/"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRC_URI = "git://github.com/memtest86plus/memtest86plus;protocol=https;nobranch=1"
SRCREV = "2f9b165eec4de20ec4b23725c90d3989517ee3fe"
S = "${WORKDIR}/git"

FILESEXTRAPATHS:prepend := "${THISDIR}/patches:"
SRC_URI += " \
	file://0001-Tweak-x86_64-makefile-to-support-compilers-other-tha.patch \
	file://0002-Use-function-pointer-to-work-around-clang-indirect-g.patch \
	file://0003-Force-memcpy-and-memset-to-be-defined-for-llvm.patch \
	file://0004-Increase-the-llvm-macro-recursion-limit-for-the-ptes.patch \
	file://0005-Include-.shstrtab-in-linker-scripts.patch \
	file://0006-Drop-the-warn-constructors-linker-flag.patch \
	file://0007-Make-GOTs-contiguous.patch \
	file://0008-Explicitly-include-.rela.dyn.patch \
	"

do_compile() {
	oe_runmake -C ${S}/build/x86_64
}

inherit deploy

do_deploy() {
	install -m 0644 ${S}/build/x86_64/mt86plus ${DEPLOYDIR}/mt86plus.bin
}

addtask deploy after do_compile
