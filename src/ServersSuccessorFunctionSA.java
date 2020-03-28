import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServersSuccessorFunctionSA implements SuccessorFunction {

    private ArrayList successors = new ArrayList();


    public static int genera_aleatori(int limit) {
        //Genera un nombre aleatori entre 0 i limit-1
        return new Random().nextInt(limit);
    }

    public List getSuccessors(Object eactual) {

        ArrayList<Successor> successors = new ArrayList<>();
        ServersBoard board = (ServersBoard) eactual;
        ServersHeuristicFunction Heur = new ServersHeuristicFunction();
        Random myRandom = new Random();

        boolean generat = false;
        int sa, s, a1, a2;
        int npeticions = board.getSize();
        ArrayList<Integer> ssp;

        while(!generat) {

            a1 = myRandom.nextInt(npeticions); //num peticio random
            System.out.println("random a1: " + a1);

            sa = board.getServidor(a1); //servidor associat a la peticio
            ssp = board.conjunt_servidors(a1);      //nomes em poden tocar servidors que tinguin el fitxer

            for(int i = 0; i< ssp.size(); ++i){
                System.out.println("servidor a provar: " + ssp.get(i));
            }

            a2 = myRandom.nextInt(ssp.size());
            System.out.println("random a2: " + a1);
            s = ssp.get(a2);
            System.out.println("SERVIDOR ESCOLLIT: " + s);

            if (sa != s) {  //comprovo que no sigui el mateix servidor
                ServersBoard emodificat = new ServersBoard(board.getBoard(), board.getBoardtemps());
                emodificat.moure_servidor(a1, s);
                double h = Heur.getHeuristicValue(emodificat);
                String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + a1 + " Coste(" + h + ") ----> " + emodificat.toString();
                successors.add(new Successor(S, emodificat));
                generat = true;
            }
        }
        return successors;
    }
}