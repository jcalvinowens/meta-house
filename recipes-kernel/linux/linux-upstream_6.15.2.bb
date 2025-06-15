SUMMARY = "Vanilla upstream Linux kernel"
inherit kernel
require kernel-core.inc

SRC_URI += "file://defconfig"
DEPENDS += " \
	bc-native \
	bison-native \
	elfutils-native \
	gmp-native \
	libmpc-native \
	openssl-native \
	rsync-native \
	util-linux-native \
	unifdef-native \
	xz-native \
	"
