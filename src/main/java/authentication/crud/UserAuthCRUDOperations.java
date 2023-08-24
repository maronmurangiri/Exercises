package authentication;

import authentication.entity.User;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

import positions.entity.Position;
import role.RoleCRUIDOperation;
import role.entity.Role;

public class UserAuthCRUDOperations {

    //Creating entity manager factory object
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DbConnect");


    public void insertUser(String firstName, String surname,String email, String password, Position position, Role role, int createdBy, Timestamp createdOn){

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            User user = new User();
            user.setFirstname(firstName);
            user.setSurname(surname);
            user.setEmail(email);
            user.setPassword(password);
            user.setPosition(position);
            user.setRole(role);
            user.setCreatedBy(createdBy);
            user.setCreatedOn(createdOn);

            //persist the user instance
            entityManager.persist(user);

            //commit transaction
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        entityManager.close();

    }


    public User findUserByEmail(String email){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email");
        query.setParameter("email",email);

        List<User> users = query.getResultList();
        if (!users.isEmpty()) {
            for (User user : users){
                return user;
            }
        }
        return  null;
    }


    public User findUserById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User userFound = entityManager.find(User.class,id);

        if (userFound != null) {
            return userFound;
        }
        return  null;
    }


    public User findUSerByRoleID(Role roleId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.role = :roleId");
        query.setParameter("roleId",roleId);

        List<User> users = query.getResultList();
        for (User user : users){
            return user;
        }
        return null;
    }


    public void updateUser(User userToUpdate,String password){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        userToUpdate.setPassword(password);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public void deleteUser(User userToDelete){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        if (userToDelete != null) {
            entityManager.remove(entityManager.contains(userToDelete) ? userToDelete : entityManager.merge(userToDelete));
            entityManager.getTransaction().commit();
            System.err.println("Deleted successfully");
        } else {
            System.err.println("User not found");
        }

        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
