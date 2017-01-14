CREATE TABLE `sms_record`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`mobile` VARCHAR(11) NOT NULL,
	`sendTime` datetime NOT NULL,
	`signName` VARCHAR(128),
	`templateCode` VARCHAR(32) NOT NULL,
	`paramJson`  VARCHAR(512),
	`requestId` VARCHAR(256) NOT NULL,
	`statusCode` INT,
	`message` VARCHAR(256),
	PRIMARY KEY(`id`)
)