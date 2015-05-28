package alex;

import alex.calendar.MonthCalendar;
import alex.calendar.NavigableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CalendarFileWriter {

    private CalendarFormatHelper helper;
    private File path;

    CalendarFileWriter(File path){
        this.helper = new CalendarFormatHelper();
        this.path = path;
    }

    public void generateFilesForCalendarSet(NavigableList<MonthCalendar> monthCalendars){
        clearPath(path);
        path.mkdir();
        for (int i = 0; i < monthCalendars.size(); i++) {
            String currentMonthHTML = helper.formatMonthCalendarToHTML(monthCalendars, i);
            String currentMonthFilepath = helper.getRelativeFilenameForMonth(monthCalendars.get(i));
            writeMonthToFile(currentMonthFilepath, currentMonthHTML);
        }
    }

    private void writeMonthToFile(String filepath, String representation){
        try {
            File file = new File(path.getAbsolutePath() + File.separator + filepath);
            file.getParentFile().mkdirs();
            file.createNewFile();
            Writer out = new FileWriter(file);
            out.write(representation);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearPath(File path) {
        if (path.isDirectory()){
            for (File subPath : path.listFiles())
                clearPath(subPath);
        }
        path.delete();
    }


}
