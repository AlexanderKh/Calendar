package alex;

import java.util.Date;

public class CalendarApp {
    public static void main(String[] args){
        Date date = new Date(2015,5,1);
        MonthCalendar calendar = new MonthCalendar(date);
        System.out.println(date);
        System.out.println(calendar);
    }


}
