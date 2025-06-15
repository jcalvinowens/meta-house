require conf/machine/include/x86/x86-base.inc
require conf/machine/include/x86/arch-x86.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-upstream"

MACHINE_FEATURES:append = " \
	acpi \
	alsa \
	bluetooth \
	efi \
	keyboard \
	numa \
	pcbios \
	pci \
	qemu-usermode \
	rtc \
	screen \
	usbgadget \
	usbhost \
	vfat \
	wifi \
	"
