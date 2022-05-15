package functionalinterface;

import java.util.function.Function;

//takes one args
public class _Function {
    public static void main(String[] args) {
        int increment = increment(0);
        System.out.println(increment);
        int increment2 = incrementByOneFunction.apply(0);
        System.out.println(increment2);
        Function<Integer, Integer> apply = incrementByOneFunction.andThen(incrementByTenFunction);
        System.out.println(apply.apply(2));
        int apply2 = incrementByOneFunction.andThen(incrementByTenFunction).apply(2);
        System.out.println(apply2);
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> incrementByTenFunction = number -> number * 10;

    //imperative
    static int increment(int number) {
        return number + 1;
    }
}