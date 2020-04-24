package hw2;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

public class QuadraticEq {

	public static void main(String[] args) {
		double a, b, c;
		Scanner scan = new Scanner(System.in);
		String fmt;
		
		a = scan.nextDouble();
		b = scan.nextDouble();
		c = scan.nextDouble();
		fmt = scan.next();
		
		scan.close();
		
		DecimalFormat pattern = new DecimalFormat(fmt);
		
		double delta = Math.sqrt((Math.pow(b, 2) - 4 * a * c));
		System.out.println(pattern.format((-b + delta) / 2 / a));
		System.out.println(pattern.format((-b - delta) / 2 / a));
	}
}
