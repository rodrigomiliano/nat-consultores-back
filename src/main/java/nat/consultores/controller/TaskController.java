package nat.consultores.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

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

    @Operation(summary = "Obtener todas las tareas", description = "Devuelve una lista de todas las tareas con filtros opcionales")
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
 
    @Operation(summary = "Obtener una tarea por ID", description = "Devuelve los detalles de una tarea específica")
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @Operation(summary = "Crear una nueva tarea", description = "Crea una nueva tarea y la devuelve")
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    
    @Operation(summary = "Editar una tarea", description = "Modificar atributos de una tarea seleccionada")
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @Operation(summary = "Eliminar una tarea", description = "Elimina una tarea específica")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }
}
