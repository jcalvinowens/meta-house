SUMMARY = "Self-Hosting Workstation"
COMPATIBLE_MACHINE = "genericx86-64"
WKS_FILE = "house-image.wks.in"
SYSTEMD_DEFAULT_TARGET = "multi-user.target"
EXTRA_IMAGE_FEATURES = "dev-pkgs doc-pkgs tools-debug tools-sdk"
CORE_IMAGE_EXTRA_INSTALL += "packagegroup-house-workstation"

inherit core-image
require boot.inc
require user.inc
