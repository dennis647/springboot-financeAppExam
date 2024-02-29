package org.kristiania.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @GetMapping("/total")
    public String getTotalExpenses(@RequestParam(value = "userId") String userId) {
        return String.format("Total expenses for user %s: 1000", userId);
    }
}
