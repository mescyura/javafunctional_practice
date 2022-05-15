package com.example;

import java.util.ArrayList;
import java.util.List;

import static com.example.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Yurii", MALE),
                new Person("Alice", FEMALE),
                new Person("Alex", MALE));

        imperativeFilteringByGender(people);
        declarativeFilteringByGender(people);
    }

    //Declarative approach
    private static void declarativeFilteringByGender(List<Person> people) {
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);
        System.out.println();
    }

    //Imperative approach
    private static void imperativeFilteringByGender(List<Person> people) {
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }
    }

    static class Person {
        private final String name;
        public final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

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