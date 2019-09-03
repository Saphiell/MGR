DROP SCHEMA IF EXISTS `mgr`;
CREATE SCHEMA `mgr`;

use `mgr`;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `data`;

CREATE TABLE `data`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `cordx` varchar(45) DEFAULT NULL,
    `cordy` varchar(45) DEFAULT NULL,
    `value` varchar(45) DEFAULT NULL,
    `folder_id` int(11) DEFAULT NULL,
    
    PRIMARY KEY (`id`),
    KEY `FK_DETAIL_idx` (`folder_id`),
	CONSTRAINT `FK_DETAIL` FOREIGN KEY (`folder_id`) REFERENCES `folder` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folder_name` varchar(128) DEFAULT NULL,
  `folder_description` varchar(MAX) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;