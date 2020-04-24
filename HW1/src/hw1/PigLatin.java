package hw1;

public class PigLatin {

	public static void main(String[] args) {
		if (args.length < 0)
			return;

		final char []vowels = {'a', 'e', 'i', 'o', 'u'};
		
		for (String ipt : args) {
			boolean isVowel = false;
			for (char c : vowels) {
				if (ipt.charAt(0) == c) {
					isVowel = true;
					break;
				}
			}
			
			StringBuilder out = new StringBuilder();
			if (isVowel)
				out.append(ipt);
			else 
				out.append(ipt.substring(1) + ipt.charAt(0));
			out.append("ay");
			out.setCharAt(0, Character.toUpperCase(out.charAt(0)));
			System.out.printf("%s ", out);
		}
	}
}