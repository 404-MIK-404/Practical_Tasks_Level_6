import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

public class Task60 {

    /**
     *
     * Создайте функцию, которая получает каждую пару чисел из массива, который суммирует до восьми,
     * и возвращает его как массив пар (отсортированный по возрастанию).
     *
     * Пример:
     * sumsUp([1, 2, 3, 4, 5]) ➞ [[3, 5]]
     *
     * sumsUp([1, 2, 3, 7, 9]) ➞ [[1, 7]]
     *
     * sumsUp([10, 9, 7, 2, 8]) ➞ []
     *
     * sumsUp([1, 6, 5, 4, 8, 2, 3, 7]) ➞ [[2, 6], [3, 5], [1, 7]]
     * // [6, 2] first to complete the cycle (to sum up to 8)
     * // [5, 3] follows
     * // [1, 7] lastly
     * // the pair that completes the cycle is always found on the left
     * // [2, 6], [3, 5], [1, 7] sorted according to cycle completeness, then pair-wise.
     *
     * @param args
     */

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Количество чисел которые будут храняться в массиве: ");
        int value  = ui.nextInt();
        HashMap<String,Integer> hashMapValue = new HashMap<>();
        ArrayList<Integer> arrayValue = new ArrayList<>();
        for (int i = 0; i < value;i++)
        {
            System.out.print("Значение: ");
            int valueVvod = ui.nextInt();
            hashMapValue.put(Integer.toString(valueVvod),i);
            arrayValue.add(valueVvod);

        }
        sumsUp(hashMapValue,arrayValue);
    }

    public static void sumsUp(HashMap<String,Integer> hashMapValue,ArrayList<Integer> arrayValue)
    {
        ArrayList<List<Integer>> arrayResults = new ArrayList<>();
        for (int i = 0; i < arrayValue.size();i++){
            int value = 8 - arrayValue.get(i);
            if (hashMapValue.containsKey(Integer.toString(value))
                    && value != arrayValue.get(i)){
                List<Integer> arrayListCheck = Arrays.asList(value,arrayValue.get(i));
                Collections.sort(arrayListCheck);
                if (arrayResults.isEmpty()){
                    arrayResults.add(arrayListCheck);
                    Collections.sort(arrayResults.get(arrayResults.size()-1));
                } else if (!arrayResults.contains(arrayListCheck)) {
                    arrayResults.add(arrayListCheck);
                    Collections.sort(arrayResults.get(arrayResults.size()-1));
                }
            }
        }
        System.out.println("Массив: " + arrayValue);
        System.out.println("Результат: " + arrayResults);


    }

}
