package com.leajava;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        // avoid magic numbers
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // always use meaningful and descriptive variable names
        // use camel casing for methods and variables
        int principal = (int)readNumber("Principal ($1k - $1M): ", 1000, 1000000);
        float annualInterest = (float)readNumber("Annual Interest Rates", 1, 30);
        byte years = (byte)readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgage);
        System.out.println("Mortgage: " + result);
    }

    public static double calculateMortgage(double principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float monthlyInterest = annualInterest/MONTHS_IN_YEAR/PERCENT;
        short months = (short)(years * MONTHS_IN_YEAR);
        double mortgage = principal
                * monthlyInterest * Math.pow(1+monthlyInterest, months)
                / (Math.pow(1+monthlyInterest, months) -1);
        return mortgage;
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print("Principal: ");
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + "and " + max);
        }
        return value;
        }
    }