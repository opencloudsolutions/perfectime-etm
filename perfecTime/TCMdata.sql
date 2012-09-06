-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 24, 2012 at 07:05 PM
-- Server version: 5.5.24
-- PHP Version: 5.3.10-1ubuntu3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `TCMdata`
--

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
CREATE TABLE IF NOT EXISTS `jobs` (
  `jobID` int(2) NOT NULL AUTO_INCREMENT,
  `position` varchar(30) NOT NULL,
  `payrate` double(4,2) NOT NULL,
  PRIMARY KEY (`jobID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`jobID`, `position`, `payrate`) VALUES
(1, 'Head Server', 5.35),
(2, 'Server', 4.31),
(3, 'Head Cook', 9.00),
(4, 'Cook', 8.50),
(5, 'Shift Manager', 9.50);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_auth_user`
--

DROP TABLE IF EXISTS `tbl_auth_user`;
CREATE TABLE IF NOT EXISTS `tbl_auth_user` (
  `aName` varchar(50) NOT NULL,
  `aEmail` varchar(50) NOT NULL,
  `magPass` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_auth_user`
--

INSERT INTO `tbl_auth_user` (`aName`, `aEmail`, `magPass`) VALUES
('John Doe', 'name@email.tld', '5f4dcc3b5aa765d61d8327deb882cf99');

-- --------------------------------------------------------

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
CREATE TABLE IF NOT EXISTS `timetable` (
  `timeid` int(11) NOT NULL AUTO_INCREMENT,
  `start` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `stop` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `tipMade` int(4) NOT NULL DEFAULT '0',
  `keyid` int(4) NOT NULL,
  PRIMARY KEY (`timeid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `keyid` int(4) NOT NULL,
  `jobID` int(2) NOT NULL,
  `sSN` int(9) NOT NULL DEFAULT '0',
  `DOB` date NOT NULL,
  `employeeName` varchar(50) NOT NULL,
  `street` varchar(30) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zip` int(5) NOT NULL,
  `jCard` varchar(60) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `image` mediumblob NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`keyid`, `jobID`, `sSN`, `DOB`, `employeeName`, `street`, `city`, `state`, `zip`, `jCard`, `phone`, `email`, `image`) VALUES
(1163, 5, 987654321, '1980-03-20', 'Saad Akhtar', '123 Some Pensacola Street', 'Pensacola', 'FL', 32505, 'de08fb7fade3c6860ee3d641aa67f159', '2515555556', 'saads-email@domain.tld',
INSERT INTO `users` (`keyid`, `jobID`, `sSN`, `DOB`, `employeeName`, `street`, `city`, `state`, `zip`, `jCard`, `phone`, `email`, `image`) VALUES
(5369, 3, 777485369, '1969-12-31', 'M Ali', 'Some St. Paul  Street', 'St. Paul', 'MN', 44468, 'f45cf442e88e2ddf075444553811036f', '2518597979', 'email@domain.tld', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
