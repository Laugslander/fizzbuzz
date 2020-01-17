
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final String OUTPUT_SEPARATOR = ", ";
    private static final int NUMBER_COUNT = 25;

    private static final Map<Integer, String> CONVERSIONS = new HashMap<>();

    static {
        CONVERSIONS.put(3, "Fizz");
        CONVERSIONS.put(5, "Buzz");
    }

    public static void main(String[] args) {
        IntStream numbers = IntStream.rangeClosed(1, NUMBER_COUNT);

        numbers.mapToObj(FizzBuzz::convert)
                .map(output -> output + OUTPUT_SEPARATOR)
                .forEach(System.out::print);
    }

    private static String convert(int number) {
        String converted = CONVERSIONS.entrySet().stream()
                .filter(entry -> number % entry.getKey() == 0)
                .map(Map.Entry::getValue)
                .collect(Collectors.joining());

        return converted.isEmpty() ? String.valueOf(number) : converted;
    }

}