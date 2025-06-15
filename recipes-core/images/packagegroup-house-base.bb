# All images

inherit packagegroup

RDEPENDS:${PN} = " \
	packagegroup-core-base-utils \
	packagegroup-core-boot \
	packagegroup-core-ssh-openssh \
	\
	base-files-rootfs \
	os-release \
	sudo \
	tzdata \
	"

RRECOMMENDS:${PN} = " \
	kernel-modules \
	"
