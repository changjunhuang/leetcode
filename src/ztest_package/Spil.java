package ztest_package;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串分割
 */
public class Spil {
    public static void main(String[] args) {

        String str = ",1,2,3,";
        String newStr = str.substring(1,str.length());
        String[] list = newStr.split(",");
        List<String> array = Arrays.asList(list);
        for (String s : array) {
            System.out.println(s);
        }

        Map map = new HashMap();
    }
}
