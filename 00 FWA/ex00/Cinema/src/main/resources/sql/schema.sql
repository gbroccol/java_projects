DROP SCHEMA IF EXISTS cinema CASCADE;

CREATE SCHEMA IF NOT EXISTS cinema;

CREATE TABLE IF NOT EXISTS cinema.images (
    image_id                serial8
    , user_id               int8
    , file_name             varchar(255) UNIQUE
    , file_original_name    varchar(255)
    , size                  varchar(255)
    , mime                  varchar(255)
);

CREATE TABLE IF NOT EXISTS cinema.user (
   user_id         serial8 CONSTRAINT user_key PRIMARY KEY,
   login           varchar(30) NOT NULL UNIQUE,
   password        text NOT NULL,
   first_name      varchar(256),
   last_name       varchar(256),
   phone_number    varchar(30),
   email           varchar(265),
   avatar          int8
);

CREATE TABLE IF NOT EXISTS cinema.user_authentication_history
(
    id              serial8,
    user_id         bigint,
    auth_date       varchar(100),
    auth_time       varchar(100),
    auth_ip         varchar(50),
    FOREIGN KEY (user_id) REFERENCES cinema.user(user_id)
);

-- CREATE TABLE cinema.ref_image_user
-- (
--     image_id        int8
--     , user_id       int8
--     , FOREIGN KEY (image_id) REFERENCES cinema.images(image_id)
-- );
--
