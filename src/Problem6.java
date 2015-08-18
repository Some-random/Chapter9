import java.util.ArrayList;

/**
 * Created by Bob_JIANG on 8/18/2015.
 */
public class Problem6 {
    static ArrayList<String> result = new ArrayList<>();

    public static void generateParenthesisHelper(StringBuilder temp, int left, int right, int n) {
        if(left == n && right == 0) {
            result.add(temp.toString());
        }
        else {
            if(left < n) {
                temp.append("(");
                generateParenthesisHelper(temp, left + 1, right, n);
                temp.deleteCharAt(temp.length() - 1);
            }
            if(right >= 0 && n - right + 1 <= left) {
                temp.append(")");
                generateParenthesisHelper(temp, left, right - 1, n);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static ArrayList<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        generateParenthesisHelper(temp, 0, n, n);
        return result;
    }

    //Standard approach, use left and right count to track down the number of parenthesis
    public static void main(String[] args) {
        ArrayList<String> list = generateParenthesis(4);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}
