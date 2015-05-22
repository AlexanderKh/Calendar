package alex;

import java.util.Calendar;

public class CalendarApp {
    public static final String OUT_PARAMETER = "--out";
    public static final String HTML_PARAMETER = "HTML";
    public static final String TEXT_PARAMETER = "TEXT";
    public static MonthFormatter outMethod;

    public static void main(String[] args){
        Calendar date = Calendar.getInstance();
        InputReader inputReader = new InputReader();
        if (args.length > 2 && args[2].equals(OUT_PARAMETER)) {
            args[3] = args[3].toUpperCase();
            if (args[3].equals(HTML_PARAMETER))
                outMethod = new MonthHTMLFormatter();
            if (args[3].equals(TEXT_PARAMETER))
                outMethod = new MonthTextFormatter();
            if (outMethod == null) {
                System.out.println("Error: enter correct --out argumnet");
                System.exit(0);
            }
            date.setTime(inputReader.getFirstDayOfMonth(args));
            MonthCalendar calendar = new MonthCalendar(date);
            System.out.println(calendar.toString());
        } else
            System.out.println("Please enter right arguments: YYYY MMM --out [HTML][TEXT]");
    }
}
