package alex;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Locale;

public class MonthCalendar {
    private LinkedList<Week> weeks;
    private Calendar dateToShow;

    MonthCalendar(Calendar startingDate){
        dateToShow = (Calendar)startingDate.clone();
        dateToShow.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        weeks = new LinkedList<Week>();
        Week week = new Week(startingDate);
        weeks.add(week);
        while (writeNextWeek(week)) {
            week = week.getNextWeek();
            weeks.add(week);
        }
    }

    private boolean writeNextWeek(Week week){
        return isCurrentOrPreviousMonth(week.getCalendarOfLastDay()) && !lastDayOfCurrentMonth(week.getCalendarOfLastDay());
    }

    private boolean isCurrentOrPreviousMonth(Calendar calendar){
        int month = dateToShow.get(Calendar.MONTH);
        int calendarMonth = calendar.get(Calendar.MONTH);
        boolean result = false;
        result = result || (month == calendarMonth);
        result = result || (month - 1 == calendarMonth);
        result = result || (month == 0 && calendarMonth == 11);
        return result;
    }

    private boolean lastDayOfCurrentMonth(Calendar calendar){
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public String getMonthTitle(){
        return dateToShow.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    }

    public String getYear(){
        return String.valueOf(dateToShow.get(Calendar.YEAR));
    }

    public LinkedList<Week> getWeeks() {
        return weeks;
    }
}
