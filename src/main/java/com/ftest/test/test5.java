package com.ftest.test;

import scala.util.parsing.json.JSON;

import java.util.Arrays;

public class test5 {
    public static void main(String[] args) {
        String code="RUB6SBCA\n" +
                "EBB7KQ2P\n" +
                "TMLKBETU\n" +
                "EVS2QQFY\n" +
                "4LEDSANQ\n" +
                "LHJ23BCQ\n" +
                "BUW826RJ\n" +
                "RX7W3ZUC\n" +
                "E5WBFTUN\n" +
                "MN8UUKUH\n" +
                "NQHA6SAR\n" +
                "KKZ8NBDQ\n" +
                "F5JMK97W\n" +
                "FVFTZEBY\n" +
                "74D4ZBWW\n" +
                "4JK34JCP\n" +
                "F2JMYLGR\n" +
                "2V3RNY86\n" +
                "C6QX394M\n" +
                "A4VPUMMU\n" +
                "AFECAJGK\n" +
                "A76VZC26\n" +
                "WGFQ5HPF\n" +
                "786SZHD4\n" +
                "3ZNPV329\n" +
                "FE47NZ24\n" +
                "BVH8SENA\n" +
                "CWFR3Y59\n" +
                "CET2B5Q2\n" +
                "BZKFKMK5\n" +
                "JPYH6QZJ\n" +
                "DCMBDWDC\n" +
                "K6RX9E9Y\n" +
                "XPST5MD4\n" +
                "BMM4S8MN\n" +
                "99VRWVN6\n" +
                "2ZA8QS5J\n" +
                "6Y6659QM\n" +
                "TZL44HJS\n" +
                "7LLF2BQ4\n" +
                "GKFFNPYT\n" +
                "L8XCUQJ9\n" +
                "SS9BK6G4\n" +
                "TWF3AAAF\n" +
                "5S6TWX8B\n" +
                "6K5C9BCV\n" +
                "4Z8NQJLZ\n" +
                "7UNXC4DC\n" +
                "SFSB9UN7\n" +
                "QEWR9TG7\n" +
                "3L2ECTDM\n" +
                "4XA3RLXP\n" +
                "8L58ZKRH\n" +
                "ZM3KUBMZ\n" +
                "R3L4FPQ4\n" +
                "QD3JLGAU\n" +
                "YZM3AA6Y\n" +
                "4L76PHRV\n" +
                "DAKVFN2K\n" +
                "D2X6T9GD\n" +
                "UAVMPP6U\n" +
                "N8DDF8QY\n" +
                "6XU2MMPG\n" +
                "VNVB3QNQ\n" +
                "2AP92DVF\n" +
                "6GBNQWXV\n" +
                "BXRWZUSA\n" +
                "HUQMPX3U\n" +
                "PB3RM5RA\n" +
                "PFVLQBCZ\n" +
                "FUFRQ359\n" +
                "CA5VSPQ8\n" +
                "4K9NET7F\n" +
                "W257VJNE\n" +
                "4HCU4PFV\n" +
                "753HQESK\n" +
                "Q6FTKQ89\n" +
                "GJ3XBM48\n" +
                "DDKC5LJ2\n" +
                "QL4VLKMC\n" +
                "LRSHSYCQ\n" +
                "HULSN3HW\n" +
                "ZZJDJ9XV\n" +
                "JBWTQM4K\n" +
                "XAN4UQYU\n" +
                "2P7SLBDF\n" +
                "8YALTDKJ\n" +
                "D259WJAW\n" +
                "5TA7BKQ7\n" +
                "4MXKTFPC\n" +
                "8B6R3J6S\n" +
                "RJ4K3DE7\n" +
                "94JYA9F6\n" +
                "NDUZ3H4W\n" +
                "LD36YBPB\n" +
                "7L35A4C4\n" +
                "YUT5L7JE\n" +
                "79C55W3Q\n" +
                "5S4SGRXA\n" +
                "Z9Y3WNGF\n" +
                "JYL2Z5YZ\n" +
                "934XEQTJ\n" +
                "QGW3YW5G\n" +
                "G3TMHCUM\n" +
                "7R3XEYTX\n" +
                "DSPFCJRH\n" +
                "E5VG97X7\n" +
                "QDUL8D7P\n" +
                "62HZ59FU\n" +
                "3ZF7ZZQS\n" +
                "NEJRWDVP\n" +
                "FGBRXY86\n" +
                "LBDD58A2\n" +
                "NFKD6M2C\n" +
                "MYDA52WR\n" +
                "FD9GM7E2\n" +
                "VQZL4DRW\n" +
                "LY9GYR8P\n" +
                "T7D3JUQF\n" +
                "UU2GL6DJ\n" +
                "9PNG2Z9U\n" +
                "SH6MZSMN\n" +
                "PE4GQCYB\n" +
                "4PZX2VB3\n" +
                "VVF4UK2K\n" +
                "TAQMPC9W\n" +
                "6LZNW85Q\n" +
                "TQUFSNH3\n" +
                "8PA5K24X\n" +
                "TNQXBAK7\n" +
                "8LFZWS8V\n" +
                "Z3JDBUMJ\n" +
                "Y3SLR26F\n" +
                "HYMERMGW\n" +
                "ZKTJA7VE\n" +
                "85MHY52S\n" +
                "9AQ66TWA\n" +
                "C5XAWGL2\n" +
                "PYDBYW6U\n" +
                "LE8HV8ZW\n" +
                "4AZEXVUG\n" +
                "HC4N3Y8S\n" +
                "54B93W6F\n" +
                "GERA8ZRX\n" +
                "JGZQPBUX\n" +
                "76PFCS6W\n" +
                "CRQVUPNE\n" +
                "X7796Q6B\n" +
                "3NDZNW74\n" +
                "RE2MGBFG\n" +
                "DK75PUDK\n" +
                "5CTYRQFK\n" +
                "8H8AVXCW\n" +
                "UXX57GTA\n" +
                "Q2PBVQ92\n" +
                "Q69YR6DR\n" +
                "2Z7U9LL2\n" +
                "7ERNMN8N\n" +
                "MEZ4MH45\n" +
                "CBSFL8SU\n" +
                "3V5YDKYP\n" +
                "DX46K6S3\n" +
                "DZ3CEM86\n" +
                "AQQWANRZ\n" +
                "LY8NT9PU\n" +
                "DL7D2MD2\n" +
                "D9EQCK2B\n" +
                "3QGP9WYP\n" +
                "PFGNFD4R\n" +
                "354BHQCH\n" +
                "9UUFBQ85\n" +
                "LGTQBUAK\n" +
                "VD2ZNKBY\n" +
                "ZYXA8GJY\n" +
                "ESG9FQMJ\n" +
                "7CAUSJVV\n" +
                "AJZ9QFER\n" +
                "5HLBKBQ5\n" +
                "6EDRZ5BG\n" +
                "569NHCQ7\n" +
                "GS2WFPRV\n" +
                "BZ3BCLGS\n" +
                "4V3KBG75\n" +
                "BHUB9DAV\n" +
                "LFHZ3XZP\n" +
                "H2TU2JFW\n" +
                "47KWLF78\n" +
                "9JZ76L6Q\n" +
                "MYY4A8BR\n" +
                "7XVT9MUT\n" +
                "F95DMUNF\n" +
                "PAVGBX3F\n" +
                "BTHV43VJ\n" +
                "E3E84R84\n" +
                "R38E5P55\n" +
                "9DEWHXFD\n" +
                "MNZ7NJQZ\n" +
                "SRD63MJG\n" +
                "MPC4455V\n" +
                "CWAN982W\n" +
                "GX4CK94F\n" +
                "ZWU3PJ5D\n" +
                "VU4MSAWG\n" +
                "BNZ86TQT\n" +
                "UJJM3UKD\n" +
                "BTTDX9D9\n" +
                "NKD73EB3\n" +
                "9K72KXFY\n" +
                "WC73YZ34\n" +
                "FCNF8Z76\n" +
                "QYMQVFMF\n" +
                "LU3VSKZU\n" +
                "6TJJGL4W\n" +
                "SY8XYGZQ\n" +
                "FEVYNDV6\n" +
                "JHZ59JSQ\n" +
                "L48PMU4V\n" +
                "W3HMUEX7\n" +
                "3TEV6SKG\n" +
                "MM478V5Z\n" +
                "FFBFNPKU\n" +
                "VAFAUEDH\n" +
                "RRQ5CTZG\n" +
                "VZJJVBLB\n" +
                "WFEJN2ZC\n" +
                "YY6MGLDR\n" +
                "H74TLYRA\n" +
                "8CMPACEF\n" +
                "H5YTNKAR\n" +
                "UQE4RLLG\n" +
                "EHXFE6WJ\n" +
                "2ZKWKCCH\n" +
                "GL2XFBR7\n" +
                "MNGY98AK\n" +
                "NRL79F6V\n" +
                "CX4NLR2B\n" +
                "3A9SWKVL\n" +
                "ZA443YHL\n" +
                "ESPVDE7N\n" +
                "VYB7XUFU\n" +
                "XN76JFDK\n" +
                "5NAMLFMG\n" +
                "D6J6GLEV\n" +
                "3SXWMPUK\n" +
                "FL4WQ3TK\n" +
                "57VKYF6C\n" +
                "ERY9ME9S\n" +
                "3HF7CXZL\n" +
                "N25FKEYW\n" +
                "FZKPVJLX\n" +
                "QFU2XPQJ\n" +
                "THQ6CGLW\n" +
                "KGJDL9L9\n" +
                "3X6CH2AP\n" +
                "W6X2MK9R\n" +
                "VHYKKZ95\n" +
                "WU55TGTR\n" +
                "HWUJLSWE\n" +
                "K3VMSN7L\n" +
                "HMHWDPXK\n" +
                "5T6L4KU7\n" +
                "FSSMKXJM\n" +
                "RV79WKUX\n" +
                "78YCJD6T\n" +
                "MPRZX3SW\n" +
                "LRRYJZQ4\n" +
                "UYUVHK64\n" +
                "65VWYQP9\n" +
                "LUL7BDSG\n" +
                "PJY3HKRF\n" +
                "PN9SUGP2\n" +
                "LFWNDQ55\n" +
                "E56E3FZE\n" +
                "MFE236EL\n" +
                "8JLC7PWP\n" +
                "AH2EN5GB\n" +
                "STFQMSDJ\n" +
                "PC3TAT4B\n" +
                "5MFLD449\n" +
                "VR6SLWD4\n" +
                "2QJLD3GK\n" +
                "VBMJS4KU\n" +
                "M3GZ7A2W\n" +
                "CXKPKEKV\n" +
                "YFJDJN92\n" +
                "ZC5NW3T2\n" +
                "AENLJM3W\n" +
                "4LVBSVHJ\n" +
                "U22Y4KTE\n" +
                "QYB465PU\n" +
                "KGC5JPPQ\n" +
                "Z9NZWQTX\n" +
                "DD7237RL\n" +
                "WZ3M9T2Y\n" +
                "NPAEJKLY\n" +
                "J69W4SPA\n" +
                "X5S2EE63\n" +
                "5PDEQSPU\n" +
                "JLEBJAW2\n" +
                "8QW5E4CK\n" +
                "6CMB6MH9\n" +
                "6UAURBUT\n" +
                "9ZKDKFMY\n" +
                "PG5ATWMJ\n" +
                "NKHJEDNR\n" +
                "K5WBRBWG\n" +
                "CB2Y9EZE\n" +
                "KR8Q7N3L\n" +
                "K34UZKEC\n" +
                "DWSCR4H4\n" +
                "EBWWSVDZ\n" +
                "7BN66F6L\n" +
                "9GVQ3RLF\n" +
                "GASJKVQF\n" +
                "GAUGSJK2\n" +
                "YZLBKW98\n" +
                "HHW5K57X\n" +
                "9WAT9DUP\n" +
                "RWD657F3\n" +
                "QLMALTXZ\n" +
                "6H7D5RDH\n" +
                "F4VEQY75\n" +
                "VQ7ECMEM\n" +
                "UQF3N537\n" +
                "S9W898FW\n" +
                "BE858SC2\n" +
                "VBSG8C3R\n" +
                "APQPUPN9\n" +
                "NBYGC8CQ\n" +
                "Q229VPEG\n" +
                "QT39242V\n" +
                "JH7383AD\n" +
                "MPHTMR2D\n" +
                "T5RARTJU\n" +
                "SBA25YLL\n" +
                "7S52E9AF\n" +
                "ZDX9KS7E\n" +
                "RXYAYPSC\n" +
                "VBVAECBS\n" +
                "F962D3Z3\n" +
                "8LCFCKVK\n" +
                "YYGBM8PL\n" +
                "5EXQTJ9X\n" +
                "XBQPERY3\n" +
                "AL2GC6KB\n" +
                "WHKTCLBL\n" +
                "XLAYGBRV\n" +
                "NCGP4STQ\n" +
                "5AWS4SDG\n" +
                "ZDVQQSB3\n" +
                "WLTZGR97\n" +
                "3MHL7SQL\n" +
                "FD3LX8R8\n" +
                "H9SEPMHB\n" +
                "8UPFN7DD\n" +
                "QBL856SL\n" +
                "R6S4VFG4\n" +
                "DME4ZT59\n" +
                "374CT8FL\n" +
                "QMVD5KV4\n" +
                "NFCSZNTG\n" +
                "KVGB4X83\n" +
                "FLHBTUE4\n" +
                "9JN3NCP9\n" +
                "7NNKJQPQ\n" +
                "U95BEQ4Y\n" +
                "EZZD5T3U\n" +
                "K44YAMV6\n" +
                "9QD6T8UL\n" +
                "6B83U7Y8\n" +
                "2B567FN8\n" +
                "ZZ824KPU\n" +
                "LAKAHWVU\n" +
                "ZRRGCKRQ\n" +
                "ECGVNDDU\n" +
                "3R288HLE\n" +
                "MRJSNAVP\n" +
                "FLSWJU6F\n" +
                "JE575JH6\n" +
                "9U93JDL4\n" +
                "HXQH8R5B\n" +
                "YPZTDQFA\n" +
                "TT6JNEJ9\n" +
                "Q2SQKA7H\n" +
                "6TWEPFQB\n" +
                "CRCPH2S2\n" +
                "3SH4AT9Q\n" +
                "9Z53AJEQ\n" +
                "YJZRFQKD\n" +
                "K7FXTKXE\n";
        String[] split = code.split("\n");
        Arrays.stream(split).forEach(
                it->{
                    System.out.println("\'"+it+"\'"+",");
                }
        );
        System.out.println(split.length);
    }
}
