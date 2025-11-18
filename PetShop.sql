CREATE DATABASE  IF NOT EXISTS `petshop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `petshop`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: petshop
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento` (
  `idAGENDAMENTO` varchar(50) NOT NULL,
  `CPF_CLIENTE` varchar(11) DEFAULT NULL,
  `SERVICO_idSERVICO` varchar(50) DEFAULT NULL,
  `DATA_AGENDAMENTO` date DEFAULT NULL,
  `HORA_AGENDAMENTO` time DEFAULT NULL,
  `VALOR` decimal(10,2) DEFAULT NULL,
  `FORMA_PAGAMENTO` enum('DINHEIRO','PIX','CARTAO_CREDITO','CARTAO_DEBITO') DEFAULT NULL,
  `STATUS` enum('AGENDADO','CONCLUIDO','CANCELADO') DEFAULT 'AGENDADO',
  PRIMARY KEY (`idAGENDAMENTO`),
  KEY `CPF_CLIENTE` (`CPF_CLIENTE`),
  KEY `SERVICO_idSERVICO` (`SERVICO_idSERVICO`),
  KEY `idx_agendamento_data` (`DATA_AGENDAMENTO`),
  CONSTRAINT `agendamento_ibfk_2` FOREIGN KEY (`SERVICO_idSERVICO`) REFERENCES `servico` (`idSERVICO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
INSERT INTO `agendamento` VALUES ('AG_be7c7292','19193498232','VETERINARIO','2025-11-28','20:50:00',120.00,'PIX','AGENDADO'),('AG_f6a636a7','99999999977','VETERINARIO','2025-11-28','06:10:00',120.00,'PIX','AGENDADO');
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `CPF` varchar(11) NOT NULL,
  `NOME` varchar(110) DEFAULT NULL,
  `TELEFONE` varchar(15) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `ENDERECO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CPF`),
  KEY `idx_cliente_nome` (`NOME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('99999999977','Jão Baiano','62999819981','jao@gmail.com','Qd 11, casa 120, setor oeste, 120');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `idCOMPRA` varchar(50) NOT NULL,
  `CPF` varchar(11) DEFAULT NULL,
  `DATA_COMPRA` date DEFAULT NULL,
  `VALOR_TOTAL` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idCOMPRA`),
  KEY `CPF` (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES ('CP_75e54b11','12345678900','2025-11-17',99.90),('CP_781b205d','12345678900','2025-11-17',99.90),('CP_79cf6305','99999999977','2025-11-17',339.80),('CP_81b86396','19193498232','2025-11-17',99.90),('CP_9fad005c','19193498232','2025-11-17',669.70);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_has_produto`
--

DROP TABLE IF EXISTS `compra_has_produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_has_produto` (
  `COMPRA_idCOMPRA` varchar(50) NOT NULL,
  `PRODUTO_idPRODUTO` varchar(50) NOT NULL,
  `QUANTIDADE` int DEFAULT NULL,
  PRIMARY KEY (`COMPRA_idCOMPRA`,`PRODUTO_idPRODUTO`),
  KEY `PRODUTO_idPRODUTO` (`PRODUTO_idPRODUTO`),
  CONSTRAINT `compra_has_produto_ibfk_1` FOREIGN KEY (`COMPRA_idCOMPRA`) REFERENCES `compra` (`idCOMPRA`) ON DELETE CASCADE,
  CONSTRAINT `compra_has_produto_ibfk_2` FOREIGN KEY (`PRODUTO_idPRODUTO`) REFERENCES `produto` (`idPRODUTO`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_has_produto`
--

LOCK TABLES `compra_has_produto` WRITE;
/*!40000 ALTER TABLE `compra_has_produto` DISABLE KEYS */;
INSERT INTO `compra_has_produto` VALUES ('CP_75e54b11','PROD_8735042c',1),('CP_781b205d','PROD_8735042c',1),('CP_79cf6305','PROD_8735042c',1),('CP_79cf6305','PROD_89da6f13c40611f09acb023ffb74e2d3',1),('CP_79cf6305','PROD_94238e6ec40611f09acb023ffb74e2d3',1),('CP_81b86396','PROD_8735042c',1),('CP_9fad005c','PROD_8735042c',1),('CP_9fad005c','PROD_89d281e2c40611f09acb023ffb74e2d3',1),('CP_9fad005c','PROD_89da6f13c40611f09acb023ffb74e2d3',1),('CP_9fad005c','PROD_94238722c40611f09acb023ffb74e2d3',1),('CP_9fad005c','PROD_94238e6ec40611f09acb023ffb74e2d3',1);
/*!40000 ALTER TABLE `compra_has_produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos_usuarios`
--

DROP TABLE IF EXISTS `grupos_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupos_usuarios` (
  `id_grupo` varchar(10) NOT NULL,
  `nome_grupo` varchar(50) NOT NULL,
  PRIMARY KEY (`id_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos_usuarios`
--

LOCK TABLES `grupos_usuarios` WRITE;
/*!40000 ALTER TABLE `grupos_usuarios` DISABLE KEYS */;
INSERT INTO `grupos_usuarios` VALUES ('ADMIN','Administrador'),('CLIENTE','Cliente do Site');
/*!40000 ALTER TABLE `grupos_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `idPRODUTO` varchar(50) NOT NULL,
  `NOME` varchar(145) DEFAULT NULL,
  `DESCRICAO` varchar(245) DEFAULT NULL,
  `PRECO` decimal(10,2) DEFAULT NULL,
  `QUANTIDADE_ESTOQUE` int DEFAULT NULL,
  PRIMARY KEY (`idPRODUTO`),
  KEY `idx_produto_nome` (`NOME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES ('PROD_8735042c','Ração Premium','Pacote de 1kg para cães filhotes',99.90,-1),('PROD_89d281e2c40611f09acb023ffb74e2d3','Arranhador Torre para Gatos','Arranhador de sisal com 3 andares e bolinha.',180.00,4),('PROD_89da6f13c40611f09acb023ffb74e2d3','Cama Nuvem Pet M','Cama redonda super macia e confortável, tamanho médio.',110.00,8),('PROD_94238722c40611f09acb023ffb74e2d3','Ração Golden Special Cães 15kg','Ração Premium Especial sabor Frango e Carne para cães adultos.',149.90,19),('PROD_94238e6ec40611f09acb023ffb74e2d3','Ração Whiskas Gatos 10kg','Ração seca sabor Peixe para gatos adultos.',129.90,13);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico` (
  `idSERVICO` varchar(50) NOT NULL,
  `DESCRICAO` varchar(100) DEFAULT NULL,
  `PRECO` decimal(10,2) DEFAULT NULL,
  `BANHO` tinyint DEFAULT NULL,
  `TOSA` tinyint DEFAULT NULL,
  PRIMARY KEY (`idSERVICO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES ('BANHO','Banho Completo',40.00,1,0),('BANHO_TOSA','Combo Banho e Tosa',80.00,1,1),('TOSA','Tosa Higiênica e Máquina',50.00,0,1),('VETERINARIO','Consulta Veterinária',120.00,0,0);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` varchar(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `id_grupo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `login` (`login`),
  KEY `id_grupo` (`id_grupo`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_grupo`) REFERENCES `grupos_usuarios` (`id_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('ADM01','Admin Master','admin@petplace.com','123','ADMIN'),('USR_6b24aac4','Guilherme Sacolinha','guizinhagay123@gmail.com','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','CLIENTE'),('USR_87f151f4','Guilherme Braga','guilhermebraga@gmail.com','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','CLIENTE'),('USR_911d683d','Igor Amaral Ferreira','igor123@gmail.com','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','CLIENTE'),('USR_9fce4507','João da Silva','joao@gmail.com','12345','CLIENTE'),('USR_a98e21be','Gustavo Nascimento','gustavo@gmail.com','12345','CLIENTE'),('USR_d8e76dff','Jão Baiano','jao@gmail.com','12345','CLIENTE'),('USR_db22acc4','Igor Amaral Ferreira','igor1@gmail.com','6ab84705e5d695efd532f462bc41ffc7a05f3a097b877dd2b95d168cd9f3b93d','CLIENTE'),('USR_e05c118e','Ração Premium','racao@gmail.com','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5','CLIENTE');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_compras_detalhes`
--

DROP TABLE IF EXISTS `vw_compras_detalhes`;
/*!50001 DROP VIEW IF EXISTS `vw_compras_detalhes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_compras_detalhes` AS SELECT 
 1 AS `idCOMPRA`,
 1 AS `DATA_COMPRA`,
 1 AS `VALOR_TOTAL`,
 1 AS `CLIENTE`,
 1 AS `PRODUTO`,
 1 AS `QUANTIDADE`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_estoque_baixo`
--

DROP TABLE IF EXISTS `vw_estoque_baixo`;
/*!50001 DROP VIEW IF EXISTS `vw_estoque_baixo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_estoque_baixo` AS SELECT 
 1 AS `idPRODUTO`,
 1 AS `NOME`,
 1 AS `QUANTIDADE_ESTOQUE`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_compras_detalhes`
--

/*!50001 DROP VIEW IF EXISTS `vw_compras_detalhes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_compras_detalhes` AS select `c`.`idCOMPRA` AS `idCOMPRA`,`c`.`DATA_COMPRA` AS `DATA_COMPRA`,`c`.`VALOR_TOTAL` AS `VALOR_TOTAL`,`cl`.`NOME` AS `CLIENTE`,`p`.`NOME` AS `PRODUTO`,`chp`.`QUANTIDADE` AS `QUANTIDADE` from (((`compra` `c` join `cliente` `cl` on((`c`.`CPF` = `cl`.`CPF`))) join `compra_has_produto` `chp` on((`chp`.`COMPRA_idCOMPRA` = `c`.`idCOMPRA`))) join `produto` `p` on((`p`.`idPRODUTO` = `chp`.`PRODUTO_idPRODUTO`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_estoque_baixo`
--

/*!50001 DROP VIEW IF EXISTS `vw_estoque_baixo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_estoque_baixo` AS select `produto`.`idPRODUTO` AS `idPRODUTO`,`produto`.`NOME` AS `NOME`,`produto`.`QUANTIDADE_ESTOQUE` AS `QUANTIDADE_ESTOQUE` from `produto` where (`produto`.`QUANTIDADE_ESTOQUE` < 5) */;
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

-- Dump completed on 2025-11-17 21:00:34
