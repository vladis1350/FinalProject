
DROP TABLE IF EXISTS product;

CREATE TABLE product (
id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  category VARCHAR(255) NOT NULL,
  description VARCHAR(255) DEFAULT NULL,
  discount decimal(19,2) DEFAULT NULL,
  name VARCHAR(255) DEFAULT NULL,
  price decimal(19,2) DEFAULT NULL
);

INSERT INTO product VALUES (11,'Meat products',NULL,11.00,'salce',11.20),
(21,'Technical goods',NULL,10.00,'Nokia',630.00),
(28,'Building products',NULL,11.00,'беседка',155.00),
(29,'Dairy products',NULL,55.00,'Milk',15.40),
(31,'Bakery products',NULL,55.00,'waffles',12.00),
(32,'Fruit',NULL,55.00,'Apple',6.30);

