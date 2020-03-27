import java.util.ArrayList;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class ServersSuccessorFunctionHC implements SuccessorFunction {

    private ArrayList successors = new ArrayList();


    public ArrayList getSuccessors(Object eactual) {
        ServersBoard board = (ServersBoard) eactual;
        int sa, s;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        for (int i = 0; i < npeticions; i++) {
            sa = board.getServidor(i);
            ssp = board.conjunt_servidors(i);
            for (int j = 0; j < ssp.size(); j++) {      //recorro cada servidor que te el fitxer
                s = ssp.get(j);
                if (sa != s) {      //comprovo que no siguin el mateix servidor
                    ServersBoard emodificat = board;
                    emodificat.moure_servidor(i,s);       //a la posició i vull posar el nou servidor s
                    String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + i;
                    successors.add(new Successor(S,emodificat));
                }
            }
        }
        return successors;
    }

}