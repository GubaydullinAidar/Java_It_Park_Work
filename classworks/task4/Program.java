import java.util.Random;
class Program {
	public static void main(String[] args) {
		int a[] = new int[100];
		Random random = new Random();

		for(int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(120);
		}

		int b[] = new int[120];

		for (int j = 0; j < a.length; j++) {
			b[a[j]] ++;
		}

		for (int k = 0; k < b.length; k++) {
			if (b[k] != 0) {
				System.out.println(k + " = " + b[k]);
			}
		}

		// вывести на экран количество людей, с возрастами от 0 до 120
		

	}
}