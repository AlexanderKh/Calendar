package alex.reader;

import alex.calendar.Year;
import org.junit.Test;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TodayReaderTest {

    @Test
    public void getYears() throws Exception {
        List<Year> years = new LinkedList<Year>();
        Calendar calendar = Calendar.getInstance();
        int[] month = {calendar.get(Calendar.MONTH)};
        Year year = new Year(calendar.get(Calendar.YEAR), month);
        years.add(year);

        TodayReader todayReader = new TodayReader();
        List<Year> actualYears = todayReader.getYears();

        assertThat(actualYears, is(years));
    }
}