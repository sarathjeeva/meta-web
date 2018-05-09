DESCRIPTION = "qt app"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"


LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "cd8a35c815b5a6f728423a295edbfee9fb60bc58"

SRC_URI = " file://mxapp \ 
	file://mxbackend \ 
	file://mxcan \ 
	file://mxinfo \ 
	file://mxled \ 
	file://mxnet \ 
	file://mxrs485 \ 
	file://mxserial \ 
	file://mxsupport \ 
	file://mxtaskmanager \ 
	git://github.com/hufan/web-demo-bb;protocol=https;branch=qt-app \
    "

S = "${WORKDIR}/"
S_G = "${WORKDIR}/git"

do_package_qa () {
  echo "----"
}

do_install () {
      install -d ${D}/usr/share/myir/
      install -d ${D}/usr/share/applications/
      install -d ${D}/usr/share/pixmaps/
      install -d ${D}/usr/lib/fonts/
      install -d ${D}/home/myir/

	  cp -r ${S_G}/applications/* ${D}/usr/share/applications/
	  cp -r ${S_G}/pixmaps/* ${D}/usr/share/pixmaps/
	  cp -r ${S_G}/msyh.ttc ${D}/usr/lib/fonts/
      install -m 0755 ${S}/mxapp ${D}/home/myir/
      install -m 0755 ${S}/mxbackend ${D}/home/myir/
      install -m 0755 ${S}/mxcan ${D}/home/myir/
      install -m 0755 ${S}/mxinfo ${D}/home/myir/
      install -m 0755 ${S}/mxled ${D}/home/myir/
      install -m 0755 ${S}/mxnet ${D}/home/myir/
      install -m 0755 ${S}/mxrs485 ${D}/home/myir/
      install -m 0755 ${S}/mxserial ${D}/home/myir/
      install -m 0755 ${S}/mxsupport ${D}/home/myir/
      install -m 0755 ${S}/mxtaskmanager ${D}/home/myir/
}

FILES_${PN} = "/home/myir/ \
	     /usr/share/myir/ \
	     /usr/lib/fonts/ \
	     /usr/share/applications/ \
	     /usr/share/pixmaps/ \
             "

