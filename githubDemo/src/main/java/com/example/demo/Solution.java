import java.util.ArrayList;
import java.util.List;

class  Solution{
    static String[] array = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String num) {
        List<String> res = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return res;
        }
        //10-19
        int i = Integer.parseInt(num);
        if (i >= 10 && i <= 19) {
            num = num.charAt(1) + "";
        }
        backTracking(new StringBuilder(), num, 0, res);
        return res;

    }

    private static void backTracking(StringBuilder temp, String num, int index, List<String> res) {
        if (temp.length() == num.length()) {
            res.add(temp.toString());
            return;
        }

        for (int i = 0; i < array[num.charAt(index) - '0'].length(); i++) {
            temp.append(array[num.charAt(index) - '0'].charAt(i));
            backTracking(temp, num, index + 1, res);
            if (temp.length() > 0) {
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
