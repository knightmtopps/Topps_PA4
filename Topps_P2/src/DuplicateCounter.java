import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.Queue;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;

public class DuplicateCounter {

    public HashMap<String,Integer> wordCounter = new HashMap<String,Integer>();
    public Queue<String> hashList = new LinkedList<String>();


    public void count(FileInputStream dataFile) {

        //variable declarations
        String newWord = new String("");
        Scanner inFS = null;
        Scanner inSS = null;
        String inputLine = new String("");
       
      //  boolean isUnique;
        boolean hasLine = true;
        boolean hasWord = true;
        inFS = new Scanner(dataFile);
        inputLine = inFS.nextLine();

        //create scanners
        inSS = new Scanner(inputLine);
        newWord = inSS.next();
        wordCounter.put(newWord,1);
        hashList.add(newWord);

        //scan in each line
        hasWord = inSS.hasNext();
        while(hasLine) {
            //scan each word in line
            while (hasWord) {
                newWord = inSS.next();
               // isUnique = true;
                if(wordCounter.containsKey(newWord)) {
                    wordCounter.put(newWord,(wordCounter.get(newWord)+1));
                }// end if
                    else { wordCounter.put(newWord,1);
                            hashList.add(newWord);
                }//end else

                //}//end if
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
        String hashWord = new String("");
        PrintWriter ouFS = null;
        ouFS = new PrintWriter(outputFile);

        while(hashList.size() > 0){
            hashWord = hashList.poll();
            ouFS.printf("%10s   %3d\n",hashWord,wordCounter.get(hashWord));
        }//end while loop

        ouFS.flush();
        
        ouFS.close();
    }//end write


}//end DuplicateCounter
