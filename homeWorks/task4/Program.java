import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println ("Введите количество элементов массива:");
		int arrNum = scanner.nextInt();

		int arr[] = new int[arrNum];

		System.out.println("Введите элементы массива:");

		for (int i = 0; i < arr.length; i++) {

			arr[i] = scanner.nextInt();			
		}

		for (int k = 0; k < arr.length / 2 ; k++) {

			arr[k] = arr[arr.length - k - 1] * arr[k];
			arr[arr.length - k - 1] = arr[k] / arr[arr.length - k - 1];
			arr[k] = arr[k] / arr[arr.length - k - 1];
			
		}

		System.out.println ("Развернутый массив:");

		for (int m : arr) {

			System.out.print (m + " ");
			
		}
	}
}