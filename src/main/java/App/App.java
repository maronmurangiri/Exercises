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



public class App {

    public static void main(String[] args) {

       UserAccount userAccount = new UserAccount();

        try {
            userAccount.login();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
