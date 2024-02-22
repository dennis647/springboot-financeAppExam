package org.kristiania.controller;

import org.kristiania.service.FinancialAdviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/advice")
public class FinancialAdviceController {

    @GetMapping("/provide")
    public String provideAdviceEndpoint(ResultSet detailedExpensesResultSet) {
        try {
            FinancialAdviceService.provideAdvice(detailedExpensesResultSet);
            return "Advice provided successfully";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Failed to provide financial advice.";
        }
    }
}