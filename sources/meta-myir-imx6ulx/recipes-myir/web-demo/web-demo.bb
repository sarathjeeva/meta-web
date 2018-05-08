DESCRIPTION = "web dem"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-dev ${PN}-staticdev ${PN}-locale"
PACKAGES_DYNAMIC = "${PN}-locale-*"


SRCREV = "5e05de4b269ea81d17906ddda2af034c757d3750"
SRC_URI = " file://cJSON.tar.bz2;md5sum=580394db958e0edfcd5ca4b25fbedf96 \
            git://github.com/hufan/web-demo-bb;protocol=https;branch=web_server"
			
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}/"
S_1 = "${WORKDIR}/git"
do_compile () {
    make
}

do_install () {
      install -d ${D}/usr/share/myir/
      install -d ${D}/usr/share/myir/www/
      install -d ${D}/lib/
      cp -S ${S}/*.so* ${D}/lib/
      cp -r ${S_1}/web_server/* ${D}/usr/share/myir/www/
      install -m 0755 ${S_1}/board_cfg.json ${D}/usr/share/myir/
      install -m 0755 ${S_1}/mxde.xml ${D}/usr/share/myir/
      install -m 0755 ${S_1}/settings.ini ${D}/usr/share/myir/
}

FILES_${PN} = "/home/myir/ \
	     /usr/share/myir/ \
	     /usr/share/myir/www/ \
	     /usr/share/myir/*/* \
	     /lib/ \
             "

