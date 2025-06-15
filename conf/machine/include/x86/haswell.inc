DEFAULTTUNE = "haswell-64"
TUNEVALID[haswell] = "Enable haswell specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains('TUNE_FEATURES', 'haswell', ' -march=haswell -mtune=haswell', '', d)}"

AVAILTUNES += "haswell-64"
TUNE_FEATURES:tune-haswell-64 = "${TUNE_FEATURES:tune-x86-64} haswell"
BASE_LIB:tune-haswell-64 = "lib64"
TUNE_PKGARCH:tune-haswell-64 = "haswell-64"
PACKAGE_EXTRA_ARCHS:tune-haswell-64 = "${PACKAGE_EXTRA_ARCHS:tune-x86-64} haswell-64"
QEMU_EXTRAOPTIONS:tune-haswell-64 = " -cpu Haswell,check=false"

COMPATIBLE_MACHINE:haswell = "^(haswell|genericx86-64)$"
