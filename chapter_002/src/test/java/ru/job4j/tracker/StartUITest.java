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
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutPut() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenWrongMenuSelectThenRepeat() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"b", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(makeMenu())));
    }
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUserEditItemThenTrackerHasEditedItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[]{"2", item.getId(), "replaced name", "replaced description", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("replaced name"));
    }
    @Test
    public void whenUserReplaceItemWithWrongIdNothingChanges() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[]{"2", "123", "replaced name", "replaced description", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUserDeletesItemThenTrackerHasNoSuchItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Item item1 = tracker.add(new Item("test name1", "test description1", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[] {"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name1"));
    }
    @Test
    public void whenUserDeletesItemWithWrongIdNothingChanges() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[]{"3", "123", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    @Test
    public void whenUserChoseGetAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[] {"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                .append(makeMenu())
                //.append("Введите пункт меню :1\r\n")
                .append("------------ Список имеющихся заявок --------------")
                .append(System.lineSeparator())
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
                .append("------------ Выход из программы --------------")
                .append(System.lineSeparator())
                .toString()
                ));
    }
    @Test
    public void whenUserFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[] {"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(makeMenu())
                        .append("------------ Поиск заявки --------------")
                        .append(System.lineSeparator())
                        .append("Искомая заявка найдена!")
                        .append(System.lineSeparator())
                        .append("id: ")
                        .append(item.getId())
                        .append(", имя: ")
                        .append("test name")
                        .append(", описание: ")
                        .append("test description")
                        .append(", дата создания: ")
                        .append(DateFormat.getDateTimeInstance().format(item.getCreated()))
                        .append(System.lineSeparator())
                        .append("------------ Выход из программы --------------")
                        .append(System.lineSeparator())
                        .toString()
        ));
    }
    @Test
    public void whenUserFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test description", System.currentTimeMillis(), ""));
        Item item1 = tracker.add(new Item("test name1", "test description1", System.currentTimeMillis(), ""));
        Input input = new StubInput(new String[] {"5", "test name1", "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                new StringBuilder()
                        .append(makeMenu())
                        .append("------------ Поиск заявки по имени --------------")
                        .append(System.lineSeparator())
                        .append("По вашему запросу: test name1 найдены следующие заявки:")
                        .append(System.lineSeparator())
                        .append("id: ")
                        .append(item1.getId())
                        .append(", имя: ")
                        .append("test name1")
                        .append(", описание: ")
                        .append("test description1")
                        .append(", дата создания: ")
                        .append(DateFormat.getDateTimeInstance().format(item1.getCreated()))
                        .append(System.lineSeparator())
                        .append("------------ Выход из программы --------------")
                        .append(System.lineSeparator())
                        .toString()
        ));
    }
    private String makeMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Меню.");
        menu.append(System.lineSeparator());
        menu.append("0. Добавить новую заявку.");
        menu.append(System.lineSeparator());
        menu.append("1. Показать все заявки.");
        menu.append(System.lineSeparator());
        menu.append("2. Редактировать заявку.");
        menu.append(System.lineSeparator());
        menu.append("3. Удалить заявку.");
        menu.append(System.lineSeparator());
        menu.append("4. Поиск заявки по id.");
        menu.append(System.lineSeparator());
        menu.append("5. Поиск заявки по имени.");
        menu.append(System.lineSeparator());
        menu.append("6. Выход из программы.");
        menu.append(System.lineSeparator());
        return menu.toString();
    }
}
