SUMMARY = "Minimal System with SSH"
COMPATIBLE_MACHINE = "genericx86-64"
WKS_FILE = "house-image.wks.in"
SYSTEMD_DEFAULT_TARGET = "multi-user.target"
EXTRA_IMAGE_FEATURES = ""
CORE_IMAGE_EXTRA_INSTALL += "packagegroup-house-base"

inherit core-image
require boot.inc
require user.inc
