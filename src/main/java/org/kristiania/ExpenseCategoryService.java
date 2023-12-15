package org.kristiania;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class ExpenseCategoryService {

    private static final Map<String, String> CATEGORY_KEYWORDS = new HashMap<>();

    static {
        CATEGORY_KEYWORDS.put("food", "Food");
        CATEGORY_KEYWORDS.put("mat", "Food");
        CATEGORY_KEYWORDS.put("rent", "Rent");
        CATEGORY_KEYWORDS.put("housing", "Rent");
        CATEGORY_KEYWORDS.put("transport", "Transportation");
        CATEGORY_KEYWORDS.put("car", "Transportation");
        CATEGORY_KEYWORDS.put("bills", "Bills");
        CATEGORY_KEYWORDS.put("electricity", "Bills");
    }

    @GetMapping("/category/{description}")
    public String categoryExpenses(@PathVariable String description) {
        for (String keyword : CATEGORY_KEYWORDS.keySet()) {
            if (description.toLowerCase().contains(keyword)) {
                return CATEGORY_KEYWORDS.get(keyword);
            }
        }
        return description;
    }
}
