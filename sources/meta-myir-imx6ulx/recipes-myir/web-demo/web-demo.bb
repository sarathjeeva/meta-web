DESCRIPTION = "web dem"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-dev ${PN}-staticdev ${PN}-locale"
PACKAGES_DYNAMIC = "${PN}-locale-*"


SRCREV = "96476d60c12b0472ea094f7a2c137b335d988800"
SRC_URI = " file://cJSON.tar.bz2;md5sum=580394db958e0edfcd5ca4b25fbedf96 \
	    file://psplash \
            git://github.com/hufan/web-demo-bb;protocol=https;branch=web_server"
			
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}/"
S_1 = "${WORKDIR}/git"

do_compile () {
 make
}

do_package_qa () {
  echo "----" 
}

do_install () {
      install -d ${D}/usr/share/myir/
      install -d ${D}/usr/share/myir/www/
      install -d ${D}/lib/
      install -d ${D}/usr/bin/
	  
      cp -S ${S}/*.so* ${D}/lib/
      cp -r ${S_1}/web_server/* ${D}/usr/share/myir/www/
      install -m 0755 ${S_1}/board_cfg.json ${D}/usr/share/myir/
      install -m 0755 ${S_1}/mxde.xml ${D}/usr/share/myir/
      install -m 0755 ${S_1}/settings.ini ${D}/usr/share/myir/
      install -m 0755 ${S}/psplash ${D}/usr/bin/
}

FILES_${PN} = "/home/myir/ \
	       /usr/share/myir/ \
	       /usr/share/myir/www/ \
	       /usr/share/myir/www/* \
	       /usr/share/myir/*/* \
	       /lib/ \
	       /usr/bin/ \
             "

TARGET_CC_ARCH += "${LDFLAGS}"

