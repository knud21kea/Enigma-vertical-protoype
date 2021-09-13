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

            //if encode
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
        }

        //else decode
        //input a list of numbers - test with { 1, 2, 10, 20 }

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

    //convert users input to captitals


}
