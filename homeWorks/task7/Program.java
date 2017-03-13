class Program {

	public static int locMax(int x[]) {

		int result = 0;

		for (int i = 1; i < x.length - 1; i++) {
			if (x[i] > x[i - 1] && x[i] > x[i + 1]) {
				result ++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int a[] = {1, 3, 2, 5, 4, 3, 1};

		System.out.println("Количество локальных максимумов = " + locMax(a));
	}
}