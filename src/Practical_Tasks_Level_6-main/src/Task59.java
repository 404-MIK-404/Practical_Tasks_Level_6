import sun.security.pkcs11.wrapper.Functions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Task59 {

    /**
     *
     *
     * Шерлок считает строку действительной, если все символы строки встречаются одинаковое количество раз.
     * Также допустимо, если он может удалить только 1 символ из 1 индекса в строке, а остальные символы будут встречаться одинаковое количество раз.
     * Для данной строки str определите, действительна ли она. Если да, верните «ДА», в противном случае верните «НЕТ».
     *
     * Например, если str = "abc", строка действительна, потому что частота символов у всех одинакова. Если str = "abcc", строка также действительна,
     * потому что мы можем удалить 1 "c" и оставить по одному символу каждого символа в строке. Однако, если str = "abccc", строка недействительна, поскольку удаление одного символа не приводит к одинаковой частоте символов.
     *
     * Пример:
     * isValid("aabbcd") ➞ "NO"
     * // We would need to remove two characters, both c and d  -> aabb or a and b -> abcd, to make it valid.
     * // We are limited to removing only one character, so it is invalid.
     *
     * isValid("aabbccddeefghi") ➞ "NO"
     * // Frequency counts for the letters are as follows:
     * // {"a": 2, "b": 2, "c": 2, "d": 2, "e": 2, "f": 1, "g": 1, "h": 1, "i": 1}
     * // There are two ways to make the valid string:
     * // Remove 4 characters with a frequency of 1: {f, g, h, i}.
     * // Remove 5 characters of frequency 2: {a, b, c, d, e}.
     * // Neither of these is an option.
     *
     * isValid("abcdefghhgfedecba") ➞ "YES"
     * // All characters occur twice except for e which occurs 3 times.
     * // We can delete one instance of e to have a valid string.
     *
     *
     * @param args
     */

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String value  = ui.nextLine();
        isValid(value);
    }

    public static void isValid(String s)
    {
        int popitka = 1;
        Map<String,Long> frequencyCharLetter = s.toLowerCase(Locale.ROOT).chars().mapToObj(e->(char)e + "").collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("До работы: " + frequencyCharLetter);
        while (true){
            String maxKey = frequencyCharLetter.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            String maxMin = frequencyCharLetter.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
            if (frequencyCharLetter.get(maxKey) - frequencyCharLetter.get(maxMin) != 0
                    && popitka == 1){
                frequencyCharLetter.put(maxKey,frequencyCharLetter.get(maxKey) - 1);
                popitka--;
            } else if (popitka < 1 && !(frequencyCharLetter.get(maxKey).equals(frequencyCharLetter.get(maxMin))) ){
                popitka = -1;
                break;
            } else if (frequencyCharLetter.get(maxKey).equals(frequencyCharLetter.get(maxMin))) {
                popitka = 0;
                break;
            }
            System.out.println("Процесс работы: " + frequencyCharLetter);
        }

        if (popitka < 0){
            System.out.println("Результат: NO");
        }
        else {
            System.out.println("Результат: YES");
        }

    }


}
