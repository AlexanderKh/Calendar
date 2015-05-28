package alex;

import java.util.*;

public class Year implements Comparable {
    private static final int MONTH_MAX = 12;
    private static final int[] FULL_YEAR = new int[12];
    private int year;
    private int[] monthNumbers;

    static {
        for (int month = 0; month < MONTH_MAX; month++) {
            FULL_YEAR[month] = month;
        }
    }

    public Year(int year){
        this(year, FULL_YEAR);
    }

    public Year(int year, int[] monthNumbers) {
        this.year = year;
        this.monthNumbers = monthNumbers;
        Arrays.sort(this.monthNumbers);
    }

    public int compareTo(Object o) {
        return Integer.compare(this.year, (((Year) o).year));
    }

    private MonthCalendar createMonthCalendar(int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        return new MonthCalendar(calendar);
    }


    public Collection<? extends MonthCalendar> getMonthCalendars() {
        List<MonthCalendar> monthCalendars = new ArrayList<MonthCalendar>();
        for (int monthNumber : monthNumbers){
            monthCalendars.add(createMonthCalendar(monthNumber));
        }
        return monthCalendars;
    }
}
