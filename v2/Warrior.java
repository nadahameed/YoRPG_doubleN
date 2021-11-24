public class Warrior extends Protagonist{
  public Warrior() {
    _hitPts = 125;
    _strength = 100;
    _defense = 40;
    _attack = .4;
  }

  public void specialize() {
    _attack = .75;
    _defense = 20;
  }

  //revert to normal mode
  public void normalize() {
    _attack = .4;
    _defense = 40;
  }
}
