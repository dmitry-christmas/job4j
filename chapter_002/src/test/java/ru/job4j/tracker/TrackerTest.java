package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 0, "");
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 0, "");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 0,  "");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenArrayOf5() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 0, "");
        Item item2 = new Item("test2", "testDescription", 0, "");
        Item item3 = new Item("test3", "testDescription", 0, "");
        Item item4 = new Item("test4", "testDescription", 0, "");
        Item item5 = new Item("test5", "testDescription", 0, "");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        Item[] rst = tracker.findAll();
        assertThat(rst.length, is(5));
    }
    @Test
    public void whendeleteItem4InArrayOf5ItemsThenArrayOf4Items() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 0, "");
        Item item2 = new Item("test2", "testDescription", 0, "");
        Item item3 = new Item("test3", "testDescription", 0, "");
        Item item4 = new Item("test4", "testDescription", 0, "");
        Item item5 = new Item("test5", "testDescription", 0, "");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.delete(item4.getId());
        boolean result = false;
        Item[] rst = tracker.findAll();
        if (rst[0].getName().equals("test1") && rst[1].getName().equals("test2") && rst[2].getName().equals("test3") && rst[3].getName().equals("test5")) {
            result = true;
        }
        assertThat(result, is(true));
    }
    @Test
    public void whenSearchByNameTest4IsItem4() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 0, "");
        Item item2 = new Item("test2", "testDescription", 0, "");
        Item item3 = new Item("test3", "testDescription", 0, "");
        Item item4 = new Item("test4", "testDescription", 0, "");
        Item item5 = new Item("test5", "testDescription", 0, "");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.findByName("test4");
        Item[] result = {item4};
        assertThat(tracker.findByName("test4"), is(result));
    }
}
