import java.util.*;
import java.io.*;

public class buffer_ioStream{
    public static void main(String args[]){
        try{
            BufferedReader br=new BufferedReader(new FileReader("hello.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("hello_.txt"));

            String line;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }

            bw.close();
            br.close();
        } catch(IOException e){
            System.out.println("Error occured : "+ e.getMessage());
        }
    }
}