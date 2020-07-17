/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 17/07/2020 10:04:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publisher` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remain` int(3) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '数据结构(第三版)', '严蔚敏', ' 清华大学出版社', 6);
INSERT INTO `book` VALUES (2, '数据结构(第五版)', '李春葆', '清华大学出版社', 5);
INSERT INTO `book` VALUES (3, '数据结构(第二版)', '严蔚敏', ' 清华大学出版社', 10);
INSERT INTO `book` VALUES (4, 'Thinking in Java(第三版)', 'Bruce Eckel', '机械工业出版社', 4);
INSERT INTO `book` VALUES (5, 'Thinking in Java(第二版)', 'Bruce Eckel', '机械工业出版社', 5);
INSERT INTO `book` VALUES (6, 'C程序设计(第三版)', '谭浩强', '清华大学出版社', 5);
INSERT INTO `book` VALUES (7, 'C程序设计(第四版)', '谭浩强', '清华大学出版社', 3);
INSERT INTO `book` VALUES (8, '高等数学(第七版)(上册)', '同济大学数学系', '高等教育出版社', 14);
INSERT INTO `book` VALUES (9, '高等数学(第七版)(下册)', '同济大学数学系', '高等教育出版社', 6);
INSERT INTO `book` VALUES (10, '概率论与数理统计', '盛骤 谢式千', '高等教育出版社', 4);
INSERT INTO `book` VALUES (11, '线性代数(第六版)', '同济大学数学系', '高等教育出版社', 6);
INSERT INTO `book` VALUES (12, '西方经济学(第六版)', '高鸿业', '中国人民大学出版社', 3);
INSERT INTO `book` VALUES (13, '计量经济(第三版)', '庞皓', '科学出版社', 7);
INSERT INTO `book` VALUES (14, '管理运筹学(第三版)', '韩伯棠', '高等教育出版社', 6);
INSERT INTO `book` VALUES (15, '金融学(第二版)', '陈学彬', '高等教育出版社', 3);
INSERT INTO `book` VALUES (16, '运筹学(第三版)', '刁在筠 刘桂真 宿洁', '高等教育出版社', 5);
INSERT INTO `book` VALUES (17, '计算机网络(第六版)', '谢希仁', '电子工业出版社', 5);
INSERT INTO `book` VALUES (18, '计算机组成原理(第二版)', '唐朔飞', '高等教育出版社', 20);
INSERT INTO `book` VALUES (19, 'C++程序设计(第三版)', '谭浩强', '清华大学出版社', 20);
INSERT INTO `book` VALUES (20, '软件工程导论(第六版)', '张海藩', '清华大学出版社', 15);
INSERT INTO `book` VALUES (21, '数据库系统概论(第五版)', '王珊 萨师煊', '高等教育出版社', 10);
INSERT INTO `book` VALUES (22, 'Java语言程序设计(第二版)', '张思民', '清华大学出版社', 6);
INSERT INTO `book` VALUES (23, 'Java语言程序设计(第三版)', '张思民', '清华大学出版社', 9);
INSERT INTO `book` VALUES (24, '数字电子技术基础(第五版)', '阎石', '高等教育出版社', 20);
INSERT INTO `book` VALUES (25, '电工学上册(第七版)', '秦曾煌', '高等教育出版社', 5);
INSERT INTO `book` VALUES (26, '电工学下册(第七版)', '秦曾煌', '高等教育出版社', 5);
INSERT INTO `book` VALUES (27, '电路(第四版)', '秋关源', '高等教育出版社', 6);

-- ----------------------------
-- Table structure for borrowship
-- ----------------------------
DROP TABLE IF EXISTS `borrowship`;
CREATE TABLE `borrowship`  (
  `id` int(11) NOT NULL,
  `email` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrowship
-- ----------------------------
INSERT INTO `borrowship` VALUES (1, '360791403@qq.com');
INSERT INTO `borrowship` VALUES (1, '3190937862@qq.com');
INSERT INTO `borrowship` VALUES (8, '360791403@qq.com');
INSERT INTO `borrowship` VALUES (17, '360791403@qq.com');
INSERT INTO `borrowship` VALUES (22, '360791403@qq.com');
INSERT INTO `borrowship` VALUES (27, '360791403@qq.com');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `email` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`email`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1062978197@qq.com', '游客', '4297F44B13955235245B2497399D7A93');
INSERT INTO `user` VALUES ('1335301531@qq.com', '方瀚成', 'C8837B23FF8AAA8A2DDE915473CE0991');
INSERT INTO `user` VALUES ('3190937862@qq.com', '荣浩', 'E10ADC3949BA59ABBE56E057F20F883E');
INSERT INTO `user` VALUES ('360791403@qq.com', '梁梦楠', '80A149BA9FA6078ECA42A6AC28920CCA');

SET FOREIGN_KEY_CHECKS = 1;
