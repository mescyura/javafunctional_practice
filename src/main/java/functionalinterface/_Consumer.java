package functionalinterface;

import java.util.function.Consumer;

//takes one args
public class _Consumer {
    public static void main(String[] args) {
        Customer yurii = new Customer("Yurii", "+380979999999");
        greetCustomer(yurii);
        System.out.println("-----");
        greetCustomerConsumer.accept(yurii);
        System.out.println("-----");
        Consumer<Customer> customerConsumer = greetCustomerConsumer.andThen(helloCustomerConsumer);
        customerConsumer.accept(yurii);
    }

    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello " + customer.customerName
            + ", thanks for registration phone number " + customer.customerPhoneNumber);

    static Consumer<Customer> helloCustomerConsumer = customer -> System.out.println("Hello world");

    //imperative
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName
                + ", thanks for registration phone number " + customer.customerPhoneNumber);
    }

    record Customer(String customerName, String customerPhoneNumber) {
    }
}