package com.autoEcole.dao.engineer;

import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EngineerReader {

    /**
     * Return the full list of Engineers
     * */
    public static List<Ingenieur> getAll(){
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        List<Ingenieur> ingenieurs = new ArrayList<Ingenieur>();

        try(FileReader reader = new FileReader("src/main/java/com/autoEcole/data/engineers.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of engineers in JSON ARRAY Format
            JSONArray ingenieursList = (JSONArray) obj;

            for (Object ing: ingenieursList){
                JSONObject ing1 = (JSONObject) ing;
                Ingenieur ingenieur = new Ingenieur();

                ingenieur.setCin((String) ing1.get("cin"));
                ingenieur.setPrenom((String) ing1.get("prenom"));
                ingenieur.setNom((String) ing1.get("nom"));
                List<String> datesInStrings = (List<String>) ing1.get("seancesDates");
                List<LocalDate> datesInLocalDate = new ArrayList<>();
                for (String s: datesInStrings){
                    datesInLocalDate.add(LocalDate.parse(s));
                }
                ingenieur.setSeancesDates(datesInLocalDate);
                ingenieur.setNbHeuresCode((double) ing1.get("nbHeuresCode"));
                ingenieur.setNbHeuresConduite((double) ing1.get("nbHeuresConduite"));
                //Adding condidat to condidat list
                ingenieurs.add(ingenieur);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            //e.printStackTrace();
//            System.out.println("THERE ARE NO ACTUAL ENGINEERS, OR IT MIGHT BE A PROBLEM WHILE PARSING THE FILE");
        }

        return ingenieurs;

    }


    /**
     * Return one engineer by cin number
     * */
    public static Ingenieur getEngineerByCin(String cin){
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();



        Ingenieur ingenieur = new Ingenieur();

        try(FileReader reader = new FileReader("src/main/java/com/autoEcole/data/engineers.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray ingineerList = (JSONArray) obj;
            for (Object ing: ingineerList){
                JSONObject ing1 = (JSONObject) ing;
                if (cin.equals(ing1.get("cin"))){ //See if the cin matches the object
                    ingenieur.setCin((String) ing1.get("cin"));
                    ingenieur.setPrenom((String) ing1.get("prenom"));
                    ingenieur.setNom((String) ing1.get("nom"));
                    List<String> datesInStrings = (List<String>) ing1.get("seancesDates");
                    List<LocalDate> datesInLocalDate = new ArrayList<>();
                    for (String s: datesInStrings){
                        datesInLocalDate.add(LocalDate.parse(s));
                    }
                    ingenieur.setSeancesDates(datesInLocalDate);
                    ingenieur.setNbHeuresCode((double) ing1.get("nbHeuresCode"));
                    ingenieur.setNbHeuresConduite((double) ing1.get("nbHeuresConduite"));
                    break;
                }

            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
//            System.out.println("PROBLEM WITHIN THE JSON FILE! CHECK THE FORMAT! CANNOT PARSE THE FILE !");
            //e.printStackTrace();
        }
        if (ingenieur.getCin() != null)
            return ingenieur;
        else
            return null;
    }


}
