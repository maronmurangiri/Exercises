package Agent;

import DatabaseConnectionManager.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class AgentDAO {
    public static Agent readAgent(int agentId) {
        Connection connection = DatabaseConnectionManager.getConnection();
        Agent agent = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tickets WHERE user_id = " + agentId);

            if (resultSet.next()) {
                int numberOfTickets = resultSet.getInt("number_of_tickets");
                int resolvedTicketCount = resultSet.getInt("resolved_ticket_count");
                int assignedTicketId = resultSet.getInt("assigned_ticket_id");

                agent = new Agent(agentId, numberOfTickets);
                agent.resolvedTicketCount(resolvedTicketCount);
                agent.setAssignedTicketId(assignedTicketId);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agent;
    }
}
