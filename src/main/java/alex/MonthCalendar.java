package alex;

import java.util.Calendar;
import java.util.LinkedList;

public class MonthCalendar {
    private LinkedList<Week> weeks;
    private int monthToShow;

    MonthCalendar(Calendar startingDate){
        monthToShow = startingDate.get(Calendar.MONTH);
        weeks = new LinkedList<Week>();
        Week week = new Week(startingDate);
        weeks.add(week);
        while (week.getMonthOfLastDay() <=  monthToShow) {
            week = week.getNextWeek();
            weeks.add(week);}

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
