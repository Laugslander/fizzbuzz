
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final Map<Integer, String> CONVERSIONS = new HashMap<>();

    static {
        CONVERSIONS.put(3, "Fizz");
        CONVERSIONS.put(5, "Buzz");
    }

    private static final String OUTPUT_SEPARATOR = ", ";

    public static void main(String[] args) {
        IntStream numbers = IntStream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.mapToObj(FizzBuzz::convert)
                .map(s -> s + OUTPUT_SEPARATOR)
                .forEach(System.out::print);
    }

    private static String convert(int number) {
        String converted = CONVERSIONS.entrySet().stream()
                .filter(e -> number % e.getKey() == 0)
                .map(Map.Entry::getValue)
                .collect(Collectors.joining());

        return converted.length() > 0 ? converted : String.valueOf(number);
    }

}