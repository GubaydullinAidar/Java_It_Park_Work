class Program {
	public static void minElem (int x[][]) {

		for (int i = 0; i < x.length; i++) {

			int min = x[i][0];
			for (int j = 0; j < x[0].length; j++) {

				if (min > x[i][j]) {
					min = x[i][j];
				}
			}
			System.out.println("Минимальный элемент в строке " + (i + 1) + " " + min);
		}
	}

	public static void main(String[] args) {
		int a[][] = {{1, 2},
					{3, 4},
					{5, 6}};

		minElem(a);
	}
}