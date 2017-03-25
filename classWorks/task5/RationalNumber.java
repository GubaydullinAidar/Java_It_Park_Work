public class RationalNumber {
	int numerator;
	int denominator;

	RationalNumber () {
		numerator = 0;
		denominator = 1;
	}

	RationalNumber (int numer, int denom) {
		numerator = numer;
		denominator = denom;
	}

	double normal() {
		double result = numerator/ denominator;
		return result;
	}
}