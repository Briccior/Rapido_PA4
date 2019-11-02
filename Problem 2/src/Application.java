import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        String inFile = "problem2.txt";
        String outFile = "unique_word_counts.txt";

        DuplicateCounter things = new DuplicateCounter();

        things.count(inFile);

        things.write(outFile);
    }
}