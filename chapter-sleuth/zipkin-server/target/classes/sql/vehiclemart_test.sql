/*
Navicat MySQL Data Transfer

Source Server         : 易鑫
Source Server Version : 50714
Source Host           : 192.168.145.160:3306
Source Database       : vehiclemart_test

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-07-16 14:23:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ba_attach_source
-- ----------------------------
DROP TABLE IF EXISTS `ba_attach_source`;
CREATE TABLE `ba_attach_source` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `attch_path` varchar(200) DEFAULT NULL COMMENT '附件存储路径',
  `attch_type` varchar(50) DEFAULT NULL COMMENT '附件类型：jpg、png等等',
  `buss_id` varchar(50) DEFAULT NULL COMMENT '业务表id',
  `compress_attch_path` varchar(200) DEFAULT NULL COMMENT '压缩后图片路径',
  `source_attch_name` varchar(100) DEFAULT NULL COMMENT '资源附件原始名称',
  `buss_type` varchar(50) DEFAULT NULL COMMENT '业务类型：用于区分同一个bussId对应的多个附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_certified_process
-- ----------------------------
DROP TABLE IF EXISTS `ba_certified_process`;
CREATE TABLE `ba_certified_process` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `certified_type` varchar(10) DEFAULT NULL COMMENT '认证类型 1-个人认证，2-企业认证',
  `userinfo_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `verify_date` datetime DEFAULT NULL COMMENT '审核时间',
  `verify_name` varchar(50) DEFAULT NULL COMMENT '审核人姓名',
  `verify_status` varchar(10) DEFAULT NULL COMMENT '审核状态 0-未审核、1-审核通过，2-已驳回',
  `company_address` varchar(125) DEFAULT NULL COMMENT '公司地址',
  `company_name` varchar(125) DEFAULT NULL COMMENT '公司名称',
  `enterprise_certify_id` varchar(50) DEFAULT NULL COMMENT '企业认证记录id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_dict
-- ----------------------------
DROP TABLE IF EXISTS `ba_dict`;
CREATE TABLE `ba_dict` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `buss_code` varchar(20) NOT NULL COMMENT '业务code',
  `buss_name` varchar(100) DEFAULT NULL COMMENT '业务名称',
  `type_code` varchar(20) NOT NULL COMMENT '类型code',
  `type_name` varchar(100) DEFAULT NULL COMMENT '类型名称',
  UNIQUE KEY `buss_code` (`buss_code`,`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_enterprise_certified
-- ----------------------------
DROP TABLE IF EXISTS `ba_enterprise_certified`;
CREATE TABLE `ba_enterprise_certified` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `business_license_image` varchar(255) DEFAULT NULL COMMENT '营业执照图片存储路径',
  `certified_result` varchar(10) DEFAULT NULL COMMENT '认证结果（1-待审核，2-认证成功，3-认证失败）',
  `company_address` varchar(125) DEFAULT NULL COMMENT '公司地址',
  `company_name` varchar(125) DEFAULT NULL COMMENT '公司名称',
  `userinfo_id` varchar(50) DEFAULT '' COMMENT '用户id',
  `suggest` varchar(255) DEFAULT NULL COMMENT '审核意见',
  `business_license_image_compress` varchar(255) DEFAULT NULL COMMENT '营业执照压缩后图片存储路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_goods_delivery_mode
-- ----------------------------
DROP TABLE IF EXISTS `ba_goods_delivery_mode`;
CREATE TABLE `ba_goods_delivery_mode` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `delivery_mode_desc` varchar(50) DEFAULT NULL COMMENT '交货方式描述',
  `delivery_mode_type` varchar(10) DEFAULT NULL COMMENT '交货方式类型  1-送货上门，2-当地4S店自提，3-买方物流',
  `goodsinfo_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_goods_image_source
-- ----------------------------
DROP TABLE IF EXISTS `ba_goods_image_source`;
CREATE TABLE `ba_goods_image_source` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `attach_source_entity` tinyblob,
  `color_name` varchar(16) DEFAULT NULL COMMENT '颜色',
  `goodsinfo_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `image_index` int(11) DEFAULT NULL COMMENT '图片索引位置',
  `image_type` varchar(10) DEFAULT NULL COMMENT '图片类型 1-车源图片，2-交易页图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `ba_goods_info`;
CREATE TABLE `ba_goods_info` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `business_type` varchar(10) DEFAULT NULL COMMENT '商家信息 1-易鑫自营',
  `car_brand_id` varchar(50) DEFAULT NULL COMMENT '品牌id',
  `car_brand_name` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `car_master_brand_id` varchar(50) DEFAULT NULL COMMENT '主品牌ID',
  `car_master_brand_name` varchar(50) DEFAULT NULL COMMENT '主品牌名称',
  `car_model_id` varchar(50) DEFAULT NULL COMMENT '车型id',
  `car_model_name` varchar(50) DEFAULT NULL COMMENT '车型名称',
  `car_style_id` varchar(50) DEFAULT NULL COMMENT '车款id',
  `car_style_name` varchar(50) DEFAULT NULL COMMENT '车款名称',
  `contact_name` varchar(50) DEFAULT NULL COMMENT '联系人名称',
  `contact_style` varchar(50) DEFAULT NULL COMMENT '联系方式(手机或邮箱)',
  `departure_time` varchar(20) DEFAULT NULL COMMENT '发车时间',
  `deposit_ratio` decimal(19,2) DEFAULT NULL COMMENT '定金比例',
  `discount_price` decimal(19,2) DEFAULT NULL COMMENT '折扣价',
  `down_shelf_date` datetime DEFAULT NULL COMMENT '下架时间',
  `fare_bearer` varchar(10) DEFAULT NULL COMMENT '运费承担方 1-卖家承担,2-买家承担',
  `formalities` varchar(10) DEFAULT NULL COMMENT '手续 1-随车，2-邮寄',
  `garage_city_code` varchar(10) DEFAULT NULL COMMENT '车源所在地编号',
  `garage_city_name` varchar(125) DEFAULT NULL COMMENT '车源所在地名称',
  `goods_index` int(11) DEFAULT NULL COMMENT '位置索引',
  `goods_status` varchar(10) DEFAULT NULL COMMENT '商品状态 1-已上架，2-草稿，3-已下架',
  `guide_price` decimal(19,2) DEFAULT NULL COMMENT '指导价',
  `invoice_type` varchar(10) DEFAULT NULL COMMENT '发票类型 1-增票、2-零售票',
  `min_quantity` int(11) DEFAULT NULL COMMENT '起订台数',
  `payment_type` varchar(10) DEFAULT NULL COMMENT '交易方式. 1-全款发车,2-定金发车',
  `release_time` datetime DEFAULT NULL COMMENT '发布时间',
  `remark` longtext COMMENT '备注',
  `sell_price` decimal(19,2) DEFAULT NULL COMMENT '售价',
  `up_shelf_date` datetime DEFAULT NULL COMMENT '上架时间',
  `vehicle_type` varchar(10) DEFAULT NULL COMMENT '车辆类型：1-国产-现车，2-国产-期货，3-合资-现车，4-合资-期货，5-进口-现车，6-进口-期货',
  `payment_commission` decimal(19,2) DEFAULT NULL COMMENT '支付返佣金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_goods_sale_place
-- ----------------------------
DROP TABLE IF EXISTS `ba_goods_sale_place`;
CREATE TABLE `ba_goods_sale_place` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `goodsinfo_id` varchar(50) DEFAULT NULL COMMENT '商品ID',
  `place_code` varchar(20) DEFAULT NULL COMMENT '地区编码',
  `place_name` varchar(50) DEFAULT NULL COMMENT '地区名称',
  `place_type` varchar(10) DEFAULT NULL COMMENT '地址类型 0-全国，1-大区，2-省，3-市',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_identify_code
-- ----------------------------
DROP TABLE IF EXISTS `ba_identify_code`;
CREATE TABLE `ba_identify_code` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code_type` varchar(200) DEFAULT NULL COMMENT '验证码类型 0-注册，1-重置密码，2-实名认证',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `verification_code` int(11) DEFAULT NULL COMMENT '手机验证码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `ba_operate_log`;
CREATE TABLE `ba_operate_log` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `buss_id` varchar(255) DEFAULT NULL COMMENT '业务记录id',
  `buss_status_code` varchar(255) DEFAULT NULL COMMENT '业务状态code',
  `log_type_code` varchar(20) DEFAULT NULL COMMENT '日志类型code',
  `operate_time` varchar(20) DEFAULT NULL COMMENT '操作时间',
  `operator_id` varchar(50) DEFAULT NULL COMMENT '操作人ID',
  `operator_name` varchar(50) DEFAULT NULL COMMENT '操作人姓名',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_order
-- ----------------------------
DROP TABLE IF EXISTS `ba_order`;
CREATE TABLE `ba_order` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `approval_msg` varchar(255) DEFAULT NULL COMMENT '备注',
  `bank_account` varchar(125) DEFAULT NULL COMMENT '银行账号',
  `bank_name` varchar(125) DEFAULT NULL COMMENT '开户银行名称',
  `buyer_message` varchar(255) DEFAULT NULL COMMENT '买家留言',
  `company_address` varchar(125) DEFAULT NULL COMMENT '单位地址',
  `contact_phone` varchar(15) DEFAULT NULL COMMENT '联系电话',
  `delivery_mode_type` varchar(10) DEFAULT NULL COMMENT '交货方式 1-送货上门，2-当地4S店自提，3-买方物流',
  `end_total_price` decimal(19,2) DEFAULT NULL COMMENT '尾付合计金额',
  `invoice_accepter_name` varchar(50) DEFAULT NULL COMMENT '发票接收人名称',
  `invoice_accepter_phone` varchar(30) DEFAULT NULL COMMENT '发票接收人电话',
  `invoice_address` varchar(255) DEFAULT NULL COMMENT '发票接收详细地址',
  `invoice_name` varchar(125) DEFAULT NULL COMMENT '开票名称',
  `invoice_post_code` varchar(20) DEFAULT NULL COMMENT '发票接收地址邮政编号',
  `order_no` varchar(50) DEFAULT NULL COMMENT '主订单编号',
  `start_total_price` decimal(19,2) DEFAULT NULL COMMENT '首付合计金额',
  `status` varchar(10) DEFAULT NULL COMMENT '状态 0-待接单，1-处理中，3-已完成，4-已失效，5-已取消',
  `tax_code` varchar(125) DEFAULT NULL COMMENT '税务号',
  `total_quantity` int(11) DEFAULT NULL COMMENT '车辆总数量',
  `userinfo_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `vehicle_accepter_name` varchar(50) DEFAULT NULL COMMENT '车辆接收人名称',
  `vehicle_accepter_phone` varchar(30) DEFAULT NULL COMMENT '车辆接收人电话',
  `vehicle_address` varchar(255) DEFAULT NULL COMMENT '车辆接收详细地址',
  `vehicle_post_code` varchar(20) DEFAULT NULL COMMENT '车辆接收地址邮政编号',
  `goodsinfo_id` varchar(50) DEFAULT NULL COMMENT '商品信息ID',
  `order_goods_info_id` varchar(50) DEFAULT NULL COMMENT '下单时的商品信息表id',
  `payment_commission` decimal(19,2) DEFAULT NULL COMMENT '支付返佣',
  `unit_price` decimal(19,2) DEFAULT NULL COMMENT '单价',
  `submit_time` datetime DEFAULT NULL COMMENT '下单时间',
  `order_invoice_type` varchar(10) DEFAULT NULL COMMENT '开票类型 1-增值税发票，2-普通发票',
  `order_taking_time` datetime DEFAULT NULL COMMENT '接单时间',
  `company_name` varchar(125) DEFAULT NULL,
  `submit_user` varchar(50) DEFAULT NULL,
  `region_code` varchar(50) DEFAULT NULL,
  `region_name` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_order_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `ba_order_goods_info`;
CREATE TABLE `ba_order_goods_info` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `business_type` varchar(10) DEFAULT NULL COMMENT '商家信息 1-易鑫自营',
  `car_brand_id` varchar(50) DEFAULT NULL COMMENT '品牌id',
  `car_brand_name` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `car_master_brand_id` varchar(50) DEFAULT NULL COMMENT '主品牌ID',
  `car_master_brand_name` varchar(50) DEFAULT NULL COMMENT '主品牌名称',
  `car_model_id` varchar(50) DEFAULT NULL COMMENT '车型id',
  `car_model_name` varchar(50) DEFAULT NULL COMMENT '车型名称',
  `car_style_id` varchar(50) DEFAULT NULL COMMENT '车款id',
  `car_style_name` varchar(50) DEFAULT NULL COMMENT '车款名称',
  `contact_name` varchar(50) DEFAULT NULL COMMENT '联系人名称',
  `contact_style` varchar(50) DEFAULT NULL COMMENT '联系方式(手机或邮箱)',
  `departure_time` varchar(20) DEFAULT NULL COMMENT '发车时间',
  `deposit_ratio` decimal(19,2) DEFAULT NULL COMMENT '定金比例',
  `discount_price` decimal(19,2) DEFAULT NULL COMMENT '折扣价',
  `down_shelf_date` datetime DEFAULT NULL COMMENT '下架时间',
  `fare_bearer` varchar(10) DEFAULT NULL COMMENT '运费承担方 1-卖家承担,2-买家承担',
  `formalities` varchar(10) DEFAULT NULL COMMENT '手续 1-随车，2-邮寄',
  `garage_city_code` varchar(10) DEFAULT NULL COMMENT '车源所在地编号',
  `garage_city_name` varchar(125) DEFAULT NULL COMMENT '车源所在地名称',
  `goods_index` int(11) DEFAULT NULL COMMENT '位置索引',
  `goods_status` varchar(10) DEFAULT NULL COMMENT '商品状态 1-已上架，2-草稿，3-已下架',
  `guide_price` decimal(19,2) DEFAULT NULL COMMENT '指导价',
  `invoice_type` varchar(10) DEFAULT NULL COMMENT '发票类型 1-增票、2-零售票',
  `min_quantity` int(11) DEFAULT NULL COMMENT '起订台数',
  `payment_type` varchar(10) DEFAULT NULL COMMENT '交易方式. 1-全款发车,2-定金发车',
  `release_time` datetime DEFAULT NULL COMMENT '发布时间',
  `remark` longtext COMMENT '备注',
  `sell_price` decimal(19,2) DEFAULT NULL COMMENT '售价',
  `up_shelf_date` datetime DEFAULT NULL COMMENT '上架时间',
  `vehicle_type` varchar(10) DEFAULT NULL COMMENT '车辆类型：1-国产-现车，2-国产-期货，3-合资-现车，4-合资-期货，5-进口-现车，6-进口-期货',
  `order_id` varchar(50) DEFAULT NULL COMMENT '对应的订单',
  `payment_commission` decimal(19,2) DEFAULT NULL COMMENT '支付返佣金额',
  PRIMARY KEY (`id`),
  KEY `FK_ordergoods2order` (`order_id`),
  CONSTRAINT `FK_ordergoods2order` FOREIGN KEY (`order_id`) REFERENCES `ba_order` (`id`),
  CONSTRAINT `FKbtyndm91u2fetpkhxj4r9lwyv` FOREIGN KEY (`order_id`) REFERENCES `ba_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_order_item
-- ----------------------------
DROP TABLE IF EXISTS `ba_order_item`;
CREATE TABLE `ba_order_item` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `child_order_no` varchar(50) DEFAULT NULL COMMENT '子订单编号',
  `color_name` varchar(20) DEFAULT NULL COMMENT '颜色',
  `goods_quantity` int(11) DEFAULT NULL COMMENT '商品数量',
  `order_no` varchar(50) DEFAULT NULL COMMENT '主订单编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_order_vehicle_item
-- ----------------------------
DROP TABLE IF EXISTS `ba_order_vehicle_item`;
CREATE TABLE `ba_order_vehicle_item` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `actual_departure_date` datetime DEFAULT NULL COMMENT '实际发车时间',
  `color_name` varchar(20) DEFAULT NULL COMMENT '颜色',
  `predict_date` datetime DEFAULT NULL COMMENT '预计接车时间',
  `vehicle_status` varchar(10) DEFAULT NULL COMMENT '车辆状态 1-待发车，2-待收车，3-已确认收车',
  `vehicle_id` varchar(50) DEFAULT NULL COMMENT '进销存车辆id',
  `vin` varchar(50) DEFAULT NULL COMMENT '车架号',
  `order_item_no` varchar(50) DEFAULT NULL COMMENT '子订单编号',
  `upload_attachment` bit(1) DEFAULT b'0' COMMENT '是否已上传收车图片，默认没有',
  `actual_pick_date` datetime DEFAULT NULL COMMENT '实际接车时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_person_certified
-- ----------------------------
DROP TABLE IF EXISTS `ba_person_certified`;
CREATE TABLE `ba_person_certified` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `businesscard_image` varchar(125) DEFAULT NULL COMMENT '工作名片照片存储路径',
  `certified_real_name` varchar(50) DEFAULT NULL COMMENT '认证真实姓名',
  `certified_result` varchar(10) DEFAULT NULL COMMENT '认证结果（1-待审核，2-认证成功，3-认证失败）',
  `customer_position` varchar(50) DEFAULT NULL COMMENT '用户职位',
  `idcard` varchar(50) DEFAULT NULL COMMENT '身份证号',
  `idcard_back_image` varchar(125) DEFAULT NULL COMMENT '身份证反面照片存储路径',
  `idcard_front_image` varchar(125) DEFAULT NULL COMMENT '身份证正面照片存储路径',
  `userinfo_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `suggest` varchar(255) DEFAULT NULL COMMENT '审核意见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_role
-- ----------------------------
DROP TABLE IF EXISTS `ba_role`;
CREATE TABLE `ba_role` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_source_item
-- ----------------------------
DROP TABLE IF EXISTS `ba_source_item`;
CREATE TABLE `ba_source_item` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `item_code` varchar(125) DEFAULT NULL COMMENT '元素编号',
  `item_name` varchar(125) DEFAULT NULL COMMENT '元素名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_source_role_relate
-- ----------------------------
DROP TABLE IF EXISTS `ba_source_role_relate`;
CREATE TABLE `ba_source_role_relate` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色表ID',
  `source_id` varchar(50) DEFAULT NULL COMMENT '资源表ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_user_info
-- ----------------------------
DROP TABLE IF EXISTS `ba_user_info`;
CREATE TABLE `ba_user_info` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `phone` varchar(11) NOT NULL COMMENT '注册手机号',
  `real_name` varchar(50) DEFAULT NULL,
  `company_name` varchar(200) NOT NULL COMMENT '公司名称',
  `trading_identities` varchar(10) NOT NULL COMMENT '贸易身份',
  `verify_status` varchar(2) DEFAULT '0' COMMENT '审核类型：0、未验证，1、验证通过，2、验证未通过',
  `passwd` varchar(200) NOT NULL COMMENT '加密后的密码',
  `user_status` tinyint(1) DEFAULT '1' COMMENT '用户状态：0、锁定，1、正常',
  `contact_phone` varchar(15) DEFAULT NULL COMMENT '联系手机号',
  `head_image` varchar(125) DEFAULT NULL COMMENT '头像图片存储路径',
  `introduction` varchar(125) DEFAULT NULL COMMENT '介绍',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ号码',
  `wechat` varchar(50) DEFAULT NULL COMMENT '微信号',
  `city_code` varchar(30) DEFAULT NULL COMMENT '所在城市编码',
  `city_name` varchar(30) DEFAULT NULL COMMENT '所在城市名称',
  `certified_company_name` varchar(125) DEFAULT NULL,
  `certified_real_name` varchar(50) DEFAULT NULL,
  `working_place` varchar(30) DEFAULT NULL COMMENT '公司地点',
  `registe_phone` varchar(11) DEFAULT NULL COMMENT '注册时的注册手机号',
  `registe_real_name` varchar(50) DEFAULT NULL COMMENT '注册时的真实姓名',
  `registe_company_name` varchar(200) DEFAULT NULL COMMENT '注册时的公司名',
  `registe_working_place` varchar(30) DEFAULT NULL COMMENT '注册时的工作地点',
  `registe_trading_identities` varchar(10) DEFAULT NULL COMMENT '注册时的贸易身份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ba_user_login_log`;
CREATE TABLE `ba_user_login_log` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `lock_time` datetime DEFAULT NULL,
  `pwd_error_count` int(11) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_user_role_relate
-- ----------------------------
DROP TABLE IF EXISTS `ba_user_role_relate`;
CREATE TABLE `ba_user_role_relate` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL COMMENT '角色id',
  `userinfo_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_vehicle_accept_address
-- ----------------------------
DROP TABLE IF EXISTS `ba_vehicle_accept_address`;
CREATE TABLE `ba_vehicle_accept_address` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `accepter_name` varchar(50) DEFAULT NULL COMMENT '接收人名称',
  `accepter_phone` varchar(50) DEFAULT NULL COMMENT '接收人电话',
  `addr_type` varchar(10) DEFAULT NULL COMMENT '地址类型（0-接车地址，1-收票地址）',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `post_code` varchar(50) DEFAULT NULL COMMENT '邮政编号',
  `region_code` varchar(50) DEFAULT NULL COMMENT '所在地区编号',
  `region_name` varchar(125) DEFAULT NULL COMMENT '所在地区名称',
  `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',
  `userinfo_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_vehicle_invoice_info
-- ----------------------------
DROP TABLE IF EXISTS `ba_vehicle_invoice_info`;
CREATE TABLE `ba_vehicle_invoice_info` (
  `id` varchar(50) NOT NULL,
  `bz_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `creator_department_id` bigint(20) DEFAULT NULL,
  `creator_department_name` varchar(255) DEFAULT NULL,
  `creator_id` varchar(255) DEFAULT NULL,
  `creator_name` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `updator_department_id` bigint(20) DEFAULT NULL,
  `updator_department_name` varchar(255) DEFAULT NULL,
  `updator_id` varchar(255) DEFAULT NULL,
  `updator_name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `bank_account` varchar(125) DEFAULT NULL COMMENT '银行账号',
  `bank_name` varchar(125) DEFAULT NULL COMMENT '开户银行名称',
  `company_address` varchar(125) DEFAULT NULL COMMENT '单位地址',
  `contact_phone` varchar(15) DEFAULT NULL,
  `invoice_name` varchar(125) DEFAULT NULL COMMENT '开票名称',
  `is_default` bit(1) DEFAULT NULL COMMENT '是否默认',
  `tax_code` varchar(125) DEFAULT NULL COMMENT '税务号',
  `userinfo_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
