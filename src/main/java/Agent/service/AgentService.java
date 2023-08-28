package Agent.service;


import authentication.crud.UserAuthCRUDOperations;
import authentication.entity.User;
import ticket.crud.TicketCRUDOperations;
import ticket.entity.Ticket;
import ticket.entity.TicketStatus;

import java.util.List;
import java.util.Scanner;

public class AgentService {
UserAuthCRUDOperations userAuthCRUDOperations = new UserAuthCRUDOperations();
    public void readTicketsAssignedToAgent(Integer agentAssignedId){
        TicketCRUDOperations ticketCRUDOperations = new TicketCRUDOperations();
        User agentAssigned = userAuthCRUDOperations.findUserById(agentAssignedId);

        ticketCRUDOperations.findTicketByAgentAssigned(agentAssigned);
        System.out.println("TICKET ASSIGNED TO AGENT");
        List<Ticket> tickets = ticketCRUDOperations.findTicketByAgentAssigned(agentAssigned);
        System.out.print("tickets ID\t tickets name\ttickets status\ttickets priority");
        System.out.println();
        int ticketCount=0;
        for(Ticket ticket:tickets){
            ticketCount++;
            System.out.print(ticket.getTicketID()+"\t"+ticket.getTicketName()+"\t"+ticket.getTicketStatus()+"\t"+ticket.getPriorityLevel());
            System.out.println();
            System.out.println("total tickets assigned to you "+ ticketCount);
        }
    }

    public void updateResolvedTickets(){
        //resolved Ticket status
        TicketCRUDOperations ticketCRUDOperations = new TicketCRUDOperations();
        TicketStatus ticketStatus = ticketCRUDOperations.findTicketStatusByName("resolved");
        System.out.println("fill in the ID of the resolved ticket");
        Scanner scanner = new Scanner(System.in);
        String resolvedTicketIdInput = scanner.nextLine();
        scanner.nextLine();

        //resolved ticket
        Ticket resolvedTicket = ticketCRUDOperations.findTicketById(Integer.parseInt(resolvedTicketIdInput));

        ticketCRUDOperations.updateResolvedTicketsStatus(resolvedTicket,ticketStatus);
        System.out.println("Ticked successfully updated to resolved");
    }

    public void readResolvedTicketByAgent(Integer agentAssignedId){
        User agentAssigned = userAuthCRUDOperations.findUserById(agentAssignedId);
        //resolved ticket status
        TicketCRUDOperations ticketCRUDOperations = new TicketCRUDOperations();
        TicketStatus ticketStatus = ticketCRUDOperations.findTicketStatusByName("resolved");

        System.out.println("TICKET RESOLVED BY AGENT");
        List<Ticket> tickets = ticketCRUDOperations.findTicketByAgentAssignedAndResolvedStatus(agentAssigned,ticketStatus);;
        System.out.print("tickets ID\t tickets name\ttickets status\ttickets priority");
        System.out.println();
        int ticketCount=0;
        for(Ticket ticket:tickets){
            ticketCount++;
            System.out.print(ticket.getTicketID()+"\t"+ticket.getTicketName()+"\t"+ticket.getTicketStatus()+"\t"+ticket.getPriorityLevel());
            System.out.println();
            System.out.println("total tickets assigned resolved by you "+ticketCount);
        }
    }
}
