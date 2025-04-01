/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.khanhdz;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author IT SUPPORTER
 */
public class ThucHanh {

    static {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
            System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int gcd(int a, int b) {
        int r;
        while (true) {
            if (b == 0) {
                return a;
            }
            r = a % b;
            a = b;
            b = r;
        }
    }

    public static boolean isPrimeSqrt(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0}; // gcd, x, y
        }

        int[] result = extendedGCD(b, a % b);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2];

        int x = y1;
        int y = x1 - (a / b) * y1;

        return new int[]{gcd, x, y};
    }

    // Tìm nghịch đảo modulo bằng Euclid mở rộng
    public static int findInverse(int a, int m) {
        int[] gcdResult = extendedGCD(a, m);
        int gcd = gcdResult[0];
        int x = gcdResult[1];

        if (gcd != 1) {
            throw new ArithmeticException("Không tồn tại nghịch đảo vì gcd(" + a + ", " + m + ") = " + gcd);
        }

        // Đảm bảo kết quả dương
        return (x % m + m) % m;
    }

    public static void main(String[] args) {

        test();
        testOclidMoRong();
    }

    static void test() {
        System.out.println("gcd ?: " + gcd(5, 18));
        System.out.println("prime ?: " + isPrimeSqrt(6));

        int a = 1759 / 550;
        System.out.println(a);
    }

    static void testOclidMoRong() {
        int a = 30;
        int b = 12;

        int[] result = extendedGCD(a, b);
        int gcd = result[0];
        int x = result[1];
        int y = result[2];

        System.out.println("GCD(" + a + ", " + b + ") = " + gcd);
        System.out.println("Các hệ số Bézout: x = " + x + ", y = " + y);
        System.out.println("Kiểm tra: " + a + "*" + x + " + " + b + "*" + y + " = " + (a * x + b * y));
    }
}
