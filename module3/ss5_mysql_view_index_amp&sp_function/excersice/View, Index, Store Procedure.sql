-- b1
CREATE DATABASE IF NOT EXISTS demo;
USE demo;

-- b2
CREATE TABLE products(
id INT AUTO_INCREMENT PRIMARY KEY,
product_code INT,
product_name VARCHAR(50),
product_price FLOAT,
product_amount INT,
product_description VARCHAR(255),
product_status VARCHAR (255)
);
INSERT INTO products(product_code,
product_name,
product_price ,
product_amount ,
product_description,
product_status)
VALUE
	(3,'rượu',1000,10,'aaaaaaa','còn hàng'),
	(2,'bánh',2000,20,'bbbbb','còn hàng'),
	(5,'nước suối',10000,10,'hhhh','còn hàng'),
	(4,'coca',9999,33,'ggg','còn hàng'),
	(10,'kẹo',5555,44,'zzzzz','hết hàng'),
	(9,'sting',1111,11,'aaaaiiiiiaaa','còn hàng');

-- b3
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
	ALTER TABLE products ADD INDEX idx_product_code(product_code);
	EXPLAIN SELECT * FROM products WHERE product_code=3;
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
	ALTER TABLE products ADD INDEX idx_name_price (product_name,product_price);
    EXPLAIN SELECT * FROM products WHERE product_name = 'bánh' and product_price='500';
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index

-- b4
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE VIEW products_view AS
SELECT 
product_code,
product_name,
product_price,
product_status
FROM products;
-- Tiến hành sửa đổi view
CREATE OR REPLACE VIEW products_view AS
SELECT product_description
FROM products;
-- Tiến hành xoá view
DROP VIEW products_view;

-- b5
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
	CREATE PROCEDURE get_all_info_products()
    BEGIN
    SELECT * FROM products;
    END //
DELIMITER ;
CALL get_all_info_products();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
	CREATE PROCEDURE get_all_info_products()
    BEGIN
    SELECT * FROM products;
    END //
DELIMITER ;
	CALL get_all_info_products();

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
	CREATE PROCEDURE get_all_info_products()
    BEGIN
    SELECT * FROM products WHERE id = 1;
    SET product_name = 'aa';
    END //
DELIMITER ;
	CALL get_all_info_products();
-- Tạo store procedure xoá sản phẩm theo id








