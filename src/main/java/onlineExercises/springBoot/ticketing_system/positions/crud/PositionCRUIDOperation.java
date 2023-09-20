package onlineExercises.springBoot.ticketing_system.positions.crud;

import jakarta.persistence.*;
import onlineExercises.springBoot.ticketing_system.department.entity.Department;
import onlineExercises.springBoot.ticketing_system.positions.entity.Position;

import java.sql.Timestamp;
import java.util.List;

public class PositionCRUIDOperation {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DbConnect");

    public void insertPosition(String positionName, int createdBy, Timestamp createdOn, Department department){

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            Position position = new Position();
            position.setPositionName(positionName);
            position.setCreatedBy(createdBy);
            position.setCreatedOn(createdOn);
            position.setDepartment(department);

            //persist the user instance
            entityManager.persist(position);

            //commit transaction
            entityTransaction.commit();
        }catch (Exception e){
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
    public static void main(String[] args){
        PositionCRUIDOperation positionCRUIDOperation = new PositionCRUIDOperation();
        System.out.println(positionCRUIDOperation.findPosition("Support"));

    }
}
