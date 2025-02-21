-- création de la base de données -param charset global
CREATE DATABASE IF NOT EXISTS tp_spring_task CHARACTER SET utf8mb4;
USE tp_spring_task;

-- création des tables
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    lastname  VARCHAR(50) NOT NULL,
    firstname  VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(100) NOT NULL,
    role_id INT NOT NULL
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    role_name VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    title VARCHAR(50) NOT NULL,
    `description` VARCHAR(255),
    creation_date DATE NOT NULL DEFAULT (current_date()),
    `status` TINYINT(1) NOT NULL DEFAULT 0,
    user_id INT NOT NULL
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS categories (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    label VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB CHARSET=utf8mb4;



-- foreign keys
ALTER TABLE users
ADD CONSTRAINT fk_roles
FOREIGN KEY(role_id) REFERENCES roles(id);

ALTER TABLE tasks
ADD CONSTRAINT fk_users
FOREIGN KEY(user_id) REFERENCES users(id);

-- table associative
CREATE TABLE tasks_categories  (
    task_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (task_id, category_id),
    FOREIGN KEY (task_id) REFERENCES tasks(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
) ENGINE=InnoDB CHARSET=utf8mb4;

INSERT INTO roles (role_name) VALUES ("ADMIN"),("MANAGER"),("USER");
INSERT INTO categories (label) VALUES ("JAVA"),("JS"),("PHP"),("HTML"), ("CSS"), ("SQL");