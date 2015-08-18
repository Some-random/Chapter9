import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Bob_JIANG on 8/18/2015.
 */
public class Problem4 {
    static ArrayList<ArrayList<Integer>> result;
    public static void subsetsHelper(ArrayList<Integer> temp, ArrayList<Integer> nums) {
        if (nums.size() == 0) {
            result.add(temp);
            return;
        }
        else {
            temp.add(nums.get(0));
            ArrayList<Integer> temp1 = new ArrayList<>(nums.subList(1, nums.size() - 1));
            subsetsHelper(temp, temp1);
            temp.remove(temp.size()- 1);
            subsetsHelper(temp, temp1);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> temp = new ArrayList<>();
        subsetsHelper(temp, nums);
        return result;
    }

    //Standard approach, add/ remove,just get used to the APIs for arraylist
    public static void main(String[] args) {

    }
}
