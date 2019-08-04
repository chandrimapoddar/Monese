package com.monese.Entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity(name = "ACCOUNT_TABLE")
@DynamicUpdate
public class AccountEntity {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "account_holder_phone")
    private String accountHolderPhone;

    @Column(name = "account_holder_postcode")
    private String accountHolderPostCode;

    @Column(name = "account_balance")
    private BigDecimal amount;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountHolderPhone() {
        return accountHolderPhone;
    }

    public void setAccountHolderPhone(String accountHolderPhone) {
        this.accountHolderPhone = accountHolderPhone;
    }

    public String getAccountHolderPostCode() {
        return accountHolderPostCode;
    }

    public void setAccountHolderPostCode(String accountHolderPostCode) {
        this.accountHolderPostCode = accountHolderPostCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
