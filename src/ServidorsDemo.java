import aima.search.framework.Problem;

public class ServidorsDemo {

    public static void main(String[] args) {
        // write your code here
        ServidorsBoard Serv=new ServidorsBoard();
        //algoritmes que utilitzem
        ServidorsHillClimbingSearch(Serv);
        ServidorsSimulatedAnnealingSearch(Serv);
        //IAP15BreadthFirstSearch(IAP15);
        //IAP15DepthLimitedSearch(IAP15,7);
        //IAP15IterativeDeepeningSearch(IAP15);
        //IAP15IterativeDeepeningAStarSearchH1(IAP15);
        // IAP15IterativeDeepeningAStarSearchH2(IAP15);
       // IAP15AStarSearchH1(IAP15);
        // IAP15AStarSearchH2(IAP15);
    }

    private static void ServidorsSimulatedAnnealingSearch(ServidorsBoard serv) {
        try {
            Problem problem =  new Problem(IAP15,new ProbIA15SuccessorFunction(), new ProbIA15GoalTest());
            Search search =  new BreadthFirstSearch(new TreeSearch());
            SearchAgent agent = new SearchAgent(problem,search);

            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ServidorsHillClimbingSearch(ServidorsBoard serv) {

    }
}
