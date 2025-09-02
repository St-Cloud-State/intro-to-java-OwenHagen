import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private final LinkedList<Person> list = new LinkedList<>();

    // Reads "FirstName,LastName,ID" per line and appends to the list
    public void store(InputStream in) throws IOException {
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
                String last  = parts[1].trim();
                String id    = parts[2].trim();
                list.add(new Person(first, last, id));
            }
        }
    }

    // Writes one person per line to the output stream
    public void display(PrintStream out) {
        for (Person p : list) {
            out.println(p.toString());
        }
    }

    // Returns index of person with matching id, or -1 if not found (0 based linked list)
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    // just some helpers
    public void add(Person p) { list.add(p); }
    public LinkedList<Person> asLinkedList() { return list; }
}

