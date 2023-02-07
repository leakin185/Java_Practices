package com.leajava;

import java.text.NumberFormat;

public class PaymentSchedule {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {
        // use appropriate variable type with suitable size
        int principal = (int) Console.readNumber("Principal ($1k - $1M): ", 1000, 1000000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rates :", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        short months = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest/MONTHS_IN_YEAR/PERCENT;

        NumberFormat currency = printMonthlyPayment(principal, months, monthlyInterest);
        printPaymentSchedule(principal, months, monthlyInterest, currency);
    }

    private static NumberFormat printMonthlyPayment(int principal, short months, float monthlyInterest) {
        double monthlyPayment = calculatePayment(principal, monthlyInterest, months);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String payment = currency.format(monthlyPayment);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment);
        return currency;
    }

    private static void printPaymentSchedule(int principal, short months, float monthlyInterest, NumberFormat currency) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (int i = 1; i <= months; i++) {
            double balance = calculateLoanBalance(principal, monthlyInterest, months, i);
            String balanceCurrency = currency.format(balance);
            System.out.println(balanceCurrency);
        }
    }

    public static double calculatePayment(double principal, float monthlyInterest, short months) {
        double monthlyPayment = principal*(monthlyInterest*Math.pow((1+monthlyInterest), months))
                /(Math.pow((1+monthlyInterest), months)-1);
        return monthlyPayment;
    }

    public static double calculateLoanBalance(double principal, float monthlyInterest, short months, int paidMonths) {
        double balance = principal*(Math.pow((1+monthlyInterest), months)-Math.pow((1+monthlyInterest), paidMonths))
                /(Math.pow((1+monthlyInterest), months)-1);
        return balance;
    }
}
