package Roles.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

    @Entity
    @Table(name = "role")
    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "role_id")
        private int roleId;

        @Column(name = "role_name")
        private String roleName;

        @Column(name = "created_by")
        private int createdBy;

        @Column(name="created_on")
        private Timestamp createdOn;

        @Column(name="updated_by")
        private Integer updatedBy;

        @Column(name = "updated_on")
        private Timestamp updatedOn;

        public int getRoleId() {
            return roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public int getCreatedBy() {
            return createdBy;
        }

        public Timestamp getCreatedOn() {
            return createdOn;
        }

        public Integer getUpdatedBy() {
            return updatedBy;
        }

        public Timestamp getUpdatedOn() {
            return updatedOn;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public void setCreatedBy(int createdBy) {
            this.createdBy = createdBy;
        }

        public void setCreatedOn(Timestamp createdOn) {
            this.createdOn = createdOn;
        }

        public void setUpdatedBy(Integer updatedBy) {
            this.updatedBy = updatedBy;
        }

        public void setUpdatedOn(Timestamp updatedOn) {
            this.updatedOn = updatedOn;
        }

        @Override
        public String toString() {
            return "Role{" +
                    "roleId=" + roleId +
                    ", roleName='" + roleName + '\'' +
                    ", createdBy=" + createdBy +
                    ", createdOn=" + createdOn +
                    ", updatedBy=" + updatedBy +
                    ", updatedOn=" + updatedOn +
                    '}';
        }
}
