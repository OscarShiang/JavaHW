package hw5;

public class File extends Document {
	private String pathname;
	
	
	public String toString() {
		String result = new String();
		result += "Path: " + pathname + '\n';
		result += super.toString();
		return result;
	}
	public void setPathname(String ipt) {
		pathname = ipt;
	}
	public String getPathname() {
		return pathname;
	}
}
