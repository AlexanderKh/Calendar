package alex.reader;

import alex.InputReader;

import java.text.SimpleDateFormat;

public abstract class AbstractCalendarReader implements InputReader{

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
}