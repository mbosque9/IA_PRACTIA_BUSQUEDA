import java.util.ArrayList;
import java.util.Random;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class ServersSuccessorFunctionSA implements SuccessorFunction {

    private ArrayList successors = new ArrayList();


    public static int genera_aleatori(int limit) {
        //Genera un nombre aleatori entre 0 i limit-1
        return new Random().nextInt(limit);
    }

    public ArrayList getSuccessors(Object eactual) {
        ServersBoard board = (ServersBoard) eactual;
        boolean generat = false;
        int sa, s, a1, a2;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        while (!generat) {
            a1 = genera_aleatori(npeticions);        //indicara una peticio
            sa = board.getServidor(a1);              //servidor associat a la peticio
            ssp = board.comprova_servidors(sa);      //nomes em poden tocar servidors que tinguin el fitxer
            a2 = genera_aleatori(ssp.size());
            s = ssp.get(a2);
            if (sa != s) {      //comprovo que no siguin el mateix servidor
                ServersBoard emodificat = new ServersBoard(board.getRequests(), board.getServers());
                emodificat.moure_servidor(a1,s);
                String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + a1;
                successors.add(new Successor(S,emodificat));
                generat = true;
            }
        }
        return successors;
    }

}