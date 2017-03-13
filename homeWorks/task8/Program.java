class Program {
	public static double aver (int x[][]) {
		double sum = 0;
		int sumNum = 0;

		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				sum += x[i][j];
				sumNum++;
			}
		}

		return (sum/sumNum);
	}

	public static void main(String[] args) {
		int a[][] = {{1, 2},
					{3, 4},
					{5, 6}};

		System.out.println ("Среднее арифметическое в матрице = " + aver(a));
	}
}