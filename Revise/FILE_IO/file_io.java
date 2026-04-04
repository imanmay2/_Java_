import java.util.*;
import java.io.*;

public class file_io {

    public static void write(){
        //FileInputStream
        try(FileOutputStream fos=new FileOutputStream("Output.txt")){
            String msg="Hello Anwesha!!";
            fos.write(msg.getBytes());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void read(){
        //FileInputStream
        try(FileInputStream fis=new FileInputStream("Output.txt")){
            int data;
            while((data=fis.read())!=-1){
                System.out.print((char)data);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void transfer(){
        //FileInputStream
        try{
            FileInputStream fis=new FileInputStream("output.txt");
            FileOutputStream fos=new FileOutputStream("copy.txt");
            int data;

            while((data=fis.read())!=-1){
                fos.write(data);
            }

            System.out.println("File copied successfully.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void fileReader(){
        try{
            FileReader fr=new FileReader("copy.txt");
            int data;
            while((data=fr.read())!=-1){
                System.out.print((char)data);
            }

            fr.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void fileWriter(){
        try{
            FileWriter fw=new FileWriter("new.txt");
            fw.write("Happy Birthday Anwesha!!!!\n");
            fw.write("Happy 21st ");
            fw.close();
            System.out.println("Data has been written successfully.");
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void bufferCopy(){
        try(
            BufferedInputStream bis=new BufferedInputStream(new FileInputStream("Output.txt"));
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("copied.txt"))
        ){
            int data;
            while((data=bis.read())!=-1){
                System.out.print((char)data);
                bos.write(data);
            }

            System.out.println("Data written successfully.");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void writeData(){
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("bday.dat"))){
            dos.writeUTF("Anwesha");
            dos.writeInt(21);
            dos.writeBoolean(true);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void readData(){
        try(DataInputStream dis=new DataInputStream(new FileInputStream("bday.dat"))){
            String name=dis.readUTF();
            int age=dis.readInt();
            boolean flag=dis.readBoolean();

            System.out.println("Name : "+name);
            System.out.println("Age : "+age);
            System.out.println("Boolean : "+flag);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        // write();
        // read();

        // transfer();

        System.out.println("...FileWriter & FileReader...");

        // fileReader();
        // fileWriter();

        writeData();
        readData();
        }
}
