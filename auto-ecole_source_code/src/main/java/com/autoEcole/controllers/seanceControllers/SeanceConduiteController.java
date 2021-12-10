package com.autoEcole.controllers.seanceControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.gui.inputs.SeanceCodeInput;
import com.autoEcole.gui.inputs.SeanceConduiteInput;
import com.autoEcole.gui.outputs.SeanceCodeOutput;
import com.autoEcole.gui.outputs.SeanceConduiteOutput;
import com.autoEcole.gui.outputs.SeanceOutput;
import com.autoEcole.services.SeanceCodeService;
import com.autoEcole.services.SeanceConduiteService;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class SeanceConduiteController {


    /**
     * Handling the seance Conduite Menu
     */
    public static void seanceConduiteMenu() {
        String seanceConduiteMenuChoice;
        boolean more = true;

        while (more) {
            SeanceConduiteOutput.seanceConduiteMenu();
            seanceConduiteMenuChoice = SeanceConduiteInput.seanceConduiteMenu();
            switch (seanceConduiteMenuChoice) {
                case "1": // Ajouter une seance (conduite)
                    SeanceConduiteService.ajouterSeanceConduite();
                    break;
                case "2": //Sypprimer une seance
                    SeanceConduiteService.supprimerSeanceConduite();
                    break;
                case "3": //Afficher une seance (conduite)
                    SeanceConduiteService.afficherUneSeanceConduite();
                    break;
                case "4": // Afficher tous les seances
                    SeanceConduiteService.afficherTousLesSeancesConduite();
                    break;
                case "5"://Menu Principale
                    MainController.mainMenu();
                    more = false;
                    break;
            }
        }

    }
}
