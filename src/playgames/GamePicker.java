package playgames;

import java.util.Scanner;

public class GamePicker {

  int pick;
  Scanner player = new Scanner(System.in);

  public int getPick() {
    return pick;
  }

  public void setPick(int pick) {
    this.pick = pick;
  }

  public void enterPick() {
    System.out.println("\nPlease Enter a number between 1 and 4");
    int pick = player.nextInt();
    while (pick > 4 || pick < 1) {
      System.out.println("\nPlease Enter a number between 1 and 4");
      pick = player.nextInt();
    }
    setPick(pick);
  }

  public Game pickGame() {
    instructions();
    enterPick();
    Game newGame;

    System.out.println("\n\n");
    switch (getPick()) {
      case 1 -> newGame = new Hangman();
      case 2 -> newGame = new MaddLibbs();
      case 3 -> newGame = new CoinToss();
      default -> newGame = new GuessTheNumber();
    }
    return newGame;
  }

  public void instructions() {
    System.out.println("\n\nThese are the games you can choose from:\n");
    System.out.println("1: Hangman");
    System.out.println("2: MaddLibbs");
    System.out.println("3: Coin Toss");
    System.out.println("4: Guess the Number");
  }

  public void playagain(Game newGame) {
    String play;
    do {
      System.out.println(newGame.start());
      System.out.println("\n\nDo you want to Play again??");
      play = player.next();

      while (!(play.equals("y") || play.equals("Y") || play.equals("n") || play.equals("N"))) {
        System.out.println("Please select y or n");
        play = player.next();
      }
    } while (play.equals("y") || play.equals("Y"));
    System.out.println("Thanks for Playing");
  }

  public void diffGame() {
    String play;
    Game newGame;

    do {
      newGame = pickGame();
      playagain(newGame);

      System.out.println("\n\nDo you want to Play a different game?");
      play = player.next();

      while (!(play.equals("y") || play.equals("Y") || play.equals("n") || play.equals("N"))) {
        System.out.println("Please select y or n");
        play = player.next();
      }

    } while (play.equals("y") || play.equals("Y"));
    System.out.println("See you!!");
  }
}
