package com.autoEcole.managemeent;

public class Salaire {

    /*
    * Calculate the salary of an engineer according to the number of hours in code session
    * and the number of hours in the driving session. in dt (Tunisian Dinar)
    * */
    public static float calculSalaire(float nbHeuresCode, float nbHeuresConduite){
        return 10 * nbHeuresConduite + 7 * nbHeuresCode;
    }


}
