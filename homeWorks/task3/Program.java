import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int s = 1;
		int a = scanner.nextInt();

		while (a != -1) {

			int num = 1;
			int aSum = 0;

			while (a != 0) {

				aSum = aSum + a % 10;
				a /= 10;
			}

			if (aSum == 2 || aSum == 3) {
				num = a;
			}

			for (int i = 2; i * i <= aSum; i++) {

				if (aSum % i == 0) {
					num = 1;
					break;
				} else {
					num = aSum;
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