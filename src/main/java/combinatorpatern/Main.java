package combinatorpatern;

import java.time.LocalDate;

import static combinatorpatern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Yurii",
                "yurii@gmail.com",
                "+380979999999",
                LocalDate.of(1993, 3, 6));

        System.out.println(new CustomerValidatorService().isValid(customer));

        //using combinator
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}