package LiveCodingSessions.sept14th.mvcQuiz1.service;

import LiveCodingSessions.sept14th.mvcQuiz1.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    List<Task> taskList = new ArrayList<>();
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

      for (Task tasks:taskList) {
          if (tasks.getTaskId() == task.getTaskId()) {
              throw new IllegalArgumentException("The item with such id exist");
          }
      }
        taskList.add(task);
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

        for (Task task : taskList){
            if (task.getTaskId()== taskId) {
                int index = taskList.indexOf(task);
                Task task1 = taskList.set(index, updatedTask);
                return updatedTask;
            }
        }

       return null;
    }

    @Override
    public Boolean deleteItem(Integer taskId) {
        if (taskId == null){
            throw  new IllegalArgumentException("Item id cannot be null");
        }
            for (Task task : taskList){
                if (task.getTaskId()==taskId){
                    int index = taskList.indexOf(task);
                    taskList.remove(index);
                    return true;
                }
            }
            return false;
        }


    @Override
    public Task getTask(Integer taskId) {
        if (taskId == null){
            throw  new IllegalArgumentException("Item id can not be null");
        }

      for (Task task : taskList){
          if (task.getTaskId()==taskId){
              int index = taskList.indexOf(task);
              Task tasks = taskList.get(index);
              return tasks;
          }
      }
      return  null;
    }

    @Override
    public List<Task> getAllTasks(){
        return taskList;
    }
}
