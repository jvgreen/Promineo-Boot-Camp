INSERT INTO store (store_id, city, address) VALUES(1001, 'Rexburg', '868686 Idaho');
INSERT INTO store (store_id, city, address) VALUES(1002, 'Idaho Falls', '868799 Idaho');
INSERT INTO store (store_id, city, address) VALUES(1003, 'Rigby', '868686 Idaho');
INSERT INTO store (store_id, city, address) VALUES(1004, 'Driggs', '868686 Idaho');

INSERT INTO department (department_id, name) VALUES(1, 'Grocery');
INSERT INTO department (department_id, name) VALUES(2, 'Deli');
INSERT INTO department (department_id, name) VALUES(3, 'Electroics');
INSERT INTO department (department_id, name) VALUES(4, 'Sports');

INSERT INTO products (product_id, name, company, price) VALUES(1, '20 count tortillas', 'Mission', 3.50);
INSERT INTO products (product_id, name, company, price) VALUES(2, 'Bacon', 'Falls Brand', 4.00);
INSERT INTO products (product_id, name, company, price) VALUES(3, 'Xbox', 'Microsoft', 399.00);
INSERT INTO products (product_id, name, company, price) VALUES(4, 'Fishing Pole', 'Shakespear', 45.67);

INSERT INTO depart_products(link_id, department_id, product_id) VALUES (1, 1, 1);
INSERT INTO depart_products(link_id, department_id, product_id) VALUES (2, 2, 1);
INSERT INTO depart_products(link_id, department_id, product_id) VALUES (3, 2, 2);
INSERT INTO depart_products(link_id, department_id, product_id) VALUES (4, 3, 3);
INSERT INTO depart_products(link_id, department_id, product_id) VALUES (5, 4, 4);

INSERT INTO salary(salary_id, amount) VALUES (1, 50000);
INSERT INTO salary(salary_id, amount) VALUES (2, 80000);
INSERT INTO salary(salary_id, amount) VALUES (3, 100000);
INSERT INTO salary(salary_id, amount) VALUES (4, 120000);

INSERT INTO employees(employee_id, salary_id, department_id, firstName, lastName) VALUES (1, 1, 1, 'John', 'Doe');
INSERT INTO employees(employee_id, salary_id, department_id, firstName, lastName) VALUES (2, 4, 2, 'Jane', 'Doe');
INSERT INTO employees(employee_id, salary_id, department_id, firstName, lastName) VALUES (3, 2, 3, 'John', 'Smith');
INSERT INTO employees(employee_id, salary_id, department_id, firstName, lastName) VALUES (4, 3, 4, 'Matt', 'Smith');

INSERT INTO depart_employee(department_id, employee_id) VALUES (1, 1);
INSERT INTO depart_employee(department_id, employee_id) VALUES (3, 2);
INSERT INTO depart_employee(department_id, employee_id) VALUES (4, 3);
INSERT INTO depart_employee(department_id, employee_id) VALUES (2, 4);




