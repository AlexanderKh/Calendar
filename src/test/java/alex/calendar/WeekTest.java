package alex.calendar;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WeekTest {

    Week week;

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 04);
        week = new Week(calendar);

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
        List<Day> actualDays = week.getDays();

        int dayOFMonth = 31;
        for(Day day : actualDays){
            Calendar calendar = day.getCalendar();
            int actualYear = calendar.get(Calendar.YEAR);
            assertThat(actualYear, is(2015));
            int actualMonth = calendar.get(Calendar.MONTH);
            assertThat(actualMonth, is((dayOFMonth == 31) ? Calendar.MAY : Calendar.JUNE));
            int actualDay = calendar.get(Calendar.DAY_OF_MONTH);
            assertThat(actualDay, is(dayOFMonth));
            if (dayOFMonth >= 31){
                dayOFMonth = 1;
            }else {
                dayOFMonth++;
            }
        }
    }
}