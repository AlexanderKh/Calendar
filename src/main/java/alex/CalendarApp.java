package alex;

import java.util.Calendar;

public class CalendarApp {
    public static void main(String[] args){
        Calendar date = Calendar.getInstance();
        InputReader inputReader = new InputReader();
        boolean wirteToHTML = false;
        if (args.length > 2 && args[2].equals("--out")){
            args[3] = args[3].toUpperCase();
            wirteToHTML = args[3].equals("HTML") ? true : false;
        }
        date.setTime(inputReader.getFirstDayOfMonth(args));
        MonthCalendar calendar = new MonthCalendar(date,wirteToHTML);
        System.out.println(calendar);
    }
}
