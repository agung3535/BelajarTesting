package com.company;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class NodeKota {

    public String stationName;

    NodeKota leftChild;
    NodeKota rightChild;
    NodeKota middleChild;
    NodeKota middleChild2;


    public NodeKota(String stationName, NodeKota firstChild, NodeKota secondChild){
        this.stationName = stationName;
        this.leftChild = firstChild;
        this.rightChild = secondChild;

    }

    public ArrayList<NodeKota> getChildren(){
        ArrayList<NodeKota> childNodeKotas = new ArrayList<>();
        if(this.leftChild != null)
        {
            childNodeKotas.add(leftChild);
        }
        if(this.rightChild != null) {
            childNodeKotas.add(rightChild);
        }
        if(this.middleChild != null) {
            childNodeKotas.add(middleChild);
        }
        if(this.middleChild2 != null) {
            childNodeKotas.add(middleChild2);
        }
        return childNodeKotas;
    }
    //    An auxiliary function which allows
//    us to remove any child nodes from
//    our list of child nodes.
    public boolean removeChild(NodeKota n){
        return false;
    }

}


public class BFS {
    Config config = new Config();
    SaveDB saveDB = new SaveDB();
    NodeKota startNodeKota;
    NodeKota goalNodeKota;

    public BFS(NodeKota startNodeKota, NodeKota goalNodeKota) {
        this.startNodeKota = startNodeKota;
        this.goalNodeKota = goalNodeKota;
    }

    public String[] compute() {
        String []hasil;
        String []status = new String[1];
        String []kosong = new String[1];
        String []empty = new String[1];
        kosong[0] = "gagal";
        empty[0] = "Tidak ada child";
        if (this.startNodeKota.equals(goalNodeKota)) {
            System.out.println("Goal Node Found!");
            status[0]= "Goal Node Found!";
            saveDB.sendToDB(this.startNodeKota.stationName.toString(),this.goalNodeKota.stationName.toString(),"Rute dapat terhubung");
            return status;
        }
        Queue<NodeKota> queue = new LinkedList<>();
        ArrayList<NodeKota> explored = new ArrayList<>();
        if (this.startNodeKota.stationName != null && this.goalNodeKota.stationName !=null){
            queue.add(this.startNodeKota);
            //explored.add(startNode);
            while (!queue.isEmpty()) {
                NodeKota current = queue.remove();
                if (current.equals(this.goalNodeKota)) {
                    //System.out.println(explored);
                    explored.add(current);
                    hasil = new String[explored.size()];
                    for (int i=0;i<explored.size();i++){
                        hasil[i] = explored.get(i).stationName;
//                    System.out.println("Data dalam array ke"+i+" = "+hasil[i]);
                        System.out.println("Penelurusan "+i+" = "+hasil[i]);
                        if (hasil[i].equals(goalNodeKota.stationName)){
                            System.out.println("Path Found");
                            saveDB.sendToDB(this.startNodeKota.stationName.toString(),this.goalNodeKota.stationName.toString(),"Rute dapat terhubung");
                        }
                    }
//                return current.getChildren().
                    return hasil;
                } else {
                    if (current.getChildren().isEmpty()){
                        System.out.println("Tidak ada child");
//                        sendToDB(this.startNodeKota.stationName.toString(),this.goalNodeKota.stationName.toString(),"Rute tidak dapat terhubung");
                        return empty;
                    }
                    else {
                        queue.addAll(current.getChildren());
                    }
                }
                explored.add(current);
            }
        }else {
            System.out.println("Gagal");
//            sendToDB(this.startNodeKota.stationName.toString(),this.goalNodeKota.stationName.toString(),"Rute tidak dapat terhubung");
            return kosong;
        }


        return kosong;
    }

//    String sendToDB(String rute_awal,String rute_tujuan,String status_rute){
//        try {
//            String sql = "INSERT INTO rute (rute_awal,rute_tujuan,status_rute) VALUES ('"+rute_awal+"','"+rute_tujuan+"','"+status_rute+"')";
//            java.sql.Connection conn=(Connection)config.configDB();
//            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
//            pst.execute();
//            return "Sukses";
//
//        } catch (Exception e) {
//            System.err.println("Got an exception!");
//            System.err.println(e.getMessage());
//        }
//        return "Failed";
//    }
}
