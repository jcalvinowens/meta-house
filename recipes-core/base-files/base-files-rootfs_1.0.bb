SUMMARY = "Overrides for rootfs base-files"
LICENSE = "ISC"

FILES:${PN} += "${sysconfdir}/fstab"

do_install() {
	install -d ${D}/${sysconfdir}

	cat > ${D}/${sysconfdir}/fstab <<-END
	LABEL=root / auto defaults 0 1
	LABEL=boot /boot auto defaults 0 2
	tmpfs /var/volatile tmpfs defaults 0 0
	END
}
