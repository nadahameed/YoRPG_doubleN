public class Character{
  // instance variables
  protected int _hitPts;
  protected int _strength;
  protected int _defense;
  protected double _attack;

  public boolean isAlive() {
    return _hitPts > 0;
  }

  public int getDefense() {
    return _defense;
  }

  public void lowerHP( int damageInflicted ) {
    _hitPts = _hitPts - damageInflicted;
  }

  public int attack( Character opponent ) {
    int damage = (int)( (_strength * _attack) - opponent.getDefense() );
    //System.out.println( "\t\t**DIAG** damage: " + damage );
    if ( damage < 0 )
      damage = 0;
    opponent.lowerHP( damage );
    return damage;
  }//end attack
}
