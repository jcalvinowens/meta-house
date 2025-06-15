SUMMARY = "Set locale to en_US.UTF-8"
LICENSE = "ISC"

RDEPENDS:${PN} = "bash"
FILES:${PN} = " \
	${sysconfdir}/profile.d/lang.sh \
	${sysconfdir}/locale.conf \
	"

do_install () {
	install -d ${D}/etc/profile.d

	cat > ${D}/${sysconfdir}/profile.d/lang.sh <<-END
	#!/bin/sh
	export LC_ALL=en_US.UTF-8
	export LANG=en_US.UTF-8
	END
	chmod 755 ${D}/${sysconfdir}/profile.d/lang.sh

	cat > ${D}/${sysconfdir}/locale.conf <<-END
	LC_ALL=en_US.UTF-8
	LANGUAGE=en_US.UTF-8
	LANG=en_US.UTF-8
	END
}
