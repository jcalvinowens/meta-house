DEFAULTTUNE = "universal-v4-64"
TUNEVALID[universal-v4] = "Universal x86-64-v4 optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'universal-v4', ' -march=x86-64-v4', '', d)}"

AVAILTUNES += "universal-v4-64"
TUNE_FEATURES:tune-universal-v4-64 = "${TUNE_FEATURES:tune-x86-64} universal-v4"
BASE_LIB:tune-universal-v4-64 = "lib64"
TUNE_PKGARCH:tune-universal-v4-64 = "universal-v4-64"
PACKAGE_EXTRA_ARCHS:tune-universal-v4-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} universal-v4-64"
QEMU_EXTRAOPTIONS:tune-universal-v4-64 = " -cpu SapphireRapids,check=false"

COMPATIBLE_MACHINE:universal-v4 = "^(universal-v4|genericx86-64)$"
