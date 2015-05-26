package alex;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InputReader {


    public static final int YEAR_TAG_POS = 0;
    public static final int MONTH_MIN = 0;
    public static final int MONTH_MAX = 12;

    public CalendarSet<Calendar> getFirstDatesFromFile(File file) throws FileNotFoundException {
        CalendarSet<Calendar> result = new CalendarSet<Calendar>();
        Scanner scanner = new Scanner(file);
        String yearRow;
        while (scanner.hasNextLine()){
            yearRow = scanner.nextLine();
            result.addAll(parseAndGetDatesFromYearRow(yearRow));
        }
        return result;
    }

    private CalendarSet<Calendar> parseAndGetDatesFromYearRow(String yearRow){
        CalendarSet<Calendar> result;
        String[] yearData = yearRow.split(" ");
        int year = Integer.valueOf(yearData[YEAR_TAG_POS]);
        if (yearData.length == 1){
            result = generateDatesForEntireYear(year);
        } else {
            result = generateDatesForMonths(yearData, year);
        }
        return result;
    }

    private CalendarSet<Calendar> generateDatesForMonths(String[] yearData, int year) {
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

    private CalendarSet<Calendar> generateDatesForEntireYear(int year) {
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
            System.out.println("Month conversion error");
            return 0;
        }
    }
}
