package ztest_package;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class SelfTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        Iterator iterator = set.iterator();

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedBlockingQueue<>();

        map.put(1,"1");
        map.put(2,"2");
        System.out.println(map.toString());
        map.put(1,"3");
        System.out.println(map.toString());




    }
}
