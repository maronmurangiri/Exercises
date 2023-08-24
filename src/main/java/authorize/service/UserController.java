package authorize.service;

import authentication.crud.UserAuthCRUDOperations;
import authentication.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import role.entity.Role;
import authentication.user.UserAccount;

public class UserController {

    private UserAuthorizationService userAuthorizationService;

    public UserController() {
        userAuthorizationService = new UserAuthorizationService();
    }

    public void getUserData(String email) throws JsonProcessingException {
        UserAuthCRUDOperations userAuthCRUDOperations = new UserAuthCRUDOperations();
        User user = userAuthCRUDOperations.findUserByEmail(email);

        String subject = user.getFirstname();
        Role role = user.getRole();

        String token = userAuthorizationService.generateToken(subject, role);

        Jws<Claims> claims = userAuthorizationService.getClaimsFromToken(token);

        String  claimsRoleJson = claims.getBody().get("roles", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Role claimsRole = objectMapper.readValue(claimsRoleJson, Role.class);

            if (claimsRole.getRoleName().equalsIgnoreCase("Admin")) {
                System.out.println(" Logged in as admin : \n You can create account, positions and departments");

                UserAccount userAccount = new UserAccount();
               userAccount.createAccount();

            } else if (claimsRole.getRoleName().equalsIgnoreCase("agent")) {
                System.out.println(" agent allowed here");
            } else {
                System.out.println("anybody is allowed here");
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
