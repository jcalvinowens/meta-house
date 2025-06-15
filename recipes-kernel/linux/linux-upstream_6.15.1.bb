SUMMARY = "Vanilla upstream Linux kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v6.x/linux-${PV}.tar.xz"
SRC_URI[sha256sum] = "44f1bb84fe512e7bafe0e6dc85d38ec1c6c8fcbe97ccb51d8c19930b799f0d64"
SRC_URI += "file://defconfig"
S = "${WORKDIR}/linux-${PV}"

DEPENDS += " \
	bc-native \
	elfutils-native \
	gmp-native \
	libmpc-native \
	openssl-native \
	util-linux-native \
	xz-native \
	"

FILESEXTRAPATHS:prepend := "${THISDIR}/patches:"
SRC_URI += " \
	file://0001-tools-power-turbostat-Fix-build-with-musl.patch \
	file://0001-tools-power-turbostat-Fix-MSRs-with-CONFIG_MULTIUSER.patch \
	"
