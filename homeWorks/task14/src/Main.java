import java.util.Scanner;

public class Main {

    public static boolean prime (int num) {
        if (num > 3) {
            for (int i = 2; i * i <= num ; i++) {
                if (num % i == 0) {
                    return false;
                } else
                    return true;
            }
        } else if (num == 2 || num == 3)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = scanner.nextInt();
        if (prime(number)) {
            System.out.println("Введенное число простое.");
        } else
            System.out.println("Введенное число составное.");
    }
}
