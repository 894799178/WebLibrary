package com.weblibrary.domain;

/**
 *
 * 帐号类
 * 该类对应数据库中account对象.
 */
public class Account {
    private int accountId;
    private int balance;



    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account() {
    }
    public Account(int accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }
}
