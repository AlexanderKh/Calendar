package alex;

import java.util.Calendar;
import java.util.LinkedList;

public class MonthCalendar {
    private LinkedList<Week> weeks;
    private Calendar monthToShow;

    MonthCalendar(Calendar startingDate){
        monthToShow = (Calendar)startingDate.clone();
        weeks = new LinkedList<Week>();
        Week week = new Week(startingDate);
        weeks.add(week);
        while (isCurrentOrPreviousMonth(week.getCalendarOfLastDay(), monthToShow.get(Calendar.MONTH))) {
            week = week.getNextWeek();
            weeks.add(week);
        }
    }

    private boolean isCurrentOrPreviousMonth(Calendar calendar, int month){
        int calendarMonth = calendar.get(Calendar.MONTH);
        boolean result = false;
        result = result || (month == calendarMonth);
        result = result || (month - 1 == calendarMonth);
        result = result || (month == 0 && calendarMonth == 11);
        return result;
    }

    @Override
    public String toString(){
        String result = "";
        for (DayOfWeek dayOfWeek: DayOfWeek.values()){
            result += dayOfWeek + "\t";
        }
        for(Week week:weeks){
            result += "\n" + week.toString();
        }
        return result;
    }
}
