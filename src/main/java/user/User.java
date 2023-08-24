package user;

import lombok.Getter;

import java.security.Timestamp;
@Getter
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int positionId;
    private int roleId;
    private Timestamp createdAt;
    private int resolvedTicketCount;
    private int assignedTicketId;

    public User() {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.positionId = positionId;
        this.roleId = roleId;
        this.createdAt = createdAt;
    }

    // Getter and setter methods for properties...

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setResolvedTicketCount(int resolvedTicketCount) {
        this.resolvedTicketCount = resolvedTicketCount;
    }

    @Override
    public String toString() {
        return "User ID: " + id +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nPosition ID: " + positionId +
                "\nRole ID: " + roleId +
                "\nCreated At: " + createdAt;
    }


    public void resolvedTicketCount(int resolvedTicketCount) {

    }

    public void setAssignedTicketId(int assignedTicketId) {
        this.assignedTicketId = assignedTicketId;
    }

}
