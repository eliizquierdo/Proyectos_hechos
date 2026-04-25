// PacmanEx1.java

import ch.aplu.jgamegrid.*;
import java.awt.Color;

public class PacmanEx1 extends GameGrid
{
  public PacmanEx1()
  {
    super(10, 10, 60, Color.red);
    Pacman paki = new Pacman();
    addActor(paki, new Location(0, 0));
   
    show();
  }

  public static void main(String[] args)
  {
    new PacmanEx1();
  }
}



