package Roles.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class RoleCRUDOperations {
    //Creating entity manager factory object
    EntityManagerFactory entityManagerFactory = createEntityManagerFactory("DbConnect");

    public void insertRole(String RoleName, int createdBy, Timestamp createdOn) {

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try {
            Role role = new Role();
            role.setRoleName(RoleName);
            role.setCreatedOn(createdOn);
            role.setCreatedBy(createdBy);

            //persist the user instance
            entityManager.persist(role);
            //  commit transaction;
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();
    }
    public void deleteRole(long roleId) {

        // Obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Begin entity transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            // Find the role by its ID
            Role role = entityManager.find(Role.class, roleId);

            if (role != null) {
                // Remove the role from the database
                entityManager.remove(role);

                // Commit transaction
                entityTransaction.commit();
            } else {
                System.out.println("Role not found with ID: " + roleId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }
    public Role getRoleById(long roleId) {

        // Obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Find the role by its ID
            Role role = entityManager.find(Role.class, roleId);
            return role;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return null;
    }
    public void updateRole(Role role) {

        // Obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            // Merge the role instance with the existing entity in the persistence context
            entityManager.merge(role);

            // Commit transaction
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback the transaction in case of an exception
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }

    public static void main (String[] args){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));
        RoleCRUDOperations RoleCRUDOperation = new RoleCRUDOperations();
        RoleCRUDOperation.insertRole("Customer care", 90, createdOn);
    }
}
