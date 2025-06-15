inherit packagegroup

RDEPENDS:${PN} = " \
	packagegroup-base-bluetooth \
	packagegroup-core-x11 \
	packagegroup-gnome-apps \
	packagegroup-gnome-desktop \
	packagegroup-house-common \
	packagegroup-house-fonts \
	\
	alsa-utils-alsamixer \
	bluez5 \
	chromium-ozone-wayland \
	ffmpeg \
	gconf \
	gdm \
	gvfs \
	iw \
	mpv \
	network-manager-applet \
	networkmanager \
	samba \
	vte-prompt \
	wpa-supplicant \
	xwayland \
	"
