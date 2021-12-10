package com.autoEcole.gui.inputs;


import com.autoEcole.dao.Seances.SeanceCodeReader;
import com.autoEcole.dao.Seances.SeanceConduiteReader;
import com.autoEcole.dao.camion.CamionReader;
import com.autoEcole.dao.engineer.EngineerReader;
import com.autoEcole.dao.moto.MotoReader;
import com.autoEcole.dao.voiture.VoitureReader;
import com.autoEcole.entities.condiats.Condidat;
import com.autoEcole.entities.ingenieurs.Ingenieur;
import com.autoEcole.entities.marqueVehicule.Marques;
import com.autoEcole.entities.seances.Seance;
import com.autoEcole.entities.seances.SeanceCode;
import com.autoEcole.entities.seances.SeanceConduite;
import com.autoEcole.entities.vehicules.Vehicule;
import com.autoEcole.managemeent.Prix;
import com.autoEcole.services.CondidatService;
import com.autoEcole.services.IngenieurService;
import com.autoEcole.services.SeanceCodeService;
import com.autoEcole.services.SeanceConduiteService;
import com.autoEcole.services.prix.PrixService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

public class InputChecker {

    private static final String[] mainMenuChoicesList = {"1", "2", "3", "4", "5", "6"};
    private static final String[] condidatesChoicesList = {"1", "2", "3", "4", "5", "6"};
    private static final String[] ajouterCondidatChoicesList = {"1", "2", "3"};
    private static final char[] drivingCategogryList = {'a', 'b', 'c'};
    private static final char[] yesOrNoAnswerList = {'y','n'};
    private static final char[] courseTypeList = {'d','c'};
    private static final int MAXMONTHPERIOD = 6; // The number of months after which you cannot have a session.
    public static final int[] thirtyDaysMonths = {4,6,9,11};
    public static final int[] thirtyOneDayMonths = {1,3,5,7,8,10,12};
    public static final int MinWorkingHour = 4;
    public static final int MaxWorkingHour = 18;
    public static final int LENGTH_NUM_IMMATRICULATION = 6;
    public static final char[] updateAttributeChoicesMenuList = {'1','2','3','4'}; //1: montant payee code, 2: m p conduite, 3:date examen 4: examen payee
    public static final char[] updateAttributeChoicesList = {'1','2'}; // 1: add new, 2: add to existing
    public static final String[] seanceMainMenuChoicesList = {"1","2","3"}; //1: seance code, 2: seance conduite, 3: menu principale
    public static final String[] seanceCodeMenuChoicesList = {"1", "2", "3", "4", "5"};
    public static final String[] motoMenuChoicesList = {"1", "2", "3", "4", "5"};
    public static final String[] voitureMenuChoicesList = {"1", "2", "3", "4", "5"};
    public static final String[] camionMenuChoicesList = {"1", "2", "3", "4", "5"};
    public static final String[] flotteMenuChoicesList = {"1", "2", "3", "4"};
    public static final String[] IngenieurMenuChoicesList = {"1", "2", "3", "4", "5", "6"};
    public static final String[] salaireMenuChoicesList = {"1", "2"};

