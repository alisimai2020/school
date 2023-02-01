-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2023 at 03:41 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `li`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `authorid` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `authour_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`authorid`, `email`, `location`, `authour_name`) VALUES
(1, 'alisimai429@gmail.com', 'Bububu', 'Simai Ali Silima'),
(2, 'simai@gmail.com', 'kijichi', 'simai ali silima'),
(3, 'issa@gmail.com', 'amani', 'issa khamis');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `sbn` varchar(255) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `authorid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`sbn`, `book_name`, `authorid`) VALUES
('a647', 'Arabic', 2),
('Bio54', 'Bilogy', 3),
('ch5', 'chemistry', 1),
('English1', 'English', 1),
('K242', 'Kiswahili', 1),
('m455', 'Mathematic', 3);

-- --------------------------------------------------------

--
-- Table structure for table `borrowed`
--

CREATE TABLE `borrowed` (
  `borrowid` bigint(20) NOT NULL,
  `issue` varchar(255) DEFAULT NULL,
  `out_date` varchar(255) DEFAULT NULL,
  `return_date` varchar(255) DEFAULT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `sbn` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrowed`
--

INSERT INTO `borrowed` (`borrowid`, `issue`, `out_date`, `return_date`, `stu_id`, `sbn`) VALUES
(1, 'availabity', '11/02/2023', '21/02/2023', 2, 'Bio54');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`stu_id`, `first_name`, `middle_name`, `last_name`, `address`, `course`) VALUES
(1, 'dai', 'simai', 'ali', 'kijichi', 'PCB'),
(2, 'ali', 'simai', 'haji', 'bububu', 'Bitam');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`authorid`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`sbn`),
  ADD KEY `FKhcj0e0ky3ftaweqnllqfwbn99` (`authorid`);

--
-- Indexes for table `borrowed`
--
ALTER TABLE `borrowed`
  ADD PRIMARY KEY (`borrowid`),
  ADD KEY `FKjjyqwgldoe7ntpvw5ebu39p9c` (`stu_id`),
  ADD KEY `FKhfbxnwgahhe59504sgk5w0wgm` (`sbn`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stu_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `authorid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `borrowed`
--
ALTER TABLE `borrowed`
  MODIFY `borrowid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `stu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FKhcj0e0ky3ftaweqnllqfwbn99` FOREIGN KEY (`authorid`) REFERENCES `author` (`authorid`);

--
-- Constraints for table `borrowed`
--
ALTER TABLE `borrowed`
  ADD CONSTRAINT `FKhfbxnwgahhe59504sgk5w0wgm` FOREIGN KEY (`sbn`) REFERENCES `book` (`sbn`),
  ADD CONSTRAINT `FKjjyqwgldoe7ntpvw5ebu39p9c` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
