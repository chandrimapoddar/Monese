package com.monese.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "TRANSACTION_TABLE")
public class TransactionEntity {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Long id;


    @Column(name = "from_account_num")
    private String fromAcctNum;

    @Column(name = "to_account_num")
    private String toAcctNum;

    @Column(name = "amount_transfered")
    private BigDecimal amountTransfered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getAmountTransfered() {
        return amountTransfered;
    }

    public void setAmountTransfered(BigDecimal amountTransfered) {
        this.amountTransfered = amountTransfered;
    }
}
