package ru.job4j.tracker;

public class StubInput implements Input {
    private final String[] value;
    private int position = 0;
    public StubInput(final String[] value) {
        this.value = value;
    }
    /**
     * Метод эмуляции ввода без проверки.
     * @param question вопрос.
     * @return ключ меню.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
    /**
     * Метод дополнительной проверки.
     * @param question вопрос.
     * @param range диапазон меню.
     * @return ключ меню.
     */
    @Override
    public int ask(String question, int[] range) {
        return Integer.valueOf(this.value[this.position++]);
    }

}
