package com.leajava;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int number = scanner.nextInt();
        // always put the most specific conditions at tbe beginning
        // nested if statements are bad practices, not as clean and harder to read
        if (number%5 == 0 && number%3 ==0)
            System.out.println("FizzBuzz");
        else if (number%5 == 0)
            System.out.println("Fizz");
        else if (number%3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);

    }
}
