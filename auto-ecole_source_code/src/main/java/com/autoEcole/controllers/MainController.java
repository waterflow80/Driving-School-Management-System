package com.autoEcole.controllers;

import com.autoEcole.controllers.condidatControllers.CondidatController;
import com.autoEcole.controllers.flotteControllers.FlotteController;
import com.autoEcole.controllers.ingenieurControllers.IngenieurController;
import com.autoEcole.controllers.seanceControllers.SeanceController;
import com.autoEcole.gui.inputs.MainInput;
import com.autoEcole.gui.outputs.MainOutput;

@SuppressWarnings("unchecked")
public class MainController {


    /*
     * Displays the welcome screen for the user.
     * */
    public static void mainMenu() {
        String mainMenuChoice;


        while (true){
            MainOutput.mainMenu();
            mainMenuChoice = MainInput.mainMenu();
            switch (mainMenuChoice){
                case "1": //Condidat Section
                    CondidatController.condidatMenu();
                    break;
                case "2": //Seance Section
                    SeanceController.seanceMenu();
                    break;
                case "3": //Gestion du Flotte
                    FlotteController.flotteMenu();
                    break;
                case "4": //Gestion des ingenieurs
                    IngenieurController.ingenieureMenu();
                    break;
                case "5": //Gestion Des Salaires
                    SalaireController.salaireMenu();
                    break;
                case "6": //EXIT
                    return;
                /*case "6": //Gestion du Tresorerie
                    TresorerieController.tresorerieMenu();
                    break;
                case "7": // Gestion Des Prix
                    PrixController.prixMenu();
                    break;
                case "8": //Exit the application
                    return; */
            }
        }





        //department = OutputService.displayWelcomeScreen(); //1:CONDIDAT, 2:INGENIEURS 3:SEANCES, 4:PAIEMENTS, 5:SALAIRE, 6:FLOTTE


    }
}
