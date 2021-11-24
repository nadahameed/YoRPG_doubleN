public class Tank extends Protagonist{
  public Tank(String name) {
    super(name);
    _hitPts = 150;
    _strength = 75;
    _defense = 60;
    _attack = .4;
  }
  public void specialize() {
    _attack = .5;
    _defense = 75;
  }

  //revert to normal mode
  public void normalize() {
    _attack = .4;
    _defense = 60;
  }

  public static String about() {
    String a = "\t -- Tank has high defense and hP, but alas not as sharp a bite.";
    return a;
  }
}
