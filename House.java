import java.util.ArrayList;


public class House extends Building implements HouseRequirements{

  //Atributes
  private ArrayList<Student> residents; //list of residents in a house
  private boolean hasDiningRoom; //whether or not the house has a dining room

  /**
   * Constructor for House
   * @param name house's name
   * @param address house's address
   * @param nFloors number of floors
   * @param hasDiningRoom does house have a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * overload constructor for a house if you don't knwow its address. it hardcodes the address as Smith College.
   * @param name House's name
   * @param nFloors number of floors
   * @param hasDiningRoom does the house have a dining room
   */
  public House(String name, int nFloors, boolean hasDiningRoom){
    this.residents = new ArrayList<Student>();
    this.name = name;
    this.activeFloor = -1;
    this.nFloors = nFloors;
    this.address = "Smith College";
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");

  }

  /**
   * acessor for if this.House has a dinning room
   * @return true if it has a dining room
   * @return false if it does not have a dinning room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * acessor for number of residents in this.House
   * @return number of residents
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * Adds Student to list of residents
   * @param s stduent who wants to move in
   */
  public void moveIn(Student s){
    if (this.residents.contains(s)){
      throw new RuntimeException(s.getName()+" already lives in " + this.name);
    } else {
      residents.add(s);
    }
    if (this.residents.contains(s) == false){
      throw new RuntimeException(s.getName()+" was not succesfully added to "+this.name);
    } else {
      System.out.println(s.getName()+ " is a resident of "+ this.name);
    }
  }

  public void moveIn(Student s, House oldHouse){
    if (this.residents.contains(s)){
      throw new RuntimeException(s.getName()+" already lives in " + this.name);
    } else {
      oldHouse.moveOut(s);
      residents.add(s);
    }
    if (this.residents.contains(s) == false){
      throw new RuntimeException(s.getName()+" was not succesfully added to "+this.name);
    } else {
      System.out.println(s.getName()+ " is a resident of "+ this.name);
    }
      

  }

  /**
   * Removes Student from list of residents
   * @param s student who wants to move out
   * @return the Student who moved out
   */
  public Student moveOut(Student s) {
    if(this.residents.contains(s) == false){
      throw new RuntimeException(s.getName()+" does not live in "+ this.name);
    } else {
      residents.remove(s);
    }
    if (this.residents.contains(s)){
      throw new RuntimeException(s.getName()+" has not succesfuly moved out of "+ this.name);
    } else {
      System.out.println(s.getName()+ " has moved out of "+ this.name);
      return s;
    }
  }

  /**
   * accessor for if a specific student lives in this house
   * @param s student in question
   * @return true if they live in this house
   * @return flase if they do not live in this house
   */
  public boolean isResident(Student s){
    if (this.residents.contains(s)){
      System.out.println(s.getName()+" lives in "+ this.name);
      return true;
    }else{
      System.out.println(s.getName()+" does not live in "+this.name);
      return false;
    }
  }
  /**
   * Prints the availible public methods for a House
   */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + isResident()\n + hasDiningRoom()\n + moveIn()\n + moveOut() ");
  }

  /**
   * Allows you to go to any floor of a House if the house has an elevator
   * @param floorNum floor you want to go to
   * @param hasElevator doe the house have an elevator?
   */
  public void goToFloor(int floorNum, boolean hasElevator){
    if (hasElevator){
      super.goToFloor(floorNum);
    } else {
      throw new RuntimeException("Sorry, " +this.name+" does not have an elevator!");
    }

  }
//main for testing
  public static void main(String[] args) {
    System.out.println();
    Student sofia = new Student("Sofia","9913",2027); 
    Student lucy = new Student("Lucy","9914",2027);
    // Student cleo = new Student("Cleo", "9915", 2027);
    House comstock = new House("Comstock","1 Mandella Rd, Northampton MA",3,true);
    House hubbard = new House("Hubbard",4,true);
    hubbard.moveIn(sofia);
    comstock.moveIn(lucy);
    comstock.moveIn(sofia,hubbard);
    System.out.println(hubbard.toString());
    hubbard.enter();
    hubbard.goUp();

  }

}