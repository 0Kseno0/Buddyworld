-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pokemon
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `pokemon_abilities`
--

DROP TABLE IF EXISTS `pokemon_abilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_abilities` (
  `pok_id` int NOT NULL,
  `abil_id` int NOT NULL,
  `is_hidden` tinyint(1) NOT NULL,
  `slot` int NOT NULL,
  PRIMARY KEY (`pok_id`,`slot`),
  KEY `abil_id` (`abil_id`),
  KEY `ix_pokemon_abilities_is_hidden` (`is_hidden`),
  CONSTRAINT `pokemon_abilities_ibfk_1` FOREIGN KEY (`pok_id`) REFERENCES `pokemon` (`pok_id`),
  CONSTRAINT `pokemon_abilities_ibfk_2` FOREIGN KEY (`abil_id`) REFERENCES `abilities` (`abil_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_abilities`
--

LOCK TABLES `pokemon_abilities` WRITE;
/*!40000 ALTER TABLE `pokemon_abilities` DISABLE KEYS */;
INSERT INTO `pokemon_abilities` VALUES (1,65,0,1),(1,34,1,3),(2,65,0,1),(2,34,1,3),(3,65,0,1),(3,34,1,3),(4,66,0,1),(4,94,1,3),(5,66,0,1),(5,94,1,3),(6,66,0,1),(6,94,1,3),(7,67,0,1),(7,44,1,3),(8,67,0,1),(8,44,1,3),(9,67,0,1),(9,44,1,3),(10,19,0,1),(10,50,1,3),(11,61,0,1),(12,14,0,1),(12,110,1,3),(13,19,0,1),(13,50,1,3),(14,61,0,1),(15,68,0,1),(15,97,1,3),(16,51,0,1),(16,77,0,2),(16,145,1,3),(17,51,0,1),(17,77,0,2),(17,145,1,3),(18,51,0,1),(18,77,0,2),(18,145,1,3),(19,50,0,1),(19,62,0,2),(19,55,1,3),(20,50,0,1),(20,62,0,2),(20,55,1,3),(21,51,0,1),(21,97,1,3),(22,51,0,1),(22,97,1,3),(23,22,0,1),(23,61,0,2),(23,127,1,3),(24,22,0,1),(24,61,0,2),(24,127,1,3),(25,9,0,1),(25,31,1,3),(26,9,0,1),(26,31,1,3),(27,8,0,1),(27,146,1,3),(28,8,0,1),(28,146,1,3),(29,38,0,1),(29,79,0,2),(29,55,1,3),(30,38,0,1),(30,79,0,2),(30,55,1,3),(31,38,0,1),(31,79,0,2),(31,125,1,3),(32,38,0,1),(32,79,0,2),(32,55,1,3),(33,38,0,1),(33,79,0,2),(33,55,1,3),(34,38,0,1),(34,79,0,2),(34,125,1,3),(35,56,0,1),(35,98,0,2),(35,132,1,3),(36,56,0,1),(36,98,0,2),(36,109,1,3),(37,18,0,1),(37,70,1,3),(38,18,0,1),(38,70,1,3),(39,56,0,1),(39,172,0,2),(39,132,1,3),(40,56,0,1),(40,172,0,2),(40,119,1,3),(41,39,0,1),(41,151,1,3),(42,39,0,1),(42,151,1,3),(43,34,0,1),(43,50,1,3),(44,34,0,1),(44,1,1,3),(45,34,0,1),(45,27,1,3),(46,27,0,1),(46,87,0,2),(46,6,1,3),(47,27,0,1),(47,87,0,2),(47,6,1,3),(48,14,0,1),(48,110,0,2),(48,50,1,3),(49,19,0,1),(49,110,0,2),(49,147,1,3),(50,8,0,1),(50,71,0,2),(50,159,1,3),(51,8,0,1),(51,71,0,2),(51,159,1,3),(52,53,0,1),(52,101,0,2),(52,127,1,3),(53,7,0,1),(53,101,0,2),(53,127,1,3),(54,6,0,1),(54,13,0,2),(54,33,1,3),(55,6,0,1),(55,13,0,2),(55,33,1,3),(56,72,0,1),(56,83,0,2),(56,128,1,3),(57,72,0,1),(57,83,0,2),(57,128,1,3),(58,22,0,1),(58,18,0,2),(58,154,1,3),(59,22,0,1),(59,18,0,2),(59,154,1,3),(60,11,0,1),(60,6,0,2),(60,33,1,3),(61,11,0,1),(61,6,0,2),(61,33,1,3),(62,11,0,1),(62,6,0,2),(62,33,1,3),(63,28,0,1),(63,39,0,2),(63,98,1,3),(64,28,0,1),(64,39,0,2),(64,98,1,3),(65,28,0,1),(65,39,0,2),(65,98,1,3),(66,62,0,1),(66,99,0,2),(66,80,1,3),(67,62,0,1),(67,99,0,2),(67,80,1,3),(68,62,0,1),(68,99,0,2),(68,80,1,3),(69,34,0,1),(69,82,1,3),(70,34,0,1),(70,82,1,3),(71,34,0,1),(71,82,1,3),(72,29,0,1),(72,64,0,2),(72,44,1,3),(73,29,0,1),(73,64,0,2),(73,44,1,3),(74,69,0,1),(74,5,0,2),(74,8,1,3),(75,69,0,1),(75,5,0,2),(75,8,1,3),(76,69,0,1),(76,5,0,2),(76,8,1,3),(77,50,0,1),(77,18,0,2),(77,49,1,3),(78,50,0,1),(78,18,0,2),(78,49,1,3),(79,12,0,1),(79,20,0,2),(79,144,1,3),(80,12,0,1),(80,20,0,2),(80,144,1,3),(81,42,0,1),(81,5,0,2),(81,148,1,3),(82,42,0,1),(82,5,0,2),(82,148,1,3),(83,51,0,1),(83,39,0,2),(83,128,1,3),(84,50,0,1),(84,48,0,2),(84,77,1,3),(85,50,0,1),(85,48,0,2),(85,77,1,3),(86,47,0,1),(86,93,0,2),(86,115,1,3),(87,47,0,1),(87,93,0,2),(87,115,1,3),(88,1,0,1),(88,60,0,2),(88,143,1,3),(89,1,0,1),(89,60,0,2),(89,143,1,3),(90,75,0,1),(90,92,0,2),(90,142,1,3),(91,75,0,1),(91,92,0,2),(91,142,1,3),(92,26,0,1),(93,26,0,1),(94,26,0,1),(95,69,0,1),(95,5,0,2),(95,133,1,3),(96,15,0,1),(96,108,0,2),(96,39,1,3),(97,15,0,1),(97,108,0,2),(97,39,1,3),(98,52,0,1),(98,75,0,2),(98,125,1,3),(99,52,0,1),(99,75,0,2),(99,125,1,3),(100,43,0,1),(100,9,0,2),(100,106,1,3),(101,43,0,1),(101,9,0,2),(101,106,1,3),(102,34,0,1),(102,139,1,3),(103,34,0,1),(103,139,1,3),(104,69,0,1),(104,31,0,2),(104,4,1,3),(105,69,0,1),(105,31,0,2),(105,4,1,3),(106,7,0,1),(106,120,0,2),(106,84,1,3),(107,51,0,1),(107,89,0,2),(107,39,1,3),(108,20,0,1),(108,12,0,2),(108,13,1,3),(109,26,0,1),(110,26,0,1),(111,31,0,1),(111,69,0,2),(111,120,1,3),(112,31,0,1),(112,69,0,2),(112,120,1,3),(113,30,0,1),(113,32,0,2),(113,131,1,3),(114,34,0,1),(114,102,0,2),(114,144,1,3),(115,48,0,1),(115,113,0,2),(115,39,1,3),(116,33,0,1),(116,97,0,2),(116,6,1,3),(117,38,0,1),(117,97,0,2),(117,6,1,3),(118,33,0,1),(118,41,0,2),(118,31,1,3),(119,33,0,1),(119,41,0,2),(119,31,1,3),(120,35,0,1),(120,30,0,2),(120,148,1,3),(121,35,0,1),(121,30,0,2),(121,148,1,3),(122,43,0,1),(122,111,0,2),(122,101,1,3),(123,68,0,1),(123,101,0,2),(123,80,1,3),(124,12,0,1),(124,108,0,2),(124,87,1,3),(125,9,0,1),(125,72,1,3),(126,49,0,1),(126,72,1,3),(127,52,0,1),(127,104,0,2),(127,153,1,3),(128,22,0,1),(128,83,0,2),(128,125,1,3),(129,33,0,1),(129,155,1,3),(130,22,0,1),(130,153,1,3),(131,11,0,1),(131,75,0,2),(131,93,1,3),(132,7,0,1),(132,150,1,3),(133,50,0,1),(133,91,0,2),(133,107,1,3),(134,11,0,1),(134,93,1,3),(135,10,0,1),(135,95,1,3),(136,18,0,1),(136,62,1,3),(137,36,0,1),(137,88,0,2),(137,148,1,3),(138,33,0,1),(138,75,0,2),(138,133,1,3),(139,33,0,1),(139,75,0,2),(139,133,1,3),(140,33,0,1),(140,4,0,2),(140,133,1,3),(141,33,0,1),(141,4,0,2),(141,133,1,3),(142,69,0,1),(142,46,0,2),(142,127,1,3),(143,17,0,1),(143,47,0,2),(143,82,1,3),(144,46,0,1),(144,81,1,3),(145,46,0,1),(145,9,1,3),(146,46,0,1),(146,49,1,3),(147,61,0,1),(147,63,1,3),(148,61,0,1),(148,63,1,3),(149,39,0,1),(149,136,1,3),(150,46,0,1),(150,127,1,3),(151,28,0,1),(152,65,0,1),(152,102,1,3),(153,65,0,1),(153,102,1,3),(154,65,0,1),(154,102,1,3),(155,66,0,1),(155,18,1,3),(156,66,0,1),(156,18,1,3),(157,66,0,1),(157,18,1,3),(158,67,0,1),(158,125,1,3),(159,67,0,1),(159,125,1,3),(160,67,0,1),(160,125,1,3),(161,50,0,1),(161,51,0,2),(161,119,1,3),(162,50,0,1),(162,51,0,2),(162,119,1,3),(163,15,0,1),(163,51,0,2),(163,110,1,3),(164,15,0,1),(164,51,0,2),(164,110,1,3),(165,68,0,1),(165,48,0,2),(165,155,1,3),(166,68,0,1),(166,48,0,2),(166,89,1,3),(167,68,0,1),(167,15,0,2),(167,97,1,3),(168,68,0,1),(168,15,0,2),(168,97,1,3),(169,39,0,1),(169,151,1,3),(170,10,0,1),(170,35,0,2),(170,11,1,3),(171,10,0,1),(171,35,0,2),(171,11,1,3),(172,9,0,1),(172,31,1,3),(173,56,0,1),(173,98,0,2),(173,132,1,3),(174,56,0,1),(174,172,0,2),(174,132,1,3),(175,55,0,1),(175,32,0,2),(175,105,1,3),(176,55,0,1),(176,32,0,2),(176,105,1,3),(177,28,0,1),(177,48,0,2),(177,156,1,3),(178,28,0,1),(178,48,0,2),(178,156,1,3),(179,9,0,1),(179,57,1,3),(180,9,0,1),(180,57,1,3),(181,9,0,1),(181,57,1,3),(182,34,0,1),(182,131,1,3),(183,47,0,1),(183,37,0,2),(183,157,1,3),(184,47,0,1),(184,37,0,2),(184,157,1,3),(185,5,0,1),(185,69,0,2),(185,155,1,3),(186,11,0,1),(186,6,0,2),(186,2,1,3),(187,34,0,1),(187,102,0,2),(187,151,1,3),(188,34,0,1),(188,102,0,2),(188,151,1,3),(189,34,0,1),(189,102,0,2),(189,151,1,3),(190,50,0,1),(190,53,0,2),(190,92,1,3),(191,34,0,1),(191,94,0,2),(191,48,1,3),(192,34,0,1),(192,94,0,2),(192,48,1,3),(193,3,0,1),(193,14,0,2),(193,119,1,3),(194,6,0,1),(194,11,0,2),(194,109,1,3),(195,6,0,1),(195,11,0,2),(195,109,1,3),(196,28,0,1),(196,156,1,3),(197,28,0,1),(197,39,1,3),(198,15,0,1),(198,105,0,2),(198,158,1,3),(199,12,0,1),(199,20,0,2),(199,144,1,3),(200,26,0,1),(201,26,0,1),(202,23,0,1),(202,140,1,3),(203,39,0,1),(203,48,0,2),(203,157,1,3),(204,5,0,1),(204,142,1,3),(205,5,0,1),(205,142,1,3),(206,32,0,1),(206,50,0,2),(206,155,1,3),(207,52,0,1),(207,8,0,2),(207,17,1,3),(208,69,0,1),(208,5,0,2),(208,125,1,3),(209,22,0,1),(209,50,0,2),(209,155,1,3),(210,22,0,1),(210,95,0,2),(210,155,1,3),(211,38,0,1),(211,33,0,2),(211,22,1,3),(212,68,0,1),(212,101,0,2),(212,135,1,3),(213,5,0,1),(213,82,0,2),(213,126,1,3),(214,68,0,1),(214,62,0,2),(214,153,1,3),(215,39,0,1),(215,51,0,2),(215,124,1,3),(216,53,0,1),(216,95,0,2),(216,118,1,3),(217,62,0,1),(217,95,0,2),(217,127,1,3),(218,40,0,1),(218,49,0,2),(218,133,1,3),(219,40,0,1),(219,49,0,2),(219,133,1,3),(220,12,0,1),(220,81,0,2),(220,47,1,3),(221,12,0,1),(221,81,0,2),(221,47,1,3),(222,55,0,1),(222,30,0,2),(222,144,1,3),(223,55,0,1),(223,97,0,2),(223,141,1,3),(224,21,0,1),(224,97,0,2),(224,141,1,3),(225,72,0,1),(225,55,0,2),(225,15,1,3),(226,33,0,1),(226,11,0,2),(226,41,1,3),(227,51,0,1),(227,5,0,2),(227,133,1,3),(228,48,0,1),(228,18,0,2),(228,127,1,3),(229,48,0,1),(229,18,0,2),(229,127,1,3),(230,33,0,1),(230,97,0,2),(230,6,1,3),(231,53,0,1),(231,8,1,3),(232,5,0,1),(232,8,1,3),(233,36,0,1),(233,88,0,2),(233,148,1,3),(234,22,0,1),(234,119,0,2),(234,157,1,3),(236,62,0,1),(236,80,0,2),(236,72,1,3),(237,22,0,1),(237,101,0,2),(237,80,1,3),(238,12,0,1),(238,108,0,2),(238,93,1,3),(239,9,0,1),(239,72,1,3),(240,49,0,1),(240,72,1,3),(241,47,0,1),(241,113,0,2),(241,157,1,3),(242,30,0,1),(242,32,0,2),(242,131,1,3),(243,46,0,1),(243,10,1,3),(244,46,0,1),(244,18,1,3),(245,46,0,1),(245,11,1,3),(246,62,0,1),(246,8,1,3),(247,61,0,1),(248,45,0,1),(248,127,1,3),(249,46,0,1),(249,136,1,3),(250,46,0,1),(250,144,1,3),(251,30,0,1),(252,65,0,1),(252,84,1,3),(253,65,0,1),(253,84,1,3),(254,65,0,1),(254,84,1,3),(255,66,0,1),(255,3,1,3),(256,66,0,1),(256,3,1,3),(257,66,0,1),(257,3,1,3),(258,67,0,1),(258,6,1,3),(259,67,0,1),(259,6,1,3),(260,67,0,1),(260,6,1,3),(261,50,0,1),(261,95,0,2),(261,155,1,3),(262,22,0,1),(262,95,0,2),(262,153,1,3),(263,53,0,1),(263,82,0,2),(263,95,1,3),(264,53,0,1),(264,82,0,2),(264,95,1,3),(265,19,0,1),(265,50,1,3),(266,61,0,1),(267,68,0,1),(267,79,1,3),(268,61,0,1),(269,19,0,1),(269,14,1,3),(270,33,0,1),(270,44,0,2),(270,20,1,3),(271,33,0,1),(271,44,0,2),(271,20,1,3),(272,33,0,1),(272,44,0,2),(272,20,1,3),(273,34,0,1),(273,48,0,2),(273,124,1,3),(274,34,0,1),(274,48,0,2),(274,124,1,3),(275,34,0,1),(275,48,0,2),(275,124,1,3),(276,62,0,1),(276,113,1,3),(277,62,0,1),(277,113,1,3),(278,51,0,1),(278,44,1,3),(279,51,0,1),(279,44,1,3),(280,28,0,1),(280,36,0,2),(280,140,1,3),(281,28,0,1),(281,36,0,2),(281,140,1,3),(282,28,0,1),(282,36,0,2),(282,140,1,3),(283,33,0,1),(283,44,1,3),(284,22,0,1),(284,127,1,3),(285,27,0,1),(285,90,0,2),(285,95,1,3),(286,27,0,1),(286,90,0,2),(286,101,1,3),(287,54,0,1),(288,72,0,1),(289,54,0,1),(290,14,0,1),(290,50,1,3),(291,3,0,1),(291,151,1,3),(292,25,0,1),(293,43,0,1),(293,155,1,3),(294,43,0,1),(294,113,1,3),(295,43,0,1),(295,113,1,3),(296,47,0,1),(296,62,0,2),(296,125,1,3),(297,47,0,1),(297,62,0,2),(297,125,1,3),(298,47,0,1),(298,37,0,2),(298,157,1,3),(299,5,0,1),(299,42,0,2),(299,159,1,3),(300,56,0,1),(300,96,0,2),(300,147,1,3),(301,56,0,1),(301,96,0,2),(301,147,1,3),(302,51,0,1),(302,100,0,2),(302,158,1,3),(303,52,0,1),(303,22,0,2),(303,125,1,3),(304,5,0,1),(304,69,0,2),(304,134,1,3),(305,5,0,1),(305,69,0,2),(305,134,1,3),(306,5,0,1),(306,69,0,2),(306,134,1,3),(307,74,0,1),(307,140,1,3),(308,74,0,1),(308,140,1,3),(309,9,0,1),(309,31,0,2),(309,58,1,3),(310,9,0,1),(310,31,0,2),(310,58,1,3),(311,57,0,1),(311,31,1,3),(312,58,0,1),(312,10,1,3),(313,35,0,1),(313,68,0,2),(313,158,1,3),(314,12,0,1),(314,110,0,2),(314,158,1,3),(315,30,0,1),(315,38,0,2),(315,102,1,3),(316,64,0,1),(316,60,0,2),(316,82,1,3),(317,64,0,1),(317,60,0,2),(317,82,1,3),(318,24,0,1),(318,3,1,3),(319,24,0,1),(319,3,1,3),(320,41,0,1),(320,12,0,2),(320,46,1,3),(321,41,0,1),(321,12,0,2),(321,46,1,3),(322,12,0,1),(322,86,0,2),(322,20,1,3),(323,40,0,1),(323,116,0,2),(323,83,1,3),(324,73,0,1),(324,75,1,3),(325,47,0,1),(325,20,0,2),(325,82,1,3),(326,47,0,1),(326,20,0,2),(326,82,1,3),(327,20,0,1),(327,77,0,2),(327,126,1,3),(328,52,0,1),(328,71,0,2),(328,125,1,3),(329,26,0,1),(330,26,0,1),(331,8,0,1),(331,11,1,3),(332,8,0,1),(332,11,1,3),(333,30,0,1),(333,13,1,3),(334,30,0,1),(334,13,1,3),(335,17,0,1),(335,137,1,3),(336,61,0,1),(336,151,1,3),(337,26,0,1),(338,26,0,1),(339,12,0,1),(339,107,0,2),(339,93,1,3),(340,12,0,1),(340,107,0,2),(340,93,1,3),(341,52,0,1),(341,75,0,2),(341,91,1,3),(342,52,0,1),(342,75,0,2),(342,91,1,3),(343,26,0,1),(344,26,0,1),(345,21,0,1),(345,114,1,3),(346,21,0,1),(346,114,1,3),(347,4,0,1),(347,33,1,3),(348,4,0,1),(348,33,1,3),(349,33,0,1),(349,12,0,2),(349,91,1,3),(350,63,0,1),(350,172,0,2),(350,56,1,3),(351,59,0,1),(352,16,0,1),(352,168,1,3),(353,15,0,1),(353,119,0,2),(353,130,1,3),(354,15,0,1),(354,119,0,2),(354,130,1,3),(355,26,0,1),(355,119,1,3),(356,46,0,1),(356,119,1,3),(357,34,0,1),(357,94,0,2),(357,139,1,3),(358,26,0,1),(359,46,0,1),(359,105,0,2),(359,154,1,3),(360,23,0,1),(360,140,1,3),(361,39,0,1),(361,115,0,2),(361,141,1,3),(362,39,0,1),(362,115,0,2),(362,141,1,3),(363,47,0,1),(363,115,0,2),(363,12,1,3),(364,47,0,1),(364,115,0,2),(364,12,1,3),(365,47,0,1),(365,115,0,2),(365,12,1,3),(366,75,0,1),(366,155,1,3),(367,33,0,1),(367,41,1,3),(368,33,0,1),(368,93,1,3),(369,33,0,1),(369,69,0,2),(369,5,1,3),(370,33,0,1),(370,93,1,3),(371,69,0,1),(371,125,1,3),(372,69,0,1),(372,142,1,3),(373,22,0,1),(373,153,1,3),(374,29,0,1),(374,135,1,3),(375,29,0,1),(375,135,1,3),(376,29,0,1),(376,135,1,3),(377,29,0,1),(377,5,1,3),(378,29,0,1),(378,115,1,3),(379,29,0,1),(379,135,1,3),(380,26,0,1),(381,26,0,1),(382,2,0,1),(383,70,0,1),(384,76,0,1),(385,32,0,1),(386,46,0,1),(387,65,0,1),(387,75,1,3),(388,65,0,1),(388,75,1,3),(389,65,0,1),(389,75,1,3),(390,66,0,1),(390,89,1,3),(391,66,0,1),(391,89,1,3),(392,66,0,1),(392,89,1,3),(393,67,0,1),(393,128,1,3),(394,67,0,1),(394,128,1,3),(395,67,0,1),(395,128,1,3),(396,51,0,1),(396,120,1,3),(397,22,0,1),(397,120,1,3),(398,22,0,1),(398,120,1,3),(399,86,0,1),(399,109,0,2),(399,141,1,3),(400,86,0,1),(400,109,0,2),(400,141,1,3),(401,61,0,1),(401,50,1,3),(402,68,0,1),(402,101,1,3),(403,79,0,1),(403,22,0,2),(403,62,1,3),(404,79,0,1),(404,22,0,2),(404,62,1,3),(405,79,0,1),(405,22,0,2),(405,62,1,3),(406,30,0,1),(406,38,0,2),(406,102,1,3),(406,22,0,4),(407,30,0,1),(407,38,0,2),(407,101,1,3),(407,22,1,4),(408,104,0,1),(408,125,1,3),(408,22,1,4),(409,104,0,1),(409,125,1,3),(410,5,0,1),(410,43,1,3),(410,22,2,4),(411,5,0,1),(411,43,1,3),(411,79,2,4),(412,61,0,1),(412,142,1,3),(413,107,0,1),(413,142,1,3),(414,68,0,1),(414,110,1,3),(415,118,0,1),(415,55,1,3),(416,46,0,1),(416,127,1,3),(417,50,0,1),(417,53,0,2),(417,10,1,3),(418,33,0,1),(418,41,1,3),(419,33,0,1),(419,41,1,3),(420,34,0,1),(421,122,0,1),(422,60,0,1),(422,114,0,2),(422,159,1,3),(423,60,0,1),(423,114,0,2),(423,159,1,3),(424,101,0,1),(424,53,0,2),(424,92,1,3),(425,106,0,1),(425,84,0,2),(425,138,1,3),(426,106,0,1),(426,84,0,2),(426,138,1,3),(427,50,0,1),(427,103,0,2),(427,7,1,3),(428,56,0,1),(428,103,0,2),(428,7,1,3),(429,26,0,1),(430,15,0,1),(430,105,0,2),(430,153,1,3),(431,7,0,1),(431,20,0,2),(431,51,1,3),(432,47,0,1),(432,20,0,2),(432,128,1,3),(433,26,0,1),(434,1,0,1),(434,106,0,2),(434,51,1,3),(435,1,0,1),(435,106,0,2),(435,51,1,3),(436,26,0,1),(436,85,0,2),(436,134,1,3),(437,26,0,1),(437,85,0,2),(437,134,1,3),(438,5,0,1),(438,69,0,2),(438,155,1,3),(439,43,0,1),(439,111,0,2),(439,101,1,3),(440,30,0,1),(440,32,0,2),(440,132,1,3),(441,51,0,1),(441,77,0,2),(441,145,1,3),(442,46,0,1),(442,151,1,3),(443,8,0,1),(443,24,1,3),(444,8,0,1),(444,24,1,3),(445,8,0,1),(445,24,1,3),(446,53,0,1),(446,47,0,2),(446,82,1,3),(447,80,0,1),(447,39,0,2),(447,158,1,3),(448,80,0,1),(448,39,0,2),(448,154,1,3),(449,45,0,1),(449,159,1,3),(450,45,0,1),(450,159,1,3),(451,4,0,1),(451,97,0,2),(451,51,1,3),(452,4,0,1),(452,97,0,2),(452,51,1,3),(453,107,0,1),(453,87,0,2),(453,143,1,3),(454,107,0,1),(454,87,0,2),(454,143,1,3),(455,26,0,1),(456,33,0,1),(456,114,0,2),(456,41,1,3),(457,33,0,1),(457,114,0,2),(457,41,1,3),(458,33,0,1),(458,11,0,2),(458,41,1,3),(459,117,0,1),(459,43,1,3),(460,117,0,1),(460,43,1,3),(461,46,0,1),(461,124,1,3),(462,42,0,1),(462,5,0,2),(462,148,1,3),(463,20,0,1),(463,12,0,2),(463,13,1,3),(464,31,0,1),(464,116,0,2),(464,120,1,3),(465,34,0,1),(465,102,0,2),(465,144,1,3),(466,78,0,1),(466,72,1,3),(467,49,0,1),(467,72,1,3),(468,55,0,1),(468,32,0,2),(468,105,1,3),(469,3,0,1),(469,110,0,2),(469,119,1,3),(470,102,0,1),(470,34,1,3),(471,81,0,1),(471,115,1,3),(472,52,0,1),(472,8,0,2),(472,90,1,3),(473,12,0,1),(473,81,0,2),(473,47,1,3),(474,91,0,1),(474,88,0,2),(474,148,1,3),(475,80,0,1),(475,154,1,3),(476,5,0,1),(476,42,0,2),(476,159,1,3),(477,46,0,1),(477,119,1,3),(478,81,0,1),(478,130,1,3),(479,26,0,1),(480,26,0,1),(481,26,0,1),(482,26,0,1),(483,46,0,1),(483,140,1,3),(484,46,0,1),(484,140,1,3),(485,18,0,1),(485,49,1,3),(486,112,0,1),(487,46,0,1),(487,140,1,3),(488,26,0,1),(489,93,0,1),(490,93,0,1),(491,123,0,1),(492,30,0,1),(493,121,0,1),(494,162,0,1),(495,65,0,1),(495,126,1,3),(496,65,0,1),(496,126,1,3),(497,65,0,1),(497,126,1,3),(498,66,0,1),(498,47,1,3),(499,66,0,1),(499,47,1,3),(500,66,0,1),(500,120,1,3),(501,67,0,1),(501,75,1,3),(502,67,0,1),(502,75,1,3),(503,67,0,1),(503,75,1,3),(504,50,0,1),(504,51,0,2),(504,148,1,3),(505,35,0,1),(505,51,0,2),(505,148,1,3),(506,72,0,1),(506,53,0,2),(506,50,1,3),(507,22,0,1),(507,146,0,2),(507,113,1,3),(508,22,0,1),(508,146,0,2),(508,113,1,3),(509,7,0,1),(509,84,0,2),(509,158,1,3),(510,7,0,1),(510,84,0,2),(510,158,1,3),(511,82,0,1),(511,65,1,3),(512,82,0,1),(512,65,1,3),(513,82,0,1),(513,66,1,3),(514,82,0,1),(514,66,1,3),(515,82,0,1),(515,67,1,3),(516,82,0,1),(516,67,1,3),(517,108,0,1),(517,28,0,2),(517,140,1,3),(518,108,0,1),(518,28,0,2),(518,140,1,3),(519,145,0,1),(519,105,0,2),(519,79,1,3),(520,145,0,1),(520,105,0,2),(520,79,1,3),(521,145,0,1),(521,105,0,2),(521,79,1,3),(522,31,0,1),(522,78,0,2),(522,157,1,3),(523,31,0,1),(523,78,0,2),(523,157,1,3),(524,5,0,1),(524,159,1,3),(525,5,0,1),(525,159,1,3),(526,5,0,1),(526,159,1,3),(527,109,0,1),(527,103,0,2),(527,86,1,3),(528,109,0,1),(528,103,0,2),(528,86,1,3),(529,146,0,1),(529,159,0,2),(529,104,1,3),(530,146,0,1),(530,159,0,2),(530,104,1,3),(531,131,0,1),(531,144,0,2),(531,103,1,3),(532,62,0,1),(532,125,0,2),(532,89,1,3),(533,62,0,1),(533,125,0,2),(533,89,1,3),(534,62,0,1),(534,125,0,2),(534,89,1,3),(535,33,0,1),(535,93,0,2),(535,11,1,3),(536,33,0,1),(536,93,0,2),(536,11,1,3),(537,33,0,1),(537,143,0,2),(537,11,1,3),(538,62,0,1),(538,39,0,2),(538,104,1,3),(539,5,0,1),(539,39,0,2),(539,104,1,3),(540,68,0,1),(540,34,0,2),(540,142,1,3),(541,102,0,1),(541,34,0,2),(541,142,1,3),(542,68,0,1),(542,34,0,2),(542,142,1,3),(543,38,0,1),(543,68,0,2),(543,3,1,3),(544,38,0,1),(544,68,0,2),(544,3,1,3),(545,38,0,1),(545,68,0,2),(545,3,1,3),(546,158,0,1),(546,151,0,2),(546,34,1,3),(547,158,0,1),(547,151,0,2),(547,34,1,3),(548,34,0,1),(548,20,0,2),(548,102,1,3),(549,34,0,1),(549,20,0,2),(549,102,1,3),(550,120,0,1),(550,91,0,2),(550,104,1,3),(551,22,0,1),(551,153,0,2),(551,83,1,3),(552,22,0,1),(552,153,0,2),(552,83,1,3),(553,22,0,1),(553,153,0,2),(553,83,1,3),(554,55,0,1),(554,39,1,3),(555,125,0,1),(555,161,1,3),(556,11,0,1),(556,34,0,2),(556,114,1,3),(557,5,0,1),(557,75,0,2),(557,133,1,3),(558,5,0,1),(558,75,0,2),(558,133,1,3),(559,61,0,1),(559,153,0,2),(559,22,1,3),(560,61,0,1),(560,153,0,2),(560,22,1,3),(561,147,0,1),(561,98,0,2),(561,110,1,3),(562,152,0,1),(563,152,0,1),(564,116,0,1),(564,5,0,2),(564,33,1,3),(565,116,0,1),(565,5,0,2),(565,33,1,3),(566,129,0,1),(567,129,0,1),(568,1,0,1),(568,60,0,2),(568,106,1,3),(569,1,0,1),(569,133,0,2),(569,106,1,3),(570,149,0,1),(571,149,0,1),(572,56,0,1),(572,101,0,2),(572,92,1,3),(573,56,0,1),(573,101,0,2),(573,92,1,3),(574,119,0,1),(574,172,0,2),(574,23,1,3),(575,119,0,1),(575,172,0,2),(575,23,1,3);
/*!40000 ALTER TABLE `pokemon_abilities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-04 13:29:43
