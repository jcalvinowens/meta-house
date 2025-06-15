# FIXME: Find a better way to organize initrd-only images so we can have more
SUMMARY = "Dummy for initrd-only images"
COMPATIBLE_MACHINE = "genericx86-64"
WKS_FILE = "dummy-image.wks.in"
EXTRA_IMAGE_FEATURES = ""
IMAGE_INSTALL = ""
PACKAGE_INSTALL = "grub-bootconf"
DEPENDS:append = " memtest86plus"

inherit core-image

IMAGE_ROOTFS_EXTRA_SPACE = "0"

# FIXME: Figure out how to do this properly...
fixup_grub_cfg_kludge() {
	sed -ri "s/bzImage/${KERNEL_IMAGETYPE}-${INITRAMFS_LINK_NAME}.bin/g" \
		${IMAGE_ROOTFS}/boot/EFI/BOOT/grub.cfg

	cat >> ${IMAGE_ROOTFS}/boot/EFI/BOOT/grub.cfg <<-'END'

	menuentry 'MemTest86+' {
		linux /mt86plus.bin dark nopause nobigstatus
	}
	END
}

ROOTFS_POSTPROCESS_COMMAND += "fixup_grub_cfg_kludge"
