DESCRIPTION = "web dem"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"

PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-dev ${PN}-staticdev ${PN}-locale"
PACKAGES_DYNAMIC = "${PN}-locale-*"


SRCREV = "3b6ea922496d60a60d49c61c44df15523adac8e7"
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

      if [ ${MACHINE} = "myd-y6ul14x14" ]
      then
      install -m 0755 ${S_1}/board_cfg_mydy6ul.json ${D}/usr/share/myir/board_cfg.json
      elif [ ${MACHINE} = "myd-y6ull14x14" ]
      then
      install -m 0755 ${S_1}/board_cfg_mydy6ull.json ${D}/usr/share/myir/board_cfg.json
      elif [ ${MACHINE} = "mys6ul14x14" ]
      then
      install -m 0755 ${S_1}/board_cfg_mysy6ul.json ${D}/usr/share/myir/board_cfg.json
      elif [ ${MACHINE} = "mys6ull14x14" ]
      then
      install -m 0755 ${S_1}/board_cfg_mysy6ull.json ${D}/usr/share/myir/board_cfg.json
      fi

      install -m 0755 ${S_1}/mxde.xml ${D}/usr/share/myir/
      install -m 0755 ${S_1}/settings.ini ${D}/usr/share/myir/
      install -m 0755 ${S}/psplash ${D}/usr/bin/
      install -m 755 ${S_1}/init_boardcfg.py ${D}/usr/share/myir/
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

