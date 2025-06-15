DEFAULTTUNE = "silvermont-64"
TUNEVALID[silvermont] = "Enable Silvermont specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'silvermont', ' -march=silvermont -mtune=silvermont', '', d)}"

AVAILTUNES += "silvermont-64"
TUNE_FEATURES:tune-silvermont-64 = "${TUNE_FEATURES:tune-x86-64} silvermont"
BASE_LIB:tune-silvermont-64 = "lib64"
TUNE_PKGARCH:tune-silvermont-64 = "silvermont-64"
PACKAGE_EXTRA_ARCHS:tune-silvermont-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} silvermont-64"
QEMU_EXTRAOPTIONS:tune-silvermont-64 = " -cpu Denverton,check=false"

COMPATIBLE_MACHINE:silvermont = "^(silvermont|genericx86-64)$"
