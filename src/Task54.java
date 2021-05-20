import java.util.*;

public class Task54 {

    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
        System.out.print("Значение которое необходимо получить: ");
        int valueone  = ui.nextInt();
        System.out.print("Количество чисел которые будут храняться в массиве: ");
        int value  = ui.nextInt();
        int[] array = new int[value];
        for (int i = 0; i < array.length;i++)
        {
            System.out.print("Значение: ");
            array[i] = ui.nextInt();
        }
        twoProduct(array,valueone);
    }

    public static void twoProduct(int[] array,int valueone)
    {
        ArrayList<Integer> ol = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < array.length;i++)
        {
            int temp = array[i];
            for (int j = 0; j < ol.size(); j++)
            {
                if (valueone == temp * ol.get(j))
                {
                    result.add(ol.get(j));
                    result.add(temp);
                    break;
                }
            }
            if (!result.isEmpty())
            {
                break;
            }
            ol.add(temp);
        }
        System.out.println("Результат: " + result);


    }


}
