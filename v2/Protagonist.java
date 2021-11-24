public class Protagonist extends Character{

  private String _name = "doubleN";

  public Protagonist() {
    _hitPts = 125;
    _strength = 100;
    _defense = 40;
    _attack = .4;
  }

  public Protagonist( String name ) {
    this();
    _name = name;
  }

  // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
  public String getName() { return _name; }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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
