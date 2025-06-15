SUMMARY = "Generic GNOME3 Self-Hosting Workstation Desktop"
COMPATIBLE_MACHINE = "genericx86-64"
WKS_FILE = "house-image.wks.in"
SYSTEMD_DEFAULT_TARGET = "graphical.target"
# FIXME: Can't include doc-pkgs due to xwayland/xorg-x11 conflict
EXTRA_IMAGE_FEATURES = "dev-pkgs splash tools-debug tools-sdk"
CORE_IMAGE_EXTRA_INSTALL += " \
	packagegroup-house-desktop \
	packagegroup-house-workstation \
	"

inherit core-image
require boot.inc
require user.inc
