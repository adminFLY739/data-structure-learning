package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UseList {
    public static void main(String[] args) {
        // init
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));

        // select
        int num = nums.get(1);

        // update
        nums.set(0, 0);

        // delete
        nums.remove(0);
        nums.clear();

        // insert
        nums.add(5);
        nums.add(4);
        nums.add(3);
        nums.add(2);
        nums.add(1);

        // traverse
        int cnt = 0;
        for (Integer integer : nums) {
            cnt += integer;
        }
        System.out.println(cnt);

        // add
        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 0));
        nums.addAll(nums2);

        // sort
        Collections.sort(nums);
    }
}
