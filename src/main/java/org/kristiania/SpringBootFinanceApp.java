package org.kristiania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootFinanceApp {

	public static void main(String[] args) throws SQLException {

		FinanceApp financeApp = new FinanceApp();

		// Call methods or functionalities from FinanceApp
		financeApp.financeMain();
	}

}
