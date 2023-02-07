package com.leajava;

import java.text.NumberFormat;

public class MortgageReport {
    public static NumberFormat printMonthlyPayment(int principal, short months, float monthlyInterest) {
        double monthlyPayment = PaymentSchedule.calculatePayment(principal, monthlyInterest, months);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String payment = currency.format(monthlyPayment);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment);
        return currency;
    }

    public static void printPaymentSchedule(int principal, short months, float monthlyInterest, NumberFormat currency) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (int i = 1; i <= months; i++) {
            double balance = PaymentSchedule.calculateLoanBalance(principal, monthlyInterest, months, i);
            String balanceCurrency = currency.format(balance);
            System.out.println(balanceCurrency);
        }
    }
}
