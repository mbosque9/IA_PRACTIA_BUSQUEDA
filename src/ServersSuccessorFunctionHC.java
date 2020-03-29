import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class ServersSuccessorFunctionHC implements SuccessorFunction {

    public List<Successor> getSuccessors(Object eactual) {
        ArrayList<Successor> successors = new ArrayList<>();
        ServersBoard board = (ServersBoard) eactual;
        ServersHeuristicFunction Heur = new ServersHeuristicFunction();
       // ServersHeuristicFunction2 Heur2 = new ServersHeuristicFunction2();
        //ServersHeuristicFunction3 Heur3 = new ServersHeuristicFunction3();


        Integer sa, s, t;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;
        for (int i = 0; i < npeticions; i++) {
            sa = board.getServidor(i);
            ssp = board.conjunt_servidors(i);
            for (int j = 0; j < ssp.size(); j++) {      //recorro cada servidor que te el fitxer
                s = ssp.get(j);
                t = board.getTemps(i, s);
                if (sa != s) {      //comprovo que no siguin el mateix servidor
                    ServersBoard emodificat = new ServersBoard(board.getBoard(), board.getBoardtemps());
                    emodificat.moure_servidor(i,s, t);       //a la posició i vull posar el nou servidor s
                    double h = Heur.getHeuristicValue(emodificat);
                   // double h2 = Heur2.getHeuristicValue(emodificat);
                   // double h3 = Heur3.getHeuristicValue(emodificat);

                    String S = ServersBoard.MOURE + " el servidor " + s + " a la petició " + i + " Coste (" + h + ")";
                    successors.add(new Successor(S,emodificat));
                }
            }
        }
        return (successors);
    }

    //intercanviar
   /* public List<Successor> getSuccessors(Object eactual) {
        ArrayList<Successor> successors = new ArrayList<>();
        ServersBoard board = (ServersBoard) eactual;
        ServersHeuristicFunction Heur = new ServersHeuristicFunction();
        ServersHeuristicFunction2 Heur2 = new ServersHeuristicFunction2();
        double hh = Heur2.getHeuristicValue(board);
        Integer sa, s;
        int npeticions = board.getSize();
        for (int i = 0; i < npeticions; i++) {
            sa = board.getServidor(i);
            for (int j = 0; j < npeticions; j++) {      //recorro cada servidor que te el fitxer
                s = board.getServidor(j);
                if (i != j && sa != s && board.comprova(i, s) && board.comprova(j, sa)) {      //comprovo que no siguin el mateix servidor
                    ServersBoard emodificat = new ServersBoard(board.getBoard(), board.getBoardtemps());
                    emodificat.intercanviar(sa, j, s, i);       //a la posició i vull posar el nou servidor s
                    double h = Heur.getHeuristicValue(emodificat);
                    String S = ServersBoard.MOURE + " el servidor " + sa + " a la petició " + j + " i " + ServersBoard.MOURE + " el servidor " + s + " a la petició " + i + " Coste (" + h + ")";
                    successors.add(new Successor(S,emodificat));
                }
            }
        }
        return (successors);
    }*/
}