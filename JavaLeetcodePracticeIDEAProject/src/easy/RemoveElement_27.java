package easy;

//给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

import java.util.ArrayList;

public class RemoveElement_27 {
    public static void main(String[] args) {
        removeElement(new int[]{3, 2, 2, 3}, 3);
    }


//    static public int removeElement(int[] nums, int val) {
//        int answer = nums.length;
//        ArrayList<Integer> array = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                answer--;
//            }else array.add(nums[i]);
//        }
//        System.out.println(array);
//        return answer;}

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        System.out.println(nums);
        return i;
    }

}
