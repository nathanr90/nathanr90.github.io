package task;

public class Task {
	
	private final String taskId;
	private String name;
	private String description;
	
	//constructor
	public Task(String taskId, String name, String description) {
		
		//length/null tests
		if(taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	//id get
	public String getId() {
		return taskId;
	}
	
	//name get and set
	public void setName(String name) {
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//description get and set
	public void setDescription(String description) {
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
