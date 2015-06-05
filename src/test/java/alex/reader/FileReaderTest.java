package alex.reader;

import alex.calendar.Year;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FileReaderTest {

    @Test
    public void getYears() throws Exception {
        File file = FileReader.input;
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("2015");
        writer.close();
        List<Year> years = new LinkedList<Year>();
        Year year = new Year(2015);
        years.add(year);

        FileReader fileReader = new FileReader();
        List<Year> actualYears = fileReader.getYears();

        assertThat(actualYears, is(years));

    }
}