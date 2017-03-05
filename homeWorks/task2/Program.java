import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int i = 1;
		int s = 0;

		while (a != -1) {

			if (i % 2 == 0) {
				s += a;
			}

			a = scanner.nextInt();
			i++;
		}

		System.out.println (s);
	}
}