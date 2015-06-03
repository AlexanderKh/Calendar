package alex.calendar;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DayTest {

    Day day;
    Calendar calendar;

    @Before
    public void setUp() throws Exception {
        calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 01);
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        day = new Day(calendar, dayOfWeek);

    }

    @Test
    public void testGetDayInMonth__return1() throws Exception {
        int actualDayInMonth = day.getDayInMonth();

        assertThat(actualDayInMonth, is(1));
    }

    @Test
    public void testGetCalendar__returnInitialCalendar() throws Exception {
        Calendar actualCalendar = day.getCalendar();

        assertThat(actualCalendar, is(calendar));
    }

    @Test
    public void testGetType__returnMONDAY() throws Exception {
        DayOfWeek actualDayType = day.getType();

        assertThat(actualDayType, is(DayOfWeek.MONDAY));
    }
}