package ru.job4j.tracker;

public class StubInput implements Input {
    private final String[] value;
    private int position = 0;
    boolean invalid = true;
    public StubInput(final String[] value) {
        this.value = value;
    }
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
    @Override
    public int ask(String question, int[] range) {
        do {
            try {
                int res = Integer.valueOf(this.value[0]);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректное значение меню.");
            }
        } while (invalid);
        return Integer.valueOf(this.value[this.position++]);
    }

}
