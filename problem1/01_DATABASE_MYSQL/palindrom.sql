-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2021 at 05:32 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `palindrom`
--

-- --------------------------------------------------------

--
-- Table structure for table `rstring`
--

CREATE TABLE `rstring` (
  `rid` int(11) NOT NULL,
  `str` varchar(1000) DEFAULT NULL,
  `lpalindrom` varchar(255) DEFAULT NULL,
  `psize` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rstring`
--

INSERT INTO `rstring` (`rid`, `str`, `lpalindrom`, `psize`) VALUES
(1, 'ababbdfsdfsbbababa', 'aba', 3),
(2, ' mcpfzufomoyswncfn kjrxthqbd', 'omo', 3),
(3, ' mcpfzufomoyswncfn kjrxthqbd', 'omo', 3),
(4, ' zh zcjfiy  zfu l ziro lbmdbbksli ql wetbdq wb ylvmbfdb', ' l ', 3),
(5, 'rzud gcohmheeqqjgnullogcssqb n yqlftprjlpb ah   ', 'hmh', 3),
(6, 'ynpevrlsxw ttszjsgs zkxtsltv', 'sgs', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rstring`
--
ALTER TABLE `rstring`
  ADD PRIMARY KEY (`rid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rstring`
--
ALTER TABLE `rstring`
  MODIFY `rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
