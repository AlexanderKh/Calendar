package alex;

import alex.renderer.AbstractCalendarRenderer;
import alex.renderer.ConsoleCalendarRenderer;
import alex.renderer.HTMLCalendarRenderer;

import java.util.Calendar;

public class CalendarApp {
    public static final String OUT_PARAMETER = "--out";
    public static final String HTML_PARAMETER = "HTML";
    public static final String TEXT_PARAMETER = "TEXT";
    public static final int ARGS_NUM_OF_YEAR = 0;
    public static final int ARGS_NUM_OF_MONTH = 1;
    public static final int ARGS_NUM_OF_OUT = 2;
    public static final int ARGS_NUM_OF_OUT_TEXT = 3;
    public static AbstractCalendarRenderer renderer;

    public static void main(String[] args){
        Calendar date = Calendar.getInstance();
        InputReader inputReader = new InputReader();
        if (args.length > ARGS_NUM_OF_OUT && args[ARGS_NUM_OF_OUT].equals(OUT_PARAMETER)) {
            args[ARGS_NUM_OF_OUT_TEXT] = args[ARGS_NUM_OF_OUT_TEXT].toUpperCase();
            if (args[ARGS_NUM_OF_OUT_TEXT].equals(HTML_PARAMETER))
                renderer = new HTMLCalendarRenderer();
            if (args[ARGS_NUM_OF_OUT_TEXT].equals(TEXT_PARAMETER))
                renderer = new ConsoleCalendarRenderer();
            if (renderer == null) {
                System.out.println("Error: enter correct --out argumnet");
                System.exit(0);
            }
            date.setTime(inputReader.getFirstDayOfMonth(args));
            MonthCalendar calendar = new MonthCalendar(date);
            System.out.println(renderer.render(calendar));
        } else
            System.out.println("Please enter right arguments: YYYY MMM --out [HTML][TEXT]");
    }
}
