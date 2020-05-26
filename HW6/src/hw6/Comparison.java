package hw6;

public class Comparison implements IOperation {
	public String perform(String num1, String num2) {
		
		// compare with sign
		if (num1.charAt(0) == '-' && num2.charAt(0) != '-')
			return "-1";
		else if (num1.charAt(0) != '-' && num2.charAt(0) == '-')
			return "1";
		
		boolean neg = num1.charAt(0) == '-' && num2.charAt(0) == '-';
		
		if (num1.length() > num2.length())
			return (neg ? "-" : "") + "1";
		else if (num1.length() < num2.length())
			return (neg ? "" : "-") + "1";
		else {
			for (int i = 0; i < num1.length(); i++) {
				if (num1.charAt(i) > num2.charAt(i))
					return (neg ? "-" : "") + "1";
				else if (num1.charAt(i) < num2.charAt(i))
					return (neg ? "" : "-") + "1";
			}
			return "0";
		}
	}
}
