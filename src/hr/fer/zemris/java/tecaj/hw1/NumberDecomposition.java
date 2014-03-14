package hr.fer.zemris.java.tecaj.hw1;

public class NumberDecomposition {

	/**
	 * 
	 * @param args Argument must be a positive integer greater than 1.
	 */
	public static void main(String[] args) {
		// Check input arguments
		if(args.length != 1) {
			System.out.println("Wrong number of input arguments");
			System.exit(1);
		}
		else if (Integer.parseInt(args[0].trim()) <= 1) {
			System.out.println("Argument must be a positive integer" 
					+ "greater than 1.");
		}
		// If the arguments are valid generate primes.
		else {
			decomposeNumber(Integer.parseInt(args[0].trim()));
		}

	}

	/**
	 * This method decomposes a  number onto its prime factors and outputs
	 * divisors onto standard output.
	 * @param i Number to decompose.
	 */
	public static void decomposeNumber(int i) {
		int numberOfDivisiors=1;
		while (i != 1) {
			int divisor = 2;
			while (i % divisor != 0) {
				divisor++;
			}
			i = i/divisor;
			System.out.println(numberOfDivisiors + ". " + divisor);
		}
	}
}
