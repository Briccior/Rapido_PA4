import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter
{
    private Map<String, Integer> wordCounter;

    public DuplicateCounter(){
        wordCounter = new HashMap<String,Integer>();
    }

    public void count(String filename) throws FileNotFoundException{

        Scanner inFile = null;

        try {
            inFile = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        inFile.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+");

        while(inFile.hasNext())
        {
            String word = inFile.next().toLowerCase();
            Integer count = wordCounter.get(word);

            if(count == null) count = 1;
            else count = count + 1;

            wordCounter.put(word, count);
        }
        inFile.close();
    }

    public void write(String outputFile) throws IOException {
        File outFile = new File(outputFile);
        FileWriter write = null;

        if (outFile.exists()) {
            write = new FileWriter(outFile, false);

            for(String words : wordCounter.keySet())
            {
                write.write(words + " " + wordCounter.get(words) + "\n");
            }
            write.close();
            System.out.println("Old data has been replaced by new data successfully");
        }
        else {
            outFile.createNewFile();
            write = new FileWriter(outFile);

            for(String words : wordCounter.keySet())
            {
                write.write(words + " " + wordCounter.get(words));
            }
            write.close();
            System.out.println("Data Written to new File");
        }
    }

}