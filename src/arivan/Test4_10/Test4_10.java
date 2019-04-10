package arivan.Test4_10;
import java.util.*;

public class Test4_10 {
    public static void main(String[] args) {
        //generate(5);
        Solution solution = new Solution();
        //System.out.println(solution.generate(5));

        Solution1 solution1 = new Solution1();
//        System.out.println(solution1.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
//        System.out.println(solution1.findDuplicates(new int[]{4,3}));
//        System.out.println(solution1.findDuplicates(new int[]{4,3,4}));
//        System.out.println(solution1.findDuplicates(new int[]{4}));
//        System.out.println(solution1.findDuplicates(new int[]{}));
//        System.out.println(solution1.findDuplicates(new int[]{4,4}));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isValid("()"));
        System.out.println(solution2.isValid("()[]{}"));
        System.out.println(solution2.isValid("(]"));
        System.out.println(solution2.isValid("([)]"));
        System.out.println(solution2.isValid("{[]}"));
        System.out.println(solution2.isValid(""));

    }
    public static void generate(int n) {
        //输出n行杨辉三角
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = "1";
                }else {
                    arr[i][j] = String.valueOf(Integer.parseInt(arr[i-1][j-1])+
                            Integer.parseInt(arr[i-1][j]));
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < n - i-1; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != null) {
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}

class Solution {

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }else {
                    list.add(result.get(i-1).get(j-1) +
                            result.get(i-1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}

class Solution1 {
    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）,
     * 其中有些元素出现两次而其他元素出现一次。
     * 找到所有出现两次的元素。
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int n = nums.length;
        if (n <= 1) {
            return list;
        }else if (n == 2 && nums[0] == nums[1]) {
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);
        for (int i = 1; i < n-1; i++) {
            if (nums[i] == nums[i-1] && nums[i] != nums[i+1]) {
                list.add(nums[i]);
            }
        }
        if (nums[n-1] == nums[n-2] && nums[n-2] != nums[n-3]) {
            list.add(nums[n-1]);
        }
        return list;
    }
}

class Solution2 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }else if (s.equals("")) {
            return true;
        }
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(arr[0]);
        int i = 1;
        while (i < arr.length) {
            if (stack.empty()) {
                stack.push(arr[i]);
            }else if (stack.peek() == '(' && arr[i] == ')') {
                stack.pop();
            }else if (stack.peek() == '[' && arr[i] == ']') {
                stack.pop();
            }else if (stack.peek() == '{' && arr[i] == '}') {
                stack.pop();
            }else {
                stack.push(arr[i]);
            }
            i++;
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}

interface Im<T> {
    void print(T t);
}
