package com.autoEcole.services;

public class NumberGeneratorService {
    public static Long number = -1L; // the auto generated number


    /**
     * returns a unique and auto generated Seance number
     * */
    public static Long getSeanceNumber(){
        NumberGeneratorService.number ++;
        return number;
    }
}
