import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пароль:");
        while (true) {
            String passw = scanner.nextLine();
            try {
                Verifier.verify(passw);
                return;
            } catch (PasswordExeption e) {
                System.out.println("Введите пароль заново!");
            }
        }
    }
}
