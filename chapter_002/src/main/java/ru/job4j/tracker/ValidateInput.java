package ru.job4j.tracker;
/**
 * Класс проверки ввода в консоли и проверки эмуляции ввода с использованием интерфейса Input.
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput implements Input {
    private final Input input;
    public ValidateInput(final Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }
    /**
     * Метод дополнительной проверки.
     * @param question вопрос.
     * @param range диапазон меню.
     * @return ключ меню.
     */
    @Override
    public int ask(String question, int[] range) {
       boolean invalid = true;
       int value = -1;
       do {
           try {
               value = this.input.ask(question, range);
               invalid = false;
           } catch (NumberFormatException nfe) {
               System.out.println("Выбранный символ недопустим.");
           } catch (MenuOutException moe) {
               System.out.println("Задайте значение от 0 до 6.");
           }
       } while (invalid);
       return value;
   }
}
