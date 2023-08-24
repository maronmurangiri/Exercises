package Agent;

import user.User;

import java.util.HashMap;
import java.util.Map;

public class Agent extends User {

    private int agentId;
    private int numberOfTickets;
    private int resolvedTicketCount;
    private int assignedTicketId;

    private static Map<Integer, Agent> agentDatabase = new HashMap<>();

    public Agent(int id, int createdBy) {
        super();
        this.agentId = agentId;
        this.numberOfTickets = numberOfTickets;
        this.resolvedTicketCount = 0;
        this.assignedTicketId = 0;
    }
    public static void createAgent(int agentId, int numberOfTickets) {
        Agent newAgent = new Agent(agentId, numberOfTickets);
    }
    public static Agent readAgent(int agentId) {
        return agentDatabase.get(agentId);
    }

    public void updateAgent(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void deleteAgent() {
        agentDatabase.remove(agentId);
    }



    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getResolvedTicketCount() {
        return resolvedTicketCount;
    }

    public void incrementResolvedTicketCount() {
        resolvedTicketCount += 1;
    }

    public int getAssignedTicketId() {
        return assignedTicketId;
    }

    public void assignTicket(int ticketId) {
        assignedTicketId = ticketId;
    }

    public void reassignTicket() {
        assignedTicketId = 0;
    }

    @Override
    public String toString() {
        String assignedTicketInfo = (assignedTicketId != 0) ? String.valueOf(assignedTicketId) : "Not assigned to any ticket";
        return super.toString() +
                "\nNumber of Tickets: " + numberOfTickets +
                "\nResolved Ticket Count: " + resolvedTicketCount +
                "\nAssigned Ticket ID: " + assignedTicketInfo;
    }
}
