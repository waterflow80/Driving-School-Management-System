package com.autoEcole.controllers.flotteControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.gui.inputs.flotte.MotoInput;
import com.autoEcole.gui.outputs.flotte.MotoOutput;
import com.autoEcole.services.vehicules.MotoService;

public class MotoController {

    /**
     * Handling the CRUD of the moto department
     * */
    public static void motoMenu(){
        String motoMenuChoice;
        boolean more = true;


        while (more){
            MotoOutput.motoMenu();
            motoMenuChoice = MotoInput.motoMenuChoice();
            switch (motoMenuChoice){
                case "1": // Ajouter une moto
                    MotoService.ajouterUneMoto();
                    break;
                case "2": //Sypprimer une moto
                    MotoService.supprimerUneMoto();
                    break;
                case "3": //Afficher une moto
                    MotoService.afficherUneMoto();
                    break;
                case "4": // Afficher tous les motos
                   MotoService.afficherTousLesMotos();
                    break;
                case "5"://Menu Principale
                    MainController.mainMenu();
                    more = false;
                    break;
            }

        }
    }
}
