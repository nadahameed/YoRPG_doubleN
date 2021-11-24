public class Orc extends Monster{
  public Orc(){
    _hitPts = 180;
    _strength = 15 + (int)( Math.random() * 45 ); // [20,65)
    _defense = 25;
    _attack = 1;
  }

  public static String about() {
    String a = "\t -- Orc, a stoic creature, like a rock.";
    return a;
  }

}
