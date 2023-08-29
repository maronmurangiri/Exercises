package ticket.acount.service;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//import authentication.UserAuthCRUDOperations;
//import authentication.crud;
import authentication.crud.UserAuthCRUDOperations;
import authentication.entity.User;
import authorize.service.UserController;
import com.fasterxml.jackson.core.JsonProcessingException;
import role.entity.Role;
import role.crud.RoleCRUIDOperation;
import positions.entity.Position;
import positions.crud.PositionCRUIDOperation;
import ticket.crud.TicketCRUDOperations;
import ticket.entity.Ticket;
import ticket.entity.TicketStatus;

import java.time.*;


public class TicketService {

    //user entity CRUD operations class instance
    UserAuthCRUDOperations userAuthCRUDOperations = new UserAuthCRUDOperations();

    //role entity CRUD operations class instance
    RoleCRUIDOperation roleCRUIDOperation = new RoleCRUIDOperation();

    //ticket entity CRUD operation class instance
    TicketCRUDOperations ticketCRUDOperations = new TicketCRUDOperations();

    UserController userController = new UserController();

    //current date time instance
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");




    Scanner scanner = new Scanner(System.in);

    String admin = "admin";

    public void createTicket(String userEmail) {
        //userData = new ArrayList<>();
        boolean operate = true;
        while (operate) {

            System.out.println("Enter the ticket name or CANCEL to quit: ");
            String ticketNameInput = scanner.nextLine();

            if (ticketNameInput.equalsIgnoreCase("cancel")){
                operate=false;
                break;
            }

            System.out.println("Enter the ticket description: ");
            String ticketDescriptionInput = scanner.nextLine();

            System.out.println("Enter the ticket priority level: ");
            String ticketPriorityLevelInput = scanner.nextLine();

            System.out.println("Enter the ticket deadline date in this format (yyyy-MM-dd HH:mm) : ");
            String ticketDeadlineDate = scanner.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");


            try {
                Date parsedDeadlineDate = dateFormat.parse(ticketDeadlineDate);
                Timestamp timestampedDeadlineDate = new Timestamp(parsedDeadlineDate.getTime());

            //Timestamp timestampedDeadlineDate = new Timestamp(parsedDeadlineDate.getTime());

            //obtain the ID of ticket creator
            User createdBy = userAuthCRUDOperations.findUserByEmail(userEmail);
            System.out.println(createdBy);

            //current Date time
            Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));

            //open status ID
            TicketStatus ticketStatus = ticketCRUDOperations.findTicketStatusByName("open");


                        //insert ticket to the database
            if (ticketCRUDOperations.insertTicket(ticketNameInput,ticketDescriptionInput,ticketStatus,ticketPriorityLevelInput,createdOn,createdBy, timestampedDeadlineDate )){
            System.err.println("Ticket successfully created\n");
            System.out.println("Enter the ticket details to create another ticket or CANCEL to quit");
            } else {
                System.err.println("Ticket creation failed......");
                System.out.println("Retry again or enter CANCEL to quit: ");

            }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }


    }

    public void displayTickets(){
        int ticketCount=0;
        List<Ticket> tickets = ticketCRUDOperations.findTicketsCreated();
        System.out.print("tickets ID\t tickets name\ttickets status\ttickets priority");
        System.out.println();
        for(Ticket ticket:tickets){
            ticketCount++;
            System.out.print(ticket.getTicketID()+"\t"+ticket.getTicketName()+"\t"+ticket.getTicketStatus()+"\t"+ticket.getPriorityLevel());
            System.out.println();
            System.out.println("total tickets created: "+ticketCount+" tickets");
        }


    }
    public void AssignTicketsToAgent(){
        Boolean operate = true;
        while (operate){
            System.out.println("CREATED TICKETS");
            displayTickets();
            System.out.println("Fill in the ticket ID of the ticket to assign or CANCEL to quit: ");
            String ticketToAssignIdInput = scanner.nextLine();


            System.out.println("fill in the email of the agent to assign this ticket:");
            String agentEmailInput = scanner.nextLine();
                if (ticketToAssignIdInput.equalsIgnoreCase("cancel")){
                    operate=false;
                }
            //ticket to update
            Ticket ticketToAssign = ticketCRUDOperations.findTicketById(Integer.parseInt(ticketToAssignIdInput));

            //user agent to assign ticket
            User agentToAssign = userAuthCRUDOperations.findUserByEmail(agentEmailInput);

            //update agent
            ticketCRUDOperations.updateTicketAgentAssigned(ticketToAssign,agentToAssign);
            System.err.println("ticket successfully assigned to"+agentToAssign);
        }
    }
    public void login() throws JsonProcessingException {

        System.out.println("Fill in your details to login or enter 'CANCEL' to quit");

        boolean loginStatus = true;
        while (loginStatus) {
            System.out.println("Enter your work Email/enter cancel to quit: ");
            String workEmailInput = scanner.nextLine();

            if (workEmailInput.equalsIgnoreCase("Cancel")) {
                System.out.println("Quitting the login process..");
                break;
            }
            //checking if user exist by getUserAccountByWorkEmail method
            User user = userAuthCRUDOperations.findUserByEmail(workEmailInput);
            if (user != null) {

                System.out.println("Enter your password: ");
                String passwordInput = scanner.nextLine();
                if (user.getPassword().equals(passwordInput)) {
                    String name = user.getFirstname();

                    System.out.println("Logged in successfully as " + name);

                    userController.getUserData(user.getEmail());

                    break;
                } else {
                    if (passwordInput.equalsIgnoreCase("cancel")){
                        loginStatus=false;
                    }else {
                        System.err.println("Invalid details");
                    }
                }
            } else {
                System.err.println("User not found");
            }
        }

    }
