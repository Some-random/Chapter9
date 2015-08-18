import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob_JIANG on 8/18/2015.
 */
public class Problem9 {
    static boolean[] column = new boolean[8];
    static boolean[][] diag = new boolean[8][8];
    static boolean[][] antidiag = new boolean[8][8];

    public static void solveNQueensHelper(List<List<String>> s, List<String> temp, int level, int n) {
        if(level == n) {
            List<String> copy = new ArrayList<>(temp);
            s.add(copy);
        }
        else {
            boolean capaable;
            for(int i = 0; i < n; i++) {
                capaable = true;
                for(int j = 1; j < Integer.min(level + 1, i + 1); j++) {
                    if(!diag[level - j][i - j]) {
                        capaable = false;
                    }
                }
                for(int j = 1; j < Integer.min(level + 1, n - i); j++) {
                    if(!antidiag[level - j][i + j]) {
                        capaable = false;
                    }
                }
                if(!column[i]) {
                    capaable = false;
                }
                if(capaable) {
                    StringBuilder SB = new StringBuilder(temp.get(level));
                    SB.setCharAt(i, '#');
                    temp.set(level, SB.toString());
                    column[i] = false;
                    for(int j = 0; j < Integer.min(level + 1, i + 1); j++) {
                        diag[level - j][i - j] = false;
                    }
                    for(int j = 0; j < Integer.min(level + 1, n - i); j++) {
                        antidiag[level - j][i + j] = false;
                    }
                    solveNQueensHelper(s, temp, level + 1, n);
                    for(int j = 0; j < Integer.min(level + 1, n - i); j++) {
                        antidiag[level - j][i + j] = true;
                    }
                    for(int j = 0; j < Integer.min(level + 1, i + 1); j++) {
                        diag[level - j][i - j] = true;
                    }
                    column[i] = true;
                    StringBuilder SB2 = new StringBuilder(temp.get(level));
                    SB2.setCharAt(i, '*');
                    temp.set(level, SB2.toString());
                }
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String >> s = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String ss = "********";
        for(int i = 0; i < 8; i++) {
            temp.add(ss);
        }
        solveNQueensHelper(s, temp, 0, n);
        return s;
    }

    //Standard question, a couple things to keep in mind: the use of min, the use of array column and 2D array diag,
    // clone at the end, where to initialize the flag
    public static void main(String[] args) {
        for(int i = 0; i < 8; i++) {
            column[i] = true;
        }
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                diag[i][j] = antidiag[i][j] = true;
            }
        }

        List<List<String>> s = solveNQueens(8);

        System.out.println(s.size());


        for(int i = 0; i < s.size(); i++) {
            for(int j = 0; j < s.get(i).size(); j++) {
                System.out.println(s.get(i).get(j));
            }
            System.out.println();
        }
    }
}
