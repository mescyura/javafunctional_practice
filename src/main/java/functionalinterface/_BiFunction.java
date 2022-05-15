package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

//takes two args
public class _BiFunction {
    public static void main(String[] args) {
        int increment = incrementByOneAndMultiply(1, 2);
        System.out.println(increment);
        int increment2 = incrementByOneAndMultiplyFunction.apply(1, 2);
        System.out.println(increment2);
        BiFunction<Integer, Integer, Integer> apply = incrementByOneAndMultiplyFunction.andThen(divideFunction);
        System.out.println(apply.apply(2, 2));
        int apply2 = incrementByOneAndMultiplyFunction.andThen(divideFunction).apply(2, 2);
        System.out.println(apply2);
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction = (number, multiplyBy) -> (number + 1) * multiplyBy;
    static Function<Integer, Integer> divideFunction = number -> number / 2;

    //imperative
    static int incrementByOneAndMultiply(int number, int multiplyBy) {
        return (number + 1) * multiplyBy;
    }
}