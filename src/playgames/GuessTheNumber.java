package playgames;

import java.util.Scanner;

public class GuessTheNumber extends PlayGames{
    int randNumber;
    int upperBound;
    int lowerBound;
    int guess;

    Scanner player = new Scanner(System.in);

    public GuessTheNumber() {
    }

    public void instructions() {
        System.out.println("Welcome to the Guess the number Game!!\nHere you will enter a two numbers to guess between");
        System.out.println("After this you will Guess a number and we will tell you whether the guess is higher or lower");
        System.out.println("If you guess the number in 5 guesses or less YOU WIN!!\n\n");
    }

    //Getters
    public int getRandNumber() {
        return randNumber;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getGuess() {
        return guess;
    }


    //Setters
    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public void setRandNumber() {
        int lower = getLowerBound();
        int upper = getUpperBound();
        this.randNumber = RandomUtils.generateRandom(lower, upper);
    }

    //userInput
    public void enterLowerBound(){
        System.out.println("Please enter the from Number");
        setLowerBound(player.nextInt());
    }

    public void enterUpperBound() {
        System.out.println("Please enter the to Number");
        setUpperBound(player.nextInt());
    }

    public void enterGuess() {
        System.out.println("Please enter a Guess");
        setGuess(player.nextInt());
    }

    public void setUp() {
        enterLowerBound();
        enterUpperBound();
        setRandNumber();
    }

    public String playGame() {
        setUp();
        instructions();
        enterGuess();
        int numOfGuesses = 4;

        while(numOfGuesses>0) {
            if(getGuess()==getRandNumber()) {
                return "Congrats you guessed it";
            } else if(getGuess()>getRandNumber()) {
                System.out.println("The number is lower than "+getGuess());
            } else {
                System.out.println("The number is higher than " + getGuess());
            }
            numOfGuesses--;
            enterGuess();
        }
        return "You didn't win this time. Better Luck next time!";
    }

    public void playAgain() {
        String play;
        Scanner gamePlayer = new Scanner(System.in);

        do {
            System.out.println(playGame());

            System.out.println("Do you want to Play again??");
            play = gamePlayer.next();

            while(!(play.equals("y") || play.equals("Y") || play.equals("n") || play.equals("N"))) {
                System.out.println("Please select y or n");
                play = gamePlayer.next();
            }

        } while(play.equals("y") || play.equals("Y"));
        System.out.println("Thanks for Playing");
    }
}
