public class Person {
    private final String firstName;
    private final String lastName;
    private final String id; // unique per person

    public Person(String firstName, String lastName, String id) {
        if (firstName == null || lastName == null || id == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + id + ")";
    }
}
