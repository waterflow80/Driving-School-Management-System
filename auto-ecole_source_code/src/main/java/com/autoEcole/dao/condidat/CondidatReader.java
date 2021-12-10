package com.autoEcole.dao.condidat;

import com.autoEcole.entities.condiats.Condidat;
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

public class CondidatReader {

    /**
     * Return the full list of condidats
     */
    public static List<Condidat> getAll() {
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();


        List<Condidat> condidats = new ArrayList<Condidat>();

        try (FileReader reader = new FileReader("src/main/java/com/autoEcole/data/condidats.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray condidatList = (JSONArray) obj;

            for (Object cond : condidatList) {
                JSONObject cond1 = (JSONObject) cond;
                Condidat condidat = new Condidat();

                condidat.setCin((String) cond1.get("cin"));
                condidat.setPrenom((String) cond1.get("prenom"));
                condidat.setNom((String) cond1.get("nom"));
                condidat.setAge(((Long) cond1.get("age")).intValue());
                condidat.setPhoneNumber(((Long) cond1.get("phoneNumber")).intValue());
                condidat.setCategorie(((String) cond1.get("categorie")).charAt(0));
                condidat.setNbSeances(((Long) cond1.get("nbSeances")).intValue());
                condidat.setMontantPayeCode(((double) cond1.get("montantPayeCode")));
                condidat.setMontantPayeConduite(((double) cond1.get("montantPayeConduite")));
                Object sDate1 = (Object) cond1.get("dateExamen");
                if (sDate1 != null) {
                    String date = (String) sDate1;
                    LocalDate localDate = LocalDate.parse(date);
                    condidat.setDateExamen(localDate);
                } else {
                    condidat.setDateExamen(null);
                }
                condidat.setExamenPayee((boolean) cond1.get("examenPayee"));

                //Adding condidat to condidat list
                condidats.add(condidat);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            //e.printStackTrace();
//            System.out.println("THERE ARE NO ACTUAL CANDIDATES, OR IT MIGHT BE A PROBLEM WHILE PARSING THE FILE");
        }

        return condidats;
    }

    /**
     * Return one condidat by cin number
     */
    public static Condidat getCondidatByCin(String cin) {
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();


        Condidat condidat = new Condidat();

        try (FileReader reader = new FileReader("src/main/java/com/autoEcole/data/condidats.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray condidatList = (JSONArray) obj;
            for (Object cond : condidatList) {
                JSONObject cond1 = (JSONObject) cond;
                if (cin.equals((String) cond1.get("cin"))) { //See if the cin matches the object
                    condidat.setCin((String) cond1.get("cin"));
                    condidat.setPrenom((String) cond1.get("prenom"));
                    condidat.setNom((String) cond1.get("nom"));
                    condidat.setAge(((Long) cond1.get("age")).intValue());
                    condidat.setPhoneNumber(((Long) cond1.get("phoneNumber")).intValue());
                    condidat.setCategorie(((String) cond1.get("categorie")).charAt(0));
                    condidat.setNbSeances(((Long) cond1.get("nbSeances")).intValue());
                    condidat.setMontantPayeCode((double) cond1.get("montantPayeCode"));
                    condidat.setMontantPayeConduite((double) cond1.get("montantPayeConduite"));
                    Object sDate1 = (Object) cond1.get("dateExamen");
                    if (sDate1 != null) {
                        String date = (String) sDate1;
                        LocalDate localDate = LocalDate.parse(date);
                        condidat.setDateExamen(localDate);
                    } else {
                        condidat.setDateExamen(null);
                    }
                    condidat.setExamenPayee((boolean) cond1.get("examenPayee"));
                    return condidat;
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
            return null;


    }
}