    /**
     * Test if the choice is in the range of the condidatesChoicesList
     */
    public static boolean validCondidateChoice(String choice) {
        for (String s: condidatesChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Test if the choice is in the range of the mainMenuChoicesList
     */
    public static boolean validMainMenuChoice(String choice) {
        for (String s: mainMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Test if the choice is in the range of the ajouterCondidatChoicesList
     */
    public static boolean validAjouterCondidatMenuChoice(String choice) {
        for (String s: ajouterCondidatChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Test if a string contains only alphabets, with no spaces
     */
    public static boolean isAlpha(String s){
        if (s == null)
            return false;
        for (int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if ( !(c <= 'Z' && c >= 'A') && !(c <= 'z' && c >= 'a') )
                return false;
        }
        return true;
    }

    /**
     * Check if the name is valid or not:not empty and contains only alphabets, with no spaces
     */
    public static boolean validName(String name) {
        if (name.length() == 0)
            return false;
        else return isAlpha(name);
    }

    /**
     * Check if the cin is valid or not and there's a candidate in the database with that cin
     * cin: catre identité nationale
     */
    public static boolean validCinCondidatForUpdate(String cin){
        if ( !(cin.charAt(0) == '1') && !(cin.charAt(0) == '0') ) //!we need to check if it's not all zeros
            return false;
        else
            return cin.length() == 8 && (CondidatService.condidatExistWithCin(cin));
    }


    /**
     * Check if the cin is valid or not, and there's an engineer in the database with that cin
     * cin: catre identité nationale
     */
    public static boolean validCinEngineerForUpdate(String cin){
        if ( !(cin.charAt(0) == '1') && !(cin.charAt(0) == '0') )
            return false;
        else
            return cin.length() == 8 && (IngenieurService.ingenieurExistsWithCin(cin));
    }

    /**
     * Check if the cin is valid or not and if  there's no other candidate with the same cin
     * cin: catre identité nationale
     */
    public static boolean validCin(String cin){
        if ( !(cin.charAt(0) == '1') && !(cin.charAt(0) == '0') )
            return false;
        else
            return cin.length() == 8 && !(CondidatService.condidatExistWithCin(cin));
    }

    /**
     * Check if the cin is valid or not and if there's no other engineer with the same cin
     * cin: catre identité nationale
     */
    public static boolean validIngenieurCin(String cin){
        if ( !(cin.charAt(0) == '1') && !(cin.charAt(0) == '0') )
            return false;
        else
            return cin.length() == 8 && !(IngenieurService.IngenieurExistWithCin(cin));
    }

    /**
     * Check if the age is between 18 and 110
     * (110: considering exceptional people)
     */
    public static boolean validAge(int age){
        if (age < 18)
            return false;
        else
            return age < 110;

    }

    /**
    * Check if the number is a valid Tunisian Phone Number
    */
    public static boolean validTunisiaPhoneNumber(int number){
        String number1 = Long.toString(number);
        if (!(number1.charAt(0) == '5') && !(number1.charAt(0) == '9') && !(number1.charAt(0) == '2') &&
                !(number1.charAt(0) == '4') && !(number1.charAt(0) == '7'))
            return false;
        else
            return number1.length() == 8;
    }

    /**
    * Check if the category of the driving licence entered is valid or not
    */
    public static boolean validCategory(char category){
        char categoryLower = Character.toLowerCase(category);
        for (char c: drivingCategogryList){
            if (categoryLower == c)
                return true;
        }
        return false;
    }

    /**
    * Check if the answer is either Y:yes ot N: no
    */
    public static boolean validYesOrNoAnswer(char answer){
        char answerLower = Character.toLowerCase(answer);
        for (char c: yesOrNoAnswerList){
            if (answerLower == c)
                return true;
        }
        return false;
    }

    /**
    * Check if the type of the session is valid or not
    */
    public static boolean validType(char type){
        char typeLower = Character.toLowerCase(type);
        for (char c: courseTypeList){
            if (typeLower == c)
                return true;
        }
        return false;
    }

    /**
    * Check if the year is valid or not, compatible with a session or not
    */
    public static boolean validYear(int year){
        int currentYear = Year.now().getValue(); //Get the current year
        if (year < currentYear) // The session should not be in the past
            return false;
        else // The session should not be after two or more years
            return (year <= currentYear+1);
    }

    /**
     * Check if the month is valid or not, compatible with a session or not
     * Check if the session is more than MAXMONTPERIOD away, incompatible in this case
     */
    public static boolean validMonth(int month, int year){
        LocalDate currentdate = LocalDate.now();
        int currentYear = Year.now().getValue(); //Get the current year
        int currentMonth = currentdate.getMonth().getValue(); //Get the current month
        if (month <=0 || month >12)
            return false;
        else if(year > currentYear){
            int deltaMonth = month + (12 - currentMonth);
            return deltaMonth <= MAXMONTHPERIOD;
        } else if (year == currentYear){
            return month >= currentMonth;
        }
        return true;
    }

    /**
    * Check if the day is valid or not, (compatible with a session or not)
    * should not be in the past
    */
    public static boolean validDay(int month, int day,int year){
        LocalDate currentdate = LocalDate.now();
        int currentMonth = currentdate.getMonth().getValue(); //Get the current month
        int currentYear = Year.now().getValue(); //Get the current year
        int currentDay = currentdate.getDayOfMonth(); //Get the current day
        if (day <=0 )
            return false;
        else if (year == currentYear && month == currentMonth){ // case of today
            if (isThirtyDayMonth(month))
                return day >= currentDay && day <=30;
            else if(isThirtyOneDayMonth(month))
                return day >= currentDay && day <=31;
            else
                return day >= currentDay && day <=28;
        }
        else{
            if (isThirtyDayMonth(month))
                return day <=30 ;
            else if (isThirtyOneDayMonth(month))
                return day <=31 ;
            else // February
                return day <=28 ;
        }

    }

    /**
    * Check if the month contains thirty days or no
    */
    public static boolean isThirtyDayMonth(int month){
        for (int thirtyDaysMonth : thirtyDaysMonths) {
            if (thirtyDaysMonth == month)
                return true;
        }
        return false;
    }

    /**
     * Check if the month contains thirty one days or no
     */
    public static boolean isThirtyOneDayMonth(int month){
        for (int thirtyOneDayMonth : thirtyOneDayMonths) {
            if (thirtyOneDayMonth == month)
                return true;
        }
        return false;
    }

    /**
     * Check if the hour is valid or not, and can be chosen for the session
     * */
    public static boolean validHour(int hour, int day,int month, int year){
        LocalDate currentdate = LocalDate.now();
        int currentHour = LocalDateTime.now().getHour(); //Get the current hour
        int currentDay = currentdate.getDayOfMonth(); //Get the current day
        int currentYear = Year.now().getValue(); //Get the current year
        int currentMonth = currentdate.getMonth().getValue(); //Get the current month
        if (hour < MinWorkingHour || hour > MaxWorkingHour)
            return false;
        else if (day == currentDay && month == currentMonth && year == currentYear){ // The session is today
            return hour > currentHour;
        }else
            return true;
    }

    /**
     * Check if the session number is correct or no, exists or no
     * */
    public static boolean validSeanceNumber(int number){
        if (number <=0)
            return false;
        else{
            List<SeanceCode> seancesCode = SeanceCodeService.getAllSeancesCode();
            for (Seance sc : seancesCode){
                if (sc.getNumber() == number){
                    return false;
                }
            }
            List<SeanceConduite> seancesConduites = SeanceConduiteService.getAllSeancesConduite();
            for (Seance sc : seancesConduites){
                if (sc.getNumber() == number){
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Check if the num immatriculation is valid or no
     * */
    public static boolean validNumImmatriculation(Long num){
        String number1 = Long.toString(num);
        return number1.length() == LENGTH_NUM_IMMATRICULATION;
    }

    /**
     * Check if the choice entered is within the available update choices
     * */
    public static boolean validUpdateAttributeChoiceMenu(char option){
        char optionLower = Character.toLowerCase(option);
        for (char c: updateAttributeChoicesMenuList){
            if (optionLower == c)
                return true;
        }
        return false;
    }

    /**
     * Check if the choice entered is within the available operations to be made over the attribute
     * */
    public static boolean validUpdateAttributeChoice(char option){
        char optionLower = Character.toLowerCase(option);
        for (char c: updateAttributeChoicesList){
            if (optionLower == c)
                return true;
        }
        return false;
    }

    /**
     * Check if the new amount of money is in the range of the code's session price
     * */
    public static boolean validNewMontantCode(char categorie ,float montant, int nbSeance){
        return montant >=0 && montant <= PrixService.prixSeancesCode(categorie,nbSeance);
    }

    /**
     * Check if the new amount of money is in the range of the driving's session price
     * */
    public static boolean validNewMontantConduite(char categorie ,float montant, int nbSeance){
        return montant >=0 && montant <= PrixService.prixSeancesConduite(categorie,nbSeance);
    }

    /**
     * Check if the montant to add is compatible or not
     * (between 0 and max price)
     * */
    public static boolean validMontantToAddCode(float newMontant, Condidat condidat){
        return newMontant >=0 && newMontant<= CondidatService.montantRestantCode(condidat, condidat.getCategorie(), condidat.getNbSeances());
    }

    /**
     * Check if the montant to add is compatible or not
     * (between 0 and max price)
     * */
    public static boolean validMontantToAddConduite(float newMontant, Condidat condidat){
        return newMontant >=0 && newMontant<= CondidatService.montantRestantConduite(condidat,condidat.getCategorie(),condidat.getNbSeances());
    }

    /**
     * Check if the choice is within the valid choices
     * 1 / 2 / 3
     * */
    public static boolean validSeanceMainMenuChoice(String choice){
        for (String s: seanceMainMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Check if the choice is within the range of [1,5]
     * */
    public static boolean validSeanceCodeMenuChoice(String choice){
        for (String s: seanceCodeMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Check if the number of candidates is grater or equal to 2
     * */
    public static boolean validNumberOfCandidates(int number){
        return number >= 2;
    }

    /**
     * Check if there's a candidate with the coressponding cin number
     * */
    public static boolean existedCondidatCinNumber(String cin){
        Condidat condidat = CondidatService.getCondidatByCin(cin);
        return condidat != null;
    }

    /**
     * Check if the number enterd is less ot equal to the current number of candidates
     * */
    public static boolean numberWithinTheRangeOfExistingCandidates(int number){
        return number <= CondidatService.getNumberOfCondidats();
    }

    /**
     * Check if the there is an engineer with the corresponding cin
     * */
    public static boolean existedEngineerCin(String cin){
        return IngenieurService.ingenieurExistsWithCin(cin);
    }

    /**
     * Check if the engineer entered is available in the day of the session
     * */
    public static boolean availableEngineerCin(String cin, LocalDate date){
        Ingenieur ingenieur = EngineerReader.getEngineerByCin(cin);
        if (ingenieur !=null) {
            if (ingenieur.getSeancesDates() == null)
                return true;
            else {
                for (LocalDate ld: ingenieur.getSeancesDates()) {
                    if (ld.compareTo(date) == 0)
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the choice enterd is within the range of the provided choices
     * */
    public static boolean validFlotteMenuChoice(String choice){
        for (String s: flotteMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Check if the Num Immatriculation of the moto matches any existed moto
     * */
    public static boolean existedMotoNumImmatriculation(Long num){
        List<Vehicule> motos = MotoReader.getAll();
        for (Vehicule m: motos){
            if (m.getNumImmatriculation().compareTo(num) == 0)
                return true;
        }
        return false;
    }

    /**
     * Check if the Num Immatriculation of the voiture matches any existed voiture
     * */
    public static boolean existedVoitureNumImmatriculation(Long num){
        List<Vehicule> voitures = VoitureReader.getAll();
        for (Vehicule m: voitures){
            if (m.getNumImmatriculation().compareTo(num) == 0)
                return true;
        }
        return false;
    }

    /**
     * Check if the Num Immatriculation of the camion matches any existed camion
     * */
    public static boolean existedCamionNumImmatriculation(Long num){
        List<Vehicule> camions = MotoReader.getAll();
        for (Vehicule m: camions){
            if (m.getNumImmatriculation().compareTo(num) == 0)
                return true;
        }
        return false;
    }

    /**
     * Check if the number corresponds to an existing seance code number
     * */
    public static boolean existedSeanceCodeNumber(Long number){
        List<SeanceCode> seanceCodes = SeanceCodeReader.getAll();
        for (SeanceCode s: seanceCodes){
            if (s.getNumber().compareTo(number) == 0)
                return true;
        }
        return false;
    }

    /**
     * Check if the number corresponds to an existing seance conduite number
     * */
    public static boolean existedSeanceConduiteNumber(Long number){
        List<SeanceConduite> seanceConduites = SeanceConduiteReader.getAll();
        for (SeanceConduite s: seanceConduites){
            if (s.getNumber().compareTo(number) == 0)
                return true;
        }
        return false;
    }

    /**
     * Check if the choice is within the range of [1,5]
     * */
    public static boolean validmotoMenuChoice(String choice){
        for (String s: motoMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Check if the choice is within the range of [1,5]
     * */
    public static boolean validvoitureMenuChoice(String choice){
        for (String s: voitureMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Check if the choice is within the range of [1,5]
     * */
    public static boolean validcamionMenuChoice(String choice){
        for (String s: camionMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Check if the marque entered corresponds to an existing moto marque
     * (all marques are in the motoMaques json file)
     * */
    public static boolean existedMarqueMoto(String marque){
        Marques allMarques = MotoReader.getAllMarquesMotos();
        for (String s:allMarques.getMarques()){
            if (s.toLowerCase().equals(marque.toLowerCase()))
                return true;
        }
        return false;
    }

    /**
     * Check if the marque entered corresponds to an existing camion marque
     * (all marques are in the motoMaques json file)
     * */
    public static boolean existedMarqueCamion(String marque){
        Marques allMarques = CamionReader.getAllMarquesCamions();
        for (String s:allMarques.getMarques()){
            if (s.toLowerCase().equals(marque.toLowerCase()))
                return true;
        }
        return false;
    }

    /**
     * Check if the marque entered corresponds to an existing voiture marque
     * (all marques are in the motoMaques json file)
     * */
    public static boolean existedMarqueVoiture(String marque){
        Marques allMarques = VoitureReader.getAllMarquesVoitures();
        for (String s:allMarques.getMarques()){
            if (s.toLowerCase().equals(marque.toLowerCase()))
                return true;
        }
        return false;
    }

    /**
     * Check id the choice entered by the user is a valid choice
     * (within the range of choices [1,6])
     * */
    public static boolean validIngenieurMenuChoice(String choice){
        for (String s: IngenieurMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }

    /**
     * Check if the option entered is within the range of available options
     * 1 or 2
     * */
    public static boolean validSalaireMenuChoice(String choice){
        for (String s: salaireMenuChoicesList)
            if (s.equals(choice))
                return true;
        return false;
    }


}
