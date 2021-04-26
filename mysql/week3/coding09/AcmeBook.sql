CREATE TABLE `user` (
  `userId` int PRIMARY KEY AUTO_INCREMENT,
  `firstName` varchar(255),
  `lastName` varchar(255),
  `email` varchar(255),
  `password` varchar(255),
  `createDtTm` timestamp
);

CREATE TABLE `post` (
  `postId` int PRIMARY KEY AUTO_INCREMENT,
  `userId` int,
  `title` varchar(255),
  `body` text,
  `createDtTm` timestamp,
  `updateDtTm` timestamp,
  `deleteDtTm` timestamp,
  `createdBy` int
);

CREATE TABLE `comment` (
  `commentId` int PRIMARY KEY AUTO_INCREMENT,
  `postId` int,
  `userId` int,
  `title` varchar(255),
  `body` text,
  `createDtTm` timestamp,
  `updateDtTm` timestamp,
  `deleteDtTm` timestamp,
  `createdBy` int
);

ALTER TABLE `post` ADD FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);

ALTER TABLE `comment` ADD FOREIGN KEY (`postId`) REFERENCES `post` (`postId`);

ALTER TABLE `comment` ADD FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);