package paquete;
//para ejecutarlo hacer clic derecho sobre esta clase Run As ...

import ch.aplu.jgamegrid.*;

public class MyGame extends GameGrid
{
  public MyGame(){
    super(10, 10, 60, java.awt.Color.red, "sprites/reef.gif");
    Fish nemo = new Fish();
    addActor(nemo, new Location(2, 4));
    show();
  }

  public static void main(String[] args){
    new MyGame();
  }
}
