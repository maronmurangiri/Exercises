package ticket;

import ticket.entity.Ticket;

import java.sql.Timestamp;

public class App {
    public static void main(String[] args) {
        TicketCRUDOperations ticketCRUDOperations = new TicketCRUDOperations();
        ticketCRUDOperations.insertTicket("No cart", "Cart disappears after sometime",
                "high", Timestamp.valueOf("2023-09-25 21:23:33.564"));
        ticketCRUDOperations.insertTicket("Discount does not reflect", "Discount does not reflect on total cost",
                "medium", Timestamp.valueOf("2023-09-25 21:23:33.564"));
        ticketCRUDOperations.insertTicket("Transaction takes too long", "Transaction takes too long to complete",
                "high", Timestamp.valueOf("2023-09-25 21:23:33.564"));

        Ticket ticketToUpdate = ticketCRUDOperations.findTicketById(1);
        System.out.println(ticketToUpdate.toString());
        ticketCRUDOperations.updateTicketDeadlineDate(ticketToUpdate, Timestamp.valueOf("2023-10-25 21:23:33.564"));
        ticketCRUDOperations.deleteTicket(2);
    }
}
