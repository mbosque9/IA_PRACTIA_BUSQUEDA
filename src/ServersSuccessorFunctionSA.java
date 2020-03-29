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

    /*public List getSuccessors(Object eactual) {
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
                ServersBoard emodificat = new ServersBoard(board.getBoard(), board.getBoardtemps(), board.getTempstotal());
                emodificat.moure_servidor(a1, s);
                for(int i= 0; i < emodificat.getSize();++i){
                    System.out.println("pet: " + i +" serv: "+  emodificat.getServidor(i));
                }

                double h = Heur.getHeuristicValue(emodificat);
                String S = ServersBoard.MOURE + " el servidor " + s + " a la petició" + a1 + " Heuristica: " + h3 + ", temps: " + board.getTempstotal() ;
                successors.add(new Successor(S, emodificat));
                generat = true;
            }
        }
        return successors;
    }*/

    public List getSuccessors(Object eactual) {
        ArrayList<Successor> successors = new ArrayList<>();
        ServersBoard board = (ServersBoard) eactual;
        ServersHeuristicFunction Heur = new ServersHeuristicFunction();
        Random myRandom = new Random();

        boolean generat = false;
        Integer sa, s, a1, a2;
        int npeticions = board.getSize();
        while(!generat) {
            a1 = myRandom.nextInt(npeticions);
            a2 = myRandom.nextInt(npeticions);
            s = board.getServidor(a1);
            sa = board.getServidor(a2);
            if (a1 != a2 && s!= sa && board.comprova(a1, sa) && board.comprova(a2,s)) {
                ServersBoard emodificat = new ServersBoard(board.getBoard(), board.getBoardtemps(), board.getTempstotal());
                emodificat.intercanviar(s, a2, sa, a1);
                double h = Heur.getHeuristicValue(emodificat);
                String S = ServersBoard.MOURE + " el servidor " + s + " a la petició " + a2 + " i " + ServersBoard.MOURE + " el servidor " + sa + " a la petició " + a1 + " Heuristica: " + h + ", temps: " + board.getTempstotal();
                successors.add(new Successor(S, emodificat));
                generat = true;
            }
        }
        return successors;
    }
}