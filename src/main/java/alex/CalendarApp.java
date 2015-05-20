package alex;

public class CalendarApp {
    public static void main(String[] args){
        MonthCalendar calendar = new MonthCalendar(InputReader.getFirstDayOfMonth(args));
        System.out.print(calendar);
    }


}
