DEFAULTTUNE = "znver3-64"
TUNEVALID[znver3] = "Enable AMD Zen V3 specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'znver3', ' -march=znver3 -mtune=znver3', '', d)}"

AVAILTUNES += "znver3-64"
TUNE_FEATURES:tune-znver3-64 = "${TUNE_FEATURES:tune-x86-64} znver3"
BASE_LIB:tune-znver3-64 = "lib64"
TUNE_PKGARCH:tune-znver3-64 = "znver3-64"
PACKAGE_EXTRA_ARCHS:tune-znver3-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} znver3-64"
QEMU_EXTRAOPTIONS:tune-znver3-64 = " -cpu EPYC,check=false"

COMPATIBLE_MACHINE:znver3 = "^(znver3|genericx86-64)$"
