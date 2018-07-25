

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
  `attch_path` varchar(200) DEFAULT NULL,
  `attch_type` varchar(50) DEFAULT NULL,
  `buss_id` varchar(50) DEFAULT NULL,
  `compress_attch_path` varchar(200) DEFAULT NULL,
  `source_attch_name` varchar(100) DEFAULT NULL,
  `buss_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_certified_operator_log
-- ----------------------------
DROP TABLE IF EXISTS `ba_certified_operator_log`;
CREATE TABLE `ba_certified_operator_log` (
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
  `certity_status` varchar(10) DEFAULT NULL,
  `certity_type` varchar(10) DEFAULT NULL,
  `evemt_type` varchar(125) DEFAULT NULL,
  `operate_time` datetime DEFAULT NULL,
  `operator_id` varchar(50) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
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
  `certified_type` varchar(10) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
  `verify_date` datetime DEFAULT NULL,
  `verify_name` varchar(50) DEFAULT NULL,
  `verify_status` varchar(10) DEFAULT NULL,
  `company_address` varchar(125) DEFAULT NULL,
  `company_name` varchar(125) DEFAULT NULL,
  `enterprise_certify_id` varchar(50) DEFAULT NULL,
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
  `buss_code` varchar(20) NOT NULL,
  `buss_name` varchar(100) DEFAULT NULL,
  `type_code` varchar(20) NOT NULL,
  `type_name` varchar(100) DEFAULT NULL,
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
  `business_license_image` varchar(255) DEFAULT NULL,
  `certified_result` varchar(10) DEFAULT NULL,
  `company_address` varchar(125) DEFAULT NULL,
  `company_name` varchar(125) DEFAULT NULL,
  `customer_position` varchar(50) DEFAULT NULL,
  `failure_message` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT '',
  `suggest` varchar(255) DEFAULT NULL,
  `business_license_image_compress` varchar(255) DEFAULT NULL,
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
  `delivery_mode_desc` varchar(50) DEFAULT NULL,
  `delivery_mode_type` varchar(10) DEFAULT NULL,
  `goodsinfo_id` varchar(50) DEFAULT NULL,
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
  `color_name` varchar(16) DEFAULT NULL,
  `goodsinfo_id` varchar(50) DEFAULT NULL,
  `image_index` int(11) DEFAULT NULL,
  `image_type` varchar(10) DEFAULT NULL,
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
  `business_type` varchar(10) DEFAULT NULL,
  `car_brand_id` varchar(50) DEFAULT NULL,
  `car_brand_name` varchar(50) DEFAULT NULL,
  `car_master_brand_id` varchar(50) DEFAULT NULL,
  `car_master_brand_name` varchar(50) DEFAULT NULL,
  `car_model_id` varchar(50) DEFAULT NULL,
  `car_model_name` varchar(50) DEFAULT NULL,
  `car_style_id` varchar(50) DEFAULT NULL,
  `car_style_name` varchar(50) DEFAULT NULL,
  `contact_name` varchar(50) DEFAULT NULL,
  `contact_style` varchar(50) DEFAULT NULL,
  `departure_time` varchar(20) DEFAULT NULL COMMENT '发车时间',
  `deposit_ratio` decimal(19,2) DEFAULT NULL,
  `discount_price` decimal(19,2) DEFAULT NULL,
  `down_shelf_date` datetime DEFAULT NULL,
  `fare_bearer` varchar(10) DEFAULT NULL,
  `formalities` varchar(10) DEFAULT NULL,
  `garage_city_code` varchar(10) DEFAULT NULL,
  `garage_city_name` varchar(125) DEFAULT NULL,
  `goods_index` int(11) DEFAULT NULL,
  `goods_status` varchar(10) DEFAULT NULL,
  `guide_price` decimal(19,2) DEFAULT NULL,
  `invoice_type` varchar(10) DEFAULT NULL,
  `min_quantity` int(11) DEFAULT NULL,
  `payment_type` varchar(10) DEFAULT NULL,
  `release_time` datetime DEFAULT NULL,
  `remark` longtext,
  `sell_price` decimal(19,2) DEFAULT NULL,
  `up_shelf_date` datetime DEFAULT NULL,
  `vehicle_type` varchar(10) DEFAULT NULL,
  `payment_commission` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_goods_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `ba_goods_operate_log`;
CREATE TABLE `ba_goods_operate_log` (
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
  `evemt_type` varchar(125) DEFAULT NULL,
  `goods_id` varchar(50) DEFAULT NULL,
  `goods_status` varchar(255) DEFAULT NULL,
  `operate_time` datetime DEFAULT NULL,
  `operator_id` varchar(50) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
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
  `goodsinfo_id` varchar(50) DEFAULT NULL,
  `place_code` varchar(20) DEFAULT NULL,
  `place_name` varchar(50) DEFAULT NULL,
  `place_type` varchar(10) DEFAULT NULL,
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
  `code_type` varchar(200) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `verification_code` int(11) DEFAULT NULL,
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
  `buss_id` varchar(255) DEFAULT NULL,
  `buss_status_code` varchar(255) DEFAULT NULL,
  `log_type_code` varchar(20) DEFAULT NULL,
  `operate_time` varchar(20) DEFAULT NULL,
  `operator_id` varchar(50) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
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
  `approval_msg` varchar(255) DEFAULT NULL,
  `bank_account` varchar(125) DEFAULT NULL,
  `bank_name` varchar(125) DEFAULT NULL,
  `buyer_message` varchar(255) DEFAULT NULL,
  `company_address` varchar(125) DEFAULT NULL,
  `contact_phone` varchar(15) DEFAULT NULL,
  `delivery_mode_type` varchar(10) DEFAULT NULL,
  `end_total_price` decimal(19,2) DEFAULT NULL,
  `invoice_accepter_name` varchar(50) DEFAULT NULL,
  `invoice_accepter_phone` varchar(30) DEFAULT NULL,
  `invoice_address` varchar(255) DEFAULT NULL,
  `invoice_name` varchar(125) DEFAULT NULL,
  `invoice_post_code` varchar(20) DEFAULT NULL,
  `order_no` varchar(50) DEFAULT NULL,
  `start_total_price` decimal(19,2) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `tax_code` varchar(125) DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
  `vehicle_accepter_name` varchar(50) DEFAULT NULL,
  `vehicle_accepter_phone` varchar(30) DEFAULT NULL,
  `vehicle_address` varchar(255) DEFAULT NULL,
  `vehicle_post_code` varchar(20) DEFAULT NULL,
  `goods_total_price` decimal(19,2) DEFAULT NULL,
  `goodsinfo_id` varchar(50) DEFAULT NULL,
  `order_goods_info_id` varchar(50) DEFAULT NULL,
  `payment_commission` decimal(19,2) DEFAULT NULL,
  `unit_price` decimal(19,2) DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  `order_invoice_type` varchar(10) DEFAULT NULL,
  `order_taking_time` datetime DEFAULT NULL,
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
  `business_type` varchar(10) DEFAULT NULL,
  `car_brand_id` varchar(50) DEFAULT NULL,
  `car_brand_name` varchar(50) DEFAULT NULL,
  `car_master_brand_id` varchar(50) DEFAULT NULL,
  `car_master_brand_name` varchar(50) DEFAULT NULL,
  `car_model_id` varchar(50) DEFAULT NULL,
  `car_model_name` varchar(50) DEFAULT NULL,
  `car_style_id` varchar(50) DEFAULT NULL,
  `car_style_name` varchar(50) DEFAULT NULL,
  `contact_name` varchar(50) DEFAULT NULL,
  `contact_style` varchar(50) DEFAULT NULL,
  `departure_time` varchar(20) DEFAULT NULL COMMENT '发车时间',
  `deposit_payment_commission` decimal(19,2) DEFAULT NULL,
  `deposit_ratio` decimal(19,2) DEFAULT NULL,
  `discount_price` decimal(19,2) DEFAULT NULL,
  `down_shelf_date` datetime DEFAULT NULL,
  `fare_bearer` varchar(10) DEFAULT NULL,
  `formalities` varchar(10) DEFAULT NULL,
  `full_payment_commission` decimal(19,2) DEFAULT NULL,
  `garage_city_code` varchar(10) DEFAULT NULL,
  `garage_city_name` varchar(125) DEFAULT NULL,
  `goods_index` int(11) DEFAULT NULL,
  `goods_status` varchar(10) DEFAULT NULL,
  `guide_price` decimal(19,2) DEFAULT NULL,
  `invoice_type` varchar(10) DEFAULT NULL,
  `min_quantity` int(11) DEFAULT NULL,
  `payment_type` varchar(10) DEFAULT NULL,
  `release_time` datetime DEFAULT NULL,
  `remark` longtext,
  `sell_price` decimal(19,2) DEFAULT NULL,
  `up_shelf_date` datetime DEFAULT NULL,
  `vehicle_type` varchar(10) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  `payment_commission` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbtyndm91u2fetpkhxj4r9lwyv` (`order_id`),
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
  `child_order_no` varchar(50) DEFAULT NULL,
  `color_name` varchar(20) DEFAULT NULL,
  `goods_quantity` int(11) DEFAULT NULL,
  `order_no` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_order_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `ba_order_operate_log`;
