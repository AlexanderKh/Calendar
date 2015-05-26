package alex;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class InputReader {


    public static final int YEAR_TAG_POS = 0;


    public static final String MONTH_CONVERSION_ERROR = "Month conversion error";

    public List<Year> readYears(File file) throws FileNotFoundException {
        List<Year> result = new ArrayList<Year>();
        Scanner scanner = new Scanner(file);
        String yearRow;
        while (scanner.hasNextLine()){
            yearRow = scanner.nextLine();
            result.add(getYearFromRow(yearRow));
        }
        return result;
    }

    private Year getYearFromRow(String yearRow){
        String[] yearData = yearRow.split(" ");
        int year = Integer.valueOf(yearData[YEAR_TAG_POS]);
        if (yearData.length == 1){
            return new Year(year);
        } else {
            int[] months = new int[yearData.length - 1];
            for (int i = 1; i < yearData.length; i++) {
                months[i - 1] = parseMonth(yearData[i]);
            }
            return new Year(year, months);
        }
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
