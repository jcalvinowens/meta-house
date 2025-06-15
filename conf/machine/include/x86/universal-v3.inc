DEFAULTTUNE = "universal-v3-64"
TUNEVALID[universal-v3] = "Universal x86-64-v3 optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'universal-v3', ' -march=x86-64-v3', '', d)}"

AVAILTUNES += "universal-v3-64"
TUNE_FEATURES:tune-universal-v3-64 = "${TUNE_FEATURES:tune-x86-64} universal-v3"
BASE_LIB:tune-universal-v3-64 = "lib64"
TUNE_PKGARCH:tune-universal-v3-64 = "universal-v3-64"
PACKAGE_EXTRA_ARCHS:tune-universal-v3-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} universal-v3-64"
QEMU_EXTRAOPTIONS:tune-universal-v3-64 = " -cpu Skylake-Client,check=false"

COMPATIBLE_MACHINE:universal-v3 = "^(universal-v3|genericx86-64)$"
