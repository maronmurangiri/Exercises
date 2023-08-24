package TicketService;

import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

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

    public Ticket(){
    }

    public void setTicketName(String ticketName) {

    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public void setAgentAssigned(int agentAssigned) {
        this.agentAssigned = agentAssigned;
    }

    public void setSubTasks(List<String> subTasks) {
        this.subTasks = subTasks;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public void setDeadlineDate(Timestamp deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}

