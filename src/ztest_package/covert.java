package ztest_package;

import java.util.ArrayList;
import java.util.List;

public class covert {

    public static void main(String[] args) {

        String str1 = ",1,2,3,4,";
        String str2 = ",1,";
        String str3 = ",1234,188054,12341234123,23452345234523,1,1234567890,";

        List<String> list1 = wipeComma(str1);
        List<String> list2 = wipeComma(str2);
        List<String> list3 = wipeComma(str3);
        System.out.println(111);
    }

    private static List<String> wipeComma(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder newStr = new StringBuilder(str.substring(1, str.length()));
            List<String> list = new ArrayList<>();
            int right = 0;
            int left = right;
            while (right < newStr.length()) {
                if (newStr.charAt(right) == ',') {
                    list.add(newStr.substring(left, right));
                    left = right + 1;
                }
                right++;
            }
            return list;
        }
        return null;
    }
}
