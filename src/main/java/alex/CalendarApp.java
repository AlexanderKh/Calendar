package alex;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;

public class CalendarApp {
    public static void main(String[] args){
        Calendar date = Calendar.getInstance();
        InputReader inputReader = new InputReader();
        boolean writeToHTML = false;
        if (args.length > 2 && args[2].equals("--out")){
            args[3] = args[3].toUpperCase();
            writeToHTML = args[3].equals("HTML");
        }
        date.setTime(inputReader.getFirstDayOfMonth(args));
        MonthCalendar calendar = new MonthCalendar(date, writeToHTML);
        try {
            PrintWriter fw = new PrintWriter("out.html");
            fw.print(calendar.toString());
            fw.close();
        }catch (Exception e){
            System.out.println("hello");
        }

    }
}
