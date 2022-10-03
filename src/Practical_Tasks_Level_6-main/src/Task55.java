import java.util.*;

public class Task55 {

    /**
     *
     * Создайте рекурсивную функцию, которая проверяет, является ли число точной верхней границей факториала n. Если это так, верните массив точной факториальной границы и n, или иначе, пустой массив.
     *
     * Пример:
     * isExact(6) ➞ [6, 3]
     *
     * isExact(24) ➞ [24, 4]
     *
     * isExact(125) ➞ []
     *
     * isExact(720) ➞ [720, 6]
     *
     * isExact(1024) ➞ []
     *
     * isExact(40320) ➞ [40320, 8]
     *
     *
     * @param args
     */

    public static void main(String[] args)
    {

        Scanner ui = new Scanner(System.in);
        System.out.print("Число факториала: ");
        int value  = ui.nextInt();
        System.out.print(fact(value));
    }

    private static int fact(int n) {
        int check = n;
        int value = 0;
        for (int i = 1; i <= check; i++) {
            check = check/i;
            value = i;
        }

        int result = 1;
        for (int i = 1; i <= value; i++) {
            result = result * i;

        }
        if (n != result)
        {
            return 0;
        }

        return value;
    }

}
