package department.account.service;


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

public class DepartmentAccount {
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

    public void createDepartment() {
        //userData = new ArrayList<>();
        boolean operate = true;
        while (operate) {

            System.out.println("Enter the Department name or CANCEL to quit: ");
            String departmentNameInput = scanner.nextLine();

            if (departmentNameInput.equalsIgnoreCase("cancel")) {
                operate = false;
                break;
            }

            System.out.println("Enter the department description: ");
            String departmentDescriptionInput = scanner.nextLine();

            System.out.println("Enter the department director email: ");
            String departmentDirectorEmailInput = scanner.nextLine();

            //to check if department exist
            Department departmentFound = departmentCRUDOperation.findDepartment(departmentNameInput);


            if (departmentFound != null) {
                System.err.println("The account exist");
                operate = true;
            } else {
                //obtain user position ID
               // Department department = departmentCRUDOperation.findDepartment(departmentNameInput);
                //System.out.println("positionID:" + departmentFound.getDepartmentId());

                //obtain the ID of Department creator who is the administrator
                if (admin.equalsIgnoreCase("admin") || admin.equalsIgnoreCase("administrator")) {
                    //obtain role ID of the admin
                    admin = "admin";
                    Role adminRoleId = roleCRUIDOperation.findRoleBY(admin);

                    User createdBy = userAuthCRUDOperations.findUSerByRoleID(adminRoleId);
                    System.out.println(createdBy);

                    //current Date time
                    Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));

                    //director
                    User departmentDirector = userAuthCRUDOperations.findUserByEmail(departmentDirectorEmailInput);

                    //insert Department to the database
                    departmentCRUDOperation.insertDepartment(departmentNameInput,departmentDescriptionInput,departmentDirector,createdBy.getId(),createdOn);
                    System.err.println("Department successfully created\n");
                    System.out.println("Enter the Department details to create another department or CANCEL to quit");

                }


            }

        }
    }
}


