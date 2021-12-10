package com.autoEcole.dao.camion;

import com.autoEcole.entities.marqueVehicule.Marques;
import com.autoEcole.entities.vehicules.Vehicule;
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

public class CamionReader {

    /**
     * Return the full list of camions
     */
    public static List<Vehicule> getAll() {
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();


        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        try (FileReader reader = new FileReader("src/main/java/com/autoEcole/data/camion.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of camions in JSON ARRAY Format
            JSONArray vehiculesList = (JSONArray) obj;
            for (Object vehic : vehiculesList) {
                JSONObject vehic1 = (JSONObject) vehic;
                Vehicule camion = new Vehicule();

                camion.setNumImmatriculation((Long) vehic1.get("numImmatriculation"));
                camion.setDisponible((boolean) vehic1.get("disponible"));
                camion.setMarque((String) vehic1.get("marque"));
                camion.setKilometrageTotal((double) vehic1.get("kilometrageTotal"));
                camion.setKilometrageMax((double) vehic1.get("kilometrageMax"));
                camion.setNbKilometresRestant((double) vehic1.get("nbKilometresRestant"));
                //Date Mise En Service
                Object sDate1 = (Object) vehic1.get("dateMiseEnService");
                if (sDate1 != null) {
                    String date = (String) sDate1;
                    LocalDate localDate = LocalDate.parse(date);
                    camion.setDateMiseEnService(localDate);
                } else {
                    camion.setDateMiseEnService(null);
                }
                //Date Prochain Entretien
                sDate1 = (Object) vehic1.get("dateProchainEntretien");
                if (sDate1 != null) {
                    String date = (String) sDate1;
                    LocalDate localDate = LocalDate.parse(date);
                    camion.setDateProchainEntretien(localDate);
                } else {
                    camion.setDateProchainEntretien(null);
                }
                //Adding car to cars list
                vehicules.add(camion);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            //e.printStackTrace();
//            System.out.println("THERE ARE NO ACTUAL CAMIONS, OR IT MIGHT BE A PROBLEM WHILE PARSING THE FILE");
        }

        return vehicules;
    }

    /**
     * Return one camion by num immatriculation
     */
    public static Vehicule getVehiculeByNumImmatriculation(Long numImmatriculation) {
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();


        Vehicule vehicule = new Vehicule();

        try (FileReader reader = new FileReader("src/main/java/com/autoEcole/data/camion.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of camions in JSON ARRAY Format
            JSONArray motosList = (JSONArray) obj;
            for (Object moto : motosList) {
                JSONObject moto1 = (JSONObject) moto;
                if (numImmatriculation.equals(moto1.get("numImmatriculation"))) { //See if the cin matches the object
                    vehicule.setNumImmatriculation((Long) moto1.get("numImmatriculation"));
                    vehicule.setDisponible((boolean) moto1.get("disponible"));
                    vehicule.setMarque((String) moto1.get("marque"));
                    vehicule.setKilometrageTotal((double) moto1.get("kilometrageTotal"));
                    vehicule.setKilometrageMax((double) moto1.get("kilometrageMax"));
                    vehicule.setNbKilometresRestant((double) moto1.get("nbKilometresRestant"));
                    //Date Mise En Service
                    Object sDate1 = (Object) moto1.get("dateMiseEnService");
                    if (sDate1 != null) {
                        String date = (String) sDate1;
                        LocalDate localDate = LocalDate.parse(date);
                        vehicule.setDateMiseEnService(localDate);
                    } else {
                        vehicule.setDateMiseEnService(null);
                    }
                    //Date Prochain Entretien
                    sDate1 = (Object) moto1.get("dateProchainEntretien");
                    if (sDate1 != null) {
                        String date = (String) sDate1;
                        LocalDate localDate = LocalDate.parse(date);
                        vehicule.setDateProchainEntretien(localDate);
                    } else {
                        vehicule.setDateProchainEntretien(null);
                    }
                    return vehicule;
                }
            }
        } catch(FileNotFoundException e){
            //e.printStackTrace();
            System.out.println("FILE NOT FOUND");
        } catch(IOException e){
            e.printStackTrace();
        } catch(ParseException e){
//            System.out.println("PROBLEM WITHIN THE JSON FILE! CHECK THE FORMAT! CANNOT PARSE THE FILE !");
            //e.printStackTrace();
        }

        return null;
    }

    /**
     * Return All available camions brands
     * */
    public static Marques getAllMarquesCamions(){
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        Marques marques = new Marques();

        try (FileReader reader = new FileReader("src/main/java/com/autoEcole/data/marques/camionsMarques.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of marques in JSON ARRAY Format
            JSONArray marquesList = (JSONArray) obj;
            JSONObject marque1 = (JSONObject) marquesList.get(0);
            marques.setMarques((List<String>) marque1.get("marques"));
            return marques;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            //e.printStackTrace();
//            System.out.println("THERE ARE NO ACTUAL BRANDS FOR CAMION, OR IT MIGHT BE A PROBLEM WHILE PARSING THE FILE");
        }

        return null;
    }
}
