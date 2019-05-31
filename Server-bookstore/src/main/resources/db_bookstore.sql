/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : db_bookstore

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-29 12:20:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `author`
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(28) NOT NULL,
  `author_intro` mediumtext,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('9', '路遥', '路遥（1949年12月3日—1992年11月17日），本名王卫国，出生于陕北榆林清涧县，中国当代作家，代表作有长篇小说《平凡的世界》、《人生》等。曾任中国作家协会陕西分会党组成员、副主席。');
INSERT INTO `author` VALUES ('10', '余华', '余华，1960年4月3日生于浙江杭州，当代作家。中国作家协会第九届全国委员会委员。');
INSERT INTO `author` VALUES ('11', '莫言', '莫言，原名管谟业，1955年2月17日出生于山东省高密市东北乡文化发展区大栏平安村，中国作家协会副主席、2012年诺贝尔文学奖获得者，亦是第一个获得诺贝尔文学奖的中国籍作家。');
INSERT INTO `author` VALUES ('12', '金庸', '金庸（1924年3月10日—2018年10月30日），本名查良镛，生于浙江省嘉兴市海宁市，1948年移居香港。当代武侠小说作家、新闻学家、企业家、政治评论家、社会活动家，“香港四大才子”之一。');
INSERT INTO `author` VALUES ('13', '贾平凹', '贾平凹，男，汉族，1953年2月21日生于陕西省商洛市丹凤县棣花镇，中共党员，毕业于西北大学中文系，当代作家，十三届全国人大代表。');
INSERT INTO `author` VALUES ('14', '沈从文', '沈从文（1902－1988），男，原名沈岳焕，笔名休芸芸、甲辰、上官碧、璇若等，乳名茂林，字崇文，湖南凤凰人，中国著名作家、历史文物研究者。');
INSERT INTO `author` VALUES ('15', '徐志摩', '徐志摩（1897年1月15日—1931年11月19日），浙江嘉兴海宁硖石人，现代诗人、散文家。原名章垿，字槱森，留学英国时改名志摩。曾经用过的笔名：南湖、诗哲、海谷、谷、大兵、云中鹤、仙鹤、删我、心手、黄狗、谔谔等。徐志摩是新月派代表诗人，新月诗社成员 。');
INSERT INTO `author` VALUES ('16', '乔治·雷蒙德·理查德·马丁', '乔治·雷蒙德·理查德·马丁（George Raymond Richard Martin），通常被称为乔治·R·R·马丁或GRRM，是一名擅长撰写奇幻、科幻和恐怖小说题材的美国作家、编辑、电视剧编剧兼制片人，雨果奖、星云奖、轨迹奖、世界科幻奖等文学奖项的多次得主。');
INSERT INTO `author` VALUES ('17', '鲁迅', '鲁迅（1881年9月25日－1936年10月19日），原名周樟寿，后改名周树人，字豫山，后改豫才，曾留学日本仙台医科专门校（现东北大学）。“鲁迅”是他1918年发表《狂人日记》时所用的笔名，也是他影响最为广泛的笔名，浙江绍兴人。著名文学家、思想家、民主战士，五四新文化运动的重要参与者，中国现代文学的奠基人。毛泽东曾评价：“鲁迅的方向，就是中华民族新文化的方向。”');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `isbn` varchar(13) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `description` text,
  `publisher_id` int(11) DEFAULT NULL,
  `number_page` int(11) DEFAULT NULL,
  `image` blob,
  `publish_date` varchar(16) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `number_sale` int(11) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `weigth` decimal(7,3) DEFAULT NULL,
  `image_src` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `FK_BOOK_AUTHOR_idx` (`author_id`),
  KEY `FK_BOOK_PUB_idx` (`publisher_id`),
  CONSTRAINT `FK_BOOK_AUTHOR` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_BOOK_PUB` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`publisher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('9787506365437', '活着', '10', '《活着》是一部充满血泪的小说。余华通过一位中国农民的苦难生活 讲述了人如何去承受巨大的苦难；讲述了眼泪的丰富和宽广；讲述了*望 的不存在：讲述了人是为了活着本身而活着…… 《活着》这部小说荣获意大利格林扎纳·卡佛文学奖*高奖项(1998年 )，台湾《中国时报》10本好书奖(1994年)，香港“博益”15本好书奖 (1990年)；并入选香港《亚洲周刊》评选的“20世纪中文小说百年百强” ；入选中国百位批评家和文学编辑评选的“九十年代*有影响的10部作品 ”。', '2', null, null, '2012年08月', '21', '56', '5', '社会', null, 'http://img3m0.ddimg.cn/7/27/25137790-1_b_2.jpg');
