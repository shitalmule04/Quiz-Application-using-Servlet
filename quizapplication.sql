-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2017 at 07:50 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `quizapplication`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `fullname` varchar(67) NOT NULL,
  `emailid` varchar(55) NOT NULL,
  `password` varchar(16) NOT NULL,
  `mobileno` varchar(10) NOT NULL,
  `class` varchar(45) NOT NULL,
  `department` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`fullname`, `emailid`, `password`, `mobileno`, `class`, `department`) VALUES
('Shital Mule', 'shitalmule04@gmail.com', 'shital123', '9623711872', '', ''),
('Shital Mule', 'shitalmule04@gmail.com', 'shital123', '9623711872', '', ''),
('Sonal Likhar', 'sonal@gmail.com', '12345', '9638527417', '', ''),
('Angelo', 'angelo@yahoo.com', 'angelo123', '9638527889', '', ''),
('Tejas Joshi', 'tejas@gmail.com', 'tejas123', '8600614776', 'B_Tech', 'IT'),
('Kalyani Kambale', 'kalyani@gmail.com', 'kalyani123', '6549873217', 'B_Tech', 'IT'),
('Shital Mule', 'shital@gmail.com', 'shital123', '9623711872', 'B_Tech', 'IT'),
('Shital Mule', 'shital@gmail.com', 'shital123', '9623711872', 'B_Tech', 'IT'),
('Shital Mule', 'shital@gmail.com', 'shital123', '9623711872', 'ty', 'IT'),
('Atamina DOnato Bero', 'atamina@gmail.com', 'atamina123', '9658745631', 'B_Tech', 'CS');

-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE IF NOT EXISTS `quiz` (
  `question` int(11) NOT NULL,
  `answer` varchar(89) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz`
--

INSERT INTO `quiz` (`question`, `answer`) VALUES
(1, 'Macintosh'),
(2, 'tee'),
(3, 'Regular files'),
(4, 'System Calls'),
(5, 'all of the mentioned'),
(6, 'device driver filesystem');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
