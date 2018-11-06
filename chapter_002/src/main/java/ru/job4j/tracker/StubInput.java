package ru.job4j.tracker;

public class StubInput implements Input {
    private final String[] value;
    private int position = 0;
    public StubInput(final String[] value) {
        this.value = value;
    }
    public String ask(String question) {
        return this.value[this.position++];
    }
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int result = -1;
        do{
            try {
                result = verify(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректное значение меню.");
            } catch (MenuOutException moe) {
                System.out.println("Выберите правильное значение из меню.");
            }
        } while (invalid);
        return result;
    }
    public int verify(String question, int[] range) {
        return Integer.parseInt(this.value[position++]);
    }
}
