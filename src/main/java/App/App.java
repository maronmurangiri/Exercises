package App;

import authentication.crud.UserAuthCRUDOperations;
import authentication.user.UserAccount;
import authorize.service.UserController;
import com.fasterxml.jackson.core.JsonProcessingException;
import role.crud.RoleCRUIDOperation;
import role.entity.Role;
import ticket.crud.TicketCRUDOperations;
import ticket.entity.TicketStatus;
import authentication.entity.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static void main(String[] args) {

       UserAccount userAccount = new UserAccount();

        try {
            userAccount.login();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        // ticketCRUDOperations.insertTicket("No cart", "Cart disappears after sometime",ticketStatus,"High",createdOn, createdBy, Timestamp.valueOf("2023-09-25 21:23:33.564"));
//        ticketCRUDOperations.insertTicket("Discount does not reflect", "Discount does not reflect on total cost",
//                "medium", Timestamp.valueOf("2023-09-25 21:23:33.564"));
//        ticketCRUDOperations.insertTicket("Transaction timeouts", "Transaction takes too long to complete",
//                "high",1, Timestamp.valueOf("2023-08-25 21:23:33.564"));
//
//        ticketCRUDOperations.insertTicket("Transaction errors out", "Transaction err  ors out after 2 seconds",101,
//                "high", Timestamp.valueOf("2023-08-30 16:03:33.564"));


        /*ticketCRUDOperations.updateTicketDeadlineDate(1, Timestamp.valueOf("2023-10-25 21:23:33.564"));
        Ticket ticketToUpdate = ticketCRUDOperations.findTicketById(4);
        System.out.println(ticketToUpdate.toString());*/

//        ticketCRUDOperations.deleteTicket(5);
    }
}
