import IA.DistFS.Requests;
import IA.DistFS.Servers;
import aima.search.framework.Metrics;
import javafx.util.Pair;

import java.util.ArrayList;

public class ServersBoard {


    private Requests requests;
    private Servers servers;
    private ArrayList< ArrayList<Integer> > temps;
    private ArrayList< ArrayList<Integer> > serxfitxer;

    private static ArrayList<Integer> Board;

    public static String MOURE = "Moure";

    public ServersBoard(){

    }
    public ServersBoard(Requests req, Servers serv) {
        requests = req;
        servers = serv;
        int[] prov, prov2;
        Pair<Integer, Integer> temp;
        for(int i = 0; i < requests.size(); ++i) {
            prov = requests.getRequest(i);
            prov2 = servers.fileLocations(prov[1]);
            for (int j = 0; prov2.size(); ++j){
                temp._1() = prov2[j];
                temp._2() = servers.transmissionTime(prov2[j], prov[0]);
                if (eda.get(i).size() == 0) eda[i].add(temp);
                else {
                    for(int k = 0; k < eda.get(i).size(); ++k){
                        if(eda.get(i).get(k) )
                    }
                }
            }
        }
    }

    public static ArrayList<Integer> comprova_servidors(Integer p){   //falta implementar
        ArrayList<Integer> posibles_servidors = null;
        return posibles_servidors;
    }

    public static void moure_servidor(int i, int s) {  //fet
        Board.set(i,s);
    }

    public Requests getRequests() {     //fet
        return requests;
    }

    public Servers getServers(){        //fet
        return servers;
    }

    public int getSize(){           //fet
        return Board.size();
    }

    public int getServidor(int i) {     //fet
        //donat la peticio numero i vull saber el fixter associat
        int[] peticio = requests.getRequest(i);
        return peticio[1];
    }
}
