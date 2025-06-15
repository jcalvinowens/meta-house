DEFAULTTUNE = "znver4-64"
TUNEVALID[znver4] = "Enable AMD Zen V4 specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'znver4', ' -march=znver4 -mtune=znver4', '', d)}"

AVAILTUNES += "znver4-64"
TUNE_FEATURES:tune-znver4-64 = "${TUNE_FEATURES:tune-x86-64} znver4"
BASE_LIB:tune-znver4-64 = "lib64"
TUNE_PKGARCH:tune-znver4-64 = "znver4-64"
PACKAGE_EXTRA_ARCHS:tune-znver4-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} znver4-64"
QEMU_EXTRAOPTIONS:tune-znver4-64 = " -cpu EPYC,check=false"

COMPATIBLE_MACHINE:znver4 = "^(znver4|genericx86-64)$"
