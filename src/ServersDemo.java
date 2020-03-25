import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;


public class ServersDemo {
    public static void main(String[] args) {
        int usuaris, max_peticions, seedr, servidors, min_replic, seeds
        Requests requests =  new Requests(usuaris, max_peticions, seedr);
        Servers servers = new Servers(servidors, min_replic, seeds);

        // write your code here
        ServidorsBoard Serv=new ServidorsBoard(requests, servers);
        //algoritmes que utilitzem
        ServidorsHillClimbingSearch(Serv);
        //IAP15BreadthFirstSearch(IAP15);
        //IAP15DepthLimitedSearch(IAP15,7);
        //IAP15IterativeDeepeningSearch(IAP15);
        //IAP15IterativeDeepeningAStarSearchH1(IAP15);
        // IAP15IterativeDeepeningAStarSearchH2(IAP15);
        // IAP15AStarSearchH1(IAP15);
        // IAP15AStarSearchH2(IAP15);
    }

    private static void ServidorsHillClimbingSearch(ServidorsBoard serv) {
        try {
            Problem problem =  new Problem(Serv,new ServidorSuccessorFunction(), new ServidorGoalTest());
            Search search =  new BreadthFirstSearch(new TreeSearch());
            SearchAgent agent = new SearchAgent(problem,search);

            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
