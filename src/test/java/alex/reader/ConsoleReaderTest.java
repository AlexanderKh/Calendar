package alex.reader;

import alex.calendar.Year;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConsoleReaderTest {

    @Test
    public void getYears() throws Exception {
        int[] months = {Calendar.JUNE};
        Year year = new Year(2015, months);
        List<Year> years = new LinkedList<Year>();
        years.add(year);

        ConsoleReader reader = new ConsoleReader();
        String input = "2015\n06\n";
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        List<Year> actualYears = reader.getYears();

        assertThat(actualYears, is(years));
    }
}