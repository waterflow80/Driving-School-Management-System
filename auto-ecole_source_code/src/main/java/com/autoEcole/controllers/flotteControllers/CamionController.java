package com.autoEcole.controllers.flotteControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.gui.inputs.flotte.CamionInput;
import com.autoEcole.gui.inputs.flotte.VoitureInput;
import com.autoEcole.gui.outputs.flotte.CamionOutput;
import com.autoEcole.gui.outputs.flotte.VehiculeOutput;
import com.autoEcole.gui.outputs.flotte.VoitureOutput;
import com.autoEcole.services.vehicules.CamionService;
import com.autoEcole.services.vehicules.VoitureService;

import java.util.ArrayList;
import java.util.List;

public class CamionController {

    /**
     * Handling the camion menu
     * */
    public static void camionMenu(){
        String camionMenuChoice;
        boolean more = true;

        while (more){
            CamionOutput.camionMenu();
            camionMenuChoice = CamionInput.camionMenuChoice();
            switch (camionMenuChoice){
                case "1": // Ajouter un camion
                    CamionService.ajouterUnCamion();
                    break;
                case "2": //Sypprimer un camion
                    CamionService.supprimerUnCamion();
                    break;
                case "3": //Afficher un camion
                    CamionService.afficherUnCamion();
                    break;
                case "4": // Afficher tous les camions
                    CamionService.afficherTousLesCamions();
                    break;
                case "5"://Menu Principale
                    MainController.mainMenu();
                    more = false;
                    break;
            }

        }
    }


}
