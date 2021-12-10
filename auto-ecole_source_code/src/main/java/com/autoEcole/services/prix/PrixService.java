package com.autoEcole.services.prix;

public class PrixService {

    private static float prixDeBase = 15;
    public static float prixExamen;
    private static float augmentationSeanceCodeA = 3;
    private static float augmentationSeanceCodeB = 3;
    private static float augmentationSeanceCodeC = 5;
    private static float augmentationSeanceConduiteA = 4 ;
    private static float augmentationSeanceConduiteB = 6;
    private static float augmentationSeanceConduiteC = 8;


    /**
     * Calculate the price of a session of code
     */
    public static float prixSeancesCode(char categorie, int nbSeances){
        switch (categorie){
            case 'a':
                return nbSeances * (prixDeBase + (prixDeBase * augmentationSeanceCodeA /100));
            case 'b':
                return nbSeances * (prixDeBase + (prixDeBase * augmentationSeanceCodeB /100));
            case 'c':
                return nbSeances * (prixDeBase + (prixDeBase * augmentationSeanceCodeC /100));
        }
        return 0;
    }

    /**
     * Calculate the price of a session of code
     */
    public static float prixSeancesConduite(char categorie, int nbSeances){
        switch (categorie){
            case 'a':
                return nbSeances * (prixDeBase + (prixDeBase * augmentationSeanceConduiteA /100));
            case 'b':
                return nbSeances * (prixDeBase + (prixDeBase * augmentationSeanceConduiteB /100));
            case 'c':
                return nbSeances * (prixDeBase + (prixDeBase * augmentationSeanceConduiteC /100));
        }
        return 0;
    }

    /**
     * Calculate the total price of the training; including the exam fee
     */
    public static float prixTotalPlusExamen(char categorie, int nbSeances){
        return prixExamen + prixSeancesCode(categorie,nbSeances) + prixSeancesConduite(categorie, nbSeances);
    }
}
