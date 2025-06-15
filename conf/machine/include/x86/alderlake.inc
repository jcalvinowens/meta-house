DEFAULTTUNE = "alderlake-64"
TUNEVALID[alderlake] = "Enable Alder Lake specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'alderlake', ' -march=alderlake -mtune=alderlake', '', d)}"

AVAILTUNES += "alderlake-64"
TUNE_FEATURES:tune-alderlake-64 = "${TUNE_FEATURES:tune-x86-64} alderlake"
BASE_LIB:tune-alderlake-64 = "lib64"
TUNE_PKGARCH:tune-alderlake-64 = "alderlake-64"
PACKAGE_EXTRA_ARCHS:tune-alderlake-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} alderlake-64"
QEMU_EXTRAOPTIONS:tune-alderlake-64 = " -cpu GraniteRapids,check=false"

COMPATIBLE_MACHINE:alderlake = "^(alderlake|genericx86-64)$"
