DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id`   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45) NULL
);

CREATE TABLE `pharmacy` (
  `id`           INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`         VARCHAR(100) NOT NULL,
  `address`      VARCHAR(200) NOT NULL,
  `open_from`     VARCHAR(45)  NULL,
  `close_at`      VARCHAR(45)  NULL,
  `served_orders` INT          NULL,
  `rate`         DOUBLE       NULL,
  `response_time` DOUBLE       NULL,
  `area_id`      INT          NULL,
  `latitude` FLOAT NULL ,
  `longitude` FLOAT NULL ,
  CONSTRAINT `pharmacy_area_id`
  FOREIGN KEY (`area_id`)
  REFERENCES `area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
