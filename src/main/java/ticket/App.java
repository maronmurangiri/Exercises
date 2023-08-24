package ticket;

import ticket.entity.Ticket;

import java.sql.Timestamp;
import java.util.List;

public class App {
    public static void main(String[] args) {
        TicketCRUDOperations ticketCRUDOperations = new TicketCRUDOperations();
//        ticketCRUDOperations.insertTicket("No cart", "Cart disappears after sometime",
//                "high", Timestamp.valueOf("2023-09-25 21:23:33.564"));
//        ticketCRUDOperations.insertTicket("Discount does not reflect", "Discount does not reflect on total cost",
//                "medium", Timestamp.valueOf("2023-09-25 21:23:33.564"));
//        ticketCRUDOperations.insertTicket("Transaction timeouts", "Transaction takes too long to complete",
//                "high",1, Timestamp.valueOf("2023-08-25 21:23:33.564"));
//
//        ticketCRUDOperations.insertTicket("Transaction errors out", "Transaction erors out after 2 seconds",101,
//                "high", Timestamp.valueOf("2023-08-30 16:03:33.564"));


        ticketCRUDOperations.updateTicketDeadlineDate(1, Timestamp.valueOf("2023-10-25 21:23:33.564"));
        Ticket ticketToUpdate = ticketCRUDOperations.findTicketById(4);
        System.out.println(ticketToUpdate.toString());

//        ticketCRUDOperations.deleteTicket(5);
    }
}
