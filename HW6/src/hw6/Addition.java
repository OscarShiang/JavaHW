package hw6;

import java.lang.Math;

public class Addition implements IOperation {
	
	public String perform(String num1, String num2) {
		// dealing with zeros
		if (num1.equals("0"))
			return num2;
		if (num2.equals("0")) 
			return num1;
		
		// dealing with different sign
		boolean neg_a = num1.charAt(0) == '-';
		boolean neg_b = num2.charAt(0) == '-';
		
		Comparison cmp = new Comparison();
		Substraction sub = new Substraction();
		if (!neg_a && neg_b) {
			
			String verify = cmp.perform(num1, num2.substring(1));
			switch(verify) {
			case "1":
				return sub.perform(num1.substring(1), num2);
			case "-1":
				return "-" + sub.perform(num2.substring(1), num1);
			case "0":
				return "0";
			}
		} else if (neg_a && !neg_b) {
			String verify = cmp.perform(num1.substring(1), num2);
			switch(verify) {
			case "1":
				return "-" + sub.perform(num1.substring(1), num2);
			case "-1":
				return sub.perform(num2, num1.substring(1));
			case "0":
				return "0";
			}
		}
		
		// dealing with same sign
		if (neg_a && neg_b) {
			num1 = num1.substring(1);
			num2 = num2.substring(1);
		}
		int max = Math.max(num1.length(), num2.length());
		char result[] = new char[max + 1];
		int a, b;
		for (int i = 0; i <= max; i ++) {
			if (i < num1.length())
				a = (int)num1.charAt(num1.length() - i - 1) - '0';
			else 
				a = 0;
			if (i < num2.length())
				b = (int)num2.charAt(num2.length() - i - 1) - '0';
			else
				b = 0;
			
			result[i] += (char)(a + b + '0');
			
			if (result[i] > '9') {
				result[i] -= 10;
				result[i + 1] ++;
			}
		}
		
		int i;
		for (i = max; i >= 0; i--) {
			if (result[i] != '0')
				break;
			else 
				result[i] = '\0';
		}
		for (int j = 0; j < i; j++, i--) {
			char tmp = result[i];
			result[i] = result[j];
			result[j] = tmp;
		}
		return (neg_a && neg_b ? "-" : "") + new String(result); 
	}
}
