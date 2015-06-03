package alex.calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class WeekTest {

    Week week;

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 04);
        week = new Week(calendar);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetNextWeek() throws Exception {
        Week nextWeek = week.getNextWeek();
        List<Day> days = nextWeek.getDays();

        int dayOFMonth = 7;
        for(Day day : days){
            Calendar calendar = day.getCalendar();
            int actualYear = calendar.get(Calendar.YEAR);
            assertThat(actualYear, is(2015));
            int actualMonth = calendar.get(Calendar.MONTH);
            assertThat(actualMonth, is(Calendar.JUNE));
            int actualDay = calendar.get(Calendar.DAY_OF_MONTH);
            assertThat(actualDay, is(dayOFMonth));
            dayOFMonth++;
        }
    }

    @Test
    public void testGetCalendarOfLastDay() throws Exception {
        Calendar calendar = week.getCalendarOfLastDay();

        assertThat(calendar.get(Calendar.YEAR), is(2015));
        assertThat(calendar.get(Calendar.MONTH), is(Calendar.JUNE));
        assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(6));
    }

    @Test
    public void testGetDays() throws Exception {
        List<Day> days = week.getDays();
        Calendar calendar = days.get(0).getCalendar();
    }
}