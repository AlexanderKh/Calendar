package alex;

import java.util.Calendar;
import java.util.LinkedList;

public class MonthCalendar {
    private LinkedList<Week> weeks;

    MonthCalendar(Calendar startingDate){
        weeks = new LinkedList<Week>();
        Week week = new Week(startingDate);
        weeks.add(week);
        do {
            week = week.getNextWeek();
            weeks.add(week);
        } while (week.inCurrentMonth());
    }

    @Override
    public String toString(){
        String result = "";
        for (DayOfWeek dayOfWeek: DayOfWeek.values()){
            result += dayOfWeek.title() + "\t";
        }
        for(Week week:weeks){
            result += "\n" + week.toString();
        }
        return result;
    }
}
