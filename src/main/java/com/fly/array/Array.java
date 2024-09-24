package com.fly.array;

import java.util.concurrent.ThreadLocalRandom;

public class Array {
    int[] nums = new int[5];

    public int access(int[] nums) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nums.length);
        return nums[randomIndex];
    }

    /**
     * 最后一位溢出
     *
     * @param nums
     * @param num
     * @param index
     */
    void insert(int[] nums, int num, int index) {
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;
    }

    /**
     * 最后一位无意义
     *
     * @param nums
     * @param index
     */
    void delete(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    void traverse(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += num;
        }
    }

    /**
     * 返回布尔类型（0/1），返回int类型（0/-1）
     *
     * @param nums
     * @param num
     * @return -1代表异常退出
     */
    int select(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * arraycopy对于一维数组的元素类型为基本类型、包装类型、String类型时为深拷贝；对于二维数组，和一维数组的元素类型为对象时为浅拷贝
     *
     * @param nums
     * @param enlarge
     * @return
     */
    int[] extend(int[] nums, int enlarge) {
        int[] res = new int[nums.length + enlarge];
        System.arraycopy(nums, 0, res, 0, nums.length);
        return res;
    }
}