INSERT INTO users (email, password, first_name, last_name)
VALUES ('protonmail@protonmail.com', 'qwerty', 'Proton', 'Valentinov');
INSERT INTO users (email, password, first_name, last_name)
VALUES ('gmail@gmail.com', 'asdfgh', 'Gmail', 'Guglov');
INSERT INTO users (email, password, first_name, last_name)
VALUES ('temp@temporarymail.com', 'nvkdkel1', 'Temp', 'Tempov');

INSERT INTO posts (user_id, date_posted, text)
VALUES ('1', '2022-06-16 16:37:23', 'Lorem ips shoto tam');
INSERT INTO posts (user_id, date_posted, text)
VALUES ('1', '2022-06-18 16:37:23', ' ips shoto tam');
INSERT INTO posts (user_id, date_posted, text)
VALUES ('1', '2022-06-17 16:37:23', 'sdfsfasfdasdf shoto tam');
INSERT INTO posts (user_id, date_posted, text)
VALUES ('2', '2022-06-16 16:37:23', 'Lorem ips shoto tam');
INSERT INTO posts (user_id, date_posted, text)
VALUES ('3', '2022-06-18 16:37:23', ' ips shoto tam');
INSERT INTO posts (user_id, date_posted, text)
VALUES ('2', '2022-06-17 16:37:23', 'sdfsfasfdasdf shoto tam');

INSERT INTO likes (post_id, user_id)
VALUES ('1', '1');
INSERT INTO likes (post_id, user_id)
VALUES ('1', '2');
INSERT INTO likes (post_id, user_id)
VALUES ('1', '3');
INSERT INTO likes (post_id, user_id)
VALUES ('2', '1');

INSERT INTO favorites (user_id, post_id)
VALUES ('1', '9');

INSERT INTO subscriptions (from_user_id, to_user_id)
VALUES ('1', '2');
INSERT INTO subscriptions (from_user_id, to_user_id)
VALUES ('1', '3');

INSERT INTO comments (post_id, user_id, date_commented, text)
VALUES ('8', '1', '2022-06-18 17:37:23.000000', 'No!');
INSERT INTO comments (post_id, user_id, date_commented, text)
VALUES ('8', '1', '2022-06-18 17:37:23.000000', 'No!');

INSERT INTO likes (post_id, user_id)
VALUES (8, 2);
INSERT INTO likes (post_id, user_id)
VALUES (8, 3);

//sudo docker run --name postgresql1 -e POSTGRES_PASSWORD=1qaz2wsx@ -p 5432:5432 -d postgres:15.2






