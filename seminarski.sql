-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2022 at 08:35 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `seminarski`
--

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE `klijent` (
  `klijentID` int(11) NOT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`klijentID`, `telefon`, `adresa`, `ime`, `prezime`) VALUES
(1, '150150', 'Bulevar Oslobodjenja 300', 'Petar', 'Petrovic'),
(2, '654321', 'Jove Ilica 150', 'Ivana', 'Ivanovic'),
(3, '999197', 'Vojvode Stepe 80', 'Ana', 'Anic'),
(4, '191977', 'Ruzveltova 4', 'Marko', 'Markovic'),
(5, '987321', 'Prvomajska 21', 'Pavle', 'Pavlovic');

-- --------------------------------------------------------

--
-- Table structure for table `narudzbina`
--

CREATE TABLE `narudzbina` (
  `narudzbinaID` int(11) NOT NULL,
  `iznos` int(11) DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `prodavacID` int(11) DEFAULT NULL,
  `klijentID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `narudzbina`
--

INSERT INTO `narudzbina` (`narudzbinaID`, `iznos`, `datum`, `prodavacID`, `klijentID`) VALUES
(1, 850, '2022-02-20', 1, 1),
(2, 1050, '2022-02-20', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `prodavac`
--

CREATE TABLE `prodavac` (
  `prodavacID` int(11) NOT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `prodavac`
--

INSERT INTO `prodavac` (`prodavacID`, `ime`, `telefon`, `lozinka`) VALUES
(1, 'Aleksandra', '123555', 'aleks123'),
(2, 'Isidora', '333589', 'isi123');

-- --------------------------------------------------------

--
-- Table structure for table `proizvod`
--

CREATE TABLE `proizvod` (
  `proizvodID` int(11) NOT NULL,
  `cena` int(11) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proizvod`
--

INSERT INTO `proizvod` (`proizvodID`, `cena`, `naziv`) VALUES
(1, 220, 'Pljeskavica'),
(2, 260, 'Piletina'),
(3, 220, 'Palacinka krem'),
(4, 300, 'Pohovana piletina'),
(5, 900, 'Mesano meso kg'),
(6, 150, 'Pomfrit porcija'),
(7, 170, 'Palacinka nutela'),
(8, 150, 'Pica parce');

-- --------------------------------------------------------

--
-- Table structure for table `stavkanarudzbine`
--

CREATE TABLE `stavkanarudzbine` (
  `stavkaID` int(11) NOT NULL,
  `kolicina` int(11) DEFAULT NULL,
  `narudzbinaID` int(11) NOT NULL,
  `proizvodID` int(11) DEFAULT NULL,
  `cena` int(11) DEFAULT NULL,
  `iznos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stavkanarudzbine`
--

INSERT INTO `stavkanarudzbine` (`stavkaID`, `kolicina`, `narudzbinaID`, `proizvodID`, `cena`, `iznos`) VALUES
(1, 5, 1, 7, 170, 850),
(2, 7, 2, 8, 150, 1050);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `klijent`
--
ALTER TABLE `klijent`
  ADD PRIMARY KEY (`klijentID`);

--
-- Indexes for table `narudzbina`
--
ALTER TABLE `narudzbina`
  ADD PRIMARY KEY (`narudzbinaID`),
  ADD KEY `prodavacID_fk` (`prodavacID`),
  ADD KEY `klijentID_fk` (`klijentID`);

--
-- Indexes for table `prodavac`
--
ALTER TABLE `prodavac`
  ADD PRIMARY KEY (`prodavacID`);

--
-- Indexes for table `proizvod`
--
ALTER TABLE `proizvod`
  ADD PRIMARY KEY (`proizvodID`);

--
-- Indexes for table `stavkanarudzbine`
--
ALTER TABLE `stavkanarudzbine`
  ADD PRIMARY KEY (`stavkaID`,`narudzbinaID`),
  ADD KEY `narudzbinaID_fk` (`narudzbinaID`),
  ADD KEY `proizvodID_fk` (`proizvodID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `klijent`
--
ALTER TABLE `klijent`
  MODIFY `klijentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `narudzbina`
--
ALTER TABLE `narudzbina`
  MODIFY `narudzbinaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `proizvod`
--
ALTER TABLE `proizvod`
  MODIFY `proizvodID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `stavkanarudzbine`
--
ALTER TABLE `stavkanarudzbine`
  MODIFY `stavkaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `narudzbina`
--
ALTER TABLE `narudzbina`
  ADD CONSTRAINT `klijent_id_fk` FOREIGN KEY (`klijentID`) REFERENCES `klijent` (`klijentID`),
  ADD CONSTRAINT `prodavac_id_fk` FOREIGN KEY (`prodavacID`) REFERENCES `prodavac` (`prodavacID`);

--
-- Constraints for table `stavkanarudzbine`
--
ALTER TABLE `stavkanarudzbine`
  ADD CONSTRAINT `narudzbina_id_fk` FOREIGN KEY (`narudzbinaID`) REFERENCES `narudzbina` (`narudzbinaID`),
  ADD CONSTRAINT `proizvod_id_fk` FOREIGN KEY (`proizvodID`) REFERENCES `proizvod` (`proizvodID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
