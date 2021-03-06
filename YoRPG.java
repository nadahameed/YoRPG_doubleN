/**********************************************
 * Team: doubleN (Nicole Zhou, Duck, Nada Hameed, Ray)
 * APCS
 * L01: An Adventurer is You!
 * 2021-11-23
 *
 * DISCO:
 * 1) If statements do not require {} when there's only one line of code inside.
 * 2) When we use Character in a parameter, it includes both Protagonist and Monster.
 * 3) Because pat is a Protagonist, any method we want pat to call has to be defined in the Protagonist class (ex: specialize) - the same goes for Monster
 * 
 * QCCs:
 * 1) It would be interesting to try and incorporate 2 Protagonists/two Monsters faced at once
 * 2) We do not know what (IOException e) does

 **********************************************/

import java.io.*;
import java.util.*;

public class YoRPG {

  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

  //change this constant to set number of encounters in a game
  public final static int MAX_ENCOUNTERS = 5;

  //each round, a Protagonist and a Monster will be instantiated...
  private Protagonist pat;
  private Monster smaug;

  private int moveCount;
  private boolean gameOver;
  private int difficulty;

  private InputStreamReader isr;
  private BufferedReader in;
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
  public YoRPG() {
    moveCount = 0;
    gameOver = false;
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
    newGame();
  }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

  /*=============================================
    void newGame() -- gathers info to begin a new game
    pre:
    post: according to user input, modifies instance var for difficulty
    and instantiates a Protagonist
    =============================================*/
  public void newGame() {
    String s;
    String name = "";
    s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

    s += "\nChoose your difficulty: \n";
    s += "\t1: Easy\n";
    s += "\t2: Not so easy\n";
    s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
    s += "Selection: ";
    System.out.print( s );

    try {
	    difficulty = Integer.parseInt( in.readLine() );
    }
    catch ( IOException e ) { }

    s = "Intrepid protagonist, what doth thy call thyself? (State your name): ";
    System.out.print( s );

    try {
	    name = in.readLine();
    }
    catch ( IOException e ) { }

  //OUR DRIVER MODS
    String str = "Choose your hero:";
    str += "\n1) Warrior" + Warrior.about();
    str += "\n2) Tank" + Tank.about();
    str += "\n3) Assassin" + Assassin.about();
    str += "\n Your choice: ";
    int characterChoice = 1;
    System.out.print(str);
    try {
      characterChoice = Integer.parseInt(in.readLine());
    }
    catch (IOException e) {}

    if (characterChoice == 1){
      pat = new Warrior(name);
    }
    else if (characterChoice == 2){
      pat = new Tank(name);
    }
    else if (characterChoice == 3){
      pat = new Assassin(name);
    }

  }//end newGame()

  /*=============================================
    boolean playTurn -- simulates a round of combat
    pre:  Protagonist pat has been initialized
    post: Returns true if player wins (monster dies).
    Returns false if monster wins (player dies).
    =============================================*/
  public boolean playTurn() {
    int i = 1;
    int d1, d2;

    if ( Math.random() >= ( difficulty / 3.0 ) )
      System.out.println( "\nNothing to see here. Move along!" );
    else {
      System.out.println( "\nLo, yonder monster approacheth!" );

      double probability = Math.random()*100;
      if (probability > 80){
        smaug = new Dragon();
        System.out.println("Our hero faces a mythical creature, a " + Dragon.about());
      } else if (probability > 40){
        smaug = new Orc();
        System.out.println("Our hero faces a mythical creature, an " + Orc.about());
      } else {
          smaug = new Goblin();
          System.out.println("Our hero faces a mythical creature, a " + Goblin.about());
        }

      while( smaug.isAlive() && pat.isAlive() ) {

        // Give user the option of using a special attack:
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.
        try {
          System.out.println( "\nDo you feel lucky?" );
          System.out.println( "\t1: Nay.\n\t2: Aye!" );
          i = Integer.parseInt( in.readLine() );
        }
        catch ( IOException e ) { }

        if ( i == 2 )
          pat.specialize();
        else
          pat.normalize();

        d1 = pat.attack( smaug );
        d2 = smaug.attack( pat );

        System.out.println( "\n" + pat.getName() + " dealt " + d1 +
                            " points of damage.");

        System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
                            " for " + d2 + " points of damage.");
      }//end while

      //option 1: you & the monster perish
      if ( !smaug.isAlive() && !pat.isAlive() ) {
        System.out.println( "'Twas an epic battle, to be sure... " +
                            "You cut ye olde monster down, but " +
                            "with its dying breath ye olde monster. " +
                            "laid a fatal blow upon thee." );
        return false;
      }
      //option 2: you slay the beast
      else if ( !smaug.isAlive() ) {
        System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
        return true;
      }
      //option 3: the beast slays you
      else if ( !pat.isAlive() ) {
        System.out.println( "Ye olde self hath expired. You got dead." );
        return false;
      }
    }//end else

    return true;
  }//end playTurn()
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  public static void main( String[] args ) {
    //As usual, move the begin-comment bar down as you progressively
    //test each new bit of functionality...

    //loading...
    YoRPG game = new YoRPG();

    int encounters = 0;

    while( encounters < MAX_ENCOUNTERS ) {
      if ( !game.playTurn() )
        break;
      encounters++;
      System.out.println();
    }

    System.out.println( "Thy game doth be over." );
    /*================================================
      ================================================*/
  }//end main

}//end class YoRPG
