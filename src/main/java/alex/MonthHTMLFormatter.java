package alex;

public class MonthHTMLFormatter implements MonthFormatter {

    public String getFormattedDay(Day day){
        DayOfWeek type = day.getType();
        String result = "\t<td style='color:";
        result += type.weekendDay() ? "RED" : "BLACK";
        result += "'>" + day.getDayInMonth() + "</td>";

        return result;
    }

    public String getFormattedWeek(Week week){
        String result = "<tr>\n\t";
        for (Day day : week.getDays()) {
            result += day + "\n\t";
        }
        result += "</tr>\n";

        return result;
    }

    public String getFormattedMonth(MonthCalendar month){
        String result = "";
        result += "<table border=2>\n";
        result += "\t<tr>\n";
        for (DayOfWeek dayOfWeek : DayOfWeek.values())
            result += "\t\t" + dayOfWeek + "\n";
        result += "\t</tr>\n\n";
        for (Week week : month.getWeeks())
            result += "\t" + week + "\n";
        result += "</table>";

        return result;
    }

    public String getFormattedDayOfWeek(DayOfWeek dayOfWeek) {
        String result = "<th style='color:";
        result += dayOfWeek.weekendDay() ? "RED" : "BLACK";
        result += "'>" + dayOfWeek.title() + "</th>";

        return result;
    }
}
