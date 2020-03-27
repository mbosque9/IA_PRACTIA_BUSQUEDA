import aima.search.framework.HeuristicFunction;
import javafx.util.Pair;

import java.util.ArrayList;

public class ServersHeuristicFunction2 implements HeuristicFunction  {

    double suma_temps = 0;
    double mitjana;
    int num_fitxer;
    int num_servidors = 0;
    double variancia;
    //vector de servidors trobats al estat amb el numero de cops que surt
    ArrayList<Integer> visitats = new ArrayList<Integer>();
    ArrayList<Integer> cops = new ArrayList<Integer>();

    public double getHeuristicValue(Object state) {
        ServersBoard board=(ServersBoard)state;
        num_fitxer = board.getSize();
        num_servidors = 0;
        for(int i = 0; i < board.getSize(); ++i) {
            int idServidor = board.getServidor(i);
            if (i== 0){
                visitats.add(idServidor);
                cops.add(1);
            }

            suma_temps += board.getTransmissionTime(idServidor,board.getFitxer(i));
            //si un servidor no ha sigut visitat encara, lafageixo a visitats amb 1 cop visitat
            if(!vist(idServidor)) {
                visitats.add(idServidor);
                cops.add(1);
            }
            //si ja ha sigut visitat, sumo 1 als cops que ho ha estat
           else{
                int pos_servidor = pos(idServidor);
                int num_cops = cops.get(pos_servidor);
                cops.set(pos_servidor,num_cops++);
            }
        }
        num_servidors = visitats.size();
        mitjana = num_fitxer/num_servidors;
        variancia = calcularVariancia();

        return suma_temps + (variancia*100*board.getSize());
    }

    private double calcularVariancia() {
        double var = 0;
        for(int i = 0; i < visitats.size(); ++i){
            int num_cops = cops.get(i);
            var += Math.pow(num_cops - mitjana,2);
        }
        return var/(visitats.size()-1);
    }

    /*private Pair< Boolean,Integer> Visitat(int idServidor) {
        //busco si un servidor ja ha sigut visitat, en cas positiu retorno en quina posicio es troba
        int i = 0;
        System.out.println("ser: " + idServidor);
        Pair<Boolean, Integer> pair = new Pair<>(false, -1);
        while (i < num_servidors && !pair.getKey()){
            if(servidors_visitats.get(i).getKey().equals(idServidor)){
                pair = new Pair<>(true,i);
            }
            ++i;
        }
        return pair;
    }*/

    private  boolean vist(int s){
        boolean trobat = false;
        int i = 0;
        while(i < visitats.size() && !trobat){
            if(visitats.get(i).equals(s)) trobat = true;
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
