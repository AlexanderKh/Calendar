package alex;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Week {
    private static final int DAYS_IN_WEEK = 7;
    private LinkedList<Day> days;

    Week(Date startingDate){
        days = new LinkedList<Day>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startingDate);
        while (calendar.get(Calendar.DAY_OF_WEEK) > 1){
            calendar.add(Calendar.DAY_OF_YEAR, -1);
        }
        for (DayOfWeek dayOfWeek: DayOfWeek.values()){
            days.add(new Day(calendar.getTime(), dayOfWeek));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    public Week getNextWeek(){
        Date last = days.getLast().getDate();
        //get nex
        return new Week();
    }

    public boolean isWeekInNextMonth(){
        System.out.println(days.getLast().getDay());
        return days.getLast().getDay() < DAYS_IN_WEEK;
    }

    @Override
    public String toString(){
        String result = "";
        for (Day day:days)
            result += day.toString() + "\t";
        return result;
    }

}
