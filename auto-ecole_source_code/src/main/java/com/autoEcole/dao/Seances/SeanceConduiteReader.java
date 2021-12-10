package com.autoEcole.dao.Seances;

import com.autoEcole.entities.seances.SeanceConduite;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeanceConduiteReader {

    /**
     * Return the full list of Seances
     * */
    public static List<SeanceConduite> getAll(){
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();



        List<SeanceConduite> seancesConduite = new ArrayList<SeanceConduite>();

        try(FileReader reader = new FileReader("src/main/java/com/autoEcole/data/seancesConduite.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray seanceConduiteList = (JSONArray) obj;
            for (Object sean: seanceConduiteList){
                JSONObject sean1 = (JSONObject) sean;
                SeanceConduite seanceConduite1 = new SeanceConduite();

                seanceConduite1.setNumImmatriculation((Long) sean1.get("numImmatriculation"));
                seanceConduite1.setNumber((Long) sean1.get("number"));
                seanceConduite1.setCategorie((String) sean1.get("categorie"));
                seanceConduite1.setType(((String) sean1.get("type")).charAt(0));
                seanceConduite1.setCinIngenieur((String) sean1.get("cinIngenieur"));
                Object listCin = (Object) sean1.get("cinCondidats") ;
                seanceConduite1.setCinCondidats((List<String>) listCin);
                Object sDate1= (Object) sean1.get("date");
                if (sDate1 != null) {
                    String date = (String) sDate1;
                    LocalDate localDate = LocalDate.parse(date);
                    seanceConduite1.setDate(localDate);
                } else {
                    seanceConduite1.setDate(null);
                }

                //Adding seanceConduite to seanceConduite list
                seancesConduite.add(seanceConduite1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            //e.printStackTrace();
//            System.out.println("THERE ARE NO ACTUAL SEANCES CONDUITE, OR IT MIGHT BE A PROBLEM WHILE PARSING THE FILE");
        }

        return seancesConduite;
    }

    /**
     * Return one SeanceConduite by number
     * */
    public static SeanceConduite getSeanceByNumber(Long number){
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();



        SeanceConduite seanceConduite = new SeanceConduite();

        try(FileReader reader = new FileReader("src/main/java/com/autoEcole/data/seancesConduite.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray seanceConduiteList = (JSONArray) obj;
            for (Object sean: seanceConduiteList){
                JSONObject sean1 = (JSONObject) sean;
                if (number.equals(sean1.get("number"))){ //See if the cin matches the object
                    seanceConduite.setNumber((Long) sean1.get("number"));
                    seanceConduite.setNumImmatriculation((Long) sean1.get("numImmatriculation"));
                    seanceConduite.setCategorie((String) sean1.get("categorie"));
                    seanceConduite.setType(((String) sean1.get("type")).charAt(0));
                    seanceConduite.setCinIngenieur((String) sean1.get("cinIngenieur"));
                    Object listCin = (Object) sean1.get("cinCondidats") ;
                    seanceConduite.setCinCondidats((List<String>) listCin);
                    Object sDate1= (Object) sean1.get("date");
                    if (sDate1 != null) {
                        String date = (String) sDate1;
                        LocalDate localDate = LocalDate.parse(date);
                        seanceConduite.setDate(localDate);
                    } else {
                        seanceConduite.setDate(null);
                    }
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

        if (seanceConduite.getNumber() != null)
            return seanceConduite;
        else
            return null;
    }
}
