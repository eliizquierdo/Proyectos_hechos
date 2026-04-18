package logica;
import java.util.ArrayList;

public class HundirElBarco {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        DotCom two = new DotCom();
        DotCom three = new DotCom();

        one.setName("Pets.com");
        two.setName("eToys.com");
        three.setName("Go2.com");

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Tu objetivo es hundir tres barcos: Pets.com, eToys.com, Go2.com");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Ingresa una casilla:");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (int x = 0; x < dotComsList.size(); x++) {
            result = dotComsList.get(x).checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(x);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("¡Todos los DotComs han sido hundidos!");
        if (numOfGuesses <= 18) {
            System.out.println("¡Solo te tomó " + numOfGuesses + " intentos. Excelente trabajo!");
        } else {
            System.out.println("Usaste " + numOfGuesses + " intentos. Puedes hacerlo mejor la próxima vez.");
        }
    }

    public static void main(String[] args) {
        HundirElBarco game = new HundirElBarco();
        game.setUpGame();
        game.startPlaying();
    }
}
