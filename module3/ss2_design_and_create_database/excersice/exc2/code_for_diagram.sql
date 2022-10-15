CREATE DATABASE IF NOT EXISTS management_sell;
USE management_sell;
CREATE TABLE customer(
customer_id INT PRIMARY KEY,
customer_name VARCHAR(50),
customer_age INT
);
CREATE TABLE product(
product_id INT PRIMARY KEY,
product_name VARCHAR(50),
product_price DOUBLE
);
CREATE TABLE order_detail (
    order_id INT PRIMARY KEY,
    product_id INT,
    FOREIGN KEY (product_id)
        REFERENCES product (product_id),
    order_QTY INT
);
CREATE TABLE `order` (
    order_id INT PRIMARY KEY,
    FOREIGN KEY (order_id)
        REFERENCES order_detail (order_id),
    customer_id INT,
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    order_date DATE,
    order_total_price DOUBLE
);

