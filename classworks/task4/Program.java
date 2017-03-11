import java.util.Random;
class Program {
	public static void main(String[] args) {
		int a[] = new int[100];
		Random random = new Random();

		for(int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(120);
		}

		/*for(int i = 0; i < 100; i++) {
			System.out.println(ages[i]);
		}*/

		for (int i = a.length; i > 0; i--) {

			for (int j = 0; j < i - 1; j++) {

				if (a[j] > a[j + 1]) {

					int tmp = a [j + 1];
					a[j + 1] = a[j];
					a[j] = tmp;

				}
			}	
		}

		for (int k = 0; k < a.length - 1; k++) {
				int sum = 0;
			if (a[k] <= a[k + 1]) {
				sum++;
			} else {
				System.out.println(a[k-1] + "=" + sum);
				sum = 0;
			}
			
		}

		// вывести на экран количество людей, с возрастами от 0 до 120
		

	}
}