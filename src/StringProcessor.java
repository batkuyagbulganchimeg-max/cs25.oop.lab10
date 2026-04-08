import java.util.*;
import java.util.function.*;

public class StringProcessor {
	public static void processStrings(List<String> strings,
			Predicate<String> filter,
			Function<String, String> transformer,
			Consumer<String> printer) {
		strings.stream()
                .filter(filter)        
                .map(transformer)      
                .forEach(printer);
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java", "Програмчлал", "Код");
		// Хэрэгжүүл: Predicate, Function, Consumer-ийг тодорхойлж, processStrings дууд
	}
}