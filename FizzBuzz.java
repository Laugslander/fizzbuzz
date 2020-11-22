import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final int RANGE_LENGTH = 30;
    private static final String OUTPUT_SEPARATOR = ", ";

    private static final Map<Integer, String> CONVERSIONS = Map.ofEntries(
            Map.entry(3, "Fizz"),
            Map.entry(5, "Buzz")
    );

    public static void main(String[] args) {
        IntStream.rangeClosed(1, RANGE_LENGTH)
                .mapToObj(FizzBuzz::convert)
                .forEach(FizzBuzz::print);
    }

    private static String convert(int number) {
        return CONVERSIONS.entrySet().stream()
                .filter(e -> number % e.getKey() == 0)
                .map(Entry::getValue)
                .reduce(String::concat)
                .orElse(String.valueOf(number));
    }

    private static void print(String value) {
        System.out.print(value + OUTPUT_SEPARATOR);
    }

}
