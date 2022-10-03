import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task57 {


    /**
     *
     * В этой задаче преобразуйте строку в серию слов (или последовательности символов), разделенных одним пробелом, причем каждое слово имеет одинаковую длину,
     * заданную первыми 15 цифрами десятичного представления числа Пи: 3.14159265358979
     *
     * Если строка содержит больше символов, чем общее количество, заданное суммой цифр Пи,
     * неиспользуемые символы отбрасываются, и вы будете использовать только те, которые необходимы для формирования 15 слов.
     *
     * String = "HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"
     *
     * Pi String = "HOW I NEED A DRINK ALCOHOLIC IN NATURE AFTER THE HEAVY LECTURES INVOLVING QUANTUM MECHANICS"
     *
     * // Every word has the same length of the digit of Pi found at the same index ?
     * // "HOW" = 3, "I" = 1, "NEED" = 4, "A" = 1, "DRINK" = 5
     * // "ALCOHOLIC" = 9, "IN" = 2, "NATURE" = 6, "AFTER" = 5
     * // "THE" = 3, "HEAVY" = 5, "LECTURES" = 8, "INVOLVING" = 9
     * // "QUANTUM" = 7, "MECHANICS" = 9
     * // 3.14159265358979
     *
     * Также, если строка содержит меньше символов, чем общее количество, заданное суммой цифр Пи, в любом случае вы должны соблюдать последовательность цифр для получения слов.
     *
     * String = "FORALOOP"
     *
     * Pi String = "FOR A LOOP"
     *
     * // Every word has the same length of the digit of Pi found at the same index ?
     * // "FOR" = 3, "A" = 1, "LOOP" = 4
     * // 3.14
     *
     * Если буквы, содержащиеся в строке, не совпадают в точности с цифрами, в этом случае вы будете повторять последнюю букву, пока слово не будет иметь правильную длину.
     *
     * String = "CANIMAKEAGUESSNOW"
     *
     * Pi String = "CAN I MAKE A GUESS NOWWWWWWW"
     *
     * // Every word has the same length of the digit of Pi found at the same index ?
     * // "CAN" = 3, "I" = 1, "MAKE" = 4, "A" = 1, "GUESS" = 5, "NOW" = 3
     * // 3.14153 (Wrong!)
     * // The length of the sixth word "NOW" (3)...
     * // ...doesn't match the sixth digit of Pi (9)
     * // The last letter "W" will be repeated...
     * // ...until the length of the word will match the digit
     *
     * // "CAN" = 3, "I" = 1, "MAKE" = 4, "A" = 1, "GUESS" = 5, "NO WW WW WW W" = 9
     * // 3.14159 (Correct!)
     *
     * Если данная строка пуста, должна быть возвращена пустая строка.
     *
     * Учитывая строку txt, реализуйте функцию, которая возвращает ту же строку, отформатированную в соответствии с приведенными выше инструкциями.
     *
     * Пример:
     * pilish_string("33314444") ➞ "333 1 4444"
     * // 3.14
     *
     * pilish_string("TOP") ➞ "TOP"
     * // 3
     *
     * pilish_string("X")➞ "XXX"
     * // "X" has to match the same length of the first digit (3)
     * // The last letter of the word is repeated
     *
     * pilish_string("")➞ ""
     *
     * Примечание:
     * - Эта задача представляет собой упрощенную концепцию, вдохновленную Пилишем, своеобразным типом ограниченного письма, в котором используются все известные возможные цифры Пи.
     * Потенциально бесконечный текст может быть написан с использованием знаков препинания и набора дополнительных правил, которые позволяют избежать длинных последовательностей маленьких цифр,
     * заменяя их словами больше 9 букв и делая так, чтобы композиция выглядела более похожей на стихотворение вольным стихом.
     *
     * - Точка, отделяющая целую часть числа Пи от десятичной, не должна учитываться в функции: она присутствует в инструкциях и примерах только для удобства чтения.
     *
     *
     * @param args
     */

    private static List<Integer> valuePI = Arrays.asList(3,1,4,1,5,9,2,6,5,3,5,8,9,7,9);

    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String value  = ui.nextLine();
        System.out.print("Результат: " + pilishString(new StringBuilder(value)));
    }

    public static String pilishString(StringBuilder value)
    {
        ArrayList<String> arrayText = new ArrayList<>();
        for (int i = 0; i < valuePI.size();i++){
            if (!value.toString().isEmpty() && value.length() >= valuePI.get(i)){
                arrayText.add(value.substring(0,valuePI.get(i)));
                value.replace(0, valuePI.get(i), "");
            }
            else {
                break;
            }
        }
        if (valuePI.size() == arrayText.size()){
            value = new StringBuilder("");
        }
        else if (!value.toString().isEmpty()) {
            String value1 = value.toString();
            char temp = value.charAt(value1.length()-1);
            for (int i = value.length(); i < valuePI.get(arrayText.size()); i++){
                value1 += temp + "";
            }
            value = new StringBuilder(value1);
            arrayText.add(value.toString());
        }
        return arrayText.stream().collect(Collectors.joining(" "));
    }


}
