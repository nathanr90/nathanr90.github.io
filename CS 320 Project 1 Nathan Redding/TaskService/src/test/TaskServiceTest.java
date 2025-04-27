package test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

class TaskServiceTest {

	//test adding a task to task hash map
	@Test
	public void testAddTask() {
		TaskService taskService = new TaskService();
		Task task = new Task("1", "Task name", "Test task");
		taskService.addTask(task);
		assertEquals(task, taskService.getTask("1"));
	}
	
	//tests ID is unique
	@Test
	public void testUniqueId() {
		TaskService taskService = new TaskService();
		Task task = new Task("1", "Task name", "Test task");
		taskService.addTask(task);
		Task task2 = new Task("1", "Name Task", "Task test");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(task2);
		});
	}
	
	//test delete
	@Test
	public void testDeleteTask() {
		TaskService taskService = new TaskService();
		Task task = new Task("1", "Task name", "Test task");
		taskService.addTask(task);
		taskService.deleteTask("1");
		assertNull(taskService.getTask("1"));
	}
	
	//test update
	@Test
	public void testUpdateTask() {
		TaskService taskService = new TaskService();
		Task task = new Task("1", "Task name", "Test task");
		taskService.addTask(task);
		taskService.updateTask("1", "Name of task", "Description of task");
		Task updatedTask = taskService.getTask("1");
		assertEquals("Name of task", updatedTask.getName());
		assertEquals("Description of task", updatedTask.getDescription());
	}

}
