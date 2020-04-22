package com.company;

import org.w3c.dom.Node;

import java.util.*;

public class Main {


    public  List<NodeKota> nodeKotas = new ArrayList<>();
    public static void main(String[] args) {
	// write your code here
        String array[];
        Main main = new Main();

        NodeKota kotaF = new NodeKota("Kota F",null,null);
        NodeKota kotaE = new NodeKota("Kota E",null,null);
        NodeKota kotaD = new NodeKota("Kota D",null,null);
        NodeKota kotaC = new NodeKota("Kota C",kotaF,null);
        NodeKota kotaB = new NodeKota("Kota B",kotaD,kotaE);
        NodeKota kotaA = new NodeKota("Kota A",kotaB,kotaC);
        NodeKota kotakosong = new NodeKota(null,null,null);
        NodeKota tujuanKosong = new NodeKota(null,null,null);
        main.nodeKotas.add(new NodeKota("Kota F",null,null));
        main.nodeKotas.add(new NodeKota("Kota E",null,null));
        main.nodeKotas.add(new NodeKota("Kota D",null,null));
        main.nodeKotas.add(new NodeKota("Kota C",kotaF,null));
        main.nodeKotas.add(new NodeKota("Kota B",kotaD,kotaE));
        main.nodeKotas.add(new NodeKota("Kota A",kotaB,kotaC));


        kotaA.leftChild = kotaB;
        kotaA.rightChild = kotaC;
        kotaB.leftChild = kotaD;
        kotaB.rightChild = kotaE;
        kotaC.rightChild = kotaF;
        kotaD.leftChild = kotaB;
//        kotaE.leftChild = kotaB;
//        kotaF.leftChild = kotaC;

        BFS bfs = new BFS(kotaA, kotaC);
//        BFS bfs1 = new BFS(kotaF,kotaE);
//        BFS bfs2 = new BFS(kotaA,kotaA);
//        BFS bfs3 = new BFS(kotakosong,kotaA);
//        bfs2.compute();
//        bfs3.compute();
//        bfs1.compute();
        array = bfs.compute();
        System.out.println("array = "+ Arrays.toString(array));
//        for (int i =0;i<bfs.compute().length;i++){
//            System.out.println("Penelurusan "+i+" = "+array[i]);
//            if (array[i].equals(kotaC.stationName)){
//                System.out.println("Path Found");
//            }
//
//        }


//        if(bfs.compute().length != 0) {
//            System.out.print("Path Found!");
//        }else {
//            System.out.println("Path Not Found");
//        }



    }





}
