import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

import java.lang.reflect.Array;
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
            System.out.println("SERVIDOR s1: " + sa);
            ssp = board.conjunt_servidors(a1);      //nomes em poden tocar servidors que tinguin el fitxer

            a2 = myRandom.nextInt(ssp.size());
            System.out.println("random a2: " + a2);
            s = ssp.get(a2);
            System.out.println("SERVIDOR S2: " + s);

            if (sa != s) {  //comprovo que no sigui el mateix servidor
                ServersBoard emodificat = new ServersBoard(board.getBoard(), board.getBoardtemps());
                emodificat.moure_servidor(a1, s);
                for(int i= 0; i < emodificat.getSize();++i){
                   System.out.println("pet: " + i +" serv: "+  emodificat.getServidor(i));
                }

                double h = Heur.getHeuristicValue(emodificat);
                String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + a1 + " Coste(" + h + ")" ;
                successors.add(new Successor(S, emodificat));
                generat = true;
            }
        }
        return successors;
    }
}