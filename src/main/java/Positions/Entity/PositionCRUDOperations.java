package Positions.Entity;

import Departments.Department;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class PositionCRUDOperations {
    //Creating entity manager factory object
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DbConnect");

    public void insertPosition(String positionName, int createdBy, Timestamp createdOn, Department department) {

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try {
            Position position = new Position();
            position.setPositionName(positionName);
            position.setCreatedOn(createdOn);
            position.setCreatedBy(createdBy);
            position.setDepartment(department);

            //persist the user instance
            entityManager.persist(position);
            //  commit transaction;
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();

    }
    public Position findPosition(String positionName){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Position p WHERE p.positionName = :positionName");
        query.setParameter("positionName",positionName);

        List<Position> positions = query.getResultList();


        if (!positions.isEmpty()) {

            for (Position position: positions){
                return position;
            }


        }
        return  null;
    }
    public static void main (String[] args){
        /**LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));**/
        PositionCRUDOperations PositionCRUDOperation = new PositionCRUDOperations();
        System.out.println(PositionCRUDOperation.findPosition("Support"));
    }
}
