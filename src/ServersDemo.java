import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import java.lang.Object;
import IA.DistFS.Servers;


public class ServersDemo {
    public static void main(String[] args) {
        int usuaris, max_peticions, seedr, servidors, min_replic, seeds
        Requests requests =  new Requests(usuaris, max_peticions, seedr);
        Servers servers = new Servers(servidors, min_replic, seeds);

        // write your code here
        ServersBoard Serv =new ServersBoard(requests, servers);
        //algoritmes que utilitzem
        ServersHillClimbingSearch(Serv);
        ServersSimulatedAnnealingSearch(Serv);
    }

    private static void ServersSimulatedAnnealingSearch(ServersBoard Serv) {
        try {
            Problem problem =  new Problem(Serv, new ServersSuccessorFunction(), new ServersGoalTest(), new ServersHeuristicFunction());
            Search search =  new SimulatedAnnealingSearch();
            SearchAgent agent = new SearchAgent(problem,search);

            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ServersHillClimbingSearch(ServersBoard Serv) {
        try {
            Problem problem =  new Problem(Serv, new ServersSuccessorFunction(), new ServersGoalTest(), new ServersHeuristicFunction());
            Search search =  new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem,search);

            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }

    }

    private static void printActions(List actions) {
        for (int i = 0; i < actions.size(); i++) {
            String action = (String) actions.get(i);
            System.out.println(action);
        }
    }
}