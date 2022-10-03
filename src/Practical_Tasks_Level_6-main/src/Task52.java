import java.util.*;
import java.util.regex.*;

public class Task52 {
    /**
     *
     * Напишите функцию, которая возвращает массив строк, заполненных из срезов символов n-длины данного слова (срез за другим, в то время как n-длина применяется к слову).
     *
     * Пример:
     * collect("intercontinentalisationalism", 6)
     * ➞ ["ationa", "interc", "ntalis", "ontine"]
     *
     * collect("strengths", 3)
     * ➞ ["eng", "str", "ths"]
     *
     * collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)
     * ➞ ["croscopicsilico", "pneumonoultrami", "volcanoconiosis"]
     *
     * Примечания:
     *
     * - Убедитесь, что результирующий массив лексикографически упорядочен.
     * - Возвращает пустой массив, если заданная строка меньше n.
     * - Ожидается, что вы решите эту задачу с помощью рекурсивного подхода.
     *
     * @param args
     */
    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String value  = ui.nextLine();
        System.out.print("Длина для того чтобы сделать срез: ");
        int lenghtvalue = ui.nextInt();
        collect(value,lenghtvalue);
    }

    public static void collect(String value, int lenghtvalue)
    {
        Pattern pattern = Pattern.compile("\\w{"+lenghtvalue+"}");
        Matcher matcher = pattern.matcher(value);
        ArrayList<String> textlenght = new ArrayList<String>();
        while(matcher.find())
        {
            textlenght.add(matcher.group());
        }
        Collections.sort(textlenght);
        System.out.println("Результат: " + textlenght.toString());
    }


}
