CREATE DATABASE  IF NOT EXISTS `standb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `standb`;
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carros`
--

LOCK TABLES `carros` WRITE;
/*!40000 ALTER TABLE `carros` DISABLE KEYS */;
INSERT INTO `carros` VALUES (1,'Modelo A',2020,'Vermelho',20000.00,'Novo','CH123456','NS123456'),(2,'Modelo B',2021,'Azul',25000.00,'Usado','CH654321','NS654321'),(3,'Modelo C',2019,'Preto',18000.00,'Usado','CH112233','NS112233'),(4,'Modelo D',2022,'Branco',27000.00,'Novo','CH223344','NS223344'),(5,'Modelo E',2023,'Cinza',30000.00,'Novo','CH334455','NS334455'),(6,'Modelo F',2021,'Verde',22000.00,'Usado','CH445566','NS445566'),(8,'Modelo H',2018,'Azul',19000.00,'Usado','CH667788','NS667788'),(9,'Modelo I',2022,'Preto',28000.00,'Novo','CH778899','NS778899'),(10,'Modelo J',2023,'Branco',31000.00,'Novo','CH889900','NS889900'),(11,'Modelo J',2023,'Branco',31000.00,'Novo','CH889900','NS889900'),(12,'Modelo A',2020,'Vermelho',20000.00,'Novo','CH123456','NS123456'),(14,'Modelo P',2020,'preto',20000.00,'Novo','CH123456','NS123456'),(15,'Modelo A',2020,'Vermelho',20000.00,'Novo','CH123456','NS123456');
/*!40000 ALTER TABLE `carros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `password` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'Afonso','1234');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendas` (
  `idVenda` int NOT NULL AUTO_INCREMENT,
  `dataVenda` varchar(10) DEFAULT NULL,
  `precoCarro` decimal(10,2) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `modelo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idVenda`),
  KEY `vendedor_id` (`nome`),
  KEY `carro_id` (`modelo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas`
--

LOCK TABLES `vendas` WRITE;
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
INSERT INTO `vendas` VALUES (1,'2023-05-17',20000.00,'João Silva','Modelo A'),(2,'2023-06-01',25000.00,'Maria Santos','Modelo B'),(3,'2023-04-15',20000.00,'paulo','Modelo C'),(4,'2023-07-22',27000.00,'Ana Oliveira','Modelo D'),(5,'2023-08-30',30000.00,'Luis Costa','Modelo E'),(6,'2023-09-12',22000.00,'Carla Pereira','Modelo F'),(7,'2023-10-05',21000.00,'Ricardo Nunes','Modelo G'),(8,'2023-11-20',19000.00,'Sofia Martins','Modelo H'),(9,'2023-12-10',28000.00,'Paulo Ribeiro','Modelo I'),(10,'2024-01-18',31000.00,'Beatriz Fernandes','Modelo J'),(11,'2023-05-17',20000.00,'João Silva','Modelo A'),(13,'2023-06-01',21000.00,'joao','Modelo G');
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedores` (
  `idVendedor` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `contacto` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nif` varchar(20) DEFAULT NULL,
  `numeroVendas` int DEFAULT NULL,
  PRIMARY KEY (`idVendedor`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedores`
--

LOCK TABLES `vendedores` WRITE;
/*!40000 ALTER TABLE `vendedores` DISABLE KEYS */;
INSERT INTO `vendedores` VALUES (1,'João Silva','123456789','joao@example.com','1234567890',332),(2,'Maria Santos','987654321','maria@example.com','0987654321',333),(3,'Pedro Almeida','111222333','pedro@example.com','1231231234',400),(4,'Ana Oliveira','222333444','ana@example.com','2342342345',290),(5,'paulo','333444555','luis@example.com','3453453456',310),(6,'Carla Pereira','444555666','carla@example.com','4564564567',275),(7,'Ricardo Nunes','555666777','ricardo@example.com','5675675678',350),(8,'Sofia Martins','666777888','sofia@example.com','6786786789',315),(9,'Paulo Ribeiro','777888999','paulo@example.com','7897897890',340),(10,'Beatriz Fernandes','888999000','beatriz@example.com','8908908901',325),(11,'João Silva','123456789','joao@example.com','1234567890',332);
/*!40000 ALTER TABLE `vendedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-21 11:50:51
