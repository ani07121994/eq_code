package ap.quantas.com;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
    public Test() {
        super();
    }
    
    public static void main(String args[]){
        
        Calendar toBeSet_expirationDate = new GregorianCalendar();
        
        toBeSet_expirationDate.add(Calendar.DAY_OF_MONTH,14);
        
        
        System.out.println("Duration to be set  in mills :: "+(toBeSet_expirationDate.getTimeInMillis() -
                                                        Calendar.getInstance().getTimeInMillis()));
        
        System.out.println("aFTER ADDING " +Calendar.getInstance().getTime());
        Calendar c =new GregorianCalendar();
        c.add(Calendar.SECOND, 3600);
        System.out.println("aFTER ADDING " +c.getTime());
        
     
        
        System.out.println("Duration to be set  in mills :: "+(14 * 24 * 60 * 60 * 1000));
        
        Long  millsValue =Long.parseLong("1209600000");
        System.out.println("millsValue :: "+millsValue );
        
           
    }
}
