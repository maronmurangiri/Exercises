package ticket;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Ticket {
    private int ticketID;
    private String description;
    private String tags;
    private String priorityLevel;
    private int agentAssigned; //userID
    private List<String> subTasks;
    private String attachments;
    private Timestamp deadlineDate;

    public Ticket(){}

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID){
        this.ticketID = ticketID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getAgentAssigned() {
        return agentAssigned;
    }

    public void setAgentAssigned(int agentAssigned) {
        this.agentAssigned = agentAssigned;
    }

    public List<String> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<String> subTasks) {
        this.subTasks = subTasks;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public Timestamp getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Timestamp deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}

