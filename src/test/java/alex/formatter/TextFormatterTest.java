package alex.formatter;

import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class TextFormatterTest {

    @Test
    public void testRender() throws Exception {
        TextFormatter formatter = new TextFormatter();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JUNE, 01);
        MonthCalendar monthCalendar = new MonthCalendar(calendar);
        NavigableList<MonthCalendar> list = new NavigableList<MonthCalendar>();
        list.add(monthCalendar);

        String out = formatter.render(list, 0);

        assert out.contains("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        assert out.contains("31\t1\t2\t3\t4\t5\t6\t\n" +
                            "7\t8\t9\t10\t11\t12\t13\t\n" +
                            "14\t15\t16\t17\t18\t19\t20\t\n" +
                            "21\t22\t23\t24\t25\t26\t27\t\n" +
                            "28\t29\t30\t1\t2\t3\t4\t");
    }
}