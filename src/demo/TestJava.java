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
                .forEach(System.out::println);

        Stream.of(Arrays.asList("Varun", "Manu", "Serin", "Akash")).flatMap(List::stream)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        Stream.of(Arrays.asList("Varun", "Manu", "Serin", "Akash"))
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        int[] arr = {1, 9, 2, 1, 4, 6, 2, 3, 1, 6, 9};

        Map<Integer, Long> countMap = Arrays.stream(arr)
                .boxed().
                collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        countMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        printFunction(".................");

        countMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList()
                .forEach(System.out::println);

        Map<Boolean, List<Integer>> partitionList = Arrays.stream(arr)
                .boxed()
                .distinct()
                .collect(Collectors.partitioningBy(i -> i > 5));

        System.out.println("Greater than 5 " + partitionList.get(true));
        System.out.println("Less than 5 " + partitionList.get(false));

        int[] sortedArray = Arrays.stream(arr)
                .sorted()
                .distinct()
                .toArray();

        System.out.println(Arrays.toString(sortedArray));

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

        int[] numberArray = {1, 5, 9};

        List<Integer> integerList = Arrays.stream(numberArray).boxed().toList();

        printFunction("start");
        IntStream.range(0, 10)
                .boxed()
                .filter(num -> !integerList.contains(num))
                .toList()
                .forEach(TestJava::printFunction);

        //printFunction(misingnumberList);

        printFunction("////////");
        printFunction(value);
        printFunction(max);
        printFunction(maxReduce);
        printFunction(sumReduce);
        printFunction(value);
        printFunction(partionGroup.get(true));
        printFunction(partionGroup.get(false));

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
