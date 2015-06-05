package alex.reader;

import alex.calendar.Year;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReader extends AbstractReader {
    public static final int YEAR_TAG_POS = 0;

    static File input = new File("/home/employee/Documents/input.txt");

    public List<Year> getYears() {
        List<Year> result = new ArrayList<Year>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String yearRow;
        while (scanner.hasNextLine()){
            yearRow = scanner.nextLine();
            result.add(getYearFromRow(yearRow));
        }
        Collections.sort(result);

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


}
