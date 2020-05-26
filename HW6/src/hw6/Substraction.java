package hw6;

public class Substraction implements IOperation {
	public String perform(String num1, String num2) {
		boolean neg_a = num1.charAt(0) == '-';
		boolean neg_b = num2.charAt(0) == '-';
		
		// dealing with zeros
		if (num1.equals("0")) {
			if (num2.equals("0"))
				return "0";
			else 
				return (neg_b ? "" : "-") + num2;
		}
		else if (num2.equals("0"))
			return num1;
		
		// dealing with different sign
		Addition add = new Addition();
		if (!neg_a && neg_b) {
			return add.perform(num1, num2.substring(1));
		} else if (neg_a && !neg_b) {
			return "-" + add.perform(num1.substring(1), num2);
		}
		
		Comparison cmp = new Comparison();
		String sign = "";
		if (neg_a && neg_b) {
			num1 = num1.substring(1);
			num2 = num2.substring(1);
			sign = "-";
		}
		
		switch(cmp.perform(num1, num2)) {
		case "0":
			return "0";
		case "-1":
			if (sign == "")
				sign = "-";
			else 
				sign = "";
			String tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		// dealing with same sign
		int max = Math.max(num1.length(), num2.length());
		char result[] = new char[max];
		
		int a, b;
		for (int i = 0; i < max; i ++) {
			if (i < num1.length())
				a = (int)num1.charAt(num1.length() - i - 1) - '0';
			else 
				a = 0;
			if (i < num2.length())
				b = (int)num2.charAt(num2.length() - i - 1) - '0';
			else 
				b = 0;
			
			result[i] += (char)(a - b + '0');
			
			if (result[i] < '0') {
				result[i] += 10;
				if (i + 1 < max)
					result[i + 1]--;
			}
		}
		
		int i = max - 1;
		for (i = max - 1; i >= 0; i--) {
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
		return sign + new String(result); 
	}
}
