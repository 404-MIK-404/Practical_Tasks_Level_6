import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task57 {

    private static String valuePI = "314159265358979";

    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String value  = ui.nextLine();
        System.out.print("Результат: " + pilishString(value));
    }

    public static String pilishString(String value)
    {
        String result = "";
        String temp = "";
        char[] array = valuePI.toCharArray();
        for (int i = 0; i < array.length;i++)
        {
            Pattern pattern = Pattern.compile("\\w{"+Integer.parseInt(Character.toString(array[i]))+"}");
            Matcher matcher = pattern.matcher(value);
            while(matcher.find())
            {
                temp = matcher.group();
                result += matcher.group() + " ";
                value = value.replaceFirst(matcher.group(),"");
                break;
            }
            if (temp.isEmpty())
            {
                if (!value.isEmpty())
                {
                    for (int j = 0; j < value.length();j++)
                    {
                        result += value.charAt(j);
                    }
                    for (int j = 0; j <  Integer.parseInt(Character.toString(array[i])) - value.length(); j++)
                    {
                        result += value.charAt(value.length() - 1);
                    }
                }
                break;
            }
            temp = "";
        }
        return result;
    }


}
