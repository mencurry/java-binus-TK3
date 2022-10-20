import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // establish the dictionary for all three levels, words are taken from Scrabble US dictionary at wordfinderx.com
        String[] dictionaryLevel1 = {"tilted","titled","tilde", "tiled", "title", "deil", "deli", "delt", "diel", "diet", "dite", "edit", "idle", "lied", "tide", "tide", "lite", "tile", "tilt", "del", "die", "dit", "eld", "led", "lid", "ted", "lei", "let", "lie", "lit", "tel", "tet", "tie", "til", "tit"};
        String[] dictionaryLevel2 = {"encase", "seance", "seneca", "ances", "canes", "cease", "cense", "scena", "scene", "aces", "acne", "cane", "cans", "case", "cees", "scan", "anes", "ease", "esne", "naes", "sane", "seen", "sene", "ace", "can", "cee", "sac", "sec", "ane", "ens", "nae", "nee", "sae", "san", "sea", "see", "sen"};
        String[] dictionaryLevel3 = {"honker", "krone", "heron", "honer", "hoke", "honk", "hork", "okeh", "keno", "kern", "kore", "hern", "hero", "hoer", "hone", "horn,", "reno", "ken", "kor", "oke", "hen", "her", "hoe", "hon", "noh", "rho", "eon", "ern", "nor", "one", "ore", "roe"};
        Scanner input = new Scanner(System.in);
        String userAnswer;
        ArrayList<String> userAnswersArray = new ArrayList<>();

        boolean status = true;
        int finalScore = 0;
        int currentScore = 0;

        while (status) {
            System.out.println("Coepoe Word Puzzle");
            System.out.println("==================\n");

            System.out.println("Rules : ");
            System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters");
            System.out.println("2. Each level, you have 10 chances to answer correctly");
            System.out.println("3. To get through to next level you have to score 70 point each level\n");

            // Level 1
            System.out.println("Level 1");
            System.out.println("d         e         t         t         l         i");
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + "> Your Answer : ");
                userAnswer = input.nextLine().trim().toLowerCase();

                if (Arrays.asList(dictionaryLevel1).contains(userAnswer) && !userAnswersArray.contains(userAnswer)) {
                    currentScore += 10;
                    System.out.println("#Right. Score = " + currentScore);
                    userAnswersArray.add(userAnswer);
                } else if (userAnswersArray.contains(userAnswer)) {
                    System.out.println("You had entered this word before..");
                } else if (!Arrays.asList(dictionaryLevel1).contains(userAnswer)) {
                    System.out.println("Sorry, you're incorrect!");
                }
            }
            System.out.println("You had answered 10 times with " + (currentScore / 10) + " right answers..\n");
            finalScore += currentScore;

            System.out.println("Correct answers : ");
            int currentIdx = 0;
            while (currentIdx < dictionaryLevel1.length) {
                for (int i = 0; i < 10 && currentIdx < dictionaryLevel1.length; i++) {
                    System.out.print(dictionaryLevel1[currentIdx] + ", ");
                    currentIdx++;
                }
                System.out.println();
            }

            // Level 2
            if (finalScore > 70) {
                currentScore = 0;
                userAnswersArray.clear();
                System.out.println("\nLevel 2");
                System.out.println("s         e         c         a         e         n");
                for (int i = 1; i <= 10; i++) {
                    System.out.print(i + "> Your Answer : ");
                    userAnswer = input.nextLine().trim().toLowerCase();

                    if (Arrays.asList(dictionaryLevel2).contains(userAnswer) && !userAnswersArray.contains(userAnswer)) {
                        currentScore += 10;
                        System.out.println("#Right. Score = " + currentScore);
                        userAnswersArray.add(userAnswer);
                    } else if (userAnswersArray.contains(userAnswer)) {
                        System.out.println("you have already entered this word, you can't!");
                    } else if (!Arrays.asList(dictionaryLevel2).contains(userAnswer)) {
                        System.out.println("Sorry, that word doesn't exist in our dictionary!");
                    }
                }
                System.out.println("You had answered 10 times with " + (currentScore / 10) + " right answers..\n");
                finalScore += currentScore;

                System.out.println("Correct answers : ");
                currentIdx = 0;
                while (currentIdx < dictionaryLevel2.length) {
                    for (int i = 0; i < 10 && currentIdx < dictionaryLevel2.length; i++) {
                        System.out.print(dictionaryLevel2[currentIdx] + ", ");
                        currentIdx++;
                    }
                    System.out.println();
                }
            }

            // Level 3
            if (finalScore > 70) {
                currentScore = 0;
                userAnswersArray.clear();
                System.out.println("\nLevel 3");
                System.out.println("h         k         r         n         e         o");
                for (int i = 1; i <= 10; i++) {
                    System.out.print(i + "> Your Answer : ");
                    userAnswer = input.nextLine().trim().toLowerCase();

                    if (Arrays.asList(dictionaryLevel3).contains(userAnswer) && !userAnswersArray.contains(userAnswer)) {
                        currentScore += 10;
                        System.out.println("#Right. Score = " + currentScore);
                        userAnswersArray.add(userAnswer);
                    } else if (userAnswersArray.contains(userAnswer)) {
                        System.out.println("you have already entered this word, you can't!");
                    } else if (!Arrays.asList(dictionaryLevel3).contains(userAnswer)) {
                        System.out.println("Sorry, that word doesn't exist in our dictionary!");
                    }
                }
                System.out.println("You had answered 10 times with " + (currentScore / 10) + " right answers..\n");
                finalScore += currentScore;

                System.out.println("Overall score : " + finalScore);
                System.out.println("You win!!");
            }

            // ask the user if they would like to retry the program
            System.out.print("\nDo you want to retry?  [Y/T] ");
            String retry = input.nextLine();

            if (retry.equalsIgnoreCase("t")){
                status = false;
            } else if (retry.equalsIgnoreCase("y")) {
                status = true;
            } else {
                status = false;
            }
        }
    }
}
