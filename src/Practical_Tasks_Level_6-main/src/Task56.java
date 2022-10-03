import java.util.*;
import java.util.regex.*;

public class Task56 {

    /**
     *
     * Деление на дробь часто приводит к бесконечно повторяющейся десятичной дроби.
     *
     * 1/3=.3333333...  1/7=.142857142857...
     *
     * Создайте функцию, которая принимает десятичную дробь в строковой форме с повторяющейся частью в круглых скобках и возвращает эквивалентную дробь в строковой форме и в наименьших членах.
     *
     * Пример:
     * fractions("0.(6)") ➞ "2/3"
     *
     * fractions("1.(1)") ➞ "10/9"
     *
     * fractions("3.(142857)") ➞ "22/7"
     *
     * fractions("0.19(2367)") ➞ "5343/27775"
     *
     * fractions("0.1097(3)") ➞ "823/7500"
     *
     *
     * @param args
     */

    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
        System.out.print("Значение: ");
        String value  = ui.nextLine();
        fractions(value);
    }

    public static void fractions(String value)
    {
        Pattern pattern = Pattern.compile("\\(\\d+\\)");
        Matcher matcher = pattern.matcher(value);
        String[] arrayText = value.split("[.]");
        String result = "";
        String nineAndZero = "";
        String numeratorCreate = "";
        while(matcher.find())
        {
            if (!matcher.group().isEmpty())
            {
                result = matcher.group();
            }
        }
        arrayText[1] = arrayText[1].replace(result,"");
        for (int i = 1; i < result.length()-1;i++){
            nineAndZero += "9";
            numeratorCreate += result.charAt(i);
        }
        for (int i = 0; i < arrayText[1].length();i++){
            nineAndZero += "0";
        }
        if (arrayText[1].isEmpty()){
            arrayText[1] = "0";
        }
        forCikl(
                (Integer.parseInt(arrayText[0]) * Integer.parseInt(nineAndZero)) + (Integer.parseInt(arrayText[1] + numeratorCreate) - Integer.parseInt(arrayText[1])),
                Integer.parseInt(nineAndZero));
    }
    public static void forCikl(int numerator, int denominator)
    {
        int limit = Math.min(numerator,denominator);
        for (int i = 2; i <= limit;i++)
        {
            if (numerator % i == 0 && denominator % i == 0)
            {

                numerator = numerator/i;
                denominator = denominator/i;
            }
        }
        System.out.print(Integer.toString(numerator) + "/" + Integer.toString(denominator));
    }


}
