package main;
import Agent.Agent;
import Agent.AgentDAO;
import DatabaseConnectionManager.DatabaseConnectionManager;
public class MainClass {
    public static void main(String[] args) {
        Agent agent = AgentDAO.readAgent(1);

        if (agent != null) {
            System.out.println(agent.toString());
        } else {
            System.out.println("Agent not found.");
        }

        DatabaseConnectionManager.closeConnection(); // Close the connection when done
    }
}


