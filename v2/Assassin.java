public class Assassin extends Protagonist{
  public Assassin(String name) {
    super(name);
    _hitPts = 75;
    _strength = 125;
    _defense = 35;
    _attack = .4;
  }
  public void specialize() {
    _attack = .85;
    _defense = 20;
  }

  //revert to normal mode
  public void normalize() {
    _attack = .4;
    _defense = 35;
  }

  public static String about() {
    String a = "\t -- Assassin is kills fast, but make sure he doesn't get caught...";
    return a;
  }

}
