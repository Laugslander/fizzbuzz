import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final int NUMBER_COUNT = 25;
    private static final String OUTPUT_SEPARATOR = ", ";

    private static final Map<Integer, String> CONVERSIONS = new TreeMap<>();

    static {
        CONVERSIONS.put(3, "Fizz");
        CONVERSIONS.put(5, "Buzz");
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, NUMBER_COUNT)
                .mapToObj(FizzBuzz::convert)
                .forEach(FizzBuzz::print);
    }

    private static String convert(int number) {
        String converted = CONVERSIONS.entrySet().stream()
                .filter(entry -> number % entry.getKey() == 0)
                .map(Entry::getValue)
                .collect(Collectors.joining());

        return converted.isEmpty() ? String.valueOf(number) : converted;
    }

    private static void print(String value) {
        System.out.print(value + OUTPUT_SEPARATOR);
    }

}
