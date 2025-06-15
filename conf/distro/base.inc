# All DISTROs

SDK_VENDOR = "-${DISTRO}sdk"
SDK_VERSION = "${DISTRO_VERSION}"
SDK_VERSION[vardepvalue] = "${SDK_VERSION}"
SDK_NAME = "${DISTRO}-${TCLIBC}-${SDKMACHINE}-${IMAGE_BASENAME}-${TUNE_PKGARCH}-${MACHINE}"
SDKPATHINSTALL = "/opt/${DISTRO}/${SDK_VERSION}"
TARGET_VENDOR = "-${DISTRO}"

FILESYSTEM_PERMS_TABLES:remove = "files/fs-perms-volatile-log.txt"
ROOT_HOME = "/root"

BB_HASHSERVE = "auto"
BB_SIGNATURE_HANDLER = "OEEquivHash"
BB_STRICT_CHECKSUM = "1"
BBINCLUDELOGS = "yes"
OEINCLUDELOGS = "yes"

INHERIT += "create-spdx"
CONNECTIVITY_CHECK_URIS = ""
QA_LOGFILE = "${TMPDIR}/qa.log"
NOERROR_QA = "buildpaths patch-status"
ERROR_QA:remove := "${NOERROR_QA}"
WARN_QA:append := " ${NOERROR_QA}"

# FIXME: Force the user to acknowledge this somehow...
LICENSE_FLAGS_ACCEPTED:append = " commercial"
