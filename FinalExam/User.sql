DROP DATABASE IF EXISTS User;
CREATE DATABASE User;
USE User;

CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    exp_in_year INT,
    pro_skill VARCHAR(100),
    project_id INT,
    role ENUM('manager', 'employee') NOT NULL
);

USE User;

INSERT INTO User (full_name, email, password, role) VALUES
    ('Manager1', 'manager1@gmail.com', '123456', 'manager'),
    ('Manager2', 'manager2@gmail.com', '123456', 'manager'),
    ('Manager3', 'manager3@gmail.com', '123456', 'manager'),
    ('Manager4', 'manager4@gmail.com', '123456', 'manager'),
    ('Manager5', 'manager5@gmail.com', '123456', 'manager');

INSERT INTO User (full_name, email, password, pro_skill, project_id, role) VALUES
    ('Employee 1', 'employee1@company.com', '123456', 'dev', 1, 'employee'),
    ('Employee 2', 'employee2@company.com', '123456', 'dev', 2, 'employee'),
    ('Employee 3', 'employee3@company.com', '123456', 'sql', 3, 'employee'),
    ('Employee 4', 'employee4@company.com', '123456', 'java', 4, 'employee'),
    ('Employee 5', 'employee5@company.com', '123456', 'test', 5, 'employee');

