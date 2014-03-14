package hr.fer.zemris.java.tecaj.hw1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This program calculates area and perimeter of user generated rectangle.
 * @author Igor Petkovski
 *
 */
public class Rectangle {

	/**
	 * @param args Arguments are width and height of an rectangle.
	 *  Both arguments must be non negative.
	 */
	public static void main(String[] args) throws IOException {
		double width = 0.0;
		double height = 0.0;
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(System.in))
				);
		
		switch (args.length) {
			case 0: 
				System.out.println("Nothing was given.");
				width = getRectangleDimension(reader, "Width");
				height = getRectangleDimension(reader, "Height");
				break;
			case 2:
				if ((validateInput(args[0]) == 1) && (validateInput(args[1]) == 1)) {
					width = Integer.parseInt(args[0].trim());
					height = Integer.parseInt(args[1].trim());
				}
				else {
					System.out.println("Both arguments must be positive.");
					System.exit(1);
				}
				break;
			default :
				System.out.println("Invalid number of arguments was provided!.");
				System.exit(1);
		}
		
		System.out.println("You have specified a rectangle with width " + 
				width + " and height " + height + ". Its area is " + 
				calculateArea(width, height) + " and its perimeter is " + 
				calculatePerimeter(width, height) + ".");
		
		reader.close();
	}
	
	/**
	 * Gets one rectangle dimension from standard input.
	 * @param reader Buffer reader instance.
	 * @param dimension String representing wanted dimension to user.
	 * @return Dimension value.
	 * @throws IOException
	 */
	private static double getRectangleDimension(BufferedReader reader,
			String dimension) throws IOException {
		String value;
		System.out.println("Please provide " + dimension + ":");
		value = reader.readLine().trim();
		
		switch (validateInput(value)) {
			case 0 :
				System.out.println("Nothing was given.");
				return getRectangleDimension(reader, dimension);
			case -1 :
				System.out.println(dimension + " is negative.");
				return getRectangleDimension(reader, dimension);
			default :
				break;
		}
		return Double.parseDouble(value);
	}

	/**
	 * Checks if an input string is a valid non-negative number.
	 * @param input
	 * @return Returns 0 if string is empty, -1 if value is negative, 
	 * and 1 if it is a positive value.
	 */
	private static int validateInput(String input) {
		if (input.isEmpty())
			return 0;
		else if (input.startsWith("-"))
			return -1;
		else
			return 1;
	}
	
	/**
	 * Calculates the area of an rectangle.
	 * @param width
	 * @param height
	 * @return 
	 */
	private static double calculateArea(double width, double height) {
		return width*height;
	}
	
	/**
	 * Calculates the perimeter of an rectangle.
	 * @param width
	 * @param height
	 * @return
	 */
	private static double calculatePerimeter(double width, double height) {
		return width*2+height*2;
	}

}
