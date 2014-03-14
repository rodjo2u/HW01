package hr.fer.zemris.java.tecaj.hw1;

public class PrimeNumbers {
	
	private static int[] primes;
	
	/**
	 * 
	 * @param args Argument must be a positive integer.
	 */
	public static void main(String[] args) {
		// Check input arguments
		if(args.length != 1) {
			System.out.println("Wrong number of input arguments");
			System.exit(1);
		}
		else if (Integer.parseInt(args[0].trim()) <= 0){
			System.out.println("Argument must be a positive integer.");
		}
		// If the arguments are valid generate primes.
		else {
			primes = new int[Integer.parseInt(args[0].trim())];
			primes[0]=2;
			if (primes.length > 1)
				generatePrimes();
			printPrimes();
		}
	}
	
	/**
	 * Method generates requested number of prime numbers.
	 */
	private static void generatePrimes(){
		int generatedPrimes=1;
		int i=3;
		while (generatedPrimes < primes.length) {
			if(isPrime(i)) {
				primes[generatedPrimes]=i;
				generatedPrimes++;
			}
			i++;
		}
	}
	
	/**
	 * Method checks if the number n is a prime.
	 * @param n Number to check primality.
	 * @return True of false.
	 */
	public static boolean isPrime(int n) {
		for (int i=2; i<= Math.sqrt((double) n); i++) {
			if ( (n % i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method prints generated prime numbers.
	 */
	public static void printPrimes() {
		for (int i=0; i<primes.length; i++)
			System.out.println((i+1) + ". " + primes[i]);
	}
}
