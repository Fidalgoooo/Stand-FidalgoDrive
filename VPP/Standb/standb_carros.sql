-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: standb
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `carros`
--

DROP TABLE IF EXISTS `carros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carros` (
  `idCarro` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(100) DEFAULT NULL,
  `ano` int DEFAULT NULL,
  `cor` varchar(50) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `numero_chassi` varchar(100) DEFAULT NULL,
  `numero_serie` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCarro`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carros`
--

LOCK TABLES `carros` WRITE;
/*!40000 ALTER TABLE `carros` DISABLE KEYS */;
INSERT INTO `carros` VALUES (1,'Modelo A',2020,'Vermelho',20000.00,'Novo','CH123456','NS123456'),(2,'Modelo B',2021,'Azul',25000.00,'Usado','CH654321','NS654321'),(3,'Modelo C',2019,'Preto',18000.00,'Usado','CH112233','NS112233'),(4,'Modelo D',2022,'Branco',27000.00,'Novo','CH223344','NS223344'),(5,'Modelo E',2023,'Cinza',30000.00,'Novo','CH334455','NS334455'),(6,'Modelo F',2021,'Verde',22000.00,'Usado','CH445566','NS445566'),(7,'Modelo G',2020,'Amarelo',21000.00,'Novo','CH556677','NS556677'),(8,'Modelo H',2018,'Azul',19000.00,'Usado','CH667788','NS667788'),(9,'Modelo I',2022,'Preto',28000.00,'Novo','CH778899','NS778899'),(10,'Modelo J',2023,'Branco',31000.00,'Novo','CH889900','NS889900');
/*!40000 ALTER TABLE `carros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-20 23:26:45
