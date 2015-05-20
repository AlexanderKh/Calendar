package alex;

import java.util.Calendar;
import java.util.Date;

public class CalendarApp {
    public static void main(String[] args){
        Calendar date = Calendar.getInstance();
        date.set(2015,5,1);
        MonthCalendar calendar = new MonthCalendar(date);
        System.out.println(date);
        System.out.println(calendar);
    }


}
