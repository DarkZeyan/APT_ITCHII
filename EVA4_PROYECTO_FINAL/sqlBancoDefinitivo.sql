CREATE DATABASE  IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `banco`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: banco
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `c_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) NOT NULL,
  `estadoNacimiento` varchar(45) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  PRIMARY KEY (`c_cliente`),
  UNIQUE KEY `c_cliente_UNIQUE` (`c_cliente`),
  UNIQUE KEY `curp_UNIQUE` (`curp`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (2,'JORGE EDUARDO','ESCOBAR','BUGARINI','6143513346','CHIHUAHUA','H','EOBJ030327HCHSGRA2','2003-03-27');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientesinactivos`
--

DROP TABLE IF EXISTS `clientesinactivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientesinactivos` (
  `c_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `celular` varchar(10) NOT NULL,
  `estadoNacimiento` varchar(45) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  PRIMARY KEY (`c_cliente`),
  UNIQUE KEY `c_cliente_UNIQUE` (`c_cliente`),
  UNIQUE KEY `curp_UNIQUE` (`curp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientesinactivos`
--

LOCK TABLES `clientesinactivos` WRITE;
/*!40000 ALTER TABLE `clientesinactivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientesinactivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `c_cuenta` int NOT NULL AUTO_INCREMENT,
  `numerocuenta` varchar(45) NOT NULL,
  `tasainteres` double NOT NULL,
  `fecha_pago` date NOT NULL,
  `fecha_corte` date NOT NULL,
  `fecha_creacion` date NOT NULL,
  `clientes_c_cliente` int NOT NULL,
  PRIMARY KEY (`c_cuenta`,`clientes_c_cliente`),
  UNIQUE KEY `numerocuenta_UNIQUE` (`numerocuenta`),
  UNIQUE KEY `c_cuenta_UNIQUE` (`c_cuenta`),
  KEY `fk_cuentas_clientes_idx` (`clientes_c_cliente`),
  CONSTRAINT `fk_cuentas_clientes` FOREIGN KEY (`clientes_c_cliente`) REFERENCES `clientes` (`c_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'23023099203',10,'2001-01-01','2001-01-01','2001-01-01',2);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `c_movimiento` int unsigned NOT NULL,
  `tipo_movimiento` int unsigned NOT NULL,
  `fecha_movimiento` date NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `tarjetas_clave_tarjeta` int unsigned NOT NULL,
  PRIMARY KEY (`c_movimiento`),
  UNIQUE KEY `c_movimiento_UNIQUE` (`c_movimiento`),
  KEY `fk_movimientos_tarjetas1_idx` (`tarjetas_clave_tarjeta`),
  CONSTRAINT `fk_movimientos_tarjetas` FOREIGN KEY (`tarjetas_clave_tarjeta`) REFERENCES `tarjetas` (`clave_tarjeta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetas`
--

DROP TABLE IF EXISTS `tarjetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetas` (
  `clave_tarjeta` int unsigned NOT NULL AUTO_INCREMENT,
  `numero_tarjeta` varchar(16) NOT NULL,
  `limite_credito` decimal(6,2) unsigned NOT NULL,
  `anualidad` decimal(6,2) unsigned NOT NULL,
  `fecha_anualidad` date NOT NULL,
  `cuentas_c_cuenta` int NOT NULL,
  PRIMARY KEY (`clave_tarjeta`),
  UNIQUE KEY `clave_tarjeta_UNIQUE` (`clave_tarjeta`),
  UNIQUE KEY `numero_tarjeta_UNIQUE` (`numero_tarjeta`),
  KEY `fk_tarjetas_cuentas1_idx` (`cuentas_c_cuenta`),
  CONSTRAINT `fk_tarjetas_cuentas` FOREIGN KEY (`cuentas_c_cuenta`) REFERENCES `cuentas` (`c_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetas`
--

LOCK TABLES `tarjetas` WRITE;
/*!40000 ALTER TABLE `tarjetas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarjetas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `username` varchar(40) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('bancony','admin');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-09  9:00:44
