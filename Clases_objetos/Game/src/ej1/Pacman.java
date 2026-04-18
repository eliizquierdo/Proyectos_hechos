package ej1;
import ch.aplu.jgamegrid.*;
//----------- class Pacman --------
class Pacman extends Actor{

		public Pacman(){
			super("sprites/pacman.gif");
		}

		public void act(){
			move();
		}

		private void tryToEat(){
 
		}
}
