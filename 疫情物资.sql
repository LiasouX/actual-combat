/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.36 : Database - zptc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zptc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zptc`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `category` varchar(11) DEFAULT NULL COMMENT '物资分类',
  `material` varchar(32) DEFAULT NULL COMMENT '物品名称',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `money` double DEFAULT NULL COMMENT '单价',
  `purse_name` varchar(32) DEFAULT NULL COMMENT '采购人员',
  `apply_name` varchar(32) DEFAULT NULL COMMENT '审核人员',
  `status` varchar(3) DEFAULT NULL COMMENT '报销状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`category`,`material`,`quantity`,`money`,`purse_name`,`apply_name`,`status`) values ('1','N95口罩',1000,5,'admin_cg','admin_hq','N'),('1','医用口罩',100000,0.5,'admin_cg','admin_hq','Y'),('2','医用酒精',5000,1.3,'admin_cg','admin_hq','Y'),('2','酒精棉球',10000,0.3,'admin_cg','admin_hq','Y'),('3','隔离服',10000,10,'admin_cg','admin_hq','N');

/*Table structure for table `intput` */

DROP TABLE IF EXISTS `intput`;

CREATE TABLE `intput` (
  `category` varchar(32) DEFAULT NULL COMMENT '物资分类',
  `material` varchar(255) DEFAULT NULL COMMENT '物资名称',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `money` double DEFAULT NULL COMMENT '单价',
  `purse_time` date DEFAULT NULL COMMENT '采购时间',
  `purse_name` varchar(32) DEFAULT NULL COMMENT '采购人员',
  `register_time` date DEFAULT NULL COMMENT '登记时间',
  `register_name` varchar(32) DEFAULT NULL COMMENT '登记人员'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `intput` */

insert  into `intput`(`category`,`material`,`quantity`,`money`,`purse_time`,`purse_name`,`register_time`,`register_name`) values ('1','N95口罩',1,5,'2021-02-28','admin_cg','2021-01-20','admin'),('1','医用口罩',100000,0.5,'2021-02-10','admin_cg','2021-02-18','admin_hq'),('2','医用酒精',5000,1.3,'2021-02-18','admin_cg','2021-02-18','admin_hq'),('2','酒精棉球',10000,0.3,'2021-02-18','admin_cg','2021-02-18','admin_hq');

/*Table structure for table `material_category` */

DROP TABLE IF EXISTS `material_category`;

CREATE TABLE `material_category` (
  `code` varchar(11) NOT NULL COMMENT '分类编码',
  `name` varchar(32) DEFAULT NULL COMMENT '分类名称',
  `description` varchar(32) DEFAULT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `material_category` */

insert  into `material_category`(`code`,`name`,`description`) values ('1','口罩','医用口罩'),('2','消毒液','医用酒精、酒精棉球、酒精棉签'),('3','防护套装','隔离服、N95口罩、内外手套、鞋套、护目镜'),('4','测温设备','红外测温仪、温度针');

/*Table structure for table `output` */

DROP TABLE IF EXISTS `output`;

CREATE TABLE `output` (
  `no` varchar(32) NOT NULL COMMENT '审领人编号（学生学号，员工工号）',
  `name` varchar(32) DEFAULT NULL COMMENT '申领人姓名',
  `category` varchar(11) DEFAULT NULL COMMENT '物资分类',
  `material` varchar(32) DEFAULT NULL COMMENT '物资名称',
  `quantity` int(11) DEFAULT NULL COMMENT '申领数量',
  `apply_time` date DEFAULT NULL COMMENT '申领时间',
  `apply_status` varchar(1) DEFAULT NULL COMMENT '申领状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `output` */

insert  into `output`(`no`,`name`,`category`,`material`,`quantity`,`apply_time`,`apply_status`) values ('1','张三','1','医用外科口罩',6,'2021-01-20','N'),('1','张三','3','防护服',130,'2021-01-20','Y'),('2','李四','1','医用防护口罩',1231645,'2021-01-20','Y'),('2','李四','3','隔离帽',4,'2021-02-14','N'),('4','赵六','3','医用防护口罩',6,'2021-02-14','Y'),('5','吴七','2','医用酒精',1012,'2021-01-20','N');

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `category` varchar(255) DEFAULT NULL COMMENT '物资分类',
  `material` varchar(255) DEFAULT NULL COMMENT '物资名称',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `price` double DEFAULT NULL COMMENT '单价',
  `time` date DEFAULT NULL COMMENT '采购时间',
  `name` varchar(32) DEFAULT NULL COMMENT '采购人员'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `purchase` */

insert  into `purchase`(`category`,`material`,`quantity`,`price`,`time`,`name`) values ('1','N95口罩',10,10,'2021-02-20','admin_cg'),('1','医用口罩',30,0.6,'2021-02-16','admin_cg'),('2','医用酒精',50,1.3,'2021-02-18','admin_cg'),('2','酒精棉球',10,0.3,'2021-02-18','admin_cg');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `type` varchar(11) DEFAULT NULL COMMENT '人员类型',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`type`,`username`,`password`,`sex`,`phone`) values ('管理员','admin','admin','男','12348825467'),('采购员','admin_cg','123','男','12312312343'),('财务处','admin_cw','123','男','21312312312'),('后勤处','admin_hq','123','女','21312312312'),('财务处','admin_hq10','1231','男','21312312312'),('后勤处','admin_hq2','123','女','21312312312'),('后勤处','admin_hq3','123','男','12312312323');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
