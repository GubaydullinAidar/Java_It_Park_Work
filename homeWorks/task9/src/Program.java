class Program {
	public static int[] minElem (int x[][]) {

		int min[] = new int[x.length];

		for (int i = 0; i < x.length; i++) {

			min[i] = x[i][0];
			for (int j = 0; j < x[0].length; j++) {

				if (min[i] > x[i][j]) {
					min[i] = x[i][j];
				}
			}
		}

		return min;
	}

	public static void main(String[] args) {
		int a[][] = {{1, 0},
					{10, 4},
					{5, 13}};

		for (int i:minElem(a)) {
			System.out.println(i);
		}
	}
}