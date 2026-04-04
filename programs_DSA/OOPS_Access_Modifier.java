public class OOPS_Access_Modifier {
    public static void main(String args[]){
        String passwd="Manmay@1234";
        Password p1=new Password();
        p1.setPasswd(passwd);
        System.out.println(p1.passwd);
    }
}


class Password{
    private String passwd;
    Password(){
        System.out.println("PassWord contructor called");
    }


    public void setPasswd(String passwd) {
        this.passwd = passwd;
        System.out.println("Password Setting task completed.");
    }
}
