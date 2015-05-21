package alex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InputReader {
    public Date getFirstDayOfMonth(String[] args){
        Date date = new Date();
        try{
            date = parseConsoleInput(args);
        }catch(Exception e){
            System.out.println("Error");
        }
        return date;
    }

    private int parseMonth(String month) throws Exception{
        if (month.matches("\\d+")){
            return Integer.valueOf(month) - 1;
        }
        else{
            try{
                return new SimpleDateFormat("MMM").parse(month).getMonth();
            }catch (Exception e){
                System.out.println("Month conversion error");
                return 0;
            }

        }
    }

    private Date parseConsoleInput(String[] input) throws Exception{
        int year, month;
        year = Integer.valueOf(input[0]);
        month = parseMonth(input[1]);
        return new Date(year, month, 1);
    }
}
