DESCRIPTION = "Installs the Teleport Client, NOTE: this recipe does not compile the source code, it only installs the pre-compiled binaries from goteleport.com/download"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
SUMMARY = "Teleport Client"
FILE_NAME = "teleport-v${PV}-linux-arm-bin.tar.gz"

SRC_URI = "https://get.gravitational.com/${FILE_NAME}"

SRC_URI[sha256sum] = "8df57eceba6a999f2f9853dd18ecdf3d7c117e93adb2e03f18a7e4bc4d1a5960"

S = "${WORKDIR}/teleport"

# Disable already-stripped and arch checks for pre-built binaries
INSANE_SKIP:${PN} += "already-stripped"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/teleport/teleport ${D}${bindir}

    install -d ${D}/var/lib/teleport
}

FILES:${PN} = "${bindir}/teleport \
/var/lib/teleport \
"
