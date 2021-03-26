package com.example.tp3;

import java.util.ArrayList;

public class Data {
    private ArrayList<Planete> donneeMd;

   /* public void installePlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        planetes.add("Venus");
        planetes.add("Terre");
        planetes.add("Mars");
        planetes.add("Jupiter");
        planetes.add("Saturne");
        planetes.add("Uranus");
        planetes.add("Neptune");
        planetes.add("Pluton");
    }*/


    private String[] nomDesPlanetes = {"Mercure", "Venus", "Terre", "Mars", "Jupiter", "Saturne", "Uranus", "Neptune", "Pluton"};
    private int[] tailleDesPlanetes = {4900, 12000, 12800, 6800, 144000, 120000, 52000, 50000, 2300};

    public Data() {
        donneeMd = new ArrayList<>();
        for (int i = 0; i < nomDesPlanetes.length; i++) {
            Planete planet = new Planete();
            planet.setNom(nomDesPlanetes[i]);
            planet.setTaille(tailleDesPlanetes[i]);
            donneeMd.add(planet);
        }
    }

    public ArrayList<Planete> getDataSet() {
        return donneeMd;
    }
}
