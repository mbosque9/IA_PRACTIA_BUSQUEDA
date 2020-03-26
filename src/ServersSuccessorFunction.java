import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class ServersSuccessorFunction {

    private ArrayList successors = new ArrayList();


    public static int genera_aleatori(int limit) {
        //Genera un nombre aleatori entre 0 i limit-1
        return new Random().nextInt(limit);
    }

    public ArrayList genera_successors(Object eactual) {
        ServersBoard board = (ServersBoard) eactual;
        //sha de fer que emodificat sigui un new ServersBoard(board.getRequest, board.getServsers)
        ServersBoard emodificat;
        int sa, s;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        for (int i = 0; i < npeticions; i++) {
            sa = board.getServidor(i);
            ssp = board.comprova_servidors(sa);
            for (int j = 0; j < ssp.size(); j++) {      //recorro cada servidor que te el fitxer
                s = ssp.get(j);
                if (sa != s) {      //comprovo que no siguin el mateix servidor
                    emodificat = board;
                    emodificat.moure_servidor(i,s);       //A la posició i vull posar el nou servidor s
                    successors.add(new Successor(emodificat));      //com transpes pero espera 2 params CERC QUE SHA DE FICAR UN STRING DE QUIN MOVIMENT HAS FET
                }
            }
            return successors;
        }
    }

    public ArrayList genera_successors_aleatori(Object eactual) {
        ServersBoard board = (ServersBoard) eactual;
        ServersBoard emodificat;
        boolean generat = false;
        int sa, s, a1, a2;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        while (!generat) {
            a1 = genera_aleatori(npeticions);        //indicara una peticio
            sa = board.getServidor(a1);                      //servidor associat a la peticio
            ssp = board.comprova_servidors(sa);    //nomes em poden tocar servidors que tinguin el fitxer
            a2 = genera_aleatori(ssp.size());
            s = ssp.get(a2);
            if (sa != s) {      //comprovo que no siguin el mateix servidor
                emodificat = board;
                emodificat.moure_servidor(a1,s);
                successors.add(new Successor(emodificat));      //com transpes pero espera 2 params
                generat = true;
            }
        }
        return successors;
    }

}