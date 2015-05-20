package alex;

import java.util.Date;

public class Day {
    private DayOfWeek type;
    private Date date;
    private Week week;

    Day(Date date, DayOfWeek type){
        this.date = date;
        this.type = type;
    }

    public int getDay(){
        return date.getDate();
    }

    public Date getDate(){
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
        result += date.getDate();
        System.out.println(date);
        return result;
    }

}
