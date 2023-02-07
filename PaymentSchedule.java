package com.leajava;

public class PaymentSchedule {
    public static void main(String[] args) {
        // use appropriate variable type with suitable size
        int principal = (int) Console.readNumber("Principal ($1k - $1M): ", 1000, 1000000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rates :", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculatorHelper(principal, annualInterest, years);
        var report = new MortgageReport(calculator);
        report.printMonthlyPayment();
        report.printPaymentSchedule();
    }

}
