import java.io.*;
import java.nio.file.*;

public class App {
    public static void main(String[] args) throws IOException {
        PersonList people = new PersonList();

        Path dataPath = Paths.get("persons.txt");
        try (InputStream in = Files.newInputStream(dataPath)) {
            people.store(in);
        }

        System.out.println("-- All People --");
        people.display(System.out);

        System.out.println("\n-- Find Tests --");
        System.out.println("Index of ID003: " + people.find("ID003"));
        System.out.println("Index of ID000: " + people.find("ID000"));
    }
}
