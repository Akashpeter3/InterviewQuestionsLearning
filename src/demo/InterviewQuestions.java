package demo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewQuestions {

    public static void main(String[] args) {

        //reverseString();
        //factorialNumber();
        //palindromeCheck();
        //largestNumber();
        // fibinocciSeries();
        // duplicateNumber();
        // checkGreaterThan();
        // sortingNamesLambda();
        // filterEvenNumbers();
        // optionalExample();
        // streamMapReduceExample();
        // functionInterfaceExample();
        // parallelStreamExample();
        //capitaliseFirstWordOfString();
        //lowerCaseFirstCharacterStringUsingAtomicInteger();
        //usingSubstringToUpperCaase();
        //reverseStringTraditionalWay();
        //secondLargestNumber();
        //reverseNumber();
        //reverseNumberTraditionalWay();
        //largestElementInArray();
        //countingOFDigits();
        //countFreequency();
        //checkChars();
        //toggleString();
        //uniqueCharacters();
        //secondLargestNumberUsingJava8();
        //findMissingNumbersArray();
        convertIntStreamToStringStream();
        //firstEvenNumberGreaterThanTen();
        //sortListOfEmployeesBySalary();
        //findMaximumAndMinimumOfListOfNumbers();
        //partitionListEvenAndOddNumber();
        //longestAndShortestWordInList();
        //flatternListofList();
        //sumOfSquaresEvenList();
        //reverseStringUsingJava8();
        //integerDivisionCheck();
        //countOccuranceEachCharacter();
        //longestStringInList();
        //sumOfIntegerInListReduce();




    }

    private static void sumOfIntegerInListReduce() {
        int sum = Stream.of(1, 5, 7, 9, 2, 7)
                .reduce(Integer::sum).orElse(0);
        System.out.println(sum);
    }

    private static void longestStringInList() {

        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry");

        String word = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).orElse("No Words");

        System.out.println(word);

    }

    private static void countOccuranceEachCharacter() {
        String input = "programming";

        Map<Character, Long> collect = input.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println(collect);
    }

    private static void integerDivisionCheck() {
        int a = 5, b = 2, c = 0;
        double d = 2;
        c = a / b;
        double result = (double) a / b;
        System.out.println(c);
        System.out.println(result);
    }

    private static void reverseStringUsingJava8() {

        String name = "Akash";

        //first way
        String reversed = IntStream.range(0, name.length())
                .mapToObj(i -> name.charAt(name.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());


        //second way
        String reversedWithSecondWay = name.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream();
                })).map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(reversed);
        System.out.println(reversedWithSecondWay);


    }

    private static void sumOfSquaresEvenList() {
        int sum = Arrays.asList(1, 4, 2, 6, 7, 8, 3, 9).stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();

        System.out.println(sum);

    }

    private static void flatternListofList() {
        List<List<Integer>> numberList = List.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        numberList.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    private static void longestAndShortestWordInList() {
        String longestWord = Stream.of("Java", "Streams", "Collectors", "Features")
                .max((a, b) -> a.length() - b.length())
                .orElse("No Words");

        String shortest = Stream.of("Java", "Streams", "Collectors", "Features")
                .min((a, b) -> a.length() - b.length())
                .orElse("No Words");

        System.out.println(longestWord);
        System.out.println(shortest);
    }

    private static void partitionListEvenAndOddNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> partition = numbers.stream()
                .collect(Collectors.partitioningBy((n -> n % 2 == 0)));

        System.out.println("Even number " + partition.get(true));
        System.out.println("Odd number " + partition.get(false));

        List<Integer> numberList = Arrays.asList(-1, 2, 3, 4, -5, 6);
        Map<Boolean, List<Integer>> numberListPartion = numberList
                .stream()
                .collect(Collectors.partitioningBy(n -> n > 0));

        System.out.println("Positive number " + numberListPartion.get(true));
        System.out.println("Negative number " + numberListPartion.get(false));


    }

    private static void findMaximumAndMinimumOfListOfNumbers() {
        int max = Arrays.asList(3, 5, 7, 2, 8).stream()
                .max(Integer::compareTo)
                .orElseThrow();

        int min = Arrays.asList(3, 5, 7, 2, 8).stream()
                .min(Integer::compareTo)
                .orElseThrow();

        System.out.println(max + " " + min);

    }

    private static void sortListOfEmployeesBySalary() {

        class Employee {
            String name;
            double salary;

            Employee(String name, double salary) {
                this.name = name;
                this.salary = salary;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getSalary() {
                return salary;
            }

            public void setSalary(double salary) {
                this.salary = salary;
            }

            @Override
            public String toString() {
                return name + ": " + salary;
            }
        }

        List<Employee> employeeList = Arrays.asList(
                new Employee("Akash", 40000),
                new Employee("Varun", 60000),
                new Employee("Rudra", 70000)
        );

        List<Employee> sortedEmployees = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();
        sortedEmployees.forEach(System.out::println);
    }

    private static void firstEvenNumberGreaterThanTen() {

        Optional<Integer> first = Arrays.asList(1, 4, 10, 30, 33, 2, 6, 8, 29, 50, 34)
                .stream()
                .filter(e -> e > 10)
                .filter(e -> e % 2 == 0)
                .findFirst();

        first.ifPresentOrElse(System.out::println, () -> System.out.println("number not found"));


    }

    private static void convertIntStreamToStringStream() {

        IntStream intStream = IntStream.of(1, 2, 3, 4);

        intStream.mapToObj(String::valueOf)
                .filter(e -> !e.contains("2"))
                .toList()
                .forEach(System.out::println);


    }

    private static void findMissingNumbersArray() {

        List<Integer> numberList = Arrays.asList(3, 7, 5, 9);

        List<Integer> integerList = IntStream.rangeClosed(1, 10)
                .boxed()
                .toList();

        integerList.stream()
                .filter(num -> !numberList.contains(num))
                .toList()
                .forEach(System.out::println);


    }

    private static void secondLargestNumberUsingJava8() {
        int[] numbers = {10, 20, 35, 5, 35, 40, 25};

        //5,10,20,25,35,40

        int number = Arrays.stream(numbers)
                .distinct()
                .sorted()
                .skip(numbers.length - 2)
                .peek(System.out::println)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Array must have least two unique numbers"));

        System.out.println(number);
    }

    private static void uniqueCharacters() {

        String input = "pppdaf";

        Map<Character, Long> collect = input.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        String uniqNames = collect.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining());


        System.out.println(uniqNames);


    }

    private static void toggleString() {

        String name = "jaVaTpoiNt";

        String toggledName = name.chars()
                .mapToObj(c -> Character.isUpperCase((char) c) ? Character.toLowerCase((char) c) : Character.toUpperCase((char) c))
                .map(String::valueOf).collect(Collectors.joining());
        System.out.println(toggledName);
    }

    private static void checkChars() {

        int number = 5647;
        //number
        String numberString = "2132342";
        //numberString.chars()
        int[] numArray = {543534};
        //numArray
        String[] stringArray = {"2132342"};
        // stringArray

    }

    private static void countFreequency() {
        String number = "99991111000";

        Map<Character, Long> collect = number.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        int count = 0;
        collect.forEach((k, v) -> System.out.println("number " + k + " is " + v + " times"));


        collect.entrySet().stream().skip(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);

//
//        for (Map.Entry<Character, Long> entryMap : collect.entrySet()) {
//            count++;
//            if (count == 2) {
//                System.out.println(entryMap.getKey());
//            }
//        }


    }

    private static void countingOFDigits() {
        int number = 5647;
        int count = 0;

        int temp = number;

        while (temp != 0) {
            temp /= 10;
            count++;
        }
        System.out.println(count);
    }

    private static void largestElementInArray() {

        int[] array = {1, 5, 90, 400, 280, 493, 284};
        Arrays.stream(array).max().ifPresent(System.out::println);
    }

    private static void reverseNumberTraditionalWay() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String stringNumbers = "";
        for (int i = numbers.length - 1; i >= 0; i--) {
            stringNumbers += String.valueOf(numbers[i]);
            if (i != 0) {
                stringNumbers += ",";
            }
        }

        System.out.println(stringNumbers);
    }

    private static void reverseNumber() {

        int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Integer[] boxedArray = Arrays.stream(numberArray).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArray, Collections.reverseOrder());

        int[] reverseNumberArray = Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(reverseNumberArray));


    }

    private static void secondLargestNumber() {

        int[] numbers = {1, 6, 2, 10, 300, 433, 446, 35, 903};
        int largest = numbers[0];
        int secondLargest = numbers[1];
        int temp = 0;

        if (secondLargest > largest) {
            temp = largest;
            largest = secondLargest;
            secondLargest = temp;
        }

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                temp = largest;
                largest = numbers[i];
                secondLargest = temp;
            }
        }

        System.out.println(secondLargest);
    }

    private static void reverseStringTraditionalWay() {
        String name = "Peter";
        char[] nameArray = name.toCharArray();
        String reversed = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reversed += nameArray[i];
        }
        System.out.println(reversed);
    }

    private static void usingSubstringToUpperCaase() {
        String name = "appu";
        String string = name.substring(0, 1).toUpperCase() + name.substring(1);
        System.out.println(string);
    }

    private static void lowerCaseFirstCharacterStringUsingAtomicInteger() {
        String name = "John Doe";
        AtomicInteger counter = new AtomicInteger(0);
        String changedName = name.chars()
                .mapToObj(i -> counter.getAndIncrement() == 0 ? Character.toLowerCase((char) i) : (char) i)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(changedName);

    }

    private static void capitaliseFirstWordOfString() {
        String name = "arun";
        String changedName = IntStream.range(0, name.length())
                .mapToObj(i -> (char) i)
                .map(i -> i == 0 ? Character.toUpperCase(name.charAt(0)) : name.charAt(i))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(changedName);
    }

    private static void parallelStreamExample() {
        long start = System.currentTimeMillis();
        int sum = IntStream.range(1, 1_000_000).parallel().sum();
        long end = System.currentTimeMillis();

        long difference = end - start;
        System.out.println(sum);
        System.out.println(difference);
    }

    private static void functionInterfaceExample() {
        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        Consumer<String> consumer = System.out::println;
        Predicate<Integer> predicate = a -> a > 0;

        System.out.println(supplier.get());
        consumer.accept("Akash peter");
        System.out.println(predicate.test(8));
    }

    private static void streamMapReduceExample() {

        List<Integer> numberList = Arrays.asList(1, 4, 6, 9, 10, 9, 32);
        int sum = numberList.stream().map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }

    private static void optionalExample() {

        String name = "Akash";

        Optional<String> optionalString = Optional.ofNullable(name);
        optionalString.ifPresent(n -> System.out.println("Name is " + name));

        String defaultName = optionalString.orElse("Default name");
        System.out.println(defaultName);
    }

    private static void filterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenList = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Even numbers are " + evenList);
    }

    private static void sortingNamesLambda() {
        String[] name = {"Vyshak", "Manu", "Akash"};
        Arrays.stream(name).sorted().forEach(System.out::println);
        List<String> names = Arrays.asList(name);
        names.sort(String::compareTo);
    }

    private static void checkGreaterThan() {

        int a = 1, b = 2;
        if (a != b) System.out.println("a not equal to b");
        else {
            System.out.println("a  equal to b");
        }
    }

    private static void duplicateNumber() {
        int[] arr = {1, 9, 2, 1, 4, 6, 2, 3, 1, 6, 9};
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        // Arrays.stream(arr).distinct().max().ifPresent(System.out::println);

        for (int num : arr) {
            // System.out.println(seen.add(num));
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        System.out.println(duplicates);
    }

    private static void fibinocciSeries() {

        int num = 10;
        int a = 0, b = 1;


        System.out.print("Fibonacci Series: " + a + ", " + b);
        for (int i = 2; i < num; i++) {
            int next = a + b;
            System.out.print(", " + next);
            a = b;
            b = next;
        }

    }

    private static void largestNumber() {

        int[] array = {1, 5, 8, 9, 2, 4};
        int largest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        System.out.println(largest);

    }

    private static void palindromeCheck() {
        String language = "MALAYALAM";
        String reversedString = new StringBuilder(language).reverse().toString();
        String string = language.equals(reversedString) ? language + " is  palindrome" : language + " is not  palindrome";
        System.out.println(string);
    }

    private static void factorialNumber() {
        int number = 5;
        int factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println(factorial);
    }

    private static void reverseString() {
        String name = "Akash Peter";
        String str = new StringBuilder(name).reverse().toString();
        System.out.println(str);
    }
}
