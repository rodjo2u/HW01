package hr.fer.zemris.java.tecaj.hw1;

public class HofstadterQ {
	/**
	 * This program calculates requested number of Hofstadters Q sequence.
	 * @param args Requested number of Hofstadters Q sequence.
	 * Argument must be positive.
	 */
	public static void main (String args[]) {
		// Check if the argument was valid
		if (Long.parseLong(args[0]) <= 0) {
			System.err.println("Argument to Hofstadter Q sequence "
					+ "must be positive.");
			System.exit(1);
		}
		// Calculate Hofstadter Q sequence
		System.out.println("You requested calculation of " + args[0] + 
				". number of Hofstadter's Q-sequence. The requested " + 
				" number is " + hofstadter(Long.parseLong(args[0].trim()))
				+ ". ");
	}
	
	/**
	 * This method calculates requested number of Hofstadters Q sequence.
	 * @param i Number of Hofstadters Q sequence.
	 * @return 
	 */
	public static long hofstadter(long i) {
		if (i==1  || i == 2)
			return 1;
		else 
			return hofstadter(i - hofstadter(i-1)) + 
					hofstadter(i - hofstadter(i-2));
	}
}
