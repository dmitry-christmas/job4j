package ru.job4j.singletone;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
public class TrackerTest {
    @Test
    public void whenEnumTheSameObject() {
        Tracker1 tracker1 = Tracker1.INSTANCE;
        Tracker1 tracker2 = Tracker1.INSTANCE;
        tracker1.setObjectNumber(1);
        assertThat(tracker2.getObjectNumber(), is(1));
        }
    @Test
    public void whenLazyOnlyOneObjectCreated() {
        Tracker2 tracker1 = Tracker2.getInstance();
        Tracker2 tracker2 = Tracker2.getInstance();
        tracker1.setObjectNumber(1);
        assertThat(tracker2.getObjectNumber(), is(1));
    }
    @Test
    public void whenEagerThenOneObjectCreating() {
        Tracker3 tracker1 = Tracker3.getInstance();
        Tracker3 tracker2 = Tracker3.getInstance();
        tracker1.setObjectNumber(1);
        assertThat(tracker2.getObjectNumber(), is(1));
    }
    @Test
    public void innerClasscreatesOnlyOneObject() {
        Tracker4 tracker1 = Tracker4.getInstance();
        Tracker4 tracker2 = Tracker4.getInstance();
        tracker1.setObjectNumber(1);
        assertThat(tracker2.getObjectNumber(), is(1));
    }
}
