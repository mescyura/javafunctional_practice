package combinatorpatern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpatern.CustomerRegistrationValidator.*;
import static combinatorpatern.CustomerRegistrationValidator.ValidationResult.*;

//functional approach
//combinator
public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@")
                ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+380") && customer.getPhoneNumber().length() == 13
                ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18
                ? SUCCESS : IS_NOT_A_ADULT;
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_A_ADULT
    }
}