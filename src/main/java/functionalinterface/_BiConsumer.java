package functionalinterface;

import java.util.function.BiConsumer;

//takes two args
public class _BiConsumer {
    public static void main(String[] args) {
        Customer yurii = new Customer("Yurii", "+380979999999");
        greetCustomer(yurii, false);
        System.out.println("-----");
        greetCustomerConsumer.accept(yurii, true);
        System.out.println("-----");
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumer = (customer1, showPhoneNumber) ->
            System.out.println("Hello " + customer1.customerName +
                    ", thanks for registration phone number " + (showPhoneNumber ? customer1.customerPhoneNumber : "************"));

    //imperative
    static void greetCustomer(Customer customer1, Boolean showPhoneNumber) {
        System.out.println("Hello " + customer1.customerName
                + ", thanks for registration phone number " + (showPhoneNumber ? customer1.customerPhoneNumber : "************"));
    }

    record Customer(String customerName, String customerPhoneNumber) {
    }
}