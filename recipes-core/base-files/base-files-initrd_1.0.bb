SUMMARY = "Overrides for initrd base-files"
LICENSE = "ISC"

FILES:${PN} += "${sysconfdir}/fstab"

do_install() {
	install -d ${D}/${sysconfdir}

	cat > ${D}/${sysconfdir}/fstab <<-END
	LABEL=root /sysroot auto ro 0 1
	tmpfs /tmp tmpfs defaults 0 0
	END
}
