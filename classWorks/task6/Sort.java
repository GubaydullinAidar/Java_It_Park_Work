public class Sort {

	public static void merge (int a[], int b[]) {

		int i = 0, j = 0, k = 0;

		int c[] = new int[a.length + b.length];
		
		while (i < a.length) {
			
			if (a[i] <= b[j]) {
				c[k] = a[i];
				i++;
			} else if (j < b.length){
				c[k] = b[j];
				j++;
			}
			k++;
		}

		
			while (k < c.length) {
				c[k] = b[j];
				k++;
				j++;
			}

			for (int n = 0; n < c.length; n++) {
				System.out.println(c[n]);
			}
	}
}