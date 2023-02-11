package com.leajava;
public class TaxCalculator2018 implements TaxCalculator{
    private double taxableincome;

    public TaxCalculator2018(double taxableincome) {
        this.taxableincome = taxableincome;
    }

    @Override
    public double calculateTax() {
        return taxableincome * 0.3;
    }
}
