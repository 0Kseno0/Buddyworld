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
-- Table structure for table `abilities`
--

DROP TABLE IF EXISTS `abilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abilities` (
  `abil_id` int NOT NULL AUTO_INCREMENT,
  `abil_name` varchar(79) NOT NULL,
  PRIMARY KEY (`abil_id`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abilities`
--

LOCK TABLES `abilities` WRITE;
/*!40000 ALTER TABLE `abilities` DISABLE KEYS */;
INSERT INTO `abilities` VALUES (2,'drizzle'),(3,'speed-boost'),(4,'battle-armor'),(5,'sturdy'),(6,'damp'),(7,'limber'),(8,'sand-veil'),(9,'static'),(10,'volt-absorb'),(11,'water-absorb'),(12,'oblivious'),(13,'cloud-nine'),(14,'compound-eyes'),(15,'insomnia'),(16,'color-change'),(17,'immunity'),(18,'flash-fire'),(19,'shield-dust'),(20,'own-tempo'),(21,'suction-cups'),(22,'intimidate'),(23,'shadow-tag'),(24,'rough-skin'),(25,'wonder-guard'),(26,'levitate'),(27,'effect-spore'),(28,'synchronize'),(29,'clear-body'),(30,'natural-cure'),(31,'lightning-rod'),(32,'serene-grace'),(33,'swift-swim'),(34,'chlorophyll'),(35,'illuminate'),(36,'trace'),(37,'huge-power'),(38,'poison-point'),(39,'inner-focus'),(40,'magma-armor'),(41,'water-veil'),(42,'magnet-pull'),(43,'soundproof'),(44,'rain-dish'),(45,'sand-stream'),(46,'pressure'),(47,'thick-fat'),(48,'early-bird'),(49,'flame-body'),(50,'run-away'),(51,'keen-eye'),(52,'hyper-cutter'),(53,'pickup'),(54,'truant'),(55,'hustle'),(56,'cute-charm'),(57,'plus'),(58,'minus'),(59,'forecast'),(60,'sticky-hold'),(61,'shed-skin'),(62,'guts'),(63,'marvel-scale'),(64,'liquid-ooze'),(65,'overgrow'),(66,'blaze'),(67,'torrent'),(68,'swarm'),(69,'rock-head'),(70,'drought'),(71,'arena-trap'),(72,'vital-spirit'),(73,'white-smoke'),(74,'pure-power'),(75,'shell-armor'),(76,'air-lock'),(77,'tangled-feet'),(78,'motor-drive'),(79,'rivalry'),(80,'steadfast'),(81,'snow-cloak'),(82,'gluttony'),(83,'anger-point'),(84,'unburden'),(85,'heatproof'),(86,'simple'),(87,'dry-skin'),(88,'download'),(89,'iron-fist'),(90,'poison-heal'),(91,'adaptability'),(92,'skill-link'),(93,'hydration'),(94,'solar-power'),(95,'quick-feet'),(96,'normalize'),(97,'sniper'),(98,'magic-guard'),(99,'no-guard'),(100,'stall'),(101,'technician'),(102,'leaf-guard'),(103,'klutz'),(104,'mold-breaker'),(105,'super-luck'),(106,'aftermath'),(107,'anticipation'),(108,'forewarn'),(109,'unaware'),(110,'tinted-lens'),(111,'filter'),(112,'slow-start'),(113,'scrappy'),(114,'storm-drain'),(115,'ice-body'),(116,'solid-rock'),(117,'snow-warning'),(118,'honey-gather'),(119,'frisk'),(120,'reckless'),(121,'multitype'),(122,'flower-gift'),(123,'bad-dreams'),(124,'pickpocket'),(125,'sheer-force'),(126,'contrary'),(127,'unnerve'),(128,'defiant'),(129,'defeatist'),(130,'cursed-body'),(131,'healer'),(132,'friend-guard'),(133,'weak-armor'),(134,'heavy-metal'),(135,'light-metal'),(136,'multiscale'),(137,'toxic-boost'),(138,'flare-boost'),(139,'harvest'),(140,'telepathy'),(141,'moody'),(142,'overcoat'),(143,'poison-touch'),(144,'regenerator'),(145,'big-pecks'),(146,'sand-rush'),(147,'wonder-skin'),(148,'analytic'),(149,'illusion'),(150,'imposter'),(151,'infiltrator'),(152,'mummy'),(153,'moxie'),(154,'justified'),(155,'rattled'),(156,'magic-bounce'),(157,'sap-sipper'),(158,'prankster'),(159,'sand-force'),(160,'iron-barbs'),(161,'zen-mode'),(162,'victory-star'),(163,'turboblaze'),(164,'teravolt'),(165,'aroma-veil'),(166,'flower-veil'),(167,'cheek-pouch'),(168,'protean'),(169,'fur-coat'),(170,'magician'),(171,'bulletproof'),(172,'competitive'),(173,'strong-jaw'),(174,'refrigerate'),(175,'sweet-veil'),(176,'stance-change'),(177,'gale-wings'),(178,'mega-launcher'),(179,'grass-pelt'),(180,'symbiosis'),(181,'tough-claws'),(182,'pixilate'),(183,'gooey'),(184,'aerilate'),(185,'parental-bond'),(186,'dark-aura'),(187,'fairy-aura'),(188,'aura-break'),(189,'primordial-sea'),(190,'desolate-land'),(191,'delta-stream');
/*!40000 ALTER TABLE `abilities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-21  8:59:34
