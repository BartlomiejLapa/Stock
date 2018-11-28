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

DROP TABLE IF EXISTS wallet;
CREATE TABLE wallet(
id int unsigned NOT NULL PRIMARY KEY auto_increment,
quantity int(11) NOT NULL,
stockname char(11) NOT NULL,
FOREIGN KEY(id) references user(id),
FOREIGN KEY(stockname) references market(stockname)
);

DROP TABLE IF EXISTS market;
CREATE TABLE market(
stockname char(11) not null PRIMARY KEY,
quantity int(11) not null
);

