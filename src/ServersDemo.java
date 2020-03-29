import IA.DistFS.Requests;
import IA.DistFS.Servers;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class ServersDemo {
    public static void main(String[] args) throws Servers.WrongParametersException {
        long inicio = System.currentTimeMillis();
        int usuaris, max_peticions, seedr, servidors, min_replic, seeds;
        usuaris = 200;
        max_peticions = 5;
        servidors = 200;
        min_replic = 5;
        seedr = seeds = 2;
        Requests requests =  new Requests(usuaris, max_peticions, seedr);
        Servers servers = new Servers(servidors, min_replic, seeds);

        // write your code here
        ServersBoard Serv =new ServersBoard(requests, servers, servidors);
        ServersHillClimbingSearch(Serv);
        //ServersSimulatedAnnealingSearch(Serv);
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio));
        System.out.println(tiempo +" mili segundos");
    }

    private static void ServersSimulatedAnnealingSearch(ServersBoard Serv) {
        try {
            System.out.println("\n TSP Simulated Annealing");
            Problem problem =  new Problem(Serv, new ServersSuccessorFunctionSA(), new ServersGoalTest(), new ServersHeuristicFunction());
            Search search =  new SimulatedAnnealingSearch(2000,100,5,0.001);
            SearchAgent agent = new SearchAgent(problem,search);

            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ServersHillClimbingSearch(ServersBoard Serv) {
        System.out.println("\n nTSP HillClimbing -->");
        try {
            Problem problem =  new Problem(Serv, new ServersSuccessorFunctionHC(), new ServersGoalTest(), new ServersHeuristicFunction());
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
            String action =  actions.get(i).toString();
            System.out.println(action);
        }

    }
}
