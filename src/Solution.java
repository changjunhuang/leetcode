public class Solution {

    public static void main(String[] args) {

//        int[] nums = {1,3,5,2,4};
//        int[] values = {1,2,3,4,5};

//        int[] nums = {1,3,5,7,9};
////        int[] values = {8,4,6,10,2};

        int[] nums = {1,100};
        int[] values = {2,1};

        System.out.println(getMaxValue(nums,values));

    }


    public static int getMaxValue(int[] nums, int[] values) {
        if (nums.length != values.length) {
            return 0;
        }

        //  定义指针
        int numsLeft = 0;
        int numsRight = nums.length - 1;
        int valuesLeft = 0;
        int valueRight = values.length - 1;

        int numsMin = 0;
        int valuesMin = 0;

        int total = 0;
        while (numsLeft <= numsRight) {
            if (nums[numsLeft] <= nums[numsRight]) {
                numsMin = nums[numsLeft];
                numsLeft++;
            } else {
                numsMin = nums[numsRight];
                numsRight--;
            }

            if (values[valuesLeft] <= values[valueRight]) {
                valuesMin = values[valuesLeft];
                valuesLeft++;
            } else {
                valuesMin = values[valueRight];
                valueRight--;
            }
            total = total + (numsMin * valuesMin);
        }

        return total;
    }

}
