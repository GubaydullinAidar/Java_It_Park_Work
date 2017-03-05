import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println ("Введите количество элементов массива:");
		int arrNum = scanner.nextInt();

		int arr[] = new int[arrNum];
		int s = 0;

		System.out.println("Введите элементы массива:");

		for (int i = 0; i < arr.length ; i++) {

			arr[i] = scanner.nextInt();
			s += arr[i];			
		}

		System.out.println("Сумма элементов массива =" + s);
	}
}