import java.util.*;
import java.util.concurrent.TimeoutException;

public class Task58 {

    /**
     *
     * Создайте функцию для генерации всех непоследовательных двоичных строк,
     * где непоследовательные определяется как строка, в которой нет последовательных строк, и где n определяет длину каждой двоичной строки.
     *
     * Пример:
     * generateNonconsecutive(1) ➞ "0 1"
     *
     * generateNonconsecutive(2) ➞ "00 01 10"
     *
     * generateNonconsecutive(3) ➞ "000 001 010 100 101"
     *
     * generateNonconsecutive(4) ➞ "0000 0001 0010 0100 0101 1000 1001 1010"
     *
     *
     *
     * @param args
     */

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
