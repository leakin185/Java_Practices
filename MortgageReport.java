package com.leajava;

import java.text.NumberFormat;

public class MortgageReport{

    private MortgageCalculatorHelper calculator;

    public MortgageReport(MortgageCalculatorHelper calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (int i = 1; i <= calculator.getMonths(); i++) {
            double balance = calculator.calculateLoanBalance(i);
            var currency = NumberFormat.getCurrencyInstance();
            String balanceCurrency = currency.format(balance);
            System.out.println(balanceCurrency);
        }
    }

    public void printMonthlyPayment() {
        double monthlyPayment = calculator.calculatePayment();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String payment = currency.format(monthlyPayment);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment);
    }
}
