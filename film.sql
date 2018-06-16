/*
 Navicat Premium Data Transfer

 Source Server         : root@localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : film

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 16/06/2018 20:08:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Actor
-- ----------------------------
DROP TABLE IF EXISTS `Actor`;
CREATE TABLE `Actor` (
  `PersonID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  `FilmID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  `Role` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`PersonID`,`FilmID`,`Role`) USING BTREE,
  KEY `FK_DY_YYXX_4` (`FilmID`),
  CONSTRAINT `FK_DY_YYXX_4` FOREIGN KEY (`FilmID`) REFERENCES `Film` (`FilmID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_YYXX_RW_3` FOREIGN KEY (`PersonID`) REFERENCES `Person` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Actor
-- ----------------------------
BEGIN;
INSERT INTO `Actor` VALUES ('4', '1', '汉·索罗');
INSERT INTO `Actor` VALUES ('5', '1', '琦拉');
INSERT INTO `Actor` VALUES ('6', '1', '托拜厄斯·贝克特');
INSERT INTO `Actor` VALUES ('7', '1', '兰多·卡瑞辛');
INSERT INTO `Actor` VALUES ('8', '1', '德赖登·沃斯');
INSERT INTO `Actor` VALUES ('87', '10', '梅根·利维');
INSERT INTO `Actor` VALUES ('88', '10', '安德鲁·迪恩');
INSERT INTO `Actor` VALUES ('89', '10', '鲍勃');
INSERT INTO `Actor` VALUES ('90', '10', '戈麦斯');
INSERT INTO `Actor` VALUES ('91', '10', '甘尼·马丁');
INSERT INTO `Actor` VALUES ('95', '11', '韦德·沃兹，帕西法尔');
INSERT INTO `Actor` VALUES ('96', '11', '萨曼莎·库克，阿尔忒弥斯');
INSERT INTO `Actor` VALUES ('97', '11', '诺兰，索伦托');
INSERT INTO `Actor` VALUES ('98', '11', '詹姆斯·哈利迪，阿诺克');
INSERT INTO `Actor` VALUES ('99', '11', 'Reb');
INSERT INTO `Actor` VALUES ('101', '12', '米尔德丽德');
INSERT INTO `Actor` VALUES ('102', '12', '狄克森');
INSERT INTO `Actor` VALUES ('103', '12', '安妮');
INSERT INTO `Actor` VALUES ('104', '12', '罗比');
INSERT INTO `Actor` VALUES ('6', '12', '威洛比');
INSERT INTO `Actor` VALUES ('10', '2', 'Lee Abbott');
INSERT INTO `Actor` VALUES ('13', '2', 'Evelyn Abbott');
INSERT INTO `Actor` VALUES ('14', '2', 'Regan Abbott');
INSERT INTO `Actor` VALUES ('15', '2', 'Marcus Abbott');
INSERT INTO `Actor` VALUES ('16', '2', 'Beau Abbott');
INSERT INTO `Actor` VALUES ('20', '3', '马克斯');
INSERT INTO `Actor` VALUES ('21', '3', '安妮');
INSERT INTO `Actor` VALUES ('21', '3', '提伯斯');
INSERT INTO `Actor` VALUES ('22', '3', '布鲁克斯');
INSERT INTO `Actor` VALUES ('23', '3', 'Sarah');
INSERT INTO `Actor` VALUES ('24', '3', 'Ryan');
INSERT INTO `Actor` VALUES ('31', '4', '托尼·史塔克');
INSERT INTO `Actor` VALUES ('32', '4', '托尔·奥丁森');
INSERT INTO `Actor` VALUES ('33', '4', '史蒂文·罗杰斯');
INSERT INTO `Actor` VALUES ('34', '4', '布鲁斯·班纳');
INSERT INTO `Actor` VALUES ('35', '4', '灭霸');
INSERT INTO `Actor` VALUES ('41', '5', '洛克');
INSERT INTO `Actor` VALUES ('42', '5', '伊娃');
INSERT INTO `Actor` VALUES ('43', '5', '卡西莫');
INSERT INTO `Actor` VALUES ('44', '5', '比安卡');
INSERT INTO `Actor` VALUES ('45', '5', '雷雷');
INSERT INTO `Actor` VALUES ('49', '6', '卡尔·马克思');
INSERT INTO `Actor` VALUES ('50', '6', '弗里德里希·恩格斯');
INSERT INTO `Actor` VALUES ('51', '6', '燕妮·冯·韦斯特伦·马克思');
INSERT INTO `Actor` VALUES ('52', '6', '皮埃尔-约瑟夫·普鲁东');
INSERT INTO `Actor` VALUES ('53', '6', '玛丽·伯恩斯');
INSERT INTO `Actor` VALUES ('59', '7', '戴维斯');
INSERT INTO `Actor` VALUES ('60', '7', '凯特博士');
INSERT INTO `Actor` VALUES ('61', '7', '拉塞尔');
INSERT INTO `Actor` VALUES ('62', '7', '克莱尔');
INSERT INTO `Actor` VALUES ('63', '7', '布莱特');
INSERT INTO `Actor` VALUES ('70', '8', '巴霍巴利');
INSERT INTO `Actor` VALUES ('71', '8', '巴拉拉德夫德斯');
INSERT INTO `Actor` VALUES ('72', '8', '提婆犀那');
INSERT INTO `Actor` VALUES ('73', '8', 'Avanthika');
INSERT INTO `Actor` VALUES ('74', '8', '卡塔帕');
INSERT INTO `Actor` VALUES ('78', '9', 'Luta');
INSERT INTO `Actor` VALUES ('79', '9', 'Maribel, Troll Kids');
INSERT INTO `Actor` VALUES ('80', '9', 'Alfida');
INSERT INTO `Actor` VALUES ('81', '9', 'Kai');
INSERT INTO `Actor` VALUES ('82', '9', 'Rollan');
COMMIT;

-- ----------------------------
-- Table structure for Category
-- ----------------------------
DROP TABLE IF EXISTS `Category`;
CREATE TABLE `Category` (
  `DYLB_LB` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#必填字段；模糊查询；精确查询；#',
  `FilmID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  PRIMARY KEY (`DYLB_LB`,`FilmID`),
  KEY `FK_DY_DYLBXX_8` (`FilmID`),
  CONSTRAINT `FK_DYLBXX_DYLB_7` FOREIGN KEY (`DYLB_LB`) REFERENCES `CategoryList` (`DYLB_LB`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_DY_DYLBXX_8` FOREIGN KEY (`FilmID`) REFERENCES `Film` (`FilmID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Category
-- ----------------------------
BEGIN;
INSERT INTO `Category` VALUES ('冒险', '1');
INSERT INTO `Category` VALUES ('动作', '1');
INSERT INTO `Category` VALUES ('科幻', '1');
INSERT INTO `Category` VALUES ('传记', '10');
INSERT INTO `Category` VALUES ('剧情', '10');
INSERT INTO `Category` VALUES ('战争', '10');
INSERT INTO `Category` VALUES ('冒险', '11');
INSERT INTO `Category` VALUES ('动作', '11');
INSERT INTO `Category` VALUES ('科幻', '11');
INSERT INTO `Category` VALUES ('剧情', '12');
INSERT INTO `Category` VALUES ('犯罪', '12');
INSERT INTO `Category` VALUES ('恐怖', '2');
INSERT INTO `Category` VALUES ('惊悚', '2');
INSERT INTO `Category` VALUES ('喜剧', '3');
INSERT INTO `Category` VALUES ('悬疑', '3');
INSERT INTO `Category` VALUES ('犯罪', '3');
INSERT INTO `Category` VALUES ('冒险', '4');
INSERT INTO `Category` VALUES ('动作', '4');
INSERT INTO `Category` VALUES ('奇幻', '4');
INSERT INTO `Category` VALUES ('科幻', '4');
INSERT INTO `Category` VALUES ('剧情', '5');
INSERT INTO `Category` VALUES ('喜剧', '5');
INSERT INTO `Category` VALUES ('传记', '6');
INSERT INTO `Category` VALUES ('剧情', '6');
INSERT INTO `Category` VALUES ('历史', '6');
INSERT INTO `Category` VALUES ('冒险', '7');
INSERT INTO `Category` VALUES ('动作', '7');
INSERT INTO `Category` VALUES ('科幻', '7');
INSERT INTO `Category` VALUES ('剧情', '8');
INSERT INTO `Category` VALUES ('动作', '8');
INSERT INTO `Category` VALUES ('奇幻', '8');
INSERT INTO `Category` VALUES ('冒险', '9');
INSERT INTO `Category` VALUES ('动画', '9');
INSERT INTO `Category` VALUES ('家庭', '9');
COMMIT;

-- ----------------------------
-- Table structure for CategoryList
-- ----------------------------
DROP TABLE IF EXISTS `CategoryList`;
CREATE TABLE `CategoryList` (
  `DYLB_LB` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#必填字段；模糊查询；精确查询；#',
  PRIMARY KEY (`DYLB_LB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of CategoryList
-- ----------------------------
BEGIN;
INSERT INTO `CategoryList` VALUES ('传记');
INSERT INTO `CategoryList` VALUES ('冒险');
INSERT INTO `CategoryList` VALUES ('剧情');
INSERT INTO `CategoryList` VALUES ('动作');
INSERT INTO `CategoryList` VALUES ('动画');
INSERT INTO `CategoryList` VALUES ('历史');
INSERT INTO `CategoryList` VALUES ('喜剧');
INSERT INTO `CategoryList` VALUES ('奇幻');
INSERT INTO `CategoryList` VALUES ('家庭');
INSERT INTO `CategoryList` VALUES ('恐怖');
INSERT INTO `CategoryList` VALUES ('悬疑');
INSERT INTO `CategoryList` VALUES ('惊悚');
INSERT INTO `CategoryList` VALUES ('战争');
INSERT INTO `CategoryList` VALUES ('犯罪');
INSERT INTO `CategoryList` VALUES ('科幻');
COMMIT;

-- ----------------------------
-- Table structure for Director
-- ----------------------------
DROP TABLE IF EXISTS `Director`;
CREATE TABLE `Director` (
  `PersonID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  `FilmID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  PRIMARY KEY (`PersonID`,`FilmID`),
  KEY `FK_DY_DYXX_2` (`FilmID`),
  CONSTRAINT `FK_DYXX_RW_1` FOREIGN KEY (`PersonID`) REFERENCES `Person` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_DY_DYXX_2` FOREIGN KEY (`FilmID`) REFERENCES `Film` (`FilmID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Director
-- ----------------------------
BEGIN;
INSERT INTO `Director` VALUES ('8', '1');
INSERT INTO `Director` VALUES ('83', '10');
INSERT INTO `Director` VALUES ('92', '11');
INSERT INTO `Director` VALUES ('100', '12');
INSERT INTO `Director` VALUES ('10', '2');
INSERT INTO `Director` VALUES ('17', '3');
INSERT INTO `Director` VALUES ('18', '3');
INSERT INTO `Director` VALUES ('25', '4');
INSERT INTO `Director` VALUES ('26', '4');
INSERT INTO `Director` VALUES ('36', '5');
INSERT INTO `Director` VALUES ('46', '6');
INSERT INTO `Director` VALUES ('54', '7');
INSERT INTO `Director` VALUES ('64', '8');
INSERT INTO `Director` VALUES ('75', '9');
COMMIT;

-- ----------------------------
-- Table structure for Film
-- ----------------------------
DROP TABLE IF EXISTS `Film`;
CREATE TABLE `Film` (
  `FilmID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  `FirmID` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  `FilmName` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#必填字段；显示名称；模糊查询；精确查询；#',
  `FilmYear` varchar(4) COLLATE utf8_bin DEFAULT '',
  `FilmLength` varchar(50) COLLATE utf8_bin DEFAULT '',
  `FilmPlot` varchar(1024) COLLATE utf8_bin DEFAULT '',
  `IntID` int(10) NOT NULL,
  PRIMARY KEY (`FilmID`),
  KEY `FK_DY_CPGS_9` (`FirmID`),
  CONSTRAINT `FK_DY_CPGS_9` FOREIGN KEY (`FirmID`) REFERENCES `Firm` (`FirmID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Film
-- ----------------------------
BEGIN;
INSERT INTO `Film` VALUES ('1', '1', '游侠索罗：星球大战外传', '2018', '135', '经过在黑暗危险的罪犯地下社会中的重重冒险，韩·索罗遇见了他未来强大的副驾驶丘巴卡、以及臭名昭著的赌徒兰多·卡瑞辛，共同展开了一场星战传奇中最不“正统”的英雄历程。', 1);
INSERT INTO `Film` VALUES ('10', '9', '战犬瑞克斯', '2017', '116', '改编自真人真事，以伊拉克战争为背景，讲诉海军陆战队下士梅根·利维和她的军犬瑞克斯一起拯救了多人生命的故事。在经历生死与相互救赎后，一人一犬建立深厚情感的故事。 它在真实的背景下以一种特殊的方式升华了人与狗的情感。狗不再是宠物，而是以战友身份与人相处；它们不再生活在人类的庇护下，而是反过来，用自己的身躯保护人类。 该片以“军犬”这个新奇的角度还原伊拉克战争，首次全面展现军犬在战区排爆、救人的惊心动魄的画面，真实刻画了女兵梅根·利维与军犬瑞克斯在战场上紧张、勇猛的状态。', 10);
INSERT INTO `Film` VALUES ('11', '3', '头号玩家', '2018', '140', '故事发生在2045年，虚拟现实技术已经渗透到了人类生活的每一个角落。詹姆斯哈利迪（马克·里朗斯 Mark Rylance 饰）一手建造了名为“绿洲”的虚拟现实游戏世界，临终前，他宣布自己在游戏中设置了一个彩蛋，找到这枚彩蛋的人即可成为绿洲的继承人。要找到这枚彩蛋，必须先获得三把钥匙，而寻找钥匙的线索就隐藏在詹姆斯的过往之中。', 11);
INSERT INTO `Film` VALUES ('12', '10', '三块广告牌', '2017', '115', '米尔德雷德（弗兰西斯·麦克多蒙德 Frances McDormand 饰）的女儿在外出时惨遭奸杀，米尔德雷德和丈夫查理（约翰·哈克斯 John Hawkes 饰）之间的婚姻因此走到了尽头，如今，她同儿子罗比（卢卡斯·赫奇斯 Lucas Hedges饰）过着相依为命的生活。一晃眼几个月过去了，案件仍然没有告破预兆，而警方似乎早已经将注意力从案子上转移了开来。 \n　　被绝望和痛苦缠绕的米尔德雷德租下了高速公路边上的三块巨型广告牌，在上面控诉警方办案无能，并将矛头直接对准了警察局局长威洛比（伍迪·哈里森 Woody Harrelson 饰）。实际上，威洛比一直隐瞒着自己身患绝症命不久矣的事实。因为这三块广告牌，米尔德雷德和威洛比的生活发生了翻天覆地的变化。', 12);
INSERT INTO `Film` VALUES ('2', '2', '寂静之地', '2018', '90', '一个大规模的入侵行动发生，让地球几乎全灭，幸存的这一家人过着安静无声的生活，一发出声音就会被怪物抓走。《寂静之地》中的家庭必须时时保持安静，这一家人必须搞清楚哪些声音可以发出，哪些不行。', 2);
INSERT INTO `Film` VALUES ('3', '3', '游戏之夜', '2018', '100', '马克思(贝特曼饰)的兄弟布鲁克斯(钱德勒饰)筹划“谋杀”派对后却遭绑架，马克思、安妮(麦克亚当斯饰)以为这只是一场游戏，但显然他们已陷入困境。', 3);
INSERT INTO `Film` VALUES ('4', '4', '复仇者联盟3：无限战争', '2018', '150', '《复仇者联盟3：无限战争》是漫威电影宇宙10周年的历史性集结，将为影迷们带来史诗版的终极对决。面对灭霸突然发起的闪电袭击，复仇者联盟及其所有超级英雄盟友必须全力以赴，才能阻止他对全宇宙造成毁灭性的打击。', 4);
INSERT INTO `Film` VALUES ('5', '5', '完美陌生人', '2016', '97', '三对处于各个婚姻阶段的伴侣和一个宅男,七人聚在一起吃晚餐。女主人提议下拍板决定当夜所有人分享每一个电话、每一条短信、邮件的内容,由此许多秘密开始不再是秘密,他们之间的关系也开始发生波动。', 5);
INSERT INTO `Film` VALUES ('6', '6', '青年马克思', '2017', '118', '1843年，君主专制下的欧洲饥荒肆虐、经济萧条，处处危机四伏。英国的工业革命改变了世界秩序，创造出新的无产阶级。秉持博爱共产理念，工人组织陆续成立。两名德国青年，马克思与恩格斯，将颠覆这些组织的乌托邦思想，改造他们的斗争及全世界的未来', 6);
INSERT INTO `Film` VALUES ('7', '3', '狂暴巨兽', '2018', '107', '巨石强森饰演的灵长类动物学家一直与人类保持距离, 却跟极为聪明的银背大猩猩乔治有着深厚的感情。但是一次基因实验出错, 让这只温驯的大猩猩变成狂怒难驯的庞然巨兽。更可怕的是, 其他动物也发生了同样基因异变。他必须阻止这场全球性的灾难, 更重要是要拯救他的好友乔治。', 7);
INSERT INTO `Film` VALUES ('8', '7', '巴霍巴利王2：终结', '2017', '167', '同蛮族的大战以摩喜施末底的胜利而告终，根据战场上的表现，希瓦伽米太后（拉姆亚·克里希南饰）选择了养子阿玛兰德拉·巴霍巴利（帕拉巴斯饰）作为王国的王储。在加冕典礼之前太后交给巴霍巴利的最后一项任务是游历王国，体察臣民的疾苦，理解\'臣民的审判\'。同时，太后还竭尽全力满足自己的亲子巴拉拉德夫德斯（纳拉·达古巴提饰）的各种需求，希望能够克制他的贪婪，平衡兄弟的关系。', 8);
INSERT INTO `Film` VALUES ('9', '8', '冰雪女王3：火与冰', '2016', '90', '不断遇到麻烦可算是凯与格尔达这对姐弟的特点了，毕竟他们是在冰雪的国度被矮人们养大的。随着他们长大成人，等待他们的麻烦也升级了。这一次，格尔达与新认识的小伙伴罗兰去寻找传说中的许愿球，不想却召唤出封印在许愿球中的邪恶力量，这对姐弟是否能够逢凶化吉，还世界一个和平？', 9);
COMMIT;

-- ----------------------------
-- Table structure for Firm
-- ----------------------------
DROP TABLE IF EXISTS `Firm`;
CREATE TABLE `Firm` (
  `FirmID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  `FirmName` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#必填字段；显示名称；模糊查询；精确查询；#',
  `FirmCity` varchar(20) COLLATE utf8_bin DEFAULT '',
  `IntID` int(10) NOT NULL,
  PRIMARY KEY (`FirmID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Firm
-- ----------------------------
BEGIN;
INSERT INTO `Firm` VALUES ('1', '美国卢卡斯影业公司', '旧金山', 1);
INSERT INTO `Firm` VALUES ('10', '美国二十世纪福斯公司', '旧金山', 10);
INSERT INTO `Firm` VALUES ('2', '美国派拉蒙影片公司', '好莱坞', 2);
INSERT INTO `Firm` VALUES ('3', '华纳兄弟影片公司', '伯班克', 3);
INSERT INTO `Firm` VALUES ('4', '华特·迪士尼电影公司', '伯班克', 4);
INSERT INTO `Firm` VALUES ('5', '意大利美杜莎影业公司', '罗马', 5);
INSERT INTO `Firm` VALUES ('6', '法国安佳特电影公司', '巴黎', 6);
INSERT INTO `Firm` VALUES ('7', '印度阿卡媒体公司', '新德里', 7);
INSERT INTO `Firm` VALUES ('8', '俄罗斯威扎特动画公司', '莫斯科', 8);
INSERT INTO `Firm` VALUES ('9', '美国LD娱乐影片公司', '旧金山', 9);
COMMIT;

-- ----------------------------
-- Table structure for Person
-- ----------------------------
DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person` (
  `PersonID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  `PersonName` varchar(50) COLLATE utf8_bin DEFAULT '',
  `PersonBirth` varchar(50) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`PersonID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Person
-- ----------------------------
BEGIN;
INSERT INTO `Person` VALUES ('1', '乔恩·卡斯丹', '1979-09-30');
INSERT INTO `Person` VALUES ('10', '约翰·卡拉辛斯基', '1979-10-20');
INSERT INTO `Person` VALUES ('100', '马丁·麦克唐纳', '1970-03-26');
INSERT INTO `Person` VALUES ('101', '弗兰西斯·麦克多蒙德', '1957-06-23');
INSERT INTO `Person` VALUES ('102', '山姆·洛克威尔', '1968-11-05');
INSERT INTO `Person` VALUES ('103', '艾比·考尼什', '1982-08-07');
INSERT INTO `Person` VALUES ('104', '卢卡斯·赫奇斯', '1996-12-12');
INSERT INTO `Person` VALUES ('11', '斯科特·贝克', '1984-10-22');
INSERT INTO `Person` VALUES ('12', '布莱恩·伍兹', '1984-09-14');
INSERT INTO `Person` VALUES ('13', '艾米莉·布朗特', '1983-02-23');
INSERT INTO `Person` VALUES ('14', '米利森特·西蒙兹', '');
INSERT INTO `Person` VALUES ('15', '诺亚·尤佩', '2005-02-25');
INSERT INTO `Person` VALUES ('16', '凯德·伍德沃德', '');
INSERT INTO `Person` VALUES ('17', '约翰·弗朗西斯·戴利', '1985-07-20');
INSERT INTO `Person` VALUES ('18', '乔纳森·M·戈尔茨坦', '1968-09-02');
INSERT INTO `Person` VALUES ('19', '马克·佩雷斯', '');
INSERT INTO `Person` VALUES ('2', '劳伦斯·卡斯丹', '1949-01-14');
INSERT INTO `Person` VALUES ('20', '杰森·贝特曼', '1969-01-14');
INSERT INTO `Person` VALUES ('21', '瑞秋·麦克亚当斯', '1978-11-17');
INSERT INTO `Person` VALUES ('22', '凯尔·钱德勒', '1965-09-17');
INSERT INTO `Person` VALUES ('23', '莎朗·豪根', '1970-07-13');
INSERT INTO `Person` VALUES ('24', '比利·马格努森', '1985-04-20');
INSERT INTO `Person` VALUES ('25', '安东尼·罗素', '1970');
INSERT INTO `Person` VALUES ('26', '乔·罗素', '1971');
INSERT INTO `Person` VALUES ('27', '杰克·科比', '1917-08-28');
INSERT INTO `Person` VALUES ('28', '克里斯托弗·马库斯', '');
INSERT INTO `Person` VALUES ('29', '斯蒂芬·麦克菲利', '');
INSERT INTO `Person` VALUES ('3', '乔治·卢卡斯', '1944-05-14');
INSERT INTO `Person` VALUES ('30', '吉姆·斯特林', '');
INSERT INTO `Person` VALUES ('31', '小罗伯特·唐尼', '1965-04-04');
INSERT INTO `Person` VALUES ('32', '克里斯·海姆斯沃斯', '1983-08-11');
INSERT INTO `Person` VALUES ('33', '克里斯·埃文斯', '1981-06-13');
INSERT INTO `Person` VALUES ('34', '马克·鲁弗洛', '1967-11-22');
INSERT INTO `Person` VALUES ('35', '乔什·布洛林', '1968-02-12');
INSERT INTO `Person` VALUES ('36', '保罗·格诺维塞', '1966-08-20');
INSERT INTO `Person` VALUES ('37', '菲利波·博洛尼亚', '');
INSERT INTO `Person` VALUES ('38', '保罗·克斯泰拉', '');
INSERT INTO `Person` VALUES ('39', '宝拉·马米妮', '');
INSERT INTO `Person` VALUES ('4', '阿尔登·埃伦瑞奇', '1989-11-22');
INSERT INTO `Person` VALUES ('40', '罗兰多·拉维洛', '');
INSERT INTO `Person` VALUES ('41', '马可·贾利尼', '1963-04-04');
INSERT INTO `Person` VALUES ('42', '卡夏·斯穆特尼亚克', '1979-08-13');
INSERT INTO `Person` VALUES ('43', '爱德华多·莱奥', '1972-04-21');
INSERT INTO `Person` VALUES ('44', '阿尔巴·罗尔瓦赫尔', '1979-02-27');
INSERT INTO `Person` VALUES ('45', '瓦莱里奥·马斯坦德雷亚', '1972-02-14');
INSERT INTO `Person` VALUES ('46', '哈乌·佩克', '1953-09-09');
INSERT INTO `Person` VALUES ('47', '帕斯卡尔·博尼策尔', '1946-02-01');
INSERT INTO `Person` VALUES ('48', '皮埃尔·霍奇森', '');
INSERT INTO `Person` VALUES ('49', '奥古斯特·迪尔', '1976-01-04');
INSERT INTO `Person` VALUES ('5', '艾米莉亚·克拉克', '1986-10-23');
INSERT INTO `Person` VALUES ('50', '史特凡·柯纳斯克', '1980-02-28');
INSERT INTO `Person` VALUES ('51', '薇姬·克里普斯', '1983-10-04');
INSERT INTO `Person` VALUES ('52', '奥利维埃·古尔梅', '1963-07-22');
INSERT INTO `Person` VALUES ('53', '汉娜·斯蒂尔', '');
INSERT INTO `Person` VALUES ('54', '布拉德·佩顿', '1980-09-16');
INSERT INTO `Person` VALUES ('55', '瑞安·恩格尔', '1979-01-20');
INSERT INTO `Person` VALUES ('56', '卡尔顿·库斯', '1959-03-22');
INSERT INTO `Person` VALUES ('57', '莱恩·康道尔', '');
INSERT INTO `Person` VALUES ('58', '亚当·希泰凯尔', '1978-01-09');
INSERT INTO `Person` VALUES ('59', '道恩·强森', '1972-05-02');
INSERT INTO `Person` VALUES ('6', '伍迪·哈里森', '1961-07-23');
INSERT INTO `Person` VALUES ('60', '娜奥米·哈里斯', '1976-09-06');
INSERT INTO `Person` VALUES ('61', '杰弗里·迪恩·摩根', '1966-04-22');
INSERT INTO `Person` VALUES ('62', '玛琳·阿克曼', '1978-05-12');
INSERT INTO `Person` VALUES ('63', '杰克·莱西', '');
INSERT INTO `Person` VALUES ('64', 'S·S·拉贾穆里', '1973-10-10');
INSERT INTO `Person` VALUES ('65', '曼孔布·戈帕拉克里希南', '');
INSERT INTO `Person` VALUES ('66', '马德汉·卡尔基', '');
INSERT INTO `Person` VALUES ('67', 'C·H·维杰·库马尔', '');
INSERT INTO `Person` VALUES ('68', '马努杰·芒塔希尔', '1976-02-27');
INSERT INTO `Person` VALUES ('69', '维杰耶德拉·普拉萨德', '');
INSERT INTO `Person` VALUES ('7', '唐纳德·格洛弗', '1983-09-25');
INSERT INTO `Person` VALUES ('70', '帕拉巴斯', '1979-10-23');
INSERT INTO `Person` VALUES ('71', '拉纳·达格巴提', '1984-12-14');
INSERT INTO `Person` VALUES ('72', '安努舒卡·谢蒂', '1981-11-07');
INSERT INTO `Person` VALUES ('73', '特曼娜·芭蒂亚', '1989-12-21');
INSERT INTO `Person` VALUES ('74', '萨伯拉杰', '1977-02-27');
INSERT INTO `Person` VALUES ('75', '阿列克谢·特斯蒂斯林', '');
INSERT INTO `Person` VALUES ('76', '安德烈·科林考夫', '');
INSERT INTO `Person` VALUES ('77', '罗伯特·伦塞', '');
INSERT INTO `Person` VALUES ('78', '迪·布拉雷·贝克尔', '1962-08-31');
INSERT INTO `Person` VALUES ('79', '洛瑞·加纳', '');
INSERT INTO `Person` VALUES ('8', '保罗·贝坦尼', '1971-05-27');
INSERT INTO `Person` VALUES ('80', 'Devin Bailey Griffin', '');
INSERT INTO `Person` VALUES ('81', '杰森·格里菲斯', '1980-11-29');
INSERT INTO `Person` VALUES ('82', '格林汉姆·豪斯蒂德', '');
INSERT INTO `Person` VALUES ('83', '加芙列拉·考珀斯维特', '');
INSERT INTO `Person` VALUES ('84', '帕梅拉·格雷', '');
INSERT INTO `Person` VALUES ('85', '安妮·玛莫罗', '1973-07-10');
INSERT INTO `Person` VALUES ('86', '蒂姆·洛夫斯特特', '');
INSERT INTO `Person` VALUES ('87', '凯特·玛拉', '1983-02-27');
INSERT INTO `Person` VALUES ('88', '汤姆·费尔顿', '1987-09-22');
INSERT INTO `Person` VALUES ('89', '布莱德利·惠特福德', '1959-10-10');
INSERT INTO `Person` VALUES ('9', '朗·霍华德', '1954-03-01');
INSERT INTO `Person` VALUES ('90', '杰拉丁妮·詹姆斯', '1950-07-06');
INSERT INTO `Person` VALUES ('91', '科曼', '1972-03-13');
INSERT INTO `Person` VALUES ('92', '史蒂文·斯皮尔伯格', '1946-12-18');
INSERT INTO `Person` VALUES ('93', '扎克·佩恩', '1968-09-01');
INSERT INTO `Person` VALUES ('94', '恩斯特·克莱恩', '');
INSERT INTO `Person` VALUES ('95', '泰伊·谢里丹', '1996-11-11');
INSERT INTO `Person` VALUES ('96', '奥利维亚·库克', '1993-12-27');
INSERT INTO `Person` VALUES ('97', '本·门德尔森', '1969-04-03');
INSERT INTO `Person` VALUES ('98', '马克·里朗斯', '1960-01-18');
INSERT INTO `Person` VALUES ('99', '丽娜·维特', '1984-05-17');
COMMIT;

-- ----------------------------
-- Table structure for Voice
-- ----------------------------
DROP TABLE IF EXISTS `Voice`;
CREATE TABLE `Voice` (
  `FilmID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  `PersonID` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '#主键自动添加；必填字段；#',
  PRIMARY KEY (`FilmID`,`PersonID`),
  KEY `FK_RW_PBXX_6` (`PersonID`),
  CONSTRAINT `FK_DY_PBXX_5` FOREIGN KEY (`FilmID`) REFERENCES `Film` (`FilmID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_RW_PBXX_6` FOREIGN KEY (`PersonID`) REFERENCES `Person` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Voice
-- ----------------------------
BEGIN;
INSERT INTO `Voice` VALUES ('1', '1');
INSERT INTO `Voice` VALUES ('2', '10');
INSERT INTO `Voice` VALUES ('12', '100');
INSERT INTO `Voice` VALUES ('2', '11');
INSERT INTO `Voice` VALUES ('2', '12');
INSERT INTO `Voice` VALUES ('3', '19');
INSERT INTO `Voice` VALUES ('1', '2');
INSERT INTO `Voice` VALUES ('4', '27');
INSERT INTO `Voice` VALUES ('4', '28');
INSERT INTO `Voice` VALUES ('4', '29');
INSERT INTO `Voice` VALUES ('1', '3');
INSERT INTO `Voice` VALUES ('4', '30');
INSERT INTO `Voice` VALUES ('5', '36');
INSERT INTO `Voice` VALUES ('5', '37');
INSERT INTO `Voice` VALUES ('5', '38');
INSERT INTO `Voice` VALUES ('5', '39');
INSERT INTO `Voice` VALUES ('5', '40');
INSERT INTO `Voice` VALUES ('6', '46');
INSERT INTO `Voice` VALUES ('6', '47');
INSERT INTO `Voice` VALUES ('6', '48');
INSERT INTO `Voice` VALUES ('7', '55');
INSERT INTO `Voice` VALUES ('7', '56');
INSERT INTO `Voice` VALUES ('7', '57');
INSERT INTO `Voice` VALUES ('7', '58');
INSERT INTO `Voice` VALUES ('8', '64');
INSERT INTO `Voice` VALUES ('8', '65');
INSERT INTO `Voice` VALUES ('8', '66');
INSERT INTO `Voice` VALUES ('8', '67');
INSERT INTO `Voice` VALUES ('8', '68');
INSERT INTO `Voice` VALUES ('8', '69');
INSERT INTO `Voice` VALUES ('9', '76');
INSERT INTO `Voice` VALUES ('9', '77');
INSERT INTO `Voice` VALUES ('10', '84');
INSERT INTO `Voice` VALUES ('10', '85');
INSERT INTO `Voice` VALUES ('10', '86');
INSERT INTO `Voice` VALUES ('11', '93');
INSERT INTO `Voice` VALUES ('11', '94');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
