/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;

public class Library extends Building implements LibraryRequirements{

  //Attributes
  private Hashtable<String, Boolean> collection; //Hashtable of books in the library and whether they are avilible to checkout

  /**
   * Constructor for Library
   * @param name library's name
   * @param address library's address
   * @param nFloors number of floors in library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * overload contructor for a Library. If you don't give a number of floors, it overrides to 4 floors
   * @param name
   * @param address
   */
   public Library(String name, String address){
      this(name, address,4);
      System.out.println("You have built a library: 📖");
  }

  /**
   * Overload constructor for a Library. Hardcodes the address to Smith College
   * @param name
   * @param nFloors
   */
  public Library(String name, int nFloors){
    this.name = name;
    this.activeFloor = -1;
    this.nFloors = nFloors;
    this.address = "Smith College";
    System.out.println("You have built a library: 📖");

  }

  /**
   * tells whether the library's collection contains a given title
   * @param title 
   * @return true if the title appears as a key in the Libary's collection
   * @return false otherwise
   */
  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      return true;
      } else { 
        return false;
      }
  }

  /**
   * adds a title to the collection of books 
   * @param title
   */
  public void addTitle(String title){
    System.out.println("Adding "+title+" to "+this.name+"....");
    if (this.containsTitle(title)){
      throw new RuntimeException(title+" is already in "+this.name);
    }

    this.collection.put(title, true);
    if (!this.containsTitle(title)){
      throw new RuntimeException(title+" was not succesfully added to "+this.name);

    } else{
      System.out.println(title+" was succesfully added to "+this.name);
      return;
    }
  }

  /**
   * Removes title from collecton of books
   * @param title the book being removed
   * @return title the book once it is successfully removed
   */
  public String removeTitle(String title){
    System.out.println("Removing "+title+" from "+this.name+"....");
    if (!this.containsTitle(title)){
        throw new RuntimeException(title+" is not in "+this.name);
    }

    this.collection.remove(title);
    if (this.containsTitle(title)){
      throw new RuntimeException(title+" was not succesfully removed from "+this.name);

    } else {
      System.out.println(title+" was succesfuly removed from "+ this.name);
      return title;
    }
  }

  /**
   * checks out a book by changing its key from true to false
   * @param title the book to be checked out
   */
  public void checkOut(String title){
    System.out.println("Checking out "+title+" from "+this.name+"....");
    if (!this.containsTitle(title)){
      throw new RuntimeException("Sorry, "+this.name+" does not carry "+title);

    } else if (!this.isAvailable(title)) {
      throw new RuntimeException("Sorry, "+title+" is not availible to check out from "+this.name);

    } else {
      this.collection.replace(title,true,false);
      System.out.println(title+" has been checked out from "+this.name);
    }
  }

  /**
   * lets someone return a book they have checked out
   * @param title the book once it's successfully returned
   */
  public void returnBook(String title){
    System.out.println("Returning "+title+" to "+this.name+"....");
    if (!this.containsTitle(title)){
      throw new RuntimeException(this.name+" does not carry "+title+". Maybe try another library!");

    } else if(this.isAvailable(title)) {
      throw new RuntimeException(this.name+" already has "+title+". No need to return!");

    } else {
      this.collection.replace(title, false, true);
      System.out.println(title+" has been returned to "+ this.name);
    }
  }

  /**
   * returns if a book is availible to checkout
   * @param title
   * @return true if the library has the book in its collection
   * @return false otherwise
   */
  public boolean isAvailable(String title){
    if (this.collection.get(title)) {
      return true;
    } else {
      return false;
    }  
  }

  /**
   * Prints out a super beautiful table of the books in the library's collection
   * and whether it is availible to checkout or not
   */
  public void printCollection(){
    System.out.println(this.name);
    System.out.printf("----------------------------------------------------------------------%n");
    System.out.printf("| %-42s | %-21s |%n", "Book Title", "Availible to Checkout");
    System.out.printf("----------------------------------------------------------------------%n");
    for (Map.Entry<String, Boolean> e : collection.entrySet())     
      System.out.printf("| %-42s | %-21s |%n", e.getKey(), e.getValue());
  }

  /**
   * Prints the list of public methods for a Library
   */
  public void showOptions(){
    super.showOptions();
    System.out.println(" + printCollection()\n + isAvailable()\n + checkOut()\n + returnBook()\n + removeTitle()\n + addTitle()\n + containsTitle()");
  }

  /**
   * method to go to any floor in the library
   * @param floorNum the floor you want to go to
   */
  public void goToFloor(int floorNum){
    super.goToFloor(floorNum);
  }

  //main for testing
  public static void main(String[] args) {
      System.out.println();
      Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton MA", 4);
      neilson.showOptions();
      Library alumniGym = new Library("Alumni Gym", "1800 smith college");
      alumniGym.enter();
      alumniGym.goToFloor(4);
      // neilson.addTitle("Looking for Alaska by John Greene");
      // neilson.addTitle("Elephant and Piggie by Mo Willems");
      // neilson.addTitle("The Hunger Games by Suzanne Collins");
      // neilson.addTitle("The Great Gatsby by F. Scott Fitzgerald");
      // System.out.println();
      // neilson.checkOut("Elephant and Piggie by Mo Willems");
      // neilson.checkOut("Looking for Alaska by John Greene");
      // neilson.checkOut("The Great Gatsby by F. Scott Fitzgerald");
      // System.out.println();
      // neilson.returnBook("Elephant and Piggie by Mo Willems");
      // neilson.returnBook("The Great Gatsby by F. Scott Fitzgerald");
      // System.out.println();

      // neilson.printCollection();
      
    }
  
  }