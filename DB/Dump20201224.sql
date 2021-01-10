-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 192.168.4.213    Database: hrm_ojt_ver1
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `create_by` bigint NOT NULL,
  `create_date` datetime(6) NOT NULL,
  `is_delete` tinyint(1) DEFAULT '0',
  `update_by` bigint NOT NULL,
  `update_date` datetime(6) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `employee_id` bigint NOT NULL,
  `role_id` bigint DEFAULT NULL,
  `last_modified_by` bigint DEFAULT NULL,
  `last_modified_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK211dk0pe7l3aibwce8yy61ota` (`employee_id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
  CONSTRAINT `FK211dk0pe7l3aibwce8yy61ota` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100058 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2000,2000,999,'2020-10-21 01:24:37.000000',1,2000,'2020-10-26 07:01:14.764000','$2a$10$xmpeYw329yULn7.VL3DOX.PIzHrV9XwxWNJXylMhtPF6Rj/UGS/u2','admin2000',2000,7008,NULL,NULL),(7000,7000,999,'2020-10-08 20:19:44.000000',0,999,'2020-10-08 20:19:44.000000','$2a$10$xmpeYw329yULn7.VL3DOX.PIzHrV9XwxWNJXylMhtPF6Rj/UGS/u2','login',7000,7000,NULL,NULL),(7001,7000,7000,'2020-10-13 03:18:57.130000',0,7001,'2020-10-21 01:22:19.021000','$2a$10$xmpeYw329yULn7.VL3DOX.PIzHrV9XwxWNJXylMhtPF6Rj/UGS/u2','admin',7029,7000,NULL,NULL),(7002,7000,7000,'2020-10-14 06:09:44.763000',0,7000,'2020-10-14 06:09:44.763000','$2a$10$mHn.yhl9DyAzvry3q10aEOA7XJsol3gEF8Nsmi/cdzrabhK9zHxw2','lq_giau',7002,7002,NULL,NULL),(7003,7000,7000,'2020-10-15 10:07:14.342000',0,7001,'2020-11-25 03:32:26.434000','$2a$10$tVv4M8Drhi6gwCEs4IUNU.IlDHVdsE0Ee1BYJqaX7llj.DCF8EL0O','dh_khanh',7059,7000,NULL,NULL),(7004,7000,7000,'2020-10-15 10:07:56.294000',0,7000,'2020-10-15 10:07:56.294000','$2a$10$3Jv6oGHuK6x.7bQENDYOvugLB7Y/53LAsy0xHhlDk4KIZxXm7CF8G','lm_hoang',7002,7002,NULL,NULL),(7005,7000,7000,'2020-10-16 02:50:54.969000',1,7000,'2020-10-16 02:50:54.969000','$2a$10$yZh9ZI2dUyk.UOHkavy94OtbL2FWVf5jKAYiq0xObPjBZ.PeoTtye','aa',7006,7000,NULL,NULL),(7006,7000,7001,'2020-10-16 07:34:45.201000',0,7006,'2020-11-12 08:01:48.299000','$2a$10$c5aNDjzGAPOGUVqDNk.q7.GXIcE.4jXvfApY4KI0icbl0dmN3MY8u','v_duy',7002,7000,NULL,NULL),(7007,7000,7001,'2020-10-16 09:42:26.371000',0,7007,'2020-12-02 08:59:24.084000','$2a$10$XwiaJALJavl1wtQqGgWj6ebsTIGCSYDxvxM95YBENY6FBQ5m/2.m2','baohung',7025,7000,NULL,NULL),(7008,7000,7001,'2020-10-19 04:30:23.812000',0,7001,'2020-10-21 01:22:04.137000','$2a$10$/xDtKRZc.vjf/2GPcuwT0uZ/cmFnHiJ6nsnuvcalAqSUrL2tVD4N6','lq_giau02',7004,7000,NULL,NULL),(7009,7000,7008,'2020-10-19 06:07:57.945000',1,7008,'2020-10-19 06:07:57.945000','$2a$10$EX7LGjykY5moWUzaWroFnOOiwnbG19rphcIM17MDSC/OxXXOAEwmm','031',7027,7000,NULL,NULL),(7010,7000,7008,'2020-10-19 06:44:03.215000',1,7008,'2020-10-19 06:44:44.890000','$2a$10$7UoQ8fWoWRn5otG7GywasekXwTgJMorO7mQ3nWYlmlfX//ORg7iJu','abcd',7002,7000,NULL,NULL),(7011,7000,7001,'2020-10-21 01:21:23.848000',0,7001,'2020-10-21 01:21:23.848000','$2a$10$mZgFhrfYwupY0/Ov8jegjuWlfi/UTqNWc3yhzn44mTq28ctvyS4qW','hung',7025,7000,NULL,NULL),(7012,7000,7001,'2020-10-21 01:25:46.878000',0,7001,'2020-10-21 01:25:46.878000','$2a$10$wBVrB5ksI6E2LtWNRFhOJ.umgcUSUS/dZVZTMVOq/0xv28jhk1IDu','tu',7004,7000,NULL,NULL),(7013,7000,7000,'2020-10-21 04:11:19.763000',0,7000,'2020-10-21 04:11:19.763000','$2a$10$Pu2tGuTIASN0u2Nm7d7LmuKtDDr6tAJrSU5AZHxDFOxAVXMNcV8pe','newuser',7003,7000,NULL,NULL),(7014,7000,7000,'2020-10-21 04:11:54.168000',0,7000,'2020-10-21 04:11:54.168000','$2a$10$JFzCZ.I0hNYe87mx7apNTuRAJToA37i0gGo5ib0pvd73sLB1S/2TG','user30',7030,7000,NULL,NULL),(7015,2000,2000,'2020-10-21 08:59:03.232000',0,7029,'2020-11-19 03:18:37.158000','$2a$10$O.bSOsBX08JcNNEyrtHrN.TCJjrgqOgd5VykPVrBuW0w4yai.YhOm','lm_hoang',2005,7024,NULL,NULL),(7016,7000,7001,'2020-10-21 10:27:24.883000',0,7001,'2020-10-21 10:27:24.883000','$2a$10$mLMAoXFpnsApbNK/DDP.wOQhW./HEtz87aPzmmSBF1As2/cUEwOZq','sds',7002,7000,NULL,NULL),(7017,7000,7001,'2020-10-21 10:27:34.950000',0,7001,'2020-10-21 10:27:34.950000','$2a$10$U7.kmJEThXa7/Xv1jXac9Ozfs.6x3md8bhtb82uj3426/WYgIVyaS','ee',7003,7000,NULL,NULL),(7018,7000,7001,'2020-10-21 10:27:45.678000',0,7001,'2020-10-21 10:27:45.678000','$2a$10$FNG8mFL8bBUpzSmeJ0AiFOuLzIyd3JDDfvW9GF1Nx469sL68GSzVO','r',7004,7000,NULL,NULL),(7019,2000,2000,'2020-10-22 03:26:47.289000',0,7029,'2020-11-19 03:18:24.220000','$2a$10$4vEzSaCQFfs/sEHeipxgLe2VuO69PjQFfVkzjd5e828s/FSQMaFKa','dh_khanh',2003,7024,NULL,NULL),(7020,2000,2000,'2020-10-23 06:50:46.319000',0,7029,'2020-11-19 03:20:31.078000','$2a$10$iMFDEn.gpgYx//UTPToqwO8Q1tpqJl5VHXW8H5JvzoxqLOXpvFu32','nvn_tan',2004,7024,NULL,NULL),(7021,7000,7000,'2020-10-26 06:49:23.484000',0,7000,'2020-10-26 06:49:23.484000','$2a$10$KrprZp97ES6rFNyTkp15Wu4LOZb8r9NzZmqL2MP7dUok6gig8Uj62','c_dinh',7000,7002,NULL,NULL),(7022,2000,7019,'2020-10-26 08:16:35.440000',0,7029,'2020-11-19 03:20:53.826000','$2a$10$/ybL53nPdKCsZ1puxUTuL.woX7lZXOdf.JFeKPo44oMMUuqC85g4O','v_duy',2008,7024,NULL,NULL),(7023,2000,7019,'2020-10-26 08:55:18.061000',0,7029,'2020-11-19 03:13:47.363000','$2a$10$6ntnKlb6xvF5sEik4M6G9ONDGz6hgNpMGbVFF21T4TjqIPQMaMmxS','admin',2007,7024,NULL,NULL),(7024,2000,7023,'2020-10-26 09:05:17.481000',1,7023,'2020-10-26 09:09:53.706000','$2a$10$mz/ScytFKtmWtlyAK7jsFOAAwHAHg6sZDNyY887Huw/DH9G82QHIC','lq_giau',7046,7009,NULL,NULL),(7025,2000,7023,'2020-10-26 09:14:58.938000',0,7023,'2020-10-27 06:23:54.480000','$2a$10$ppqtjnKIIKI8bYSpSteW4.Pr3chIiNU/OHeSMlitSyplt/R5QdW9m','lq_giau01',7046,7008,NULL,NULL),(7026,2000,7023,'2020-10-26 09:19:33.069000',0,7023,'2020-10-27 06:23:45.959000','$2a$10$uIS472bVKvL9kMbqz53mqeFXZI31c8YTg30OyB.QEhsVvOGUs.SNK','n_tu',2009,7008,NULL,NULL),(7027,2000,7023,'2020-10-26 09:20:22.361000',0,7029,'2020-11-19 03:20:20.887000','$2a$10$w7MzMGqk4lpcOp9JNFXud.1VRDu6zy2W0zIocagH4c9IbAjv1wNzq','n_suu',2006,7024,NULL,NULL),(7028,2000,7023,'2020-10-26 09:21:41.711000',0,7023,'2020-10-26 09:21:41.711000','$2a$10$D.CzEIZOgMUfGn5JaTPey.oEviaKu1rQQc0JKeLE4GBQ7SY7l5fwa','manager',2000,7010,NULL,NULL),(7029,2000,7023,'2020-10-27 06:30:16.101000',0,7029,'2020-11-19 03:20:38.105000','$2a$10$z4nnuN2kTVWIZvMS3wvvouDL5upRR764eKHUZRwPqfpG0DPQd3UwK','nxt_an',2007,7024,NULL,NULL),(7030,2000,7023,'2020-10-27 07:52:52.973000',0,7029,'2020-11-19 03:18:42.763000','$2a$10$wCiU8lq0RZPt8KsCQSaXSucZP0RSoE0ZpkgCznc/JrE8ZF/mGT7YC','login',2005,7024,NULL,NULL),(7031,7000,7006,'2020-10-27 07:58:22.627000',0,7006,'2020-10-27 07:58:22.627000','$2a$10$pXUkZEF0mjbjfQtA1dDI2O3ErsorXFl28vouy8r012JOAR.LoG5sO','v_duy_tm',7003,7000,NULL,NULL),(7032,7000,7006,'2020-10-27 08:01:17.795000',0,7031,'2020-11-12 08:00:34.737000','$2a$10$87XggOs.PSqfKR572cE/hOYO0EsMLky1YSNDCs99aX5b0Svr6U2OG','v_duy_ga',7060,7000,NULL,NULL),(7033,7000,7001,'2020-10-29 08:42:27.023000',0,7033,'2020-12-01 07:52:43.406000','$2a$10$FP5d4u5emz2Kg8mxqPFNuOKegT1cBEm7/R4TibVrbrTnWovsfkRGq','a_thu',7047,7000,NULL,NULL),(7034,2000,7023,'2020-11-04 03:08:13.637000',0,7029,'2020-11-19 03:20:59.879000','$2a$10$3tPaw40WMhgpekis/D46n.bL.2KMoMx72bRslWVBRYLbEdDcZjY1O','v_duy2',2008,7024,NULL,NULL),(7035,2000,7023,'2020-11-05 06:22:51.300000',0,7029,'2020-11-19 03:18:08.397000','$2a$10$SoCQjlJ/5qcP3Y2wViHW5O24ZPNMYYMlgCDLPQs7ENpPrjFtYbVc.','a_thu',7063,7024,NULL,NULL),(7037,2000,7023,'2020-11-09 02:46:38.185000',0,7023,'2020-11-17 01:41:15.063000','$2a$10$icW0GdcoA5t/a7eo4MjM5.bzUYFn/L/DSMJEVDyhHMMl25lR1b0ea','lq_giau02',7056,7009,NULL,NULL),(7038,2000,7023,'2020-11-10 01:13:17.823000',0,7029,'2020-11-19 03:20:12.940000','$2a$10$/z.Kmp.e2B4khe7KZRb4Yee1nrJ25jLmphj31qXyHkp3IHWMbVGee','lq_giau0203',7063,7024,NULL,NULL),(7039,2000,7023,'2020-11-10 02:06:19.744000',1,7023,'2020-11-10 02:06:19.744000','$2a$10$/UBmsPe5atYKTu/BTmMBhO/zom8YxL2sNOaBU3sM1bgc09UnZHnya','refr',7064,7008,NULL,NULL),(7040,2000,7023,'2020-11-10 02:27:44.845000',0,7023,'2020-11-10 02:29:23.666000','$2a$10$adNKv/mRNU9cbNJTDdjBgeY6FGcYqkj55BIEiSEzSOMmif5X2ohDu','giau8898',7063,7009,NULL,NULL),(7041,2000,7023,'2020-11-10 02:31:03.173000',0,7029,'2020-11-19 03:18:31.762000','$2a$10$lgRTEmB0ORvxAsQ7gbCSO.o5bYhilp..4D4s1V6WEMKLBPu9tGUku','khanh999',7061,7024,NULL,NULL),(7042,2000,7023,'2020-11-10 03:04:31.344000',0,7023,'2020-11-10 03:05:14.499000','$2a$10$gf5KDPbEedz6WtN9re9GNuCEjpslV7tu/YBe00gxtxpDwopeTRJxm','tuonglam',7056,7009,NULL,NULL),(7043,2000,7023,'2020-11-12 01:55:47.980000',0,7029,'2020-11-19 03:20:45.748000','$2a$10$eKn54uZ4fkBUG3UZgMq8cOMgp.LjiO7ie1oGm5Mg9ZbEfYauOxaim','rfr',7055,7024,NULL,NULL),(7044,7000,7006,'2020-11-16 06:07:31.959000',0,7006,'2020-11-16 06:07:31.959000','$2a$10$ow9ZXz.DPw6Q0j6OFBbNhe7w13orglG.p42824OrENXF8asQnYeAy','v_duy_mb',7058,7000,NULL,NULL),(7045,2000,7035,'2020-11-16 10:08:05.163000',0,7029,'2020-11-19 03:18:12.953000','$2a$10$e//QUqe/OeN9YnmoqruRBecn0C1nFjpUSQiKtpc2NNWI3iUYxSUTu','a_thu2',7072,7024,NULL,NULL),(7046,7000,7001,'2020-11-17 01:37:33.008000',0,7001,'2020-11-17 01:37:33.008000','$2a$10$3fzz0cl7m9K3gTNOIgmvK.sRd.WBh5SSeZLwXUot2NWlJZfrXTKgW','giau',7002,7002,NULL,NULL),(7047,7000,7001,'2020-11-17 02:03:50.115000',0,7001,'2020-11-17 02:03:50.115000','$2a$10$8mh5fugXp6XvdqQ9lhgfv.uCRtSc/X5F.nn6OsLqeCyqwEIj.NxIq','d_phuong',7073,7000,NULL,NULL),(7048,7000,7001,'2020-11-17 02:04:06.489000',0,7001,'2020-11-17 02:04:06.489000','$2a$10$dwhLjMRYA9uqp6hevJ8aPeps.aLt5pOKKBgXUb/gFxwhJNXriTqJC','d_phuong2',7074,7000,NULL,NULL),(7049,2000,7045,'2020-11-17 03:55:47.699000',0,7029,'2020-11-19 03:18:17.831000','$2a$10$LptBLmJyD/7e0fsJ7Fkom..L9e3KPtc7qwQAwzTiCOnHhko/P9ncS','a_thu3',7075,7024,NULL,NULL),(7050,7000,7033,'2020-11-17 06:21:11.006000',0,7033,'2020-11-17 06:21:11.006000','$2a$10$YgIzYMN0pQuxuNKzV8d93uBH2KH/yBt31wshW7VIJdE5yK/uDFDNy','a_thu2',7076,7000,NULL,NULL),(7051,7000,7033,'2020-11-17 06:22:00.378000',0,7033,'2020-11-17 06:22:00.378000','$2a$10$19N0LsPCY9R8vVMV9pViHOTybjinc1ps7JsClGoIoCYe8ZkVgpkga','a_thu3',7077,7000,NULL,NULL),(9999,4000,999,'2020-11-23 13:43:28.000000',1,10000,'2020-12-04 07:00:44.211000','$2a$10$xmpeYw329yULn7.VL3DOX.PIzHrV9XwxWNJXylMhtPF6Rj/UGS/u2','admin4000',10001,10000,NULL,NULL),(10000,4000,9999,'2020-11-24 06:37:54.582000',0,9999,'2020-11-24 06:37:54.582000','$2a$10$inWD4l0PCOZ.zduP0iTGsuPdlF8kn.QCaWm61Ik.GskkqlXnZD4La','admin',9999,10000,NULL,NULL),(10001,4000,10000,'2020-11-25 02:30:43.867000',0,10000,'2020-12-07 10:53:47.591000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','lq_giau',10001,10000,NULL,NULL),(10002,4000,9999,'2020-11-30 03:46:26.045000',0,9999,'2020-11-30 03:46:26.045000','$2a$10$uu3hrvCE6qKR74H6cewVb..RanhU0jCRujQju2SsHev3LFCSMsKUm','nvn_tan',4004,10000,NULL,NULL),(10003,4000,9999,'2020-11-30 03:46:43.122000',0,9999,'2020-11-30 03:46:43.122000','$2a$10$yAlTR042ZtRFi5XQplVHNeTYHwagMYQbPvTM4kACV2U0wfDACnRfW','lm_hoang',4005,10000,NULL,NULL),(10004,4000,9999,'2020-11-30 03:47:06.313000',0,9999,'2020-11-30 03:47:06.313000','$2a$10$0vu/AdQ5mS6pdF/vSn9AserMaExDqg8hZow73DH0JWh8o4lWaIsqS','n_suu',4006,10000,NULL,NULL),(10005,4000,9999,'2020-11-30 03:47:25.230000',0,9999,'2020-11-30 03:47:25.230000','$2a$10$4zr6pKe99Odn.qPyLU2Ym.cIOhCMRGSxgVtDrX2eTpdeqxugJtLye','dh_khanh',4003,10000,NULL,NULL),(10006,4000,9999,'2020-11-30 03:47:45.013000',0,9999,'2020-11-30 03:47:45.013000','$2a$10$ZWiRsQbKPhObwjOUR2mrpe1KPGC/1dgClIpNjluhDUoRa4o5ndbbm','nxt_an',4007,10000,NULL,NULL),(10007,4000,9999,'2020-11-30 03:48:20.463000',0,10000,'2020-12-09 03:17:15.601000','$2a$10$x9A7W9cAlp7pa8nCKJPRwuynnkzlSz79NacirtvVB4kcmpIbiedJC','v_duy',4008,10000,NULL,NULL),(10008,4000,10001,'2020-11-30 04:15:48.105000',0,10001,'2020-11-30 04:15:48.105000','$2a$10$vZk13Q2kdCoaXCYA75JJx.rcQty04dgAB21FQjZrtiEmZ94ij0qt6','nc_nghi',9999,10000,NULL,NULL),(10009,4000,10001,'2020-11-30 04:17:20.782000',0,10001,'2020-11-30 04:17:20.782000','$2a$10$BbeafMtr91a9UyIvIdM.n.Y9wXFSe3Ovjnp6j56CufU1zTS7ICISa','n_dinh',4001,10000,NULL,NULL),(10010,2000,7049,'2020-11-30 06:29:29.629000',0,7049,'2020-11-30 06:29:29.629000','$2a$10$6QH6DbVMi.f25yNUgoboaepDnSNFacUN7lFW2JrNR7bOVtyerER.a','h_trang',10002,7024,NULL,NULL),(10011,7000,7051,'2020-11-30 06:32:32.900000',0,7051,'2020-11-30 06:32:32.900000','$2a$10$OdBMwliMiF6/ELxGTKRx9.1CWIjc65ruBjpIRS4jj70UbQy.u3Q2K','h_trang',10003,7000,NULL,NULL),(10012,4000,10005,'2020-12-01 06:35:28.082000',0,10005,'2020-12-01 06:35:28.082000','$2a$10$V3rbAEmH.K3qlJOAmZpjsOI7KKKA0YXDGg3DT7WVrSZrO1i0mH4ZC','v_hung',10006,10000,NULL,NULL),(10013,4000,10001,'2020-12-01 09:25:51.812000',0,10001,'2020-12-01 09:25:51.812000','$2a$10$CcShAvr8xKYGbUfbt.zS0OtKVCQ95KPHrEqmIAM.KD29Yg96bCPoG','member',10001,10003,NULL,NULL),(10014,4000,10000,'2020-12-04 06:59:17.017000',0,10014,'2020-12-08 10:30:14.228000','$2a$10$5DjQVeh5rsnMe7GOzjo6mu1u9Psy.2Yjrfr0b40JZAJo4yfsJWMJ2','th_trung',10008,10002,NULL,NULL),(10015,4000,10000,'2020-12-04 06:59:43.253000',0,10000,'2020-12-04 06:59:43.253000','$2a$10$Y5CtnpIWmUrEzdwmidsZueGUwa6jEyB1E5pudenlEKcJmdw5AZcTG','px_tuan',10007,10000,NULL,NULL),(10016,4000,10000,'2020-12-07 02:22:33.313000',0,10000,'2020-12-07 02:22:33.313000','$2a$10$bUekR5vex33fD90a8mKE2e2y68lWpUMFEvLsCkDtlG3wTFUDYZOuu','n_tu',4009,10003,NULL,NULL),(10017,4000,10005,'2020-12-07 03:06:46.795000',0,10005,'2020-12-07 03:06:46.795000','$2a$10$3l37lpoDZkPtfweryWM3zeQdppQZPlEdNCtPwixbT7YmonuFW.Jza','vdl_huong',4110,10000,NULL,NULL),(10018,4000,10000,'2020-12-07 10:55:18.618000',1,10000,'2020-12-07 10:57:38.179000','$2a$10$L.eRuDzBwNyIMLoL2/KBpOhqHan11oWf5ingq42Kq2esnyOT1Lhi2','lv_hung',10006,10000,NULL,NULL),(10019,4000,10000,'2020-12-07 10:59:14.376000',0,10000,'2020-12-09 02:37:55.340000','$2a$10$6c32ruaYMI7jgnlCeZP81Odn6jsgYz68LjMJ3dcOwCyzdY2eJGOK.','nm_hieu',4131,10003,NULL,NULL),(10020,4000,10000,'2020-12-08 02:38:53.024000',1,10000,'2020-12-08 02:39:03.431000','$2a$10$BcjBptWTJprwLTCbMZR/Pu0H.ABVVgVD/3WzomOyAoTj9OauwLqM6','hth_thoa',4134,10000,NULL,NULL),(100021,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','lvq_vu',4216,10000,NULL,NULL),(100022,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','nn_anh',4215,10000,NULL,NULL),(100023,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:44:42.043000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','n_hung',4214,10003,NULL,NULL),(100024,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:40:07.858000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','lq_don',4213,10003,NULL,NULL),(100025,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:39:05.424000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','tv_thanh',4212,10003,NULL,NULL),(100026,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:34:34.156000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','nb_hung',4211,10003,NULL,NULL),(100027,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:39:17.095000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','tn_my',4141,10003,NULL,NULL),(100028,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','hk_trong',4140,10000,NULL,NULL),(100029,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','hvn_duy',4139,10000,NULL,NULL),(100030,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','hv_tuan',4138,10000,NULL,NULL),(100031,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','lvh_vu',4137,10000,NULL,NULL),(100032,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:39:54.353000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','ha_bao',4136,10003,NULL,NULL),(100033,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','nnh_tien',4135,10000,NULL,NULL),(100034,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','hth_thoa',4134,10000,NULL,NULL),(100035,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:40:18.028000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','nt_linh',4133,10003,NULL,NULL),(100036,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:40:28.281000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','tc_son',4132,10003,NULL,NULL),(100038,4000,999,'2020-12-09 09:30:54.000000',0,10000,'2020-12-09 02:40:37.798000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','tvg_tai',4128,10003,NULL,NULL),(100039,4000,999,'2020-12-09 09:30:54.000000',0,999,'2020-12-09 09:30:54.000000','$2a$10$HT/m5BqHEqyktFZJieNxoufaJ7Wwcg8wfGfwX53nbpRoeL8nF3IbO','lv_hung',10006,10000,NULL,NULL),(100040,4000,10000,'2020-12-09 02:35:01.538000',0,10000,'2020-12-09 02:35:01.538000','$2a$10$DzvmHCr0cW/3CiTwZNvR/eFi6acjBpbbBxn7yRCxi5zEr1QktpgJC','nta_thu',4119,10003,NULL,NULL),(100041,4000,10000,'2020-12-09 02:35:30.599000',0,10000,'2020-12-09 02:35:30.599000','$2a$10$moLr.Nz6D8oeHKQyIt49k.8l0/LkAZp6zQ5DT8T6W4mlUbJ5HVr0G','hnd_phuong',4118,10003,NULL,NULL),(100042,4000,10000,'2020-12-09 02:35:56.263000',0,10000,'2020-12-09 02:35:56.263000','$2a$10$RF4u6Jt6.c6fNRrMaLkkquJGNeLRP.jF7A.FmiNJH/1cKglHrI.Uu','tvq_huy',4129,10003,NULL,NULL),(100043,4000,10000,'2020-12-09 02:38:27.388000',0,10000,'2020-12-09 02:38:27.388000','$2a$10$r3dlKiyZk1uNApMZgycE1uMQXwJStJCpuhAhwbalg7URR2oaKkXKW','tq_anh',4127,10003,NULL,NULL),(100044,4000,10000,'2020-12-09 02:38:51.604000',0,10000,'2020-12-09 02:38:51.604000','$2a$10$mvKFoqzPOf6Fj4vQpQTAd.AyG9ZhyEJeCS3TXmrjFnmvJRaU.5Hze','dn_hoai',4115,10003,NULL,NULL),(100045,4000,10000,'2020-12-09 02:39:42.316000',0,10000,'2020-12-09 02:39:42.316000','$2a$10$V8q/8m7Z7tRNFsAETGJzjeMgCbryVIlwWlcUwCZk5dxwXwXXksFXu','ncv_my',4126,10003,NULL,NULL),(100046,4000,10000,'2020-12-09 02:40:59.256000',0,10000,'2020-12-09 02:40:59.256000','$2a$10$UpynMWFfS87wQENqYQGhFOFSpzsB0a33kG6OCxCdqTtpRm2pJ4NV.','lb_mui',4100,10003,NULL,NULL),(100047,4000,10000,'2020-12-09 02:41:30.198000',0,10000,'2020-12-09 02:41:30.198000','$2a$10$n280/lJToIpDDcsOuThKv.rRaOyRBaqiZ5DhnyC7eoXtWIdB.PGHa','dt_hieu',4101,10003,NULL,NULL),(100048,4000,10000,'2020-12-09 02:41:55.764000',0,10000,'2020-12-09 02:41:55.764000','$2a$10$2qxs0rJNgMo7pBsgXtGOLOL2EJmLuNihIBSFQsk2UZBtToCWVsSla','lt_nghia',4104,10003,NULL,NULL),(100049,4000,10000,'2020-12-09 02:42:20.740000',0,10000,'2020-12-09 02:42:20.740000','$2a$10$BEvHUdxyUxMcqHAWcsv.cOlKv2TfzjB1Cm6LM.O1XebDKqqUgz3Ke','ntu_nhi',4002,10003,NULL,NULL),(100050,4000,10000,'2020-12-09 02:43:01.151000',0,10000,'2020-12-09 02:43:01.151000','$2a$10$fAymiDegkd867t0UVfl/muYAjVkTfN5S8TF.gZIICIPECM3vVp/9G','ntk_thoa',4010,10003,NULL,NULL),(100051,4000,10000,'2020-12-09 02:43:26.670000',0,10000,'2020-12-09 02:43:26.670000','$2a$10$doxEW89SKusmafaN5W51HOx0b3pPsHFEeKNy7kJBv8Z4eC.fLu0tK','mxb_minh',4105,10003,NULL,NULL),(100052,4000,10000,'2020-12-09 02:43:51.783000',0,10000,'2020-12-09 02:43:51.783000','$2a$10$IEBRU8.i.Y7LZLIx0uVGeeA8.1J/.cgDqPdiWPUcDmE7aYvqgxZ7S','dv_hien',4102,10003,NULL,NULL),(100053,4000,10000,'2020-12-09 02:44:20.009000',0,10000,'2020-12-09 02:44:20.009000','$2a$10$ZrQCTuAT5Wgmq4sSyDGMSunEC.8DscpXN3LOHo0cmNTBDsffz5rnS','nv_quoc',4106,10003,NULL,NULL),(100054,4000,10000,'2020-12-09 02:45:12.934000',0,10000,'2020-12-09 02:45:12.934000','$2a$10$L61yftrS6bOM.UxnwuIpY.JLmbfQsWfcZWMxaYc9TtClGBPg7FXBO','db_quy',4114,10003,NULL,NULL),(100055,4000,10000,'2020-12-09 02:45:44.462000',0,10000,'2020-12-09 02:45:44.462000','$2a$10$A60Y.PoEgLCQxrkuf903UenYBD5BhdwvS8KdtlIW/azka0WlnvDaC','lvv_quoc',4216,10003,NULL,NULL),(100056,4000,10001,'2020-12-23 01:05:15.589000',0,10001,'2020-12-23 01:07:25.076000','$2a$10$MSaWH4swXtloF7bqGnPgpectnaLwb065FQ84su6xpV56jWwMNBZaS','hd_toan',4112,10000,NULL,NULL),(100057,4000,100056,'2020-12-23 09:11:16.509000',0,100056,'2020-12-23 09:11:16.509000','$2a$10$MO8/3JNtx83uMCW12tFWR.a47L9Oc6TmOwxvbDzZTbuabCsjlMMNi','lm_tuan',4111,10000,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-24 14:23:06