-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 30, 2016 at 01:55 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Narnia_Hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `Appointments`
--

CREATE TABLE `Appointments` (
  `idAppointments` int(11) NOT NULL,
  `Appointment_Date` varchar(10) NOT NULL,
  `Appointment_Time` varchar(20) NOT NULL,
  `AppPat_Name` varchar(45) DEFAULT NULL,
  `AppPat_Surname` varchar(45) DEFAULT NULL,
  `AppPatId` int(11) DEFAULT NULL,
  `AppDoctor` int(11) DEFAULT NULL,
  `AppService` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Appointments`
--

INSERT INTO `Appointments` (`idAppointments`, `Appointment_Date`, `Appointment_Time`, `AppPat_Name`, `AppPat_Surname`, `AppPatId`, `AppDoctor`, `AppService`) VALUES
(1, '22/10/2016', '13:30', 'Vilma', 'C', 1, 0, NULL),
(2, '17/01/2017', '13:30', 'Vilma', 'C', 1, 0, '0'),
(3, '17/01/2017', '13:30', 'Vilma', 'C', 1, 0, '0'),
(4, '17/01/2017', '13:30', 'Vilma', 'C', 1, 0, '0'),
(5, '17/01/2017', '13:30', 'Vilma', 'C', 1, 0, '0'),
(6, '17/01/2017', '13:30', 'Vilma', 'C', 1, 0, '0'),
(7, '17/01/2017', '13:30', 'Vilma', 'C', 1, 0, '0'),
(8, '17/01/2017', '13:30', 'Vilma', 'C', 1, 0, '0'),
(9, '23', '16', 'Vilma', 'C', 1, 0, '0'),
(10, '23', '16', 'Vilma', 'C', 1, 0, '0'),
(11, '23', '24', 'Vilma', 'C', 1, 0, '0'),
(12, '23', '24', 'Vilma', 'C', 1, 0, '0'),
(13, '3', '12', 'd', 'd', 3, 0, '0'),
(14, '22', '13', 'j', 'j', 9, 2, '0');

-- --------------------------------------------------------

--
-- Table structure for table `Bills`
--

CREATE TABLE `Bills` (
  `idBills` int(11) NOT NULL,
  `Bills_date` varchar(15) DEFAULT NULL,
  `BillPatId` int(11) NOT NULL,
  `BillDoctor` int(11) DEFAULT NULL,
  `BillService` varchar(45) DEFAULT NULL,
  `BillAmmount` double DEFAULT NULL,
  `BillStatus` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Bills`
--

INSERT INTO `Bills` (`idBills`, `Bills_date`, `BillPatId`, `BillDoctor`, `BillService`, `BillAmmount`, `BillStatus`) VALUES
(1, '20-12-2016', 4, 2, 'First Consultation', 50, 'Unpaid'),
(3, '23', 1, 2, 'First Consultation', 50, 'Unpaid'),
(4, '25', 5, 2, 'Blood Test', 30, 'Unpaid'),
(5, '26', 4, 0, 'Treatment Follow Up', 25, 'Unpaid'),
(6, '23', 2, 2, 'Consultation & Blood Test', 2, 'Unpaid'),
(7, '23', 2, 2, 'Regular Consultation', 2, 'Unpaid');

-- --------------------------------------------------------

--
-- Table structure for table `Messages`
--

CREATE TABLE `Messages` (
  `idMessages` int(11) NOT NULL,
  `Message_Date` varchar(20) DEFAULT NULL,
  `MesPatId` int(11) DEFAULT NULL,
  `MessageText` varchar(100) DEFAULT NULL,
  `MesDocId` int(11) DEFAULT NULL,
  `MessageStatus` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Messages`
--

INSERT INTO `Messages` (`idMessages`, `Message_Date`, `MesPatId`, `MessageText`, `MesDocId`, `MessageStatus`) VALUES
(1, '23', 1, 'retb', 2, 'Unread'),
(2, '20/12/2016', 3, 'tvtb', 2, 'Unread'),
(3, '3', 2, 'fddghju', 2, 'Read');

-- --------------------------------------------------------

--
-- Table structure for table `Patients`
--

CREATE TABLE `Patients` (
  `idPatients` int(11) NOT NULL,
  `Patients_Name` varchar(45) NOT NULL,
  `Patients_Surname` varchar(45) NOT NULL,
  `Patients_Age` int(11) DEFAULT NULL,
  `Patients_Address` varchar(45) DEFAULT NULL,
  `Patients_Phone` varchar(45) DEFAULT NULL,
  `referDoctor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Patients`
--

INSERT INTO `Patients` (`idPatients`, `Patients_Name`, `Patients_Surname`, `Patients_Age`, `Patients_Address`, `Patients_Phone`, `referDoctor`) VALUES
(1, 'Vilma', 'C', 24, 'sjhcvdegh', '1234567', 2),
(2, 'Geo', 'M', 24, 'efregtr', '234657', 2),
(3, 'd', 'd', 32, 'any', '7554564', 2),
(4, 'x', 'x', 23, 'dvfv', '223', 2),
(5, 'f', 'f', 45, 'fvb', '213456', 2),
(6, 'Juana', 'La Cubana', 45, 'Su Casa', '32456', 2),
(7, 'Al', 'Bino', 32, 'jdkfbd', '23743', 2),
(8, 'h', 'h', 23, 'bhjbh', '87', 2),
(9, 'j', 'j', 32, 'dsfgb', '234', 2),
(10, 's', 's', 2, 'wef', '123', 2),
(11, 't', 't', 4, 'fdg', '23', 2);

-- --------------------------------------------------------

--
-- Table structure for table `Services`
--

CREATE TABLE `Services` (
  `idServices` int(11) NOT NULL,
  `Service type` varchar(45) DEFAULT NULL,
  `ServicePrice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `system_users`
--

CREATE TABLE `system_users` (
  `idsystem_users` int(11) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_userName` varchar(15) NOT NULL,
  `user_password` varchar(15) NOT NULL,
  `user_type` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `system_users`
--

INSERT INTO `system_users` (`idsystem_users`, `user_name`, `user_userName`, `user_password`, `user_type`) VALUES
(1, 'Vilma Carolina', 'v', 'v', 'receptionist'),
(2, 'Geomar', 'geo', '123', 'doctor'),
(3, 'Mayela', 'maye', '1234', 'billing');

-- --------------------------------------------------------

--
-- Table structure for table `User_Types`
--

CREATE TABLE `User_Types` (
  `idUser_Types` int(11) NOT NULL,
  `User_Typescol` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User_Types`
--

INSERT INTO `User_Types` (`idUser_Types`, `User_Typescol`) VALUES
(1, 'Receptionist'),
(2, 'Doctor'),
(3, 'Billing');

-- --------------------------------------------------------

--
-- Table structure for table `VisitRegister`
--

CREATE TABLE `VisitRegister` (
  `idVisitRegister` int(11) NOT NULL,
  `VisitDate` varchar(45) DEFAULT NULL,
  `VisitPatId` int(11) DEFAULT NULL,
  `VisitDocId` int(11) DEFAULT NULL,
  `VisitComments` varchar(100) DEFAULT NULL,
  `VisitPres` varchar(100) DEFAULT NULL,
  `PresType` char(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `VisitRegister`
--

INSERT INTO `VisitRegister` (`idVisitRegister`, `VisitDate`, `VisitPatId`, `VisitDocId`, `VisitComments`, `VisitPres`, `PresType`) VALUES
(1, NULL, 3, 2, 'Good Health', 'Nothing', 'NA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Appointments`
--
ALTER TABLE `Appointments`
  ADD PRIMARY KEY (`idAppointments`),
  ADD KEY `AllPatId_idx` (`AppPatId`),
  ADD KEY `AppDoctor_idx` (`AppDoctor`),
  ADD KEY `AppService_idx` (`AppService`);

--
-- Indexes for table `Bills`
--
ALTER TABLE `Bills`
  ADD PRIMARY KEY (`idBills`),
  ADD KEY `BillPatId_idx` (`BillPatId`),
  ADD KEY `BillDoctor_idx` (`BillDoctor`);

--
-- Indexes for table `Messages`
--
ALTER TABLE `Messages`
  ADD PRIMARY KEY (`idMessages`),
  ADD KEY `MesPatId_idx` (`MesPatId`),
  ADD KEY `MesDocId_idx` (`MesDocId`);

--
-- Indexes for table `Patients`
--
ALTER TABLE `Patients`
  ADD PRIMARY KEY (`idPatients`);

--
-- Indexes for table `Services`
--
ALTER TABLE `Services`
  ADD PRIMARY KEY (`idServices`);

--
-- Indexes for table `system_users`
--
ALTER TABLE `system_users`
  ADD PRIMARY KEY (`idsystem_users`),
  ADD KEY `user_type_idx` (`user_type`);

--
-- Indexes for table `User_Types`
--
ALTER TABLE `User_Types`
  ADD PRIMARY KEY (`idUser_Types`);

--
-- Indexes for table `VisitRegister`
--
ALTER TABLE `VisitRegister`
  ADD PRIMARY KEY (`idVisitRegister`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Appointments`
--
ALTER TABLE `Appointments`
  MODIFY `idAppointments` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `Bills`
--
ALTER TABLE `Bills`
  MODIFY `idBills` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `Messages`
--
ALTER TABLE `Messages`
  MODIFY `idMessages` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Patients`
--
ALTER TABLE `Patients`
  MODIFY `idPatients` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `Services`
--
ALTER TABLE `Services`
  MODIFY `idServices` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `system_users`
--
ALTER TABLE `system_users`
  MODIFY `idsystem_users` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `User_Types`
--
ALTER TABLE `User_Types`
  MODIFY `idUser_Types` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `VisitRegister`
--
ALTER TABLE `VisitRegister`
  MODIFY `idVisitRegister` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Appointments`
--
ALTER TABLE `Appointments`
  ADD CONSTRAINT `AllPatId` FOREIGN KEY (`AppPatId`) REFERENCES `Patients` (`idPatients`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Bills`
--
ALTER TABLE `Bills`
  ADD CONSTRAINT `BillPatId` FOREIGN KEY (`BillPatId`) REFERENCES `Patients` (`idPatients`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Messages`
--
ALTER TABLE `Messages`
  ADD CONSTRAINT `MesDocId` FOREIGN KEY (`MesDocId`) REFERENCES `system_users` (`idsystem_users`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `MesPatId` FOREIGN KEY (`MesPatId`) REFERENCES `Patients` (`idPatients`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
