class List_<t1,t2>{

    t1 n1;
    t2 n2;
    public List_(t1 n1,t2 n2){
        this.n1=n1;
        this.n2=n2;
    }

    public void print(){
        System.out.println(n1+" , "+n2);
    }
}


public class generics {
    


    public static void main(String args[]){
        List_<Integer,Integer> l1=new List_(12,34);
        l1.print();
    }
}
