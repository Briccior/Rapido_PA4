import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {

    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException{

        String words;

        uniqueWords = new HashSet<String>();
        Scanner scnr = new Scanner(new File(dataFile));

        while(scnr.hasNext())
        {
            words = scnr.next();
            uniqueWords.add(words);
        }
        scnr.close();
    }

    public void Write(String outputFile) throws IOException{
        File outFile = new File(outputFile);
        FileWriter write = null;

        if(outFile.exists()) {
            write = new FileWriter(outFile, false);
            Iterator iterate = uniqueWords.iterator();

            while(iterate.hasNext())
            {
                String name = (String)iterate.next();
                write.write(name + "\n");
            }
            write.close();

            System.out.println("Old data has been replaced by new data successfully");
        }
        else {
            outFile.createNewFile();
            write = new FileWriter(outFile);
            Iterator iterate = uniqueWords.iterator();

            while (iterate.hasNext())
            {
                String name = (String)iterate.next();
                write.write(name + "\n");
            }
            write.close();
            System.out.println("Data Written to new File");
        }
    }
}

