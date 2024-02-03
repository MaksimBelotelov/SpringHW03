CREATE TABLE IF NOT EXISTS userTable (
    `name` VARCHAR(45) NOT NULL,
    age INT,
    email VARCHAR(45) NOT NULL
);

INSERT INTO userTable (`name`, age, email) VALUES ('Maksim', 32, 'maksim@mail.ru'),
                                                   ('Ivan', 23, 'ivan@mail.ru');