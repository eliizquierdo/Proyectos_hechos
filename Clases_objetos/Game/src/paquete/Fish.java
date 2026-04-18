package paquete;

import ch.aplu.jgamegrid.*;

public class Fish extends Actor{
  public Fish(){
    super("sprites/nemo.gif");
  }

  public void act(){
    move();
    if (!isMoveValid())
      turn(180);
  }
}
