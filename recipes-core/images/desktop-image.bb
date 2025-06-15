SUMMARY = "Generic GNOME3 Desktop"
COMPATIBLE_MACHINE = "genericx86-64"
WKS_FILE = "house-image.wks.in"
SYSTEMD_DEFAULT_TARGET = "graphical.target"
EXTRA_IMAGE_FEATURES = "splash"
CORE_IMAGE_EXTRA_INSTALL += "packagegroup-house-desktop"

inherit core-image
require boot.inc
require user.inc
