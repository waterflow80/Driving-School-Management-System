package com.autoEcole.dao.camion;

import com.autoEcole.dao.voiture.VoitureReader;
import com.autoEcole.entities.marqueVehicule.Marques;
import com.autoEcole.entities.vehicules.Vehicule;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CamionWriter {

    /**
     * Adding a new camion to the json file
     * */
    public static void addCamion(Vehicule camion){
        //Retrieving the list of SeanceCode from the file, to append the new one
        List<Vehicule> vehicules = CamionReader.getAll();
        JSONArray vehiculesList = castListVehiculesToJSONArray(vehicules);

        //Seance Object
        JSONObject vehicule1 = new JSONObject();

        vehicule1.put("numImmatriculation", camion.getNumImmatriculation());
        //Date mise en service
        if (camion.getDateMiseEnService() != null)
            vehicule1.put("dateExamen",camion.getDateMiseEnService().toString());
        else
            vehicule1.put("dateExamen",camion.getDateMiseEnService()); //null anyway
        //Date Prochain entretien
        if (camion.getDateProchainEntretien() != null)
            vehicule1.put("dateProchainEntretien",camion.getDateProchainEntretien().toString());
        else
            vehicule1.put("dateProchainEntretien",camion.getDateProchainEntretien()); //null anyway
        vehicule1.put("kilometrageTotal", camion.getKilometrageTotal());
        vehicule1.put("nbKilometresRestant", camion.getNbKilometresRestant());
        vehicule1.put("marque", camion.getMarque());
        vehicule1.put("disponible",camion.isDisponible());
        vehicule1.put("kilometrageMax", camion.getKilometrageMax());


        //Add SeanceCode to list
        vehiculesList.add(vehicule1);

        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/camion.json")){
            file.write(vehiculesList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert List of vehicles into JSONArray
     * */
    public static JSONArray castListVehiculesToJSONArray(List<Vehicule> vehicules){
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
     * Adding a list of camions to the file (saving it)
     * */
    public static void addListVehicules(List<Vehicule> vehicules){
        JSONArray vehiculesList = castListVehiculesToJSONArray(vehicules);
        //Write to JSON File
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/camion.json")){
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
        try (FileWriter file = new FileWriter("src/main/java/com/autoEcole/data/marques/camionsMarques.json")){
            file.write(marquesList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
