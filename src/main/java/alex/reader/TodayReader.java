package alex.reader;


import alex.InputReader;
import alex.calendar.Year;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TodayReader implements InputReader{

    public List<Year> getYears() {
        Calendar calendar = Calendar.getInstance();
        int[] month = new int[1];
        month[0] = calendar.get(Calendar.MONTH);
        Year year = new Year(calendar.get(Calendar.YEAR), month);
        List<Year> result = new ArrayList<Year>();
        result.add(year);

        return result;
    }
}
