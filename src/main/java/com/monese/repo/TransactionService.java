package com.monese.repo;


import com.monese.Entity.AccountEntity;
import com.monese.Entity.TransactionEntity;
import com.monese.dto.AccountTransaction;
import com.monese.dto.MoneyTransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private AccountRepo accountRepo;

    public String transferMoney(MoneyTransferRequest request) {
        TransactionEntity entity = new TransactionEntity();
        entity.setAmountTransfered(request.getTransferAmount());
        entity.setFromAcctNum(request.getFromAcctNum());
        entity.setToAcctNum(request.getToAcctNum());

        final Optional<AccountEntity> fromAccount = accountRepo.findById(Long.valueOf(request.getFromAcctNum()));
        final Optional<AccountEntity> toAccount = accountRepo.findById(Long.valueOf(request.getToAcctNum()));
        if (fromAccount.isPresent() && toAccount.isPresent()) {
            final AccountEntity from = fromAccount.get();
            final AccountEntity to = toAccount.get();
            if (from.getAmount().compareTo(request.getTransferAmount()) == 1) {
                BigDecimal subtractAmt = from.getAmount().subtract(request.getTransferAmount());
                from.setAmount(subtractAmt);

                BigDecimal addAmt = to.getAmount().add(request.getTransferAmount());
                to.setAmount(addAmt);

                System.out.println(from.getAmount());
                System.out.println(to.getAmount());

                accountRepo.saveAndFlush(from);
                accountRepo.saveAndFlush(to);
                //accountRepo.setAmount(from.getAccountId(), subtractAmt);
                //accountRepo.setAmount(to.getAccountId(), addAmt);
                transactionRepo.save(entity);
                return "Successful Transfer";
            } else {
                return "Sufficient Funds not available in account";
            }
        } else {
            return "Accounts not found";
        }

    }

    public String getBalanceByAccountId(Long id) {
        System.out.println("ID :  " + id);
        Optional<AccountEntity> account = accountRepo.findById(id);
        if (account.isPresent()) {
            return ("Balance is :" + account.get().getAmount() + "for AccountID :" + id);
        } else {
            return "No account Found";
        }
    }


    public List<AccountTransaction> getStatementsByAccountId(Long id) {
        List<TransactionEntity> debitTransactions = transactionRepo.findByAccountId(String.valueOf(id));
        System.out.println(debitTransactions.size());
        System.out.println(debitTransactions.get(0).getAmountTransfered());
        List<AccountTransaction> transactionList = debitTransactions.stream().map(x -> {
            String transactType = "Credit";
            if (Long.valueOf(x.getFromAcctNum()) == id) {
                transactType = "DEBIT";
            }

            AccountTransaction transaction = new AccountTransaction();
            transaction.setAmount(x.getAmountTransfered());
            transaction.setTransactionId(x.getId());
            transaction.setTransactionType(transactType);
            return transaction;
        })
                .sorted(Comparator.comparing(AccountTransaction::getTransactionId))
                .collect(Collectors.toList());
        return transactionList;
    }
}
