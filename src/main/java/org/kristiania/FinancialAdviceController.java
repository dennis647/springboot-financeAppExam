package org.kristiania;

import org.kristiania.FinancialAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advice")
public class FinancialAdviceController {

    private final FinancialAdviceService financialAdviceService;

    @Autowired
    public FinancialAdviceController(FinancialAdviceService financialAdviceService) {
        this.financialAdviceService = financialAdviceService;
    }

    @GetMapping("/provide")
    public String provideAdvice() {
        return FinancialAdviceService.provideAdvice();
    }
}
