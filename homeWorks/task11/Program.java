class Program {
	public static void nullMainDiag (int x[][]) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length; j++) {
				if (j == (x.length - i - 1)) {
					x[i][j] = 0;
				}
			}
		}
	}

	public static void printArr (int b[][]) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main (String[] args) {
		int a[][] = { {1, 2, 3},
						{4, 5, 6},
						{7, 8, 9} };

		nullMainDiag(a);
		printArr(a);
	}
}