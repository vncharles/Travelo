-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: travelo-app
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` enum('ROLE_ADMIN','ROLE_STAFF','ROLE_USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','ROLE_ADMIN'),(2,'user','ROLE_USER'),(3,'staff','ROLE_STAFF');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_booking`
--

DROP TABLE IF EXISTS `t_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `number_person` int DEFAULT NULL,
  `status` enum('CANCEL','DONE','NEW','PAID','UNPAID') DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `staff_id` bigint DEFAULT NULL,
  `tour_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5xqcpu5o0jfqk1ck4j1d55jwi` (`customer_id`),
  KEY `FKmhihmw9rfnbtako2hqehr3o3e` (`staff_id`),
  KEY `FKipi2lwbwe45wo76x6x5ad1tab` (`tour_id`),
  CONSTRAINT `FK5xqcpu5o0jfqk1ck4j1d55jwi` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FKipi2lwbwe45wo76x6x5ad1tab` FOREIGN KEY (`tour_id`) REFERENCES `t_tour` (`id`),
  CONSTRAINT `FKmhihmw9rfnbtako2hqehr3o3e` FOREIGN KEY (`staff_id`) REFERENCES `t_staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_booking`
--

LOCK TABLES `t_booking` WRITE;
/*!40000 ALTER TABLE `t_booking` DISABLE KEYS */;
INSERT INTO `t_booking` VALUES (39,'2023-01-03',5,'DONE',15000000,1,1,1),(40,'2023-11-29',3,'UNPAID',9000000,2,1,2),(41,'2023-01-03',6,'DONE',18000000,3,1,3),(42,'2023-01-03',4,'DONE',12000000,4,4,4),(43,'2023-01-05',2,'DONE',6000000,5,3,5),(44,'2023-01-06',5,'DONE',15000000,6,8,6),(45,'2023-01-07',3,'DONE',9000000,7,7,7),(46,'2023-11-15',6,'PAID',18000000,8,7,8),(47,'2023-11-16',4,'CANCEL',12000000,9,9,9),(48,'2023-11-17',2,'PAID',6000000,10,3,10),(49,'2023-01-07',3,'DONE',9000000,7,8,6),(50,'2023-01-08',5,'DONE',15000000,2,5,7),(51,'2023-11-16',2,'CANCEL',6000000,3,3,9),(52,'2023-11-20',6,'PAID',18000000,10,3,10),(53,'2023-01-04',5,'DONE',15000000,3,4,1),(54,'2023-11-30',3,'UNPAID',9000000,7,4,2),(55,'2023-01-04',6,'DONE',18000000,5,7,3),(56,'2023-01-03',4,'DONE',12000000,6,9,4),(57,'2023-01-05',2,'DONE',6000000,4,6,5);
/*!40000 ALTER TABLE `t_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer`
--

DROP TABLE IF EXISTS `t_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8ih0gjupm00mksrnjgwexrmmu` (`user_id`),
  CONSTRAINT `FK2ql1crfdbg9r694mss1t3bt1w` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer`
--

LOCK TABLES `t_customer` WRITE;
/*!40000 ALTER TABLE `t_customer` DISABLE KEYS */;
INSERT INTO `t_customer` VALUES (1,'Hà Nội','nguyenvana@example.com','Nguyễn Văn A','0987654321',NULL),(2,'Hồ Chí Minh','tranthib@example.com','Trần Thị B','0123456789',NULL),(3,'Đà Nẵng','levanc@example.com','Lê Văn C','0909090909',NULL),(4,'Hải Phòng','phamthid@example.com','Phạm Thị D','0999888777',NULL),(5,'Quảng Ninh','hoangve@example.com','Hoàng Văn E','0888777666',NULL),(6,'Thanh Hóa','dothif@example.com','Đỗ Thị F','0777666555',NULL),(7,'Nghệ An','nguyenvang@example.com','Nguyễn Văn G','0666555444',NULL),(8,'Hà Tĩnh','lythih@example.com','Lý Thị H','0555444333',NULL),(9,'Thừa Thiên-Huế','truongvani@example.com','Trương Văn I','0444333222',NULL),(10,'Bình Định','maithik@example.com','Mai Thị K','0333222111',NULL);
/*!40000 ALTER TABLE `t_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer_bookings`
--

DROP TABLE IF EXISTS `t_customer_bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_customer_bookings` (
  `customer_id` bigint NOT NULL,
  `bookings_id` bigint NOT NULL,
  UNIQUE KEY `UK_cafbms7n8o232cf7c08ecv4hx` (`bookings_id`),
  KEY `FKbxq4amefo5k1amjb4jomhn2it` (`customer_id`),
  CONSTRAINT `FKbxq4amefo5k1amjb4jomhn2it` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`),
  CONSTRAINT `FKhdws6gernfyst6us7j0a8xk61` FOREIGN KEY (`bookings_id`) REFERENCES `t_booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer_bookings`
--

LOCK TABLES `t_customer_bookings` WRITE;
/*!40000 ALTER TABLE `t_customer_bookings` DISABLE KEYS */;
INSERT INTO `t_customer_bookings` VALUES (1,39),(2,40),(2,50),(3,41),(3,51),(3,53),(4,42),(4,57),(5,43),(5,55),(6,44),(6,56),(7,45),(7,49),(7,54),(8,46),(9,47),(10,48),(10,52);
/*!40000 ALTER TABLE `t_customer_bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_image`
--

DROP TABLE IF EXISTS `t_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_uri` varchar(255) DEFAULT NULL,
  `tour_info_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKues2b17rln02m39yf8pghl7h` (`tour_info_id`),
  CONSTRAINT `FKues2b17rln02m39yf8pghl7h` FOREIGN KEY (`tour_info_id`) REFERENCES `t_tour_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_image`
--

LOCK TABLES `t_image` WRITE;
/*!40000 ALTER TABLE `t_image` DISABLE KEYS */;
INSERT INTO `t_image` VALUES (1,'http://localhost:8084/image/halong1.png',1),(2,'http://localhost:8084/image/halong2.png',1),(3,'http://localhost:8084/image/halong3.png',1),(4,'http://localhost:8084/image/thacbangioc1.png',2),(5,'http://localhost:8084/image/thacbangioc2.png',2),(6,'http://localhost:8084/image/thacbangioc3.png',2),(7,'http://localhost:8084/image/dongnai1.png',3),(8,'http://localhost:8084/image/dongnai2.png',3),(9,'http://localhost:8084/image/dongnai3.png',3),(10,'http://localhost:8084/image/dalat1.png',4),(11,'http://localhost:8084/image/dalat2.png',4),(12,'http://localhost:8084/image/dalat3.png',4),(13,'http://localhost:8084/image/quynhon1.png',5),(14,'http://localhost:8084/image/quynhon2.png',5),(15,'http://localhost:8084/image/quynhon3.png',5),(16,'http://localhost:8084/image/buonmethuot1.png',6),(17,'http://localhost:8084/image/buonmethuot2.png',6),(18,'http://localhost:8084/image/buonmethuot3.png',6),(19,'http://localhost:8084/image/phuquoc1.png',7),(20,'http://localhost:8084/image/phuquoc2.png',7),(21,'http://localhost:8084/image/phuquoc3.png',7),(22,'http://localhost:8084/image/danang1.png',8),(23,'http://localhost:8084/image/danang2.png',8),(24,'http://localhost:8084/image/danang3.png',8),(25,'http://localhost:8084/image/chaudoc1.png',9),(26,'http://localhost:8084/image/chaudoc2.png',9),(27,'http://localhost:8084/image/chaudoc3.png',9),(28,'http://localhost:8084/image/vungcaodalat1.png',10),(29,'http://localhost:8084/image/vungcaodalat2.png',10),(30,'http://localhost:8084/image/vungcaodalat3.png',10);
/*!40000 ALTER TABLE `t_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_location`
--

DROP TABLE IF EXISTS `t_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_location` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_location`
--

LOCK TABLES `t_location` WRITE;
/*!40000 ALTER TABLE `t_location` DISABLE KEYS */;
INSERT INTO `t_location` VALUES (1,'Thủ đô nghìn năm văn hiến, với hệ thống di tích lịch sử và văn hóa phong phú.','Hà Nội'),(2,'Thành phố sôi động, nơi giao thoa văn hóa và kinh tế.','Hồ Chí Minh'),(3,'Thành phố trẻ trung, hiện đại, nơi giao thoa giữa văn hóa truyền thống và sự phồn thịnh của thành phố phát triển.','Đà Nẵng'),(4,'Thành phố nằm ở trung tâm Đồng Bằng Sông Cửu Long, nổi tiếng với cảnh đẹp hùng vĩ của dòng sông và hệ sinh thái động và cây xanh.','Cần Thơ'),(5,'Nơi nằm dưới chân núi Fansipan, với cảnh đẹp hữu tình và đồng bằng lúa mạch rộng lớn.','Lào Cai'),(6,'Thành phố nổi tiếng với vịnh Hạ Long, một trong những kỳ quan tự nhiên của thế giới.','Quảng Ninh'),(7,'Vùng đất của những người dân Ê Đê, với cộng đồng văn hóa độc đáo và thiên nhiên hùng vĩ.','Đắk Lắk'),(8,'Thành phố biển nổi tiếng với bãi biển dài và nước biển trong xanh.','Nha Trang'),(9,'Thành phố ven biển gần TP.Hồ Chí Minh, nổi tiếng với cảnh đẹp và các bãi biển tuyệt vời.','Vũng Tàu'),(10,'Thành phố cổ kính nằm giữa các triền núi và biển, nổi tiếng với di sản văn hóa độc đáo.','Huế'),(11,'Hòn đảo ngọc xinh đẹp, với bãi biển dịu dàng và hệ sinh thái biển độc đáo.','Phú Quốc'),(12,'Thành phố ngàn hoa, với khí hậu mát mẻ và cảnh đẹp nên thơ.','Đà Lạt'),(13,'Thị trấn nằm giữa những ngọn núi hùng vĩ, nổi tiếng với những thửa ruộng bậc thang tuyệt vời.','Sapa'),(14,'Phố cổ Hội An với những ngôi nhà cổ, cầu ánh sáng lãng mạn và ẩm thực phong phú.','Hội An'),(15,'Vịnh Cam Ranh nổi tiếng với bãi biển dài và biển xanh biếc.','Cẩm Ranh'),(16,'Thị trấn núi Tam Đảo với khí hậu se lạnh và cảnh đẹp thiên nhiên hùng vĩ.','Tam Đảo'),(17,'Đảo Cô Tô xinh đẹp, với bãi biển trong xanh và đồng cỏ xanh mướt.','Cô Tô'),(18,'Thành phố cà phê nằm giữa vùng cao nguyên đồng bằng Sông Cửu Long.','Buôn Ma Thuột'),(19,'Quận Cần Giờ, nơi gặp gỡ giữa sông nước và thiên nhiên hoang dã.','Cần Giờ');
/*!40000 ALTER TABLE `t_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_staff`
--

DROP TABLE IF EXISTS `t_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_staff` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `person_id` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status_working` bit(1) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_inq4nwxr7j9od3vrxp9tjpafo` (`user_id`),
  CONSTRAINT `FKlbxihux3m3cnci1cj4mja6t2o` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_staff`
--

LOCK TABLES `t_staff` WRITE;
/*!40000 ALTER TABLE `t_staff` DISABLE KEYS */;
INSERT INTO `t_staff` VALUES (1,'Hà Nội','1990-01-01','nguyenvana@example.com',_binary '','Nguyễn Văn A','CMND123456','0987654321',_binary '',NULL),(2,'Hồ Chí Minh','1992-03-15','tranthib@example.com',_binary '\0','Trần Thị B','CMND789012','0123456789',_binary '',NULL),(3,'Đà Nẵng','1988-07-20','levanc@example.com',_binary '','Lê Văn C','CMND345678','0909090909',_binary '',NULL),(4,'Hải Phòng','1995-05-10','phamthid@example.com',_binary '\0','Phạm Thị D','CMND567890','0999888777',_binary '',NULL),(5,'Quảng Ninh','1998-11-30','hoangve@example.com',_binary '','Hoàng Văn E','CMND123789','0888777666',_binary '',NULL),(6,'Thanh Hóa','1985-12-25','dothif@example.com',_binary '\0','Đỗ Thị F','CMND678901','0777666555',_binary '',NULL),(7,'Nghệ An','1993-09-08','nguyenvang@example.com',_binary '','Nguyễn Văn G','CMND234567','0666555444',_binary '',NULL),(8,'Hà Tĩnh','1987-06-18','lythih@example.com',_binary '\0','Lý Thị H','CMND890123','0555444333',_binary '',NULL),(9,'Thừa Thiên-Huế','1991-04-03','truongvani@example.com',_binary '','Trương Văn I','CMND456789','0444333222',_binary '',NULL);
/*!40000 ALTER TABLE `t_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tour`
--

DROP TABLE IF EXISTS `t_tour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_tour` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` date DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `tour_info_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKktjyxnjut6o5ohk71ggclfsyt` (`tour_info_id`),
  CONSTRAINT `FKktjyxnjut6o5ohk71ggclfsyt` FOREIGN KEY (`tour_info_id`) REFERENCES `t_tour_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tour`
--

LOCK TABLES `t_tour` WRITE;
/*!40000 ALTER TABLE `t_tour` DISABLE KEYS */;
INSERT INTO `t_tour` VALUES (1,'2023-01-01','2023-02-10 18:00:00.000000',7500000,'2023-02-01 08:00:00.000000',20,1),(2,'2023-11-15','2023-12-15 20:00:00.000000',8000000,'2023-12-03 10:00:00.000000',15,2),(3,'2023-01-03','2023-02-20 17:00:00.000000',7200000,'2023-02-10 09:00:00.000000',25,3),(4,'2023-01-04','2023-02-25 22:00:00.000000',9000000,'2023-02-15 12:00:00.000000',18,4),(5,'2023-01-05','2023-03-01 23:00:00.000000',7800000,'2023-02-20 14:00:00.000000',22,5),(6,'2023-01-06','2023-03-10 18:30:00.000000',8200000,'2023-03-01 08:30:00.000000',17,6),(7,'2023-01-07','2023-03-15 21:30:00.000000',7600000,'2023-03-05 11:30:00.000000',23,7),(8,'2023-11-05','2023-11-30 20:00:00.000000',8800000,'2023-11-25 10:00:00.000000',16,8),(9,'2023-11-06','2023-12-02 23:00:00.000000',9200000,'2023-11-26 13:00:00.000000',19,9),(10,'2023-11-05','2023-12-05 23:00:00.000000',8000000,'2023-12-01 23:00:00.000000',21,10);
/*!40000 ALTER TABLE `t_tour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tour_bookings`
--

DROP TABLE IF EXISTS `t_tour_bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_tour_bookings` (
  `tour_id` bigint NOT NULL,
  `bookings_id` bigint NOT NULL,
  UNIQUE KEY `UK_lkjl4a1q1os1onhqa7rltrxv3` (`bookings_id`),
  KEY `FKss50sh7nwxptqma1p1qfwcp9y` (`tour_id`),
  CONSTRAINT `FKqeg5jly6u8txtbh6alqqdfol2` FOREIGN KEY (`bookings_id`) REFERENCES `t_booking` (`id`),
  CONSTRAINT `FKss50sh7nwxptqma1p1qfwcp9y` FOREIGN KEY (`tour_id`) REFERENCES `t_tour` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tour_bookings`
--

LOCK TABLES `t_tour_bookings` WRITE;
/*!40000 ALTER TABLE `t_tour_bookings` DISABLE KEYS */;
INSERT INTO `t_tour_bookings` VALUES (1,39),(1,53),(2,40),(2,54),(3,41),(3,55),(4,42),(4,56),(5,43),(5,57),(6,44),(6,49),(7,45),(7,50),(8,46),(9,47),(9,51),(10,48),(10,52);
/*!40000 ALTER TABLE `t_tour_bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tour_info`
--

DROP TABLE IF EXISTS `t_tour_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_tour_info` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` date DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `itinerary` varchar(10000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `location_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK875xh3ajypnw941r9x0froe7d` (`location_id`),
  CONSTRAINT `FK875xh3ajypnw941r9x0froe7d` FOREIGN KEY (`location_id`) REFERENCES `t_location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tour_info`
--

LOCK TABLES `t_tour_info` WRITE;
/*!40000 ALTER TABLE `t_tour_info` DISABLE KEYS */;
INSERT INTO `t_tour_info` VALUES (1,'2023-01-01','Hành trình tới vùng đất Quảng Ninh, trải nghiệm vịnh Hạ Long huyền bí, thăm các hang động kỳ diệu, và khám phá văn hóa độc đáo của người dân địa phương.','07:30-12:00 Xe cùng hướng dẫn viên đón khách tại khách sạn khởi hành đi thăm Vịnh Hạ Long.\n12:00-12:15 Quý khách đến bến cảng tàu Hạ Long và làm thủ tục lên tàu.\n12:15-14:00 Tàu rời bến bắt đầu chuyến thăm quan du ngoạn Vịnh Hạ Long, tàu sẽ đi ngang qua các hòn đá lớn nhỏ với tên gọi đặc biệt như: Hòn Gà Chọi, hòn Chó Đá, hòn Đỉnh Hương. \nQuý khách dùng bữa cơm trưa trên tàu. \n14:00-16:30 Quý khách thăm quan Hang Sửng Sốt, một trong những hang động đẹp nhất vịnh Hạ Long. Tiếp đó, tàu di chuyển đến Hang Luồn, du khách có thể chèo kayak/đò hoặc nghỉ ngơi trên tàu. \nTiếp theo, tàu sẽ đưa khách đến với đảo Ti Top. Quý khách có thể tắm biển tại bãi tắm TiTop với bãi cát trắng, hoặc trekking leo lên đỉnh núi Ti Top ngắm nhìn toàn cảnh Vịnh Hạ Long. \n16:30-18:00 Quay trở lại tàu để khởi hành về lại cảng Hạ Long. Quý khách có thể nghe nhạc và thư giãn trên boong tàu, hòa mình vào thiên nhiên. \n18:00-21:30 Tàu cập bến. Chia tay nhà tàu và lên xe về Hà Nội. Kết thúc tour.','Khám Phá Vịnh Hạ Long và Quảng Ninh',7500000,_binary '',6),(2,'2023-02-01','Khám phá vẻ đẹp hùng vĩ của thác Bản Giốc, thưởng thức ẩm thực đặc sắc tại Lạng Sơn, và trải nghiệm văn hóa của người dân địa phương.','06:00-10:00 Xe và hướng dẫn viên đón khách tại điểm hẹn, khởi hành đi thác Bản Giốc.\n10:00-12:00 Thăm quan thác Bản Giốc, tận hưởng không khí tươi mới và hùng vĩ của thiên nhiên. \n12:00-13:30 Dùng trưa tại nhà hàng địa phương với các món ăn ngon đặc sản vùng miền.\n13:30-15:00 Tiếp tục hành trình đến Lạng Sơn, thăm quan các điểm du lịch lịch sử và văn hóa.\n15:00-18:00 Mua sắm đặc sản, đồ handmade tại thị trấn Đồng Đăng.\n18:00-21:00 Trở về điểm xuất phát, kết thúc tour.','Thác Bản Giốc và Lạng Sơn',8000000,_binary '',10),(3,'2023-03-01','Du lịch miền Tây, khám phá vùng đồng bằng sông Cửu Long, thăm làng nghề cá truyền thống và trải nghiệm cuộc sống thủy thủ trên sông.','08:00-12:00 Xe và hướng dẫn viên đón khách tại điểm hẹn, khởi hành đi miền Tây Đồng Nai.\n12:00-13:00 Dùng trưa tại quán ẩm thực truyền thống miền Tây.\n13:00-15:00 Thăm làng nghề cá, trải nghiệm cuộc sống thủy thủ trên sông và mua sắm đặc sản miền Tây.\n15:00-17:00 Tiếp tục hành trình đến Cuộc sống thủy thủ truyền thống, tham gia các hoạt động trải nghiệm và tận hưởng không khí bình yên của vùng quê.\n17:00-19:00 Trở về điểm xuất phát, kết thúc tour.','Miền Tây Đồng Nai và Cuộc Sống Thủy Thủ',6500000,_binary '',4),(4,'2023-04-01','Hành trình tới thành phố ngàn hoa, trải nghiệm không khí mát mẻ, thăm các khu vườn hoa độc đáo và thưởng thức đặc sản địa phương.','08:00-12:00 Xe và hướng dẫn viên đón khách tại điểm hẹn, khởi hành đi Đà Lạt.\n12:00-13:00 Dùng trưa tại nhà hàng địa phương với các món ăn ngon.\n13:00-15:00 Thăm các khu vườn hoa nổi tiếng, chụp ảnh lưu niệm và tận hưởng không khí trong lành của thành phố ngàn hoa.\n15:00-17:00 Ghé thăm các địa điểm du lịch nổi tiếng khác của Đà Lạt.\n17:00-19:00 Trở về điểm xuất phát, kết thúc tour.','Đà Lạt - Thành phố Ngàn Hoa',7000000,_binary '',11),(5,'2023-05-01','Khám phá vẻ đẹp của bờ biển Quy Nhơn, thăm các di tích lịch sử, và thưởng thức ẩm thực độc đáo của vùng miền.','07:00-12:00 Xe và hướng dẫn viên đón khách tại điểm hẹn, khởi hành đi Quy Nhơn.\n12:00-13:00 Dùng trưa tại nhà hàng địa phương với các món biển tươi ngon.\n13:00-15:00 Thăm các điểm du lịch nổi tiếng tại Quy Nhơn, như Chùa Đổng Cốc, Bãi Xep, Eo Gió.\n15:00-17:00 Tận hưởng thời gian tự do tại bãi biển Ky Co, tắm biển và thư giãn.\n17:00-19:00 Trở về điểm xuất phát, kết thúc tour.','Hành Trình Quy Nhơn và Biển Trung',7200000,_binary '',13),(6,'2023-06-01','Hành trình tới Buôn Ma Thuột, thăm các vườn cà phê nổi tiếng, trải nghiệm cuộc sống của người dân địa phương và thưởng thức cà phê ngon.','07:30-12:00 Xe và hướng dẫn viên đón khách tại khách sạn. Khởi hành đi thăm các vườn cà phê nổi tiếng ở Buôn Ma Thuột.\n12:00-13:00 Dùng trưa tại nhà hàng địa phương, thưởng thức các món ăn ngon.\n13:00-15:30 Tiếp tục hành trình thăm các điểm du lịch và vườn cà phê khác nhau, tìm hiểu quy trình chế biến cà phê.\n15:30-17:00 Thăm các cửa hàng trưng bày và mua sắm cà phê đặc sản.\n17:00-18:00 Trở về khách sạn và kết thúc chương trình.','Thành Phố Cà Phê Buôn Ma Thuột',8900000,_binary '',18),(7,'2023-07-01','Khám phá vẻ đẹp của đảo Phú Quốc, trải nghiệm bãi biển dịu dàng, tham gia các hoạt động giải trí và thưởng thức hải sản tươi ngon.','08:00-12:00 Di chuyển đến đảo Phú Quốc và kiểm tra phòng tại khách sạn.\n12:00-13:00 Dùng trưa tại nhà hàng ven biển.\n13:00-15:30 Thăm quan các điểm du lịch trên đảo như Dinh Cậu, Suối Tranh, và Dinh Thự Ông Địa.\n15:30-18:00 Tự do tận hưởng thời gian tại bãi biển hoặc tham gia các hoạt động giải trí.\n18:00-20:00 Dùng tối và thưởng thức các món hải sản tại nhà hàng địa phương.\n20:00-22:00 Tự do khám phá cuộc sống về đêm trên đảo.','Đảo Ngọc Phú Quốc',9500000,_binary '',12),(8,'2023-08-01','Tham gia lễ hội ánh sáng tại thành phố Đà Nẵng, ngắm nhìn những tác phẩm nghệ thuật ánh sáng độc đáo và thưởng thức ẩm thực đặc sản.','18:00-19:30 Hướng dẫn viên đón khách tại điểm hẹn và khám phá các khu vực trung tâm của thành phố Đà Nẵng.\n19:30-21:00 Tham quan lễ hội ánh sáng với các triển lãm nghệ thuật, đèn LED sáng tạo trên cầu Rồng và các con đường trung tâm.\n21:00-22:30 Dùng tối tại một nhà hàng địa phương và thưởng thức các món ăn đặc sản.\n22:30 Kết thúc chương trình, hướng dẫn viên đưa du khách trở về khách sạn hoặc điểm hẹn.','Lễ Hội Ánh Sáng Đà Nẵng',7800000,_binary '',3),(9,'2023-09-01','Khám phá vùng đất Châu Đốc, thăm khu du lịch Thạch Anh và trải nghiệm cuộc sống ven sông nước.','07:00-12:00 Hướng dẫn viên và phương tiện đưa đoàn đi thăm khu du lịch Thạch Anh và các điểm du lịch nổi tiếng khác.\n12:00-13:00 Dùng trưa tại nhà hàng ven sông.\n13:00-15:30 Tiếp tục thăm quan các điểm du lịch khác và thưởng thức cảnh đẹp ven sông.\n15:30-17:00 Trở về trung tâm thị trấn, tự do mua sắm và thăm quan.\n17:00-18:00 Trở về khách sạn và kết thúc chương trình.','Châu Đốc - Miền Tây Sông Nước',6900000,_binary '',7),(10,'2023-10-01','Hành trình tới vùng cao núi Đà Lạt, thăm những thửa ruộng bậc thang tuyệt vời, và trải nghiệm không khí trong lành của núi rừng.','08:00-12:00 Xe và hướng dẫn viên đưa du khách đi thăm những khu vườn đặc sản, thể hiện nét đẹp của vùng núi Đà Lạt.\n12:00-13:00 Dùng trưa tại nhà hàng địa phương.\n13:00-15:30 Tiếp tục hành trình thăm các điểm du lịch nổi tiếng như thác Prenn, thác Datanla, và làng hoa Đà Lạt.\n15:30-17:00 Tự do mua sắm và thưởng thức đặc sản địa phương.\n17:00-18:00 Trở về khách sạn và kết thúc chương trình.','Vùng Cao Núi Đà Lạt',7200000,_binary '',12);
/*!40000 ALTER TABLE `t_tour_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tour_info_images`
--

DROP TABLE IF EXISTS `t_tour_info_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_tour_info_images` (
  `tour_info_id` bigint NOT NULL,
  `images_id` bigint NOT NULL,
  UNIQUE KEY `UK_m7hbjmwjy2vd2a4gsgidd5t07` (`images_id`),
  KEY `FKb5wrv9dpr45he7xmx4s7y4ah0` (`tour_info_id`),
  CONSTRAINT `FKb5wrv9dpr45he7xmx4s7y4ah0` FOREIGN KEY (`tour_info_id`) REFERENCES `t_tour_info` (`id`),
  CONSTRAINT `FKqkeiageavwalpu4kqia4oc6vd` FOREIGN KEY (`images_id`) REFERENCES `t_image` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tour_info_images`
--

LOCK TABLES `t_tour_info_images` WRITE;
/*!40000 ALTER TABLE `t_tour_info_images` DISABLE KEYS */;
INSERT INTO `t_tour_info_images` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9),(4,10),(4,11),(4,12),(5,13),(5,14),(5,15),(6,16),(6,17),(6,18),(7,19),(7,20),(7,21),(8,22),(8,23),(8,24),(9,25),(9,26),(9,27),(10,28),(10,29),(10,30);
/*!40000 ALTER TABLE `t_tour_info_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh5t8al9lhymuhsfhleigltyut` (`role_id`),
  CONSTRAINT `FKh5t8al9lhymuhsfhleigltyut` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,_binary '','admin@gmail.com','$2a$10$J.22iiKQx2g.QcvYakQP/.grq/ouPl6iZaQfRSUF0ubrUw67JsvOy',1);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-22  1:35:00
