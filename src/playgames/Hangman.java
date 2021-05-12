package playgames;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Hangman implements Game {

  private static final String[] words = {"serendipity", "solitude", "aurora", "idyllic",
      "euphoria"};

  Scanner player = new Scanner(System.in);
  ArrayList<String> playerWord = new ArrayList<>();
  String answer;
  String guess;
  int guessCount;
  int arrIndex;

  public int getArrIndex() {
    return arrIndex;
  }

  public void setArrIndex() {
    this.arrIndex = RandomUtils.generateRandom(0, words.length - 1);
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer() {
    this.answer = words[getArrIndex()];
  }

  public int getAnswerLength() {
    return getAnswer().length();
  }

  public int getGuessCount() {
    return guessCount;
  }

  public void setGuessCount() {
    this.guessCount = getAnswer().length() + 10;
  }

  public void lowerGuessCount() {
    this.guessCount = getGuessCount() - 1;
  }

  public void instructions() {
    System.out.println("Hangman X X");
    System.out.println("         ^\n");
    System.out.println("You must guess the word before your guesses run out");
  }

  public ArrayList<String> getPlayerWord() {
    return playerWord;
  }

  public void setPlayerWord(String letter) {
    this.playerWord.add(letter);
  }

  public void changePlayerWord(int index, String letter) {
    this.playerWord.set(index, letter);
  }

  public String joinPlayerWord() {
    return String.join("", getPlayerWord());
  }

  public void displayPlayerWord() {
    System.out.println(joinPlayerWord());
  }

  public String getGuess() {
    return guess;
  }

  public void setGuess(String guess) {
    this.guess = guess;
  }

  public void enterGuess() {
    Pattern regex = Pattern.compile("[a-z]");

    System.out.println("Please guess a letter");
    String playerGuess = player.next();

    while (!regex.matcher(playerGuess).find()) {
      System.out.println("Please guess a letter FROM THE ALPHABET DINGUS!!");
      playerGuess = player.next();
    }

    setGuess(playerGuess);
  }

  public void setUp() {
    setArrIndex();
    setAnswer();
    setGuessCount();
  }

  public String playGame() {
    Pattern underScore = Pattern.compile("_");

    setUp();
    instructions();

    for (int i = 0; i < getAnswerLength(); i++) {
      setPlayerWord("_");
    }

    displayPlayerWord();

    while (getGuessCount() > 0 && underScore.matcher(joinPlayerWord()).find()) {
      System.out.println("\nYou have " + getGuessCount() + " guesses remaining");
      enterGuess();

      for (int letter = 0; letter < getAnswerLength(); letter++) {
        if (getAnswer().charAt(letter) == getGuess().charAt(0)) {
          changePlayerWord(letter, getGuess());
        }
      }

      displayPlayerWord();
      lowerGuessCount();
    }

    if (!underScore.matcher(joinPlayerWord()).find()) {
      return "YOU WON!!! CONGRATS";
    } else {
      return "YOU Lost!!! SUCKER";
    }
  }

  public String start() {
    return playGame();
  }

}

