/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    //Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for Cafe
     * @param name Cafe's name
     * @param address Cafe's address
     * @param nFloors Number of floors in Cafe
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * overload contructor for Cafe's wihtout names
     * @param address Cafe's address
     * @param nFloors Number of floors in Cafe
     */
    public Cafe(String address, int nFloors){
        super("Starbucks", address, nFloors);
        this.nCoffeeOunces = 8000;
        this.nSugarPackets = 1000;
        this.nCreams = 1000;
        this.nCups = 1000;

        System.out.println("You have built a cafe: ☕");
    }

    /**
     * decreases the inventory every time someone buys a coffee
     * @param size oz of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams number of splashes of cream
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        System.out.println();
        System.out.println("One "+coffeeToString(size, nSugarPackets, nCreams)+" coming right up!");
        if (this.nCups == 0 || 
            size >= this.nCoffeeOunces || 
            nSugarPackets >= this.nSugarPackets ||
            nCreams >= this.nCreams
            ) {
            System.out.println("One moment please.....we need to restock the ingredients....");
            this.restock(800, 100, 100, 100);
            //System.out.println("coffee: " + this.nCoffeeOunces + " Sugar: "+this.nSugarPackets+" cream: "+ this.nCreams + " cups: " + this.nCups);
        } 

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Here is your drink! ☕ Have a good day!");
        System.out.println();
    }

    /**
     * Overload method for black coffee drinkers (no cream or sugar)
     * @param size oz of coffee
     */
    public void sellCoffee(int size){
        System.out.println();
        System.out.println("One "+ size +" ounce black coffee coming right up!");
        if (this.nCups == 0 || size >= this.nCoffeeOunces){
            System.out.println("One moment please.....we need to restock the ingredients....");
            this.restock(800, 100, 100, 100);
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Here is your drink! ☕ Have a good day!");
        System.out.println();
    }

    /**
     * restocks the inventory when an ingredient runs out
     * @param nCoffeeOunces oz of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams number of splashes of cream
     * @param nCups number fo cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        
    }

    /**
     * toString method for an order at the cafe
     * @param size oz of coffee
     * @param nSugarPackets number of sugar packets
     * @param nCreams number of splashes of cream
     * @return stylized string
     */
    private String coffeeToString(int size, int nSugarPackets, int nCreams){
        return String.valueOf(size) + " oz coffee with "+ String.valueOf(nSugarPackets) + " packets of sugar and " + String.valueOf(nCreams)+" splashes of cream";
    }

    /**
     * prints public methods for Cafe
     */
    public void showOptions(){
        super.showOptions();
        System.out.println(" + sellCoffee()");
    }

    /**
     * Stops you from trying to go to the next floor
     * @param floorNum floor you want to go to
     */
    public void goToFloor(int floorNum){
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        throw new RuntimeException("Whoaa there, hold up!! The upper levels are for employees only!!");
    }

    /**
     * Stops you from trying to go to the next floor
     */
    public void goUp(){
        throw new RuntimeException("Whoaa there, hold up!! The upper levels are for employees only!!");
    }


    
    //main for testing
    public static void main(String[] args) {
        System.out.println();
        Cafe woodstar= new Cafe("Woodstar", "60 Masonic St, Northampton, MA", 2,800,100,100,100);
        System.out.println(woodstar.toString());
        woodstar.showOptions();
        woodstar.enter();
        woodstar.sellCoffee(18, 4, 0);
        woodstar.sellCoffee(783,0,3);
        woodstar.sellCoffee(10);

        Cafe starbucks = new Cafe("1800 ur mom street", 1);
        System.out.println(starbucks.toString());
    }
    
}
