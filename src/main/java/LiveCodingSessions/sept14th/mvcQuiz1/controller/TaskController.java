package LiveCodingSessions.sept14th.mvcQuiz1.controller;

import LiveCodingSessions.sept14th.mvcQuiz1.model.Task;
import LiveCodingSessions.sept14th.mvcQuiz1.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {

    TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody Task task){
       try {
           Task tasks = taskService.createItem(task);
           return ResponseEntity.ok("Task "+tasks.getTitle()+" successfully created" );
       }catch (IllegalArgumentException e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") Integer taskId){
       try {
           Task task = taskService.getTask(taskId);
           return ResponseEntity.ok(task);
       }catch (IllegalArgumentException e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @GetMapping("/retrieveall")
    public ResponseEntity<?> getAllTask(){
        List<Task> task = taskService.getAllTasks();
        return ResponseEntity.ok(task);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Integer id){
        try {
             taskService.deleteItem(id);
             return  ResponseEntity.ok("successfully deleted");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("not deleted");
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") Integer taskId, @RequestBody Task task){
        try {
           Task task1 = taskService.updateItem(taskId,task);
            return ResponseEntity.ok(task1);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
