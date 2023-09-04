package authorize.service;

//import authentication.crud.UserAuthCRUDOperations;
//import main.java.authentication.crud.;
import Agent.service.AgentService;
import authentication.crud.UserAuthCRUDOperations;
//import authentication.UserAuthCRUDOperations;
import authentication.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import department.account.service.DepartmentAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import positions.account.service.PositionAccount;
import role.account.service.RoleAccount;
import role.entity.Role;
import authentication.user.UserAccount;
import authorize.service.UserAuthorizationService;
import ticket.acount.service.TicketService;
import ticket.crud.TicketCRUDOperations;
import ticket.entity.Ticket;

import java.util.List;
import java.util.Scanner;
import java.lang.System;

public class UserController {


    private UserAuthorizationService userAuthorizationService;

    public UserController() {
        userAuthorizationService = new UserAuthorizationService();
    }

    public void getUserData(String email) throws JsonProcessingException {
        UserAuthCRUDOperations userAuthCRUDOperations = new UserAuthCRUDOperations();
        User user = userAuthCRUDOperations.findUserByEmail(email);

        String subject = user.getFirstname();
        String roleName = user.getRole().getRoleName();

        String userEmail = user.getEmail();
        Integer userId = user.getId();

        String token = userAuthorizationService.generateToken(subject, roleName,userEmail,userId);

        Jws<Claims> claims = userAuthorizationService.getClaimsFromToken(token);

        String  claimsRole = claims.getBody().get("roles", String.class);
        //ObjectMapper objectMapper = new ObjectMapper();
       // Role claimsRole = objectMapper.readValue(claimsRoleJson, Role.class);

        userEmail = claims.getBody().get("email",String.class);
         userId = claims.getBody().get("userId", Integer.class);

            if (claimsRole.equalsIgnoreCase("admin")) {
                System.out.println(" Logged in as admin : \n You can create account, positions and departments\n");


                Scanner scanner = new Scanner(System.in);
                String choice;

                Boolean operate = true;
                do {
                    System.out.println("WELCOME TO ADMIN MENU\n Choose what to carry on or CANCEL to quit");
                    System.out.println("1 --> Create a user");
                    System.out.println("2 --> Create a position");
                    System.out.println("3 --> Create a department");
                    System.out.println("4 --> Create a role");
                    System.out.println("5 --> Display all tickets created");
                    System.out.println("6 --> Assign ticket to agent");
                    System.out.println("7 --> Display resolved tickets");
                    System.out.println("8 --> Update tickets status of ticket resolved by you");


                    choice = scanner.nextLine().toLowerCase();


                    switch (choice) {
                        case "1":
                            System.out.println("ACCOUNT CREATION \nEnter the user details below: ");
                            UserAccount userAccount = new UserAccount();
                            userAccount.createAccount();
                            break;

                        case "2":
                            System.out.println("NEW POSITIONS CREATION\n Enter the details below:");
                            PositionAccount positionAccount = new PositionAccount();
                            positionAccount.createPosition();
                            break;

                        case "3":
                            System.out.println("NEW DEPARTMENT CREATION\nEnter the details below:");
                            DepartmentAccount departmentAccount = new DepartmentAccount();
                            departmentAccount.createDepartment();
                            break;

                        case "4":
                            System.out.println("NEW ROLE CREATION\nEnter the details below:");
                            RoleAccount roleAccount = new RoleAccount();
                            roleAccount.createRole();
                            break;

                        case "5":
                            System.out.println("ALL TICKETS CREATED");
                            TicketService ticketService = new TicketService();
                            ticketService.displayTickets();
                            break;

                        case "6":
                            System.out.println("ASSIGNING AGENT");
                            TicketService ticketService1 = new TicketService();
                            ticketService1.AssignTicketsToAgent();
                            break;
                        case "7":
                            System.out.println("Resolved tickets");
                            TicketService ticketService2 = new TicketService();
                            ticketService2.displayResolvedTickets();
                            break;

                        case "8":
                            System.out.println("UPDATE STATUS OF TICKET YOU RESOLVED\n Enter the details below:");
                            AgentService agentService = new AgentService();
                            agentService.updateResolvedTickets();
                            break;

                        case "cancel":
                            System.out.println("Quiting......");

                            operate=false;
                            break;

                        default:
                            System.out.println("Invalid choice. Please select a valid option or type 'cancel' to exit.");
                            break;


                        }



                }
                while (operate);



            }
            else if (claimsRole.equalsIgnoreCase("agent")) {

                Scanner scanner = new Scanner(System.in);
                String choice;

                Boolean operate = true;
                do {
                    System.out.println("WELCOME TO AGENT MENU\n Choose what to carry on or CANCEL to quit");
                    System.out.println("1 --> view tickets assigned");
                    System.out.println("2 --> Update status of resolved ticket");
                    System.out.println("3 --> view resolved tickets");



                    choice = scanner.nextLine().toLowerCase();
                    AgentService agentService = new AgentService();

                    switch (choice) {
                        case "1":

                            System.out.println("VIEW TOTAL ASSIGNED TICKET \n");
                            agentService.readTicketsAssignedToAgent(userId);
                            break;

                        case "2":
                            System.out.println("ALL TICKETS ASSIGNED");
                            //AgentService agentService1 = new AgentService();
                            agentService.readTicketsAssignedToAgent(userId);
                            System.out.println("UPDATE STATUS OF RESOLVED TICKET\n Enter the details below:");
                            //AgentService agentService3 = new AgentService();
                            agentService.updateResolvedTickets();
                            break;

                        case "3":
                            System.out.println("VIEW RESOLVED TICKETS\nEnter the details below:");
                            AgentService agentService2 = new AgentService();
                            agentService2.readResolvedTicketByAgent(userId);
                            break;

                        case "cancel":
                            System.out.println("Quiting......");

                            operate=false;
                            break;

                        default:
                            System.out.println("Invalid choice. Please select a valid option or type 'cancel' to exit.");
                            break;


                    }



                }
                while (operate);




            } else if (claimsRole.equalsIgnoreCase("user")) {


                Scanner scanner = new Scanner(System.in);
                System.out.println("You can create a ticket and view ticket status: ");
                String choice;

                Boolean operate = true;
                do {
                    System.out.println("WELCOME TO USER MENU\n Choose what to carry on or CANCEL to quit");
                    System.out.println("1 --> Create a ticket");
                    System.out.println("2 --> view ticket");


                    choice = scanner.nextLine().toLowerCase();


                    switch (choice) {
                        case "1":
                            System.out.println("TICKET CREATION \nEnter the ticket details below: ");
                            TicketService ticketService = new TicketService();
                            ticketService.createTicket(userEmail);
                            break;

                        case "2":
                            System.out.println("View ticket\n Enter the details below:");
                            TicketCRUDOperations ticketCRUDOperations = new TicketCRUDOperations();
                            List<Ticket> tickets = ticketCRUDOperations.findTicketByTicketCreatorID(userId);
                            System.out.print("Ticket title\tticket description\t\t\tticket priority level\tticket status");
                            System.out.println();
                            for (Ticket ticket :tickets){
                                System.out.print(ticket.getTicketName()+"\t"+ticket.getDescription()+"\t\t"+ticket.getPriorityLevel()+"\t\t\t\t"+ticket.getTicketStatus()+"\n");
                            }

                            break;

                        case "cancel":
                            System.out.println("Quiting......");
                            operate = false;
                            break;

                        default:
                            System.out.println("Invalid choice. Please select a valid option or type 'cancel' to exit.");
                            break;


                    }


                }
                while (operate);


            }

            }


    public static void main(String[] args){
        UserController userController = new UserController();
        UserAuthorizationService userAuthorizationService = new UserAuthorizationService();


        try {
            userController.getUserData("murangirimaron@gmail.com");
        } catch (JsonProcessingException e) {
        }
    }
}
