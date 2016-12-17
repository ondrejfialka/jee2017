-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fadb
-- ------------------------------------------------------
-- Server version	5.6.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accommodation`
--

DROP TABLE IF EXISTS `accommodation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accommodation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `imagePath` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accommodation`
--

LOCK TABLES `accommodation` WRITE;
/*!40000 ALTER TABLE `accommodation` DISABLE KEYS */;
INSERT INTO `accommodation` VALUES (1,'A nice new hotel with free internet access','U:\\JSE\\Workspace\\FA\\images\\hotelo.jpg','Heidelberg','Hotelo',15),(2,'montparnasse.concorde-hotels.com',NULL,'Paris','Concorde Montparnasse',12),(3,'soin-esthetique-du-corps.com',NULL,'Paris','Four Seasons',5),(4,'www.l-hotel.com',NULL,'Paris','L\'Hôtel',8),(5,'www.sanctuaryhousehotel.co.uk',NULL,'London','Sanctuary House Hotel',20),(6,'www.cityinn.com',NULL,'London','City Inn Hotel Westminster',3),(7,'www.brownshotel.com',NULL,'London','Brown\'s Hotel',15),(8,NULL,NULL,'Prague','Ambassador',8),(9,NULL,NULL,'Prague','Grand Hotel Praha',50),(10,NULL,NULL,'Prague','Corinthia Towers',10);
/*!40000 ALTER TABLE `accommodation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` bigint(20) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `holiday_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE20F75326B532249` (`holiday_id`),
  KEY `FKE20F7532F0BD3F4B` (`customer_id`),
  CONSTRAINT `FKE20F75326B532249` FOREIGN KEY (`holiday_id`) REFERENCES `holiday` (`id`),
  CONSTRAINT `FKE20F7532F0BD3F4B` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,654,1,1),(2,655,2,2),(3,656,3,3),(6,0,2,3),(7,0,1,3);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard`
--

DROP TABLE IF EXISTS `creditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL,
  `ownerName` varchar(255) DEFAULT NULL,
  `validity` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard`
--

