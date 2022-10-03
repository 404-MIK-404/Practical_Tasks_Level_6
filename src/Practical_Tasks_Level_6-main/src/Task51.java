import java.util.*;

public class Task51 {


    /**
     *
     * Создайте функцию, которая принимает две строки. Первая строка содержит предложение, содержащее буквы второй строки в последовательной последовательности, но в другом порядке.
     * Скрытая анаграмма должна содержать все буквы, включая дубликаты, из второй строки в любом порядке и не должна содержать никаких других букв алфавита.
     *
     * Напишите функцию, чтобы найти анаграмму второй строки, вложенную где-то в первую строку.
     * Вы должны игнорировать регистр символов, любые пробелы и знаки препинания и возвращать анаграмму в виде строчной строки без пробелов или знаков препинания.
     *
     * Пример:
     * hiddenAnagram(["My world evolves in a beautiful space called Tesh.", "sworn love lived"]) ➞ "worldevolvesin"
     * // The sequence "world evolves in" is a perfect anagram of "sworn love lived".
     *
     * hiddenAnagram("An old west action hero actor", "Clint Eastwood") ➞ "noldwestactio"
     * // The sequence "n old west actio" is a perfect anagram of "Clint Eastwood".
     *
     * hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison") ➞ "mrmojorisin"
     * // The sequence "Mr. Mojo Risin" ignoring the full stop, is a perfect
     * // anagram of "Jim Morrison".
     *
     * hiddenAnagram("Banana? margaritas", "ANAGRAM") ➞ "anamarg"
     * // The sequence "ana? marg" ignoring "?" is a perfect anagram of "Anagram".
     *
     * hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit") ➞ "debitcard"
     * // When all spaces, numbers and puntuation marks are removed
     * // from the whole phrase, the remaining characters form the sequence
     * // "Debitcard" which is a perfect anagram of "bad credit".
     *
     * hiddenAnagram("Bright is the moon", "Bongo mirth") ➞ "noutfond"
     * // The words "Bright moon" are an anagram of "bongo mirth" but they are
     * // not a continuous alphabetical sequence because the words "is the" are in
     * // between. Hence the negative result, "noutfond" is returned.
     *
     * Примечание:
     *
     * - Совершенная анаграмма содержит все буквы оригинала в любом порядке, ни больше, ни меньше.
     * - Если в предложении нет скрытой анаграммы, верните "noutfond".
     * - Как и в приведенных выше примерах, скрытая анаграмма может начинаться или заканчиваться частично через слово и/или охватывать несколько слов и может содержать знаки препинания и другие не-альфа-символы.
     * - Игнорируйте регистр символов и любые встроенные не-альфа-символы.
     * - Если в предложении больше 1 результата, верните ближайший к началу.
     *
     *
     *
     * @param args
     */

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Текст: ");
        String valueone  = ui.nextLine();
        System.out.print("Ключ: ");
        String valuetwo  = ui.nextLine();
        System.out.print("Результат: " + hiddenAnagram(valueone,valuetwo));

    }

    public static String hiddenAnagram(String sentence, String key) {
        sentence = sentence.toLowerCase(Locale.ROOT);
        key = key.toLowerCase(Locale.ROOT);
        sentence = sentence.replaceAll(" ", "");
        sentence = sentence.replaceAll("[^A-Za-zА-Яа-я0-9]", ""); // удалится все кроме букв и цифр
        key = key.replaceAll("[^A-Za-zА-Яа-я0-9]", ""); // удалится все кроме букв и цифр
        String keyCopy = new String(key), result = "";

        for (int i = 0; i < sentence.length(); i++) {
            if (result.length() == key.length())
                break;
            if (keyCopy.contains(Character.toString(sentence.charAt(i)))) {
                result += Character.toString(sentence.charAt(i));
                keyCopy.replace(Character.toString(sentence.charAt(i)), "");
            } else {
                keyCopy = new String(key);
                result = "";
            }
        }
        if (result.length() != key.length())
            return "notfound";
        return result;
    }



}
