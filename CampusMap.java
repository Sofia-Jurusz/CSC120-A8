import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();

        
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * toString method for the campus map
     * @return styleized string of each building in the map and its address
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }


    public void playCampusMap(){
        // System.out.println("Welcome to Play Campus Map!");
        // int play = 1;
        // Scanner myScanner = new Scanner (System.in);
        // if (play == 1){
        //     System.out.println("Type 'enter _______' for the building you'd like to enter");
        //     String userRequest = myScanner.nextLine();
        //     String lowercaseUserRequest = userRequest.toLowerCase();
        //     String[] requestList = lowercaseUserRequest.split(" ");
        //     String building = requestList[2];;
        //     if (requestList[0]=="enter"){
        //         enterBuilding()
        //     }

        // } else{
        //     myScanner.close();
        //     return;
        // }
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        //All my buildings
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        Building bassHall = new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4);
        Building ainsworth = new Building("Ainsworth Gym","102 Lower College Ln, Northampton, MA 01063",4);
        Building burton = new Building("Burton", "46 College Ln, Northampton, MA 01063",4);

        Cafe woodstar = new Cafe("Woodstar", "60 Masonic St, Northampton, MA", 1, 700,100, 700, 90);
        Cafe starbucks1 = new Cafe("1800 Main Street", 1); // using the overload method that makes cafes without names starbucks'
        Cafe campusCenter = new Cafe("The CC","100 Elm St, Northampton, MA 01063", 1, 600, 40, 100, 50);
        
        House comstock = new House("Comstock","1 Mandella Rd, Northampton MA",3,true); 
        House hubbard = new House("Hubbard",4,true); //using the overload method that if you don't know the address, its automatically set to "Smith college"
        House wilson = new House("Wilson", 4, true);
        House king = new House("King",4,true);
        House chapin = new House("Chapin",4, true);

        Library neilson = new Library("Neilson Library", 4); // using the overload method that if you don't know the address, its automatically set to "Smith college"
        Library alumnaeGym = new Library("Alumnae Gym", "83 Green St, Northampton, MA 01063");// using the overload that if you do not set a number a floors, the library automatically has 4 floors
        System.out.println();
        
        //adding buildings to my map
        myMap.addBuilding(fordHall);
        myMap.addBuilding(bassHall);
        myMap.addBuilding(woodstar);
        myMap.addBuilding(starbucks1); 
        myMap.addBuilding(comstock);
        myMap.addBuilding(hubbard);
        myMap.addBuilding(alumnaeGym);
        myMap.addBuilding(neilson);
        myMap.addBuilding(ainsworth);
        myMap.addBuilding(wilson);
        myMap.addBuilding(campusCenter);
        myMap.addBuilding(king);
        myMap.addBuilding(chapin);
        myMap.addBuilding(burton);

        //print the map
        System.out.println();
        System.out.println(myMap);
        System.out.println();

        //testing the other overload methods
        woodstar.sellCoffee(8); //overload method of buying a black coffee
        Student sofia = new Student("Sofia","9913",2027); 
        hubbard.moveIn(sofia); //my first year I lived in hubbard, but second year I moved to comstock
        comstock.moveIn(sofia, hubbard); // overload method of moving from one smith house to another


    }
    
}
