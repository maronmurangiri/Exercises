package LiveCodingSessions.sept14th.mvcQuiz1.service;


import LiveCodingSessions.sept14th.mvcQuiz1.model.Task;
import LiveCodingSessions.sept14th.mvcQuiz1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }



    @Override
    public Task createItem(Task task) {
       if (task.getTaskId()<=0){
           throw new IllegalArgumentException("Invalid task Id. ");
       }
       if (task.getTitle()==null|| task.getTitle().isBlank()){
           throw new IllegalArgumentException("Task title should neither be null or blank");
       }
       if (task.getCompletionStatus()==null || task.getCompletionStatus().isBlank()){
           throw new IllegalArgumentException("Task completion status can neither be null nor blank");
       }

      if (taskRepository.existsById(task.getTaskId())){
              throw new IllegalArgumentException("The item with such id exist");
          }

        taskRepository.save(task);
        return  task;
    }

    @Override
    public Task updateItem(Integer taskId, Task updatedTask) {
        if (updatedTask.getTaskId()<=0){
            throw new IllegalArgumentException("Invalid task Id. ");
        }
        if (updatedTask.getTitle()==null|| updatedTask.getTitle().isBlank()){
            throw new IllegalArgumentException("Task title should neither be null or blank");
        }
        if (updatedTask.getCompletionStatus()==null || updatedTask.getCompletionStatus().isBlank()){
            throw new IllegalArgumentException("Task completion status can neither be null nor blank");
        }
        if (updatedTask== null){
            throw new IllegalArgumentException("task cannot be null");
        }

        if (taskRepository.existsById(taskId)){
                Task task = taskRepository.save(updatedTask);
                return task;
            }

       return null;
    }

    @Override
    public Boolean deleteItem(Integer taskId) {
        if (taskId == null){
            throw  new IllegalArgumentException("Item id cannot be null");
        }
            if (taskRepository.existsById(taskId)){
                    taskRepository.deleteById(taskId);
                    return true;
                }

            return false;
        }


    @Override
    public Task getTask(Integer taskId) {
        if (taskId == null){
            throw  new IllegalArgumentException("Item id can not be null");
        }
      //  if (taskRepository.existsById(taskId)) {
            System.out.println(taskId);
             Task tasks = taskRepository.getById(taskId);
              return tasks;
         //}
        //return null;

    }

    @Override
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}
