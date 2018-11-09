package ru.job4j.tracker;
/**
 * Класс проверки ввода в консоли.
 * @version $Id$
 * @since 0.1
 */
public class ValidateInput extends ConsoleInput {
    private final Input input;
    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Метод дополнительной проверки.
     * @param question вопрос.
     * @param range диапазон меню.
     * @return ключ меню.
     */
    public int ask(String question, int[] range) {
       boolean invalid = true;
       int value = -1;
       do {
           try {
               value = super.ask(question, range);
               invalid = false;
           } catch (NumberFormatException nfe) {
               System.out.println("Введите корректное значение меню.");
           } catch (MenuOutException moe) {
               System.out.println("Выберите правильное значение из меню.");
           } catch (ArrayIndexOutOfBoundsException aiobe) {
               System.out.println("Выберите правильное значение из меню.");
           }
       } while (invalid);
       return value;
   }
}
