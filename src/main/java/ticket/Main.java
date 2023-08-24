package ticket;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Ticket issue = new Ticket(101, "No cart", "Cart disappears after sometime",
                "high", Timestamp.valueOf("2023-07-25 21:23:33.564"));
        issue.getDeadlineDate();
    }
}
