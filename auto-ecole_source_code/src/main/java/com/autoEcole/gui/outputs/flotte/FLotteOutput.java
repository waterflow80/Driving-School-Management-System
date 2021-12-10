package com.autoEcole.gui.outputs.flotte;

public class FLotteOutput {
    private static final int WIDTH = 30;

    /**
     * Display the flotte menu (voiture, motos, camions)
     * */
    public static void displayFlotteMenu(){
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("-----FLOTTE DEPARTMENT-----");

        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
        System.out.println("1: MOTOS");
        System.out.println("2: VOITURES");
        System.out.println("3: CAMION");
        System.out.println("4: MENU PRINCIPALE");
        for (int i=0;i<WIDTH+1;i++)
            System.out.print("#");
        System.out.print("\n");
    }
}
