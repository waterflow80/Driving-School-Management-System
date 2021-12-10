package com.autoEcole.entities.ingenieurs;

import com.autoEcole.entities.ingenieurs.Ingenieur;

import java.util.List;

public class Ingenieurs {
    private List<Ingenieur> ingenieurs;

    public Ingenieurs(List<Ingenieur> ingenieurs) {
        this.ingenieurs = ingenieurs;
    }

    public List<Ingenieur> getIngenieurs() {
        return ingenieurs;
    }

    public void setIngenieurs(List<Ingenieur> ingenieurs) {
        this.ingenieurs = ingenieurs;
    }


}
