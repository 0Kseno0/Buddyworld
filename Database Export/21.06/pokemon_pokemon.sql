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
-- Table structure for table `pokemon`
--

DROP TABLE IF EXISTS `pokemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon` (
  `pok_id` int NOT NULL AUTO_INCREMENT,
  `pok_name` varchar(79) NOT NULL,
  `pok_height` int DEFAULT NULL,
  `pok_weight` int DEFAULT NULL,
  `pok_base_experience` int DEFAULT NULL,
  PRIMARY KEY (`pok_id`)
) ENGINE=InnoDB AUTO_INCREMENT=724 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon`
--

LOCK TABLES `pokemon` WRITE;
/*!40000 ALTER TABLE `pokemon` DISABLE KEYS */;
INSERT INTO `pokemon` VALUES (1,'bulbasaur',7,69,64),(2,'ivysaur',10,130,142),(3,'venusaur',20,1000,236),(4,'charmander',6,85,62),(5,'charmeleon',11,190,142),(6,'charizard',17,905,240),(7,'squirtle',5,90,63),(8,'wartortle',10,225,142),(9,'blastoise',16,855,239),(10,'caterpie',3,29,39),(11,'metapod',7,99,72),(12,'butterfree',11,320,178),(13,'weedle',3,32,39),(14,'kakuna',6,100,72),(15,'beedrill',10,295,178),(16,'pidgey',3,18,50),(17,'pidgeotto',11,300,122),(18,'pidgeot',15,395,216),(19,'rattata',3,35,51),(20,'raticate',7,185,145),(21,'spearow',3,20,52),(22,'fearow',12,380,155),(23,'ekans',20,69,58),(24,'arbok',35,650,153),(25,'pikachu',4,60,112),(26,'raichu',8,300,218),(27,'sandshrew',6,120,60),(28,'sandslash',10,295,158),(29,'nidoran-f',4,70,55),(30,'nidorina',8,200,128),(31,'nidoqueen',13,600,227),(32,'nidoran-m',5,90,55),(33,'nidorino',9,195,128),(34,'nidoking',14,620,227),(35,'clefairy',6,75,113),(36,'clefable',13,400,217),(37,'vulpix',6,99,60),(38,'ninetales',11,199,177),(39,'jigglypuff',5,55,95),(40,'wigglytuff',10,120,196),(41,'zubat',8,75,49),(42,'golbat',16,550,159),(43,'oddish',5,54,64),(44,'gloom',8,86,138),(45,'vileplume',12,186,221),(46,'paras',3,54,57),(47,'parasect',10,295,142),(48,'venonat',10,300,61),(49,'venomoth',15,125,158),(50,'diglett',2,8,53),(51,'dugtrio',7,333,142),(52,'meowth',4,42,58),(53,'persian',10,320,154),(54,'psyduck',8,196,64),(55,'golduck',17,766,175),(56,'mankey',5,280,61),(57,'primeape',10,320,159),(58,'growlithe',7,190,70),(59,'arcanine',19,1550,194),(60,'poliwag',6,124,60),(61,'poliwhirl',10,200,135),(62,'poliwrath',13,540,230),(63,'abra',9,195,62),(64,'kadabra',13,565,140),(65,'alakazam',15,480,225),(66,'machop',8,195,61),(67,'machoke',15,705,142),(68,'machamp',16,1300,227),(69,'bellsprout',7,40,60),(70,'weepinbell',10,64,137),(71,'victreebel',17,155,221),(72,'tentacool',9,455,67),(73,'tentacruel',16,550,180),(74,'geodude',4,200,60),(75,'graveler',10,1050,137),(76,'golem',14,3000,223),(77,'ponyta',10,300,82),(78,'rapidash',17,950,175),(79,'slowpoke',12,360,63),(80,'slowbro',16,785,172),(81,'magnemite',3,60,65),(82,'magneton',10,600,163),(83,'farfetchd',8,150,123),(84,'doduo',14,392,62),(85,'dodrio',18,852,161),(86,'seel',11,900,65),(87,'dewgong',17,1200,166),(88,'grimer',9,300,65),(89,'muk',12,300,175),(90,'shellder',3,40,61),(91,'cloyster',15,1325,184),(92,'gastly',13,1,62),(93,'haunter',16,1,142),(94,'gengar',15,405,225),(95,'onix',88,2100,77),(96,'drowzee',10,324,66),(97,'hypno',16,756,169),(98,'krabby',4,65,65),(99,'kingler',13,600,166),(100,'voltorb',5,104,66),(101,'electrode',12,666,168),(102,'exeggcute',4,25,65),(103,'exeggutor',20,1200,182),(104,'cubone',4,65,64),(105,'marowak',10,450,149),(106,'hitmonlee',15,498,159),(107,'hitmonchan',14,502,159),(108,'lickitung',12,655,77),(109,'koffing',6,10,68),(110,'weezing',12,95,172),(111,'rhyhorn',10,1150,69),(112,'rhydon',19,1200,170),(113,'chansey',11,346,395),(114,'tangela',10,350,87),(115,'kangaskhan',22,800,172),(116,'horsea',4,80,59),(117,'seadra',12,250,154),(118,'goldeen',6,150,64),(119,'seaking',13,390,158),(120,'staryu',8,345,68),(121,'starmie',11,800,182),(122,'mr-mime',13,545,161),(123,'scyther',15,560,100),(124,'jynx',14,406,159),(125,'electabuzz',11,300,172),(126,'magmar',13,445,173),(127,'pinsir',15,550,175),(128,'tauros',14,884,172),(129,'magikarp',9,100,40),(130,'gyarados',65,2350,189),(131,'lapras',25,2200,187),(132,'ditto',3,40,101),(133,'eevee',3,65,65),(134,'vaporeon',10,290,184),(135,'jolteon',8,245,184),(136,'flareon',9,250,184),(137,'porygon',8,365,79),(138,'omanyte',4,75,71),(139,'omastar',10,350,173),(140,'kabuto',5,115,71),(141,'kabutops',13,405,173),(142,'aerodactyl',18,590,180),(143,'snorlax',21,4600,189),(144,'articuno',17,554,261),(145,'zapdos',16,526,261),(146,'moltres',20,600,261),(147,'dratini',18,33,60),(148,'dragonair',40,165,147),(149,'dragonite',22,2100,270),(150,'mewtwo',20,1220,306),(151,'mew',4,40,270),(152,'chikorita',9,64,64),(153,'bayleef',12,158,142),(154,'meganium',18,1005,236),(155,'cyndaquil',5,79,62),(156,'quilava',9,190,142),(157,'typhlosion',17,795,240),(158,'totodile',6,95,63),(159,'croconaw',11,250,142),(160,'feraligatr',23,888,239),(161,'sentret',8,60,43),(162,'furret',18,325,145),(163,'hoothoot',7,212,52),(164,'noctowl',16,408,155),(165,'ledyba',10,108,53),(166,'ledian',14,356,137),(167,'spinarak',5,85,50),(168,'ariados',11,335,137),(169,'crobat',18,750,241),(170,'chinchou',5,120,66),(171,'lanturn',12,225,161),(172,'pichu',3,20,41),(173,'cleffa',3,30,44),(174,'igglybuff',3,10,42),(175,'togepi',3,15,49),(176,'togetic',6,32,142),(177,'natu',2,20,64),(178,'xatu',15,150,165),(179,'mareep',6,78,56),(180,'flaaffy',8,133,128),(181,'ampharos',14,615,230),(182,'bellossom',4,58,221),(183,'marill',4,85,88),(184,'azumarill',8,285,189),(185,'sudowoodo',12,380,144),(186,'politoed',11,339,225),(187,'hoppip',4,5,50),(188,'skiploom',6,10,119),(189,'jumpluff',8,30,207),(190,'aipom',8,115,72),(191,'sunkern',3,18,36),(192,'sunflora',8,85,149),(193,'yanma',12,380,78),(194,'wooper',4,85,42),(195,'quagsire',14,750,151),(196,'espeon',9,265,184),(197,'umbreon',10,270,184),(198,'murkrow',5,21,81),(199,'slowking',20,795,172),(200,'misdreavus',7,10,87),(201,'unown',5,50,118),(202,'wobbuffet',13,285,142),(203,'girafarig',15,415,159),(204,'pineco',6,72,58),(205,'forretress',12,1258,163),(206,'dunsparce',15,140,145),(207,'gligar',11,648,86),(208,'steelix',92,4000,179),(209,'snubbull',6,78,60),(210,'granbull',14,487,158),(211,'qwilfish',5,39,86),(212,'scizor',18,1180,175),(213,'shuckle',6,205,177),(214,'heracross',15,540,175),(215,'sneasel',9,280,86),(216,'teddiursa',6,88,66),(217,'ursaring',18,1258,175),(218,'slugma',7,350,50),(219,'magcargo',8,550,144),(220,'swinub',4,65,50),(221,'piloswine',11,558,158),(222,'corsola',6,50,133),(223,'remoraid',6,120,60),(224,'octillery',9,285,168),(225,'delibird',9,160,116),(226,'mantine',21,2200,163),(227,'skarmory',17,505,163),(228,'houndour',6,108,66),(229,'houndoom',14,350,175),(230,'kingdra',18,1520,243),(231,'phanpy',5,335,66),(232,'donphan',11,1200,175),(233,'porygon2',6,325,180),(234,'stantler',14,712,163),(236,'tyrogue',7,210,42),(237,'hitmontop',14,480,159),(238,'smoochum',4,60,61),(239,'elekid',6,235,72),(240,'magby',7,214,73),(241,'miltank',12,755,172),(242,'blissey',15,468,608),(243,'raikou',19,1780,261),(244,'entei',21,1980,261),(245,'suicune',20,1870,261),(246,'larvitar',6,720,60),(247,'pupitar',12,1520,144),(248,'tyranitar',20,2020,270),(249,'lugia',52,2160,306),(250,'ho-oh',38,1990,306),(251,'celebi',6,50,270),(252,'treecko',5,50,62),(253,'grovyle',9,216,142),(254,'sceptile',17,522,239),(255,'torchic',4,25,62),(256,'combusken',9,195,142),(257,'blaziken',19,520,239),(258,'mudkip',4,76,62),(259,'marshtomp',7,280,142),(260,'swampert',15,819,241),(261,'poochyena',5,136,44),(262,'mightyena',10,370,147),(263,'zigzagoon',4,175,48),(264,'linoone',5,325,147),(265,'wurmple',3,36,39),(266,'silcoon',6,100,72),(267,'beautifly',10,284,178),(268,'cascoon',7,115,41),(269,'dustox',12,316,135),(270,'lotad',5,26,44),(271,'lombre',12,325,119),(272,'ludicolo',15,550,216),(273,'seedot',5,40,44),(274,'nuzleaf',10,280,119),(275,'shiftry',13,596,216),(276,'taillow',3,23,54),(277,'swellow',7,198,151),(278,'wingull',6,95,54),(279,'pelipper',12,280,151),(280,'ralts',4,66,40),(281,'kirlia',8,202,97),(282,'gardevoir',16,484,233),(283,'surskit',5,17,54),(284,'masquerain',8,36,145),(285,'shroomish',4,45,59),(286,'breloom',12,392,161),(287,'slakoth',8,240,56),(288,'vigoroth',14,465,154),(289,'slaking',20,1305,252),(290,'nincada',5,55,53),(291,'ninjask',8,120,160),(292,'shedinja',8,12,83),(293,'whismur',6,163,48),(294,'loudred',10,405,126),(295,'exploud',15,840,221),(296,'makuhita',10,864,47),(297,'hariyama',23,2538,166),(298,'azurill',2,20,38),(299,'nosepass',10,970,75),(300,'skitty',6,110,52),(301,'delcatty',11,326,133),(302,'sableye',5,110,133),(303,'mawile',6,115,133),(304,'aron',4,600,66),(305,'lairon',9,1200,151),(306,'aggron',21,3600,239),(307,'meditite',6,112,56),(308,'medicham',13,315,144),(309,'electrike',6,152,59),(310,'manectric',15,402,166),(311,'plusle',4,42,142),(312,'minun',4,42,142),(313,'volbeat',7,177,140),(314,'illumise',6,177,140),(315,'roselia',3,20,140),(316,'gulpin',4,103,60),(317,'swalot',17,800,163),(318,'carvanha',8,208,61),(319,'sharpedo',18,888,161),(320,'wailmer',20,1300,80),(321,'wailord',145,3980,175),(322,'numel',7,240,61),(323,'camerupt',19,2200,161),(324,'torkoal',5,804,165),(325,'spoink',7,306,66),(326,'grumpig',9,715,165),(327,'spinda',11,50,126),(328,'trapinch',7,150,58),(329,'vibrava',11,153,119),(330,'flygon',20,820,234),(331,'cacnea',4,513,67),(332,'cacturne',13,774,166),(333,'swablu',4,12,62),(334,'altaria',11,206,172),(335,'zangoose',13,403,160),(336,'seviper',27,525,160),(337,'lunatone',10,1680,154),(338,'solrock',12,1540,154),(339,'barboach',4,19,58),(340,'whiscash',9,236,164),(341,'corphish',6,115,62),(342,'crawdaunt',11,328,164),(343,'baltoy',5,215,60),(344,'claydol',15,1080,175),(345,'lileep',10,238,71),(346,'cradily',15,604,173),(347,'anorith',7,125,71),(348,'armaldo',15,682,173),(349,'feebas',6,74,40),(350,'milotic',62,1620,189),(351,'castform',3,8,147),(352,'kecleon',10,220,154),(353,'shuppet',6,23,59),(354,'banette',11,125,159),(355,'duskull',8,150,59),(356,'dusclops',16,306,159),(357,'tropius',20,1000,161),(358,'chimecho',6,10,149),(359,'absol',12,470,163),(360,'wynaut',6,140,52),(361,'snorunt',7,168,60),(362,'glalie',15,2565,168),(363,'spheal',8,395,58),(364,'sealeo',11,876,144),(365,'walrein',14,1506,239),(366,'clamperl',4,525,69),(367,'huntail',17,270,170),(368,'gorebyss',18,226,170),(369,'relicanth',10,234,170),(370,'luvdisc',6,87,116),(371,'bagon',6,421,60),(372,'shelgon',11,1105,147),(373,'salamence',15,1026,270),(374,'beldum',6,952,60),(375,'metang',12,2025,147),(376,'metagross',16,5500,270),(377,'regirock',17,2300,261),(378,'regice',18,1750,261),(379,'registeel',19,2050,261),(380,'latias',14,400,270),(381,'latios',20,600,270),(382,'kyogre',45,3520,302),(383,'groudon',35,9500,302),(384,'rayquaza',70,2065,306),(385,'jirachi',3,11,270),(386,'deoxys-normal',17,608,270),(387,'turtwig',4,102,64),(388,'grotle',11,970,142),(389,'torterra',22,3100,236),(390,'chimchar',5,62,62),(391,'monferno',9,220,142),(392,'infernape',12,550,240),(393,'piplup',4,52,63),(394,'prinplup',8,230,142),(395,'empoleon',17,845,239),(396,'starly',3,20,49),(397,'staravia',6,155,119),(398,'staraptor',12,249,218),(399,'bidoof',5,200,50),(400,'bibarel',10,315,144),(401,'kricketot',3,22,39),(402,'kricketune',10,255,134),(403,'shinx',5,95,53),(404,'luxio',9,305,127),(405,'luxray',14,420,235),(406,'budew',2,12,56),(407,'roserade',9,145,232),(408,'cranidos',9,315,70),(409,'rampardos',16,1025,173),(410,'shieldon',5,570,70),(411,'bastiodon',13,1495,173),(412,'burmy',2,34,45),(413,'wormadam-plant',5,65,148),(414,'mothim',9,233,148),(415,'combee',3,55,49),(416,'vespiquen',12,385,166),(417,'pachirisu',4,39,142),(418,'buizel',7,295,66),(419,'floatzel',11,335,173),(420,'cherubi',4,33,55),(421,'cherrim',5,93,158),(422,'shellos',3,63,65),(423,'gastrodon',9,299,166),(424,'ambipom',12,203,169),(425,'drifloon',4,12,70),(426,'drifblim',12,150,174),(427,'buneary',4,55,70),(428,'lopunny',12,333,168),(429,'mismagius',9,44,173),(430,'honchkrow',9,273,177),(431,'glameow',5,39,62),(432,'purugly',10,438,158),(433,'chingling',2,6,57),(434,'stunky',4,192,66),(435,'skuntank',10,380,168),(436,'bronzor',5,605,60),(437,'bronzong',13,1870,175),(438,'bonsly',5,150,58),(439,'mime-jr',6,130,62),(440,'happiny',6,244,110),(441,'chatot',5,19,144),(442,'spiritomb',10,1080,170),(443,'gible',7,205,60),(444,'gabite',14,560,144),(445,'garchomp',19,950,270),(446,'munchlax',6,1050,78),(447,'riolu',7,202,57),(448,'lucario',12,540,184),(449,'hippopotas',8,495,66),(450,'hippowdon',20,3000,184),(451,'skorupi',8,120,66),(452,'drapion',13,615,175),(453,'croagunk',7,230,60),(454,'toxicroak',13,444,172),(455,'carnivine',14,270,159),(456,'finneon',4,70,66),(457,'lumineon',12,240,161),(458,'mantyke',10,650,69),(459,'snover',10,505,67),(460,'abomasnow',22,1355,173),(461,'weavile',11,340,179),(462,'magnezone',12,1800,241),(463,'lickilicky',17,1400,180),(464,'rhyperior',24,2828,241),(465,'tangrowth',20,1286,187),(466,'electivire',18,1386,243),(467,'magmortar',16,680,243),(468,'togekiss',15,380,245),(469,'yanmega',19,515,180),(470,'leafeon',10,255,184),(471,'glaceon',8,259,184),(472,'gliscor',20,425,179),(473,'mamoswine',25,2910,239),(474,'porygon-z',9,340,241),(475,'gallade',16,520,233),(476,'probopass',14,3400,184),(477,'dusknoir',22,1066,236),(478,'froslass',13,266,168),(479,'rotom',3,3,154),(480,'uxie',3,3,261),(481,'mesprit',3,3,261),(482,'azelf',3,3,261),(483,'dialga',54,6830,306),(484,'palkia',42,3360,306),(485,'heatran',17,4300,270),(486,'regigigas',37,4200,302),(487,'giratina-altered',45,7500,306),(488,'cresselia',15,856,270),(489,'phione',4,31,216),(490,'manaphy',3,14,270),(491,'darkrai',15,505,270),(492,'shaymin-land',2,21,270),(493,'arceus',32,3200,324),(494,'victini',4,40,270),(495,'snivy',6,81,62),(496,'servine',8,160,145),(497,'serperior',33,630,238),(498,'tepig',5,99,62),(499,'pignite',10,555,146),(500,'emboar',16,1500,238),(501,'oshawott',5,59,62),(502,'dewott',8,245,145),(503,'samurott',15,946,238),(504,'patrat',5,116,51),(505,'watchog',11,270,147),(506,'lillipup',4,41,55),(507,'herdier',9,147,130),(508,'stoutland',12,610,225),(509,'purrloin',4,101,56),(510,'liepard',11,375,156),(511,'pansage',6,105,63),(512,'simisage',11,305,174),(513,'pansear',6,110,63),(514,'simisear',10,280,174),(515,'panpour',6,135,63),(516,'simipour',10,290,174),(517,'munna',6,233,58),(518,'musharna',11,605,170),(519,'pidove',3,21,53),(520,'tranquill',6,150,125),(521,'unfezant',12,290,220),(522,'blitzle',8,298,59),(523,'zebstrika',16,795,174),(524,'roggenrola',4,180,56),(525,'boldore',9,1020,137),(526,'gigalith',17,2600,232),(527,'woobat',4,21,63),(528,'swoobat',9,105,149),(529,'drilbur',3,85,66),(530,'excadrill',7,404,178),(531,'audino',11,310,390),(532,'timburr',6,125,61),(533,'gurdurr',12,400,142),(534,'conkeldurr',14,870,227),(535,'tympole',5,45,59),(536,'palpitoad',8,170,134),(537,'seismitoad',15,620,229),(538,'throh',13,555,163),(539,'sawk',14,510,163),(540,'sewaddle',3,25,62),(541,'swadloon',5,73,133),(542,'leavanny',12,205,225),(543,'venipede',4,53,52),(544,'whirlipede',12,585,126),(545,'scolipede',25,2005,218),(546,'cottonee',3,6,56),(547,'whimsicott',7,66,168),(548,'petilil',5,66,56),(549,'lilligant',11,163,168),(550,'basculin-red-striped',10,180,161),(551,'sandile',7,152,58),(552,'krokorok',10,334,123),(553,'krookodile',15,963,234),(554,'darumaka',6,375,63),(555,'darmanitan-standard',13,929,168),(556,'maractus',10,280,161),(557,'dwebble',3,145,65),(558,'crustle',14,2000,166),(559,'scraggy',6,118,70),(560,'scrafty',11,300,171),(561,'sigilyph',14,140,172),(562,'yamask',5,15,61),(563,'cofagrigus',17,765,169),(564,'tirtouga',7,165,71),(565,'carracosta',12,810,173),(566,'archen',5,95,71),(567,'archeops',14,320,177),(568,'trubbish',6,310,66),(569,'garbodor',19,1073,166),(570,'zorua',7,125,66),(571,'zoroark',16,811,179),(572,'minccino',4,58,60),(573,'cinccino',5,75,165),(574,'gothita',4,58,58),(575,'gothorita',7,180,137);
/*!40000 ALTER TABLE `pokemon` ENABLE KEYS */;
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