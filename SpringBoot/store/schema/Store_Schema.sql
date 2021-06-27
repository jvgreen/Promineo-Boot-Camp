DROP TABLE IF EXISTS depart_employee;
DROP TABLE IF EXISTS depart_products;
DROP TABLE IF EXISTS store; 
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS salary;
DROP TABLE IF EXISTS depart_employee;

CREATE TABLE store (
    store_id int NOT NULL Unique,
    city varchar(50) NOT NULL,
    address varchar(250) NOT NULL,
    PRIMARY KEY (store_id)
);

CREATE TABLE department (
    department_id int unsigned NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    PRIMARY KEY (department_id)
);

CREATE TABLE products (
    product_id int unsigned NOT NULL AUTO_INCREMENT,
    name varchar(150) NOT NULL,
    company varchar(150) NOT NULL,
    price decimal(9, 2) NOT NULL,
    PRIMARY KEY (product_id)
);

CREATE TABLE depart_products (
    link_id int Unique NOT NULL AUTO_INCREMENT,
    department_id int unsigned NOT NULL,
    product_id int unsigned NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (department_id),
    FOREIGN KEY (product_id) REFERENCES products (product_id) 
);

CREATE TABLE salary (
    salary_id int unsigned NOT NULL AUTO_INCREMENT,
    amount decimal(9,2) NOT NULL,
    PRIMARY KEY (salary_id)
);

CREATE TABLE employees (
    employee_id int unsigned NOT NULL AUTO_INCREMENT,
    salary_id int unsigned NOT NULL,
    department_id int unsigned NOT NULL,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (salary_id) REFERENCES salary (salary_id)
);

CREATE TABLE depart_employee (
    department_id int unsigned NOT NULL,
    employee_id  int unsigned NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (department_id),
    FOREIGN KEY (employee_id) REFERENCES employees (employee_id)
);

