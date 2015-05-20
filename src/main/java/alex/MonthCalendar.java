package alex;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MonthCalendar {
    private Date startingDate;
    private LinkedList<Week> weeks;

    MonthCalendar(Date firstDayOfMonth){
        startingDate = firstDayOfMonth;
        weeks = new LinkedList<Week>();
        weeks.add(new Week(startingDate));
        while (!weeks.getLast().isWeekInNextMonth()){
            weeks.add(weeks.getLast().getNextWeek());
        }
    }

    @Override
    public String toString(){
        String result = "";
        for(Week week:weeks){
            result += week.toString() + "\n\n";
        }
        return result;
    }
}
