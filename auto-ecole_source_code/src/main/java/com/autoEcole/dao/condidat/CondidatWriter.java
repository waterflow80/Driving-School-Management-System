package com.autoEcole.dao.condidat;

import com.autoEcole.entities.condiats.Condidat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

public class CondidatWriter {
    @SuppressWarnings("unchecked")
    /**
     * Adding a new candiadtes to the json file (database)
     * */
    public static void addCondidat(Condidat condidat){
        //Retrieving the list of condidats from the file, to append the new one
        List<Condidat> condidats = CondidatReader.getAll();
        JSONArray condidatList = castListToJSONArray(condidats);

        //Condidat Object
        JSONObject condidat1 = new JSONObject();

        condidat1.put("cin",condidat.getCin());
        condidat1.put("nom",condidat.getNom());
        condidat1.put("prenom",condidat.getPrenom());
        condidat1.put("age",condidat.getAge());
        condidat1.put("phoneNumber",condidat.getPhoneNumber());
        condidat1.put("categorie",String.valueOf(condidat.getCategorie()));
        condidat1.put("nbSeances",condidat.getNbSeances());
        condidat1.put("montantPayeCode",condidat.getMontantPayeCode());
        condidat1.put("montantPayeConduite",condidat.getMontantPayeConduite());
        //LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(condidat.getDateExamen()));
        if (condidat.getDateExamen() != null)
            condidat1.put("dateExamen",condidat.getDateExamen().toString());
        else
            condidat1.put("dateExamen",condidat.getDateExamen());
        //condidat1.put("dateExamen",localDate.toString());
        condidat1.put("examenPayee",condidat.isExamenPayee());


        //Add condidats to list
        condidatList.add(condidat1);

        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/condidats.json")){
            file.write(condidatList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert List of Condidats into JSONArray
     * */
    public static JSONArray castListToJSONArray(List<Condidat> condidats){
        JSONArray condidatList = new JSONArray();

        for (Condidat c: condidats){
            JSONObject cond1 = new JSONObject();
            cond1.put("cin",c.getCin());
            cond1.put("nom",c.getNom());
            cond1.put("prenom",c.getPrenom());
            cond1.put("age",c.getAge());
            cond1.put("phoneNumber",c.getPhoneNumber());
            cond1.put("categorie",String.valueOf(c.getCategorie()));
            cond1.put("nbSeances",c.getNbSeances());
            cond1.put("montantPayeCode",c.getMontantPayeCode());
            cond1.put("montantPayeConduite",c.getMontantPayeConduite());
            if (c.getDateExamen() != null)
                cond1.put("dateExamen",c.getDateExamen().toString());
            else
                cond1.put("dateExamen",c.getDateExamen()); //null anyway
            cond1.put("examenPayee",c.isExamenPayee());
            condidatList.add(cond1);

        }
        return condidatList;
    }

    @SuppressWarnings("unchecked")
    /**
     * Adding a list of candidates to the json file (database)
     * */
    public static void addListCondidat(List<Condidat> condidats){
        JSONArray condidatList = castListToJSONArray(condidats);
        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/condidats.json")){
            file.write(condidatList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
