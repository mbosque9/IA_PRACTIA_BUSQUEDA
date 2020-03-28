import aima.search.framework.HeuristicFunction;
import javafx.util.Pair;

import java.util.ArrayList;

public class ServersHeuristicFunction2 implements HeuristicFunction  {

    double suma_temps;
    double mitjana;
    double num_fitxer;
    double num_servidors;
    double servidorsTotals;
    double variancia;
    //vector de servidors trobats al estat amb el numero de cops que surt
    ArrayList<Integer> visitats ;
    ArrayList<Integer> cops;

    public double getHeuristicValue(Object state) {
        ServersBoard board=(ServersBoard)state;
        servidorsTotals = board.getNumServidors();
        num_fitxer = board.getSize();
        num_servidors = 0;
        visitats = new ArrayList<>();
        cops = new ArrayList<>();
        suma_temps = 0;

        for(int i = 0; i < num_fitxer; ++i) {
            int idServidor = board.getServidor(i);
            if (i== 0){
                visitats.add(idServidor);
                cops.add(1);
            }
            else {
                suma_temps += board.getTransmissionTime(idServidor, board.getFitxer(i));
                //si un servidor no ha sigut visitat encara, lafageixo a visitats amb 1 cop visitat
                if (!(vist(idServidor))) {
                    visitats.add(idServidor);
                    cops.add(1);
                }
                //si ja ha sigut visitat, sumo 1 als cops que ho ha estat
                else {
                    int pos_servidor = pos(idServidor);
                    int num_cops = cops.get(pos_servidor);
                    cops.set(pos_servidor, ++num_cops);
                }
            }
        }


        num_servidors = visitats.size();
        mitjana = num_fitxer/servidorsTotals;
        variancia = calcularVariancia();

        double h = suma_temps + (variancia*100*board.getSize());
        System.out.println("h: " + h);
        return h;

    }

    private double calcularVariancia() {
        double var = 0;
        for(int i = 0; i < visitats.size(); ++i){
            int num_cops = cops.get(i);
            var += Math.pow(num_cops - mitjana,2);
        }
        return var/(visitats.size());
    }


    private  boolean vist(int s){
        boolean trobat = false;
        int i = 0;
        while(i < visitats.size() && !trobat){
            if(visitats.get(i).equals(s)) trobat = true;
            ++i;
        }
        return trobat;
    }

    private int pos(int s){
        int sol = -1;
        for(int i = 0; i<visitats.size(); ++i){
            if(visitats.get(i).equals(s)) sol = i;
        }
        return sol;
    }

}
