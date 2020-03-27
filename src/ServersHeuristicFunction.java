import aima.search.framework.HeuristicFunction;


public class ServersHeuristicFunction implements HeuristicFunction  {

    public double getHeuristicValue(Object state) {
        ServersBoard board = (ServersBoard) state;
        int tmax = 0;
        int s, uID, tt;
        int[] ip;
        System.out.println(board.getSize());
        for (int i = 0; i < board.getSize(); i++) {
            s = board.getServidor(i);
            ip = board.getRequest(i);    //arraylist amb info petició (userID, fileID)
            uID = ip[0];                //m'interessa el userID
            tt = board.getTransmissionTime(s,uID);     //retorna el tt del servidor s a l'usuari uID
            if (tt > tmax) tmax = tt;
        }
        return tmax;
    }


}
