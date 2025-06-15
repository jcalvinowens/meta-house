DEFAULTTUNE = "znver5-64"
TUNEVALID[znver5] = "Enable AMD Zen V5 specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'znver5', ' -march=znver5 -mtune=znver5', '', d)}"

AVAILTUNES += "znver5-64"
TUNE_FEATURES:tune-znver5-64 = "${TUNE_FEATURES:tune-x86-64} znver5"
BASE_LIB:tune-znver5-64 = "lib64"
TUNE_PKGARCH:tune-znver5-64 = "znver5-64"
PACKAGE_EXTRA_ARCHS:tune-znver5-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} znver5-64"
QEMU_EXTRAOPTIONS:tune-znver5-64 = " -cpu EPYC,check=false"

COMPATIBLE_MACHINE:znver5 = "^(znver5|genericx86-64)$"
