package playgames;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MaddLibbs implements Game {

  Scanner player = new Scanner(System.in);
  Random rand = new Random();

  String story;
  ArrayList<String> nounArr = new ArrayList<>();
  ArrayList<String> adjArr = new ArrayList<>();
  ArrayList<String> verbArr = new ArrayList<>();
  ArrayList<String> numArr = new ArrayList<>();

  //getters
  public String getNoun(int index) {
    return nounArr.get(index - 1);
  }

  public String getAdj(int index) {
    return adjArr.get(index - 1);
  }

  public String getVerb(int index) {
    return verbArr.get(index - 1);
  }

  public String getNumber(int index) {
    return numArr.get(index - 1);
  }

  public String getStory() {
    return story;
  }

  //setters
  public void setNoun(String newNoun) {
    this.nounArr.add(newNoun);
  }

  public void setAdj(String newAdj) {
    this.adjArr.add(newAdj);
  }

  public void setVerb(String newVerb) {
    this.verbArr.add(newVerb);
  }

  public void setNum() {
    String newNum = Integer.toString(rand.nextInt(100));
    this.numArr.add(newNum);
  }

  public void setStory(String story) {
    this.story = story;
  }

  //user input
  public void enterNoun() {
    System.out.println("Please enter a Noun");
    setNoun(player.nextLine());
  }

  public void enterAdj() {
    System.out.println("Please enter an Adjective");
    setAdj(player.nextLine());
  }

  public void enterVerb() {
    System.out.println("Please enter a Verb");
    setVerb(player.nextLine());
  }

  public void runningMaddLib() {
    int whichStory = rand.nextInt(2);
    String mlstory;
    if (whichStory == 0) {
      mlstory = ("Once upon a time there was a princess, who lived in a " + getNoun(1)
          + ". She longed " +
          "for a prince who lived far, far away. So one day she " + getVerb(1)
          + " away in order to find the prince and his " +
          "noble " + getNoun(2) + ". As she " + getVerb(2) + "ed along a path, she fell into a "
          + getAdj(1) +
          " " + getNoun(3) + " that was " + getAdj(2) + " and about " + getNumber(1)
          + " feet tall. She was" +
          " stuck in there for a very " + getAdj(3) + " time. She started " + getVerb(3)
          + "ing so that someone " +
          "could hear her. At the " + getNoun(1)
          + " the king was getting worried, so he sent out some " +
          getNoun(4) + " to look for her. None of the " + getNoun(4) + " found her. Hours later, " +
          "the prince found her sleeping. He tried to wake her up, but couldn't. He pulled her out of the "
          + getNoun(3) + " and put her on his " + getNoun(2) + ". While they were " + getVerb(4)
          + "ing to " +
          "the prince's castle, the princess awoke." +
          "\n" +
          "And they lived " + getAdj(4) + " ever after\n" +
          "\n" +
          "the end.");
    } else {
      mlstory = ("Pickachu and Charizard are very good friends. One day they went to go find a "
          + getNoun(2) + "to help " +
          "their friend " + getNoun(1) + " catch a legendary pokemon that was very " + getAdj(1)
          + ". They " +
          getVerb(1) + "ed " + "through the mountains and rivers and " + getAdj(2) + " forests for "
          + getNumber(1) + " days. Finally they " + "found the " + getNoun(2) + " it was very "
          + getAdj(3) +
          " and very " + getAdj(4) + ". They took the " + getNoun(2) + " and " + getVerb(2)
          + "ed back " +
          "towards home but then a wild " + getNoun(3) + " appeared. Together"
          + " they battle and defeated the "
          + getNoun(3) + " and were able to " + getVerb(3) + " it and give it to their friend "
          + getNoun(1) + ". Now with the " + getNoun(2) + " the team went " + getVerb(4)
          + "ing to the "
          + getNoun(4) + " to battle the legendary Pokemon");
    }
    setStory(mlstory);
  }

  public void printInstructions() {
    System.out.println(
        """
                    To play, fill in the blanks on this page with the requested words.
                    A NOUN is the name of a person, place, or thing. Sidewalk, umbrella, bathtub, and roller skates are nouns.
                    An ADJECTIVE describes a person, place, or thing. Lumpy, soft, cute, messy, and short are adjectives.
                    A VERB is an action word. Run, jump, and swim are verbs.
                    An ADVERB describes in what way someone does something. Quickly, slowly, and carefully are adverbs.
                    Have FUN!!!
            """
    );
  }

  public String playGame() {
    int index = 0;
    while (index <= 3) {
      enterNoun();
      enterAdj();
      enterVerb();
      index++;
    }
    setNum();
    runningMaddLib();
    printInstructions();
    return getStory();
  }

  public String start() {
    return playGame();
  }

}

