import IA.DistFS.Requests;
import IA.DistFS.Servers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class ServersBoard {


    private Requests requests;
    private Servers servers;
    private ArrayList< ArrayList<Integer> > temps;
    private ArrayList< ArrayList<Integer> > serxfitxer;


    private static ArrayList<Integer> Board;

    public static String MOURE = "Moure";

    public ServersBoard(Requests req, Servers serv) {
        requests = req;
        servers = serv;
        int[] prov;
        Set<Integer> prov2;
        Integer tempo, tempo2, max = 0, min_ser = -1;
        ArrayList<Integer> p, q;
        Iterator itr;
        for(int i = 0; i < requests.size(); ++i) {
            prov = requests.getRequest(i);
            prov2 = servers.fileLocations(prov[1]);
            p = null;
            q = null;
            itr = prov2.iterator();
            while (itr.hasNext()){
                tempo = (Integer) itr.next();
                tempo2 =  servers.tranmissionTime(tempo, prov[0]);
                p.add(tempo);
                q.add(tempo2);
                if (tempo2 > max) {
                    max = tempo2;
                    min_ser = tempo;
                }
            }
            temps.add(p);
            serxfitxer.add(q);
            Board.add(min_ser);
        }
    }

    public static ArrayList<Integer> comprova_servidors(Integer p){   //falta implementar
        ArrayList<Integer> posibles_servidors = null;
        //int[] peticio = requests.getRequest(i);
        //return peticio[1];
        //file locations(if_fitxer) = vectors de id de servidors on esta
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
