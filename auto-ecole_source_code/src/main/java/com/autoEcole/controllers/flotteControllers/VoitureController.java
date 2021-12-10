package com.autoEcole.controllers.flotteControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.gui.inputs.flotte.MotoInput;
import com.autoEcole.gui.inputs.flotte.VoitureInput;
import com.autoEcole.gui.outputs.flotte.MotoOutput;
import com.autoEcole.gui.outputs.flotte.VoitureOutput;
import com.autoEcole.services.vehicules.MotoService;
import com.autoEcole.services.vehicules.VoitureService;

public class VoitureController {

    /**
     * Handling the voiture menu
     * */
    public static void voitureMenu(){
        String voitureMenuChoice;
        boolean more = true;

        while (more){
            VoitureOutput.voitureMenu();
            voitureMenuChoice = VoitureInput.voitureMenuChoice();
            switch (voitureMenuChoice){
                case "1": // Ajouter une voiture
                    VoitureService.ajouterUneVoiture();
                    break;
                case "2": //Sypprimer une voiture
                    VoitureService.supprimerUneVoiture();
                    break;
                case "3": //Afficher une voiture
                    VoitureService.afficherUneVoiture();
                    break;
                case "4": // Afficher tous les voitures
                    VoitureService.afficherTousLesVoitures();
                    break;
                case "5"://Menu Principale
                    MainController.mainMenu();
                    more = false;
                    break;
            }

        }
    }


}
