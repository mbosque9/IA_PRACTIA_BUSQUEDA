import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class ServersSuccessorFunctionHC implements SuccessorFunction {

    public List<Successor> getSuccessors(Object eactual) {
        ArrayList<Successor> successors = new ArrayList<>();
        ServersBoard board = (ServersBoard) eactual;
        ServersHeuristicFunction Heur = new ServersHeuristicFunction();

        int sa, s;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        for (int i = 0; i < npeticions; i++) {
            sa = board.getServidor(i);
            ssp = board.conjunt_servidors(i);
            for (int j = 0; j < ssp.size(); j++) {      //recorro cada servidor que te el fitxer
                s = ssp.get(j);
                if (sa != s) {      //comprovo que no siguin el mateix servidor
                    ServersBoard emodificat = new ServersBoard(board.getBoard(), board.getBoardtemps());
                    emodificat.moure_servidor(i,s);       //a la posició i vull posar el nou servidor s
                    for (int a = 0; a < emodificat.getSize(); a++) {
                        System.out.println("La peticio  "+ a + "  te assignat el servidor  " + emodificat.getServidor(a));
                    }
                    double h = Heur.getHeuristicValue(emodificat);
                    String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + i + " Coste(" + h + ") ----> " + emodificat.toString();
                    successors.add(new Successor(S,emodificat));
                }
            }
        }
        return (successors);
    }

}