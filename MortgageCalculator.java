package com.leajava;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        // avoid magic numbers
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        double principal;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal ($1k - $1M): ");
        principal = scanner.nextDouble();
        while (!(1000 <= principal && principal <= 1000000)) {
            System.out.println("Enter a number between 1,000 and 1,000,000");
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextDouble();
        }

        // always use meaningful and descriptive variable names
        // use camel casing
        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        while (!(annualInterest > 0) || !(annualInterest<=30)) {
            System.out.println("Enter a value greater than 0 and less than or equals to 30");
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
        }
        float monthlyInterest = annualInterest/MONTHS_IN_YEAR/PERCENT;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        while (!(years > 0) || !(years<=30)) {
            System.out.println("Enter a value greater than 0 and less than or equals to 30");
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
        }
        int months = years * 12;

        double mortgage = principal
                * monthlyInterest * Math.pow(1+monthlyInterest, months)
                / (Math.pow(1+monthlyInterest, months) -1);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgage);
        System.out.println("Mortgage: " + result);
    }
}