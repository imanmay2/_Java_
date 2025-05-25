public class Shallow_Deep_Copy_ {
    public static void main(String args[]){
        Student s1=new Student("Anwesha",1,new int[]{98,99,100});
        


        Student s2=new Student(s1);
        

        s1.print(s2);
        s2.name="Anwesha Chakraborty";
        s1.print(s1);
        System.out.println();
        System.out.println(s1.name);


    }
}

class Student{
    String name;
    int roll;
    int marks[]=new int[3];

    Student(String name,int roll,int marks[]){
        this.name=name;
        this.roll=roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=marks[i];
        }
    }

    Student(Student s1){
        this.name=s1.name;
        this.roll=s1.roll;
        this.marks=s1.marks;
    }


    public void print(Student s){
        System.out.println(s.name);
        System.out.println(s.roll);
        for(int i=0;i<s.marks.length;i++){
            System.out.print(s.marks[i]+" ");
        }
    }
}
