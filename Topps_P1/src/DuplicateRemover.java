import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;


public class DuplicateRemover {

    public ArrayList<String> uniqueWords = new ArrayList<String>();


    public void remove(FileInputStream dataFile) {
        String newWord = new String("");
        Scanner inFS = null;
        Scanner inSS = null;
        String inputLine = new String("");
        int i;
        
        boolean isUnique;
        boolean hasLine = true;
        boolean hasWord = true;
        inFS = new Scanner(dataFile);
        inputLine = inFS.nextLine();

        inSS = new Scanner(inputLine);
        newWord = inSS.next();
        uniqueWords.add(newWord);


        hasWord = inSS.hasNext();
        while(hasLine) {
            while (hasWord) {
                newWord = inSS.next();
                isUnique = true;
                for (i = 0; i < uniqueWords.size(); i++) {
                    if(newWord.equals(uniqueWords.get(i))) {
                        isUnique = false;
                    }//end if
                }//end for loop
                if(isUnique == true){
                    uniqueWords.add(newWord);

                }//end if
                hasWord = inSS.hasNext();
            }// end while loop
            hasWord = true;
            hasLine = inFS.hasNextLine();
            if(hasLine){
                inputLine = inFS.nextLine();
                inSS = new Scanner(inputLine);
            }//end if
        }// end while loop


inSS.close();
inFS.close();
    }//end remove

    public void write(FileOutputStream outputFile){
        PrintWriter ouFS = null;
        ouFS = new PrintWriter(outputFile);
        int i;
        // test for loop
        for(i = 0; i < uniqueWords.size();i++) {
            ouFS.println(uniqueWords.get(i));

        }
        ouFS.flush();
        
    }//end write

}// end of duplicateremoverclass
