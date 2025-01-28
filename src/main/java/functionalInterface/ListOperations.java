package functionalInterface;
import java.util.*;
import java.util.function.*;

public class ListOperations {
    public static Supplier<List<Integer>> generateRandomIntegers = () -> {
        List<Integer> randomIntegers = new ArrayList<>();
        Random random = new Random();
        for (int i=0;
        i < 10;
        i++) {
            randomIntegers.add(random.nextInt(100));
        }
        return randomIntegers;

    };
    public static Predicate<Integer> isEven = number -> number % 2 == 0;
    private static Integer threshold;

    public static Predicate<Integer> isGreaterThanThreshold(int threshold) {

        return number -> number > threshold;
    }

    public static Consumer<Integer> printElement = System.out::println;

    public static int calculateSquare(int number) {
        return number * number;
    }

    public static Consumer<Integer> printSquare = number -> System.out.println(calculateSquare(number));

    public static Runnable executeProgramlogic = () -> {
        List<Integer> integers = generateRandomIntegers.get();
        if (integers == null || integers.isEmpty()) {
            System.out.println("The list is empty");
            return;
        }
        System.out.println("Original list");
        integers.forEach(printElement);

        int threshold = 50;
        List<Integer> filteredList = filterList(integers, isEven.and(isGreaterThanThreshold(threshold))); {

            System.out.println("\nFiltered list (Even and >" + threshold + "):");
            filteredList.forEach(printElement);

            System.out.println("\nSquares of the filtered numbers");
            filteredList.forEach(printSquare);
        }
    };

    public static <T> List<T> filterList(List<T> list, Predicate<T> condition) {
        if (list == null) {
            return new ArrayList<>();
        }

        List<T> result=new ArrayList<>();
        for (T element: list){
            if (condition.test(element)){
                result.add(element);
            }
        } return result;
    }

    public static void main(String[] args) {
        executeProgramlogic.run();
    }
}
