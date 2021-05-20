import java.util.*;
import java.util.concurrent.TimeoutException;

public class Task58 {



    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Введите текст: ");
        int value  = ui.nextInt();
        generateNonconsecutive(value);

    }

    public static void generateNonconsecutive(int n) {
        boolean check = false;
        ArrayList<String> arrayList = new ArrayList<String>();
        String text = "";
        for (int i = 0; i < Math.pow(2,n);i++)
        {
            String temp = Integer.toBinaryString(i);
            for (int j = 0; j < temp.length()-1;j++)
            {
                if (temp.charAt(j) == '1' && temp.charAt(j+1) == '1')
                {
                    check = true;
                    break;
                }
                else
                {
                    text += temp.charAt(j);
                }
            }
            if (!check)
            {
                text = temp;
                for (int j = 0; j < n - temp.length();j++)
                {
                    text = "0" + text;
                }
                arrayList.add(text);
            }
            check = false;
        }
        System.out.print(arrayList);
    }

}
