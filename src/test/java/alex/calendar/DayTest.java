package alex.calendar;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class DayTest {

    @Test
    public void testGetDayInMonth() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 01);
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

        Day day = new Day(calendar, dayOfWeek);

        assert day.getDayInMonth() == 1;
    }

    @Test
    public void testGetCalendar() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 01);
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

        Day day = new Day(calendar, dayOfWeek);

        assert day.getCalendar().equals(calendar);
    }

    @Test
    public void testGetType() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 01);
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

        Day day = new Day(calendar, dayOfWeek);

        assert day.getType().equals(DayOfWeek.MONDAY);
    }
}