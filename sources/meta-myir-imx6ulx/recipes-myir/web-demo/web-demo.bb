DESCRIPTION = "web dem"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-dev ${PN}-staticdev ${PN}-locale"
PACKAGES_DYNAMIC = "${PN}-locale-*"

SRC_URI = "file://cJSON.tar.bz2;md5sum=580394db958e0edfcd5ca4b25fbedf96 \
           file://mxde.xml \
           file://settings.ini \
           file://board_cfg.json \
           file://myir \
           "
LIC_FILES_CHKSUM = "file://settings.ini;md5=b2e121f7083d25452d0f7168eb7196f9"

S = "${WORKDIR}"

do_compile () {
    make
}

do_install () {
      install -d ${D}/usr/share/myir/
      install -d ${D}/lib/
      cp -S ${S}/*.so* ${D}/lib/
      cp -r ${S}/myir/* ${D}/usr/share/myir/
      install -m 0755 ${S}/board_cfg.json ${D}/usr/share/myir/
      install -m 0755 ${S}/mxde.xml ${D}/usr/share/myir/
      install -m 0755 ${S}/settings.ini ${D}/usr/share/myir/
}

FILES_${PN} = "/home/myir/ \
	     /usr/share/myir/ \
	     /usr/share/myir/*/* \
	     /lib/ \
             "

