inherit ${@bb.utils.contains('EFI_PROVIDER', 'systemd-boot', 'uki', '', d)}

UKI_CMDLINE = "${APPEND}"

remove_redundant_kernel_image() {
	rm -f ${IMAGE_ROOTFS}/boot/bzImage
}

ROOTFS_POSTPROCESS_COMMAND += "${@bb.utils.contains('EFI_PROVIDER', 'systemd-boot', 'remove_redundant_kernel_image', '', d)}"
