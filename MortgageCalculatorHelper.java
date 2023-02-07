package com.leajava;

public class MortgageCalculatorHelper {
    private int principal;
    private float monthlyInterest;
    private byte months;

    public MortgageCalculatorHelper(int principal, float monthlyInterest, byte months) {
        this.principal = principal;
        this.monthlyInterest = monthlyInterest;
        this.months = months;
    }

    public double calculatePayment() {
        double monthlyPayment = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), months))
                / (Math.pow((1 + monthlyInterest), months) - 1);
        return monthlyPayment;
    }

    public double calculateLoanBalance(int paidMonths) {
        double balance = principal * (Math.pow((1 + monthlyInterest), months) - Math.pow((1 + monthlyInterest), paidMonths))
                / (Math.pow((1 + monthlyInterest), months) - 1);
        return balance;
    }

    public short getMonths() {
        return months;
    }
}
