package role.account.service;

import authentication.crud.UserAuthCRUDOperations;
import authentication.entity.User;
import department.crud.DepartmentCRUDOperation;
import department.entity.Department;
import positions.crud.PositionCRUIDOperation;
import role.crud.RoleCRUIDOperation;
import role.entity.Role;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RoleAccount {
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String admin = "admin";

    //role CRUD operation instance
    RoleCRUIDOperation roleCRUIDOperation = new RoleCRUIDOperation();

    //position CRUD operation class instance
    PositionCRUIDOperation positionCRUIDOperation = new PositionCRUIDOperation();

    //department CRUD operation class instance
    DepartmentCRUDOperation departmentCRUDOperation = new DepartmentCRUDOperation();

    //userCRUD operation class instance
    UserAuthCRUDOperations userAuthCRUDOperations = new UserAuthCRUDOperations();
    Scanner scanner = new Scanner(System.in);

    public void createRole() {
        //userData = new ArrayList<>();
        boolean operate = true;
        while (operate) {

            System.out.println("Enter the Role name or CANCEL to quit: ");
            String roleNameInput = scanner.nextLine();

            if (roleNameInput.equalsIgnoreCase("cancel")) {
                operate = false;
                break;
            }

            //to check if role exist
            Role roleFound = roleCRUIDOperation.findRoleBY(roleNameInput);


            if (roleFound != null) {
                System.err.println("The account exist");
                operate = true;
            } else {

                //obtain the ID of role creator who is the administrator
                if (admin.equalsIgnoreCase("admin") || admin.equalsIgnoreCase("administrator")) {
                    //obtain role ID of the admin
                    admin = "admin";
                    Role adminRoleId = roleCRUIDOperation.findRoleBY(admin);

                    User createdBy = userAuthCRUDOperations.findUSerByRoleID(adminRoleId);
                    System.out.println(createdBy);

                    //current Date time
                    Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));

                    //insert Department to the database
                    if(roleCRUIDOperation.insertRole(roleNameInput,createdBy.getId(),createdOn)){
                    System.err.println("Role successfully created\n");
                    System.out.println("Enter the role details below to create another role or CANCEL to quit");

                }
                    else {
                        System.out.println("Role has not been created.....");
                        System.out.println("Kindly try again.");
                    }
                }


            }

        }
    }

    public static void main(String[] args){
        department.account.service.DepartmentAccount departmentAccount = new department.account.service.DepartmentAccount();
        departmentAccount.createDepartment();
    }
}


