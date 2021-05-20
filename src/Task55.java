import java.util.*;

public class Task55 {

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
