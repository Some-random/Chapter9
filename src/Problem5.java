import java.util.ArrayList;

/**
 * Created by Bob_JIANG on 8/18/2015.
 */
public class Problem5 {
    public static void getPermsHelper(ArrayList<String> result, StringBuilder temp, StringBuilder base) {
        if(base.length() == 0) {
            result.add(temp.toString());
        }
        else {
            for(int i = 0; i < base.length(); i++) {
                char c = base.charAt(i);
                temp.append(c);
                base.deleteCharAt(i);
                getPermsHelper(result, temp, base);
                base.insert(i, c);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static ArrayList<String> getPerms(String base) {
        StringBuilder SB = new StringBuilder(base);
        StringBuilder temp = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        getPermsHelper(result, temp, SB);
        return result;
    }

    //Standard problem, notice the use of StringBuilder
    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abcde");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
