package com.autoEcole.services.salaire;

import com.autoEcole.dao.engineer.EngineerReader;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.gui.inputs.IngenieurInput;
import com.autoEcole.gui.outputs.IngenieurOutput;
import com.autoEcole.gui.outputs.salaire.SalaireOutput;
import com.autoEcole.services.IngenieurService;

import java.util.List;

public class SalaireService {

    /**
     * Display the salary of an engineer chosen by cin
     * depending on the number of hours he has worked
     * */
    public static void afficherSalaireIngenieur(){
        String cin;
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        if (ingenieurs.isEmpty())
            System.out.println("THERE ARE NO ENGINEERS AT THE MOMENT !");
        else {
            SalaireOutput.headerAfficherSalaireIngenieur();
            IngenieurOutput.engineersFewDetails(); //display the list of all engineers to choose from
            IngenieurOutput.askForCinIngenieur();
            cin  = IngenieurInput.cinIngenieurForUpdate(); //the cin of the desired engineer
            Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin);
            if (ingenieur!=null){
                IngenieurService.displaySalaireByCin(cin);
            }else {
                System.out.println("CANNOT FIND ENGINEER !");
            }
        }
    }


}
