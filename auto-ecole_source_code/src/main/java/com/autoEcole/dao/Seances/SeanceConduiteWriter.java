package com.autoEcole.dao.Seances;

import com.autoEcole.entities.seances.SeanceConduite;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SeanceConduiteWriter {

    @SuppressWarnings("unchecked")
    public static void addSeanceConduite(SeanceConduite seanceConduite){
        //Retrieving the list of SeanceCode from the file, to append the new one
        List<SeanceConduite> seancesConduite = SeanceConduiteReader.getAll();
        JSONArray seanceConduiteList = castListToJSONArray(seancesConduite);

        //Seance Object
        JSONObject seanceConduite1 = new JSONObject();

        seanceConduite1.put("number",seanceConduite.getNumber());
        seanceConduite1.put("date",seanceConduite.getDate().toString());
        seanceConduite1.put("cinCondidats",seanceConduite.getCinCondidats());
        seanceConduite1.put("cinIngenieur",seanceConduite.getCinIngenieur());
        seanceConduite1.put("categorie",seanceConduite.getCategorie());
        seanceConduite1.put("type",String.valueOf(seanceConduite.getType()));
        seanceConduite1.put("numImmatriculation", seanceConduite.getNumImmatriculation());


        //Add SeanceCode to list
        seanceConduiteList.add(seanceConduite1);

        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/seancesConduite.json")){
            file.write(seanceConduiteList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert List of SeanceCodes into JSONArray
     * */
    public static JSONArray castListToJSONArray(List<SeanceConduite> seancesConduite){
        JSONArray seanceConduiteList = new JSONArray();

        for (SeanceConduite s: seancesConduite){
            JSONObject sean1 = new JSONObject();

            sean1.put("number",s.getNumber());
            sean1.put("date",s.getDate().toString());
            sean1.put("cinCondidats",s.getCinCondidats());
            sean1.put("cinIngenieur",s.getCinIngenieur());
            sean1.put("categorie",s.getCategorie());
            sean1.put("type",String.valueOf(s.getType()));
            sean1.put("numImmatriculation", s.getNumImmatriculation());

            seanceConduiteList.add(sean1);

        }
        return seanceConduiteList;
    }

    @SuppressWarnings("unchecked")
    /**
     * Adding a list of seanceCode to the file (saving it)
     * */
    public static void addListSeancesConduite(List<SeanceConduite> seancesconduite){
        JSONArray seancesConduiteList = castListToJSONArray(seancesconduite);
        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/seancesConduite.json")){
            file.write(seancesConduiteList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
