public class Monster{
  public int health = 15;

  public boolean isAlive(){
    return (health > 0);
  }
  
  public int attack(Protagonist being){
    being.health -= 3;
    return 3;
  }
}
