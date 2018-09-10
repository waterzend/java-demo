/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1-root-root
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : authority

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2018-09-10 15:45:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '2018-09-10 14:35:08', '2018-09-10 14:35:10');
