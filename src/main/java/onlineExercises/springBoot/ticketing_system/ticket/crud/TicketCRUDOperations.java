package onlineExercises.springBoot.ticketing_system.ticket.crud;

import onlineExercises.springBoot.ticketing_system.authentication.entity.User;
import jakarta.persistence.*;
import onlineExercises.springBoot.ticketing_system.role.entity.Role;
import onlineExercises.springBoot.ticketing_system.ticket.entity.Ticket;
//import TicketService.Ticket;
import onlineExercises.springBoot.ticketing_system.ticket.entity.TicketStatus;


//import ticket.entity.Ticket;


import java.sql.Timestamp;
import java.util.List;

public class TicketCRUDOperations {
    //Creating entity manager factory object
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DbConnect");

    public boolean insertTicket(String ticketName, String description, TicketStatus statusID, String priorityLevel, Timestamp createdOn, User CreatedBy, Timestamp deadlineDate){
        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            Ticket ticket = new Ticket();
            TicketStatus ticketStatus = new TicketStatus();

            ticket.setTicketName(ticketName);
            ticket.setDescription(description);
            ticket.setTicketStatus(statusID);
            ticket.setPriorityLevel(priorityLevel);
            ticket.setDeadlineDate(deadlineDate);
            ticket.setCreatedBy(CreatedBy.getId());
            ticket.setCreatedOn(createdOn);

            //persist the ticket instance
            entityManager.persist(ticket);
           // entityManager.persist(ticketStatus);

            //commit transaction
            entityTransaction.commit();

            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            entityManager.close();
        }



    }

    public TicketStatus findTicketStatusByName(String statusName){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT s FROM TicketStatus s WHERE s.statusName = :statusName");
        query.setParameter("statusName",statusName);

        List<TicketStatus> ticketStatuses = query.getResultList();
        if (!ticketStatuses.isEmpty()) {
            for (TicketStatus ticketStatus : ticketStatuses){
                return ticketStatus;
            }
        }
        return  null;
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

    public List<Ticket> findTicketByTicketCreatorID(Integer ticketCreatorID){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.createdBy = :createdBy");
        query.setParameter("createdBy",ticketCreatorID);

        List<Ticket> tickets = query.getResultList();

        return tickets;
    }

    public List<Ticket> findTicketsCreated() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT t FROM Ticket t ");

        List<Ticket> tickets = query.getResultList();

        return tickets;
    }

    public List<Ticket> findTicketsCreatedByStatus(String ticketStatusName){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TicketStatus ticketStatus = findTicketStatusByName(ticketStatusName);
        if (ticketStatusName.equalsIgnoreCase("open")) {

            Query query = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.ticketStatus= :ticketStatus");
            query.setParameter("ticketStatus",ticketStatus);
            List<Ticket> tickets = query.getResultList();

            return tickets;
        } else if (ticketStatusName.equalsIgnoreCase("resolved")) {
             ticketStatus = findTicketStatusByName(ticketStatusName);
            Query query = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.ticketStatus = :ticketStatus");
            query.setParameter("ticketStatus",ticketStatus);
            List<Ticket> tickets = query.getResultList();

            return tickets;
        }
        return null;
    }

    public List<Ticket> findTicketByAgentAssigned(User agentAssignedId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.agentAssigned = :agentAssigned");
        query.setParameter("agentAssigned",agentAssignedId);

        List<Ticket> tickets = query.getResultList();

        return tickets;
    }
    public List<Ticket> findTicketByAgentAssignedAndResolvedStatus(User agentAssigned,TicketStatus ticketStatus){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.agentAssigned = :agentAssigned AND t.ticketStatus = :ticketStatus");
        query.setParameter("agentAssigned",agentAssigned);
        query.setParameter("ticketStatus",ticketStatus);

        List<Ticket> tickets = query.getResultList();

        return tickets;
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
    public void updateTicketAgentAssigned(Ticket ticketToUpdate, User user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setAgentAssigned(user);
        //entityManager.contains(userToDelete) ? userToDelete : entityManager.merge(userToDelete)
        entityManager.persist(entityManager.contains(ticketToUpdate)?ticketToUpdate:entityManager.merge(ticketToUpdate));

        entityManager.getTransaction().commit();
        //entityManager.merge(ticketToUpdate);

        entityManager.close();
    }

    public void updateResolvedTicketsStatus(Ticket ticketToUpdate, TicketStatus ticketStatus){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ticketToUpdate.setTicketStatus(ticketStatus);
        entityManager.persist(entityManager.contains(ticketToUpdate)?ticketToUpdate:entityManager.merge(ticketToUpdate));

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

//        entityManager.getTransaction().begin();
//        ticketToUpdate.setDeadlineDate(deadlineDate);
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
///**new code
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{

            ticketToUpdate.setDeadlineDate(deadlineDate);

            //persist the ticket instance
            entityManager.persist(ticketToUpdate);

            //commit transaction
            entityTransaction.commit();
        } catch (Exception e){
            e.printStackTrace();
        }

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
            System.err.println("Ticket not found");
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

