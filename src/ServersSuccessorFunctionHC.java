import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;

public class ServersSuccessorFunctionHC implements SuccessorFunction {

    public List<Successor> getSuccessors(Object eactual) {
        ArrayList<Successor> successors = new ArrayList<>();
        ServersBoard board = (ServersBoard) eactual;
        ServersHeuristicFunction Heur = new ServersHeuristicFunction();
        ServersHeuristicFunction Heur2 = new ServersHeuristicFunction();
        double h2 = Heur.getHeuristicValue(board);
        System.out.println("heu value: " + h2);

        Integer sa, s, t;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        for (int i = 0; i < npeticions; i++) {
            sa = board.getServidor(i);
            ssp = board.conjunt_servidors(i);
            System.out.println("servidor estat: " + sa);
            for (int j = 0; j < ssp.size(); j++) {      //recorro cada servidor que te el fitxer
                s = ssp.get(j);
                t = board.getTemps(i, s);
                System.out.println("servidor posible: " + s);
                if (sa != s) {      //comprovo que no siguin el mateix servidor
                    System.out.println("entro if ");
                    ServersBoard emodificat = new ServersBoard(board.getBoard(), board.getBoardtemps());
                    emodificat.moure_servidor(i,s, t);       //a la posició i vull posar el nou servidor s
                    for (int a = 0; a < emodificat.getSize(); a++) {
                        System.out.println("La peticio  "+ a + "  te assignat el servidor  " + emodificat.getServidor(a));
                    }
                    double h = Heur.getHeuristicValue(emodificat);
                    System.out.println("heu value: " + h);
                    String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + i + " Coste(" + h + ") ----> " + emodificat.toString();
                    successors.add(new Successor(S,emodificat));
                }
            }
        }
        return (successors);
    }

}