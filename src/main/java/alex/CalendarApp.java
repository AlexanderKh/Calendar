package alex;

import java.util.Calendar;

public class CalendarApp {
    public static void main(String[] args){
        Calendar date = Calendar.getInstance();
        InputReader inputReader = new InputReader();
        date.setTime(inputReader.getFirstDayOfMonth(args));
        MonthCalendar calendar = new MonthCalendar(date,true);
        System.out.println(calendar);
    }
}
