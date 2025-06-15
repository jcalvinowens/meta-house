SUMMARY = "Generic initrd with busybox"
LICENSE = "ISC"

IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""
IMAGE_NAME_SUFFIX ?= ""
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
COMPATIBLE_HOST = '(x86_64.*)-(linux.*)'

PACKAGE_EXCLUDE = "kernel-image-*"
PACKAGE_INSTALL = "busybox-initrd os-release-initrd"

PACKAGE_INSTALL_ATTEMPTONLY:append = " \
	kernel-module-ahci \
	kernel-module-atkbd \
	kernel-module-cqhci \
	kernel-module-ehci-hcd \
	kernel-module-ehci-pci \
	kernel-module-ext4 \
	kernel-module-hid-generic \
	kernel-module-mmc-block \
	kernel-module-mmc-core \
	kernel-module-nvme \
	kernel-module-nvme-core \
	kernel-module-ohci-hcd \
	kernel-module-ohci-pci \
	kernel-module-rtc-cmos \
	kernel-module-rpmb-core \
	kernel-module-scsi-mod \
	kernel-module-sdhci \
	kernel-module-sdhci-pci \
	kernel-module-sd-mod \
	kernel-module-uhci-hcd \
	kernel-module-usb-storage \
	kernel-module-usbhid \
	kernel-module-vmd \
	kernel-module-xhci-hcd \
	kernel-module-xhci-pci \
	"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
