package alex.reader;

import alex.InputReader;
import alex.calendar.Year;

import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleReader extends AbstractCalendarReader {

    public List<Year> getYears() {
        List<Year> result = new ArrayList<Year>();
        int year, month;
        Scanner in = new Scanner(System.in);
        System.out.print("Input Year: ");
        year = Integer.valueOf(in.next());
        System.out.print("Input Month: ");
        month = parseMonth(in.next());
        in.close();
        int[] months = new int[1];
        months[0] = month;
        result.add(new Year(year, months));
        return result;
    }

}
