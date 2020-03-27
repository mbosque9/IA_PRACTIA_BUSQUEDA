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
    ArrayList<Pair<Integer,Integer>> servidors_visitats;


    public double getHeuristicValue(Object state) {
        ServersBoard board=(ServersBoard)state;
        num_fitxer = board.getSize();
        for(int i = 0; i < board.getSize(); ++i) {
            int idServidor = board.getServidor(i);
            suma_temps += board.getTransmissionTime(idServidor,board.getFitxer(i));
            //si un servidor no ha sigut visitat encara, lafageixo a visitats amb 1 cop visitat
            if(!Visitat(idServidor).getKey()) {
                Pair<Integer, Integer> pair = new Pair<>(idServidor, 1);
                servidors_visitats.add(pair);
            }

            //si ja ha sigut visitat, sumo 1 als cops que ho ha estat
           else{
                int pos_servidor = Visitat(idServidor).getValue();
                int num_cops = servidors_visitats.get(pos_servidor).getValue();
                int servidor = servidors_visitats.get(pos_servidor).getKey();
                servidors_visitats.set(pos_servidor, new Pair<>(servidor,num_cops));
            }
        }
        num_servidors = servidors_visitats.size();
        mitjana = num_fitxer/num_servidors;
        variancia = calcularVariancia();

        return suma_temps + (variancia*100*board.getSize());
    }

    private double calcularVariancia() {
        double var = 0;
        for(int i = 0; i < servidors_visitats.size(); ++i){
            int num_cops = servidors_visitats.get(i).getValue();
            var += Math.pow(num_cops - mitjana,2);
        }
        return var/(servidors_visitats.size()-1);
    }

    private Pair< Boolean,Integer> Visitat(int idServidor) {
        //busco si un servidor ja ha sigut visitat, en cas positiu retorno en quina posicio es troba
        int i = 0;
        Pair<Boolean, Integer> pair = new Pair<>(false, -1);
        while (i < servidors_visitats.size() && !pair.getKey()){
            if(servidors_visitats.get(i).equals(idServidor)){
                pair = new Pair<>(true,i);
            }
            ++i;
        }
        return pair;
    }

}
