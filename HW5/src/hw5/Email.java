package hw5;

public class Email extends Document {
	private String sender;
	private String recipient;
	private String title;
	
	public String toString() {
		String result = new String();
		result += "From: " + sender + '\n';
		result += "To: " + recipient + '\n';
		result += "Title: " + title + '\n';
		result += super.toString();
		return result;
	}
	
	// set method
	public void setSender(String ipt) {
		sender = ipt;
	}
	public void setRecipient(String ipt) {
		recipient = ipt;
	}
	public void setTitle(String ipt) {
		title = ipt;
	}
	
	// get method
	public String getSender() {
		return sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public String getTitle() {
		return title;
	}
}
