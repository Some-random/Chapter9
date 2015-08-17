/**
 * Created by Bob_JIANG on 8/17/2015.
 */
public class Problem1 {
    public static int countWaysDP(int i, int[] map) {
        map[0] = 0;
        map[1] = 1;
        map[2] = 2;
        map[3] = 4;
        int j = 4;
        for(; j <= i; j++) {
            map[j] = map[j - 1] + map[j - 2] + map[j - 3];
        }
        return map[i];
    }


    //Let's just use the DP approach...
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            long t1 = System.currentTimeMillis();
            int[] map = new int[30 + 1];
            for (int j = 0; j < map.length; j++) {
                map[j] = -1;
            }
            int c1 = countWaysDP(i, map);
            long t2 = System.currentTimeMillis();
            long d1 = t2 - t1;

            long t3 = System.currentTimeMillis();
            //int c2 = countWaysRecursive(i);
            long t4 = System.currentTimeMillis();
            long d2 = t4 - t3;
            System.out.println(i + " " + c1);// + " " + c2 + " " + d1 + " " + d2);
        }
    }
}