LOCK TABLES `creditcard` WRITE;
/*!40000 ALTER TABLE `creditcard` DISABLE KEYS */;
INSERT INTO `creditcard` VALUES (1,'4210-3903-2933-1929','MARTIN JELEN','03/09'),(2,'4567-5654-8797-2133','TOMAS BAUER','04/10'),(3,'5455-4567-7982-3132','ONDREJ KUCERA','12/08');
/*!40000 ALTER TABLE `creditcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `card_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK27FBE3FE93CDC464` (`card_id`),
  CONSTRAINT `FK27FBE3FE93CDC464` FOREIGN KEY (`card_id`) REFERENCES `creditcard` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Martin','Jelen',1),(2,'Tomáš','Bauer',2),(3,'Ondřej','Kučera',3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday`
--

DROP TABLE IF EXISTS `holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holiday` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ends` date DEFAULT NULL,
  `fixed` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `starts` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday`
--

LOCK TABLES `holiday` WRITE;
/*!40000 ALTER TABLE `holiday` DISABLE KEYS */;
INSERT INTO `holiday` VALUES (1,'2009-05-22','','10 days of Prague',390,'2009-05-11'),(2,'2009-02-16','','5 days of London',210,'2009-02-10'),(3,'2009-03-22','','14 days of Europe',750,'2009-03-08'),(4,'2009-03-12','','abc',124,'2009-03-17');
/*!40000 ALTER TABLE `holiday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday_service`
--

DROP TABLE IF EXISTS `holiday_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holiday_service` (
  `Holiday_id` bigint(20) NOT NULL,
  `services_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Holiday_id`,`services_id`),
  KEY `FK2F920D8E6B532249` (`Holiday_id`),
  KEY `FK2F920D8E707B92E0` (`services_id`),
  CONSTRAINT `FK2F920D8E6B532249` FOREIGN KEY (`Holiday_id`) REFERENCES `holiday` (`id`),
  CONSTRAINT `FK2F920D8E707B92E0` FOREIGN KEY (`services_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday_service`
--

LOCK TABLES `holiday_service` WRITE;
/*!40000 ALTER TABLE `holiday_service` DISABLE KEYS */;
INSERT INTO `holiday_service` VALUES (1,6),(2,8),(2,9);
/*!40000 ALTER TABLE `holiday_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holiday_transportation`
--

DROP TABLE IF EXISTS `holiday_transportation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holiday_transportation` (
  `Holiday_id` bigint(20) NOT NULL,
  `transportation_id` bigint(20) NOT NULL,
  KEY `FKE61958736B532249` (`Holiday_id`),
  KEY `FKE61958731A10EBCB` (`transportation_id`),
  CONSTRAINT `FKE61958731A10EBCB` FOREIGN KEY (`transportation_id`) REFERENCES `transportation` (`id`),
  CONSTRAINT `FKE61958736B532249` FOREIGN KEY (`Holiday_id`) REFERENCES `holiday` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holiday_transportation`
--

LOCK TABLES `holiday_transportation` WRITE;
/*!40000 ALTER TABLE `holiday_transportation` DISABLE KEYS */;
INSERT INTO `holiday_transportation` VALUES (3,1),(3,2),(3,3),(3,4),(2,5),(2,6),(2,9),(1,8),(1,11),(4,10),(4,11);
/*!40000 ALTER TABLE `holiday_transportation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD97C5E956562EC27` (`hotel_id`),
  CONSTRAINT `FKD97C5E956562EC27` FOREIGN KEY (`hotel_id`) REFERENCES `accommodation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'A nice, long massage','Heidelberg','Back massage',1,1),(2,'Express dry cleaning for business travellers available','Paris','Dry cleaning',2,2),(3,'Express dry cleaning for business travellers available','Paris','Dry cleaning',2,4),(4,'Express dry cleaning for business travellers available','London','Dry cleaning',2,5),(5,'Express dry cleaning for business travellers available','London','Dry cleaning',2,7),(6,'A one-day trip to Klatovy','Prague','Klatovy (1 day)',0,NULL),(7,'A two-day trip to the metropolis of the South Bohemia','Prague','České Budějovice (2 days)',0,NULL),(8,NULL,'London','Oxford (1 day)',0,NULL),(9,'Sightseeing around the City of London','London','City of London sightseeing',0,NULL),(10,'A one-day getaway to the amusement park','Paris','Eurodisney (1 day)',0,NULL),(11,'No shoes stolen. Guarranteed','London','Shoe cleaning',2,5);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stay`
--

DROP TABLE IF EXISTS `stay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stay` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dayFrom` date DEFAULT NULL,
  `dayTo` date DEFAULT NULL,
  `holiday_id` bigint(20) DEFAULT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK277A796B532249` (`holiday_id`),
  KEY `FK277A796562EC27` (`hotel_id`),
  CONSTRAINT `FK277A796562EC27` FOREIGN KEY (`hotel_id`) REFERENCES `accommodation` (`id`),
  CONSTRAINT `FK277A796B532249` FOREIGN KEY (`holiday_id`) REFERENCES `holiday` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stay`
--

LOCK TABLES `stay` WRITE;
/*!40000 ALTER TABLE `stay` DISABLE KEYS */;
INSERT INTO `stay` VALUES (1,'2009-05-12','2009-05-21',1,8),(2,'2009-02-10','2009-02-14',2,5),(3,'2009-03-08','2009-03-13',3,4),(4,'2009-03-15','2009-03-19',3,9),(5,'2009-03-20','2009-03-21',3,6);
/*!40000 ALTER TABLE `stay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transportation`
--

DROP TABLE IF EXISTS `transportation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transportation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `arrival` datetime DEFAULT NULL,
  `capacity` int(11) NOT NULL,
  `departure` datetime DEFAULT NULL,
  `loc_from` varchar(255) DEFAULT NULL,
  `occupied` int(11) NOT NULL,
  `loc_to` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transportation`
--

LOCK TABLES `transportation` WRITE;
/*!40000 ALTER TABLE `transportation` DISABLE KEYS */;
INSERT INTO `transportation` VALUES (1,'2009-03-08 09:15:00',20,'2009-03-07 18:00:00','Chicago',1,'Paris',0),(2,'2009-03-15 07:00:00',400,'2009-03-14 20:00:00','Paris',1,'Prague',2),(3,'2009-03-20 15:00:00',8,'2009-03-20 12:40:00','Prague',1,'London',0),(4,'2009-03-22 04:00:00',20,'2009-03-21 22:45:00','London',1,'Chicago',0),(5,'2009-02-10 10:00:00',15,'2009-02-10 00:30:00','Detroit',2,'London',0),(6,'2009-02-16 14:30:00',10,'2009-02-16 00:45:00','London',2,'Detroit',0),(7,'2009-05-12 07:15:00',12,'2009-05-11 20:00:00','Chicago',1,'Prague',0),(8,'2009-05-22 00:15:00',3,'2009-05-21 12:10:00','Prague',1,'Chicago',0),(9,'2009-03-11 09:15:00',15,'2009-03-10 18:00:00','Chicago',0,'Paris',0),(10,'2009-03-15 09:15:00',15,'2009-03-14 18:00:00','Chicago',0,'Paris',0),(11,'2009-03-18 09:15:00',15,'2009-03-17 18:00:00','Chicago',0,'Paris',0),(12,'2009-03-22 09:15:00',15,'2009-03-21 18:00:00','Chicago',0,'Paris',0),(13,'2009-03-25 09:15:00',15,'2009-03-24 18:00:00','Chicago',0,'Paris',0),(14,'2009-03-29 09:15:00',15,'2009-03-28 18:00:00','Chicago',0,'Paris',0),(15,'2009-04-01 09:15:00',15,'2009-03-31 18:00:00','Chicago',0,'Paris',0),(16,'2009-04-05 09:15:00',15,'2009-04-04 18:00:00','Chicago',0,'Paris',0),(17,'2009-03-16 00:15:00',20,'2009-03-15 12:10:00','Paris',0,'Chicago',0),(18,'2009-03-23 00:15:00',20,'2009-03-22 12:10:00','Paris',0,'Chicago',0),(19,'2009-03-30 00:15:00',20,'2009-03-29 12:10:00','Paris',0,'Chicago',0),(20,'2009-04-05 00:15:00',20,'2009-04-05 12:10:00','Paris',0,'Chicago',0),(21,'2009-04-13 00:15:00',20,'2009-04-12 12:10:00','Paris',0,'Chicago',0),(22,'2009-04-20 00:15:00',20,'2009-04-19 12:10:00','Paris',0,'Chicago',0),(23,'2009-04-27 00:15:00',20,'2009-04-26 12:10:00','Paris',0,'Chicago',0),(24,'2009-02-24 10:00:00',8,'2009-02-24 00:30:00','Detroit',0,'London',0),(25,'2009-03-10 10:00:00',8,'2009-03-10 00:30:00','Detroit',0,'London',0),(26,'2009-03-24 10:00:00',8,'2009-03-24 00:30:00','Detroit',0,'London',0),(27,'2009-04-07 10:00:00',8,'2009-04-07 00:30:00','Detroit',0,'London',0),(28,'2009-04-21 10:00:00',8,'2009-04-21 00:30:00','Detroit',0,'London',0),(29,'2009-03-02 14:30:00',12,'2009-03-02 00:45:00','London',0,'Detroit',0),(30,'2009-03-16 14:30:00',12,'2009-03-16 00:45:00','London',0,'Detroit',0),(31,'2009-03-30 14:30:00',12,'2009-03-30 00:45:00','London',0,'Detroit',0),(32,'2009-04-13 14:30:00',12,'2009-04-13 00:45:00','London',0,'Detroit',0),(33,'2009-03-10 10:00:00',20,'2009-03-09 22:30:00','Chicago',0,'Prague',0),(34,'2009-03-30 10:00:00',20,'2009-03-29 22:30:00','Chicago',0,'Prague',0),(35,'2009-04-19 10:00:00',20,'2009-04-18 22:30:00','Chicago',0,'Prague',0),(36,'2009-03-23 01:45:00',14,'2009-03-22 12:45:00','Prague',0,'Chicago',0),(37,'2009-04-25 01:45:00',14,'2009-04-24 12:45:00','Prague',0,'Chicago',0),(38,'2009-03-08 19:00:00',7,'2009-03-08 10:00:00','Paris',0,'Prague',1),(39,'2009-03-10 18:30:00',6,'2009-03-10 14:30:00','London',0,'Paris',2),(40,'2009-03-12 20:15:00',9,'2009-03-12 18:30:00','Prague',0,'London',0),(41,'2009-03-14 17:05:00',7,'2009-03-14 09:45:00','Prague',0,'Paris',1),(42,'2009-03-16 15:15:00',8,'2009-03-16 12:00:00','Paris',0,'London',2),(43,'2009-03-18 19:00:00',7,'2009-03-18 10:00:00','Paris',0,'Prague',1),(44,'2009-03-20 20:15:00',9,'2009-03-20 18:30:00','Prague',0,'London',0),(45,'2009-03-22 15:15:00',9,'2009-03-22 12:00:00','London',0,'Prague',0),(46,'2009-03-24 18:30:00',6,'2009-03-24 14:30:00','London',0,'Paris',2),(47,'2009-03-26 17:05:00',7,'2009-03-26 09:45:00','Prague',0,'Paris',1),(48,'2009-03-28 18:30:00',6,'2009-03-28 14:30:00','London',0,'Paris',2),(49,'2009-03-30 20:15:00',9,'2009-03-30 18:30:00','Prague',0,'London',0),(50,'2009-04-01 15:15:00',8,'2009-04-01 12:00:00','Paris',0,'London',2),(51,'2009-04-03 15:15:00',9,'2009-04-03 12:00:00','London',0,'Prague',0),(52,'2009-04-05 19:00:00',7,'2009-04-05 10:00:00','Paris',0,'Prague',1),(53,'2009-04-07 15:15:00',9,'2009-04-07 12:00:00','London',0,'Prague',0),(54,'2009-04-09 15:15:00',9,'2009-04-09 12:00:00','London',0,'Prague',0),(55,'2009-04-11 15:15:00',8,'2009-04-11 12:00:00','Paris',0,'London',2),(56,'2009-04-13 17:05:00',7,'2009-04-13 09:45:00','Prague',0,'Paris',1),(57,'2009-04-15 15:15:00',8,'2009-04-15 12:00:00','Paris',0,'London',2),(58,'2009-04-17 20:15:00',9,'2009-04-17 18:30:00','Prague',0,'London',0),(59,'2009-04-19 19:00:00',7,'2009-04-19 10:00:00','Paris',0,'Prague',1),(60,'2009-04-21 18:30:00',6,'2009-04-21 14:30:00','London',0,'Paris',2),(61,'2009-04-23 17:05:00',7,'2009-04-23 09:45:00','Prague',0,'Paris',1);
/*!40000 ALTER TABLE `transportation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traveller`
--

DROP TABLE IF EXISTS `traveller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traveller` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateOfBirth` date DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `idNumber` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `contract_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC314B49F95DF42CB` (`contract_id`),
  CONSTRAINT `FKC314B49F95DF42CB` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traveller`
--

LOCK TABLES `traveller` WRITE;
/*!40000 ALTER TABLE `traveller` DISABLE KEYS */;
INSERT INTO `traveller` VALUES (1,'1975-08-12','Michal','329310291','Bláha',1),(2,'1978-04-20','Marek','545487988','Tuhý',2),(3,'1998-05-10','Martin','545646544','Tuhý',2),(4,'1960-12-12','Marie','78219464','Hýlová',3),(5,'2009-03-13','Martin','12343567','Jelen',7);
/*!40000 ALTER TABLE `traveller` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-02 19:25:32
