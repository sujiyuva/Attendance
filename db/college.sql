-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 28, 2016 at 07:42 AM
-- Server version: 5.7.4-m14
-- PHP Version: 5.4.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `college`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE IF NOT EXISTS `attendance` (
  `id` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `rollno` varchar(30) NOT NULL,
  `dept` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `name`, `rollno`, `dept`) VALUES
(1, 'shiva', '11mca45', 'B.E.CSE');

-- --------------------------------------------------------

--
-- Table structure for table `attendancestatus`
--

CREATE TABLE IF NOT EXISTS `attendancestatus` (
  `id` varchar(50) NOT NULL,
  `presentdays` varchar(50) NOT NULL,
  `absenrdays` varchar(50) NOT NULL,
  `onduty` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendancestatus`
--

INSERT INTO `attendancestatus` (`id`, `presentdays`, `absenrdays`, `onduty`) VALUES
('4', 'yes', 'no', 'no'),
('5', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'no', 'yes', 'no'),
('1', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('5', 'yes', 'no', 'no'),
('3', 'no', 'yes', 'no'),
('6', 'yes', 'no', 'no'),
('11', 'yes', 'no', 'no'),
('3', 'no', 'yes', 'no'),
('11', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'no', 'yes', 'no'),
('1', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'no', 'no', 'yes'),
('1', 'no', 'yes', 'no'),
('2', 'no', 'yes', 'no'),
('2', 'no', 'yes', 'no'),
('3', 'no', 'yes', 'no'),
('4', 'no', 'no', 'yes'),
('4', 'no', 'yes', 'no'),
('4', 'no', 'yes', 'no'),
('5', 'no', 'no', 'yes'),
('5', 'no', 'yes', 'no'),
('6', 'no', 'yes', 'no'),
('1', 'no', 'no', 'yes'),
('6', 'yes', 'no', 'no'),
('2', 'no', 'yes', 'no'),
('2', 'yes', 'no', 'no'),
('4', 'no', 'no', 'yes'),
('3', 'yes', 'no', 'no'),
('3', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('2', 'yes', 'no', 'no'),
('3', 'no', 'yes', 'no'),
('4', 'yes', 'no', 'no'),
('5', 'no', 'no', 'yes'),
('6', 'yes', 'no', 'no'),
('7', 'yes', 'no', 'no'),
('8', 'no', 'yes', 'no'),
('9', 'yes', 'no', 'no'),
('10', 'yes', 'no', 'no'),
('11', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('2', 'yes', 'no', 'no'),
('2', 'yes', 'no', 'no'),
('3', 'yes', 'no', 'no'),
('3', 'yes', 'no', 'no'),
('4', 'yes', 'no', 'no'),
('5', 'no', 'no', 'yes'),
('6', 'yes', 'no', 'no'),
('7', 'yes', 'no', 'no'),
('8', 'yes', 'no', 'no'),
('9', 'yes', 'no', 'no'),
('10', 'no', 'yes', 'no'),
('11', 'no', 'yes', 'no'),
('5', 'no', 'no', 'yes'),
('2', 'yes', 'no', 'no'),
('1', 'no', 'yes', 'no'),
('2', 'no', 'yes', 'no'),
('3', 'yes', 'no', 'no'),
('4', 'yes', 'no', 'no'),
('5', 'yes', 'no', 'no'),
('8', 'yes', 'no', 'no'),
('6', 'no', 'yes', 'no'),
('9', 'yes', 'no', 'no'),
('11', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('2', 'yes', 'no', 'no'),
('1', 'no', 'yes', 'no'),
('2', 'no', 'no', 'yes'),
('1', 'yes', 'no', 'no'),
('2', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('2', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('2', 'no', 'yes', 'no'),
('1', 'no', 'yes', 'no'),
('1', 'no', 'yes', 'no'),
('10', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('4', 'yes', 'no', 'no'),
('3', 'no', 'no', 'yes'),
('1', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'no', 'yes', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'no', 'yes', 'no'),
('6', 'yes', 'no', 'no'),
('6', 'no', 'yes', 'no'),
('7', 'yes', 'no', 'no'),
('7', 'yes', 'no', 'no'),
('7', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('2', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no'),
('1', 'yes', 'no', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE IF NOT EXISTS `register` (
  `name` varchar(50) NOT NULL,
  `mobileno` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`name`, `mobileno`, `email`, `city`, `country`, `username`, `password`) VALUES
('shiva', '9952353237', 'shiva.propulsion@gmail.com', 'coimbatore', 'india', 'shiva', 'shiva'),
('devi', '1234567890', 'devi@gmail.com', 'cbe', 'india', 'devi', 'devi'),
('manju', '1234567890', 'manju@gmail.com', 'cbe', 'india', 'manju', 'manju'),
('manisha', '1234567890', 'manisha@gmail.com', 'cbe', 'india', 'manisha', 'manisha'),
('shiva', '9952353237', 'shiva.propulsion@gmail.com', 'coimbatore', 'india', 'shiva', 'shiva'),
('devi', '1234567890', 'devi@gmail.com', 'cbe', 'india', 'devi', 'devi'),
('manju', '1234567890', 'manju@gmail.com', 'cbe', 'india', 'manju', 'manju'),
('manisha', '1234567890', 'manisha@gmail.com', 'cbe', 'india', 'manisha', 'manisha'),
('admin', '1234567890', 'admin@gmail.com', 'cbe', 'india', 'admin', 'admin'),
('staff', '1234567890', 'staff@gmail.com', 'cbe', 'india', 'staff', 'staff');

-- --------------------------------------------------------

--
-- Table structure for table `studentlist`
--

CREATE TABLE IF NOT EXISTS `studentlist` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `rollno` varchar(50) NOT NULL,
  `dept` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `studentlist`
--

INSERT INTO `studentlist` (`id`, `name`, `rollno`, `dept`) VALUES
(1, 'Krithika.T', '13BC058', 'CSE'),
(2, 'Kokila.N', '13BC059', 'CSE'),
(3, 'Kokila.P', '13BC060', 'CSE'),
(4, 'Koushik Rajan.A', '13BC061', 'CSE'),
(5, 'Kowsalya.B', '13BC062', 'CSE'),
(6, 'Lakshana.M', '13BC063', 'CSE'),
(7, 'Lakshmi.T', '13BC064', 'CSE'),
(8, 'Lavanya.K', '13BC065', 'CSE'),
(9, 'Loganayaki.N', '13BC066', 'CSE'),
(10, 'Madhu Shalini.R', '13BC067', 'CSE'),
(11, 'Manisha.V', '13BC068', 'CSE'),
(12, 'Manju Bharathi.N', '13BC069', 'CSE');

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE IF NOT EXISTS `subjects` (
  `titles` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`titles`) VALUES
('Subject One '),
('Subject Two'),
('Subject Three'),
('Subject Four'),
('Subject Five'),
('Subject Six');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
