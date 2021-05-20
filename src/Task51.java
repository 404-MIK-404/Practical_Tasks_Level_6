import java.util.*;

public class Task51 {

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
