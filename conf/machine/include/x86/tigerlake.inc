DEFAULTTUNE = "tigerlake-64"
TUNEVALID[tigerlake] = "Enable Tiger Lake specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'tigerlake', ' -march=tigerlake -mtune=tigerlake', '', d)}"

AVAILTUNES += "tigerlake-64"
TUNE_FEATURES:tune-tigerlake-64 = "${TUNE_FEATURES:tune-x86-64} tigerlake"
BASE_LIB:tune-tigerlake-64 = "lib64"
TUNE_PKGARCH:tune-tigerlake-64 = "tigerlake-64"
PACKAGE_EXTRA_ARCHS:tune-tigerlake-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} tigerlake-64"
QEMU_EXTRAOPTIONS:tune-tigerlake-64 = " -cpu Icelake-Server,check=false"

COMPATIBLE_MACHINE:tigerlake = "^(tigerlake|genericx86-64)$"
