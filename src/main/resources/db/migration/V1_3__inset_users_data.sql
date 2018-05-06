INSERT INTO `user_roles` (`id`, `name`) VALUES
  (1, 'ADMIN');

INSERT INTO `user_roles` (`id`, `name`) VALUES
  (2, 'PHARMACY');

INSERT INTO `user_roles` (`id`, `name`) VALUES
  (3, 'USER');


INSERT INTO `users` (`id`, `username`, `password`, `enabled`, `role_id`) VALUES
  (1, 'testAdmin', '$2a$10$OdIAnBNJXngu80Wh03K2tOiIi4W6ToJ3wRmw4V/8NJUlkNjZFSG26', 1, 1);

INSERT INTO `users` (`id`, `username`, `password`, `enabled`, `role_id`) VALUES
  (2, 'testUser', '$2a$10$OdIAnBNJXngu80Wh03K2tOiIi4W6ToJ3wRmw4V/8NJUlkNjZFSG26', 1, 2);

INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES
  ('admin', NULL, 'admin', 'read', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, NULL),
  ('user', NULL, 'user', 'read', 'client_credentials', NULL, NULL, NULL, NULL, NULL, NULL);
