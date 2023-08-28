package role.crud;

import department.entity.Department;
import jakarta.persistence.*;
import positions.entity.Position;
import role.entity.Role;

import java.sql.Timestamp;
import java.util.List;

public class RoleCRUIDOperation {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DbConnect");

    public boolean insertRole(String roleName, int createdBy, Timestamp createdOn){

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            Role role = new Role();
            role.setRoleName(roleName);
            role.setCreatedBy(createdBy);
            role.setCreatedOn(createdOn);

            //persist the user instance
            entityManager.persist(role);

            //commit transaction
            entityTransaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            entityManager.close();
        }



    }
    public Role findRoleBY(String roleName){
        //roleName = "admin";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName");

        query.setParameter("roleName",roleName);

        List<Role> rolee = query.getResultList();
        if(!rolee.isEmpty()) {
            for (Role role : rolee) {

                return role;
            }
        }
            return null;

    }

}