INSERT INTO `book` VALUES ('9787506365680', '许三观卖血记', '10', '本书以博大的温情描绘了磨难中的人生，以激烈的故事形式表达了人在面对厄运时求生的欲望。小说讲述了许三观靠着卖血渡过了人生的一个个难关，战胜了命运强加给他的惊涛骇浪，而当他老了，知道自己的血再也没有人要时，他哭了。法国《读书》杂志在评论《许三观卖血记》时说道：这是一部精妙绝伦的小说，是朴实简洁和内涵意蕴深远的完美结合。本书入选韩国《中央日报》评选的“100部必读书”（2000年）、中国百位批评家和文学编辑评选的“20世纪90年代*有影响的10部作品”。', '2', null, null, '2017年09月', '24', '50', '6', '中国当代小说', null, 'http://img3m6.ddimg.cn/15/26/25160766-1_b_3.jpg');
INSERT INTO `book` VALUES ('9787530209554', '平凡的世界(共3册) ', '9', '《平凡的世界(套装共3册)》是一部现实主义小说，也是小说化的家族史。作家高度浓缩了中国西北农村的历史变迁过程，作品达到了思想性与艺术性的高度统一，特别是主人公面对困境艰苦奋斗的精神，对今天的大学生朋友仍有启迪。\r\n这是一部全景式地表现中国当代城乡社会生活的长篇小说。全书共三部。作者在近十年问广阔背景上，通过复杂的矛盾纠葛，刻划了社会各**众多普通人的形象。劳动与爱情，挫折与追求，痛苦与欢乐，日常生活与巨大社会冲突，纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。', '1', '1251', null, '2009年01月01日', '74.8', '20', '2', '中国当代小说', null, 'http://img3m2.ddimg.cn/41/25/25090502-1_b_5.jpg');
INSERT INTO `book` VALUES ('9787530211564', '人生', '9', '《人生》是作家路遥创作的小说，也是其成名作。原载《收获》1982年第三期，获1981——1982全国优秀中篇小说奖。小说以改革时期陕北高原的城乡生活为时空背景，描写了高中毕业生高加林回到土地又离开土地，再离开土地，再回到土地这样人生的变化过程构成了其故事构架。高加林同农村姑娘刘巧珍，城市姑娘黄亚萍之间的感情纠葛构成了故事发展的矛盾，也正是体现那种艰难选择的悲剧。', '1', null, null, '2012年03月', '25', '80', '16', '社会', null, 'http://img3m0.ddimg.cn/6/16/22632990-1_b_1.jpg');
INSERT INTO `book` VALUES ('9787530212035', '早晨从中午开始', '9', '《早晨从中午开始》是路遥的一部随笔集，收入《早晨从中午开始》《路遥自传》等散文随笔。是倾听路遥、了解路遥，充分阅读《平凡的世界》《人生》的必读书。\r\n　　当生命进入正午的时候，工作却要求我像早晨的太阳一般充满青春的朝气投身于其间……作家的劳动绝不仅仅是为了取悦当代，而更重要的是给历史一个深厚的交代。', '1', null, null, '2012年04月', '16.5', '10', '10', '中国现当代随笔', null, 'http://img3m9.ddimg.cn/39/34/22727469-1_b_1.jpg');
INSERT INTO `book` VALUES ('9787533946630', '丰乳肥臀', '11', '莫言*庞大、*丰满的小说，记录百年中国风云变幻的恢宏“史诗”。\r\n\r\n经由一双婴儿的眼睛，目睹一个家族亲历的战争、贫穷、革命、荒淫。\r\n\r\n有爱有欲，有生有死，有人性的愚昧、贪婪，也有人情的温暖、博爱。\r\n\r\n一切无情，一切有情，一切疯癫——用一个故事看懂中国。', '9', null, null, '2017年01月', '27', '59', '6', '中国当代小说', null, 'http://img3m5.ddimg.cn/83/13/24169745-1_b_5.jpg');
INSERT INTO `book` VALUES ('9787547711101', ' 鲁迅全集', '17', null, '10', null, null, null, '45', '100', '2', null, null, 'http://img3m7.ddimg.cn/93/10/23473587-1_b_0.jpg');

