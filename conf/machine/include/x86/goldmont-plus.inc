DEFAULTTUNE = "goldmont-plus-64"
TUNEVALID[goldmont-plus] = "Enable goldmont-plus specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'goldmont-plus', ' -march=goldmont-plus -mtune=goldmont-plus', '', d)}"

AVAILTUNES += "goldmont-plus-64"
TUNE_FEATURES:tune-goldmont-plus-64 = "${TUNE_FEATURES:tune-x86-64} goldmont-plus"
BASE_LIB:tune-goldmont-plus-64 = "lib64"
TUNE_PKGARCH:tune-goldmont-plus-64 = "goldmont-plus-64"
PACKAGE_EXTRA_ARCHS:tune-goldmont-plus-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} goldmont-plus-64"
QEMU_EXTRAOPTIONS:tune-goldmont-plus-64 = " -cpu Cooperlake,check=false"

COMPATIBLE_MACHINE:goldmont-plus = "^(goldmont-plus|genericx86-64)$"
