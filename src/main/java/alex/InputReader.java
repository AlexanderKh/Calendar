package alex;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InputReader {


    public static final int YEAR_TAG_POS = 0;
    public static final int MONTH_MIN = 0;
    public static final int MONTH_MAX = 12;

    public List<Date> getFirstDatesFromFile(File file) throws FileNotFoundException {
        List<Date> result = new ArrayList<Date>();
        Scanner scanner = new Scanner(file);
        String yearRow;
        while (scanner.hasNextLine()){
            yearRow = scanner.nextLine();
            result.addAll(parseAndGetDatesFromYearRow(yearRow));
        }
        return result;
    }

    public  List<Date> parseAndGetDatesFromYearRow(String yearRow){
        List<Date> result;
        String[] yearData = yearRow.split(" ");
        int year = Integer.valueOf(yearData[YEAR_TAG_POS]);
        if (yearData.length == 1){
            result = generateDatesForEntireYear(year);
        } else {
            result = generateDatesForMonths(yearData, year);
        }
        return result;
    }

    private List<Date> generateDatesForMonths(String[] yearData, int year) {
        List<Date> result;
        result = new ArrayList<Date>();
        int month;
        for (int i = 1; i < yearData.length; i++){
            month = parseMonth(yearData[i]);
            result.add(new Date(year, month, 1));
        }
        return result;
    }

    private List<Date> generateDatesForEntireYear(int year) {
        List<Date> result = new ArrayList<Date>();
        for (int month = MONTH_MIN; month < MONTH_MAX; month++){
            result.add(new Date(year, month, 1));
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
