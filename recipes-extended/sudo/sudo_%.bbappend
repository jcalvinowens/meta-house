SUMMARY = "Allow group wheel to execute any command without a password"
FILES:${PN} += "${sysconfdir}/sudoers.d/10-wheel-nopasswd"

do_install:append() {
	install -d ${D}${sysconfdir}/sudoers.d
	cat > ${D}${sysconfdir}/sudoers.d/10-wheel-nopasswd <<-'END'
	%wheel ALL=(ALL:ALL) NOPASSWD: ALL
	END
}
