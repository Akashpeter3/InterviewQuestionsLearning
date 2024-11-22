package demo;

import java.util.Arrays;

public class JavaTesting {

    public static void main(String[] args) {

        // maxArray();

        // reverseArray();

        //secondLargestNumber();

        reverseString();
    }

    private static void reverseString() {

        String name = "Akash";

        StringBuilder builder = new StringBuilder(name);
        builder.reverse();
        //System.out.println(builder.toString());

        char[] nameArray = name.toCharArray();
        char[] reversedArray = new char[nameArray.length];
        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i]= nameArray[nameArray.length-1-i];
        }

        String reversedString = new String(reversedArray);
        System.out.println(reversedString);
      //  System.out.println(Arrays.toString(reversedArray));
    }

    private static void secondLargestNumber() {

        int[] numArray = {9, 10, 10, 0, 11, 10, 12, 18};

        int firstLargest = numArray[0];
        int secondLargest = numArray[1];
        int temp = 0;

        if (secondLargest > firstLargest) {
            temp = firstLargest;
            firstLargest = secondLargest;
            secondLargest = temp;
        }

        for (int i = 2; i < numArray.length; i++) {
            if (numArray[i] > firstLargest) {
                temp = firstLargest;
                firstLargest = numArray[i];
                secondLargest = temp;
            }
        }
        System.out.println(firstLargest + " " + secondLargest);


    }

    private static void reverseArray() {

        int[] numArray = {1, 9, 7, 0, 11};

        int lastIndex = numArray.length - 1;
        int[] reversedArray = new int[numArray.length];

        for (int i = 0; i < reversedArray.length; i++) {
            reversedArray[i] = numArray[lastIndex - i];

        }

        System.out.println(Arrays.toString(reversedArray));

    }

    private static void maxArray() {
        int[] numArray = {1, 9, 7, 0, 11};
        int max = numArray[0];
        int temp = 0;

        for (int i = 0; i < numArray.length; i++) {

            if (numArray[i] > max) {
                max = numArray[i];
            }
        }
        System.out.println(max);
    }
}
