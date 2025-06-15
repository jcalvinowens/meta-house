DEFAULTTUNE = "universal-v2-64"
TUNEVALID[universal-v2] = "Universal x86-64-v2 optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'universal-v2', ' -march=x86-64-v2', '', d)}"

AVAILTUNES += "universal-v2-64"
TUNE_FEATURES:tune-universal-v2-64 = "${TUNE_FEATURES:tune-x86-64} universal-v2"
BASE_LIB:tune-universal-v2-64 = "lib64"
TUNE_PKGARCH:tune-universal-v2-64 = "universal-v2-64"
PACKAGE_EXTRA_ARCHS:tune-universal-v2-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} universal-v2-64"
QEMU_EXTRAOPTIONS:tune-universal-v2-64 = " -cpu Nehalem,check=false"

COMPATIBLE_MACHINE:universal-v2 = "^(universal-v2|genericx86-64)$"
