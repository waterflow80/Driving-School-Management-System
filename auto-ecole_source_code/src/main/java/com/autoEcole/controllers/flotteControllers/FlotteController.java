package com.autoEcole.controllers.flotteControllers;

import com.autoEcole.controllers.MainController;
import com.autoEcole.gui.inputs.flotte.FlotteInput;
import com.autoEcole.gui.outputs.flotte.FLotteOutput;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

public class FlotteController {

    //Manage the flotte menu
    public static void flotteMenu(){
        FLotteOutput.displayFlotteMenu();
        String choice = FlotteInput.flotteMenuChoice();
        switch (choice){
            case "1": //MOTO SECTION
                MotoController.motoMenu();
                break;
            case "2": //VOITURE SECTION
                VoitureController.voitureMenu();
                break;
            case "3": //CAMION SECTION
                CamionController.camionMenu();
                break;
            case "4": //MENU PRINCIPALE
                MainController.mainMenu();
                break;

        }
    }
}
