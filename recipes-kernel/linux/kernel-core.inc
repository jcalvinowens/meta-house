LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LICENSE = "GPL-2.0-only"

SRC_URI = "${KERNELORG_MIRROR}/linux/kernel/v6.x/linux-${PV}.tar.xz"
SRC_URI[sha256sum] = "3458cd6a6c508e161dbc5406e72b99d5dbdf929faf704a67db9ba46d07514858"
S = "${WORKDIR}/linux-${PV}"

FILESEXTRAPATHS:prepend := "${THISDIR}/patches:"
SRC_URI += " \
	file://0001-tools-power-turbostat-Fix-build-with-musl.patch \
	file://0001-tools-power-turbostat-Fix-MSRs-with-CONFIG_MULTIUSER.patch \
	"
