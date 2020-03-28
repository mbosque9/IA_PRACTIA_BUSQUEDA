import IA.DistFS.Requests;
import IA.DistFS.Servers;

import java.util.*;

public class ServersBoard {


    private static Requests requests;
    private static Servers servers;
    private  ArrayList<Integer> Board = new ArrayList<Integer>();
    private  ArrayList<Integer> Boardtemps = new ArrayList<Integer>();

    public static String MOURE = "Moure";

    /*public ServersBoard(Requests req, Servers serv) {
        requests = req;
        servers = serv;
        int[] prov;
        Set<Integer> prov2;
        Integer tempo, tempo2, max, min_ser;
        Iterator itr;
        for(int i = 0; i < requests.size(); ++i) {
            max = 500000000;
            min_ser = -1;
            prov = requests.getRequest(i);
            prov2 = servers.fileLocations(prov[1]);
            itr = prov2.iterator();
            while (itr.hasNext()){
                tempo = (Integer) itr.next();
                tempo2 =  servers.tranmissionTime(tempo, prov[0]);
                if (tempo2 < max) {
                    max = tempo2;
                    min_ser = tempo;
                }
            }
            Board.add(min_ser);
            Boardtemps.add(max);
        }
        System.out.println("mida b: " + Board.size());
        for (int a = 0; a < Board.size(); a++) {
            System.out.println("La peticio  "+ a + "  te assignat el servidor  " + Board.get(a));
        }
        System.out.println("requests: ");
        for (int i = 0; i<requests.size(); ++i){
            System.out.println("fitxer: " + getFitxer(i) + " usuari: " + getUsuari(i));
        }
    }*/

    public ServersBoard(final ArrayList<Integer> bor, ArrayList<Integer> temps) {
        this.Board = (ArrayList<Integer>) bor.clone();
        this.Boardtemps = (ArrayList<Integer>) temps.clone();
    }

    public ServersBoard(Requests req, Servers serv) {
        requests = req;
        servers = serv;
        int[] prov;
        Set<Integer> prov2;
        Iterator itr;
        for(int i = 0; i < requests.size(); ++i) {
            prov = requests.getRequest(i);
            prov2 = servers.fileLocations(prov[1]);
            itr = prov2.iterator();
            if (itr.hasNext()){
                Integer p = (Integer) itr.next();
                Board.add(p);
                Boardtemps.add(servers.tranmissionTime(p, getUsuari(i)));
            }
        }
        for (int a = 0; a < Board.size(); a++) {
            System.out.println("La peticio  "+ a + "  te assignat el servidor  " + Board.get(a));
        }
    }

    public ArrayList<Integer> conjunt_servidors(Integer p){   //fet
        ArrayList<Integer> posibles_servidors = new  ArrayList<Integer>();
        Set<Integer> servidors = servers.fileLocations(getFitxer(p));
        posibles_servidors.addAll(servidors);
        return posibles_servidors;
    }

    public  void moure_servidor(Integer i, Integer s, Integer t) {  //fet
        Board.set(i,s);
        Boardtemps.set(i,t);
    }

    public  void moure_servidor(Integer i, Integer s) {  //forrraaa
        Board.set(i, s);
    }

    public Integer getTemps(int i, Integer p) {
             return servers.tranmissionTime(p, getUsuari(i));
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

    public int getFitxer(int i) {     //fet
        //donat la peticio numero i vull saber el fitxer associat
        int[] peticio = requests.getRequest(i);
        return peticio[1];
    }
    public int getUsuari(int i) {     //fet
        //donat la peticio numero i vull saber el fitxer associat
        int[] peticio = requests.getRequest(i);
        return peticio[0];
    }


    public int[] getRequest(int i) {
        System.out.println("i: " + i);
        return requests.getRequest(i);
    }

    public int getTransmissionTime(int s, int fID) {
        return servers.tranmissionTime(s,fID);
    }

    public int getServidor(int i) {
       return Board.get(i);
    }

    public int getTempsServidor(int i) {
        return Boardtemps.get(i);
    }

    public ArrayList<Integer> getBoard() {
        return (ArrayList<Integer>) Board.clone();
    }

    public ArrayList<Integer> getBoardtemps() {
        return (ArrayList<Integer>) Boardtemps.clone();
    }

}
