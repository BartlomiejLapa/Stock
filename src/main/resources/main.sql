DROP DATABASE IF EXISTS stock;
CREATE DATABASE stock
    default character set utf8mb4
    default collate utf8mb4_general_ci;
use stock;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
id int unsigned NOT NULL PRIMARY KEY auto_increment,
username char(16) NOT NULL,
password char(72) NOT NULL,
email varchar(255) NOT NULL, 
active int(11) default NULL
);

DROP TABLE IF EXISTS market;
CREATE TABLE market(
stockname char(11) NOT NULL PRIMARY KEY,
quantity int(11) NOT NULL
);

DROP TABLE IF EXISTS wallet;
CREATE TABLE wallet(
id int unsigned PRIMARY KEY auto_increment,
stockname char(11),
quantity int(11) NOT NULL,
FOREIGN KEY(id) references users(id),
FOREIGN KEY(stockname) references market(stockname)

);

DROP TABLE IF EXISTS persistent_logins;
CREATE TABLE persistent_logins(
username varchar(64) NOT NULL,
series varchar(64) NOT NULL PRIMARY KEY ,
token varchar(64) NOT NULL,
last_used timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS role;
CREATE TABLE role(
role_id int(11) NOT NULL PRIMARY KEY auto_increment,
role varchar(255) default NULL
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role(
user_id int unsigned NOT NULL,
role_id int(11) NOT NULL,
PRIMARY KEY (user_id, role_id),
KEY user_role_key (role_id),
CONSTRAINT users_role FOREIGN KEY(user_id) REFERENCES users(id),
CONSTRAINT role_role FOREIGN KEY(role_id) REFERENCES role(role_id)
);

INSERT INTO `role` VALUES (1,'ALLOW');
