CREATE TABLE `cars` (
  `carId` int PRIMARY KEY AUTO_INCREMENT,
  `make` varchar(255),
  `model` varchar(255),
  `year` date,
  `price` double
);

CREATE TABLE `customers` (
  `customerId` int PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(255),
  `last_name` varchar(255)
);

CREATE TABLE `customer_cars` (
  `carId` int,
  `customerId` int
);

ALTER TABLE `customer_cars` ADD FOREIGN KEY (`carId`) REFERENCES `cars` (`carId`);

ALTER TABLE `customer_cars` ADD FOREIGN KEY (`customerId`) REFERENCES `customers` (`customerId`);