CREATE TABLE `ba_order_operate_log` (
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
  `evemt_type` varchar(125) DEFAULT NULL,
  `operate_time` datetime DEFAULT NULL,
  `operator_id` varchar(50) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  `order_status` varchar(50) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
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
  `actual_departure_date` datetime DEFAULT NULL,
  `color_name` varchar(20) DEFAULT NULL,
  `predict_date` datetime DEFAULT NULL,
  `vehicle_status` varchar(10) DEFAULT NULL,
  `vehicle_id` varchar(50) DEFAULT NULL,
  `vin` varchar(50) DEFAULT NULL,
  `order_item_no` varchar(50) DEFAULT NULL,
  `upload_attachment` bit(1) DEFAULT b'0' COMMENT '是否已上传收车图片，默认没有',
  `actual_pick_date` datetime DEFAULT NULL,
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
  `businesscard_image` varchar(125) DEFAULT NULL,
  `certified_real_name` varchar(50) DEFAULT NULL,
  `certified_result` varchar(10) DEFAULT NULL,
  `customer_position` varchar(50) DEFAULT NULL,
  `failure_message` varchar(255) DEFAULT NULL,
  `idcard` varchar(50) DEFAULT NULL,
  `idcard_back_image` varchar(125) DEFAULT NULL,
  `idcard_front_image` varchar(125) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
  `suggest` varchar(255) DEFAULT NULL,
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
  `role_name` varchar(50) DEFAULT NULL,
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
  `item_code` varchar(125) DEFAULT NULL,
  `item_name` varchar(125) DEFAULT NULL,
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
  `role_id` varchar(50) DEFAULT NULL,
  `source_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ba_userinfo_update_log
-- ----------------------------
DROP TABLE IF EXISTS `ba_userinfo_update_log`;
CREATE TABLE `ba_userinfo_update_log` (
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
  `operate_time` datetime DEFAULT NULL,
  `operate_type` varchar(125) DEFAULT NULL,
  `operator_id` varchar(50) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
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
  `trading_identities` varchar(10) NOT NULL COMMENT '贸易身份，LS：零售，ALL:都是',
  `verify_status` varchar(2) DEFAULT '0' COMMENT '审核类型：0、未验证，1、验证通过，2、验证未通过',
  `passwd` varchar(200) NOT NULL COMMENT '加密以后的密码',
  `user_status` tinyint(1) DEFAULT '1' COMMENT '用户状态：0、锁定，1、正常',
  `contact_phone` varchar(15) DEFAULT NULL,
  `head_image` varchar(125) DEFAULT NULL,
  `introduction` varchar(125) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `wechat` varchar(50) DEFAULT NULL,
  `city_code` varchar(30) DEFAULT NULL,
  `city_name` varchar(30) DEFAULT NULL,
  `certified_company_name` varchar(125) DEFAULT NULL,
  `certified_real_name` varchar(50) DEFAULT NULL,
  `working_place` varchar(30) DEFAULT NULL COMMENT '公司地点',
  `registe_company_name` varchar(200) DEFAULT NULL,
  `registe_phone` varchar(11) DEFAULT NULL,
  `registe_real_name` varchar(50) DEFAULT NULL,
  `registe_trading_identities` varchar(10) DEFAULT NULL,
  `registe_working_place` varchar(30) DEFAULT NULL,
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
  `userinfo_id` varchar(50) NOT NULL COMMENT '用户id',
  `pwd_error_count` tinyint(1) DEFAULT '0' COMMENT '连续登陆错误次数',
  `lock_time` datetime DEFAULT NULL COMMENT '锁定截止时间',
  `phone` varchar(11) DEFAULT NULL,
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
  `role_id` varchar(50) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
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
  `accepter_name` varchar(50) DEFAULT NULL,
  `accepter_phone` varchar(50) DEFAULT NULL,
  `addr_type` varchar(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `post_code` varchar(50) DEFAULT NULL,
  `region_code` varchar(50) DEFAULT NULL,
  `region_name` varchar(125) DEFAULT NULL,
  `is_default` bit(1) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
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
  `bank_account` varchar(125) DEFAULT NULL,
  `bank_name` varchar(125) DEFAULT NULL,
  `company_address` varchar(125) DEFAULT NULL,
  `contact_phone` varchar(15) DEFAULT NULL,
  `invoice_name` varchar(125) DEFAULT NULL,
  `is_default` bit(1) DEFAULT NULL,
  `tax_code` varchar(125) DEFAULT NULL,
  `userinfo_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for car_demo
-- ----------------------------
DROP TABLE IF EXISTS `car_demo`;
CREATE TABLE `car_demo` (
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
  `brand` varchar(255) DEFAULT NULL,
  `plate_number` varchar(255) DEFAULT NULL,
  `vin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
