import javafx.util.Pair;

import java.util.ArrayList;

public class ServersBoard {

    private Requests requests;
    private Servers servers;
    private ArrayList< ArrayList<Integer> > temps;
    private ArrayList< ArrayList<Integer> > serxfitxer;

    private ArrayList<Integer> Board;

    public ServersBoard(Requests req, Servers serv) {
        requests = req;
        servers = serv;
        Vector<int> prov, prov2;
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

    public static void intercanviar_fitxers(Integer id1, Integer s2, Integer id2, Integer s){
        //HOLA
    }

    public static void moure_fitxer(Integer idFitxer, Integer idServidor){
//heeeeeey
    }

    public static boolean moure_comprovat(Integer fitxer, Integer servidor){

    }

    public static boolean intercanviar_comprovat(Integer fitxer, Integer servidor){

    }
}
