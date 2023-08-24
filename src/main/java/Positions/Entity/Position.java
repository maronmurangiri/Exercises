package Positions.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import Departments.Department;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "position_name")
    private String positionName;

    @Column(name="created_by")
    private int createdBy;

    @Column(name = "created_on")
    private Timestamp created_on;

    @Column(name = "updated_on")
    private Timestamp updated_on;

    @Column(name = "updated_by")
    private int updated_by;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id")
    private Department department;

    public Integer getPositionId() {
        return positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public Timestamp getCreatedOn() {
        return created_on;
    }

    public Timestamp getUpdatedOn() {
        return updated_on;
    }

    public int getUpdatedBy() {
        return updated_by;
    }

    public Department getDepartment() {
        return department;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedOn(Timestamp created_on) {
        this.created_on = created_on;
    }

    public void setUpdatedOn(Timestamp updated_on) {
        this.updated_on = updated_on;
    }

    public void setUpdated_by(int updated_by) {
        this.updated_by = updated_by;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + created_on +
                ", UpdatedBy=" + updated_by +
                ", updatedOn=" + updated_on +
                ", departmentId=" + department +
                '}';
    }

    public Position() {
        this.positionId = positionId;
        this.positionName = positionName;
        this.createdBy = createdBy;
        this.created_on = created_on;
        updated_by = updated_by;
        this.updated_on = updated_on;
        this.department = department;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    public Timestamp getUpdated_on() {
        return updated_on;
    }

    public int getUpdated_by() {
        return updated_by;
    }

    public void setCreated_on(Timestamp created_on) {
        this.created_on = created_on;
    }

    public void setUpdated_on(Timestamp updated_on) {
        this.updated_on = updated_on;
    }
}
