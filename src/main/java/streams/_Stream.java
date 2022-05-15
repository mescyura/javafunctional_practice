package streams;

import java.util.List;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Yurii", MALE),
                new Person("Alice", FEMALE),
                new Person("Alex", MALE));

//        people.stream()
//                .map(person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);

        boolean femalePresented = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(femalePresented);
    }

    record Person(String name, Gender gender) {

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}