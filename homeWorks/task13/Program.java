class Program {
	public static void maxElem (int x[][]) {

		for (int i = 0; i < x[0].length; i++) {

			int max = x[0][i];
			for (int j = 0; j < x.length; j++) {

				if (max < x[j][i]) {
					max = x[j][i];
				}
			}
			System.out.println("Максимальный элемент в столбце " + (i + 1) + " " + max);
		}
	}

	public static void main(String[] args) {
		int a[][] = {{1, 2},
					{3, 4},
					{5, 6}};

		maxElem(a);
	}
}