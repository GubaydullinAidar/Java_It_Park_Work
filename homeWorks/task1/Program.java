import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int s = 1;
		int a = scanner.nextInt();

		while (a != -1) {

			int num = 1;

			if (a == 2 || a == 3) {
				num = a;
			}

			for (int i = 2; i*i <= a; i++) {

				if (a % i == 0) {
					num = 1;
					break;
				} else {
					num = a;
				}
			}

			s *= num;
			a = scanner.nextInt();
		}

		if (s == 1) {
			s = 0;
		}

		System.out.println(s);
	}
}