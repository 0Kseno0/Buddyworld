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
-- Temporary view structure for view `habitat_view`
--

DROP TABLE IF EXISTS `habitat_view`;
/*!50001 DROP VIEW IF EXISTS `habitat_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `habitat_view` AS SELECT 
 1 AS `pok_id`,
 1 AS `pok_name`,
 1 AS `hab_name`,
 1 AS `pok_height`,
 1 AS `pok_weight`,
 1 AS `capture_rate`,
 1 AS `base_happiness`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `pok_abilities`
--

DROP TABLE IF EXISTS `pok_abilities`;
/*!50001 DROP VIEW IF EXISTS `pok_abilities`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pok_abilities` AS SELECT 
 1 AS `pok_id`,
 1 AS `pok_name`,
 1 AS `abil_name`,
 1 AS `is_hidden`,
 1 AS `pok_base_experience`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `att_def_hp`
--

DROP TABLE IF EXISTS `att_def_hp`;
/*!50001 DROP VIEW IF EXISTS `att_def_hp`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `att_def_hp` AS SELECT 
 1 AS `pok_id`,
 1 AS `pok_name`,
 1 AS `b_atk`,
 1 AS `b_def`,
 1 AS `b_hp`,
 1 AS `b_speed`,
 1 AS `b_sp_atk`,
 1 AS `b_sp_def`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `top_10_view`
--

DROP TABLE IF EXISTS `top_10_view`;
/*!50001 DROP VIEW IF EXISTS `top_10_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `top_10_view` AS SELECT 
 1 AS `pok_id`,
 1 AS `pok_name`,
 1 AS `b_atk`,
 1 AS `b_def`,
 1 AS `b_hp`,
 1 AS `b_speed`,
 1 AS `b_sp_atk`,
 1 AS `b_sp_def`,
 1 AS `TOTAL`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `pokemon_total`
--

DROP TABLE IF EXISTS `pokemon_total`;
/*!50001 DROP VIEW IF EXISTS `pokemon_total`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pokemon_total` AS SELECT 
 1 AS `pok_id`,
 1 AS `pok_name`,
 1 AS `b_atk`,
 1 AS `b_def`,
 1 AS `b_hp`,
 1 AS `b_speed`,
 1 AS `b_sp_atk`,
 1 AS `b_sp_def`,
 1 AS `total`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `habitat_view`
--

/*!50001 DROP VIEW IF EXISTS `habitat_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `habitat_view` AS select 1 AS `pok_id`,1 AS `pok_name`,1 AS `hab_name`,1 AS `pok_height`,1 AS `pok_weight`,1 AS `capture_rate`,1 AS `base_happiness` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pok_abilities`
--

/*!50001 DROP VIEW IF EXISTS `pok_abilities`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pok_abilities` AS select 1 AS `pok_id`,1 AS `pok_name`,1 AS `abil_name`,1 AS `is_hidden`,1 AS `pok_base_experience` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `att_def_hp`
--

/*!50001 DROP VIEW IF EXISTS `att_def_hp`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `att_def_hp` AS select 1 AS `pok_id`,1 AS `pok_name`,1 AS `b_atk`,1 AS `b_def`,1 AS `b_hp`,1 AS `b_speed`,1 AS `b_sp_atk`,1 AS `b_sp_def` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `top_10_view`
--

/*!50001 DROP VIEW IF EXISTS `top_10_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `top_10_view` AS select 1 AS `pok_id`,1 AS `pok_name`,1 AS `b_atk`,1 AS `b_def`,1 AS `b_hp`,1 AS `b_speed`,1 AS `b_sp_atk`,1 AS `b_sp_def`,1 AS `TOTAL` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pokemon_total`
--

/*!50001 DROP VIEW IF EXISTS `pokemon_total`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb3 */;
/*!50001 SET character_set_results     = utf8mb3 */;
/*!50001 SET collation_connection      = utf8mb3_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pokemon_total` AS select 1 AS `pok_id`,1 AS `pok_name`,1 AS `b_atk`,1 AS `b_def`,1 AS `b_hp`,1 AS `b_speed`,1 AS `b_sp_atk`,1 AS `b_sp_def`,1 AS `total` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-04 13:29:44
