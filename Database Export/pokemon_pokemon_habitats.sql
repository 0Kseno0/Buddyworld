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
-- Table structure for table `pokemon_habitats`
--

DROP TABLE IF EXISTS `pokemon_habitats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_habitats` (
  `hab_id` int NOT NULL,
  `hab_name` varchar(79) NOT NULL,
  `hab_descript` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`hab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_habitats`
--

LOCK TABLES `pokemon_habitats` WRITE;
/*!40000 ALTER TABLE `pokemon_habitats` DISABLE KEYS */;
INSERT INTO `pokemon_habitats` VALUES (1,'cave','This is your underground habitat, typically natural, but also including man-made mines and tunnels through the mountains.'),(2,'forest','Forests are typically you more traditional woodlands where there are large gatherings of standing trees, mostly deciduous and/or evergreens.'),(3,'grassland','Typically, grasslands are rolling plains, but grasslands can be as simple as what their name entitles: anyplace where the main vegetation isn\'t standing trees, ranging from simple common grass to farmlands of wheat/cotton/corn or otherwise.'),(4,'mountain','Mountains are elevated environments that range in variance of both height and features. Some are tall and rocky ranges. Some are snowy forested peaks.'),(5,'rare','Non-Space is a unique habitat. Its not truly defined. The easiest way to describe it is to state that \"Non-Space\" doesn\'t exist in our reality, but more as another alternative dimension of nonexistence. '),(6,'rough-terrain','Wastelands. Badlands. Dry air, little water to drink, and sand as far as the eye can see. Cold or warm deserts exist, but one thing they have in common: They are extreme environments where only the most adaptable to the harsh conditions survive.'),(7,'sea','Saltwater oceans and seas are the Ocean habitat, ranging from its surface to its darkest depths far below sea-level where even light doesn\'t reach into the abyss of darkness. Commonplace, Ocean habitats go hand-in-hand with the Beach habitat when near land, but otherwise, this habitat doesn\'t include land: its all saltwater!'),(8,'urban','The last habitat, Urban, is the man-made habitat of urbanization and industrialization. Towns, Cities, Settlements. Places where people gather in large populations where the wilderness has been claimed by humans and made less natural. It ranges from the streets and parks, to alleys and even sewer systems that make a city what it is. '),(9,'waters-edge','Lakes, rivers, streams, and ponds. If it is water and isn\'t saltwater oceans/seas, its going to be freshwater. Freshwater is mostly commonplace anywhere inland that water can be found naturally. Just make sure the water the pokemon can be found in is deep enough for it! Freshwater can range from the surface of the water, its shoreline, and to underwater environments.'),(10,'Unknown','Unknown');
/*!40000 ALTER TABLE `pokemon_habitats` ENABLE KEYS */;
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
