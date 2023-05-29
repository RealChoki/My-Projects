import java.util.Scanner;

public class HangmanLectureLarisch {

    // Lecture: 05/23

    /**
     * Runs the Hangman game.
     */
    public static void main(String[] args) {
        runGame();
    }

    /**
     * Runs the main game loop of Hangman.
     */
    private static void runGame() {
        String[] hangManArt = {
            "        +---+\n        |   |\n            |\n            |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n            |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n        |   |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n       /|   |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n       /|\\  |\n            |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n       /|\\  |\n       /    |\n            |\n      =========",
            "        +---+\n        |   |\n        O   |\n       /|\\  |\n       / \\  |\n            |\n      ========="
        };
        final int maxWrongTurns = 6;
        int wrongTurns = 0;
        int foundCharacters = 0;
        String history = "";

        final String randomWord = randomWord();

        char[] word = initialCharArrayOfLength(randomWord.length());
        System.out.println(word);

        do {
            char characterInput = scanCharacter();
            System.out.println("Valid input was: " + characterInput);

            if (charExistsInWord(characterInput, history.toCharArray())) {
                System.out.println(characterInput + " has already been used, please try again");
                continue;
            }

            boolean existsInWord = charExistsInWord(characterInput, randomWord.toCharArray());
            System.out.println(existsInWord ? "exists" : "Does not exist");
            history += characterInput;

            if (existsInWord) {
                for (int i = 0; i < word.length; i++) {
                    if (randomWord.charAt(i) == characterInput) {
                        word[i] = characterInput;
                        foundCharacters++;

                    }
                }
            } else {
                wrongTurns++;
                System.out.println(hangManArt[wrongTurns]);
            }

            printRoundInfo(word, wrongTurns, maxWrongTurns);

        } while (foundCharacters < randomWord.length() && wrongTurns < maxWrongTurns);
    }

    /**
     * Prints the current round information including the word, wrong turns, and maximum wrong turns.
     *
     * @param word         The character array representing the current state of the word.
     * @param wrongTurns   The number of wrong turns made.
     * @param maxWrongTurns The maximum number of wrong turns allowed.
     */
    private static void printRoundInfo(char[] word, int wrongTurns, int maxWrongTurns) {
        System.out.println(word);
        System.out.println("Wrong turns: " + wrongTurns + "/" + maxWrongTurns);
    }

    /**
     * Generates a random word from a predefined list of words.
     *
     * @return A randomly selected word.
     */
    private static String randomWord() {
        final String[] words = {
                "JAVA",
                "CODING",
                "PROGRAMMING",
                "INFORMATICS",
                "COMPUTER",
                "HTW",
                "BERLIN",
                "TRESKOWALLEE",
        };

        return words[(int) (Math.random() * words.length)];
    }

    /**
     * Checks if a given character exists in the provided character array.
     *
     * @param needle   The character to search for.
     * @param haystack The character array to search in.
     * @return {@code true} if the character exists in the array, {@code false} otherwise.
     */
    private static boolean charExistsInWord(char needle, char[] haystack) {
        for (char c : haystack) {
            if (c == needle) {
                return true;
            }
        }
        return false;
    }

    /**
     * Scans user input for a single character.
     *
     * @return The character input by the user.
     */
    private static char scanCharacter() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Your input: ");
            input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Input must be of length 1, try again.");
            }
        } while (input.length() != 1);

        return input.toUpperCase().charAt(0);
    }

    /**
     * Creates a character array filled with underscores of a specified length.
     *
     * @param length The length of the character array.
     * @return A character array filled with underscores.
     */
    private static char[] initialCharArrayOfLength(int length) {
        char[] word = new char[length];
        for (int i = 0; i < word.length; i++) {
            word[i] = '_';
        }
        return word;
    }
}