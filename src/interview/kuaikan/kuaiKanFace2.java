package interview.kuaikan;

public class kuaiKanFace2 {

    public static void main(String[] args) {
        int[] case1_a = {1, 2, 3, 4};
        int[] case1_b = {4, 5, 6};
        int[] result1 = add(case1_a, case1_b);
        for (int i : result1) {
            System.out.print(i);
        }
        System.out.println();

        int[] case2_a = {1, 2, 3, 4};
        int[] case2_b = {9, 9, 9, 9};
        int[] result2 = add(case2_a, case2_b);
        for (int i : result2) {
            System.out.print(i + "");
        }
        System.out.println();
    }

    // int[] a = {1, 2, 3, 4};
    // int[] b = {4, 5, 6};
    // int[] c = add(a, b);
    // 1690
    public static int[] add(int[] a, int[] b) {
        int[] longArray = null;
        int[] shortArray = null;
        if (a.length >= b.length) {
            longArray = a;
            shortArray = b;
        } else {
            longArray = b;
            shortArray = a;
        }

        int[] result = new int[longArray.length + 1];
        int resultIndex = result.length - 1;
        int key = 0;
        int longIndex = longArray.length - 1;
        int shortIndex = shortArray.length - 1;

        for (int i = shortIndex; i >= 0 && resultIndex >= 0; i--) {
            int num = longArray[longIndex--] + shortArray[i] + key;
            // 进位
            key = num / 10;
            //  取个位
            result[resultIndex--] = num % 10;
        }

        for (; longIndex >= 0 && resultIndex >= 0; longIndex--) {
            if (key > 0) {
                int lastNum = longArray[longIndex] + key;
                result[resultIndex--] = lastNum;
                key = lastNum / 10;
            } else {
                result[resultIndex--] = longArray[longIndex];
            }
        }

        if (key > 0) {
            result[0] = key;
        }

        return result;
    }
}
