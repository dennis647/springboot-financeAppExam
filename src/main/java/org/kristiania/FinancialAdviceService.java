package org.kristiania;

import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FinancialAdviceService {

    public static String provideAdvice(ResultSet detailedExpensesResultSet) throws SQLException {
        boolean isBadPurchase = false;
        Map<String, Double> categoryExpenses = new HashMap<>();

        while (detailedExpensesResultSet.next()) {
            String expenseCategory = detailedExpensesResultSet.getString("category");
            double expenseAmount = detailedExpensesResultSet.getDouble("amount");

            categoryExpenses.put(expenseCategory, categoryExpenses.getOrDefault(expenseCategory, 0.0) + expenseAmount);

        }
        for (Map.Entry<String, Double> entry : categoryExpenses.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("snus") && entry.getValue() > 500) {
                System.out.println("Spending a lot on snus may not be the best use of your funds. Amount: kr " + entry.getValue());
                isBadPurchase = true;
            }
            if (entry.getKey().equalsIgnoreCase("cigarettes") && entry.getValue() > 500) {
                System.out.println("Spending a lot on cigarettes may not be the best use of your funds. Amount: kr " + entry.getValue());
                isBadPurchase = true;
            }
            if (entry.getKey().equalsIgnoreCase("alcohol") || entry.getKey().equalsIgnoreCase("beer") || entry.getKey().equalsIgnoreCase("vodka")
                    && entry.getValue() > 1500) {
                System.out.println("You've been spending a lot on alcohol. Amount: kr " + entry.getValue());
                isBadPurchase = true;
            }
            if (entry.getKey().equalsIgnoreCase("sweater") || entry.getKey().equalsIgnoreCase("t-shirt") || entry.getKey().equalsIgnoreCase("hoodie")
                    && entry.getValue() > 3000) {
                System.out.println("kr " + entry.getValue() + ",- Is a lot to use on one clothing item");
                isBadPurchase = true;
            }
        }

        if (!isBadPurchase) {
            System.out.println("No specific advice for your expenses this month.");
        }
    return "Advice based on user experince";
    }

    public static String provideAdvice() {
        return "Advice based on user experience";
    }
}