-- ----------------------------
-- Table structure for `bsuser`
-- ----------------------------
DROP TABLE IF EXISTS `bsuser`;
CREATE TABLE `bsuser` (
  `user_id` varchar(20) NOT NULL,
  `display_name` varchar(28) NOT NULL,
  `password` varchar(32) NOT NULL,
  `balance` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bsuser
-- ----------------------------
INSERT INTO `bsuser` VALUES ('1', '2', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', '0');
-- 123456
INSERT INTO `bsuser` VALUES ('11111111@qq.com', 'Jayson', 'e10adc3949ba59abbe56e057f20f883e', '100000');
INSERT INTO `bsuser` VALUES ('000000@qq.com', 'PPTV', 'e10adc3949ba59abbe56e057f20f883e', '0');
-- 1
INSERT INTO `bsuser` VALUES ('czw', 'czw', 'c4ca4238a0b923820dcc509a6f75849b', '100000');
-- 1
INSERT INTO `bsuser` VALUES ('jp', 'jp', 'c4ca4238a0b923820dcc509a6f75849b', '99619.5');
INSERT INTO `bsuser` VALUES ('jp@qq.com', 'jayson', '827ccb0eea8a706c4c34a16891f84e7b', '0');
-- 1
INSERT INTO `bsuser` VALUES ('sys', 'sys', 'c4ca4238a0b923820dcc509a6f75849b', '98695');
INSERT INTO `bsuser` VALUES ('test@qq.com', 'JP', 'e10adc3949ba59abbe56e057f20f883e', '0');
INSERT INTO `bsuser` VALUES ('ttt@qq.com', 'Jayson01', 'e10adc3949ba59abbe56e057f20f883e', '0');

-- ----------------------------
-- Table structure for `publisher`
-- ----------------------------
DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
  `publisher_id` int(11) NOT NULL AUTO_INCREMENT,
  `publisher_name` varchar(28) NOT NULL,
  `publisher_intro` mediumtext,
  PRIMARY KEY (`publisher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publisher
-- ----------------------------
INSERT INTO `publisher` VALUES ('1', '北京十月文艺出版社', '北京十月文艺出版社成立于1983年，是以出版文学艺术类图书为主的专业出版社。主要出版现当代文学艺术作品、文艺理论专著、文学人物传记及古代优秀文艺作品。在已出版的600余种图书中，长篇小说《黄河东流去》、《少年天子》、《穆斯林的葬礼》荣获茅盾文学奖，《战争启示录》、《补天裂》获\"五个一工程\"。');
INSERT INTO `publisher` VALUES ('2', '作家出版社', '作家出版社是中国作家协会所属国家级大型文学出版社，现设有八个图书编辑室和《作家文摘》报社。自1953年建社以来，广泛团结中外作家，致力于荟萃当代文学佳作，扶植文坛新人，促进海内外文学交流，出版了大量的优秀文学图书，其中有部分作品先后被介绍到海外，在国内外产生了广泛影响。为了加强海内外的文学交流，与国际出版业接轨，作家出版社曾推出不少引进版图书，深受广大作家和读者喜爱，作家出版社现任社长葛笑政。');
INSERT INTO `publisher` VALUES ('3', '北京燕山出版社', '北京燕山出版社成立于1985年，隶属北京市文物局，以古籍、文物考古及文史社科类选题为主要出版方向。自《宋词鉴赏辞典》获1987年全国优秀畅销书奖始，不断荣获各级各类奖项。其中《图说北京史》曾获中国图书奖，《历史上的永定河与北京》曾获“三个一百”原创出版工程奖，《京剧史照》曾获国家优秀图书奖，《登科记考补正》、《经史说略》、《中国宝卷总目》、《古籍整理浅谈》、《加摹乾隆京城全图》、《琉璃厂杂记》、《北京出土文物》、《北京旧闻丛书》、《中国邮票全集》等奖项，为北京燕山出版社树立了良好的出版品牌形象。');
INSERT INTO `publisher` VALUES ('4', '新世界出版社', '新世界出版社，成立于1951年，是我国最主要的对外出版机构之一，中国国际出版集团成员之一。最初以向海外读者介绍中国历史、文化、音像为主，出版了一大批深受海外读者欢迎的图书，其中不少图书以版权贸易的形式传播到许多国家和地区，累计出书5000多种。');
INSERT INTO `publisher` VALUES ('5', 'HarperCollins Publishers', 'HarperCollins Publishers is the second-largest consumer book publisher in the world. Headquartered in New York, HarperCollins has publishing operations in 17 countries. With two hundred years of history and more than 120 branded imprints around the world, HarperCollins publishes approximately 10,000 new books every year in 16 languages, and has a print and digital catalog of more than 200,000 titles. Writing across dozens of genres, HarperCollins authors include winners of the Nobel Prize, the Pulitzer Prize, the National Book Award, the Newbery and Caldecott Medals, and the Man Booker Prize.');
INSERT INTO `publisher` VALUES ('6', '广州出版社', '广州出版社成立于1992年12月28日，是广州市属惟一的图书出版单位。1999年，广州出版社正式加盟广州日报报业集团，在改革和发展中不断前进。');
INSERT INTO `publisher` VALUES ('7', '长江文艺出版社', '长江文艺出版社于1955年在湖北武汉成立，现已出版图书5000余种。与境外出版机构达成版权贸易两百余种，发行网络遍布全国，计有600余种图书分别获得国家级、省级大奖。');
INSERT INTO `publisher` VALUES ('8', '江苏人民出版社', '江苏人民出版社成立于1953年1月1日。国家一级出版社，首批“全国百佳图书出版单位”之一，是具有深厚历史积淀和众多图书品牌的综合性出版社。年均出版图书1000余种，承担多项国家重点出版项目。先后有400余种图书获得省部级以上优秀奖，其中《我的经济观》、《中国三峡》、《拉贝日记》、《中国现代化历程》、《走进马克思》等12种图书，先后16次获得国家级大奖。现为凤凰出版传媒集团成员。建社至今，出版图书万余种，总印数16亿多册，进入十一五后，将努力打造成为集团内重点图书的生产基地，大众读物的创新平台。江苏人民出版社现设有4个图书编辑室，1个文化教育分社，1个期刊中心（含《董事会》和《马小跳》2种期刊）；拥有1家合资企业：北京凤凰联动文化传媒有限公司。出版社已于2010年5月改制为江苏人民出版社有限公司，简称“江苏人民出版社”');
INSERT INTO `publisher` VALUES ('9', '浙江文艺出版社', '浙江文艺出版社成立于1983年，是浙江省唯一以出版文学艺术书籍为主的专业出版社。建社17年来，出版各类图书1400余种。');
INSERT INTO `publisher` VALUES ('10', '北京日报出版社', '北京日报社是直属于北京市委宣传部的新闻媒体。');

-- ----------------------------
-- Table structure for `trade`
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `trade_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(28) NOT NULL,
  `trade_time` datetime NOT NULL,
  `trade_amount` float NOT NULL,
  PRIMARY KEY (`trade_id`),
  KEY `FK_TRADE_idx` (`user_id`),
  CONSTRAINT `FK_TRADE` FOREIGN KEY (`user_id`) REFERENCES `bsuser` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trade
-- ----------------------------
INSERT INTO `trade` VALUES ('1', '11111111@qq.com', '2019-03-12 22:11:21', '45');
INSERT INTO `trade` VALUES ('10', 'jp', '2019-05-27 13:47:14', '78');
INSERT INTO `trade` VALUES ('11', 'jp', '2019-05-27 13:48:18', '403');
INSERT INTO `trade` VALUES ('12', 'jp', '2019-05-27 14:12:57', '136.5');
INSERT INTO `trade` VALUES ('13', 'jp', '2019-05-27 14:13:36', '67.5');
INSERT INTO `trade` VALUES ('14', 'jp', '2019-05-27 14:20:11', '143');
INSERT INTO `trade` VALUES ('15', 'jp', '2019-05-27 14:22:23', '65.5');
INSERT INTO `trade` VALUES ('16', 'sys', '2019-05-27 14:32:05', '27');
INSERT INTO `trade` VALUES ('17', 'jp', '2019-05-27 14:45:15', '315');
INSERT INTO `trade` VALUES ('18', 'jp', '2019-05-27 14:45:48', '65.5');
INSERT INTO `trade` VALUES ('19', 'sys', '2019-05-28 12:42:33', '51');
INSERT INTO `trade` VALUES ('20', 'sys', '2019-05-29 03:23:44', '1227');

-- ----------------------------
-- Table structure for `tradeitem`
-- ----------------------------
DROP TABLE IF EXISTS `tradeitem`;
CREATE TABLE `tradeitem` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trade_id` int(11) DEFAULT NULL,
  `book_isbn` varchar(13) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FK_TRA_ITEM_BOOK_idx` (`book_isbn`),
  KEY `FK_TRA_ITEM_TRADE_idx` (`trade_id`),
  CONSTRAINT `FK_TRA_ITEM_BOOK` FOREIGN KEY (`book_isbn`) REFERENCES `book` (`isbn`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_TRA_ITEM_TRADE` FOREIGN KEY (`trade_id`) REFERENCES `trade` (`trade_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tradeitem
-- ----------------------------
INSERT INTO `tradeitem` VALUES ('1', '1', '9787506365437', '1', '21');
INSERT INTO `tradeitem` VALUES ('2', '1', '9787506365680', '1', '24');
INSERT INTO `tradeitem` VALUES ('8', '10', '9787533946630', '2', '54');
INSERT INTO `tradeitem` VALUES ('9', '10', '9787506365680', '1', '24');
INSERT INTO `tradeitem` VALUES ('10', '11', '9787530212035', '2', '33');
INSERT INTO `tradeitem` VALUES ('11', '11', '9787506365680', '2', '48');
INSERT INTO `tradeitem` VALUES ('12', '11', '9787533946630', '1', '27');
INSERT INTO `tradeitem` VALUES ('13', '11', '9787530211564', '10', '250');
INSERT INTO `tradeitem` VALUES ('14', '11', '9787547711101', '1', '45');
INSERT INTO `tradeitem` VALUES ('15', '12', '9787530212035', '1', '16.5');
INSERT INTO `tradeitem` VALUES ('16', '12', '9787506365680', '5', '120');
INSERT INTO `tradeitem` VALUES ('17', '13', '9787530212035', '1', '16.5');
INSERT INTO `tradeitem` VALUES ('18', '13', '9787506365680', '1', '24');
INSERT INTO `tradeitem` VALUES ('19', '13', '9787533946630', '1', '27');
INSERT INTO `tradeitem` VALUES ('20', '14', '9787506365680', '3', '72');
INSERT INTO `tradeitem` VALUES ('21', '14', '9787506365437', '1', '21');
INSERT INTO `tradeitem` VALUES ('22', '14', '9787530211564', '2', '50');
INSERT INTO `tradeitem` VALUES ('23', '15', '9787530211564', '1', '25');
INSERT INTO `tradeitem` VALUES ('24', '15', '9787530212035', '1', '16.5');
INSERT INTO `tradeitem` VALUES ('25', '15', '9787506365680', '1', '24');
INSERT INTO `tradeitem` VALUES ('26', '16', '9787533946630', '1', '27');
INSERT INTO `tradeitem` VALUES ('27', '17', '9787547711101', '7', '315');
INSERT INTO `tradeitem` VALUES ('28', '18', '9787530211564', '1', '25');
INSERT INTO `tradeitem` VALUES ('29', '18', '9787530212035', '1', '16.5');
INSERT INTO `tradeitem` VALUES ('30', '18', '9787506365680', '1', '24');
INSERT INTO `tradeitem` VALUES ('31', '19', '9787506365680', '1', '24');
INSERT INTO `tradeitem` VALUES ('32', '19', '9787533946630', '1', '27');
INSERT INTO `tradeitem` VALUES ('33', '20', '9787506365680', '50', '1200');
INSERT INTO `tradeitem` VALUES ('34', '20', '9787533946630', '1', '27');
