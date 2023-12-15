package org.kristiania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootFinanceApp {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(SpringBootFinanceApp.class, args);
		FinanceApp financeApp = new FinanceApp();

		financeApp.financeMain();
	}

}
