package com.leajava;

import java.text.NumberFormat;
import java.util.Scanner;

public class PaymentSchedule {
    public static void main(String[] args) {
        // use appropriate variable type with suitable size
        int principal = (int)readNumber("Principal ($1k - $1M): ", 1000, 1000000);
        float annualInterest = (float)readNumber("Annual Interest Rates :", 1, 30);
        byte years = (byte)readNumber("Period (Years): ", 1, 30);

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        short months = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest/MONTHS_IN_YEAR/PERCENT;

        double monthlyPayment = calculatePayment(principal, monthlyInterest, months);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String payment = currency.format(monthlyPayment);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + payment);
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
        double monthlyPayment = principal*(monthlyInterest*Math.pow((1+monthlyInterest), months))/(Math.pow((1+monthlyInterest), months)-1);
        return monthlyPayment;
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + "and " + max);
        }
        return value;
    }

    public static double calculateLoanBalance(double principal, float monthlyInterest, short months, int paidMonths) {
        double balance = principal*(Math.pow((1+monthlyInterest), months)-Math.pow((1+monthlyInterest), paidMonths))/(Math.pow((1+monthlyInterest), months)-1);
        return balance;
    }
}
