-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`attachments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`attachments` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `NameOfAttachment` VARCHAR(45) NOT NULL,
  `Date` VARCHAR(45) NOT NULL,
  `Commentary` VARCHAR(70) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`contactinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`contactinfo` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `SurName` VARCHAR(45) NOT NULL,
  `MiddleName` VARCHAR(45) NULL DEFAULT NULL,
  `DateOfBirth` VARCHAR(45) NULL DEFAULT NULL,
  `Sex` VARCHAR(45) NULL DEFAULT NULL,
  `Citizenship` VARCHAR(45) NULL DEFAULT NULL,
  `MaritalStatus` VARCHAR(45) NULL DEFAULT NULL,
  `WebSite` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `PlaceOfWork` VARCHAR(45) NULL DEFAULT NULL,
  `Address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`telephonenumber`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`telephonenumber` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `CodeOfCountry` VARCHAR(5) NOT NULL,
  `CodeOfOperator` VARCHAR(5) NOT NULL,
  `TelephoneNumbercol` VARCHAR(10) NOT NULL,
  `TypeOfPhone` VARCHAR(10) NULL DEFAULT NULL,
  `Commentary` VARCHAR(70) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`contacts` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `ContactInfoId` INT NOT NULL,
  `TelephoneNumberId` INT NOT NULL,
  `AttachmentId` INT NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  INDEX `ContactInfoId_idx` (`ContactInfoId` ASC) VISIBLE,
  INDEX `AttachmentId_idx` (`AttachmentId` ASC) VISIBLE,
  INDEX `TelephoneNumberId_idx` (`TelephoneNumberId` ASC) VISIBLE,
  CONSTRAINT `AttachmentId`
    FOREIGN KEY (`AttachmentId`)
    REFERENCES `mydb`.`attachments` (`Id`),
  CONSTRAINT `ContactInfoId`
    FOREIGN KEY (`ContactInfoId`)
    REFERENCES `mydb`.`contactinfo` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `TelephoneNumberId`
    FOREIGN KEY (`TelephoneNumberId`)
    REFERENCES `mydb`.`telephonenumber` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
