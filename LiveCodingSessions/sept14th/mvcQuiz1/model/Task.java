package LiveCodingSessions.sept14th.mvcQuiz1.model;

public class Task {
    int taskId;
    String title;
    String completionStatus;

    public Task(int taskId, String title, String completionStatus) {
        this.taskId = taskId;
        this.title = title;
        this.completionStatus = completionStatus;
    }

    public Task() {
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }
}
