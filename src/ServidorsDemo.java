import IA.DistFS.Servers;

public class ServidorsDemo {
    public static void main(String[] args) {
        int usuaris, max_peticions, seedr, servidors, min_replic, seeds
        Requests requests =  new Requests(usuaris, max_peticions, seedr);
        Servers servers = new Servers(servidors, min_replic, seeds);

        // write your code here
        ServidorsBoard Serv=new ServidorsBoard(requests, servers);
        //algoritmes que utilitzem
        //IAP15BreadthFirstSearch(IAP15);
        //IAP15DepthLimitedSearch(IAP15,7);
        //IAP15IterativeDeepeningSearch(IAP15);
        //IAP15IterativeDeepeningAStarSearchH1(IAP15);
        // IAP15IterativeDeepeningAStarSearchH2(IAP15);
       // IAP15AStarSearchH1(IAP15);
        // IAP15AStarSearchH2(IAP15);
    }
}
