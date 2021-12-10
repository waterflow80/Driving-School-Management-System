package com.autoEcole.controllers.ingenieurControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.gui.inputs.IngenieurInput;
import com.autoEcole.gui.inputs.MainInput;
import com.autoEcole.gui.outputs.IngenieurOutput;
import com.autoEcole.services.IngenieurService;

public class IngenieurController {

    /**
     * Handle the engineer menu
     * */
    public static void ingenieureMenu(){
        String ingineerMenuChoice;
        boolean more = true;
        String cin = "", pause;

        while (more){
            IngenieurOutput.engineerMenu();
            ingineerMenuChoice = IngenieurInput.engineerMenuChoice();
            switch (ingineerMenuChoice){
                case "1": //AJOUTER INGENIEUR
                    IngenieurService.ajouterIngenieur();
                    pause = MainInput.pause();
                    break;
                case "2": //SUPPRIMER UN INGENIEUR
                    IngenieurService.supprimerIngenieur();
                    pause = MainInput.pause();
                    break;
                case "3": // AFFICHER UN INGENIEUR
                    IngenieurService.afficherUnIngenieur();
                    pause = MainInput.pause();
                    break;
                case "4": //AFICHER TOUS LES INGENIEURS
                    IngenieurService.afficherTousLesIngenieurs();
                    break;

                case "5": //UPDATE UN INGENIEUR
                    IngenieurService.updateIngenieur();
                    break;
                case "6":
                    MainController.mainMenu();
                    more = false;
                    break;
            }
        }
    }
}
