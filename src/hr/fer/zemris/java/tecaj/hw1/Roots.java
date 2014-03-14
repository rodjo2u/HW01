package hr.fer.zemris.java.tecaj.hw1;

public class Roots {

	/**
	 * This class calculates designated root of a designated imaginary number.
	 * @param args Program accepts three arguments: real part of imaginary
	 * number, imaginary part of imaginary number and requested root
	 * of imaginary number.
	 */
	public static void main(String[] args) {
		
		if (args.length != 3) {
			System.err.println("You have enterd wrong number of elements");
			System.exit(1);
		}
			
		Double real = Double.parseDouble(args[0].trim());
		Double imaginary = Double.parseDouble(args[1].trim());
		int root = Integer.parseInt(args[2].trim());
		
		Double absoluteLength = absoluteLength(real, imaginary);
		
		Double angle = Math.atan2(imaginary, real);
		
		long newReal, newImaginary;
		
		for (int i=0; i < root; i++) {
			newReal = Math.round(Math.pow(absoluteLength, 1.0/root)*
					Math.cos((angle+2*i*Math.PI)/root));
			newImaginary = Math.round(Math.pow(absoluteLength, 1.0/root)*
					Math.sin((angle+2*i*Math.PI)/root));
			if( newImaginary >= 0)
				System.out.println(newReal + " + " + newImaginary + "i");
			else
				System.out.println(newReal + " - " + Math.abs(newImaginary) + "i");
		}
	}
	
	/**
	 * This method calculates absolute length of imaginary number.
	 * @param real Real component of imaginary number.
	 * @param imaginary Imaginary component of imaginary number.
	 * @return Absolute length of imaginary number.
	 */
	public static Double absoluteLength(Double real, Double imaginary) {
		return Math.sqrt(Math.pow(real,2) + Math.pow(imaginary, 2));
	}

}
