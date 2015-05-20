package alex;

import java.util.Calendar;

public class CalendarApp {
    public static void main(String[] args){
        Calendar date = Calendar.getInstance();
        date.setTime(InputReader.getFirstDayOfMonth(args));
        MonthCalendar calendar = new MonthCalendar(date);
        System.out.println(calendar);
    }

}
