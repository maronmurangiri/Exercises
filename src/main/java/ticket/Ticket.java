package ticket;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@Data
public class Ticket {
    private int ticketID;
    private String ticketName;
    private String description;
    private String tags;
    private String priorityLevel;
    private int agentAssigned; //userID
    private List<String> subTasks;
    private String attachments;
    private Timestamp deadlineDate;

    public Ticket(int ticketID, String ticketName, String description, String priorityLevel, Timestamp deadlineDate){
        this.ticketID = ticketID;
        this.ticketName = ticketName;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.deadlineDate = deadlineDate;
    }

}

