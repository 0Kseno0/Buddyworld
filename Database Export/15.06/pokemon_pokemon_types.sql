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
-- Table structure for table `pokemon_types`
--

DROP TABLE IF EXISTS `pokemon_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_types` (
  `pok_id` int NOT NULL,
  `type_id` int NOT NULL,
  `slot` int NOT NULL,
  PRIMARY KEY (`pok_id`,`slot`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `pokemon_types_ibfk_1` FOREIGN KEY (`pok_id`) REFERENCES `pokemon` (`pok_id`),
  CONSTRAINT `pokemon_types_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `types` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_types`
--

LOCK TABLES `pokemon_types` WRITE;
/*!40000 ALTER TABLE `pokemon_types` DISABLE KEYS */;
INSERT INTO `pokemon_types` VALUES (16,1,1),(17,1,1),(18,1,1),(19,1,1),(20,1,1),(21,1,1),(22,1,1),(39,1,1),(40,1,1),(52,1,1),(53,1,1),(83,1,1),(84,1,1),(85,1,1),(108,1,1),(113,1,1),(115,1,1),(128,1,1),(132,1,1),(133,1,1),(137,1,1),(143,1,1),(161,1,1),(162,1,1),(163,1,1),(164,1,1),(174,1,1),(190,1,1),(203,1,1),(206,1,1),(216,1,1),(217,1,1),(233,1,1),(234,1,1),(241,1,1),(242,1,1),(263,1,1),(264,1,1),(276,1,1),(277,1,1),(287,1,1),(288,1,1),(289,1,1),(293,1,1),(294,1,1),(295,1,1),(298,1,1),(300,1,1),(301,1,1),(327,1,1),(333,1,1),(335,1,1),(351,1,1),(352,1,1),(396,1,1),(397,1,1),(398,1,1),(399,1,1),(400,1,1),(424,1,1),(427,1,1),(428,1,1),(431,1,1),(432,1,1),(440,1,1),(441,1,1),(446,1,1),(463,1,1),(474,1,1),(486,1,1),(493,1,1),(504,1,1),(505,1,1),(506,1,1),(507,1,1),(508,1,1),(519,1,1),(520,1,1),(521,1,1),(531,1,1),(572,1,1),(573,1,1),(56,2,1),(57,2,1),(62,2,2),(66,2,1),(67,2,1),(68,2,1),(106,2,1),(107,2,1),(214,2,2),(236,2,1),(237,2,1),(256,2,2),(257,2,2),(286,2,2),(296,2,1),(297,2,1),(307,2,1),(308,2,1),(391,2,2),(392,2,2),(447,2,1),(448,2,1),(453,2,2),(454,2,2),(475,2,2),(499,2,2),(500,2,2),(532,2,1),(533,2,1),(534,2,1),(538,2,1),(539,2,1),(559,2,2),(560,2,2),(6,3,2),(12,3,2),(16,3,2),(17,3,2),(18,3,2),(21,3,2),(22,3,2),(41,3,2),(42,3,2),(83,3,2),(84,3,2),(85,3,2),(123,3,2),(130,3,2),(142,3,2),(144,3,2),(145,3,2),(146,3,2),(149,3,2),(163,3,2),(164,3,2),(165,3,2),(166,3,2),(169,3,2),(176,3,2),(177,3,2),(178,3,2),(187,3,2),(188,3,2),(189,3,2),(193,3,2),(198,3,2),(207,3,2),(225,3,2),(226,3,2),(227,3,2),(249,3,2),(250,3,2),(267,3,2),(276,3,2),(277,3,2),(278,3,2),(279,3,2),(284,3,2),(291,3,2),(333,3,2),(334,3,2),(357,3,2),(373,3,2),(384,3,2),(396,3,2),(397,3,2),(398,3,2),(414,3,2),(415,3,2),(416,3,2),(425,3,2),(426,3,2),(430,3,2),(441,3,2),(458,3,2),(468,3,2),(469,3,2),(472,3,2),(519,3,2),(520,3,2),(521,3,2),(527,3,2),(528,3,2),(561,3,2),(566,3,2),(567,3,2),(1,4,2),(2,4,2),(3,4,2),(13,4,2),(14,4,2),(15,4,2),(23,4,1),(24,4,1),(29,4,1),(30,4,1),(31,4,1),(32,4,1),(33,4,1),(34,4,1),(41,4,1),(42,4,1),(43,4,2),(44,4,2),(45,4,2),(48,4,2),(49,4,2),(69,4,2),(70,4,2),(71,4,2),(72,4,2),(73,4,2),(88,4,1),(89,4,1),(92,4,2),(93,4,2),(94,4,2),(109,4,1),(110,4,1),(167,4,2),(168,4,2),(169,4,1),(211,4,2),(269,4,2),(315,4,2),(316,4,1),(317,4,1),(336,4,1),(406,4,2),(407,4,2),(434,4,1),(435,4,1),(451,4,1),(452,4,1),(453,4,1),(454,4,1),(543,4,2),(544,4,2),(545,4,2),(568,4,1),(569,4,1),(27,5,1),(28,5,1),(31,5,2),(34,5,2),(50,5,1),(51,5,1),(74,5,2),(75,5,2),(76,5,2),(95,5,2),(104,5,1),(105,5,1),(111,5,1),(112,5,1),(194,5,2),(195,5,2),(207,5,1),(208,5,2),(220,5,2),(221,5,2),(231,5,1),(232,5,1),(246,5,2),(247,5,2),(259,5,2),(260,5,2),(290,5,2),(322,5,2),(323,5,2),(328,5,1),(329,5,1),(330,5,1),(339,5,2),(340,5,2),(343,5,1),(344,5,1),(383,5,1),(389,5,2),(423,5,2),(443,5,2),(444,5,2),(445,5,2),(449,5,1),(450,5,1),(464,5,1),(472,5,1),(473,5,2),(529,5,1),(530,5,1),(536,5,2),(537,5,2),(551,5,1),(552,5,1),(553,5,1),(74,6,1),(75,6,1),(76,6,1),(95,6,1),(111,6,2),(112,6,2),(138,6,1),(139,6,1),(140,6,1),(141,6,1),(142,6,1),(185,6,1),(213,6,2),(219,6,2),(222,6,2),(246,6,1),(247,6,1),(248,6,1),(299,6,1),(304,6,2),(305,6,2),(306,6,2),(337,6,1),(338,6,1),(345,6,1),(346,6,1),(347,6,1),(348,6,1),(369,6,2),(377,6,1),(408,6,1),(409,6,1),(410,6,1),(411,6,1),(438,6,1),(464,6,2),(476,6,1),(524,6,1),(525,6,1),(526,6,1),(557,6,2),(558,6,2),(564,6,2),(565,6,2),(566,6,1),(567,6,1),(10,7,1),(11,7,1),(12,7,1),(13,7,1),(14,7,1),(15,7,1),(46,7,1),(47,7,1),(48,7,1),(49,7,1),(123,7,1),(127,7,1),(165,7,1),(166,7,1),(167,7,1),(168,7,1),(193,7,1),(204,7,1),(205,7,1),(212,7,1),(213,7,1),(214,7,1),(265,7,1),(266,7,1),(267,7,1),(268,7,1),(269,7,1),(283,7,1),(284,7,1),(290,7,1),(291,7,1),(292,7,1),(313,7,1),(314,7,1),(347,7,2),(348,7,2),(401,7,1),(402,7,1),(412,7,1),(413,7,1),(414,7,1),(415,7,1),(416,7,1),(451,7,2),(469,7,1),(540,7,1),(541,7,1),(542,7,1),(543,7,1),(544,7,1),(545,7,1),(557,7,1),(558,7,1),(92,8,1),(93,8,1),(94,8,1),(200,8,1),(292,8,2),(302,8,2),(353,8,1),(354,8,1),(355,8,1),(356,8,1),(425,8,1),(426,8,1),(429,8,1),(442,8,1),(477,8,1),(478,8,2),(479,8,2),(487,8,1),(562,8,1),(563,8,1),(81,9,2),(82,9,2),(205,9,2),(208,9,1),(212,9,2),(227,9,1),(303,9,1),(304,9,1),(305,9,1),(306,9,1),(374,9,1),(375,9,1),(376,9,1),(379,9,1),(385,9,1),(395,9,2),(410,9,2),(411,9,2),(436,9,1),(437,9,1),(448,9,2),(462,9,2),(476,9,2),(483,9,1),(485,9,2),(530,9,2),(4,10,1),(5,10,1),(6,10,1),(37,10,1),(38,10,1),(58,10,1),(59,10,1),(77,10,1),(78,10,1),(126,10,1),(136,10,1),(146,10,1),(155,10,1),(156,10,1),(157,10,1),(218,10,1),(219,10,1),(228,10,2),(229,10,2),(240,10,1),(244,10,1),(250,10,1),(255,10,1),(256,10,1),(257,10,1),(322,10,1),(323,10,1),(324,10,1),(390,10,1),(391,10,1),(392,10,1),(467,10,1),(485,10,1),(494,10,2),(498,10,1),(499,10,1),(500,10,1),(513,10,1),(514,10,1),(554,10,1),(555,10,1),(7,11,1),(8,11,1),(9,11,1),(54,11,1),(55,11,1),(60,11,1),(61,11,1),(62,11,1),(72,11,1),(73,11,1),(79,11,1),(80,11,1),(86,11,1),(87,11,1),(90,11,1),(91,11,1),(98,11,1),(99,11,1),(116,11,1),(117,11,1),(118,11,1),(119,11,1),(120,11,1),(121,11,1),(129,11,1),(130,11,1),(131,11,1),(134,11,1),(138,11,2),(139,11,2),(140,11,2),(141,11,2),(158,11,1),(159,11,1),(160,11,1),(170,11,1),(171,11,1),(183,11,1),(184,11,1),(186,11,1),(194,11,1),(195,11,1),(199,11,1),(211,11,1),(222,11,1),(223,11,1),(224,11,1),(226,11,1),(230,11,1),(245,11,1),(258,11,1),(259,11,1),(260,11,1),(270,11,1),(271,11,1),(272,11,1),(278,11,1),(279,11,1),(283,11,2),(318,11,1),(319,11,1),(320,11,1),(321,11,1),(339,11,1),(340,11,1),(341,11,1),(342,11,1),(349,11,1),(350,11,1),(363,11,2),(364,11,2),(365,11,2),(366,11,1),(367,11,1),(368,11,1),(369,11,1),(370,11,1),(382,11,1),(393,11,1),(394,11,1),(395,11,1),(400,11,2),(418,11,1),(419,11,1),(422,11,1),(423,11,1),(456,11,1),(457,11,1),(458,11,1),(484,11,1),(489,11,1),(490,11,1),(501,11,1),(502,11,1),(503,11,1),(515,11,1),(516,11,1),(535,11,1),(536,11,1),(537,11,1),(550,11,1),(564,11,1),(565,11,1),(1,12,1),(2,12,1),(3,12,1),(43,12,1),(44,12,1),(45,12,1),(46,12,2),(47,12,2),(69,12,1),(70,12,1),(71,12,1),(102,12,1),(103,12,1),(114,12,1),(152,12,1),(153,12,1),(154,12,1),(182,12,1),(187,12,1),(188,12,1),(189,12,1),(191,12,1),(192,12,1),(251,12,2),(252,12,1),(253,12,1),(254,12,1),(270,12,2),(271,12,2),(272,12,2),(273,12,1),(274,12,1),(275,12,1),(285,12,1),(286,12,1),(315,12,1),(331,12,1),(332,12,1),(345,12,2),(346,12,2),(357,12,1),(387,12,1),(388,12,1),(389,12,1),(406,12,1),(407,12,1),(413,12,2),(420,12,1),(421,12,1),(455,12,1),(459,12,1),(460,12,1),(465,12,1),(470,12,1),(492,12,1),(495,12,1),(496,12,1),(497,12,1),(511,12,1),(512,12,1),(540,12,2),(541,12,2),(542,12,2),(546,12,1),(547,12,1),(548,12,1),(549,12,1),(556,12,1),(25,13,1),(26,13,1),(81,13,1),(82,13,1),(100,13,1),(101,13,1),(125,13,1),(135,13,1),(145,13,1),(170,13,2),(171,13,2),(172,13,1),(179,13,1),(180,13,1),(181,13,1),(239,13,1),(243,13,1),(309,13,1),(310,13,1),(311,13,1),(312,13,1),(403,13,1),(404,13,1),(405,13,1),(417,13,1),(462,13,1),(466,13,1),(479,13,1),(522,13,1),(523,13,1),(63,14,1),(64,14,1),(65,14,1),(79,14,2),(80,14,2),(96,14,1),(97,14,1),(102,14,2),(103,14,2),(121,14,2),(122,14,1),(124,14,2),(150,14,1),(151,14,1),(177,14,1),(178,14,1),(196,14,1),(199,14,2),(201,14,1),(202,14,1),(203,14,2),(238,14,2),(249,14,1),(251,14,1),(280,14,1),(281,14,1),(282,14,1),(307,14,2),(308,14,2),(325,14,1),(326,14,1),(337,14,2),(338,14,2),(343,14,2),(344,14,2),(358,14,1),(360,14,1),(374,14,2),(375,14,2),(376,14,2),(380,14,2),(381,14,2),(385,14,2),(386,14,1),(433,14,1),(436,14,2),(437,14,2),(439,14,1),(475,14,1),(480,14,1),(481,14,1),(482,14,1),(488,14,1),(494,14,1),(517,14,1),(518,14,1),(527,14,1),(528,14,1),(561,14,1),(574,14,1),(575,14,1),(87,15,2),(91,15,2),(124,15,1),(131,15,2),(144,15,1),(215,15,2),(220,15,1),(221,15,1),(225,15,1),(238,15,1),(361,15,1),(362,15,1),(363,15,1),(364,15,1),(365,15,1),(378,15,1),(459,15,2),(460,15,2),(461,15,2),(471,15,1),(473,15,1),(478,15,1),(147,16,1),(148,16,1),(149,16,1),(230,16,2),(329,16,2),(330,16,2),(334,16,1),(371,16,1),(372,16,1),(373,16,1),(380,16,1),(381,16,1),(384,16,1),(443,16,1),(444,16,1),(445,16,1),(483,16,2),(484,16,2),(487,16,2),(197,17,1),(198,17,1),(215,17,1),(228,17,1),(229,17,1),(248,17,2),(261,17,1),(262,17,1),(274,17,2),(275,17,2),(302,17,1),(318,17,2),(319,17,2),(332,17,2),(342,17,2),(359,17,1),(430,17,1),(434,17,2),(435,17,2),(442,17,2),(452,17,2),(461,17,1),(491,17,1),(509,17,1),(510,17,1),(551,17,2),(552,17,2),(553,17,2),(559,17,1),(560,17,1),(570,17,1),(571,17,1),(35,18,1),(36,18,1),(39,18,2),(40,18,2),(122,18,2),(173,18,1),(174,18,2),(175,18,1),(176,18,1),(183,18,2),(184,18,2),(209,18,1),(210,18,1),(280,18,2),(281,18,2),(282,18,2),(298,18,2),(303,18,2),(439,18,2),(468,18,1),(546,18,2),(547,18,2);
/*!40000 ALTER TABLE `pokemon_types` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-15  5:11:05
