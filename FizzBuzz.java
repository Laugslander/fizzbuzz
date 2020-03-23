import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final int SEQUENCE_LENGTH = 25;
    private static final String OUTPUT_SEPARATOR = ", ";

    private static final Map<Integer, String> CONVERSIONS = Map.of(
            3, "Fizz",
            5, "Buzz"
    );

    public static void main(String[] args) {
        IntStream.rangeClosed(1, SEQUENCE_LENGTH)
                .mapToObj(FizzBuzz::convert)
                .forEach(FizzBuzz::print);
    }

    private static String convert(final int number) {
        String conversion = CONVERSIONS.entrySet().stream()
                .filter(entry -> number % entry.getKey() == 0)
                .map(Entry::getValue)
                .collect(Collectors.joining());

        return conversion.isEmpty() ? String.valueOf(number) : conversion;
    }

    private static void print(String value) {
        System.out.print(value + OUTPUT_SEPARATOR);
    }

}
