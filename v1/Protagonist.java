<<<<<<< HEAD
/**
  class Protagonist -- protagonist of Ye Olde RPG
  **/

public class Protagonist extends Character{

    private String _name = "doubleN";

    /**
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      **/
    public Protagonist() {
        _hitPts = 125;
        _strength = 100;
        _defense = 40;
        _attack = .4;
    }


    /**
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      **/
    public Protagonist( String name ) {
        this();
        _name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //prepare a Protagonist for a special attack
    public void specialize() {
        _attack = .75;
        _defense = 20;
    }

    //revert to normal mode
    public void normalize() {
        _attack = .4;
        _defense = 40;
    }

}//end class Protagonist
=======
public class Protagonist{
  public int health = 10;
  private int atkpwr;
  private String _name = "jillian";

  public boolean isAlive(){
    return (health > 0);
  }

  public void specialize(){
    atkpwr = 4;
  }

  public void normalize(){
    atkpwr = 2;
  }

  public int attack(Monster being){
    being.health -= atkpwr;
    return atkpwr;
  }
  
  public Protagonist(String name){
    this();
    _name = name;
    }
  
  public String getName() {return _name; }
}
>>>>>>> f3b0b9ae62a5f701eab34b15bf816953f3e52e72
