package ticket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int ticketID;

    @Column(name = "ticket_name")
    private String ticketName;

    @Column(name = "description")
    private String description;

    @Column(name= "status_id")
    private int statusID;

    @Column(name = "tags")
    private String tags;

    @Column(name = "priorityLevel")
    private String priorityLevel;

//    @ManyToOne(targetEntity = User.class)
//    @JoinColumn(name = "user_id")
    @Column(name = "user_id")
    private int agentAssigned;

    @Column(name = "subTasks")
    private List<String> subTasks;

    @Column(name = "attachments")
    private String attachments;

    @Column(name = "deadline_date")
    private Timestamp deadlineDate;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "created_by")
    private int createdBy;

    @Column(name="updated_by")
    private int updatedBy;

    @Column(name="updated_on")
    private Timestamp updatedOn;

    public Ticket(){

    }

    public Ticket(String ticketName, String description, int statusID, String priorityLevel, Timestamp deadlineDate){
        this.statusID = statusID;
        this.ticketName = ticketName;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.deadlineDate = deadlineDate;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", ticketName='" + ticketName + '\'' +
                ", description='" + description + '\'' +
                ", statusID='" + statusID + '\'' +
                ", tags='" + tags + '\'' +
                ", priorityLevel='" + priorityLevel + '\'' +
                ", agentAssigned=" + agentAssigned +
                ", subTasks=" + subTasks +
                ", attachments='" + attachments + '\'' +
                ", deadlineDate=" + deadlineDate +
                ", createdOn=" + createdOn +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
