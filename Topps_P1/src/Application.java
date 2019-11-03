
//Martin Topps  Assignment 4 problem 1

// import statments
//import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
//import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) throws IOException{
        FileInputStream fileByteStream =null;
        FileOutputStream outputFile = null;
       // Scanner inFS = null;
        DuplicateRemover uniqueWords = new DuplicateRemover();
      //  PrintWriter ouFS = null;

        fileByteStream = new FileInputStream ("problem1.txt");
        //inFS = new Scanner(fileByteStream);
        uniqueWords.remove(fileByteStream);
        fileByteStream.close();

        outputFile = new FileOutputStream("unique_words.txt");
        //ouFS = new PrintWriter(outputFile);
        uniqueWords.write(outputFile);
        outputFile.close();
    }// end of main
}//end of Application
