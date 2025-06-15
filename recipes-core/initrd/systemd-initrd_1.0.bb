SUMMARY = "Generic initrd with systemd"
LIC_FILES_CHKSUM = "file://switch-root.service;beginline=1;endline=13;md5=4ccbb83d86381652d13b46797a3ee1de"
LICENSE = "ISC"

RDEPENDS:${PN} = "systemd"
FILES:${PN} += "/sysroot /dev/console ${systemd_unitdir}/system/switch-root.service"
SRC_URI += "file://switch-root.service"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

do_install() {
	install -d ${D}/sysroot

	install -d ${D}/dev
	mknod -m 600 ${D}/dev/console c 5 1

	install -d ${D}/${systemd_unitdir}/system
	install ${S}/switch-root.service ${D}/${systemd_unitdir}/system
}
