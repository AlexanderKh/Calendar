package alex;

import java.util.Calendar;

public class CalendarApp {
    public static WierdInterface outMethod;

    public static void main(String[] args){
        Calendar date = Calendar.getInstance();
        InputReader inputReader = new InputReader();
        if (args.length > 2 && args[2].equals("--out")) {
            args[3] = args[3].toUpperCase();
            if (args[3].equals("HTML"))
                outMethod = new WierdClassForHTML();
            if (args[3].equals("TEXT"))
                outMethod = new WierdClassForText();
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
