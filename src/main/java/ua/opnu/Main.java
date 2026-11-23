package ua.opnu;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //#1
    static final Predicate<Integer> isPrime = n -> {
        if (n < 2) return false;
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    };

    //#2
    static Student[] filter(Student[] input, Predicate<Student> p) {
        Student[] result = new Student[input.length];
        int counter = 0;
        for (Student s : input) {
            if (p.test(s)) {
                result[counter++] = s;
            }}
        return Arrays.copyOfRange(result, 0, counter);
    }

    //#3

    static int[] filter(int[] input, Predicate<Integer> p1, Predicate<Integer> p2) {
        int[] result = new int[input.length];
        int counter = 0;
        for (int i : input) {
            if (p1.test(i) && p2.test(i)) {
                result[counter++] = i;
            }
        }
        return Arrays.copyOfRange(result, 0, counter);
    }

    //#4
    static void forEach(Student[] input, Consumer<Student> action) {
        for (Student s : input) {
            action.accept(s);
        }
    }

    static void main() {
        System.out.println("=== Завдання 1 ===");
        for (int n : new int[]{-3, 0, 1, 2, 9, 13, 25, 97}) {
            System.out.println(n + " -> " + isPrime.test(n));
        }

        System.out.println("\n=== Завдання 2 ===");
        Student[] students = {
                new Student("Борис", "Іванов", "КН-31", new int[]{75, 80, 90}),
                new Student("Петро", "Петренко", "КН-31", new int[]{92, 58, 70}),
                new Student("Ростислав", "Стромбек", "УПІ-251", new int[]{61, 60, 100}),
                new Student("Григорій", "Сковорода", "ER-32", new int[]{88, 40, 55}),
        };
        Predicate<Student> tr = s -> {
            for (int mark : s.getMarks()) {
                if (mark < 60) return false;
            }
            return true;
        };
        for (Student s : filter(students, tr)) {
            System.out.println(s);
        }

        System.out.println("\n=== Завдання 3 ===");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Predicate<Integer> even = n -> n % 2 == 0;
        Predicate<Integer> greaterThan5 = n -> n > 5;
        System.out.println(Arrays.toString(filter(numbers, even, greaterThan5)));
        System.out.println(Arrays.toString(filter(numbers, isPrime, even.negate())));


        System.out.println("\n=== Завдання 4 ===");
        Consumer<Student> printName =
                s -> System.out.println(s.getLastName().toUpperCase() + " " + s.getName());
        forEach(students, printName);


    }
}
