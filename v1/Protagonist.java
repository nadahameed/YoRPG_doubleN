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
