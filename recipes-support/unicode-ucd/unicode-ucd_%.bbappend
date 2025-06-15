# wget -q 'https://www.unicode.org/license.txt' -O - | sha256sum -
SRC_URI[ucd-license.sha256sum] = "abf84f74dea2812799e1dbef7f0581adf7db244881e4febb8684f441568da0ad"

# wget -q 'https://www.unicode.org/license.txt' -O - | md5sum -
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/ucd-license-v3.txt;md5=ea17640caddb659394df50e5db6efd69"
