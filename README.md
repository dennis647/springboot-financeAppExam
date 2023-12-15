Kandidatnr: 2022

Password for mySql database "toor"

First part of the project:
https://github.com/dennis647/FinanceAppEksamen

To run the application, just go on the SpringBootFinanceApp.java class and "Run FinanceApp".
The program runs in the intellij terminal. So after the springboot has booted up everything should work :-)

Features:
- Create own users
- Select exsiting users
- Input Income, expenses & savings amount for each month
- Input a yearly savings goal
- Overview of monthly expenses
- Overview of yearly total income & expenses
- Category API - Some similar expenses go under the same category
- Advice API - Gives advice if you're wasting money on bad things
- 


If needed to create tables yourself, these are the create statements:

CREATE TABLE users ( user_id int(11) NOT NULL AUTO_INCREMENT, fullname varchar(100) NOT NULL, savings_goal decimal(10,2) NOT NULL DEFAULT 0.00, PRIMARY KEY (user_id) ) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE user_savings ( savings_id int(11) NOT NULL AUTO_INCREMENT, user_id int(11) NOT NULL, month date DEFAULT NULL, amount_saved decimal(10,2) NOT NULL, PRIMARY KEY (savings_id), KEY user_id (user_id), CONSTRAINT user_savings_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (user_id) ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE income ( income_id int(11) NOT NULL AUTO_INCREMENT, user_id int(11) DEFAULT NULL, month date DEFAULT NULL, work_income decimal(10,2) DEFAULT NULL, extra_income decimal(10,2) DEFAULT NULL, PRIMARY KEY (income_id), KEY user_id (user_id), CONSTRAINT income_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (user_id) ) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE expenses ( expense_id int(11) NOT NULL AUTO_INCREMENT, user_id int(11) DEFAULT NULL, month date DEFAULT NULL, category varchar(50) DEFAULT NULL, amount decimal(10,2) DEFAULT NULL, PRIMARY KEY (expense_id), KEY user_id (user_id), CONSTRAINT expenses_ibfk_1 FOREIGN KEY (user_id) REFERENCES users (user_id) ) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

Data that can be inserted if you want some values in the database:

INSERT INTO users (user_id, fullname, savings_goal) VALUES (1, 'Ola Normann', 450000);

INSERT INTO income (user_id, month, work_income, extra_income) VALUES (1, '2023-01-01', 42000, 8000);

INSERT INTO expenses (user_id, month, category, amount) VALUES (1, '2023-01-01', 'Alcohol', 3000);
INSERT INTO expenses (user_id, month, category, amount) VALUES (1, '2023-01-01', 'Rent', 10000);
INSERT INTO expenses (user_id, month, category, amount) VALUES (1, '2023-01-01', 'Bills', 3400);
INSERT INTO expenses (user_id, month, category, amount) VALUES (1, '2023-01-01', 'Transport', 2000);

INSERT INTO user_savings (user_id, month, amount_saved) VALUES (1, '2023-01-01', 30000);

