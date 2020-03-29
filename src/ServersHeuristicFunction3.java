import aima.search.framework.HeuristicFunction;

public class ServersHeuristicFunction3 implements HeuristicFunction {

    public double getHeuristicValue(Object state) {
        ServersBoard board = (ServersBoard) state;
        ServersHeuristicFunction Heur = new ServersHeuristicFunction();
        ServersHeuristicFunction2 Heur2 = new ServersHeuristicFunction2();
        double hh = Heur2.getHeuristicValue(board);
        double h = Heur.getHeuristicValue(board);
        return (h + hh);
    }

}
