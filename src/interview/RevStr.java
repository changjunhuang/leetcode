package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 依图笔试
 *
 * @author huangchangjun
 * @date 2023-4-13
 */
public class RevStr {
    //I like beijing.  beijing. like I

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            System.out.println(RevString(a));
        }
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        in.hasNextLine();
//        String str = "I like beijing.";
//        System.out.println(RevString(str));
//    }

    public static String RevString(String str) {
        str = str.trim();
        List<String> strList = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!String.valueOf(str.charAt(i)).equals(" ")) {
                if (String.valueOf(str.charAt(i)).equals(".")) {
                    stringBuilder.append(str.charAt(i));
                    strList.add(stringBuilder.toString());
                    break;
                }
                stringBuilder.append(str.charAt(i));
                continue;
            }
            strList.add(stringBuilder.toString());
            stringBuilder = new StringBuilder();
        }

        stringBuilder = new StringBuilder();
        for (int j = strList.size() - 1; j >= 0; j--) {
            stringBuilder.append(strList.get(j)).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
