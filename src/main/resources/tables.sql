CREATE TABLE users
(
    id    BIGSERIAL      NOT NULL PRIMARY KEY,
    email      VARCHAR UNIQUE NOT NULL,
    password   VARCHAR    NOT NULL,
    first_name VARCHAR    NOT NULL,
    last_name  VARCHAR    NOT NULL
);

CREATE TABLE posts
(
    id     BIGSERIAL PRIMARY KEY,
    user_id     BIGINT       NOT NULL,
    date_posted timestamp    NOT NULL,
    text        VARCHAR NOT NULL
);

CREATE TABLE comments
(
    id     BIGSERIAL PRIMARY KEY,
    commented_post_id        BIGINT       NOT NULL,
    user_id        BIGINT       NOT NULL,
    date_commented timestamp    NOT NULL,
    text           VARCHAR NOT NULL
);

CREATE TABLE likes
(
    id BIGSERIAL PRIMARY KEY,
    post_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
);

CREATE TABLE favorites
(
    id      BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    post_id BIGINT NOT NULL
);

CREATE TABLE subscriptions
(
    id           BIGSERIAL PRIMARY KEY,
    from_user_id BIGINT NOT NULL,
    to_user_id   BIGINT NOT NULL
);



