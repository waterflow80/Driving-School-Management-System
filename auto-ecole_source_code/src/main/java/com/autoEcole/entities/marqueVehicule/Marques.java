package com.autoEcole.entities.marqueVehicule;

import java.util.ArrayList;
import java.util.List;

public class Marques {
    private List<String> marques;

    public Marques(List<String> marques) {
        this.marques = marques;
    }

    public Marques() {
    }

    public List<String> getMarques() {
        return marques;
    }

    public void setMarques(List<String> marques) {
        this.marques = marques;
    }

    /**
     * Adding a new brand to the brands list
     * */
    public void addMarque(String marque){
        if (this.marques.isEmpty()){
            this.marques = new ArrayList<String>();
            this.marques.add(marque);
        }else {
            this.marques.add(marque);
        }

    }
}
