class Program {
	public static int[] maxElem (int x[][]) {

		int max[] = new int[x[0].length];

		for (int i = 0; i < x[0].length; i++) {

			max[i] = x[0][i];
			for (int j = 0; j < x.length; j++) {

				if (max[i] < x[j][i]) {
					max[i] = x[j][i];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int a[][] = {{1, 15},
					{10, 4},
					{5, 6}};

		for (int max : maxElem(a)) {
			System.out.println(max);

		}
	}
}