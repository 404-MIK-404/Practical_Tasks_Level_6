import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Task53 {


    /**
     *
     * В шифре Nico кодирование осуществляется путем создания цифрового ключа и присвоения каждой буквенной позиции сообщения с помощью предоставленного ключа.
     *
     * Создайте функцию, которая принимает два аргумента, message и key, и возвращает закодированное сообщение.
     *
     * Существуют некоторые вариации правил шифрования. Одна из версий правил шифрования изложена ниже:
     *
     * message = "mubashirhassan"
     * key = "crazy"
     *
     * nicoCipher(message, key) ➞ "bmusarhiahass n"
     *
     * Шаг 1: Назначьте числа отсортированным буквам из ключа:
     * "crazy" = 23154
     *
     * Шаг 2: Назначьте номера буквам данного сообщения:
     * 2 3 1 5 4
     * ---------
     * m u b a s
     * h i r h a
     * s s a n
     *
     * Шаг 3: Сортировка столбцов по назначенным номерам:
     * 1 2 3 4 5
     * ---------
     * b m u s a
     * r h i a h
     * a s s   n
     *
     * Шаг 4: Верните закодированное сообщение по строкам:
     * eMessage = "bmusarhiahass n"
     *
     * Пример:
     * nicoCipher("myworldevolvesinhers", "tesh") ➞ "yowmledrovlvsnieesrh"
     *
     * nicoCipher("andiloveherso", "tesha") ➞ "lnidaevheo s or"
     *
     * nicoCipher("mubashirhassan", "crazy") ➞ "bmusarhiahass n"
     *
     * nicoCipher("edabitisamazing", "matt") ➞ "deabtiismaaznig "
     *
     * nicoCipher("iloveher", "612345") ➞ "lovehir    e"
     *
     * @param args
     */

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
        String result = "";
        List<String> arrayList =  key.chars().mapToObj(e->(char)(e) + "").collect(Collectors.toList());
        List<String> arrayListClone = new ArrayList<>(arrayList);
        HashMap<Integer,String> map = new HashMap<>();

        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size();i++){
            map.put((i+1),arrayList.get(i));
        }

        for (Map.Entry<Integer,String> value : map.entrySet()){
            Integer key1 = value.getKey();
            String  value1 = value.getValue();
            for (int i = 0; i < arrayListClone.size();i++){
                if (value1.equals(arrayListClone.get(i))){
                    arrayListClone.set(i,String.valueOf(key1));
                    break;
                }
            }
        }

        double max = (double) map.entrySet().stream().max((entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1).get().getKey();
        String[][] array = new String[(int) Math.ceil(message.length()/max)][arrayList.size()];

        int count = 0;
        for (int i = 0; i < array.length;i++){
            for (int j = 0; j < array[i].length;j++){
                if (count != message.length()){
                    map.put(Integer.parseInt(arrayListClone.get(j)),message.charAt(count) + "");
                    count++;
                } else {
                    map.put(Integer.parseInt(arrayListClone.get(j))," ");
                }
            }
            result += String.join("", map.values());
            map.clear();

        }

        System.out.println("Результат: " + result);
    }


}
