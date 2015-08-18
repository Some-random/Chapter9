/**
 * Created by Bob_JIANG on 8/18/2015.
 */
public class Problem8 {

    public static int makeChange(int n)
    {
        int count = 0;
        for (int i = 0; i <= n / 25; i++)
            for (int j = 0; j <= n / 10; j++)
                for (int k = 0; k <= n / 5; k++)
                    for (int l = 0; l <= n; l++)

                    {
                        int v = i * 25 + j * 10 + k * 5 + l;
                        if (v == n)
                            count ++;
                        else if (v > n)
                            break;
                    }
        return count;
    }

    //Hmm... kinda like this loop approach...
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println("makeChange(" + i + ") = " + makeChange(i));
        }
    }
}
