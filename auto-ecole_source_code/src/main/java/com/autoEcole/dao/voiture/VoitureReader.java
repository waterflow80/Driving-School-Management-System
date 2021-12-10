package com.autoEcole.dao.voiture;

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

public class VoitureReader {


    /**
     * Return the full list of Cars
     */
    public static List<Vehicule> getAll() {
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();


        List<Vehicule> vehicules = new ArrayList<Vehicule>();

        try (FileReader reader = new FileReader("src/main/java/com/autoEcole/data/voitures.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray vehiculesList = (JSONArray) obj;
            for (Object vehic : vehiculesList) {
                JSONObject vehic1 = (JSONObject) vehic;
                Vehicule voiture = new Vehicule();

                voiture.setNumImmatriculation((Long) vehic1.get("numImmatriculation"));
                voiture.setDisponible((boolean) vehic1.get("disponible"));
                voiture.setMarque((String) vehic1.get("marque"));
                voiture.setKilometrageTotal((double) vehic1.get("kilometrageTotal"));
                voiture.setKilometrageMax((double) vehic1.get("kilometrageMax"));
                voiture.setNbKilometresRestant((double) vehic1.get("nbKilometresRestant"));
                //Date Mise En Service
                Object sDate1 = (Object) vehic1.get("dateMiseEnService");
                if (sDate1 != null) {
                    String date = (String) sDate1;
                    LocalDate localDate = LocalDate.parse(date);
                    voiture.setDateMiseEnService(localDate);
                } else {
                    voiture.setDateMiseEnService(null);
                }
                //Date Prochain Entretien
                sDate1 = (Object) vehic1.get("dateProchainEntretien");
                if (sDate1 != null) {
                    String date = (String) sDate1;
                    LocalDate localDate = LocalDate.parse(date);
                    voiture.setDateProchainEntretien(localDate);
                } else {
                    voiture.setDateProchainEntretien(null);
                }
                //Adding car to cars list
                vehicules.add(voiture);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("FILE NOT FOUND");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            //e.printStackTrace();
//            System.out.println("THERE ARE NO ACTUAL CARS, OR IT MIGHT BE A PROBLEM WHILE PARSING THE FILE");
        }

        return vehicules;
    }

    /**
     * Return one Seance Code by number
     */
    public static Vehicule getVehiculeByNumImmatriculation(Long numImmatriculation) {
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();


        Vehicule vehicule = new Vehicule();

        try (FileReader reader = new FileReader("src/main/java/com/autoEcole/data/voitures.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            //list of condidats in JSON ARRAY Format
            JSONArray voituresList = (JSONArray) obj;
            for (Object voit : voituresList) {
                JSONObject voit1 = (JSONObject) voit;
                if (numImmatriculation.equals(voit1.get("numImmatriculation"))) { //See if the cin matches the object
                    vehicule.setNumImmatriculation((Long) voit1.get("numImmatriculation"));
                    vehicule.setDisponible((boolean) voit1.get("disponible"));
                    vehicule.setMarque((String) voit1.get("marque"));
                    vehicule.setKilometrageTotal((double) voit1.get("kilometrageTotal"));
                    vehicule.setKilometrageMax((double) voit1.get("kilometrageMax"));
                    vehicule.setNbKilometresRestant((double) voit1.get("nbKilometresRestant"));
                    //Date Mise En Service
                    Object sDate1 = (Object) voit1.get("dateMiseEnService");
                    if (sDate1 != null) {
                        String date = (String) sDate1;
                        LocalDate localDate = LocalDate.parse(date);
                        vehicule.setDateMiseEnService(localDate);
                    } else {
                        vehicule.setDateMiseEnService(null);
                    }
                    //Date Prochain Entretien
                    sDate1 = (Object) voit1.get("dateProchainEntretien");
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
     * Return All available cars brands
     * */
    public static Marques getAllMarquesVoitures(){
        @SuppressWarnings("unchecked")
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        Marques marques = new Marques();

        try (FileReader reader = new FileReader("src/main/java/com/autoEcole/data/marques/voituresMarques.json")) {
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
            System.out.println("THERE ARE NO ACTUAL BRANDS FOR CARS, OR IT MIGHT BE A PROBLEM WHILE PARSING THE FILE");
        }

        return null;
    }
}
