package playgames;


//Edit to make it a game

import java.util.Scanner;

public class CoinToss extends PlayGames{
        String coin;
        String guess;
        Scanner player = new Scanner(System.in);

        public CoinToss() {

        }

        public String getCoin() {
            return coin;
        }

        public void setCoin(){
            if (RandomUtils.generateRandom(0,1)==0) {
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
            while(!(guess.equals("Heads") || guess.equals("Tails") || guess.equals("heads") || guess.equals("tails"))) {
                System.out.println("Please Enter your guess of Heads or Tails");
                guess = player.nextLine();
            }
            setGuess(guess);
        }

        public void displayCoin (String coin) {
            System.out.println(coin);
        }

        public String playGame () {
            setCoin();
            enterGuess();
            displayCoin(getCoin());
            if(getCoin().equals(getGuess())) {
                return "You Won!!";
            }
            return "You Lost better Luck next time!";
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
