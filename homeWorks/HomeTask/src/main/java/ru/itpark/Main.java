package ru.itpark;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов массива:");
        int n = scanner.nextInt();
        System.out.println("Введите количество потоков:");
        int k = scanner.nextInt();

        int array[] = new int[n];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        ThreadSumElementArr sumElementArr;
        FinalSum finalSum = new FinalSum(0);

        for (int i = 0; i < array.length - n % k; i += n / k) {
            if (i < ((n / k) * (k - 1))) {
                sumElementArr = new ThreadSumElementArr(i, i + n / k - 1, array, finalSum);
            } else {
                sumElementArr = new ThreadSumElementArr(i, array.length - 1, array, finalSum);
            }
            sumElementArr.start();
            try {
                sumElementArr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Сумма элементов массива = " + finalSum.getSum());
    }
}
