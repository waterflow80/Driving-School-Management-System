package com.autoEcole.controllers.seanceControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.gui.inputs.SeanceInput;
import com.autoEcole.gui.outputs.SeanceOutput;

public class SeanceController {

    public static void seanceMenu(){
        boolean more = true;
        String codeOrConsuiteChoice;

        while (more){
            SeanceOutput.seanceMainMenu();
            codeOrConsuiteChoice = SeanceInput.seanceMainMenuChoice();
            switch (codeOrConsuiteChoice){
                case "1": //Seance code
                    SeanceCodeController.seanceCodeMenu();
                    break;
                case "2": //Seance Conduite
                    SeanceConduiteController.seanceConduiteMenu();
                    break;
                case "3": //Menu principale
                    MainController.mainMenu();
                    break;
            }
        }
    }
}
