package com.leajava;

public class MortgageCalculatorHelper {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;
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

    public double[] getRemainingBalances() {
        double[] balances = new double[months];
        for (int i = 1; i <= months; i++) {
            balances[i-1] = calculateLoanBalance(i);
        }
        return balances;
    }


}
