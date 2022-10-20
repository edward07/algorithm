import java.util.ArrayList;
import java.util.List;

/**
 *求组合数
 */
public class Combination {

    static int target = 7;
    static int[] candidates = {2,3,4,5};

    public static void get(int target, ArrayList<Integer> answerList) {
        for (int i = 0; i < candidates.length; i++) {
            int remain = target - candidates[i];
            if (remain == 0) {
                ArrayList<Integer> currList = (ArrayList<Integer>)answerList.clone();
                currList.add(candidates[i]);
                printList(currList);
                return;
            } else if (remain < 0) {
               return;
            } else {
                ArrayList<Integer> currList = (ArrayList<Integer>)answerList.clone();
                currList.add(candidates[i]);
                get(remain, currList);
            }
        }
    }

    public static void printList(List<Integer> list) {
        StringBuffer sb  = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        get(target, new ArrayList<>());
    }

}
