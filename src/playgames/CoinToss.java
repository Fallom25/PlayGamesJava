package playgames;

import java.util.Scanner;

public class CoinToss implements Game {

  String coin;
  String guess;
  Scanner player = new Scanner(System.in);

  public CoinToss() {

  }

  public String getCoin() {
    return coin;
  }

  public void setCoin() {
    if (RandomUtils.generateRandom(0, 1) == 0) {
      this.coin = "Heads";
    } else {
      this.coin = "Tails";
    }
  }

  public String getGuess() {
    return guess;
  }

  public void setGuess(String guess) {
    this.guess = guess;
  }

  public void enterGuess() {
    System.out.println("Please Enter your guess of Heads or Tails");
    String guess = player.nextLine();
    while (!(guess.equals("Heads") || guess.equals("Tails") || guess.equals("heads") || guess
        .equals("tails"))) {
      System.out.println("Please Enter your guess of Heads or Tails");
      guess = player.nextLine();
    }
    setGuess(guess);
  }

  public void displayCoin(String coin) {
    System.out.println("\n" + coin);
  }

  public String playGame() {
    setCoin();
    enterGuess();
    displayCoin(getCoin());
    if (getCoin().equals(getGuess())) {
      return "\nYou Won!!";
    }
    return "\nYou Lost better Luck next time!";
  }

  public String start() {
    return playGame();
  }

}
