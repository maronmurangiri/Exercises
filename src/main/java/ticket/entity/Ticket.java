package ticket.entity;

import authentication.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import role.entity.Role;

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
    @ManyToOne(targetEntity = TicketStatus.class)
    @JoinColumn(name = "status_id")
    private TicketStatus ticketStatus;

    /*@Column(name= "status_id")
    private int statusID;*/

    @Column(name = "tags")
    private String tags;

    @Column(name = "priorityLevel")
    private String priorityLevel;

//    @ManyToOne(targetEntity = User.class)
//    @JoinColumn(name = "user_id")

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",updatable = false,insertable = false)
    private User user;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",updatable = true,insertable = true)
    private User agentAssigned;

    /* @Column(name = "user_id")
    private int agentAssigned;*/

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

    public Ticket(String ticketName, String description, TicketStatus ticketStatus, String priorityLevel, Timestamp deadlineDate){
        this.ticketStatus = ticketStatus;
        this.ticketName = ticketName;
        this.description = description;
        this.priorityLevel = priorityLevel;
        this.deadlineDate = deadlineDate;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
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

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAgentAssigned() {
        return agentAssigned;
    }

    public void setAgentAssigned(User agentAssigned) {
        this.agentAssigned = agentAssigned;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", ticketName='" + ticketName + '\'' +
                ", description='" + description + '\'' +
                ", statusID='" + ticketStatus.getStatusID() + '\'' +
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
