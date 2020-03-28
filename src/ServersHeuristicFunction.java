import aima.search.framework.HeuristicFunction;


public class ServersHeuristicFunction implements HeuristicFunction  {

    public double getHeuristicValue(Object state) {
        ServersBoard board = (ServersBoard) state;
        int tmax = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (tmax < board.getTempsServidor(i)) tmax = board.getTempsServidor(i);
        }
        return tmax;
    }


}
