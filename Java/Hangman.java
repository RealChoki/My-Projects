import java.util.Scanner;

/**
 * Class with executable main method containing logic for the game "Hangman".
 */
public class Hangman {

    /**
     * Main method calling the main menu logic of Hangman.
     *
     * @param args Command line arguments (unused).
     * @author Team Prog1
     */
    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        runGame();

        // TODO: Task 1.1) Add main menu (loop)
        //  - Input "p" => play (new game)
        //  - Input "h" => help (print list of commands ("p", "h", and "q"))
        //  - Input "q" => Quit/Exit
        //  - Any other input (Invalid) => Print "Invalid input <input>" + help menu (list of commands as if input was "h")

        // TODO: Task 1.2) Manage statistics, i.e., store wins and losses, count the respective nr up after each game
        //  and show the total after each game. For example: Wins: 3, losses: 1.

        // TODO: Task 1.3) Add valid Javadoc for this method (and any method you have added). As - due to your valuable contribution - there are multiple
        //  collaborators working on this project, please don't forget to use the tag @author <Your name> (see other methods)

        // - You are allowed to change this method body and add as many new methods as you want (please don't forget to describe them with Javadoc as described in task 1.3).
        // - You MUST NOT change any of the preexisting methods or head of this method.
        // - Please have a look at the existing code -- if possible, call/use methods we have already implemented.
        // - After implementing your features, you may remove all these comments and TODOs.

        // Checklist:
        // - [ ] Implementation of main menu (task 1.1 -- 1 point)
        // - [ ] Implementation of statistics (task 1.2 -- 0.5 points)
        // - [ ] Javadoc describing your new feature(s) + @author tag (task 1.3 -- 0.5 points)
    }

    /**
     * Runs a game of Hangman and returns whether this game was lost or won by the user.
     *
     * @return True if the game was won, false if not.
     * @author Team Prog1
     */
    private static boolean runGame() {
        String[] hangManArt = {
            "        +---+\n        |   |\n            |\n            |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n            |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n        |   |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n       /|   |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n       /|\\  |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n       /|\\  |\n       /    |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n       /|\\  |\n       / \\  |\n            |\n      ========="
        };
        final String randomWord = randomWord();
        final int maxWrongTurns = 6;
        int wrongTurns = 0;
        int foundCharacters = 0;
        String history = "";
        char[] wordLetters = initialCharArrayOfLength(randomWord.length());

        while (foundCharacters < randomWord.length() && wrongTurns < maxWrongTurns) {
            printRoundInfo(wordLetters, wrongTurns, maxWrongTurns);
            char characterInput = scanLetterCharToUpperCase();

            if (charExistsInArray(characterInput, history.toCharArray())) {
                System.out.println("'" + characterInput + "' has already been used, please try again.");
                continue;
            }

            history += characterInput;
            if (charExistsInArray(characterInput, randomWord.toCharArray())) {
                for (int i = 0; i < wordLetters.length; i++) {
                    if (randomWord.charAt(i) == characterInput) {
                        wordLetters[i] = characterInput;
                        foundCharacters++;
                    }
                }
            } else {
                wrongTurns++;
                System.out.println(hangManArt[wrongTurns]);
            }

        }

        boolean isGameWon = foundCharacters == wordLetters.length;
        System.out.print("You " + (isGameWon ? "won" : "lost") + " this round! Word was: " + randomWord + "\n");
        return isGameWon;
    }

    /**
     * Prints the information of a current Hangman round, i.e., the nr. of wrong turns and the currently visible
     * word/underscores for letters yet to be guessed.
     *
     * @param word          (Partly hidden) word whose letters are to be guessed represented as char array.
     * @param wrongTurns    Nr. of wrong turns for a current game.
     * @param maxWrongTurns Max nr. of wrong turns.
     * @author Team Prog1
     */
    private static void printRoundInfo(char[] word, int wrongTurns, int maxWrongTurns) {
        System.out.print("Word: ");
        System.out.print(word);
        System.out.println(" (Wrong turns: " + wrongTurns + "/" + maxWrongTurns + ")");
        printHangman(wrongTurns);
    }

    private static void printHangman(int wrongTurns) {
        // Remove this placeholder once there is a real hangman graphic:

        // TODO: Task 2.1) Print a hangman graphic based on the current number of wrong turns

        // TODO: Task 2.2) Add valid Javadoc for this method. As - due to your valuable contribution - there are multiple
        //  collaborators working on this project, please don't forget to use the tag @author <Your name> (see other methods)

        // - Feel free to work in this method and add new methods (which shouldn't be necessary in this case).
        // - You MUST NOT change any of the preexisting methods or this method head.
        // - Inspiration: ASCII-Art => https://www.asciiart.eu/
        // - After implementing your features, you may remove all these comments and TODOs.

        // Checklist:
        // - [ ] Hangman graphic (task 2.1 -- 1.5 point)
        // - [ ] Javadoc describing your new feature(s) + @author tag (task 2.2 -- 0.5 points)
    }

    /**
     * Checks whether a character (needle) exists in an array of characters (haystack).
     *
     * @param needle Character to be looked for.
     * @param haystack Array of characters to search in.
     * @return True if the given character was found in the array, false if not.
     * @author Team Prog1
     */
    private static boolean charExistsInArray(char needle, char[] haystack) {
        for (char c : haystack) {
            if (c == needle) {
                return true;
            }
        }
        return false;
    }

    /**
     * Scans user input until obtaining exactly one letter and returns it converted to uppercase.
     *
     * @return Legal user input character, i.e., a letter, in uppercase.
     * @author Team Prog1
     */
    private static char scanLetterCharToUpperCase() {
        char validCharacter = scanLetterChar();
        String oneCharString = "" + validCharacter;
        return oneCharString.toUpperCase().charAt(0);
    }

    /**
     * Scans user input until obtaining exactly one letter and returns it.
     *
     * @return Legal user input character, i.e., a letter.
     * @author Team Prog1
     */
    private static char scanLetterChar() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Your input: ");
            input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("  => Input must be of length 1, try again.");
            } else if (!Character.isLetter(input.charAt(0))) {
                System.out.println("  => Input must be a letter, try again.");
            }
        } while (input.length() != 1 || !Character.isLetter(input.charAt(0)));

        return input.charAt(0);
    }

    /**
     * Initializes a character array with a given length, fills it with underscores and returns it.
     *
     * @param length Length of the array to be created.
     * @return Character array of the given length, filled with underscores.
     * @author Team Prog1
     */
    private static char[] initialCharArrayOfLength(int length) {
        char[] arr = new char[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '_';
        }
        return arr;
    }

    /**
     * Selects and returns a random uppercase word from a list of programming/uni related words.
     *
     * @return Random uppercase word related to programming / uni.
     * @author Team Prog1
     */
    private static String randomWord() {
        final String[] words = {
                "ALGORITHM",
                "ARRAY",
                "BERLIN",
                "CODING",
                "COMPILER",
                "COMPUTER",
                "DEBUGGING",
                "HTW",
                "INFORMATICS",
                "JAVA",
                "LOOP",
                "METHOD",
                "OPERATOR",
                "PROGRAMMING",
                "SEMESTER",
                "TRESKOWALLEE",
                "VARIABLE"
        };

        return words[(int) (Math.random() * words.length)];
    }
}