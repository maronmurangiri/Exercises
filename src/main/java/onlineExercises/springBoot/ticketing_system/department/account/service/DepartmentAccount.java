package onlineExercises.springBoot.ticketing_system.department.account.service;


import onlineExercises.springBoot.ticketing_system.authentication.crud.UserAuthCRUDOperations;
import onlineExercises.springBoot.ticketing_system.authentication.entity.User;
import onlineExercises.springBoot.ticketing_system.department.crud.DepartmentCRUDOperation;
import onlineExercises.springBoot.ticketing_system.department.entity.Department;
import onlineExercises.springBoot.ticketing_system.positions.crud.PositionCRUIDOperation;
import onlineExercises.springBoot.ticketing_system.role.crud.RoleCRUIDOperation;
import onlineExercises.springBoot.ticketing_system.role.entity.Role;

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
            } else if (departmentNameInput.isBlank()) {
                System.out.println("Enter a valid department name: ");
                continue;
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


