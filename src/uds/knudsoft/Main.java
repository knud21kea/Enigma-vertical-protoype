package uds.knudsoft;

public class Main {

    public static void main(String[] args) {
        // Enigma vertical prototype

        //Intro

        //Encode or decode?

        //if encode
        //input a string - test with "KODE"
        String inputString = "KODE";
        //convert to uppercase (method)
        //call stringToIntArray()
        stringToIntArray(inputString);
        //call convertListOfNumbersToString
        //output encoded string

        //else decode
        //input a list of numbers - test with 1,2,3,4

    }
    //String from int array

    //String to int array
    public static void stringToIntArray(String inputString) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        int length = inputString.length();
        int[] intArray = new int[length];
        String ch;
        int index = 0;
        for (int i = 0; i < length; i++) {
            ch = inputString.substring(i, i + 1);
            index = characters.indexOf(ch);
            intArray[i] = index +1;
            System.out.println(intArray[i]);
        }
    }

    //method to convert a string to a list of numbers

    //method to convert 1 letter to a number

    //method to convert a list of numbers to a string

    //method to convert 1 number to a letter

    //convert users input to captitals


}
