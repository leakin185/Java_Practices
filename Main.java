package com.leajava;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var calculator = new TaxCalculator2018(100);
        var report = new TaxReport(calculator);
    }
}