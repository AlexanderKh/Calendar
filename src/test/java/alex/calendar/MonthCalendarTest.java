package alex.calendar;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MonthCalendarTest {

    MonthCalendar monthCalendar;

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 01);
        monthCalendar = new MonthCalendar(calendar);
    }

    @Test
    public void getMonthTitle() throws Exception {
        String monthTitle = "June";

        String actualMonthTitle = monthCalendar.getMonthTitle();

        assertThat(actualMonthTitle, is(monthTitle));
    }

    @Test
    public void getMonthNumber() throws Exception {
        int actualMonthNumber = monthCalendar.getMonthNumber();

        assertThat(actualMonthNumber, is(6));
    }

    @Test
    public void getYear() throws Exception {
        String year = "2015";

        String actualYear = monthCalendar.getYear();

        assertThat(actualYear, is(year));
    }

    @Test
    public void getWeeks() throws Exception {
        LinkedList<Week> weeks = new LinkedList<Week>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 1);
        weeks.add(new Week(calendar));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        weeks.add(new Week(calendar));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        weeks.add(new Week(calendar));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        weeks.add(new Week(calendar));
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        weeks.add(new Week(calendar));

        LinkedList<Week> actualWeeks = monthCalendar.getWeeks();

        assertThat(actualWeeks, is(weeks));
    }
}