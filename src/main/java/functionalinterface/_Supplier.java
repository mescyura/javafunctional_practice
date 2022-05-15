package functionalinterface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc://localhost:8080/suppliers";

    //imperative
    static String getDBConnectionUrl(){
        return "jdbc://localhost:8080/suppliers";
    }
}