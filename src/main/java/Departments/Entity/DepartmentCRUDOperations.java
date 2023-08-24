package Departments.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class DepartmentCRUDOperations {
    //Creating entity manager factory object
    EntityManagerFactory entityManagerFactory = createEntityManagerFactory("DbConnect");

    public void insertDepartment(String departmentName, String departmentDescription, Departments.User user, int createdBy, Timestamp createdOn) {

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try {
            Departments.Department department = new Departments.Department();
            department.setName(departmentName);
            department.setDescription(departmentDescription);
            department.setDirector(user);
            department.setCreatedOn(createdOn);
            department.setCreatedBy((long) createdBy);

            //persist the user instance
            entityManager.persist(user);
            //  commit transaction;
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();

        //
    }
    public void deleteDepartment(long departmentId) {

        // Obtain entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            // Find the department to be deleted by its ID
            Departments.Department department = entityManager.find(Departments.Department.class, departmentId);

            if (department != null) {
                // Remove the department from the entity manager
                entityManager.remove(department);
                // Commit transaction
                entityTransaction.commit();
            } else {
                System.out.println("Department not found with ID: " + departmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    public Departments.Department getDepartmentById(long departmentId) {

        // Obtain entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Find the department by its ID
            Departments.Department department = entityManager.find(Departments.Department.class, departmentId);

            if (department != null) {
                return department;
            } else {
                System.out.println("Department not found with ID: " + departmentId);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
    public void updateDepartment(long departmentId, String newDepartmentName, String newDepartmentDescription, Departments.User newDirector) {

        // Obtain entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Begin entity transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            // Find the department by its ID
            Departments.Department department = entityManager.find(Departments.Department.class, departmentId);

            if (department != null) {
                // Update department attributes
                department.setName(newDepartmentName);
                department.setDescription(newDepartmentDescription);
                department.setDirector(newDirector);

                // Merge the updated department into the database
                entityManager.merge(department);

                // Commit transaction
                entityTransaction.commit();
            } else {
                System.out.println("Department not found with ID: " + departmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
    }
    public Departments.User findUserByEmail(String email){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email");
        query.setParameter("email",email);

        List<Departments.User> users = query.getResultList();
        if (!users.isEmpty()) {
            for (Departments.User user : users) {
                return user;
            }
        }
        return  null;
    }
    public static void main (String[] args){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));
        DepartmentCRUDOperations DepartmentCRUDOperation = new DepartmentCRUDOperations();
        DepartmentCRUDOperation.insertDepartment("IT", "Technology", DepartmentCRUDOperation.findUserByEmail("nziokakelvin02@gmail.com"), 2, createdOn);
    }
}
