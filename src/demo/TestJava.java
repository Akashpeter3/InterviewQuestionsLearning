package demo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestJava {

    public static void main(String[] args) {

        Stream.of(Arrays.asList("Varun", "Manu", "Serin", "Akash"))
                .flatMap(List::stream)
                .sorted()
                .toList()
                .forEach(TestJava::printFunction);

        Stream.of(Arrays.asList("Varun", "Manu", "Serin", "Akash")).flatMap(List::stream)
                .sorted(Comparator.naturalOrder())
                .forEach(TestJava::printFunction);

        Stream.of(Arrays.asList("Varun", "Manu", "Serin", "Akash"))
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .forEach(TestJava::printFunction);


        int[] arr = {1, 9, 2, 1, 4, 6, 2, 3, 1, 6, 9};

        Map<Integer, Long> countMap = Arrays.stream(arr)
                .boxed().
                collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        countMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(TestJava::printFunction);

        printFunction(".................");

        countMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList()
                .forEach(TestJava::printFunction);

        Map<Boolean, List<Integer>> partitionList = Arrays.stream(arr)
                .boxed()
                .distinct()
                .collect(Collectors.partitioningBy(i -> i > 5));

        printFunction("Greater than 5 " + partitionList.get(true));
        printFunction("Less than 5 " + partitionList.get(false));

        int[] sortedArray = Arrays.stream(arr)
                .sorted()
                .distinct()
                .toArray();

        printFunction(Arrays.toString(sortedArray));

        int max = Arrays.stream(arr)
                .boxed()
                .distinct()
                .max((a, b) -> a - b)
                .orElse(0);

        int maxReduce = Arrays.stream(arr)
                .boxed()
                .distinct()
                .reduce((a, b) -> a > b ? a : b)
                .orElse(0);

        int sumReduce = Arrays.stream(arr)
                .boxed()
                .distinct()
                .reduce(0, Integer::sum);

        int value = Arrays.stream(arr).parallel()
                .boxed()
                .distinct()
                .reduce(0, Integer::sum, Integer::sum);

        Map<Boolean, List<Integer>> partionGroup = Arrays.stream(arr).
                boxed()
                .distinct()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        int[] numberArray = {1, 5, 9, 4};

        List<Integer> integerList = Arrays.stream(numberArray).boxed().toList();

        printFunction("start");
        IntStream.range(0, 10)
                .boxed()
                .filter(num -> !integerList.contains(num))
                .toList()
                .forEach(TestJava::printFunction);

        Arrays.stream(numberArray).boxed()
                .filter(num -> num > 2)
                .filter(num -> num % 2 == 0)
                .findFirst()
                .ifPresentOrElse(TestJava::printFunction, () -> printFunction("No number present"));

        String name = "jaVaTpoiNt";

        String toggle = name.chars()
                .mapToObj(i -> (char) i)
                .map(i -> Character.isUpperCase((i)) ? Character.toLowerCase((i)) : Character.toUpperCase((i)))
                .map(String::valueOf)
                .collect(Collectors.joining());

        printFunction(toggle);

        int number = 5647;

        int length = String.valueOf(number).length();
        printFunction(length);

        int[] array = {1, 5, 90, 400, 280, 493, 284};
        Arrays.stream(array).max().ifPresent(TestJava::printFunction);

        String myName = "Akash Peter";

        String reverseMyName = new StringBuilder(myName).reverse().toString();
        //printFunction(reverseMyName);

        int[] arrays = {1, 9,};
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int arrayy : arrays) {
            if (!seen.add(arrayy)) {
                duplicates.add(arrayy);
            }

        }
        //printFunction(duplicates);

        int values = IntStream.rangeClosed(1, 5)
                .boxed()
                .distinct()
                .reduce(1, (i, c) -> i * c);
        printFunction(values);


        int[] numbers = {10, 20, 35, 5, 35, 40, 25};
        //{5,10,20,35,40}
        int numberss = Arrays.stream(numbers)
                .distinct()
                .sorted()
                .skip(numbers.length - 3)
                .findFirst()
                .orElse(0);


        printFunction(numberss);

        String[] arrayString = {"vishnu", "arun", "dravid", "manu", "sena", "john"};


//        Arrays.stream(arrayString)
//                .map(e -> Character.toUpperCase(e.charAt(0)) + e.substring(1))
//                .toList()
//                .forEach(System.out::println);

//        Arrays.stream(arrayString)
//                .filter(na -> na.equals("vishnu"))
//                .toList()
//                .forEach(System.out::println);

//        String wordString = Arrays.stream(arrayString)
//                .skip(1)
//                .findFirst()
//                .orElse("no words");

//     long count =   Arrays.stream(arrayString).count();
//     printFunction(count);

//      String nammess=  Arrays.stream(arrayString).max((a,b)->a.length()-b.length()).orElse("no word");
//        System.out.println(nammess);

//        Arrays.stream(arrayString)
//                .sorted(Comparator.comparing(String::length))
//                .skip(2).findFirst()
//                .ifPresent(System.out::println);


        int[] a = {1, 4, 7, 9};
        int[] b = {4, 8, 9, 2};

        int[] newArray = IntStream.range(0, a.length)
                .map(i -> a[i] * b[i])
                .toArray();

        printFunction(Arrays.toString(newArray));

        int[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.stream(numArray)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        String naamee = "Akash";


        String reverseNameee = naamee.chars().mapToObj(i -> (char) i).sorted(Comparator.reverseOrder())
                .map(String::valueOf).collect(Collectors.joining());

        printFunction(reverseNameee);

        Arrays.stream(numArray)
                .boxed()
                .sorted(Comparator.reverseOrder()).toList().forEach(TestJava::printFunction);

        String myOwnName = "Akash Peter";


//     String [] splitArray =  Arrays
//               .stream(myOwnName.split(" "))
//               .toArray(String[]::new);

//        System.out.println(splitArray[0]);
//        System.out.println(splitArray[1]);
        String homeName = "Palathai Parambu";
        String[] arrayyys = Arrays.stream(homeName.split(" "))
                .toArray(String[]::new);

        printFunction(arrayyys[0]);
        printFunction(arrayyys[1]);

        int nu = 55555;

        Long counted = String.valueOf(number).chars()
                .count();
        printFunction(counted);


        //printFunction(misingnumberList);

        printFunction("////////");
//        printFunction(value);
//        printFunction(max);
//        printFunction(maxReduce);
//        printFunction(sumReduce);
//        printFunction(value);
//        printFunction(partionGroup.get(true));
//        printFunction(partionGroup.get(false));


//


    }

    private static void printFunction(Object value) {

        Predicate<Object> isPrintable = v -> v instanceof String
                || v instanceof Integer
                || v instanceof Boolean
                || v instanceof Double
                || v instanceof Float
                || v instanceof Long
                || v instanceof Character
                || v instanceof java.util.Collection
                || v instanceof java.util.Map;

        if (isPrintable.test(value)) {
            System.out.println(value);
        }
    }


}
