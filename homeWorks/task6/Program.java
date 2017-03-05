import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println ("Введите количество элементов массива:");
		int arrNum = scanner.nextInt();

		int arr[] = new int[arrNum];
		int s = 1;

		System.out.println("Введите элементы массива:");

		for (int i = 0; i < arr.length ; i++) {

			arr[i] = scanner.nextInt();
			
			if ((i + 1) % 2 != 0 && arr[i] % 2 == 0) {
				s *= arr[i];
			}			
		}

		if (s == 1) {
			s = 0;
		}

		System.out.println("Произведение четных элементов массива, стоящих на нечетных позициях =" + s);
	}
}