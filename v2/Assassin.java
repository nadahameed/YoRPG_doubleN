public class Assassin extends Protagonist{
  public Assassin() {
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
}
