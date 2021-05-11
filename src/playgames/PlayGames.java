package playgames;

import java.util.Scanner;

public class PlayGames {
    int pick;
    Scanner player = new Scanner(System.in);


    public int getPick() {
        return pick;
    }

    public void setPick(int pick) {
        this.pick = pick;
    }

    public void enterPick() {
        System.out.println("Please Enter a number between 1 and 4");
        int pick = player.nextInt();
        while (pick >4 || pick <1) {
            System.out.println("Please Enter a number between 1 and 4");
            pick = player.nextInt();
        }
        setPick(pick);
    }

    public void instructions(){
        System.out.println("These are the games you can choose from:");
        System.out.println("1: Hangman");
        System.out.println("2: MaddLibbs");
        System.out.println("3: Coin Toss");
        System.out.println("4: Guess the Number\n\n");
    }

//Can you help me figure out how to call a class within this function.
    //see line 44. newGame.playGame();

//    public void playAgain() {
//        String play;
//        Scanner gamePlayer = new Scanner(System.in);
//
//        do {
//            System.out.println(newGame.playGame());
//
//            System.out.println("Do you want to Play again??");
//            play = gamePlayer.next();
//
//            while(!(play.equals("y") || play.equals("Y") || play.equals("n") || play.equals("N"))) {
//                System.out.println("Please select y or n");
//                play = gamePlayer.next();
//            }
//
//        } while(play.equals("y") || play.equals("Y"));
//        System.out.println("Thanks for Playing");
//    }

    public static void main(String[] args) {
        PlayGames game = new PlayGames();

        game.instructions();
        game.enterPick();

        System.out.println("\n\n");
        if (game.getPick()==1) {
            Hangman newGame = new Hangman();
            newGame.playAgain();
        } else if (game.getPick()==2) {
            MaddLibbs newGame = new MaddLibbs();
            newGame.playAgain();
        } else if (game.getPick()==3) {
            CoinToss newGame = new CoinToss();
            newGame.playAgain();
        } else {
            GuessTheNumber newGame = new GuessTheNumber();
            newGame.playAgain();
        }
    }
}


