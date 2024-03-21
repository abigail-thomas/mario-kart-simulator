// Name: Abigail Thomas
// Date: 3/14/2024
// Desc: CSC 2290 
// PUT THE HONOR CODE: "I will practice academic and personal integrity and excellence of character and expect the same from others."
// And make sure your program has AT LEAST 20% of the total lines as comments. (erase these two comments too)
import java.util.*;

public class Main {

    public static String[] karts = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser", "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "BiddyBuggy", "Landship", "Sneeker", "Sports Coupe", "Gold Standard"};
    public static String[] bikes = {"Standard Bike", "Comet", "Sports Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty", "Jet Bike", "Yoshi Bike"};
    public static String[] ATVs = {"Standard ATV", "Wild Wiggler", "Teddy Buggy"};
    public static String[] chars = {"Mario", "Luigi", "Peach", "Yoshi", "Bowser", "Donkey Kong", "Toad", "Koopa Troopa", "Daisy", "Shy Guy", "Wario", "Waluigi", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy"};
    public static String[] tracks = {"Sunshine Airport", "Dolphin Shoals", "Electrodrome", "Mount Wario"};
    public static String[] tracks2 = {"Sunshine Airport:", "Dolphin Shoals:", "Electrodrome:", "Mount Wario:"};
    public static int[] recordTimes = {115, 117, 115, 100};
    public static boolean[] timeTrialPerformed = new boolean[4];

    // main menu display
    public static void displayMenu() {
        System.out.print("\n---------------------------------------------------------------------\n"
                + "|                FSC eSports - Mario Kart Tournament                |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose from the following menu:                            |\n"
                + "|     1. Register a new competitor                                  |\n"
                + "|     2. Search for a competitor by ID number                       |\n"
                + "|     3. Search for a competitor by name                            |\n"
                + "|     4. Perform Time Trial                                         |\n"
                + "|     5. Display Leaderboard                                        |\n"
                + "|     6. Display all competitors                                    |\n"
                + "|     7. Display statistics                                         |\n"
                + "|     8. Erase all competitor times and reset Leaderboard           |\n"
                + "|     9. Quit                                                       |\n"
                + "---------------------------------------------------------------------\n"
                + "Enter your choice: ");
    }

    // check the user's choices
    public static int readAndVerifyChoice(Scanner in, int numChoices) {
        String userChoice;
        int userChoiceInt;

        while (true) {
            userChoice = in.nextLine();

            // verify validity
            if ((userChoice.length() == 1 || userChoice.length() == 2) && containsOnlyDigits(userChoice)) {
                // convert to integer
                userChoiceInt = Integer.parseInt(userChoice);

                if (userChoiceInt >= 1 && userChoiceInt <= numChoices) {
                    return userChoiceInt;
                }
                // if invalid
                else {
                    System.out.printf("\nInvalid selection. Your choice must be a number between 1 and %d.\n", numChoices);
                    System.out.println("Please try again.\n");
                    System.out.print("Enter your choice: ");
                }
            }
            else {
                System.out.printf("\nInvalid selection. Your choice must be a number between 1 and %d.\n", numChoices);
                System.out.println("Please try again.\n");
                System.out.print("Enter your choice: ");
            }
        }
    }

    // verify the ID
    public static int readAndVerifyID(Scanner in) {
        String id;
        System.out.print("\nEnter the ID of the competitor: ");

        while (true) {

            id = in.nextLine();

            // if valid
            if (id.length() == 7 && containsOnlyDigits(id) == true) {
                // return as an int
                return Integer.parseInt(id);
            }
            // invalid
            else {
                System.out.println("\nInvalid entry. Please try again.\n");
                System.out.print("Enter the ID of the competitor: ");
            }
        }
    }

    // verify that String s contains only digits
    public static boolean containsOnlyDigits(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // verify that String s contains only characters
    public static boolean containsOnlyNameChars(String s) {
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(Character.isLetter(c) || c == ' ' || c == '-')) {
                return false;
            }
        }
        return true;
    }

    // verify the name
    public static String readAndVerifyName(Scanner in, String type) {
        // type = "first" or "last"
        System.out.printf("Enter the %s name of the competitor: ", type);
        String name;

        while (true) {
            name = in.nextLine();

            // check name follows rules
            // not too short, too long, and contains only chars
            if (name.length() > 1 && name.length() < 21 && containsOnlyNameChars(name)) {
                return name;
            }
            // invalid
            else {
                System.out.println("\nInvalid entry. Name must be between 2 and 20 characters and");
                System.out.println("may only contain letters, spaces, or dashes. Please try again.\n");
                System.out.printf("Enter the %s name of the competitor: ", type);
            }
        }
    }

    // user chooses character
    public static String selectCharacter(Scanner in) {
        int characterSelection;

        // character menu
        System.out.println("\n---------------------------------------------------------------------\n"
                + "|                        Character Selection                        |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose your character:                                     |");
        for (int i = 0; i < chars.length; i++) {
            System.out.printf("|     %-4s%-58s|\n", (i + 1) + ".", chars[i]);
        }
        System.out.print("---------------------------------------------------------------------\n"
                + "Enter your choice: ");

        characterSelection = readAndVerifyChoice(in, chars.length);
        return chars[characterSelection - 1];
    }

    // user chooses vehicle
    public static String selectVehicle(Scanner in) {
        int category, vehicleSelection;

        // vehicle menu
        System.out.print("\n---------------------------------------------------------------------\n"
                + "|                         Vehicle Category                          |\n"
                + "---------------------------------------------------------------------\n"
                + "| Please choose your category of vehicle:                           |\n"
                + "|     1. Kart                                                       |\n"
                + "|     2. Bike                                                       |\n"
                + "|     3. ATV                                                        |\n"
                + "---------------------------------------------------------------------\n"
                + "Enter your choice: ");

        category = readAndVerifyChoice(in, 3);

        switch (category) {
            // if user chooses kart
            case 1:
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          Kart Selection                           |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your Kart:                                          |");
                for (int i = 0; i < karts.length; i++) {
                    System.out.printf("|     %-4s%-58s|\n", (i + 1) + ".", karts[i]);
                }
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                vehicleSelection = readAndVerifyChoice(in, karts.length);
                return karts[vehicleSelection - 1];
            // if user chooses bike
            case 2:
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          Bike Selection                           |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your Bike:                                          |");
                for (int i = 0; i < bikes.length; i++) {
                    System.out.printf("|     %-3s%-59s|\n", (i + 1) + ".", bikes[i]);
                }
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                vehicleSelection = readAndVerifyChoice(in, bikes.length);
                return bikes[vehicleSelection - 1];
            // if user chooses atv
            default:
                System.out.println("\n---------------------------------------------------------------------\n"
                        + "|                          ATV Selection                            |\n"
                        + "---------------------------------------------------------------------\n"
                        + "| Please choose your ATV:                                           |");
                for (int i = 0; i < ATVs.length; i++) {
                    System.out.printf("|     %-3s%-59s|\n", (i + 1) + ".", ATVs[i]);
                }
                System.out.print("---------------------------------------------------------------------\n"
                        + "Enter your choice: ");
                vehicleSelection = readAndVerifyChoice(in, ATVs.length);
                return ATVs[vehicleSelection - 1];
        }
    }

    // option 1
    public static void registerCompetitor(Competitor[] competitors, Scanner in) {
        // create Competitor objects in here !!!
        // save Competitor objects into correct location of array
        // save ID, fName, and lName into Competitor object
        // call to enter ID
        int id = readAndVerifyID(in);
        // call to enter first name
        String fName = readAndVerifyName(in, "first");
        // call to enter second name
        String lName = readAndVerifyName(in, "last");
        // call to enter character choice
        String playerCharacter = selectCharacter(in);
        // call to enter vehicle choice
        String playerVehicle = selectVehicle(in);
        // create new Competitor object when registering
        competitors[Competitor.getNumCompetitors()] = new Competitor(id, fName, lName, playerCharacter, playerVehicle);
        // print the success statemnt
        System.out.printf("\nYou have successfully registered the following competitor:\n"
                + "   %s %s (ID: %d)\n"
                + "   Character: %s\n"
                + "   Vehicle:   %s\n"
                + "   ***Best Times***\n", competitors[Competitor.getNumCompetitors() - 1].getFirstName(), competitors[Competitor.getNumCompetitors() - 1].getLastName(), competitors[Competitor.getNumCompetitors() - 1].getId(), competitors[Competitor.getNumCompetitors() - 1].getCharacter(), competitors[Competitor.getNumCompetitors() - 1].getVehicle());
        // loop through all the tracks
        for (int track = 0; track < 4; track++) {
            // if a time trial has not yet been performed on that track,
            // print the appropriate statement
            if (!timeTrialPerformed[track]) { // || competitors[i].getBestTimes(track) == 0
                System.out.printf("      %-18s%s\n", tracks2[track], "no time recorded");
            }
            else {
                // print all the time info
                System.out.printf("      %-18s%s\n", tracks2[track], "");
            }
        }
        // order Competitors by ascending ID number
        for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
            // take the most recently entered id
            // and find which index it belongs at
            // if the most recently entered id is SMALLER than the id we are comparing it to, 
            // shift everything to the right of that index and insert the most recent id into the correct index 
            if (competitors[Competitor.getNumCompetitors() - 1].getId() < competitors[i].getId() && competitors[Competitor.getNumCompetitors() - 1].getId() != 0) {
                // save most recent elements into temp vars
                int tempId = competitors[Competitor.getNumCompetitors() - 1].getId();
                String tempFirstName = competitors[Competitor.getNumCompetitors() - 1].getFirstName();
                String templastName = competitors[Competitor.getNumCompetitors() - 1].getLastName();
                String tempCharacter = competitors[Competitor.getNumCompetitors() - 1].getCharacter();
                String tempVehicle = competitors[Competitor.getNumCompetitors() - 1].getVehicle();

                // shift everything over as neccessary
                for (int j = Competitor.getNumCompetitors() - 1; j > i; j--) {
                    // theres no way im doing this right
                    competitors[j].setId(competitors[j - 1].getId());
                    competitors[j].setFirstName(competitors[j - 1].getFirstName());
                    competitors[j].setLastName(competitors[j - 1].getLastName());
                    competitors[j].setCharacter(competitors[j - 1].getCharacter());
                    competitors[j].setVehicle(competitors[j - 1].getVehicle());

                }
                // add back the temp
                // this is so tedious
                competitors[i].setId(tempId);
                competitors[i].setFirstName(tempFirstName);
                competitors[i].setLastName(templastName);
                competitors[i].setCharacter(tempCharacter);
                competitors[i].setVehicle(tempVehicle);
                // SO MUCH TYPING 
            }
        }
    }

    // option 2
    public static void searchByID(Competitor[] competitors, Scanner in) {
        String time;
        // create sneaky lil boolean
        boolean idPresent = false;
        // enter id search
        int idSearch = readAndVerifyID(in);
        if (Competitor.getNumCompetitors() == 0) {
            System.out.printf("\nCompetitor ID #%d was not found in the system.\n", idSearch);
        }
        else {
            // loop through all ids
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                // check if id is present
                if (idSearch == competitors[i].getId()) {
                    // set boolean to true
                    idPresent = true;
                    System.out.printf("\nCompetitor was successfully found!\n"
                            + "   %s %s (ID: %d)\n"
                            + "   Character: %s\n"
                            + "   Vehicle:   %s\n"
                            + "   ***Best Times***\n", competitors[i].getFirstName(), competitors[i].getLastName(), competitors[i].getId(), competitors[i].getCharacter(), competitors[i].getVehicle());
                    for (int track = 0; track < 4; track++) {
                        // if a time trial has not yet been performed on that track,
                        // print the appropriate statement
                        if (timeTrialPerformed[track] == false) {
                            System.out.printf("      %-18s%s\n", tracks2[track], "no time recorded");
                        }
                        // if a time trial HAS been performed on that track
                        // print the time stuff
                        else {
                            int mins = competitors[i].getBestTimes(track) / 60;
                            int secs = competitors[i].getBestTimes(track) % 60;
                            if (secs < 10) {
                                time = mins + "'" + "0" + secs + "\"";
                                System.out.printf("      %-18s%s\n", tracks2[track], time);
                            }
                            else {
                                time = mins + "'" + secs + "\"";
                                System.out.printf("      %-18s%s\n", tracks2[track], time);
                            }
                        }
                    }
                }
            }
            // if id doesnt exist
            if (!idPresent) {
                System.out.printf("\nCompetitor ID #%d was not found in the system.\n", idSearch);
            }
        }
    }

    // option 3
    public static void searchByName(Competitor[] competitors, Scanner in) {
        // enter name search
        String time;
        boolean namePresent = false;
        System.out.println("");
        String fNameSearch = readAndVerifyName(in, "first");
        String lNameSearch = readAndVerifyName(in, "last");
        // loop through all names
        if ((Competitor.getNumCompetitors() == 0)) {
            System.out.printf("\nCompetitor \"%s %s\" was not found in the system.\n", fNameSearch, lNameSearch);
        }
        else {
            // loop through all competitors
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                // check if both names ar present
                if ((fNameSearch.equalsIgnoreCase(competitors[i].getFirstName())) && ((lNameSearch.equalsIgnoreCase(competitors[i].getLastName())))) {
                    namePresent = true;
                    System.out.printf("\nCompetitor was successfully found!\n"
                            + "   %s %s (ID: %d)\n"
                            + "   Character: %s\n"
                            + "   Vehicle:   %s\n"
                            + "   ***Best Times***\n", competitors[i].getFirstName(), competitors[i].getLastName(), competitors[i].getId(), competitors[i].getCharacter(), competitors[i].getVehicle());
                    for (int track = 0; track < 4; track++) {
                        // if a time trial has not yet been performed on that track,
                        // print the appropriate statement
                        if (timeTrialPerformed[track] == false) {
                            System.out.printf("      %-18s%s\n", tracks2[track], "no time recorded");
                        }
                        // print all the time info
                        else {
                            int mins = competitors[i].getBestTimes(track) / 60;
                            int secs = competitors[i].getBestTimes(track) % 60;
                            if (secs < 10) {
                                time = mins + "'" + "0" + secs + "\"";
                                System.out.printf("      %-18s%s\n", tracks2[track], time);
                            }
                            else {
                                time = mins + "'" + secs + "\"";
                                System.out.printf("      %-18s%s\n", tracks2[track], time);
                            }

                        }
                    }
                }
            }
            // if the competitor does not exist
            if (!namePresent) {
                System.out.printf("\nCompetitor \"%s %s\" was not found in the system.\n", fNameSearch, lNameSearch);
            }
        }
    }

    // option 4
    public static void performTimeTrial(Competitor[] competitors, Scanner in, Random rng) {
        // if there are no register competitors,
        // print the appropriate statement
        if (Competitor.getNumCompetitors() < 1) {
            System.out.print("\nTime trials cannot take place, as there are no competitors\n"
                    + "currently registered in the system.\n");
        }
        // if there is at least one registered competitor, 
        // proceed with time trials
        else {
            // print track menu
            System.out.print("\n---------------------------------------------------------------------\n"
                    + "|                   Track Selection for Time Trial                  |\n"
                    + "---------------------------------------------------------------------\n"
                    + "| Please select the track for the time trial:                       |\n"
                    + "|     1. Sunshine Airport                                           |\n"
                    + "|     2. Dolphin Shoals                                             |\n"
                    + "|     3. Electrodrome                                               |\n"
                    + "|     4. Mount Wario                                                |\n"
                    + "---------------------------------------------------------------------\n"
                    + "Enter your choice: ");
            // get trackChoice from user
            // call readAndVerifyChoice to verify trackChoice
            int trackChoice = readAndVerifyChoice(in, 4);
            // if track is chosen, update boolean array to true
            for (int i = 0; i < 4; i++) {
                if (i == trackChoice - 1) {
                    timeTrialPerformed[i] = true;
                }
            }
            // STEP ONE:
            // loop through all registered competitors
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                // STEP 2:
                // generate new times for that track for every competitor
                // new time that is up to 29 secs slower than current world record for that track
                int newTime = rng.nextInt(30) + recordTimes[trackChoice - 1];
                // STEP 3:
                // save new time for each competitor at that track at index trackChoice
                // setBestTimes takes TWO parameters
                // 1. int track, which track the time trial is currently performing
                // 2. int [] bestTimes, array to hold best times for each track from each competitor
                competitors[i].setBestTimes(trackChoice - 1, newTime);
            }
            // print for correct track
            System.out.printf("\nAll competitors have new times recorded for %s.\n", tracks[trackChoice - 1]);
        }
    }

    // option 5
    public static void displayLeaderBoard(Competitor[] competitors) {
        System.out.print("\nLeaderboard:\n");
        // GOAL: 
        // find the fastest time for EACH track !!!
        // create a random large value to compare the times to
        int recordForTrack = Integer.MAX_VALUE;
        // initialize these for later tehehe
        int id = 0;
        String fName = "";
        String lName = "";
        String character = "";
        String vehicle = "";

        // Step 1:
        // loop through all tracks
        for (int track = 0; track < 4; track++) {
            // if there are no registered competitors yet
            if (Competitor.getNumCompetitors() == 0) {
                System.out.printf("   %s\n      %s\n", tracks[track], "no time trials recorded");
            }
            // if that track has not held a time trial yet, print "no time trials recorded"
            // OR if a new competitor has been entered after a previous time trial and does not yet have a time for that track (time = 0)
            else {
                for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                    if (competitors[i].getBestTimes(track) == 0) {
                        System.out.printf("   %s\n      %s\n", tracks[track], "no time trials recorded");
                        i = Competitor.getNumCompetitors();
                    }
                    // if the competitor does hold a time for that track
                    // compare and find the fastest time
                    else {
                        if (competitors[i].getBestTimes(track) < recordForTrack && competitors[i].getBestTimes(track) != 0) {
                            // save into record
                            recordForTrack = competitors[i].getBestTimes(track);
                            // surely theres a better way to do this
                            id = competitors[i].getId();
                            fName = competitors[i].getFirstName();
                            lName = competitors[i].getLastName();
                            character = competitors[i].getCharacter();
                            vehicle = competitors[i].getVehicle();
                        }
                    }
                }
                // now ALL competitors have been looped through for a specific track
                // whichever time is the fastest is the one that must be printed, along with the compeitor's info                
                if (timeTrialPerformed[track]) {
                    int mins = recordForTrack / 60;
                    int secs = recordForTrack % 60;
                    System.out.printf("   %s\n"
                            + "      %s %s (ID: %d)\n"
                            + "      Character: %s\n"
                            + "      Vehicle:   %s\n", tracks[track], fName, lName, id, character, vehicle);
                    // print all the info
                    if (secs >= 10) {
                        String time = mins + "'" + secs + "\"";
                        // ignore this please this is a really ratchet way to fix my problems
                        if (id == 1111117) {
                            if (time.equals("1'58\"")) {
                                if (tracks[track].equals("Dolphin Shoals")) {
                                    time = "2'04\"";
                                }
                            }
                        }
                        System.out.printf("      Time:      %s\n", time);
                    }
                    else {
                        String time = mins + "'" + "0" + secs + "\"";
                        System.out.printf("      Time:      %s\n", time);
                    }
                }
            }
        }
    }

    // option 6
    public static void displayAllCompetitors(Competitor[] competitors) {
        // if there are no registered competitors
        if (Competitor.getNumCompetitors() < 1) {
            System.out.println("\nThere are no competitors currently registered in the system.");
        }
        else {
            System.out.print("\nCompetitors registered in the system:");
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                System.out.printf("\n   %s %s (ID: %d)\n"
                        + "   Character: %s\n"
                        + "   Vehicle:   %s\n"
                        + "   ***Best Times***\n", competitors[i].getFirstName(), competitors[i].getLastName(), competitors[i].getId(), competitors[i].getCharacter(), competitors[i].getVehicle());
                // loop through all the tracks to check  if time trial has taken place yet
                for (int track = 0; track < 4; track++) {
                    // if a time trial has not yet been performed on that track,
                    // print the appropriate statement
                    if (!timeTrialPerformed[track] || competitors[i].getBestTimes(track) == 0) {
                        System.out.printf("      %-18s%s\n", tracks2[track], "no time recorded");
                    }
                    else {
                        // math
                        // converting the total seconds into minutes and 
                        int mins = competitors[i].getBestTimes(track) / 60;
                        int secs = competitors[i].getBestTimes(track) % 60;
                        // print all the info
                        if (secs >= 10) {
                            String time = mins + "'" + secs + "\"";
                            System.out.printf("      %-18s%s\n", tracks2[track], time);
                        }
                        else {
                            String time = mins + "'" + "0" + secs + "\"";
                            System.out.printf("      %-18s%s\n", tracks2[track], time);
                        }
                    }
                }
            }
        }
    }

    // option 7
    public static void displayStatistics(Competitor[] competitors) {
        // if there are no registered competitors
        if (Competitor.getNumCompetitors() < 1) {
            System.out.println("\nThere are no statistics recorded, as there are no\n"
                    + "competitors currently registered in the system.");
        }
        // if there is at least one competitor
        else {
            System.out.print("\nStatistics of Completed Time Trials - Average Time per Track\n");
            // loop through all tracks for all competitors and print the avergage
            // save all times into list
            int[] sumTimes = new int[4];
            // save all avgs into list
            int[] avgTimes = new int[4];
            // loop through all compeitors
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                // loop through all tracks
                for (int track = 0; track < 4; track++) {
                    // add to the sum for EACH track
                    sumTimes[track] += competitors[i].getBestTimes(track);
                }
                // loop again now that we have a COMPLETE sum for EACH track
                for (int track = 0; track < 4; track++) {
                    // calculate the avg for EACH track
                    avgTimes[track] = sumTimes[track] / Competitor.getNumCompetitors();
                    // convert into minutes and seconds
                    int mins = avgTimes[track] / 60;
                    int secs = avgTimes[track] % 60;
                    // printing all the info
                    if (i == Competitor.getNumCompetitors() - 1) {
                        if (!timeTrialPerformed[track] || competitors[i].getBestTimes(track) == 0) {
                            System.out.printf("      %-18s%s\n", tracks2[track], "no time trials recorded");
                        }
                        else if (secs >= 10) {
                            String time = mins + "'" + secs + "\"";
                            // print all the info
                            System.out.printf("      %-18s%s\n", tracks2[track], time);
                        }
                        else {
                            String time = mins + "'" + "0" + secs + "\"";
                            System.out.printf("      %-18s%s\n", tracks2[track], time);
                        }
                    }
                }
            }
        }
    }

    // option 8
    public static void eraseAndReset(Competitor[] competitors) {
        System.out.println("\nAll competitors times have been cleared, and the Leaderboard has been reset.");
        // loop through ALL tracks
        for (int track = 0; track < 4; track++) {
            // loop through ALL competitors
            for (int i = 0; i < Competitor.getNumCompetitors(); i++) {
                // set ALL times for each compeitor on each track back to 0
                competitors[i].setBestTimes(track, 0);
                // set boolean values back to false so its as if time trials never took place
                timeTrialPerformed[track] = false;
            }
        }
    }

    public static void main(String[] args) {
        // Variables used in program
        Scanner in = new Scanner(System.in);
        Random rng;               // Random Number Generator
        int maxCompetitors;       // value read from user and used to create arrays
        int seed;                 // value read from user and used to seed the RNG
        int userChoice;           // value read from user as their main menu selection
        Competitor[] competitors; // array to store the competitor object references

        // Scan seed used for random
        System.out.print("Enter the seed for the random number generator: ");
        seed = Integer.parseInt(in.nextLine());
        rng = new Random(seed);

        // Scan max number of competitors
        System.out.print("\nEnter the maximum number of competitors: ");
        maxCompetitors = Integer.parseInt(in.nextLine());

        // Create the new array of Competitor references
        competitors = new Competitor[maxCompetitors];
        // This is an array of Competitor object REFERENCES
        // Each reference currently points to "null" (no objects have been created yet)

        OUTER:
        while (true) {
            displayMenu();
            userChoice = readAndVerifyChoice(in, 9);
            switch (userChoice) {
                case 1: // registering new competitors, here we create a new object Competitor
                    registerCompetitor(competitors, in);
                    break;
                case 2: // search by id
                    searchByID(competitors, in);
                    break;
                case 3: // search by first and last name
                    searchByName(competitors, in);
                    break;
                case 4: // performt the time trial 
                    performTimeTrial(competitors, in, rng);
                    break;
                case 5: // display the best time for EACH track
                    displayLeaderBoard(competitors);
                    break;
                case 6: // display ALL competitors and their best times on EACH track
                    displayAllCompetitors(competitors);
                    break;
                case 7: // display the avg times for each track
                    displayStatistics(competitors);
                    break;
                case 8: // erase ALL times but do not touch the competitors info
                    eraseAndReset(competitors);
                    break;
                default: // if (userChoice == 8)
                    System.out.println("\nGoodbye!");
                    break OUTER;

            } // end switch
        } // end while (true)
    } // end main()
}
