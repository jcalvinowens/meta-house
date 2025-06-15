SUMMARY = "Remove generic base-files"

FILES:remove:${PN} = " \
	${sysconfdir}/fstab \
	"

do_install:append() {
	rm ${D}/${sysconfdir}/fstab
}
