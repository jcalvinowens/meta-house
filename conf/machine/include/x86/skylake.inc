DEFAULTTUNE = "skylake-64"
TUNEVALID[skylake] = "Enable skylake specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'skylake', ' -march=skylake -mtune=skylake', '', d)}"

AVAILTUNES += "skylake-64"
TUNE_FEATURES:tune-skylake-64 = "${TUNE_FEATURES:tune-x86-64} skylake"
BASE_LIB:tune-skylake-64 = "lib64"
TUNE_PKGARCH:tune-skylake-64 = "skylake-64"
PACKAGE_EXTRA_ARCHS:tune-skylake-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} skylake-64"
QEMU_EXTRAOPTIONS:tune-skylake-64 = " -cpu Skylake-Server,check=false"

COMPATIBLE_MACHINE:skylake = "^(skylake|genericx86-64)$"
