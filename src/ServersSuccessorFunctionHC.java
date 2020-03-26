import java.util.ArrayList;
import java.util.Random;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class ServersSuccessorFunctionHC {

    private ArrayList successors = new ArrayList();


    public ArrayList genera_successors(Object eactual) {
        ServersBoard board = (ServersBoard) eactual;
        int sa, s;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        for (int i = 0; i < npeticions; i++) {
            sa = board.getServidor(i);
            ssp = board.comprova_servidors(sa);
            for (int j = 0; j < ssp.size(); j++) {      //recorro cada servidor que te el fitxer
                s = ssp.get(j);
                if (sa != s) {      //comprovo que no siguin el mateix servidor
                    ServersBoard emodificat = new ServersBoard(board.getRequests(), board.getServers());;
                    emodificat.moure_servidor(i,s);       //a la posició i vull posar el nou servidor s
                    String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + i;
                    successors.add(new Successor(S,emodificat));
                }
            }
        }
        return successors;
    }

}