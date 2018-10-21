package com.niuzj.provider;

import java.util.Scanner;

/**
 * @author niuzheju
 * @date 2018/10/20 21:20
 */
public class Test02 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int i = scanner.nextInt();
        int a = 100;
        int b = 10;
        int bai = i / a;
        int shi = (i - bai * a) / b;
        int ge = i - bai * a - shi * b;
        System.out.println(ge + "," + shi + "," + bai);
    }
}
