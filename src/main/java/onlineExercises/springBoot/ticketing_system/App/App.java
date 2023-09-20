package onlineExercises.springBoot.ticketing_system.App;

import com.fasterxml.jackson.core.JsonProcessingException;
import onlineExercises.springBoot.ticketing_system.authentication.user.UserAccount;

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
