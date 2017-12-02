CREATE DATABASE  IF NOT EXISTS `digitalquestdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `digitalquestdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: digitalquestdb
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `filmes`
--

DROP TABLE IF EXISTS `filmes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filmes` (
  `idFilmes` int(11) NOT NULL AUTO_INCREMENT,
  `Produtos_idProdutos` int(11) NOT NULL,
  `Duracao` float DEFAULT NULL,
  `Diretor` varchar(45) DEFAULT NULL,
  `Estudio` varchar(45) DEFAULT NULL,
  `Genero` varchar(45) DEFAULT NULL,
  `Sinopse` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFilmes`,`Produtos_idProdutos`),
  KEY `fk_Filmes_Produtos1_idx` (`Produtos_idProdutos`),
  CONSTRAINT `fk_Filmes_Produtos1` FOREIGN KEY (`Produtos_idProdutos`) REFERENCES `produtos` (`idProdutos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filmes`
--

LOCK TABLES `filmes` WRITE;
/*!40000 ALTER TABLE `filmes` DISABLE KEYS */;
INSERT INTO `filmes` VALUES (1,3,90,'Sao Bellini','Estudio Tabajara','Romance','Xande e seu amor'),(2,4,120,'Roberto Carlos','Cachorrao','Comedia','Cachorro zumbi nazista que come pessoas'),(3,9,140,'Martin','Pixar','Aventura','O treinador de cao participa em competicoes'),(4,10,240,'Irmaos russos','Marvel Studio','Acao','Thanos chega na Terra para causar caos');
/*!40000 ALTER TABLE `filmes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogos`
--

DROP TABLE IF EXISTS `jogos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jogos` (
  `idJogos` int(11) NOT NULL AUTO_INCREMENT,
  `Produtos_idProdutos` int(11) NOT NULL,
  `Descricao` varchar(45) DEFAULT NULL,
  `Desenvolvedor` varchar(45) DEFAULT NULL,
  `Publicadora` varchar(45) DEFAULT NULL,
  `Genero` varchar(45) DEFAULT NULL,
  `Site_oficial` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idJogos`,`Produtos_idProdutos`),
  KEY `fk_Jogos_Produtos_idx` (`Produtos_idProdutos`),
  CONSTRAINT `fk_Jogos_Produtos` FOREIGN KEY (`Produtos_idProdutos`) REFERENCES `produtos` (`idProdutos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogos`
--

LOCK TABLES `jogos` WRITE;
/*!40000 ALTER TABLE `jogos` DISABLE KEYS */;
INSERT INTO `jogos` VALUES (2,5,'O credo do assassino','Ubisoft','Ubisoft','Aventura','www.assassinscreed.com'),(3,11,'Talion busca vingar a sua familia','Monolith','Warner Games','Aventura','middleearthshadowofwar.com'),(4,14,'Jogo de tiro online','Blizzard','Blizzard','Shooter','playovertwach.com');
/*!40000 ALTER TABLE `jogos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_de_desejos`
--

DROP TABLE IF EXISTS `lista_de_desejos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_de_desejos` (
  `idLista_de_desejos` int(11) NOT NULL,
  `Usuarios_idUsuarios` varchar(12) NOT NULL,
  PRIMARY KEY (`idLista_de_desejos`,`Usuarios_idUsuarios`),
  KEY `fk_Lista_de_desejos_Usuarios1_idx` (`Usuarios_idUsuarios`),
  CONSTRAINT `fk_Lista_de_desejos_Usuarios1` FOREIGN KEY (`Usuarios_idUsuarios`) REFERENCES `usuarios` (`Login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_de_desejos`
--

LOCK TABLES `lista_de_desejos` WRITE;
/*!40000 ALTER TABLE `lista_de_desejos` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_de_desejos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_de_desejos_has_produtos`
--

DROP TABLE IF EXISTS `lista_de_desejos_has_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista_de_desejos_has_produtos` (
  `Lista_de_desejos_idLista_de_desejos` int(11) NOT NULL,
  `Produtos_idProdutos` int(11) NOT NULL,
  PRIMARY KEY (`Lista_de_desejos_idLista_de_desejos`,`Produtos_idProdutos`),
  KEY `fk_Lista_de_desejos_has_Produtos_Produtos1_idx` (`Produtos_idProdutos`),
  KEY `fk_Lista_de_desejos_has_Produtos_Lista_de_desejos1_idx` (`Lista_de_desejos_idLista_de_desejos`),
  CONSTRAINT `fk_Lista_de_desejos_has_Produtos_Lista_de_desejos1` FOREIGN KEY (`Lista_de_desejos_idLista_de_desejos`) REFERENCES `lista_de_desejos` (`idLista_de_desejos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lista_de_desejos_has_Produtos_Produtos1` FOREIGN KEY (`Produtos_idProdutos`) REFERENCES `produtos` (`idProdutos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_de_desejos_has_produtos`
--

LOCK TABLES `lista_de_desejos_has_produtos` WRITE;
/*!40000 ALTER TABLE `lista_de_desejos_has_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_de_desejos_has_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livros`
--

DROP TABLE IF EXISTS `livros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livros` (
  `idLivros` int(11) NOT NULL AUTO_INCREMENT,
  `Produtos_idProdutos` int(11) NOT NULL,
  `Autor` varchar(45) DEFAULT NULL,
  `Editora` varchar(45) DEFAULT NULL,
  `Edicao` varchar(45) DEFAULT NULL,
  `Genero` varchar(45) DEFAULT NULL,
  `Num_pag` int(11) DEFAULT NULL,
  PRIMARY KEY (`idLivros`,`Produtos_idProdutos`),
  KEY `fk_Livros_Produtos1_idx` (`Produtos_idProdutos`),
  CONSTRAINT `fk_Livros_Produtos1` FOREIGN KEY (`Produtos_idProdutos`) REFERENCES `produtos` (`idProdutos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livros`
--

LOCK TABLES `livros` WRITE;
/*!40000 ALTER TABLE `livros` DISABLE KEYS */;
INSERT INTO `livros` VALUES (1,6,'Alexandre Rocha','Moderna','2','Acao',210),(2,12,'Joao Lucas','Abril','3','Aventura',350),(3,13,'O Alemao','Estrangeira','6','Bibliografia',560);
/*!40000 ALTER TABLE `livros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musicas`
--

DROP TABLE IF EXISTS `musicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musicas` (
  `idMusicas` int(11) NOT NULL AUTO_INCREMENT,
  `Produtos_idProdutos` int(11) NOT NULL,
  `Artista` varchar(45) DEFAULT NULL,
  `Genero` varchar(45) DEFAULT NULL,
  `Album` varchar(45) DEFAULT NULL,
  `Duracao` float DEFAULT NULL,
  PRIMARY KEY (`idMusicas`,`Produtos_idProdutos`),
  KEY `fk_Musicas_Produtos1_idx` (`Produtos_idProdutos`),
  CONSTRAINT `fk_Musicas_Produtos1` FOREIGN KEY (`Produtos_idProdutos`) REFERENCES `produtos` (`idProdutos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicas`
--

LOCK TABLES `musicas` WRITE;
/*!40000 ALTER TABLE `musicas` DISABLE KEYS */;
INSERT INTO `musicas` VALUES (1,1,'Paralamas do sucesso','Rock','sucesso',5.2),(1,2,'Legiao Urbana','Rock','dois',3.5),(2,8,'Foo Fighters','Rock','Concrete and gold',5.5),(3,7,'AC/DC','Rock','Back in Black',6.2);
/*!40000 ALTER TABLE `musicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `idProdutos` int(11) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(45) NOT NULL,
  `Preco` double NOT NULL,
  `Categoria` enum('Movies','Music','Games','Books') NOT NULL,
  `Ano` int(11) NOT NULL,
  PRIMARY KEY (`idProdutos`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'O vento levou',12.45,'Music',2016),(2,'Quero colo',45.41,'Music',2016),(3,'O amor de Xande',40,'Movies',2018),(4,'Dogao o cachorro do mal',55,'Movies',2020),(5,'Assassins creed',19.99,'Games',2007),(6,'Novo mundo',29.99,'Books',2017),(7,'Back in Black',12.45,'Music',1980),(8,'Dirty Water',45.41,'Music',2017),(9,'O treinador',40,'Movies',2015),(10,'Vingadores: A guerra infinita',55,'Movies',2018),(11,'Shadow of war',99.99,'Games',2017),(12,'Ola mundo 2',19.99,'Books',2008),(13,'O alemao',9.99,'Books',2012),(14,'Overwatch',149.9,'Games',2016);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `Login` varchar(12) NOT NULL,
  `Senha` varchar(20) NOT NULL,
  PRIMARY KEY (`Login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Gusmao','jhne45as'),('tya','hngas45a');
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

-- Dump completed on 2017-12-01 21:11:56
