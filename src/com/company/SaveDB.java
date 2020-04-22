package com.company;

import java.sql.Connection;

public class SaveDB {
    Config config = new Config();

    String sendToDB(String rute_awal,String rute_tujuan,String status_rute){
        try {
            String sql = "INSERT INTO rute (rute_awal,rute_tujuan,status_rute) VALUES ('"+rute_awal+"','"+rute_tujuan+"','"+status_rute+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            return "Sukses";

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return "Failed";
    }
}
