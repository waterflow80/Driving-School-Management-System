package com.autoEcole.controllers.seanceControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.gui.inputs.SeanceCodeInput;
import com.autoEcole.gui.outputs.SeanceCodeOutput;
import com.autoEcole.services.SeanceCodeService;

import java.util.ArrayList;
import java.util.List;

public class SeanceCodeController {

    /**
     * Handling the seance code menu
     * */
    public static void seanceCodeMenu(){
        String seanceCodeMenuChoice;
        boolean more = true;


        while (more){
            SeanceCodeOutput.seanceCodeMenu();
            seanceCodeMenuChoice = SeanceCodeInput.seanceCodeMenu();
            switch (seanceCodeMenuChoice){
                case "1": // Ajouter une seance (code)
                    SeanceCodeService.ajouterSeanceCode();
                    break;
                case "2": //Sypprimer une seance
                    SeanceCodeService.supprimerSeanceCode();
                    break;
                case "3": //Afficher une seance (code)
                    SeanceCodeService.afficherUneSeanceCode();
                    break;
                case "4": // Afficher tous les seances
                    SeanceCodeService.afficherTousLesSeancesCode();
                    break;
                case "5"://Menu Principale
                    MainController.mainMenu();
                    more = false;
                    break;
            }

        }
    }
}
