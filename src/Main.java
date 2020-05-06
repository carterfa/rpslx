import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static Scanner input = new Scanner(System.in);


    public static void main(String[] args){

        int wins = 0;
        int losses = 0;
        int ties = 0;

        String[] options = {"scissors", "paper", "rock", "lizard", "spock"};
        //String[] options = {"scissors", "paper", "rock"};

        System.out.println("Choose rock, paper, scissors, lizard, or spock.");
        play(options, wins, losses, ties);

    }

    public static void play(String[] options, int wins, int losses, int ties){

        String strChoice = input.next().trim().toLowerCase();

        for (int i = 0; i < options.length; i++) {
            if(strChoice.equals(options[i])){
                int choiceIdx = i;
                compare(options, choiceIdx, wins, losses, ties);
            };
        }

        System.out.println("Not an option.");
        play(options, wins, losses, ties);

    }

    public static void compare(String[] options, int choiceIdx, int wins, int losses, int ties) {
        int botChoice = randomGen(options);
        System.out.println("You played " + options[choiceIdx]);
        System.out.println("The bot played " + options[botChoice]);

        if (choiceIdx == botChoice){
            System.out.println("It's a tie!");
            ties++;
        }
        else if (winCheck(options, choiceIdx, botChoice)){
            System.out.println("You won!");
            wins++;
        }else{
            System.out.println("You lost!");
            losses++;
        }
        System.out.println("Wins: " + wins + " | Losses: " +losses + " | Ties: " + ties);
        play(options, wins, losses, ties);
    }

    public static boolean winCheck(String[] options, int choiceIdx, int botChoice){

        int[] winArr = arrayGen(options, choiceIdx);

        for (int i =0; i < winArr.length; i++){
            if (botChoice == winArr[i]){
                return true;
            }
        }

        return false;

    }

    public static int[] arrayGen(String[] options, int choiceIdx){

        int[] arr = {choiceIdx - 2, choiceIdx - (options.length-1)};

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                arr[i] += options.length;
            }
        }

        return arr;
    }

    public static int randomGen(String[] options){
        Random rand = new Random();
        int randNum = rand.nextInt(options.length);
        return randNum;
    }

}
