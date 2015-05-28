package alex.reader;

import alex.Year;

import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleReader implements InputReader {

    public static final String MONTH_CONVERSION_ERROR = "Month conversion error";

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
