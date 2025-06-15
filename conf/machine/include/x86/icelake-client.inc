DEFAULTTUNE = "icelake-client-64"
TUNEVALID[icelake-client] = "Enable Ice Lake specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'icelake-client', ' -march=icelake-client -mtune=icelake-client', '', d)}"

AVAILTUNES += "icelake-client-64"
TUNE_FEATURES:tune-icelake-client-64 = "${TUNE_FEATURES:tune-x86-64} icelake-client"
BASE_LIB:tune-icelake-client-64 = "lib64"
TUNE_PKGARCH:tune-icelake-client-64 = "icelake-client-64"
PACKAGE_EXTRA_ARCHS:tune-icelake-client-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} icelake-client-64"
QEMU_EXTRAOPTIONS:tune-icelake-client-64 = " -cpu Icelake-Server,check=false"

COMPATIBLE_MACHINE:icelake-client = "^(icelake-client|genericx86-64)$"
