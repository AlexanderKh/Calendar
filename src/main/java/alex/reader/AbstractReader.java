package alex.reader;

import alex.CalendarReader;
import alex.calendar.Year;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractReader implements CalendarReader {

    private static final String MONTH_CONVERSION_ERROR = "Month conversion error";

    protected int parseMonth(String month){
        if (month.matches("\\d+")){
            return Integer.valueOf(month) - 1;
        }
        try{
            return new SimpleDateFormat("MMM").parse(month).getMonth();
        }catch (Exception e){
            System.out.println(MONTH_CONVERSION_ERROR);
            return 0;
        }
    }

    protected List<Year> getListWithOneMonth(int year, int month){
        List<Year> result = new ArrayList<Year>();
        int[] months = new int[1];
        months[0] = month;
        result.add(new Year(year, months));

        return result;
    }
}