package alex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InputReader {
    public Date getFirstDayOfMonth(String[] args){
        Date date = new Date();
        try{
            date = parseConsoleInput(args);
        }catch(Exception e){
            System.out.println("Error");
        }
        return date;
    }

    private int parseMonth(String month) throws Exception{
        if (month.matches("\\d+")){
            return Integer.valueOf(month) - 1;
        }
        try{
            return new SimpleDateFormat("MMM").parse(month).getMonth();
        }catch (Exception e){
            System.out.println("Month conversion error");
            return 0;
        }
    }

    private Date parseConsoleInput(String[] input) throws Exception{
        int year, month;
        year = Integer.valueOf(input[CalendarApp.ARGS_NUM_OF_YEAR]);
        month = parseMonth(input[CalendarApp.ARGS_NUM_OF_MONTH]);
        return new Date(year, month, 1);
    }
}
