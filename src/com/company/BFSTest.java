package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @BeforeEach
    void init() {
        NodeKota tujuanKosong = new NodeKota(null,null,null);
        NodeKota kotakosong = new NodeKota(null,null,null);
        NodeKota kotaF = new NodeKota("Kota F",null,null);
        NodeKota kotaE = new NodeKota("Kota E",null,null);
        NodeKota kotaD = new NodeKota("Kota D",null,null);
        NodeKota kotaC = new NodeKota("Kota C",kotaF,null);
        NodeKota kotaB = new NodeKota("Kota B",kotaD,kotaE);
        NodeKota kotaA = new NodeKota("Kota A",kotaB,kotaC);

        Main main = new Main();

        kotaA.leftChild = kotaB;
        kotaA.rightChild = kotaC;
        kotaB.leftChild = kotaD;
        kotaB.rightChild = kotaE;
        kotaC.rightChild = kotaF;
        kotaD.leftChild = kotaB;




        BFS bfs = new BFS(kotaA,kotaE);
        BFS bfs2 = new BFS(kotaA,kotaA);
        BFS bfs3 = new BFS(kotaF,kotaE);
        BFS bfs1 = new BFS(kotakosong,tujuanKosong);
        String [] expectedResult = {"Kota A", "Kota B", "Kota C", "Kota D", "Kota E"};
        String [] resultfailed = {"Tidak ada child"};
        String [] resultFoundAtFirst = {"Goal Node Found!"};
        String [] failed = {"gagal"};

        assertEquals(Arrays.toString(failed), Arrays.toString(bfs1.compute()),"[Gagal]");
        System.out.println("---------------------------");
        assertEquals(Arrays.toString(resultFoundAtFirst), Arrays.toString(bfs2.compute()));

        System.out.println("---------------------------");
        assertEquals(Arrays.toString(resultfailed),Arrays.toString(bfs3.compute()),"[Tidak ada child]");
        System.out.println("---------------------------");
        assertEquals(Arrays.toString(expectedResult),Arrays.toString(bfs.compute()),"[Kota A, Kota B, Kota C, Kota D, Kota E]");




    }
    @Test
    void Test(){
        System.out.println("Masuk Test");
        NodeKota tujuanKosong = new NodeKota(null,null,null);
        NodeKota kotakosong = new NodeKota(null,null,null);
        NodeKota kotaF = new NodeKota("Kota F",null,null);
        NodeKota kotaE = new NodeKota("Kota E",null,null);
        NodeKota kotaD = new NodeKota("Kota D",null,null);
        NodeKota kotaC = new NodeKota("Kota C",kotaF,null);
        NodeKota kotaB = new NodeKota("Kota B",kotaD,kotaE);
        NodeKota kotaA = new NodeKota("Kota A",kotaB,kotaC);

        SaveDB saveDB = new SaveDB();

        kotaA.leftChild = kotaB;
        kotaA.rightChild = kotaC;
        kotaB.leftChild = kotaD;
        kotaB.rightChild = kotaE;
        kotaC.rightChild = kotaF;
        kotaD.leftChild = kotaB;

        BFS bfs = new BFS(kotaA,kotaE);
        BFS bfs2 = new BFS(kotaA,kotaA);
        SaveDBTest1 saveDBTest1 = new SaveDBTest1();
        saveDBTest1.sendToDB(bfs.startNodeKota.stationName, bfs.goalNodeKota.stationName, "Rute dapat terhubung");
        saveDBTest1.sendToDB(bfs.startNodeKota.stationName, bfs.goalNodeKota.stationName, "Rute dapat terhubung");
//        SaveDBTest saveDBTest = new SaveDBTest();
//        saveDBTest.sendToDB(bfs2.startNodeKota.stationName, bfs2.goalNodeKota.stationName, "Rute dapat terhubung");
//        assertEquals("Sukses", saveDB.sendToDB(bfs2.startNodeKota.stationName, bfs2.goalNodeKota.stationName, "Rute dapat terhubung"));
//        assertEquals("Sukses", saveDB.sendToDB(bfs.startNodeKota.stationName, bfs.goalNodeKota.stationName, "Rute dapat terhubung"));
    }



}

class SaveDBTest1 {

    @Test
    void sendToDB(String rute_awal,String rute_tujuan,String status_rute) {
        SaveDB saveDB = new SaveDB();
        System.out.println("masuk Send");
        assertEquals("Sukses", saveDB.sendToDB(rute_awal, rute_tujuan, status_rute));
    }
}