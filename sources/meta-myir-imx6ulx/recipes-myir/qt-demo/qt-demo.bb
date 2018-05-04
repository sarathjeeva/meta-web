DESCRIPTION = "qt app"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"


SRCREV = "de2c45867af61f77455bc81585e1319e1b73d717"
SRC_URI = "git://github.com/hufan/web-demo;protocol=https;branch=master"

LIC_FILES_CHKSUM = "file://settings.ini;md5=b2e121f7083d25452d0f7168eb7196f9"

S = "${WORKDIR}/git"

do_install () {
      install -d ${D}/usr/share/myir/
      install -d ${D}/usr/share/applications/
      install -d ${D}/usr/share/pixmaps/
      install -d ${D}/usr/lib/fonts/
      install -d ${D}/lib/

      cp -r  ${S}/applications/*  ${D}/usr/share/applications/
      cp -r  ${S}/pixmaps/*  ${D}/usr/share/pinxmaps/
      install -m 0755 ${S}/msyh.ttc ${D}/usr/lib/fonts/
}

LES_${PN} = "/home/myir/ \
	     /usr/share/myir/ \
	     /usr/lib/fonts/ \
	     /usr/share//applications*/* \
	     /usr/share/pixmaps/*/* \
	     /lib/ \
             "

