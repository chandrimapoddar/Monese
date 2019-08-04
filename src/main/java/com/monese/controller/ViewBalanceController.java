package com.monese.controller;


import com.monese.dto.AccountTransaction;
import com.monese.repo.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewBalanceController {

    @Autowired
    private TransactionService service;


    @GetMapping("/viewBalance")
    public String viewAccountBalance(@RequestParam("accountId") Long id) {
        return service.getBalanceByAccountId(id);
    }

    @GetMapping("/viewAccountTransactions")
    @ResponseBody
    public List<AccountTransaction> getAccountTransactions(@RequestParam("accountId") Long id) {
        return service.getStatementsByAccountId(id);
    }
}
