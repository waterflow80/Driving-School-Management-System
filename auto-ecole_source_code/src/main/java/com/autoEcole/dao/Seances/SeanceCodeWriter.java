package com.autoEcole.dao.Seances;

import com.autoEcole.entities.seances.SeanceCode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SeanceCodeWriter {
    @SuppressWarnings("unchecked")
    public static void addSeanceCode(SeanceCode seanceCode){
        //Retrieving the list of SeanceCode from the file, to append the new one
        List<SeanceCode> seanceCodes = SeanceCodeReader.getAll();
        JSONArray seanceCodeList = castListToJSONArray(seanceCodes);

        //Seance Object
        JSONObject seanceCode1 = new JSONObject();

        seanceCode1.put("number",seanceCode.getNumber());
        seanceCode1.put("date",seanceCode.getDate().toString());
        seanceCode1.put("cinCondidats",seanceCode.getCinCondidats());
        seanceCode1.put("cinIngenieur",seanceCode.getCinIngenieur());
        seanceCode1.put("categorie",seanceCode.getCategorie());
        seanceCode1.put("type",String.valueOf(seanceCode.getType()));


        //Add SeanceCode to list
        seanceCodeList.add(seanceCode1);

        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/seancesCode.json")){
            file.write(seanceCodeList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert List of SeanceCodes into JSONArray
     * */
    public static JSONArray castListToJSONArray(List<SeanceCode> seanceCodes){
        JSONArray seanceCodeList = new JSONArray();

        for (SeanceCode s: seanceCodes){
            JSONObject sean1 = new JSONObject();

            sean1.put("number",s.getNumber());
            sean1.put("date",s.getDate().toString());
            sean1.put("cinCondidats",s.getCinCondidats());
            sean1.put("cinIngenieur",s.getCinIngenieur());
            sean1.put("categorie",s.getCategorie());
            sean1.put("type",String.valueOf(s.getType()));

            seanceCodeList.add(sean1);

        }
        return seanceCodeList;
    }

    @SuppressWarnings("unchecked")
    /**
     * Adding a list of seanceCode to the file (saving it)
     * */
    public static void addListSeancesCode(List<SeanceCode> seanceCodes){
        JSONArray seancesCodeList = castListToJSONArray(seanceCodes);
        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/seancesCode.json")){
            file.write(seancesCodeList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
