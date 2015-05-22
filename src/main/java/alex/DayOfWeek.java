package alex;


import java.util.Calendar;

public enum DayOfWeek {
    SUNDAY("Sun", Calendar.SUNDAY, true),
    MONDAY("Mon", Calendar.MONDAY, false),
    TUESDAY("Tue", Calendar.TUESDAY, false),
    WEDNESDAY("Wed", Calendar.WEDNESDAY, false),
    THURSDAY("Thu", Calendar.THURSDAY, false),
    FRIDAY("Fri", Calendar.FRIDAY, false),
    SATURDAY("Sat", Calendar.SATURDAY, true);

    private final String title;
    private final int id;
    private final boolean weekendDay;

    DayOfWeek(String title, int id, boolean weekendDay){
        this.title = title;
        this.id = id;
        this.weekendDay = weekendDay;
    }
    public String title(){
        return title;
    }
    public int id(){
        return id;
    }
    public boolean weekendDay(){
        return weekendDay;
    }

}
