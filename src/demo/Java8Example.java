package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Java8Example {

    public static void main(String[] args) {
        List<Integer> numlist = Arrays.asList(1, 10, 4, 9, 0);

        List<Integer> list = numlist.stream().filter(n -> n > 6).peek(System.out::println).toList();

        reverseArray();
        duplicateElementArray();


    }

    private static void duplicateElementArray() {

        int [] numArray = {1,1,6,7,0,9,9};
        List<Integer>integerList= new ArrayList<>();
        for (int i = 0; i < numArray.length; i++) {
            for (int j = i+1; j < numArray.length; j++) {
                if (numArray[i] == numArray[j]) {
                    integerList.add(numArray[i]);
                }
            }
        }
       integerList.forEach(System.out::println);

    }

    private static void reverseArray() {

        String arr = "Akash";

        char[] name = arr.toCharArray();
        String reversed = "";
        for (int i = name.length - 1; i >= 0; i--) {

            reversed += name[i];

        }
        System.out.println(reversed);

    }






}
