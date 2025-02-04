package nat.consultores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nat.consultores.entity.Task;
import nat.consultores.service.TaskService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tasks")
public class TaskController {

	private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
 
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }


    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    
    
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }
}