/*
    public void logout() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Would you like to log out?(yes/No): ");
            String logoutState = scanner.nextLine();

            if (logoutState.equalsIgnoreCase("yes")) {
                System.out.println("You have been logged out, see you soon");
                break;
            } else {
                System.out.println("You are still logged in  ");
            }
        }

    }

    public void resetPassword() {
        boolean operate = true;

        while (operate) {
            System.out.println("Enter your work email or CANCEL to quit:");
            String workEmailInput = scanner.nextLine();

            User user = getUserAccountByWorkEmail(workEmailInput);
            if (user != null) {
                System.out.println("Enter the current password or CANCEL to quit: ");
                String currentPasswordInput = scanner.nextLine();

                if (user.getPassword().equals(currentPasswordInput)) {
                    System.out.println("Enter the new password or CANCEL to quit: ");
                    String newPasswordInput = scanner.nextLine();

                    if (isPasswordValid(newPasswordInput)) {
                        //code for updating the password field in the database
                    } else {
                        if (newPasswordInput.equalsIgnoreCase("cancel")) {
                            operate = false;
                        } else {
                            System.err.println("Enter a valid password: with atleast 8 characters with atleast a digit, a lowercase, an uppercase and a special character");
                        }
                    }

                } else {
                    if (currentPasswordInput.equalsIgnoreCase("cancel")) {
                        operate = false;
                    } else {
                        System.err.println("Password do not match");
                    }
                }

            } else {
                if (workEmailInput.equalsIgnoreCase("cancel")){
                    operate=false;
                }
                else {
                    System.err.println("No such user");
                }
            }

        }
    }




    public void deleteUserAccount(){
        boolean operate = true;

        while (operate) {
            System.out.println("Enter the work email of the user's account you wanna delete or CANCEL to quit: ");

            String userAccountToBeDeletedWorkEmail = scanner.nextLine();
            if(getUserAccountByWorkEmail(userAccountToBeDeletedWorkEmail) != null){
                //code for deleting the user account from the database
            }
            else{
                if (userAccountToBeDeletedWorkEmail.equalsIgnoreCase("cancel")){
                    operate=false;
                }else {
                    System.err.println("No such user");
                }
            }
        }



    }
*/

    //method for checking if password is valid
    public static boolean isPasswordValid(String newPassword){

        boolean hasLowercase = !newPassword.equals(newPassword.toUpperCase());
        boolean hasUpperCase = !newPassword.equals(newPassword.toLowerCase());
        boolean hasDigit = newPassword.matches(".*\\d.*");
        boolean isLengthValid = newPassword.length() >= 8;
        boolean hasSpecialCharacter = newPassword.matches(".*[^a-zA-Z0-9].*");

        return hasLowercase && hasUpperCase && hasDigit && hasSpecialCharacter && isLengthValid;

    }

    public static void main(String[] args) throws JsonProcessingException {
        //authentication.user.UserAccount userAccount = new authentication.user.UserAccount();
        //userAccount.createAccount();
        //userAccount.login();
        TicketService ticketService = new TicketService();
        ticketService.createTicket("murangirimaron@gmail.com");
    }
}
