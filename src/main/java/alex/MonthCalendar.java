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
        do {
            weeks.add(weeks.getLast().getNextWeek());
        } while ((!weeks.getLast().isWeekInNextMonth()));
    }

    @Override
    public String toString(){
        String result = "";
        System.out.println(weeks.size());
        for(Week week:weeks){
            result += week.toString() + "\n\n";
        }
        return result;
    }
}
