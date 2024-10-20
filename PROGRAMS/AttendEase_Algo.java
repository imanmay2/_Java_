import java.sql.Date;
import java.util.HashMap;
public class AttendEase_Algo{
    
    public static HashMap<String,extract> getdateMap(Date date){
        HashMap<String,extract> dateMap = new HashMap<>();
        //Code as required
        // dateMap.put("Mon",new extract(date)); //Sat Oct 20......
        // System.out.println(dateMap); //{"Mon":Object<extract>}
        // extract val = dateMap.get("Mon");
        // val.getDate() // 20
        // val.{} //Oct 20, 2024
        return dateMap;
    }

    
    // Sun Oct 20 12:23:35 IST 2024.
    public static class extract{
        private int extractDate;
        private String fetch_Date;
        public Date date;
        public extract(Date dateObject){
            this.date = dateObject;
            String objDate=this.date.toString();
            String[] arrWords=new String[6];
            String dateWord="";
            int ct=-1;
            for(int i=0;i<objDate.length;i++){
                if(objDate.charAt(i)==" "){
                    ct++;
                    arrWords[ct]=dateWord;
                    dateWord="";
                }
                else{
                    dateWord=dateWord+String.valueOf(objDate.charAt(i));
                }
            }

            this.extractDate=Integer.parseInt(arrWords[2]);
            // String date_=String.valueOf(objDate.charAt(8));
            // String date=date_.concat(String.valueOf(objDate.charAt(9)));
            // this.extractDate=Integer.parseInt(date);  
            this.fetch_Date=arr[1]+" "+arr[2]+","+" "+arr[5];
        }

        
        public static int getDate(){
            //It will return the Integer value of the input date.
            return this.extractDate;      
        }

        public static String fetchDate(){
            // It will fetch the date as : Oct 20, 2024 .
            return this.fetch_Date;
        } 
    }
    public static void main(String[] args){
        System.out.println(new extract(new Date()).getDate());
    }
}
