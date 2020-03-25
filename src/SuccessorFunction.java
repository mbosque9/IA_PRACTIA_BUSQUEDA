import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class ServidorSuccessorFunction {

    private List successors;  //ArrayList<Board>

    public static int genera_aleatori(int limit) {
        //Genera un nombre aleatori entre 0 i limit-1
        return new Random().nextInt(limit);
    }

    public List genera_successors(Board eactual) {
        Board emodificat = eactual;
        int nservidors = eactual.size();
        int nfitxers;

        for (int s = 0; s < nservidors; s++) {
            nfitxers = eactual.get(s).size();
            for (int f = 0; f < nfitxers; f++) {
                for (int s2 = 0; s2 != s && s2 < nservidors; s2++) {
                    if (ServidorsBoard.moure_comprovat(f, s2)) {        //moure
                        emodificat = ServidorsBoard.moure_fitxer(f, s2);
                        successors.add(emodificat);
                    }
                    else if (ServidorsBoard.intercanviar_comprovat(f, s2, f2, s) && op == 1) {        //intercanviar
                        emodificat = ServidorsBoard.intercanviar_fitxers(f, s2, f2, s);
                        successors.add(emodificat);
                    }
                }
            }
        }
        return successors;
    }

    public List genera_successors_aleatori(Board eactual) {
        boolean generat = false;
        int nservidors = eactual.size();
        int nfitxers = eactual.get(s).size();

        while (not generat) {
            int op = genera_aleatori(2);    //0 mou, 1 intercanvia
            int s = genera_aleatori(nservidors);
            int f = genera_aleatori(nfitxers);    //trio un fitxer random del servidor que m'ha sortit
            int s2 = genera_aleatori(nservidors);

            if (ServidorsBoard.moure_comprovat(f, s2) && op == 0) {
                    eactual = ServidorsBoard.moure_fitxer(f, s2);
                    successors.add(eactual);
                    generat = true;
            }
            else if (op == 1) {
                int f2 = genera_aleatori(eactual.get(s2).size());
                if (ServidorsBoard.intercanviar_comprovat(f, s2, f2, s)) {
                    eactual = ServidorsBoard.intercanviar_fitxers(f, s2, f2, s);
                    successors.add(eactual);
                    generat = true;
                }
            }
        }
        return successors;
    }

}