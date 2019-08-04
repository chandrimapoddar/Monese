package com.monese.controller;

import com.monese.dto.MoneyTransferRequest;
import com.monese.repo.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/send")
public class MoneySendController {


    @Autowired
    private TransactionService service;

    @PostMapping("/transferMoney")
    @Transactional
    public String sendMoney(@RequestBody MoneyTransferRequest req) {
        //do some processing
        //need to check database if positive balance is there for the accounts
        return service.transferMoney(req);
        /*System.out.println("Transfer Amount" + req.getTransferAmount() + "Successful From Account No :" +
                req.getFromAcctNum() + "to Account No :"+ req.getToAcctNum());*/
    }
}
