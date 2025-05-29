import java.util.*;
import java.util.stream.*;

class Employee {
   int id, age;
   String name, designation, department;
   Employee(int id, String name, String designation) {
       this.id = id;
       this.name = name;
       this.designation = designation;
   }
   Employee(String name, String department) {
       this.name = name;
       this.department = department;
    }
    Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return id + " " + name + " " + designation;
    }
}

class Users {
    String name, email;
    int regYear, age;
    Users(String name, String email, int regYear) {
        this.name = name;
        this.email = email;
        this.regYear = regYear;
    }
    Users(String name, String email, int age, boolean dummy) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}

class Student {
    String name, course;
    int rollNumber;
    List<Integer> marks;
    Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }
    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    Student(String name, String course) {
        this.name = name;
        this.course = course;
    }
    Student(int id, String name) {
        this.name = name;
    }
}

class Product {
    String name, category;
    int price;
    Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class Book {
    String title, author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class Assgn {
     public static void main(String[] args) {

        System.out.println("---------------------------------------------");
        ArrayList<Employee> e = new ArrayList<>();
        e.add(new Employee(1, "Harsit", "Engineer"));
        e.add(new Employee(2, "Aha", "Dev"));
        e.stream()
            .filter(emp -> emp.name.toLowerCase().charAt(0) == emp.name.toLowerCase().charAt(emp.name.length() - 1))
            .forEach(System.out::println);

        System.out.println("---------------------------------------------");
        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("A", "a@gmail.com", 2021));
        users.add(new Users("B", "b@gmail.com", 2018));
        users.stream().filter(u -> u.regYear > 2020)
            .forEach(u -> System.out.println(u.email));

        System.out.println("---------------------------------------------");
        ArrayList<Student> students1 = new ArrayList<>();
        students1.add(new Student("X", Arrays.asList(36, 50, 45)));
        students1.add(new Student("Y", Arrays.asList(25, 50, 45)));
        students1.stream()
            .filter(s -> s.marks.stream().allMatch(m -> m >= 35))
            .forEach(s -> System.out.println(s.name));

        System.out.println("---------------------------------------------");
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(new Product("P1", 42, "A"));
        products1.add(new Product("P2", 21, "B"));
        products1.stream()
            .filter(p -> p.price % 2 == 0 && String.valueOf(p.price).contains("2"))
            .forEach(p -> System.out.println(p.name));

        System.out.println("---------------------------------------------");
        List<String> departments = Arrays.asList("Admin", "Sales", "HR", "Legal");
        departments.stream().filter(d -> d.length() == 5)
            .map(String::toUpperCase)
            .forEach(System.out::println);

        System.out.println("---------------------------------------------");
        ArrayList<Student> students2 = new ArrayList<>();
        students2.add(new Student("Ram", 1));
        students2.add(new Student("Shyam", 2));
        students2.add(new Student("A", 3));
        students2.stream()
            .sorted(Comparator.comparingInt(s -> s.name.length()))
            .forEach(s -> System.out.println(s.name));

        System.out.println("---------------------------------------------");
        ArrayList<Book> books1 = new ArrayList<>();
        books1.add(new Book("Java Basics", "A"));
        books1.add(new Book("Python Book", "B"));
        books1.stream()
            .filter(b -> b.title.toLowerCase().contains("java"))
            .forEach(b -> System.out.println(b.title));

        System.out.println("---------------------------------------------");
        ArrayList<Product> products2 = new ArrayList<>();
        products2.add(new Product("X", 100));
        products2.add(new Product("Y", 200));
        products2.add(new Product("Z", 300));
        double avg = products2.stream().mapToInt(p -> p.price).average().orElse(0);
        products2.stream().filter(p -> p.price > avg)
            .forEach(p -> System.out.println(p.name));

        System.out.println("---------------------------------------------");
        String sentence = "Java Stream Practice";
        Arrays.stream(sentence.split(" "))
            .map(String::length)
            .forEach(System.out::println);

        System.out.println("---------------------------------------------");
        ArrayList<Employee> e2 = new ArrayList<>();
        e2.add(new Employee(1, "Aaeio", 25));
        e2.add(new Employee(2, "Rajiv", 30));
        e2.stream()
            .filter(emp -> emp.name.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) != -1).count() == 3)
            .forEach(System.out::println);

        students2.stream()
            .sorted(Comparator.comparing(s -> s.name.charAt(s.name.length() - 1)))
            .forEach(s -> System.out.println(s.name));

        products2.stream()
            .filter(p -> p.name.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) != -1).count() > 2)
            .forEach(p -> System.out.println(p.name));

        System.out.println("---------------------------------------------");
        List<Student> trimmed = students2.stream()
            .map(s -> new Student(0, s.name.trim()))
            .collect(Collectors.toList());

        System.out.println("---------------------------------------------");
        ArrayList<Users> users2 = new ArrayList<>();
        users2.add(new Users("A", "a@gmail.com", 21, true));
        users2.add(new Users("B", "b@yahoo.com", 22, true));
        users2.stream().filter(u -> u.email.endsWith("@gmail.com"))
            .forEach(u -> System.out.println(u.name));

        System.out.println("---------------------------------------------");
        ArrayList<Student> students3 = new ArrayList<>();
        students3.add(new Student("Bnm", "CS"));
        students3.add(new Student("John", "IT"));
        students3.stream()
            .filter(s -> s.name.toLowerCase().chars().noneMatch(c -> "aeiou".indexOf(c) != -1))
            .forEach(s -> System.out.println(s.name));

        products2.stream()
            .filter(p -> Character.isUpperCase(p.name.charAt(0)))
            .forEach(p -> System.out.println(p.name));

        System.out.println("---------------------------------------------");
        ArrayList<Student> students4 = new ArrayList<>();
        students4.add(new Student("Oddy", Arrays.asList(35, 37, 39)));
        students4.add(new Student("Mix", Arrays.asList(35, 36, 37)));
        students4.stream()
            .filter(s -> s.marks.stream().allMatch(m -> m % 2 == 1))
            .forEach(s -> System.out.println(s.name));

        System.out.println("---------------------------------------------");
        ArrayList<Employee> e3 = new ArrayList<>();
        e3.add(new Employee("John", "IT"));
        e3.add(new Employee("John Smith", "HR"));
        e3.stream()
            .sorted(Comparator.comparingInt(emp -> emp.name.split(" ").length))
            .forEach(System.out::println);

        books1.add(new Book("C++ 101", "Dev"));
        books1.stream()
            .filter(b -> b.title.chars().noneMatch(Character::isDigit))
            .forEach(b -> System.out.println(b.title));

        System.out.println("---------------------------------------------");
        List<String> courses = Arrays.asList("Java", "CSS", "HTML", "SQL", "Oracle");
        courses.stream()
            .filter(c -> {
                String s = c.toLowerCase();
                return !"aeiou".contains("" + s.charAt(0)) && !"aeiou".contains("" + s.charAt(s.length() - 1));
            }).forEach(System.out::println);
        System.out.println("---------------------------------------------");
     }
}