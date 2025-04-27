package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private Map<String, Task> tasks;
	
	//tasks hash map
	public TaskService() {
		tasks = new HashMap<>();
	}
	
	//adds task and tests for unique id
	public void addTask(Task task) {
		if (tasks.get(task.getId()) != null) {
			throw new IllegalArgumentException("Non-unique ID");
		}
		tasks.put(task.getId(), task);
	}
	
	//deletes task
	public void deleteTask(String taskId) {
		tasks.remove(taskId);
	}
	
	//updates task based on Id
	public void updateTask(String taskId, String name, String description) {
		Task task = tasks.get(taskId);
		
		if (task != null) {
			if (name != null) {
				task.setName(name);
			}
			if (description != null) {
				task.setDescription(description);
			}
		}
	}
	
	//getter for testing purposes
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
}
