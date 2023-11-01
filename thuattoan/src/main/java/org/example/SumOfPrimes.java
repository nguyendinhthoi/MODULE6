package org.example;

public class SumOfPrimes {
    static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2){
            return true;
        }
        return false;
    }
    static int sumOfPrimes(int n) {
        int total = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                total += i;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int n = 100;
        int result = sumOfPrimes(n);
        System.out.println("Tổng của các số nguyên tố từ 2 đến " + n + " là " + result);
    }
}
