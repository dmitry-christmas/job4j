package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUserEditItemThenTrackerHasEditedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", 123L, ""));
        Input input = new StubInput(new String[]{"2", item.getId(), "replaced name", "replaced description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("replaced name"));
    }
    @Test
    public void whenUserReplaceItemWithWrongIdNothingChanges() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", 123L, ""));
        Input input = new StubInput(new String[]{"2", "123", "replaced name", "replaced description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUserDeletesItemThenTrackerHasNoSuchItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", 123L, ""));
        Item item1 = tracker.add(new Item("test name1", "test description1", 123L, ""));
        Input input = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name1"));
    }
    @Test
    public void whenUserDeletesItemWithWrongIdNothingChanges() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", 123L, ""));
        Input input = new StubInput(new String[]{"3", "123", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
}
