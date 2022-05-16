package streams;

import java.util.*;
import java.util.stream.Collectors;

import static streams._StreamPractice.Gender.FEMALE;
import static streams._StreamPractice.Gender.MALE;

public class _StreamPractice {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach ❌

        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.gender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);
        System.out.println("---");

        // Declarative approach ✅

        //Filter
        System.out.println("-filter fy female-");
        List<Person> filteredFemales = people.stream()
                .filter(person -> person.gender().equals(FEMALE))
                .collect(Collectors.toList());
        filteredFemales.forEach(System.out::println);
        System.out.println("---");

        //Sort
        System.out.println("-sort by age-");
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparing(Person::age))
                .collect(Collectors.toList());
        sortedByAge.forEach(System.out::println);
        System.out.println("---");

        //All Match
        System.out.println("-all match age > 5-");
        boolean allMatch = people.stream()
                .allMatch(person -> person.age > 5);
        System.out.println(allMatch);
        System.out.println("---");

        //Any Match
        System.out.println("-any match - name 'Antonio'-");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.name().equals("Antonio"));
        System.out.println(anyMatch);
        System.out.println("---");

        //None Match
        System.out.println("-none match age > 121-");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.age() > 121);
        System.out.println(noneMatch);
        System.out.println("---");

        //Max
        System.out.println("-max age Person-");
        people.stream()
                .max(Comparator.comparing(Person::age))
                .ifPresent(System.out::println);
        System.out.println("---");

        //Min
        System.out.println("-min age Person-");
        people.stream()
                .min(Comparator.comparing(Person::age))
                .ifPresent(System.out::println);
        System.out.println("---");

        //Group
        System.out.println("-group by gender-");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::gender));
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });
        System.out.println("---");

        //Group methods together
        System.out.println("-filter by gender and get the oldest male-");
        people.stream()
                .filter(person -> person.gender().equals(MALE))
                .max(Comparator.comparing(Person::age))
                .ifPresent(System.out::println);
        System.out.println("---");
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, MALE),
                new Person("Alina Smith", 33, FEMALE),
                new Person("Helen White", 57, FEMALE),
                new Person("Alex Boz", 14, MALE),
                new Person("Jamie Goa", 99, MALE),
                new Person("Anna Cook", 7, FEMALE),
                new Person("Zelda Brown", 120, FEMALE)
        );
    }

    static record Person(String name, int age, Gender gender) {

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public String name() {
            return name;
        }

        @Override
        public int age() {
            return age;
        }

        @Override
        public Gender gender() {
            return gender;
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}