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

        NumberFormat currency = MortgageReport.printMonthlyPayment(principal, months, monthlyInterest);
        MortgageReport.printPaymentSchedule(principal, months, monthlyInterest, currency);
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
