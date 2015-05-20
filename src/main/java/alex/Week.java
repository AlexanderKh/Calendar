package alex;

import java.util.Calendar;
import java.util.LinkedList;

public class Week {
    private static final int DAYS_IN_WEEK = 7;
    private LinkedList<Day> days;

    Week(Calendar startingDate){
        days = new LinkedList<Day>();
        rewindToSunday(startingDate);
        fillDaysList(startingDate);
    }

    private void fillDaysList(Calendar startingDate) {
        for (DayOfWeek dayOfWeek: DayOfWeek.values()){
            startingDate.add(Calendar.DAY_OF_YEAR, 1);
            days.add(new Day((Calendar) startingDate.clone(), dayOfWeek));
        }
    }

    private void rewindToSunday(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) > calendar.getActualMinimum(Calendar.DAY_OF_WEEK)){
            calendar.add(Calendar.DAY_OF_YEAR, -1);
        }
    }

    public Week getNextWeek(){
        Day lastDayInCurrentWeek = days.getLast();
        Calendar nextWeekStartingDate = (Calendar) lastDayInCurrentWeek.getDate().clone();
        nextWeekStartingDate.add(Calendar.DAY_OF_YEAR, 1);
        return new Week(nextWeekStartingDate);
    }

    public boolean inCurrentMonth(){
        return !(days.getLast().getDayInMonth() < DAYS_IN_WEEK);
    }

    @Override
    public String toString(){
        String result = "";
        for (Day day:days) {
            result += day.toString() + "\t";
        }
        return result;
    }

}
