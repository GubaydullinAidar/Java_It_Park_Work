class Program {
	public static void main(String[] args) {

		int a[] = {-3, 10, 11, 12, 15, -5};

		for (int i = a.length; i > 0; i--) {

			for (int j = 0; j < i - 1; j++) {

				if (a[j] > a[j + 1]) {

					int tmp = a [j + 1];
					a[j + 1] = a[j];
					a[j] = tmp;

				}
			}
			
		}

		for (int k = 0; k < a.length; k++) {
			System.out.println(a[k] + " ");
		}
	}
}