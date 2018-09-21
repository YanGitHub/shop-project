/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : db_shop

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2018-09-21 23:28:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_bill`
-- ----------------------------
DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE `t_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_no` varchar(32) DEFAULT NULL COMMENT '开台单编号',
  `desk_id` bigint(20) DEFAULT NULL COMMENT '桌台 id t_desk_id',
  `vip_code` varchar(20) DEFAULT NULL COMMENT '会员编码',
  `person_num` int(11) DEFAULT NULL COMMENT '人数',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `vip_name` varchar(20) DEFAULT NULL COMMENT '会员',
  `note` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开台单信息表';

-- ----------------------------
-- Records of t_bill
-- ----------------------------

-- ----------------------------
-- Table structure for `t_bill_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_bill_menu`;
CREATE TABLE `t_bill_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bill_no` varchar(20) DEFAULT NULL COMMENT 't_bill bill_no',
  `menu_code` varchar(20) DEFAULT NULL COMMENT '菜单编号',
  `menu_type_code` varchar(20) DEFAULT NULL COMMENT '类别',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `is_settled` int(11) DEFAULT NULL COMMENT '是否结账 1已结 0 未结',
  `note` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='点菜信息表';

-- ----------------------------
-- Records of t_bill_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `t_company`
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '公司名称',
  `address` varchar(64) DEFAULT NULL COMMENT '地址',
  `mobile` varchar(16) NOT NULL COMMENT '电话',
  `duty_paragraph` varchar(64) DEFAULT NULL COMMENT '税号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司信息';

-- ----------------------------
-- Records of t_company
-- ----------------------------

-- ----------------------------
-- Table structure for `t_desk_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_desk_info`;
CREATE TABLE `t_desk_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_Id` bigint(20) NOT NULL COMMENT '桌台类型 t_desk_type id',
  `name` varchar(20) NOT NULL COMMENT '桌台名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='桌台信息表';

-- ----------------------------
-- Records of t_desk_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_desk_status`
-- ----------------------------
DROP TABLE IF EXISTS `t_desk_status`;
CREATE TABLE `t_desk_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(10) DEFAULT NULL COMMENT '桌台状态',
  `vip_name` varchar(10) DEFAULT NULL COMMENT '会员名称',
  `person_num` int(11) DEFAULT NULL COMMENT '人数',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `tel` varchar(20) DEFAULT NULL COMMENT '手机',
  `note` varchar(20) DEFAULT NULL COMMENT '备注',
  `desk_num` varchar(20) DEFAULT NULL COMMENT '桌台编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='桌台状态表';

-- ----------------------------
-- Records of t_desk_status
-- ----------------------------

-- ----------------------------
-- Table structure for `t_desk_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_desk_type`;
CREATE TABLE `t_desk_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL COMMENT '桌台类别',
  `num` int(11) DEFAULT NULL COMMENT '容纳人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='桌台类型表';

-- ----------------------------
-- Records of t_desk_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_menu_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_info`;
CREATE TABLE `t_menu_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `real_price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `unt_price` decimal(10,0) DEFAULT NULL COMMENT '原价',
  `point_base` decimal(10,0) DEFAULT NULL COMMENT '积分基数',
  `type_id` bigint(20) DEFAULT NULL COMMENT '菜单类别编号 t_menu_type id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单信息表';

-- ----------------------------
-- Records of t_menu_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_menu_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_type`;
CREATE TABLE `t_menu_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '类别名称',
  `discount` decimal(10,0) DEFAULT NULL COMMENT '折扣率',
  `is_discount` int(1) DEFAULT NULL COMMENT '是否打折 1 是 0 不是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单类别表';

-- ----------------------------
-- Records of t_menu_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL COMMENT '时间',
  `receivable` decimal(10,0) DEFAULT NULL COMMENT '应收',
  `actual_receipt` decimal(10,0) DEFAULT NULL COMMENT '实收',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售统计表';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `type` int(1) DEFAULT NULL COMMENT '1管理员 2操作员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `t_user` VALUES ('2', 'user', 'user', '2');

-- ----------------------------
-- Table structure for `t_vip_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_vip_info`;
CREATE TABLE `t_vip_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL COMMENT '会员编号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `tel` varchar(20) DEFAULT NULL COMMENT '手机',
  `pwd` varchar(20) DEFAULT NULL COMMENT '密码',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `vip_type` varchar(20) DEFAULT NULL COMMENT '会员类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员信息表';

-- ----------------------------
-- Records of t_vip_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_vip_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_vip_type`;
CREATE TABLE `t_vip_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '类别名称',
  `price` decimal(10,0) DEFAULT NULL COMMENT '价格',
  `discount` decimal(10,0) DEFAULT NULL COMMENT '折扣率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员类型表';

-- ----------------------------
-- Records of t_vip_type
-- ----------------------------
