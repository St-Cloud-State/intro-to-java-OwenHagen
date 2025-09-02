import java.io.*;
import java.nio.file.*;
import java.util.LinkedList;

public class MyMain {

    // Reads "FirstName,LastName,ID" per line from the input stream and appends to the list
    public static void store(InputStream in, LinkedList<Person> list) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.err.println("Skipping malformed line: " + line);
                    continue;
                }
                String first = parts[0].trim();
                String last = parts[1].trim();
                String id = parts[2].trim();
                list.add(new Person(first, last, id));
            }
        }
    }

    // Writes one person per line to the output stream
    public static void display(PrintStream out, LinkedList<Person> list) {
        for (Person p : list) {
            out.println(p.toString());
        }
    }

    // Returns index of person with matching id, or -1 if not found
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        LinkedList<Person> people = new LinkedList<>();

        // We can also adjust this path and put a folder in root if we'd like, a dedicated data folder. For now, this works.
        Path dataPath = Paths.get("persons.txt");

        try (InputStream in = Files.newInputStream(dataPath)) {
            store(in, people);
        }

        System.out.println("-- All People --");
        display(System.out, people);

        System.out.println("\n-- Find Tests --");
        System.out.println("Index of ID002: " + find("ID002", people)); // should be 1 according to my sample data (0 based linked list)
        System.out.println("Index of ID999: " + find("ID999", people)); // should be -1 because there isn't an ID matching ID999
    }
}
