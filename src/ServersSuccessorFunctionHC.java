import java.util.ArrayList;
import java.util.List;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class ServersSuccessorFunctionHC implements SuccessorFunction {

    public List getSuccessors(Object eactual) {
        ArrayList successors = new ArrayList();
        ServersBoard board = (ServersBoard) eactual;

      //  System.out.println("\nENTRO HC, L'ESTAT ACTUAL ES-----------------------------------------------------------------------------------");
        for (int a = 0; a < board.getSize(); a++) {
          //  System.out.println("La peticio  "+ a + "  te assignat el servidor  " + board.getServidor(a));
        }

        int sa, s;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        for (int i = 0; i < npeticions; i++) {
            sa = board.getServidor(i);
            ssp = board.conjunt_servidors(i);
            for (int j = 0; j < ssp.size(); j++) {      //recorro cada servidor que te el fitxer
                s = ssp.get(j);
                if (sa != s) {      //comprovo que no siguin el mateix servidor
                    ServersBoard emodificat = new ServersBoard(board.getRequests(), board.getServers(), board.getBoard());

                   // System.out.println("\n\n-----------------------------------------------------------------------------------");
                    //System.out.println("\nL'estat emodificat es (hauria de ser el actual):");
                    for (int a = 0; a < emodificat.getSize(); a++) {                                                                            //CANVIEU BOARD. PER EMODIFICAT
                      //  System.out.println("La peticio  "+ a + "  te assignat el servidor  " + emodificat.getServidor(a));                     //CANVIEU BOARD. PER EMODIFICAT
                    }

                    emodificat.moure_servidor(i,s);       //a la posició i vull posar el nou servidor s

                    String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + i;
                    successors.add(new Successor(S,emodificat));

                   // System.out.println("-----\nMoc el servidor " + s + " a la petició" + i);
                    for (int a = 0; a < emodificat.getSize(); a++) {
                       // System.out.println("La peticio  "+ a + "  te assignat el servidor  " + emodificat.getServidor(a));
                    }
                }
            }
        }
        return successors;
    }

}