import java.util.*;
import java.io.*;

public class buffer_ioStream{
    public static void main(String args[]){
        try{
            BufferedReader br=new BufferedReader(new FileReader("hello.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("self.txt"));

            String line;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }

            br.close();
            bw.close();
        } catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());

        }
         finally{
            System.out.println("File Content has been transferred.");

         }
    }
}