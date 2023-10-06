package com.example.cobauts;

public class Transaction {
    int id;
    String date;
    String amount;
    String debitCredit;

    public Transaction(String date, String amount, String debitCredit) {
        this.date = date;
        this.amount = amount;
        this.debitCredit = debitCredit;
    }

    public Transaction(int id, String date, String amount, String debitCredit) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.debitCredit = debitCredit;
    }

    public int getId() {
        return id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDebitCredit() {
        return debitCredit;
    }

    public void setDebitCredit(String debitCredit) {
        this.debitCredit = debitCredit;
    }


}






