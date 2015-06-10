package alex.reader;

import alex.calendar.Year;

import java.util.Calendar;
import java.util.List;

public class StringParamReader extends AbstractReader {
    String year;
    String month;

    public StringParamReader(){}

    public StringParamReader(String year, String month){
        this.year = year;
        this.month = month;
    }

    public List<Year> getYears() {
        try{
            int yearNum = Integer.valueOf(year);
            int monthNum = Integer.valueOf(month);
            return getListWithOneMonth(yearNum, monthNum);
        } catch (Exception e){
            Calendar calendar = Calendar.getInstance();
            return getListWithOneMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
        }
    }
}
