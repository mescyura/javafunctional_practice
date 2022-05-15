package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println(isPhoneNumberValid("+380979999999"));
        System.out.println(isPhoneNumberValid("+38097999999"));
        System.out.println("----");
        System.out.println(isPhoneNumberValidPredicate.test("+380979999999"));
        System.out.println(isPhoneNumberValidPredicate.test("+38097999999"));
        System.out.println("-----");
        System.out.println("Is phone number valid and contains 3 - " +
                isPhoneNumberValidPredicate.and(isPhoneNumberContainsThreePredicate).test("+380979999994"));
        System.out.println("Is phone number valid and contains 3 - " +
                isPhoneNumberValidPredicate.and(isPhoneNumberContainsThreePredicate).test("+380979999999"));
        System.out.println("-----");

    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("+3") && phoneNumber.length() == 13;
    static Predicate<String> isPhoneNumberContainsThreePredicate = phoneNumber -> phoneNumber.contains("4");

    //imperative
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+3") && phoneNumber.length() == 13;
    }
}