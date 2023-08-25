package authentication.entity;
import positions.entity.Position;
import role.entity.Role;

import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",insertable = false,updatable = false)
    private int id;

    @Column(name="first_name")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name="password")
    private String password;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id",insertable = true,updatable = true)
    private Position position;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private Role role;


    @Column(name="created_by")
    private int createdBy;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name="updated_by")
    private Integer updatedBy;

    @Column(name="updated_on")
    private Timestamp updatedOn;

    @Column(name="email")
    private String email;

    public User(int id, String firstname, String surname, String email, String password, Position position, Role role, int createdBy, Timestamp createdOn, int updatedBy, Timestamp updatedOn) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.position = position;
        this.role = role;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.email = email;
    }

    public User() {

    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", position=" + position +
                ", role=" + role +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", updatedBy=" + updatedBy +
                ", updatedOn=" + updatedOn +
                ", email='" + email + '\'' +
                '}';
    }
}
