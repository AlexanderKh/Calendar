package alex.calendar;

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
            days.add(new Day((Calendar) startingDate.clone(), dayOfWeek));
            startingDate.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    private void rewindToSunday(Calendar calendar) {
        int difference = calendar.getActualMinimum(Calendar.DAY_OF_WEEK) - calendar.get(Calendar.DAY_OF_WEEK);
        if (difference >= 0) return;
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

    public LinkedList<Day> getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Week){
            return days.get(0).equals(((Week) o).getDays().get(0));
        } else {
            return false;
        }
    }

}
