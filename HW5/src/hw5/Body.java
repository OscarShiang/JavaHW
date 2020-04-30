package hw5;

import java.util.Scanner;

public class Body {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String mode = scan.nextLine();
		String type = scan.nextLine();

		Document object = null;

		// dispatch of type
		switch(type) {
		case "Document":
			object = new Document();
			object.setText(scan.nextLine());
			break;
		case "Email":
			object = new Email();
			((Email)object).setSender(scan.nextLine());
			((Email)object).setRecipient(scan.nextLine());
			((Email)object).setTitle(scan.nextLine());
			object.setText(scan.nextLine());
			break;
		case "File":
			object = new File();
			((File)object).setPathname(scan.nextLine());
			object.setText(scan.nextLine());
			break;
		}
		
		// dispatch of mode
		switch(mode) {
		case "A":
			System.out.println(object.toString());
			break;
		case "B":
			String pattern = scan.next();
			System.out.println(object.toString().contains(pattern));
			break;
		case "C":
			String var = scan.nextLine();
			if (object instanceof Email) {
				String str;
				switch(var) {
				case "sender":
					str = scan.nextLine();
					((Email)object).setSender(str);
					break;
				case "recipient":
					str = scan.nextLine();
					((Email)object).setSender(str);
					break;
				case "title":
					str = scan.nextLine();
					((Email)object).setTitle(str);
					break;
				case "text":
					str = scan.nextLine();
					object.setText(str);
					break;
				}
				
			} else if (object instanceof File) {
				String str;
				switch(var) {
				case "pathname":
					str = scan.nextLine();
					((File)object).setPathname(str);
					break;
				case "text":
					str = scan.nextLine();
					object.setText(str);
					break;
				}
			} else if (object instanceof Document) {
				switch (var) {
				case "text":
					String str = scan.nextLine();
					object.setText(str);
					break;
				}
			}
			System.out.println(object.toString());
			break;
		}
		
		scan.close();
	}

}
