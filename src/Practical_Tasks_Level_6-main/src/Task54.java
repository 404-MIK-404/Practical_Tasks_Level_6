import java.util.*;

public class Task54 {

    /**
     *
     * Создайте метод, который принимает массив arr и число n и возвращает массив из двух целых чисел из arr, произведение которых равно числу n следующего вида:
     *
     * [value_at_lower_index, value_at_higher_index]
     *
     * Убедитесь, что вы возвращаете массив из двух целых чисел, который точно делит n (произведение n) и что индексы совпадают с указанным выше форматом.
     * Таким образом, сортировка значений основана на восходящих индексах.
     *
     * Пример:
     * twoProduct([1, 2, 3, 9, 4, 5, 15, 3], 45) ➞ [9, 5]
     * // at index 5 which has the value 5 is  a full match
     * // to the value at index 3 which is 9
     * // the closest gap between indices that equates
     * // to the product which is 45
     *
     * twoProduct([1, 2, 3, 9, 4, 15, 3, 5], 45) ➞ [3, 15]
     * // at index 5 which has the value 15 is a full match
     * // to the value at index 2 which is 3
     * // the closest gap between indices that equates
     * // to the product which is 45
     *
     * twoProduct([1,  2, -1,  4,  5,  6,  10, 7], 20) ➞ [4, 5]
     * // at index 4 which has the value 5 is a full match
     * // to the value at index 3 which is 4
     * // a full match can only be achieved  if you've found the multiplier at an
     * // index lower than the current index, thus, 5 (@ index 4) has a pair lower
     * // than its index which is the value 4 (@ index 3), so, 5*4 = 20, in which 5
     * // has a higher index (4) than 4 which has an index value of 3
     *
     * twoProduct([1, 2, 3, 4, 5,  6, 7, 8, 9, 10], 10) ➞ [2, 5]
     *
     * twoProduct([100, 12, 4, 1, 2], 15) ➞ []
     *
     * Примечание:
     * - Дубликатов не будет.
     * - Возвращает пустой массив, если совпадение не найдено.
     * - Всегда считайте, что пара рассматриваемого элемента (текущий элемент, на который указывали во время поиска) находится слева от него.
     * - Массив может иметь несколько решений (произведений n), поэтому возвращайте первое найденное полное совпадение (как описано выше).
     *
     *
     *
     *
     * @param args
     */


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
