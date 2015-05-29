package alex.reader;


import alex.calendar.Year;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TodayReader extends AbstractReader {

    public List<Year> getYears() {
        Calendar calendar = Calendar.getInstance();
        return getListWithOneMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
    }
}
