package positions.entity;

import department.entity.Department;
import jakarta.persistence.*;
import java.sql.Timestamp;

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
    private Timestamp createdOn;

    @Column(name = "updated_by")
    private Integer UpdatedBy;

    @Column(name = "updated_on")
    private Timestamp updatedOn;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "department_id")
    private Department department;

    public Position() {

    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                ", UpdatedBy=" + UpdatedBy +
                ", updatedOn=" + updatedOn +
                ", departmentId=" + department +
                '}';
    }

    public Position(Integer positionId, String positionName, int createdBy, Timestamp createdOn, int updatedBy, Timestamp updatedOn, Department department) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        UpdatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.department = department;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
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

    public int getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        UpdatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
