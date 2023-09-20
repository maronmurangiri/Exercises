package LiveCodingSessions.sept14th.mvcQuiz1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Integer taskId;
    String title;
    String completionStatus;

    public Task() {

    }
    public Task(Integer taskId, String title, String completionStatus) {
        this.taskId = taskId;
        this.title = title;
        this.completionStatus = completionStatus;
    }

}
