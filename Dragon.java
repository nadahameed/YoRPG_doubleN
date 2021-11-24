public class Dragon extends Monster{
  public Dragon(){
    _hitPts = 175;
    _strength = 30 + (int)( Math.random() * 45 ); // [20,65)
    _defense = 20;
    _attack = 1;
  }

  public static String about() {
    String a = "\t -- dragons, a mighty beast. Enough said.";
    return a;
  }

}
