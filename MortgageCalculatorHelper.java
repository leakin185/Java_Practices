package com.leajava;

public class MortgageCalculatorHelper {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;
    private int principal;
    private float yearlyInterest;
    private byte years;
    private float monthlyInterest;
    private byte months;

    public MortgageCalculatorHelper(int principal, float yearlyInterest, byte years) {
        this.principal = principal;
        this.yearlyInterest = yearlyInterest;
        this.years = years;
        this.months = getPaymentMonths();
        this.monthlyInterest = getMonthlyInterest();
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

    public byte getPaymentMonths() {
        return (byte)(years * MONTHS_IN_YEAR);
    }

    public float getMonthlyInterest() {
        return yearlyInterest / MONTHS_IN_YEAR / PERCENT;
    }

    public double[] getRemainingBalances() {
        var balances = new double[months];
        for (short i = 1; i <= balances.length; i++) {
            balances[i-1] = calculateLoanBalance(i);
        }
        return balances;
    }


}
