package alex;

import java.util.Calendar;

public class Day {
    private DayOfWeek type;
    private Calendar date;

    Day(Calendar date, DayOfWeek type){
        this.date = date;
        this.type = type;
    }

    public int getDayInMonth(){
        return date.get(Calendar.DAY_OF_MONTH);
    }

    public Calendar getDate(){
        return date;
    }

    @Override
    public String toString(){
        String result;
        if (type.weekendDay()){
            result = "\u001B[31m";
        }else {
            result = "\u001B[0m";
        }
        result += getDayInMonth();
        return result;
    }

}
