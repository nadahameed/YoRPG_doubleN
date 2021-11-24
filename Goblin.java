public class Goblin extends Monster{
  public Goblin(){
    _hitPts = 125;
    _strength = 25 + (int)( Math.random() * 45 ); // [20,65)
    _defense = 15;
    _attack = 1;
  }

  public static String about() {
    String a = "\t -- Goblins aren't the strongest, but they can bite.";
    return a;
  }
}
