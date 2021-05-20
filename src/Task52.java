import java.util.*;
import java.util.regex.*;

public class Task52 {

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
