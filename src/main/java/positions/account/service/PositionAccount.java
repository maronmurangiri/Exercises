package positions.account.service;

//import authentication.crud.UserAuthCRUDOperations;
import authentication.crud.UserAuthCRUDOperations;
import authentication.entity.User;
import department.crud.DepartmentCRUDOperation;
import department.entity.Department;
import positions.entity.Position;
import role.crud.RoleCRUIDOperation;
import role.entity.Role;
import positions.crud.PositionCRUIDOperation;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PositionAccount {
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

                    //obtain the ID of Position creator who is the administrator
                    if ( admin.equalsIgnoreCase("admin")|| admin.equalsIgnoreCase("administrator")) {
                        //obtain role ID of the admin
                        admin = "admin";
                        Role adminRoleId = roleCRUIDOperation.findRoleBY(admin);

                        User createdBy = userAuthCRUDOperations.findUSerByRoleID(adminRoleId);

                        //current Date time
                        Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));

                        //insert position to the database
                        positionCRUIDOperation.insertPosition(positionNameInput,createdBy.getCreatedBy(),createdOn,department);

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
