package misc;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manasapte on 3/9/18.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solution = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int start = 0;
            int end = nums.length -1;
            int sum;
            while (start<end) {
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                sum = nums[start] + nums[end] + nums[i];
                System.out.println("start: "+start+" nums start: "+nums[start]+" end: "+end+" nums end: "+nums[end]+" i: "+i+" nums i:" + nums[i] + " sum: "+sum);
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    List<Integer> curSol = new ArrayList<>();
                    curSol.add(i);
                    curSol.add(start);
                    curSol.add(end);
                    solution.add(curSol);
                    start++;
                    end--;
                    while (nums[start] == nums[start-1]) {
                        start++;
                    }
                    while (nums[end] == nums[end+1]) {
                        end--;
                    }
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        List<List<Integer>> sol = t.threeSum(new int[] {-4,-1,-1,0,1,2});
        System.out.println("solution: " + sol);
    }
}
