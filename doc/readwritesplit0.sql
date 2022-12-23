/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.43.201
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 192.168.43.201:3306
 Source Schema         : readwritesplit0

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 29/07/2021 11:49:30
*/




CREATE DATABASE if not exists `readwritesplit0` /*!40100 DEFAULT   */ /*!80016 DEFAULT ENCRYPTION='N' */

-- ----------------------------
-- Table structure for tb_keyvalue_0
-- ----------------------------
DROP TABLE IF EXISTS `tb_keyvalue_0`;
CREATE TABLE `tb_keyvalue_0`  (
  `id` bigint(0) NOT NULL,
  `fld_key` varchar(255)   DEFAULT NULL,
  `fld_value` varchar(255)   DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB    ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_keyvalue_1
-- ----------------------------
DROP TABLE IF EXISTS `tb_keyvalue_1`;
CREATE TABLE `tb_keyvalue_1`  (
  `id` bigint(0) NOT NULL,
  `fld_key` varchar(255)    DEFAULT NULL,
  `fld_value` varchar(255)    DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB    ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_keyvalue_2
-- ----------------------------
DROP TABLE IF EXISTS `tb_keyvalue_2`;
CREATE TABLE `tb_keyvalue_2`  (
  `id` bigint(0) NOT NULL,
  `fld_key` varchar(255)    DEFAULT NULL,
  `fld_value` varchar(255)   DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB    ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
