package Positions.Entity;

import Departments.Entity.DepartmentCRUDOperations;
import Roles.Entity.RoleCRUDOperations;
import Departments.Department;
import Roles.Entity.Role;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PositionAccount {
    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String admin = "admin";

    //role CRUD operation instance
    RoleCRUDOperations roleCRUIDOperation = new RoleCRUDOperations();

    //position CRUD operation class instance
    PositionCRUDOperations positionCRUIDOperation = new PositionCRUDOperations();

    //department CRUD operation class instance
    DepartmentCRUDOperations departmentCRUDOperation = new DepartmentCRUDOperations();

    //userCRUD operation class instance
    UserAuthCRUDOperations userAuthCRUDOperations = new UserAuthCRUDOperations();
    Scanner scanner = new Scanner(System.in);
    public void createPosition() {
        //userData = new ArrayList<>();
        boolean operate = true;
        while (operate) {

            System.out.println("Enter the position name or CANCEL to quit: ");
            String positionNameInput = scanner.nextLine();

            if (positionNameInput.equalsIgnoreCase("cancel")){
                operate=false;
                break;
            }

            System.out.println("Enter the position's department: ");
            String departmentNameInput = scanner.nextLine();

            //to check if position exist
            Position positionFound = positionCRUIDOperation.findPosition(positionNameInput);


            if (positionFound != null) {
                System.err.println("The account exist");
                operate= true;
            } else {
                //obtain user position ID
                Department department = departmentCRUDOperation.findDepartment(departmentNameInput);
                System.out.println("positionID:"+department.getId());

                //obtain the ID of Position creator who is the administrator
                if ( admin.equalsIgnoreCase("admin")|| admin.equalsIgnoreCase("administrator")) {
                    //obtain role ID of the admin
                    admin = "admin";
                    Role adminRoleId = roleCRUIDOperation.findRoleBY(admin);

                    User createdBy = userAuthCRUDOperations.findUSerByRoleID(adminRoleId);
                    System.out.println(createdBy);
                    //current Date time
                    Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));

                    //insert position to the database
                    positionCRUIDOperation.insertPosition(positionNameInput, positionFound.getCreatedBy(), createdOn,department);

                    System.err.println("Position successfully created\n");
                    System.out.println("Enter the Position details to create another account or CANCEL to quit");

                }


            }

        }


    }

    public static void main(String[] args){
        PositionAccount positionAccount = new PositionAccount();
        positionAccount.createPosition();
    }
}
