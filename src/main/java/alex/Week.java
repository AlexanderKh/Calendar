package alex;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Week {
    private static final int DAYS_IN_WEEK = 7;
    private LinkedList<Day> days;

    Week(Calendar startingDate){
        days = new LinkedList<Day>();
        Calendar calendar = startingDate;
        while (calendar.get(Calendar.DAY_OF_WEEK) > 1){
            calendar.add(Calendar.DAY_OF_YEAR, -1);
        }
        for (DayOfWeek dayOfWeek: DayOfWeek.values()){
            days.add(new Day((Calendar) calendar.clone(), dayOfWeek));
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    public Week getNextWeek(){
        Calendar newCalendar = (Calendar) days.getLast().getDate().clone();
        newCalendar.add(Calendar.DAY_OF_YEAR, 1);
        return new Week(newCalendar);
    }

    public boolean isWeekInNextMonth(){
        return days.getLast().getDayInMonth() < DAYS_IN_WEEK;
    }

    @Override
    public String toString(){
        String result = "";
        for (Day day:days)
            result += day.toString() + "\t";
        return result;
    }

}
