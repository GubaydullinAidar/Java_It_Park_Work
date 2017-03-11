import java.util.Scanner;

class Program {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int b = scanner.nextInt();

		int a[] = {-3, 10, 11, 12, 15, -5};

		int Ind = -1;

		for (int i = 0; i < a.length; i++) {
			if (b == a[i]) {

				Ind = i;

			}
		}

		System.out.println(Ind);
	}
}