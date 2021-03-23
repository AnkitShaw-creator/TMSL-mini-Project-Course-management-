-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: user
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `course_name` varchar(30) DEFAULT NULL,
  `course_duration` varchar(15) DEFAULT NULL,
  `instructor` varchar(30) DEFAULT NULL,
  `fee` varchar(10) DEFAULT NULL,
  `about` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('python','4 weeks','Charles Russell Severance','499','This Specialization builds on the success of the Python for Everybody course and will introduce fundamental programming concepts including data structures, networked application program interfaces, and databases, using the Python programming language. In the Capstone Project, you?ll use the technologies learned throughout the Specialization to design and create your own  applications for data retrieval, processing, and visualization.'),('artificial intelligence','4 weeks','Andrew Ng','599','AI is not only for engineers. If you want your organization to become better at using AI, this is the course to tell everyone--especially your non-technical colleagues--to take.AI is not only for engineers. If you want your organization to become better at using AI, this is the course to tell everyone--especially your non-technical colleagues--to take. In this course, you will learn: The meaning behind common AI terminology, including neural networks, machine learning, deep learning, and data science,What AI realistically can--and cannot--do,How to spot opportunities to apply AI to problems in your own organization,What it feels like to build machine learning and data science projects,How to work with an AI team and build an AI strategy in your company,How to navigate ethical and societal discussions surrounding AI'),('machine learning','4 weeks','Dr Marco Gillies','599','Machine Learning, often called Artificial Intelligence or AI, is one of the most exciting areas of technology at the moment. We see daily news stories that herald new breakthroughs in facial recognition technology, self driving cars or computers that can have a conversation just like a real person. Machine Learning technology is set to revolutionise almost any area of human life and work, and so will affect all our lives, and so you are likely to want to find out more about it. Machine Learning has a reputation for being one of the most complex areas of computer science, requiring advanced mathematics and engineering skills to understand it. While it is true that working as a Machine Learning engineer does involve a lot of mathematics and programming, we believe that anyone can understand the basic concepts of Machine Learning, and given the importance of this technology, everyone should.'),('deep learning','5 weeks','Andrew Ng','599','The Deep Learning Specialization is our foundational program that will help you understand the capabilities, challenges, and consequences of deep learning and prepare you to participate in the development of leading-edge AI technology.In this Specialization, you will build neural network architectures such as Convolutional Neural Networks, Recurrent Neural Networks, LSTMs, Transformers, and learn how to make them better with strategies such as Dropout, BatchNorm, Xavier/He initialization, and more. You will master these theoretical concepts and their industry applications using Python and TensorFlow. You will tackle real-world case studies such as autonomous driving, sign language reading, music generation, computer vision, speech recognition, and natural language processing.'),('java','5 weeks','Susan H. Rodger','499','Take your first step towards a career in software development with this introduction to Java-one of the most in-demand programming languages and the foundation of the Android operating system. Designed for beginners, this Specialization will teach you core programming concepts and equip you to write programs to solve complex problems. In addition, you will gain the foundational skills a software engineer needs to solve real-world problems, from designing algorithms to testing and debugging your programs.');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `name` varchar(20) DEFAULT NULL,
  `user_id` varchar(15) DEFAULT NULL,
  `paswd` varchar(15) DEFAULT NULL,
  `phone_no` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('anish singh','anish12','anish12@@','9831624339'),('anirban ghosh','anirban12','anirban12@@','8759018223'),('ankit shaw','ankit12','ankit12@@','8777514081'),('ashok yadav','ashok12','ashok12@@','6289608089'),('gourav chakraborty','gourav12','gourav12@@','7044302820'),('mohit john kujur','mohit12','mohit12@@','9163338737');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-22 18:53:33
