import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.Date;

public class Main {
	public static void main(String[] args) {	
        Scanner in = new Scanner(System.in);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        String t1 = in.next();
        String t2 = in.next();
        
        try {
            Date date1 = format.parse(t1);
            Date date2 = format.parse(t2);
            
            long time = date2.getTime() - date1.getTime();
            
            if (time == 0) {
                System.out.println("24:00:00");
            } else {
                System.out.println(format.format(time));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        in.close();
    }
}
        
        