package authentication.user;

import java.sql.*;
import java.time.format.DateTimeFormatter;
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

import java.time.*;


public class    UserAccount {

    //user entity CRUID operations class instance
    UserAuthCRUDOperations userAuthCRUDOperations = new UserAuthCRUDOperations();

    //role entity CRUID operations class instance
    RoleCRUIDOperation roleCRUIDOperation = new RoleCRUIDOperation();

    //positions entity CRUID operation class instance
    PositionCRUIDOperation positionCRUIDOperation = new PositionCRUIDOperation();

    UserController userController = new UserController();

    //current date time instance
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    Scanner scanner = new Scanner(System.in);

    String admin = "admin";

    public void createAccount() {
        //userData = new ArrayList<>();
        boolean operate = true;
        while (operate) {

        System.out.println("Enter user first name or CANCEL to quit: ");
        String firstNameInput = scanner.nextLine();

        if (firstNameInput.equalsIgnoreCase("cancel")){
            operate=false;
            break;
        }

        System.out.println("Enter user Surname: ");
        String surnameInput = scanner.nextLine();

        System.out.println("Enter user department: ");
        String departmentInput = scanner.nextLine();

        System.out.println("Enter the role of the user in the system: ");
        String userRoleInTheSystemInput = scanner.nextLine();

        System.out.println("Enter user work Position: ");
        String userWorkPositionInput = scanner.nextLine();

        System.out.println("Enter user Work Email: ");
        String workEmailInput = scanner.nextLine();

            System.out.println("Enter your password: ");
            String passwordInput = scanner.nextLine();

            if (isPasswordValid(passwordInput)) {

                System.out.println("Confirm password: ");
                String confirmPasswordInput = scanner.nextLine();
               // User newUserAccount = new User(firstName,surname,workEmail,password,department,userRoleInTheSystem,userWorkPosition,);

                //to check if user exist
                User userFound = userAuthCRUDOperations.findUserByEmail(workEmailInput);


                if (userFound != null) {
                    System.err.println("The account exist");
                    operate= true;
                } else {
                    //obtain user position ID
                    Position userPositionId = positionCRUIDOperation.findPosition(userWorkPositionInput);

                    //obtain user role ID
                    Role roleIdInDB = roleCRUIDOperation.findRoleBY(userRoleInTheSystemInput);

                    //obtain the ID of account creator who is the administrator
                    if ( admin.equalsIgnoreCase("admin")|| admin.equalsIgnoreCase("administrator")) {
                        //obtain role ID of the admin
                        admin = "admin";
                        Role adminRoleId = roleCRUIDOperation.findRoleBY(admin);

                        User createdBy = userAuthCRUDOperations.findUSerByRoleID(adminRoleId);

                        //current Date time
                        Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));



                        if (passwordInput.equals(confirmPasswordInput)) {

                            //insert user to the database
                            userAuthCRUDOperations.insertUser(firstNameInput, surnameInput,workEmailInput, passwordInput, userPositionId,roleIdInDB,createdBy.getCreatedBy(),createdOn);
                            System.err.println("Account successfully created\n");
                            System.out.println("Enter the user details to create another account or CANCEL to quit");
                        } else {
                            System.err.println("Passwords do not match");
                            System.out.println("Retry again or enter CANCEL to quit: ");

                            if (confirmPasswordInput.equalsIgnoreCase("cancel")){
                                operate=false;
                                break;
                            }
                        }
                    }


                }


            } else {
                System.err.println("Kindly enter a valid password with: ");
                System.err.println("atleast an uppercase,lowercase,digit, special character and of length greater than 8");
            }
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
        UserAccount userAccount = new UserAccount();
        //userAccount.createAccount();
        userAccount.login();
    }
}
