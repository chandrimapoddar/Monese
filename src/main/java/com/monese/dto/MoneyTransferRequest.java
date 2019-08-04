package com.monese.dto;

import java.math.BigDecimal;

public class MoneyTransferRequest {

    private String fromAcctNum;
    private String toAcctNum;
    private BigDecimal transferAmount;

    public String getFromAcctNum() {
        return fromAcctNum;
    }

    public void setFromAcctNum(String fromAcctNum) {
        this.fromAcctNum = fromAcctNum;
    }

    public String getToAcctNum() {
        return toAcctNum;
    }

    public void setToAcctNum(String toAcctNum) {
        this.toAcctNum = toAcctNum;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }
}
