DESCRIPTION = "qt app"
DEPENDS = "zlib glibc ncurses "
SECTION = "libs"
LICENSE = "MIT"
PV = "3"
PR = "r0"


LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

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
          "

S = "${WORKDIR}/"
S_N = "${WORKDIR}/"

do_install () {
      install -d ${D}/usr/share/myir/
      install -d ${D}/usr/share/applications/
      install -d ${D}/usr/share/pixmaps/
      install -d ${D}/usr/lib/fonts/
      install -d ${D}/home/myir/

      install -m 0755 ${S_N}/mxapp ${D}/home/myir/
      install -m 0755 ${S_N}/mxcan ${D}/home/myir/
      install -m 0755 ${S_N}/mxinfo ${D}/home/myir/
      install -m 0755 ${S_N}/mxled ${D}/home/myir/
      install -m 0755 ${S_N}/mxnet ${D}/home/myir/
      install -m 0755 ${S_N}/mxrs485 ${D}/home/myir/
      install -m 0755 ${S_N}/mxserial ${D}/home/myir/
      install -m 0755 ${S_N}/mxsupport ${D}/home/myir/
      install -m 0755 ${S_N}/mxtaskmanager ${D}/home/myir/
}

FILES_${PN} = "/home/myir/ \
	     /usr/share/myir/ \
	     /usr/lib/fonts/ \
	     /usr/share/applications/ \
	     /usr/share/pixmaps/ \
             "

