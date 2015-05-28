package alex;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Run {

    public static void main(String[] args){
        BeanFactory beanFactory = new FileSystemXmlApplicationContext("/src/main/java/spring-config.xml");
        CalendarApp calendarApp = (CalendarApp) beanFactory.getBean("calendarApp");
        calendarApp.execute();

    }
}
