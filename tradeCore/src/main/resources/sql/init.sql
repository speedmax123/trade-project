USE TRADE_SYSTEM_VERSION_1_0_0;

############################################################################ for user

# user table
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `userType` BIGINT(20) NOT NULL COMMENT 'user type',
  `username` VARCHAR(255) NOT NULL COMMENT 'user name',
  `nickname` VARCHAR(255) COMMENT 'nickname',
  `email` VARCHAR(255) COMMENT 'email address',
  `IdNumber` VARCHAR(255) COMMENT 'id number',
  `cellPhone` VARCHAR(255) COMMENT 'cell phone number',
  `userStatus` BIGINT(20) NOT NULL COMMENT 'user status',
  `password` VARCHAR(255) NOT NULL COMMENT 'login password',
  `dealPwd` VARCHAR(255) NOT NULL COMMENT 'dealing password',
  `refereeId` BIGINT(20) NOT NULL COMMENT 'referee Id',
  `createTime` DATETIME NOT NULL COMMENT 'register time',
  `verifyTime` DATETIME NOT NULL COMMENT 'verify time',
  `lastLoginTime` DATETIME NOT NULL COMMENT 'last login time',
  `lastLoginIpAddress` VARCHAR(255) NOT NULL COMMENT 'last login ip address',
  `content` TEXT COMMENT 'personal statements'
  PRIMARY KEY (`id`),
  KEY `index_id` (`id`),
  KEY `index_referee_id` (`refereeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user table';

# user account table

# user attributes value table

DROP TABLE IF EXISTS `tbl_user_attributes`;

############################################################################ for trade record

# trade record table
DROP TABLE IF EXISTS `tbl_trade_record`;

############################################################################ for payment should be refactor

# payment gateway record
DROP TABLE IF EXISTS `tbl_payment_gateway_record`;

############################################################################ for

############################################################################ for both financial product and normal product

# product category
DROP TABLE IF EXISTS `tbl_product_category`;

# product table which contains all the product records
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE `tbl_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `prodTypeId` BIGINT(20) NOT NULL COMMENT 'product type',
  `productName` VARCHAR(255) NOT NULL COMMENT 'product name',
  `productCreateTime` DATETIME NOT NULL COMMENT 'product create time',
  `productModifyTime` DATETIME NOT NULL COMMENT 'product latest modify time',
  `productStatus` INT(20) NOT NULL DEFAULT '0' COMMENT 'product status, 0 pending, 1 activated, 2 deactivated',
  `productTitle` VARCHAR(255) NOT NULL COMMENT 'product title',
  `productDescription` TEXT NOT NULL COMMENT 'product description',
  `agentId` BIGINT(20) NOT NULL COMMENT 'agent Id',
  `version` BIGINT(20) NOT NULL DEFAULT '0' COMMENT 'optimistic lock',
  PRIMARY KEY (`id`),
  KEY `index_id` (`id`),
  KEY `index_prod_type_id` (`prodTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='product record table';


# product type, which shows product's type like p2p, funds, insurance'
DROP TABLE IF EXISTS `tbl_product_type`;
CREATE TABLE `tbl_product_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `productTypeName` VARCHAR(255) NOT NULL COMMENT 'product type name',
  `productTypeCreateTime` DATETIME NOT NULL COMMENT 'product type create time',
  `productTypeModifyTime` DATETIME NOT NULL COMMENT 'product type latest modify time',
  `productTypeStatus` INT(11) DEFAULT '0' COMMENT 'product type status 0 pending, 1 activated, 2 deactivated',
  PRIMARY KEY (`id`),
  KEY `index_id` (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='product type table';

# product attributes template, which shows all kinds of attributes available for product
DROP TABLE IF EXISTS `tbl_product_attributes_template`;
CREATE TABLE `tbl_product_attributes_template` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `prodAttrTplName` VARCHAR(255) NOT NULL COMMENT 'product attributes template name',
  `prodAttrTplType` VARCHAR(255) NOT NULL COMMENT 'product attributes template type',
  `prodTypeId` BIGINT(20) NOT NULL COMMENT 'product type id',
  `prodAttrTplCreateTime` DATETIME NOT NULL COMMENT 'product attributes create time',
  `prodAttrTplModifyTime` DATETIME NOT NULL COMMENT 'product attributes latest modify time',
  `prodAttrTplStatus` INT(11) DEFAULT '0' COMMENT 'product attributes type status: 0 pending, 1 activated, 2 deactivated',
  PRIMARY KEY (`id`),
  KEY `index_id` (`id`),
  KEY `index_prod_type_id` (`prodTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='product attributes template table';

# product attributes table, which contains all data mapping to product attributes template and product type
DROP TABLE IF EXISTS `tbl_product_attribute`;
CREATE TABLE `tbl_product_attribute` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `prodId` BIGINT(20) NOT NULL COMMENT 'product record id',
  `prodAttrName` VARCHAR(255) NOT NULL COMMENT 'product atrribute name',
  `prodAttrType` VARCHAR(255) NOT NULL COMMENT 'product attribute type',
  `prodAttrValue` VARCHAR(255) NOT NULL COMMENT 'product attribute value',
  `prodAttrCreateTime` DATETIME NOT NULL COMMENT 'product attribute create time',
  `prodAttrModifyTime` DATETIME NOT NULL COMMENT 'product attribute modify time',
  `prodAttrStatus` INT(20) DEFAULT '0' COMMENT 'product attribute status: 0 pending, 1 activated, 2 deactivated',
  PRIMARY KEY (`id`),
  KEY `index_id` (`id`),
  KEY `index_product_id` (`prodId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='product attribute table';


CREATE TABLE `test_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='test_user table';

DROP TABLE IF EXISTS `test_user_account`;
CREATE TABLE `test_user_account` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `amount_avaliable` DECIMAL(10, 2) DEFAULT '0.00' NOT NULL COMMENT 'user amount',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='test_user table';

DROP TABLE IF EXISTS `test_user_account_version`;
CREATE TABLE `test_user_account_version` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `amount_avaliable` DECIMAL(10, 2) DEFAULT '0.00' NOT NULL COMMENT 'user amount',
  `version` BIGINT(20) NOT NULL COMMENT 'optimistic lock version',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='test_user table version';


INSERT INTO `test_user` (firstName, lastName) VALUES ('Speed', 'Xu');

# find database isolation level
SELECT @@GLOBAL.tx_isolation, @@tx_isolation;