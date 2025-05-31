import java.util.Optional;

class User {
    private String name;
    private Optional<String> email; 

    public User(String name, String email) {
        this.name = name;
        this.email = Optional.ofNullable(email); 
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }
}

public class OptionalExample {
    public static void main(String[] args) {
        User userWithEmail = new User("Alice", "alice@example.com");
        User userWithoutEmail = new User("Bob", null);

        printEmail(userWithEmail);
        printEmail(userWithoutEmail);
    }

    public static void printEmail(User user) {
        user.getEmail().ifPresentOrElse(
            email -> System.out.println(user.getName() + "'s email: " + email),
            () -> System.out.println(user.getName() + " has no email.")
        );
    }
}
