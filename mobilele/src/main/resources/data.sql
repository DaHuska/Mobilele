INSERT INTO user_roles
VALUES(1, 'USER'), (2, 'ADMIN');

INSERT INTO `users` (`id`, `created`, `first_name`, `image_url`, `is_active`, `last_name`, `modified`, `password`, `username`)
VALUES
    (1, '1999-01-01', 'Alex', 'url link', 1, 'Boyanov', '1999-01-01', '8dded4dc9b97fe3124a0b5397e3ab5251046e6ffaf0fcf6b32c6eb9fea7b1337bfa48a886c8c064adebeb5ff05b84300', 'huski'),
    (2, '1999-01-01', 'User', 'url link', 1, 'Userov', '1999-01-01', '8dded4dc9b97fe3124a0b5397e3ab5251046e6ffaf0fcf6b32c6eb9fea7b1337bfa48a886c8c064adebeb5ff05b84300', 'user');

INSERT INTO `users_user_roles` (`user_id`, `role_id`)
VALUES
    (1, 1),
    (1, 2),
    (2, 1);