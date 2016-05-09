package bean;


public class ComposeMailBean {
	private String ToName;
	private String subject;
	private String body;
	private String from;
	
	
	public String getToName() {
		return ToName;
	}
	public void setToName(String toName) {
		ToName = toName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	private String Time;

}
