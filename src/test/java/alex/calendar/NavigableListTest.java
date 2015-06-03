package alex.calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class NavigableListTest {

    NavigableList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list =  new NavigableList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
    }

    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void getPreviousFor() throws Exception {
        assertThat(list.getPreviousFor(0), is(nullValue()));
        assertThat(list.getPreviousFor(1), is(0));
    }

    @Test
    public void getNextFor() throws Exception {
        assertThat(list.getNextFor(2), is(nullValue()));
        assertThat(list.getNextFor(1), is(2));
    }
}