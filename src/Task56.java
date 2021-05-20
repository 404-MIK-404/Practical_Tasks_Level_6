import java.util.*;
import java.util.regex.*;

public class Task56 {

    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
        System.out.print("Значение: ");
        String value  = ui.nextLine();
        fractions(value);
    }

    public static void fractions(String value)
    {
        boolean check = false;
        String valueone = "0";
        String valuetwo = "0";
        String temp = "";
        String nine = "";

        String[] array =  value.split("[.]");

        Pattern pattern = Pattern.compile("\\d*^(\\d*)");
        Matcher matcher = pattern.matcher(array[1]);
        while(matcher.find())
        {
            if (!matcher.group().isEmpty())
            {
                valueone = matcher.group();
            }
        }

        pattern = Pattern.compile("\\d*[^([\\d*])]");
        matcher = pattern.matcher(array[1]);
        while(matcher.find())
        {
            if (!matcher.group().isEmpty())
            {
                valuetwo = matcher.group();
            }
        }


        for (int i = 0; i < valuetwo.length();i++)
        {
            if (valuetwo.charAt(i) != '0')
            {
                nine += "9";
            }
        }


        for (int i =0; i < valueone.length();i++)
        {
            if (valueone.charAt(i) != '0')
            {
                temp += valueone.charAt(i);
                nine += "0";
                check = true;
            }
        }

        if (check)
        {
            valueone = temp;
        }

        int a = (Integer.parseInt(array[0]) * Integer.parseInt(nine))+ Integer.parseInt( valueone + valuetwo) - Integer.parseInt(valueone);
        int aone = Integer.parseInt(nine);
        forCikl(a,aone);

    }



    public static void forCikl(int a, int aone)
    {
        int limit = Math.min(a,aone);
        for (int i = 2; i <= limit;i++)
        {
            if (a % i == 0 && aone % i == 0)
            {

                a = a/i;
                aone = aone/i;
            }
        }

        System.out.print(Integer.toString(a) + "/" + Integer.toString(aone));
    }


}
