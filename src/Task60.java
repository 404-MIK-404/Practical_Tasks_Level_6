import java.util.*;

public class Task60 {


    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Количество чисел которые будут храняться в массиве: ");
        int value  = ui.nextInt();
        int[] array = new int[value];
        for (int i = 0; i < array.length;i++)
        {
            System.out.print("Значение: ");
            array[i] = ui.nextInt();
        }
        sumsUp(array);
    }

    public static void sumsUp(int[] array)
    {
        ArrayList<Integer> ol = new ArrayList<Integer>();
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < array.length;i++)
        {
            int temp = array[i];
            for (int j = 0; j < ol.size(); j++)
            {
                if (8 == temp + ol.get(j))
                {
                    result.add("[" + ol.get(j).toString()+"," + Integer.toString(temp) +"]");
                }
            }
            ol.add(temp);
        }
        System.out.println("Результат: " + result);


    }

}
