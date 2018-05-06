--
-- Table structure for table `oauth_client_details`
--
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id`               VARCHAR(255) NOT NULL,
  `resource_ids`            VARCHAR(255)  DEFAULT NULL,
  `client_secret`           VARCHAR(255)  DEFAULT NULL,
  `scope`                   VARCHAR(255)  DEFAULT NULL,
  `authorized_grant_types`  VARCHAR(255)  DEFAULT NULL,
  `web_server_redirect_uri` VARCHAR(255)  DEFAULT NULL,
  `authorities`             VARCHAR(255)  DEFAULT NULL,
  `access_token_validity`   INT(11)       DEFAULT NULL,
  `refresh_token_validity`  INT(11)       DEFAULT NULL,
  `additional_information`  VARCHAR(4096) DEFAULT NULL,
  `autoapprove`             VARCHAR(255)  DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------

-- Table structure for table `oauth_access_token`
--
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id`          VARCHAR(255) DEFAULT NULL,
  `token`             BLOB,
  `authentication_id` VARCHAR(255) DEFAULT NULL,
  `user_name`         VARCHAR(255) DEFAULT NULL,
  `client_id`         VARCHAR(255) DEFAULT NULL,
  `authentication`    BLOB,
  `refresh_token`     VARCHAR(255) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------
--
-- Table structure for table `oauth_refresh_token`
--
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id`       VARCHAR(255) DEFAULT NULL,
  `token`          BLOB,
  `authentication` BLOB
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------
--
-- Table structure for table `user_roles`
--
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id`       INT         NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  `enabled`  TINYINT(1)  NOT NULL,
  `role_id`  INT         NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `auth_user_id_fk`
  FOREIGN KEY (`role_id`) REFERENCES `user_roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;
