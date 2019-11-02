import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        String inFile = "problem1.txt";
        String outFile = "unique_words.txt";

        DuplicateRemover things = new DuplicateRemover();

        things.remove(inFile);

        things.Write(outFile);
    }
}