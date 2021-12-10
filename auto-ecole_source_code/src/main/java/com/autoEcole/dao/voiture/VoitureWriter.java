package com.autoEcole.dao.voiture;

import com.autoEcole.dao.Seances.SeanceCodeReader;
import com.autoEcole.entities.marqueVehicule.Marques;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.vehicules.Vehicule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class VoitureWriter {
    @SuppressWarnings("unchecked")
    /**
     * Adding a new vehicle (car) to the json file
     * */
    public static void addVoiture(Vehicule voiture){
        //Retrieving the list of SeanceCode from the file, to append the new one
        List<Vehicule> vehicules = VoitureReader.getAll();
        JSONArray vehiculesList = castListToJSONArray(vehicules);

        //Seance Object
        JSONObject vehicule1 = new JSONObject();

        vehicule1.put("numImmatriculation", voiture.getNumImmatriculation());
        //Date mise en service
        if (voiture.getDateMiseEnService() != null)
            vehicule1.put("dateExamen",voiture.getDateMiseEnService().toString());
        else
            vehicule1.put("dateExamen",voiture.getDateMiseEnService()); //null anyway
        //Date Prochain entretien
        if (voiture.getDateProchainEntretien() != null)
            vehicule1.put("dateProchainEntretien",voiture.getDateProchainEntretien().toString());
        else
            vehicule1.put("dateProchainEntretien",voiture.getDateProchainEntretien()); //null anyway
        vehicule1.put("kilometrageTotal", voiture.getKilometrageTotal());
        vehicule1.put("nbKilometresRestant", voiture.getNbKilometresRestant());
        vehicule1.put("marque", voiture.getMarque());
        vehicule1.put("disponible",voiture.isDisponible());
        vehicule1.put("kilometrageMax", voiture.getKilometrageMax());


        //Add SeanceCode to list
        vehiculesList.add(vehicule1);

        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/voitures.json")){
            file.write(vehiculesList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert List of vehicles into JSONArray
     * */
    public static JSONArray castListToJSONArray(List<Vehicule> vehicules){
        JSONArray vehiculesList = new JSONArray();

        for (Vehicule v: vehicules){
            JSONObject vehic1 = new JSONObject();

            vehic1.put("numImmatriculation", v.getNumImmatriculation());
            //Date mise en service
            if (v.getDateMiseEnService() != null)
                vehic1.put("dateExamen",v.getDateMiseEnService().toString());
            else
                vehic1.put("dateExamen",v.getDateMiseEnService()); //null anyway
            //Date Prochain entretien
            if (v.getDateProchainEntretien() != null)
                vehic1.put("dateProchainEntretien",v.getDateProchainEntretien().toString());
            else
                vehic1.put("dateProchainEntretien",v.getDateProchainEntretien()); //null anyway
            vehic1.put("kilometrageTotal", v.getKilometrageTotal());
            vehic1.put("nbKilometresRestant", v.getNbKilometresRestant());
            vehic1.put("marque", v.getMarque());
            vehic1.put("disponible",v.isDisponible());
            vehic1.put("kilometrageMax", v.getKilometrageMax());

            //Finally adding the vehicle to the list
            vehiculesList.add(vehic1);
        }
        return vehiculesList;
    }

    @SuppressWarnings("unchecked")
    /**
     * Adding a list of vehicles to the file (saving it)
     * */
    public static void addListVehicules(List<Vehicule> vehicules){
        JSONArray vehiculesList = castListToJSONArray(vehicules);
        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/voitures.json")){
            file.write(vehiculesList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Casting a list of strings into a json array
     * */
    public static JSONArray castListMarquesToJSONArray(Marques marques){
        JSONArray marquesList = new JSONArray();
        JSONObject marque1 = new JSONObject();
        marque1.put("marques", marques.getMarques());
        marquesList.add(marque1);
        return  marquesList;
    }

    /**
     * Adding marques to json file (change the old list with the new one)
     * */
    public static void addMarques(Marques marques){
        //Retrieving the list of marques from the file
        JSONArray marquesList = castListMarquesToJSONArray(marques);

        //Marque Object
        JSONObject marque1 = new JSONObject();

        marque1.put("marques", marques.getMarques());

        //Add marques to list
        marquesList.add(marque1);

        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/marques/voituresMarques.json")){
            file.write(marquesList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
