SUMMARY = "Minimalist Initrd-Only System"
LICENSE = "ISC"

IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""
IMAGE_NAME_SUFFIX ?= ""
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
COMPATIBLE_HOST = '(x86_64.*)-(linux.*)'
COMPATIBLE_MACHINE = "minimal-pc"

PACKAGE_EXCLUDE = "kernel-image-*"
PACKAGE_INSTALL = "busybox initramfs-base packagegroup-core-boot"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
