package TicketService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Timestamp;
import java.util.List;

@SuppressWarnings("CallToPrintStackTrace")
public class TicketCRUDOperationso {
    //Creating entity manager factory object
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("agent");

    public void insertTicket(String ticketName, String description, String priorityLevel, Timestamp deadlineDate){
        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            Ticket ticket = new Ticket();
            ticket.setTicketName(ticketName);
            ticket.setDescription(description);
            ticket.setPriorityLevel(priorityLevel);
            ticket.setDeadlineDate(deadlineDate);

            //persist the ticket instance
            entityManager.persist(ticket);

            //commit transaction
            entityTransaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }

        entityManager.close();
    }

    public Ticket findTicketById(int id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Ticket ticketFound = entityManager.find(Ticket.class, id);

        if (ticketFound != null) {
            return ticketFound;
        }
        return  null;
    }

    public void updateTicketName(Ticket ticketToUpdate,String name){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setTicketName(name);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void updateTicketDescription(Ticket ticketToUpdate,String description){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setDescription(description);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void updateTicketTags(Ticket ticketToUpdate,String tags){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setTags(tags);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void updateTicketPriorityLevel(Ticket ticketToUpdate,String priorityLevel){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setPriorityLevel(priorityLevel);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void updateTicketAgentAssigned(Ticket ticketToUpdate,int userID){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setAgentAssigned(userID);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void updateTicketSubTasks(Ticket ticketToUpdate, List<String> subTasks){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setSubTasks(subTasks);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void updateTicketDeadlineDate(int ticketID, Timestamp deadlineDate){
        Ticket ticketToUpdate = findTicketById(ticketID);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setDeadlineDate(deadlineDate);

        //persist the ticket instance
//        entityManager.persist(ticketToUpdate);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteTicket(int ticketID){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Ticket ticketToDelete = findTicketById(ticketID);

        if (ticketToDelete != null) {
            entityManager.remove(entityManager.contains(ticketToDelete) ? ticketToDelete : entityManager.merge(ticketToDelete));
            entityManager.getTransaction().commit();
            System.err.println("Deleted successfully");
        } else {
            System.err.println("User not found");
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
