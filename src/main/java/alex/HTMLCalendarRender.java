package alex;

public class HTMLCalendarRender implements CalendarRender {

    public static final String TAB = "\t";
    public static final String NL = "\n";
    public static final String TR = "tr";
    public static final String OPEN_TAG = "<";
    public static final String CLOSE_TAG = ">";
    public static final String BLACK = "BLACK";
    public static final String RED = "RED";
    public static final String TABLE = "table";
    public static final String END_TAG = "</";
    public static final String TD = "td";
    public static final String TH = "th";

    public String render(MonthCalendar monthCalendar) {
        return renderMonth(monthCalendar);
    }

    private String appendTag(String sb, String tag, String contents) {
        sb += "<" + tag + ">";
        sb += contents;
        sb += "</" + tag + ">" + NL;
        return sb;
    }

    private String appendTag(String sb, String tag, String contents, String tagParam) {
        sb += "<" + tag + " " + tagParam + ">";
        sb += contents;
        sb += "</" + tag + ">" + NL;
        return sb;
    }


    private String renderDay(Day day){
        DayOfWeek type = day.getType();
        String tagParam = "style = 'color : " + (type.weekendDay() ? RED : BLACK) + "'";
        String dayInMonth = String.valueOf(day.getDayInMonth());

        return appendTag("", TD, dayInMonth, tagParam);
    }

    private String renderWeek(Week week){
        String result = "";
        for (Day day : week.getDays()) {
            result += renderDay(day) + NL;
        };

        return appendTag("", TR, result);
    }

    private String renderMonth(MonthCalendar month){
        String header = "";
        String weeks = "";
        for (DayOfWeek dayOfWeek : DayOfWeek.values())
            header += renderDayOfWeek(dayOfWeek);

        for (Week week : month.getWeeks())
            weeks += TAB + renderWeek(week) + NL;

        return appendTag("", TABLE, header + weeks, "border = 2");
    }

    private String renderDayOfWeek(DayOfWeek dayOfWeek) {
        String result = OPEN_TAG + TH + " style='color:";
        result += dayOfWeek.weekendDay() ? RED : BLACK;
        result += "'>" + dayOfWeek.title() + END_TAG + TH + CLOSE_TAG;

        return result;
    }
}
