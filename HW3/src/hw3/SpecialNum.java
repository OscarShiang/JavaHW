package hw3;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class SpecialNum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in = scan.next();
		scan.close();
		
		char type = in.charAt(0);
		int num = Integer.parseInt(in.substring(2));

		if (type == 'X') {
			while (num % 2 == 0)
				num /= 2;
			while (num % 3 == 0)
				num /= 3;
			while (num % 5 == 0)
				num /= 5;
			System.out.println(num == 1);
		} else if (type == 'Y') {
			long nums[] = new long[1000000];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 100; k++) {
						nums[k + 100 * j + 10000 * i] = (long)(Math.pow(2, i) * Math.pow(3, j) * Math.pow(5, k));
					}
				}
			}
			Arrays.sort(nums);
			System.out.println(nums[num - 1]);
		}
	}

}
