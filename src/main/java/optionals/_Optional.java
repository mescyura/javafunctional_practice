package optionals;

import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {
        Optional.ofNullable("Hello")
                .ifPresent(value -> {
                    String output = value.toUpperCase();
                    System.out.println(output);
                });
    }
}