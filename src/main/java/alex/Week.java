package alex;

import java.util.Calendar;
import java.util.LinkedList;

public class Week {
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
        int difference = calendar.getActualMinimum(Calendar.DAY_OF_WEEK) - calendar.get(Calendar.DAY_OF_WEEK);
        if (difference != 0)
            calendar.add(Calendar.DAY_OF_YEAR, difference);
    }

    public Week getNextWeek() {
        Day lastDayInCurrentWeek = days.getLast();
        Calendar nextWeekStartingDate = (Calendar) lastDayInCurrentWeek.getCalendar().clone();
        nextWeekStartingDate.add(Calendar.DAY_OF_YEAR, 1);
        return new Week(nextWeekStartingDate);
    }

    public Calendar getCalendarOfLastDay(){
        return days.getLast().getCalendar();
    }

    public String toHTML(){
        String result = "<tr>\n\t";
        for (Day day:days) {
            result += day.toHTML() + "\n\t";
        }
        result += "</tr>\n";
        return result;
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
