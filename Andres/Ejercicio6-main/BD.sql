CREATE DATABASE MY_APP;
USE MY_APP;
CREATE TABLE user_tbl (
  user_id INT primary KEY AUTO_INCREMENT NOT NULL,
  user_firstname VARCHAR(40) NOT NULL,
  user_lastname VARCHAR(40) NOT NULL,
  user_email VARCHAR(60) NOT NULL,
  user_password VARBINARY(256) NOT NULL
);

create table category(
category_id int not null primary key auto_increment,
category_name varchar(40) not null
);

create table Products(
Product_id int not null primary key auto_increment,
Product_name varchar(40) not null,
Product_value int not null,
FK_category_id int not null
);

alter table products add foreign key (FK_category_id) references category(category_id);


select * from user_tbl;

INSERT INTO MY_APP.user_tbl (user_id, user_firstname, user_lastname, user_email, user_password) 
VALUES (UPPER(1), UPPER('Andres'), UPPER('Sarmiento'), 'sarmientokrlos@gmail.com',
AES_ENCRYPT('a&m1305mjh', 
'$2a$12$NI5AboyH/AhXsH8tzHqsvOzNDvaMo6hPgoCIjWww/hqWDtkpPSABS'));

SELECT *, 
 CAST(AES_DECRYPT(user_password, 
'$2a$12$NI5AboyH/AhXsH8tzHqsvOzNDvaMo6hPgoCIjWww/hqWDtkpPSABS') AS CHAR(50)) 
end_data FROM user_tbl WHERE user_id = 1;


SELECT p.Product_id, p.Product_name, p.Product_value, p.FK_category_id FROM products p where p.Product_id = 1;
UPDATE products set Product_name = ? , Product_value= ?, FK_category_id=? where Product_id = ?;
INSERT INTO products (Product_name,Product_value,FK_category_id) VALUES (upper(?),?,?);
delete from products where Product_id= ?
