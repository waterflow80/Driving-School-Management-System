package com.autoEcole.dao.engineer;

import com.autoEcole.dao.condidat.CondidatReader;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EngineerWriter {

    @SuppressWarnings("unchecked")
    public static void addEngineer(Ingenieur ingenieur){
        //Retrieving the list of Engineers from the file, to append the new one
        List<Ingenieur> ingenieurs = EngineerReader.getAll();
        JSONArray ingenieursList = castListToJSONArray(ingenieurs);

        //Condidat Object
        JSONObject ingenieur1 = new JSONObject();

        ingenieur1.put("cin",ingenieur.getCin());
        ingenieur1.put("nom",ingenieur.getNom());
        ingenieur1.put("prenom",ingenieur.getPrenom());
        List<String> datesInStrings = new ArrayList<>(); //converting a list of dates into a list of strings
        for (LocalDate ld: ingenieur.getSeancesDates()){
            datesInStrings.add(ld.toString());
        }
        ingenieur1.put("seancesDates",datesInStrings);
        ingenieur1.put("nbHeuresCode",ingenieur.getNbHeuresCode());
        ingenieur1.put("nbHeuresConduite",ingenieur.getNbHeuresConduite());


        //Add ingenieur to list
        ingenieursList.add(ingenieur1);

        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/engineers.json")){
            file.write(ingenieursList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Convert List of Engineers into JSONArray
     * */
    public static JSONArray castListToJSONArray(List<Ingenieur> ingenieurs){
        JSONArray ingenieursList = new JSONArray();

        for (Ingenieur i: ingenieurs){
            JSONObject ing1 = new JSONObject();

            ing1.put("cin",i.getCin());
            ing1.put("nom",i.getNom());
            ing1.put("prenom",i.getPrenom());
            List<String> datesInStrings = new ArrayList<>(); //converting a list of dates into a list of strings
            for (LocalDate ld: i.getSeancesDates()){
                datesInStrings.add(ld.toString());
            }
            ing1.put("seancesDates",datesInStrings);
            ing1.put("nbHeuresCode",i.getNbHeuresCode());
            ing1.put("nbHeuresConduite",i.getNbHeuresConduite());
            ingenieursList.add(ing1);
        }
        return ingenieursList;
    }


    @SuppressWarnings("unchecked")
    /**
     * Add a list of engineers to the file (db)
     * */
    public static void addListEngineers(List<Ingenieur> ingenieurs){
        JSONArray ingeneiursList = castListToJSONArray(ingenieurs);
        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/engineers.json")){
            file.write(ingeneiursList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
