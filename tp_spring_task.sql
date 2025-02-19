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
    creation_date DATE NOT NULL,
    `status` TINYINT(1) NOT NULL DEFAULT 0,
    user_id INT NOT NULL
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS categories (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    label VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB CHARSET=utf8mb4;


-- table associative
CREATE TABLE completing  (
    task_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (task_id, category_id),
    FOREIGN KEY (task_id) REFERENCES task(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
) ENGINE=InnoDB CHARSET=utf8mb4;


-- foreign keys
ALTER TABLE users
ADD CONSTRAINT fk_roles
FOREIGN KEY(role_id) REFERENCES roles(id);

ALTER TABLE tasks
ADD CONSTRAINT fk_users
FOREIGN KEY(user_id) REFERENCES users(id);
