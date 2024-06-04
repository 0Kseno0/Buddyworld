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
-- Table structure for table `moves`
--

DROP TABLE IF EXISTS `moves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moves` (
  `move_id` int NOT NULL AUTO_INCREMENT,
  `move_name` varchar(79) NOT NULL,
  `type_id` int NOT NULL,
  `move_power` smallint DEFAULT NULL,
  `move_pp` smallint DEFAULT NULL,
  `move_accuracy` smallint DEFAULT NULL,
  `category` int DEFAULT NULL,
  PRIMARY KEY (`move_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `moves_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `types` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=622 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moves`
--

LOCK TABLES `moves` WRITE;
/*!40000 ALTER TABLE `moves` DISABLE KEYS */;
INSERT INTO `moves` VALUES (2,'karate-chop',2,50,25,100,1),(3,'double-slap',1,15,10,85,1),(4,'comet-punch',1,18,15,85,1),(5,'mega-punch',1,80,20,85,1),(6,'pay-day',1,40,20,100,1),(7,'fire-punch',10,75,15,100,1),(8,'ice-punch',15,75,15,100,1),(9,'thunder-punch',13,75,15,100,1),(10,'scratch',1,40,35,100,1),(11,'vice-grip',1,55,30,100,1),(12,'guillotine',1,NULL,5,30,1),(13,'razor-wind',1,80,10,100,2),(14,'swords-dance',1,NULL,20,NULL,0),(15,'cut',1,50,30,95,1),(16,'gust',3,40,35,100,2),(17,'wing-attack',3,60,35,100,1),(19,'fly',3,90,15,95,1),(20,'bind',1,15,20,85,1),(21,'slam',1,80,20,75,1),(22,'vine-whip',12,45,25,100,1),(23,'stomp',1,65,20,100,1),(24,'double-kick',2,30,30,100,1),(25,'mega-kick',1,120,5,75,1),(26,'jump-kick',2,100,10,95,1),(27,'rolling-kick',2,60,15,85,1),(28,'sand-attack',5,NULL,15,100,0),(29,'headbutt',1,70,15,100,1),(30,'horn-attack',1,65,25,100,1),(31,'fury-attack',1,15,20,85,1),(32,'horn-drill',1,NULL,5,30,1),(33,'tackle',1,50,35,100,1),(34,'body-slam',1,85,15,100,1),(35,'wrap',1,15,20,90,1),(36,'take-down',1,90,20,85,1),(37,'thrash',1,120,10,100,1),(38,'double-edge',1,120,15,100,1),(39,'tail-whip',1,NULL,30,100,0),(40,'poison-sting',4,15,35,100,1),(41,'twineedle',7,25,20,100,1),(42,'pin-missile',7,25,20,95,1),(43,'leer',1,NULL,30,100,0),(44,'bite',17,60,25,100,1),(45,'growl',1,NULL,40,100,0),(47,'sing',1,NULL,15,55,0),(48,'supersonic',1,NULL,20,55,0),(49,'sonic-boom',1,NULL,20,90,2),(51,'acid',4,40,30,100,2),(52,'ember',10,40,25,100,2),(53,'flamethrower',10,90,15,100,2),(55,'water-gun',11,40,25,100,2),(56,'hydro-pump',11,110,5,80,2),(57,'surf',11,90,15,100,2),(58,'ice-beam',15,90,10,100,2),(59,'blizzard',15,110,5,70,2),(60,'psybeam',14,65,20,100,2),(61,'bubble-beam',11,65,20,100,2),(62,'aurora-beam',15,65,20,100,2),(63,'hyper-beam',1,150,5,90,2),(64,'peck',3,35,35,100,1),(65,'drill-peck',3,80,20,100,1),(66,'submission',2,80,20,80,1),(67,'low-kick',2,NULL,20,100,1),(69,'seismic-toss',2,NULL,20,100,1),(70,'strength',1,80,15,100,1),(71,'absorb',12,20,25,100,2),(72,'mega-drain',12,40,15,100,2),(74,'growth',1,NULL,20,NULL,0),(75,'razor-leaf',12,55,25,95,1),(76,'solar-beam',12,120,10,100,2),(77,'poison-powder',4,NULL,35,75,0),(78,'stun-spore',12,NULL,30,75,0),(79,'sleep-powder',12,NULL,15,75,0),(80,'petal-dance',12,120,10,100,2),(81,'string-shot',7,NULL,40,95,0),(82,'dragon-rage',16,NULL,10,100,2),(83,'fire-spin',10,35,15,85,2),(84,'thunder-shock',13,40,30,100,2),(85,'thunderbolt',13,90,15,100,2),(86,'thunder-wave',13,NULL,20,100,0),(87,'thunder',13,110,10,70,2),(88,'rock-throw',6,50,15,90,1),(89,'earthquake',5,100,10,100,1),(90,'fissure',5,NULL,5,30,1),(91,'dig',5,80,10,100,1),(92,'toxic',4,NULL,10,90,0),(93,'confusion',14,50,25,100,2),(94,'psychic',14,90,10,100,2),(95,'hypnosis',14,NULL,20,60,0),(96,'meditate',14,NULL,40,NULL,0),(97,'agility',14,NULL,30,NULL,0),(98,'quick-attack',1,40,30,100,1),(101,'night-shade',8,NULL,15,100,2),(103,'screech',1,NULL,40,85,0),(105,'recover',1,NULL,10,NULL,0),(106,'harden',1,NULL,30,NULL,0),(108,'smokescreen',1,NULL,20,100,0),(109,'confuse-ray',8,NULL,10,100,0),(110,'withdraw',11,NULL,40,NULL,0),(111,'defense-curl',1,NULL,40,NULL,0),(112,'barrier',14,NULL,20,NULL,0),(113,'light-screen',14,NULL,30,NULL,0),(114,'haze',15,NULL,30,NULL,0),(115,'reflect',14,NULL,20,NULL,0),(116,'focus-energy',1,NULL,30,NULL,0),(120,'self-destruct',1,200,5,100,1),(121,'egg-bomb',1,100,10,75,1),(122,'lick',8,30,30,100,1),(123,'smog',4,30,20,70,2),(124,'sludge',4,65,20,100,2),(125,'bone-club',5,65,20,85,1),(126,'fire-blast',10,110,5,85,2),(127,'waterfall',11,80,15,100,1),(128,'clamp',11,35,15,85,1),(129,'swift',1,60,20,NULL,2),(130,'skull-bash',1,130,10,100,1),(131,'spike-cannon',1,20,15,100,1),(132,'constrict',1,10,35,100,1),(133,'amnesia',14,NULL,20,NULL,0),(134,'kinesis',14,NULL,15,80,0),(135,'soft-boiled',1,NULL,10,NULL,0),(136,'high-jump-kick',2,130,10,90,1),(137,'glare',1,NULL,30,100,0),(138,'dream-eater',14,100,15,100,2),(139,'poison-gas',4,NULL,40,90,0),(140,'barrage',1,15,20,85,1),(141,'leech-life',7,20,15,100,1),(142,'lovely-kiss',1,NULL,10,75,0),(144,'transform',1,NULL,10,NULL,0),(145,'bubble',11,40,30,100,2),(146,'dizzy-punch',1,70,10,100,1),(147,'spore',12,NULL,15,100,0),(148,'flash',1,NULL,20,100,0),(149,'psywave',14,NULL,15,100,2),(150,'splash',1,NULL,40,NULL,0),(151,'acid-armor',4,NULL,20,NULL,0),(152,'crabhammer',11,100,10,90,1),(153,'explosion',1,250,5,100,1),(154,'fury-swipes',1,18,15,80,1),(155,'bonemerang',5,50,10,90,1),(156,'rest',14,NULL,10,NULL,0),(157,'rock-slide',6,75,10,90,1),(158,'hyper-fang',1,80,15,90,1),(159,'sharpen',1,NULL,30,NULL,0),(161,'tri-attack',1,80,10,100,2),(162,'super-fang',1,NULL,10,90,1),(163,'slash',1,70,20,100,1),(167,'triple-kick',2,10,10,90,1),(172,'flame-wheel',10,60,25,100,1),(173,'snore',1,50,15,100,2),(174,'curse',8,NULL,10,NULL,0),(175,'flail',1,NULL,15,100,1),(177,'aeroblast',3,100,5,95,2),(178,'cotton-spore',12,NULL,40,100,0),(179,'reversal',2,NULL,15,100,1),(181,'powder-snow',15,40,25,100,2),(183,'mach-punch',2,40,30,100,1),(184,'scary-face',1,NULL,10,100,0),(185,'feint-attack',17,60,20,NULL,1),(186,'sweet-kiss',18,NULL,10,75,0),(187,'belly-drum',1,NULL,10,NULL,0),(188,'sludge-bomb',4,90,10,100,2),(189,'mud-slap',5,20,10,100,2),(190,'octazooka',11,65,10,85,2),(192,'zap-cannon',13,120,5,50,2),(196,'icy-wind',15,55,15,95,2),(198,'bone-rush',5,25,10,90,1),(200,'outrage',16,120,10,100,1),(201,'sandstorm',6,NULL,10,NULL,0),(202,'giga-drain',12,75,10,100,2),(203,'endure',1,NULL,10,NULL,0),(204,'charm',18,NULL,20,100,0),(205,'rollout',6,30,20,90,1),(207,'swagger',1,NULL,15,90,0),(208,'milk-drink',1,NULL,10,NULL,0),(209,'spark',13,65,20,100,1),(210,'fury-cutter',7,40,20,95,1),(211,'steel-wing',9,70,25,90,1),(215,'heal-bell',1,NULL,5,NULL,0),(217,'present',1,NULL,15,90,1),(219,'safeguard',1,NULL,25,NULL,0),(220,'pain-split',1,NULL,20,NULL,0),(221,'sacred-fire',10,100,5,95,1),(222,'magnitude',5,NULL,30,100,1),(223,'dynamic-punch',2,100,5,50,1),(224,'megahorn',7,120,10,85,1),(225,'dragon-breath',16,60,20,100,2),(228,'pursuit',17,40,20,100,1),(229,'rapid-spin',1,20,40,100,1),(230,'sweet-scent',1,NULL,20,100,0),(231,'iron-tail',9,100,15,75,1),(232,'metal-claw',9,50,35,95,1),(233,'vital-throw',2,70,10,NULL,1),(237,'hidden-power',1,60,15,100,2),(238,'cross-chop',2,100,5,80,1),(239,'twister',16,40,20,100,2),(240,'rain-dance',11,NULL,5,NULL,0),(241,'sunny-day',10,NULL,5,NULL,0),(242,'crunch',17,80,15,100,1),(244,'psych-up',1,NULL,10,NULL,0),(245,'extreme-speed',1,80,5,100,1),(246,'ancient-power',6,60,5,100,2),(247,'shadow-ball',8,80,15,100,2),(249,'rock-smash',2,40,15,100,1),(250,'whirlpool',11,35,15,85,2),(253,'uproar',1,90,10,100,2),(257,'heat-wave',10,95,10,90,2),(258,'hail',15,NULL,10,NULL,0),(260,'flatter',17,NULL,15,100,0),(261,'will-o-wisp',10,NULL,15,85,0),(263,'facade',1,70,20,100,1),(265,'smelling-salts',1,70,10,100,1),(276,'superpower',2,120,5,100,1),(280,'brick-break',2,75,15,100,1),(281,'yawn',1,NULL,10,NULL,0),(283,'endeavor',1,NULL,5,100,1),(284,'eruption',10,150,5,100,2),(287,'refresh',1,NULL,20,NULL,0),(291,'dive',11,80,10,100,1),(292,'arm-thrust',2,15,20,100,1),(294,'tail-glow',7,NULL,20,NULL,0),(295,'luster-purge',14,70,5,100,2),(296,'mist-ball',14,70,5,100,2),(297,'feather-dance',3,NULL,15,100,0),(298,'teeter-dance',1,NULL,20,100,0),(299,'blaze-kick',10,85,10,90,1),(302,'needle-arm',12,60,15,100,1),(303,'slack-off',1,NULL,10,NULL,0),(304,'hyper-voice',1,90,10,100,2),(305,'poison-fang',4,50,15,100,1),(306,'crush-claw',1,75,10,95,1),(309,'meteor-mash',9,90,10,90,1),(310,'astonish',8,30,15,100,1),(312,'aromatherapy',12,NULL,5,NULL,0),(313,'fake-tears',17,NULL,20,100,0),(314,'air-cutter',3,60,25,95,2),(315,'overheat',10,130,5,90,2),(317,'rock-tomb',6,60,15,95,1),(318,'silver-wind',7,60,5,100,2),(319,'metal-sound',9,NULL,40,85,0),(320,'grass-whistle',12,NULL,15,55,0),(321,'tickle',1,NULL,20,100,0),(322,'cosmic-power',14,NULL,20,NULL,0),(323,'water-spout',11,150,5,100,2),(324,'signal-beam',7,75,15,100,2),(325,'shadow-punch',8,60,20,NULL,1),(326,'extrasensory',14,80,20,100,2),(327,'sky-uppercut',2,85,15,90,1),(328,'sand-tomb',5,35,15,85,1),(329,'sheer-cold',15,NULL,5,30,2),(330,'muddy-water',11,90,10,85,2),(331,'bullet-seed',12,25,30,100,1),(332,'aerial-ace',3,60,20,NULL,1),(333,'icicle-spear',15,25,30,100,1),(336,'howl',1,NULL,40,NULL,0),(337,'dragon-claw',16,80,15,100,1),(339,'bulk-up',2,NULL,20,NULL,0),(340,'bounce',3,85,5,85,1),(341,'mud-shot',5,55,15,95,2),(342,'poison-tail',4,50,25,100,1),(344,'volt-tackle',13,120,15,100,1),(345,'magical-leaf',12,60,20,NULL,2),(347,'calm-mind',14,NULL,20,NULL,0),(348,'leaf-blade',12,90,15,100,1),(349,'dragon-dance',16,NULL,20,NULL,0),(350,'rock-blast',6,25,10,90,1),(351,'shock-wave',13,60,20,NULL,2),(352,'water-pulse',11,60,20,100,2),(354,'psycho-boost',14,140,5,90,1),(355,'roost',3,NULL,10,NULL,0);
/*!40000 ALTER TABLE `moves` ENABLE KEYS */;
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
