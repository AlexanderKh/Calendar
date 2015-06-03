package alex.calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DayOfWeekTest {


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testTitle__returnsMon() throws Exception {
        String title = DayOfWeek.MONDAY.title();
        assertThat(title, is("Mon"));
    }

    @Test
    public void testId__returnsCalendar_MONDAY() throws Exception {
        int id = DayOfWeek.MONDAY.id();
        assertThat(id, is(Calendar.MONDAY));
    }

    @Test
    public void testWeekendDay__ReturnsFalse() throws Exception {
        boolean weekendDay = DayOfWeek.MONDAY.weekendDay();
        assertThat(weekendDay, is(false));

    }
}