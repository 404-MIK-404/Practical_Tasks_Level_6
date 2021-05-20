import java.util.*;
import java.util.regex.*;

public class Task53 {

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String message  = ui.nextLine();
        System.out.print("Ключ для текста: ");
        String key = ui.nextLine();
        nicoCipher(message,key);
    }

    public static void nicoCipher(String message,String key)
    {
        ArrayList<String> textlenght = new ArrayList<String>();
        HashMap<Integer,String> a = new HashMap<Integer,String>();
        String temp = "";
        String result = "";
        int lenghttext = 0;
        char[] arrays = key.toCharArray();
        Arrays.sort(arrays);
        for (int i = 0; i < arrays.length;i++)
        {
           key = key.replaceFirst(Character.toString(arrays[i]), Integer.toString(i));
        }

        Pattern pattern = Pattern.compile("\\w{"+key.length()+"}");
        Matcher matcher = pattern.matcher(message);
        while(matcher.find()) {
            lenghttext += matcher.group().length();
            textlenght.add(matcher.group());
        }


        for (int i = lenghttext; i < message.length();i++ )
        {
            temp += message.charAt(i);
        }
        for (int i = 0; i < temp.length() % key.length();i++)
        {
            temp += " ";
        }

        textlenght.add(temp);


        for (int i = 0; i < textlenght.size();i++)
        {
            for (int j = 0; j < textlenght.get(i).length();j++)
            {
                a.put(Integer.parseInt(Character.toString(key.charAt(j))),Character.toString(textlenght.get(i).charAt(j)));
            }
            for (int j = 0; j < a.size(); j++)
            {
                result += a.get(j);
            }
            a.clear();
        }
        System.out.println("Результат: " + result);
    }


}
