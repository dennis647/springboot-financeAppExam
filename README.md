Kandidatnr: 2022

Password for mySql database "toor"

The start up coding for this project:
https://github.com/dennis647/FinanceAppEksamen
(For installing spring boot, i created this new repository)

To run the application, just go on the SpringBootFinanceApp.java class and "Run FinanceApp".
The program runs in the intellij terminal where you would write all the inputs etc. So after the springboot has booted up everything should work :-)

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




Overview – Description of the project:
Money is always something that is needed in your life, so why should you waste more than you have to? 
As a student myself, money is always needed, and it is important to have control of what goes in and what goes out of your bank account. Some months have more income or expenses than other months, but it’s always an advantage to know what your monthly expenses are, where you can save money, full overview of your payments etc. This is not only useful for when I’m a student, but also through the rest of my life.
Therefore, my project is: A personal financial overview, an application that uses different microservices to keep track of your finance, can categorize different payments, track income, come with examples where I could save money etc.
With this personal financial overview application, I can get full control of my finances. Through different microservices this application will track your monthly income and expenses, it will show suggestions to what expenses could be avoided, gather up all the fixed monthly payments to get an overview of what you might not need. Along with some other microservices.


Features:
- Create own users
- Select exsiting users
- Input Income, expenses & savings amount for each month
- Input a yearly savings goal
- Overview of monthly expenses
- Overview of yearly total income & expenses
- Category API - Some similar expenses go under the same category
- Advice API - Gives advice if you're wasting money on bad things

User stories
1.	Income tracking
•	As a user, I want the application to track all my various sources of income, such as my salary, my investments and freelance work.
•	I want that the application to give me suggestions on how I can optimize my income, for example putting my extra income into savings.
2.	Recommendations to save money.
•	As a user, I want the application to have a good overview and analysis of my spending habits. Here I want to application to come with suggestions for where I can save money.
•	I want to get recommendations based on my financial data and where I can save my money.
3.	Expense tracking
•	As a user, I want the application to categorize my expenses, so that I can see what different categories my expenses go towards, and I want it to put similar expenses into one category.
•	As a user, I want to see an overview of the entire year that shows what I used in total on each category.
4.	Overview
•	As a user, I want to see a clear overview of my monthly income and expenses for the selected month. Here I also want an in-depth view where I can see the categories the expenses have gone to as well.
•	As a user, I want to see a yearly overview of my total income and expenses. I also want to see an in-depth view of where my total expenses have gone to, what categories and I want to see how much I have saved in total for the entire year, see it for each month and how far I’m from my savings goal.


  

