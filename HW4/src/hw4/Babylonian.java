package hw4;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Babylonian {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double n = scan.nextDouble();
		
		scan.close();
	
		double guess = n / 2, delta;
		
		do {
			double newGuess = (guess + (n / guess)) / 2;
			delta = Math.abs(newGuess - guess);
			guess = newGuess;
			
		} while (delta > 0.01);
		
		DecimalFormat fmt = new DecimalFormat("0.##");

		System.out.println(fmt.format(guess));
	}
}
