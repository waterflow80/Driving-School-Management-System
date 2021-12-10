package com.autoEcole.dao.Seances;

import com.autoEcole.entities.seances.SeanceCode;
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


public class SeanceCodeReader {

    /**
     * Return the full list of Saences
     * */
    public static List<SeanceCode> getAll(){
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();



        List<SeanceCode> seanceCodes = new ArrayList<SeanceCode>();

        try(FileReader reader = new FileReader("src/main/java/com/autoEcole/data/seancesCode.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray seanceCodeList = (JSONArray) obj;
            for (Object sean: seanceCodeList){
                JSONObject sean1 = (JSONObject) sean;
                SeanceCode seanceCode = new SeanceCode();

                seanceCode.setNumber((Long) sean1.get("number"));
                seanceCode.setCategorie((String) sean1.get("categorie"));
                seanceCode.setType(((String) sean1.get("type")).charAt(0));
                seanceCode.setCinIngenieur((String) sean1.get("cinIngenieur"));
                Object listCin = (Object) sean1.get("cinCondidats") ;
                seanceCode.setCinCondidats((List<String>) listCin);
                Object sDate1= (Object) sean1.get("date");
                if (sDate1 != null) {
                    String date = (String) sDate1;
                    LocalDate localDate = LocalDate.parse(date);
                    seanceCode.setDate(localDate);
                } else {
                    seanceCode.setDate(null);
                }

                //Adding seanceCode to seanceCodes list
                seanceCodes.add(seanceCode);
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

        return seanceCodes;
    }


    /**
     * Return one Seance Code by number
     * */
    public static SeanceCode getSeanceByNumber(Long number){
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();



        SeanceCode seanceCode = new SeanceCode();

        try(FileReader reader = new FileReader("src/main/java/com/autoEcole/data/seancesCode.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray seanceCodeList = (JSONArray) obj;
            for (Object sean: seanceCodeList){
                JSONObject sean1 = (JSONObject) sean;
                if (number.equals(sean1.get("number"))){ //See if the cin matches the object
                    seanceCode.setNumber((Long) sean1.get("number"));
                    seanceCode.setCategorie((String) sean1.get("categorie"));
                    seanceCode.setType(((String) sean1.get("type")).charAt(0));
                    seanceCode.setCinIngenieur((String) sean1.get("cinIngenieur"));
                    Object listCin = (Object) sean1.get("cinCondidats") ;
                    seanceCode.setCinCondidats((List<String>) listCin);
                    Object sDate1= (Object) sean1.get("date");
                    if (sDate1 != null) {
                        String date = (String) sDate1;
                        LocalDate localDate = LocalDate.parse(date);
                        seanceCode.setDate(localDate);
                    } else {
                        seanceCode.setDate(null);
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

        if (seanceCode.getNumber() != null)
            return seanceCode;
        else
            return null;
    }


}
