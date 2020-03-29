import aima.search.framework.HeuristicFunction;
import javafx.util.Pair;

import java.util.ArrayList;

public class ServersHeuristicFunction2 implements HeuristicFunction  {

    double suma_temps;
    double mitjana;
    double num_fitxer;
    double servidorsTotals;
    double variancia;
    double h;
    //vector de servidors trobats al estat amb el numero de cops que surt
    int[] servidors;

    public double getHeuristicValue(Object state) {
        ServersBoard board=(ServersBoard)state;
        servidorsTotals = board.getNumServidors();
        servidors = new int[(int) servidorsTotals];
        num_fitxer = board.getSize();
        h = 0;
        for(int i = 0; i < num_fitxer; ++i) {
            ++servidors[board.getServidor(i)];
        }

        suma_temps = board.getTempstotal();
        mitjana = num_fitxer/servidorsTotals;
        variancia = calcularVariancia();
        h = suma_temps;
        return h;

    }

    private double calcularVariancia() {
        double var = 0;
        for(int i = 0; i < servidors.length; ++i){
            int num_cops = servidors[i];
             var += Math.pow(num_cops - mitjana,2);
        }
        return var/servidorsTotals;
    }
}
