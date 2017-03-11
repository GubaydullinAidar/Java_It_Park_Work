class Program {
	public static int sum(int a, int b) {

		int result = a;

		while ( a < b) {

			a++;
			result += a;			
			
		}

		return result;
	}

	public static void main(String[] args) {
		int x = 6;
		int y = 8;
		int c = sum (x, y);

		System.out.println(c);
	}
}