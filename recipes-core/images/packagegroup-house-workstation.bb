inherit packagegroup

RDEPENDS:${PN} = " \
	packagegroup-house-common \
	packagegroup-self-hosted \
	\
	kernel-dev \
	kernel-devsrc \
	perl-misc \
	python3-pip \
	python3-distro \
	python3-git \
	python3-gnupg \
	python3-jsonschema \
	python3-pyyaml \
	rpcsvc-proto \
	"
