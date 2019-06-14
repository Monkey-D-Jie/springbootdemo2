/*
Navicat MySQL Data Transfer

Source Server         : MyTestDB
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : employees

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2019-06-14 14:23:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `dept_no` varchar(32) NOT NULL,
  `dept_name` varchar(40) NOT NULL,
  PRIMARY KEY (`dept_no`),
  UNIQUE KEY `dept_name` (`dept_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
