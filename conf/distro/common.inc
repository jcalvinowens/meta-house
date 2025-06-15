# Self-hosting DISTROs

PACKAGE_CLASSES = "package_ipk"

BUILD_CFLAGS:append:pn-binutils-native = " -pie -fpie"

PREFERRED_PROVIDER_virtual/base-utils = "packagegroup-core-base-utils"
VIRTUAL-RUNTIME_base-utils-hwclock = "util-linux-hwclock"
VIRTUAL-RUNTIME_keymaps = "keymaps"
VIRTUAL-RUNTIME_login_manager = "shadow-base"
VIRTUAL-RUNTIME_vim = "vim"

DEFAULT_IMAGE_LINGUAS = "en-us"
DEFAULT_IMAGE_LINGUAS:libc-glibc = "en-us c"

GLIBC_GENERATE_LOCALES = "all"
ENABLE_BINARY_LOCALE_GENERATION = "1"

LOCALE_UTF8_IS_DEFAULT = "1"
LOCALE_UTF8_IS_DEFAULT:class-nativesdk = "0"
LOCALE_UTF8_ONLY = "0"

require conf/distro/base.inc
