package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private String menu =  "Меню.\r\n0. Add new Item.\r\n1. Show all items.\r\n2. Edit item.\r\n3. Delete item.\r\n4. Find item by Id.\r\n5. Find items by name.\r\n6. Exit Program.\r\n";
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutPut() {
        System.setOut(this.stdout);
    }
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
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[]{"2", item.getId(), "replaced name", "replaced description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("replaced name"));
    }
    @Test
    public void whenUserReplaceItemWithWrongIdNothingChanges() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[]{"2", "123", "replaced name", "replaced description", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUserDeletesItemThenTrackerHasNoSuchItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Item item1 = tracker.add(new Item("test name1", "test description1", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name1"));
    }
    @Test
    public void whenUserDeletesItemWithWrongIdNothingChanges() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[]{"3", "123", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUserChoseGetAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                .append(menu)
                //.append("Введите пункт меню :1\r\n")
                .append("Список имеющихся заявок:\r\n")
                .append("id: ")
                .append(item.getId())
                //.append(System.lineSeparator())
                .append(", имя: ")
                .append("test name")
                .append(", описание: ")
                .append("test description")
                .append(", дата создания: ")
                .append(DateFormat.getDateTimeInstance().format(item.getCreated()))
                .append(System.lineSeparator())
                .append(menu)
                .toString()
                ));
    }
    @Test
    public void whenUserFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        //.append("Введите пункт меню :1\r\n")
                        .append("Искомая заявка найдена!\r\n")
                        .append("id: ")
                        .append(item.getId())
                        //.append(System.lineSeparator())
                        .append(", имя: ")
                        .append("test name")
                        .append(", описание: ")
                        .append("test description")
                        .append(", дата создания: ")
                        .append(DateFormat.getDateTimeInstance().format(item.getCreated()))
                        .append(System.lineSeparator())
                        .append(menu)
                        .toString()
        ));
    }
    @Test
    public void whenUserFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Item item1 = tracker.add(new Item("test name1", "test description1", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[] {"5", "test name1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(menu)
                        .append("------------ Поиск заявки по имени --------------\r\n")
                        .append("По вашему запросу: test name1 найдены следующие заявки:\r\n")
                        .append("id: ")
                        .append(item1.getId())
                        //.append(System.lineSeparator())
                        .append(", имя: ")
                        .append("test name1")
                        .append(", описание: ")
                        .append("test description1")
                        .append(", дата создания: ")
                        .append(DateFormat.getDateTimeInstance().format(item1.getCreated()))
                        .append(System.lineSeparator())
                        .append(menu)
                        .toString()
        ));
    }
}
