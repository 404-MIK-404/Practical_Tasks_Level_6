import java.util.*;


public class Task59 {

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String value  = ui.nextLine();
        System.out.print("Результат: " + isValid(value));
    }

    public static boolean isValid(String s)
    {
        Map<Character,Integer> map = new HashMap<>();
        int count = 1;
        int zapomnit = 0;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), count);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        count = 0;

        for (Integer digit : map.values()) {
            if (digit == zapomnit)
                count++;
            zapomnit = digit;
            if (digit > max)
                max = digit;
        }
        if (count == map.size() - 1)
            return true;
        else if (map.containsValue(1)) {
            count = 0;
            for (Integer digit : map.values()) {
                if (digit == 1)
                    count++;
            }
            if (count == 1)
                return true;
        }

        else {
            count = 0;
            max -=1;
            for (Integer digit : map.values()) {
                if (digit == max)
                    count++;
            }
            if (count == map.size() - 1)
                return true;
        }
        return false;


    }






}
