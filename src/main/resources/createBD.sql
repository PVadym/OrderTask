CREATE DATABASE IF NOT EXISTS ordersdb;

CREATE TABLE IF NOT EXISTS products (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  discription TEXT ,
  price BIGINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS clients (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  address VARCHAR(250) NULL,
  phone VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS orders (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  date DATETIME NOT NULL DEFAULT NOW(),
  user_id INT NOT NULL ,
  FOREIGN KEY (user_id)REFERENCES clients(id))
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS products_orders (
  product_id INT NOT NULL ,
  order_id INT NOT NULL ,
  PRIMARY KEY (product_id,order_id),
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (order_id) REFERENCES orders(id))
  ENGINE = InnoDB;