package uds.knudsoft;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Enigma vertical prototype

        //Intro

        //Encode or decode?
        System.out.print("\nTast e til encode eller d til decode ");
        String option = input.nextLine();
        if (option.equals("e") || option.equals("E")) {

            //encode
            //input a string
            System.out.print("Indtast en streng ");
            String inputString = input.nextLine();

            //convert to uppercase
            inputString = inputString.toUpperCase();
            final int inputLength = inputString.length();

            //call stringToIntArray()
            int[] intArray = stringToIntArray(inputString, inputLength);

            //call convertListOfNumbersToString
            String outputString = convertListOfNumbersToString(intArray, inputLength);

            //output encoded string
            System.out.println(outputString);
        } else if (option.equals("d") || option.equals("D")) {

            //decode
            System.out.println("Decoding...");
            //input a list of numbers - test with { 1, 2, 10, 20 }
            String inputString = "{ 1, 2, 3, 23, 12, 0 }";
            int elements = getNumberOfElements(inputString);
            System.out.println(elements);
            String[] subString = sliceStringIntoCodeStrings(inputString, elements);
            for (int i=0;i<elements;i++) {
                System.out.println(subString[i]);
            }


        } else {
            //exit
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
        String characters = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        return characters.indexOf(letter);
    }

    //method to convert a list of numbers to a string
    public static String convertListOfNumbersToString (int[] intArray, int inputLength) {
        String outputString = "{ ";
        for (int i=0;i<inputLength-1;i++) {
            outputString = outputString + intArray[i] + ", ";
        }
        outputString = outputString + intArray[inputLength-1] + " }";
    return outputString;
    }

    //method to convert 1 number to a letter
    public static String convertNumberToLetter(int number) {
        String characters = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        return characters.substring(number, number + 1);
    }

    //find how many elements = number of commas +1
    public static int getNumberOfElements (String inputString) {
        int firstComma = inputString.indexOf(",");
        int nextComma = 0;
        int lastComma = inputString.lastIndexOf("," , firstComma + 1);
        int count = -1;
        while (nextComma != lastComma) {
            count++;
            nextComma = inputString.indexOf("," , firstComma + 1);
            firstComma = nextComma;
        }
        return count +1;
    }

public static String[] sliceStringIntoCodeStrings (String inputString, int codes) {
        String[] codeString = new String[codes];
        for (int i=0;i<codes;i++) {
            codeString[i] = "";
        }
        int code = 0;
        int position = 0;
        char ch = '{';
        while (ch != '}') {
            ch = inputString.charAt(position);
            if (Character.isDigit(ch)) {
                while (Character.isDigit(ch)) {
                    codeString[code] += ch;
                    position++;
                    ch = inputString.charAt(position);
                }
                code++;
            }
            position++;
        }
        return codeString;
}
}
