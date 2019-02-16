/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21-log : Database - ssm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，主键',
  `name` varchar(20) NOT NULL COMMENT '部门名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`id`,`name`,`create_time`,`update_time`) values (1,'测试部','2019-01-15 17:00:23','2019-01-15 17:00:23'),(2,'技术部','2019-01-15 17:00:28','2019-01-15 17:00:28'),(3,'财务部','2019-01-15 17:33:02','2019-01-15 17:33:02'),(4,'财务部','2019-01-15 17:33:56','2019-01-15 17:33:56'),(5,'财务部','2019-01-15 17:34:04','2019-01-15 17:34:04'),(12,'2121','2019-01-15 19:22:14','2019-01-15 19:22:14');

/*Table structure for table `staffs` */

DROP TABLE IF EXISTS `staffs`;

CREATE TABLE `staffs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id,主键',
  `number` varchar(20) NOT NULL COMMENT '编号',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `d_id` int(11) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`),
  KEY `d_id` (`d_id`),
  CONSTRAINT `staffs_ibfk_2` FOREIGN KEY (`d_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `staffs` */

insert  into `staffs`(`id`,`number`,`name`,`create_time`,`update_time`,`d_id`) values (2,'NO000001','张三','2019-01-15 17:00:44','2019-01-15 17:00:44',1),(3,'NO000002','李四','2019-01-15 17:01:01','2019-01-15 17:01:01',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
