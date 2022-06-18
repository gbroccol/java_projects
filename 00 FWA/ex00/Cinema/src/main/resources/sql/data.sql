INSERT INTO cinema."user"(login, password, first_name, last_name, phone_number, email, avatar_id)
VALUES
       ('gbroccol', '$2a$10$CstbLCvvMliyK2vMm7Vi0ORqMlw21PMxIlvgIMx.yqdeAi5uKZfW.', 'Anastasiya', 'Pchelina', '899999999', 'gbroccol@lalala.ru', null),
       ('sjolyn', '$2a$10$CstbLCvvMliyK2vMm7Vi0ORqMlw21PMxIlvgIMx.yqdeAi5uKZfW.', 'Oleg', 'Tokmachov', '999999', 'tokmachov@yahoo.com', null),
       ('alex', '$2a$10$CstbLCvvMliyK2vMm7Vi0ORqMlw21PMxIlvgIMx.yqdeAi5uKZfW.', 'Alex', 'Smith', '12123123', 'smith@yahoo.com', null)
on conflict (login) do nothing;