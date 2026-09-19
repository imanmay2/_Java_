public class static_keyword{
    public static void main(String args[]){
        Student s1=new Student();
        s1.setName("Sarada Vidya Mandir");
        System.out.println(s1.getName());


        //creating a new object.....
        Student s2=new Student();
        System.out.println(s2.getName());       // due to static , SVM is stil getting printed...

        Student s3=new Student();
        s1.setName("VIT");
        System.out.println(s1.getName());

    }
}



class Student{
    static String School_Name;
    void setName(String School_Name){
        this.School_Name=School_Name;
    }

    String getName(){
        return this.School_Name;
    }
}