package org.util;

import java.math.BigDecimal;

public class Payment {
    private String account;
    private BigDecimal amount;

    public Payment(String account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAccount() {
        return account;
    }
}
