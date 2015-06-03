package alex.calendar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static com.sun.javafx.fxml.expression.Expression.lessThan;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class YearTest {

    Year year;

    @Before
    public void setUp() throws Exception {
        int[] months = {1, 2, 12};
        year = new Year(2015, months);
    }

    @Test
    public void compareTo__returnNegative() throws Exception {
        Year year2016 = new Year(2016);

        Integer difference = year.compareTo(year2016);

        lessThan(difference, 0);
    }

    @Test
    public void testGetMonthCalendars__returnJAN_FEB_DEC() throws Exception {
        ArrayList<MonthCalendar> monthCalendars = new ArrayList<MonthCalendar>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 01);
        monthCalendars.add(new MonthCalendar(calendar));
        calendar.set(Calendar.MONTH, Calendar.FEBRUARY);
        monthCalendars.add(new MonthCalendar(calendar));
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        monthCalendars.add(new MonthCalendar(calendar));

        ArrayList<MonthCalendar> actualMonthCalendars = (ArrayList<MonthCalendar>) year.getMonthCalendars();

        assertThat(actualMonthCalendars, is(monthCalendars));
    }
}