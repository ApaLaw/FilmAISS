package aiss.model;

public class Comment {
	
	private String id;
	private String Name;
	private String Message;
	
	public Comment() {
		
	}
	
	public Comment(String name, String message) {
		Name = name;
		Message = message;
	}


	public Comment(String id, String name, String message) {
		this.id = id;
		Name = name;
		Message = message;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Comment [id=" + id + ", Name=" + Name + ", Message=" + Message + "]";
	}
	
	

}
