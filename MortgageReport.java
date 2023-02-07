package com.leajava;

import java.text.NumberFormat;

public class MortgageReport{

    private MortgageCalculatorHelper calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculatorHelper calculator) {

        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances()) {
            String balanceCurrency = currency.format(balance);
            System.out.println(balanceCurrency);
        }
    }

    public void printMonthlyPayment() {

        double monthlyPayment = calculator.calculatePayment();
        String payment = currency.format(monthlyPayment);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment);
    }
}
