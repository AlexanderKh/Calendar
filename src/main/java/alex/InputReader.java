package alex;

import java.util.Date;
import java.util.Scanner;

public class InputReader {
    public Date getFirstDayOfMonth(String[] args){
        Date date = new Date();
        try{
            if (args.length == 0)
                date = interactiveInput();
            else
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
            String uppercaseMonth = month.toUpperCase();
            if (uppercaseMonth.equals("JAN") || uppercaseMonth.equals("JANUARY"))
                return 0;
            if (uppercaseMonth.equals("FEB") || uppercaseMonth.equals("FEBRUARY"))
                return 1;
            if (uppercaseMonth.equals("MAR") || uppercaseMonth.equals("MARCH"))
                return 2;
            if (uppercaseMonth.equals("APR") || uppercaseMonth.equals("APRIL"))
                return 3;
            if (uppercaseMonth.equals("MAY"))
                return 4;
            if (uppercaseMonth.equals("JUN") || uppercaseMonth.equals("JUNE"))
                return 5;
            if (uppercaseMonth.equals("JUL") || uppercaseMonth.equals("JULY"))
                return 6;
            if (uppercaseMonth.equals("AUG") || uppercaseMonth.equals("AUGUST"))
                return 7;
            if (uppercaseMonth.equals("SEP") || uppercaseMonth.equals("SEPTEMBER"))
                return 8;
            if (uppercaseMonth.equals("OCT") || uppercaseMonth.equals("OCTOBER"))
                return 9;
            if (uppercaseMonth.equals("NOV") || uppercaseMonth.equals("NOVEMBER"))
                return 10;
            if (uppercaseMonth.equals("DEC") || uppercaseMonth.equals("DECEMBER"))
                return 11;
        }
        throw new Exception("Month conversion error");
    }

    private Date interactiveInput() throws Exception{
        int year, month;
        Scanner in = new Scanner(System.in);
        System.out.print("Input Year: ");
        year = Integer.valueOf(in.next());
        System.out.print("Input Month: ");
        month = parseMonth(in.next());
        in.close();
        return new Date(year, month, 1);
    }

    private Date parseConsoleInput(String[] input) throws Exception{
        int year, month;
        year = Integer.valueOf(input[0]);
        month = parseMonth(input[1]);
        return new Date(year, month, 1);
    }
}
