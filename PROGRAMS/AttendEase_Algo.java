import java.sql.Date;
public class AttendEase_Algo{
    int extractDate;
    class extract{
        extract(Date dateObject){
            String objDate=dateObject.toString();
            String date_=String.valueOf(objDate.charAt(8));
            String date=date_.concat(String.valueOf(objDate.charAt(9)));
            extractDate=Integer.parseInt(date);
        } 
    }
    public static void main(String[] args){
        
    }
}