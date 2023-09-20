package onlineExercises.springBoot.ticketing_system.department.crud;

import jakarta.persistence.*;
import onlineExercises.springBoot.ticketing_system.authentication.entity.User;
import onlineExercises.springBoot.ticketing_system.department.entity.Department;

import java.sql.Timestamp;
import java.util.List;

public class DepartmentCRUDOperation {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DbConnect");

    public void insertDepartment(String departmentName, String description, User director, int createdBy, Timestamp createdOn){

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            Department department = new Department();
            department.setDepartmentName(departmentName);
            department.setDepartmentDescription(description);
            department.setCreatedBy(createdBy);
            department.setCreatedOn(createdOn);
            department.setDirector(director);

            //persist the user instance
            entityManager.persist(department);

            //commit transaction
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        entityManager.close();

    }

    public Department findDepartment(String departmentName){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT d FROM Department d WHERE d.departmentName = :departmentName");
        query.setParameter("departmentName",departmentName);

        List<Department> departments = query.getResultList();


        if (!departments.isEmpty()) {

            for (Department department: departments){
                return department;
            }


        }
        return  null;
    }
    public static void main(String[] args){
        onlineExercises.springBoot.ticketing_system.positions.crud.PositionCRUIDOperation positionCRUIDOperation = new onlineExercises.springBoot.ticketing_system.positions.crud.PositionCRUIDOperation();
        System.out.println(positionCRUIDOperation.findPosition("Support"));

    }
}
