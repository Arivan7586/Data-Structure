package arivan.Test3_16;

public class Test3_16 {
    public static void main(String[] args) {
//        String str = "helloa";
//        char[] arr = str.toCharArray();
//        Solution2.reverseString(arr,0,5);
//        String s = new String(arr);
//        System.out.println(s);

//        char[] arr = str.toCharArray();
//        Solution1.reverseString(arr);
//        String s1 = new String(arr);
//        System.out.println(Solution.toLowerCase(s1));

        String str = "Let's take LeetCode contest";
        System.out.println(Solution2.reverseWords(str));
    }
}

class Solution {
//    实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
//    并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
    public static String toLowerCase(String str) {
        if (str == null) {
            return str;
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int c = arr[i];
            if (c >= 65 && c <= 90) {
                arr[i] = (char)(c + 32);
            }
        }
        String result = new String(arr);
        return result;
    }
}

class Solution1 {
//    编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//
//    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
    public static void reverseString(char[] s) {
        int n = s.length;
        if (n <= 1) {
            return;
        }
        int l = 0;
        int r = n - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}

class Solution2 {
//    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//    示例 1:
//    输入: "Let's take LeetCode contest"
//    输出: "s'teL ekat edoCteeL tsetnoc"
    public static String reverseWords(String s) {
        if (s.equals("")) {
            return "";
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n <= 1) {
            return null;
        }
        int l = 0;

        int r = 0;
        int i = 0;
        while (i < n) {
            //找到l的位置
            for (; i < n; i++) {
                if (arr[i] != ' ') {
                    l = i;
                    break;
                }else {
                    i++;
                }
            }
            //找到r的位置
            while (i < n) {
                if (i == n-1) {
                    r = n - 1;
                    reverseString(arr,l,r);
                    i++;
                    break;
                }
                if (arr[i] == ' ') {
                    r = i - 1;
                    reverseString(arr,l,r);
                    i++;
                    break;
                }else {
                    i++;
                }
            }
        }
        return new String(arr);
    }
    public static void reverseString(char[] s, int l, int r) {
        int n = s.length;
        if (n <= 1) {
            return;
        }
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
