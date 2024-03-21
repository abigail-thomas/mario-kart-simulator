public class Competitor {

    private int id;
    private String firstName;
    private String lastName;
    private String character;
    private String vehicle;
    private int[] bestTimes = new int[4];
    private static int numCompetitors = 0;

    // Constructors
    // registering a competitor
    public Competitor(int id, String firstName, String lastName, String character, String vehicle) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.character = character;
        this.vehicle = vehicle;
        numCompetitors++;
    }
    /* // performing time trial ??
    public Competitor(int [] bestTimes) {
        this.bestTimes = bestTimes;
    }*/
    
    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
    public String getVehicle() {
        return vehicle;
    }
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
    public int getBestTimes(int track) {
        return bestTimes[track];
    }
    public void setBestTimes(int track, int time) {
        // save time into bestTime[track]
        bestTimes[track] = time;
    }
    public static int getNumCompetitors() {
        return numCompetitors;
    }
    public static void setNumCompetitors(int aNumCompetitors) {
        numCompetitors = aNumCompetitors;
    }
}
