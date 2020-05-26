package hw6;

import java.util.Scanner;

public class Bignum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner parser = new Scanner(scan.nextLine());
		scan.close();
		
		// operations
		IOperation ops = null;
		IOperation add = new Addition();
		IOperation sub = new Substraction();
		IOperation cmp = new Comparison();
		
		String x = null, y = null, symbol = null;
		while (parser.hasNext()) {
			String token = parser.next();
			
			// parsing tokens
			switch(token) {
			case "+":
				ops = add;
				break;
			case "-":
				ops = sub;
				break;
			case ">":
				symbol = "1";
				ops = cmp;
				break;
			case "=":
				symbol = "0";
				ops = cmp;
				break;
			case "<":
				symbol = "-1";
				ops = cmp;
				break;
			default:
				if (x == null)
					x = token;
				else if (y == null)
					y = token;
			}
			
			if (ops == null || y == null)
				continue;
			
			// compute
			x = ops.perform(x, y);
			y = null;
			ops = null;
			
			if (symbol != null) {
				if (x.equals(symbol))
					x = "true";
				else 
					x = "false";
				break;
			}
				
		}
		parser.close();
		
		System.out.println(x);
	}

}
