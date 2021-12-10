package com.autoEcole.controllers.condidatControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.gui.inputs.CondidatInput;
import com.autoEcole.gui.outputs.CondidatOutput;
import com.autoEcole.gui.inputs.MainInput;
import com.autoEcole.services.CondidatService;

public class CondidatController {


    public static void condidatMenu(){
        String condidatMenuChoice, ajoutCondidatChoice;
        String cin = "", pause;
//        char response;
        boolean more = true; //stay in the same menu until the user exits


        while (more){
            CondidatOutput.condidatMenu(); // display the candidate department menu
            condidatMenuChoice = CondidatInput.condidatMenu();
            switch (condidatMenuChoice){
                case "1": //AJOUTER CONDIDAT MENU
                    CondidatOutput.ajouterCondidatMainMenu();
                    ajoutCondidatChoice = CondidatInput.ajouterCondidatMenu();
                    switch (ajoutCondidatChoice){
                        case "1": //AJOUTER UN CONDIDAT MENU
                            CondidatService.ajouterCondidat();
                            pause = MainInput.pause();
                            break;
                        case "2": //GO BACK
                    break; // go back to the while loop
                        case "3":
                            more = false;
                            break;
                    }
                    break;
                case "2": //SUPPRIMER UN CONDIDAT
                    CondidatService.supprimerCondidat();
                    pause = MainInput.pause();
                    break;
                case "3": // AFFICHER UN CONDIDAT
                    CondidatService.afficherUnCondidat();
                    pause = MainInput.pause();
                    break;
                case "4": //AFICHER TOUS LES CONDIDATS
                    CondidatService.afficherTousLesCondidats();
                    break;

                case "5": //UPDATE UN CONDIDAT
                    CondidatService.updateCondidat();
                    break;
                case "6":
                    MainController.mainMenu();
                    more = false;
                    break;
            }
        }
        }


}



