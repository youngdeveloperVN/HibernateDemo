-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 23, 2021 at 12:10 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java5`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectProduct` (IN `q` INT)  BEGIN
    SELECT * FROM product
    WHERE quantity > q;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `selectProduct2` (IN `q` INT, OUT `count` INT)  BEGIN
    SELECT COUNT(*) INTO count FROM product
    WHERE quantity > q;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `createUser` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `updateUser` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `admin` bit(1) DEFAULT NULL,
  `firstName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lastName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `createUser` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `updateUser` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `createDate`, `createUser`, `updateDate`, `updateUser`, `name`) VALUES
(1, NULL, NULL, NULL, NULL, 'Category');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `createUser` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `updateUser` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avaiable` int(11) NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `createDate`, `createUser`, `updateDate`, `updateUser`, `avaiable`, `image`, `name`, `price`, `quantity`, `category_id`) VALUES
(1, NULL, NULL, NULL, NULL, 0, NULL, 'PRODUC1', 10.02, 5, 1),
(2, NULL, NULL, NULL, NULL, 0, NULL, 'PRODUC2', 12.02, 13, 1),
(3, NULL, NULL, NULL, NULL, 0, NULL, 'PRODUC2', 12.02, 12, 1),
(4, NULL, NULL, NULL, NULL, 0, NULL, 'PRODUC2', 12.02, 11, 1),
(5, NULL, NULL, NULL, NULL, 0, NULL, 'PRODUC2', 12.02, 10, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKexqqeaksnmmku5py194ywp140` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FKexqqeaksnmmku5py194ywp140` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
