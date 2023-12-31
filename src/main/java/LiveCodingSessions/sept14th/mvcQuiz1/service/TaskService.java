package LiveCodingSessions.sept14th.mvcQuiz1.service;

import LiveCodingSessions.sept14th.mvcQuiz1.model.Task;

import java.util.List;

public interface TaskService {
    Task createItem(Task task);


    Task updateItem(Integer id,Task updatedtask);

    Boolean deleteItem(Integer id);

    Task getTask(Integer id);
    
    List<Task> getAllTasks();

}
