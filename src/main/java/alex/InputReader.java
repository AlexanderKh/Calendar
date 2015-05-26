package alex;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InputReader {


    public static final int YEAR_TAG_POS = 0;
    public static final int MONTH_MIN = 0;
    public static final int MONTH_MAX = 12;
    public static final String MONTH_CONVERSION_ERROR = "Month conversion error";

    public CalendarSet<Calendar> getFirstDatesFromFile(File file) throws FileNotFoundException {
        CalendarSet<Calendar> result = new CalendarSet<Calendar>();
        Scanner scanner = new Scanner(file);
        String yearRow;
        while (scanner.hasNextLine()){
            yearRow = scanner.nextLine();
            result.addAll(parseAndGetCalendarsFromYearRow(yearRow));
        }
        return result;
    }

    private CalendarSet<Calendar> parseAndGetCalendarsFromYearRow(String yearRow){
        CalendarSet<Calendar> result;
        String[] yearData = yearRow.split(" ");
        int year = Integer.valueOf(yearData[YEAR_TAG_POS]);
        if (yearData.length == 1){
            result = generateCalendarsForEntireYear(year);
        } else {
            result = generateCalendarsForMonths(yearData, year);
        }
        return result;
    }

    private CalendarSet<Calendar> generateCalendarsForMonths(String[] yearData, int year) {
        CalendarSet<Calendar> result = new CalendarSet<Calendar>();
        int month;
        for (int i = 1; i < yearData.length; i++){
            Calendar calendar = Calendar.getInstance();
            month = parseMonth(yearData[i]);
            calendar.set(year, month, 1);
            result.add(calendar);
        }
        return result;
    }

    private CalendarSet<Calendar> generateCalendarsForEntireYear(int year) {
        CalendarSet<Calendar> result = new CalendarSet<Calendar>();
        for (int month = MONTH_MIN; month < MONTH_MAX; month++){
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, 1);
            result.add(calendar);
        }
        return result;
    }

    private int parseMonth(String month){
        if (month.matches("\\d+")){
            return Integer.valueOf(month) - 1;
        }
        try{
            return new SimpleDateFormat("MMM").parse(month).getMonth();
        }catch (Exception e){
            System.out.println(MONTH_CONVERSION_ERROR);
            return 0;
        }
    }
}
