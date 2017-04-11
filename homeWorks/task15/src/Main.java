import java.util.Scanner;

public class Main {

    public static int sumDigitsNum (int numb) {
        int result = 0;

        while (numb != 0) {
            result += numb % 10;
            numb /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        int number = scanner.nextInt();
        System.out.println("Сумма цифр числа " + number + " = " + sumDigitsNum(number));

    }
}
