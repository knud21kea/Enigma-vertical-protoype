package uds.knudsoft;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static String CHARACTERS = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

    public static void main(String[] args) {
        // Enigma vertical prototype

        //Intro
        //Number cipher using danish alphabet and space
        //Can both encode a string to numbers and decode numbers to a string

        //Encode or decode?
        System.out.println("\nVelkommen til Enigma!");
        System.out.print("\nTast e til encode eller d til decode: ");
        String option = input.nextLine();

        if (option.equals("e") || option.equals("E")) {
            //encode
            //input a string
            System.out.print("Indtast en streng: ");
            String inputString = input.nextLine();

            //convert to uppercase
            inputString = inputString.toUpperCase();
            final int inputLength = inputString.length();

            //convert the input string to a list of numbers (int array)
            int[] intArray = stringToIntArray(inputString, inputLength);

            //Could shift here

            //convert the list of numbers to a formatted string of codes
            String outputString = convertListOfNumbersToString(intArray, inputLength);

            //output encoded string
            System.out.println("Koden er: " + outputString);

        } else if (option.equals("d") || option.equals("D")) {
            //decode
            //input a list of numbers - test with "{7, 15, 4, 20, 0, 7, 29, 5, 20, 0, 4, 21, 0, 5, 18, 0, 6, 15, 18, 0, 19, 5, 10}"
            System.out.println("Indtast en liste som {x, y, ...}");
            System.out.print("Eller paste en tidligere udskrevet kode: ");
            String inputString = input.nextLine();

            //Find how many code numbers in the list
            final int elements = getNumberOfElements(inputString);

            //Extract the code numbers with custom algorithm
            int[] codeString = new int[elements];
            String[] subString = sliceStringIntoCodeStrings(inputString, elements);

            //convert the code number strings to code numbers and output the decoded letters.
            System.out.print("Teksten var: ");
            for (int i = 0; i < elements; i++) {
                codeString[i] = Integer.parseInt(subString[i]);
                //could shift here
                subString[i] = convertNumberToLetter(codeString[i]);
                System.out.print(subString[i]);
            }
        }
    }

    //method to convert a string to a list of numbers
    public static int[] stringToIntArray(String inputString, int inputLength) {
        int[] intArray = new int[inputLength];
        String letter;
        for (int i = 0; i < inputLength; i++) {
            letter = inputString.substring(i, i + 1);
            int index = letterToInt(letter);
            intArray[i] = index;
        }
        return intArray;
    }

    //method to convert 1 letter to a number
    public static int letterToInt(String letter) {
        return CHARACTERS.indexOf(letter);
    }

    //method to convert a list of numbers to a string
    public static String convertListOfNumbersToString(int[] intArray, int inputLength) {
        String outputString = "{";
        for (int i = 0; i < inputLength - 1; i++) {
            outputString += intArray[i] + ", "; //todo research StringBuilder
        }
        outputString += intArray[inputLength - 1] + "}";
        return outputString;
    }

    //method to convert 1 number to a letter
    public static String convertNumberToLetter(int number) {
        return CHARACTERS.substring(number, number + 1);
    }

    //find how many elements = number of commas +1
    public static int getNumberOfElements(String inputString) {
        int firstComma = inputString.indexOf(",");
        int nextComma = 0;
        int lastComma = inputString.lastIndexOf(",", firstComma + 1);
        int count = -1;
        while (nextComma != lastComma) {
            count++;
            nextComma = inputString.indexOf(",", firstComma + 1);
            firstComma = nextComma;
        }
        return count + 1;
    }

    //extract code strings from input string
    public static String[] sliceStringIntoCodeStrings(String inputString, int codes) {
        String[] codeString = new String[codes];
        for (int i = 0; i < codes; i++) {
            codeString[i] = "";
        }
        int code = 0;
        int position = 0;
        char ch = '{';
        while (ch != '}') { //stop if end of list
            ch = inputString.charAt(position);
            if (Character.isDigit(ch)) {
                while (Character.isDigit(ch)) {
                    codeString[code] += ch;
                    position++;
                    ch = inputString.charAt(position);
                }
                code++; //move to next code string
            }
            position++; //point to next character
        }
        return codeString;
    }
}
