public class Main {

/* 1. Two Sum */
// https://leetcode.com/problems/two-sum/submissions/957469655/
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[] {i, j};
            }
        }
    }
    return new int[] {};
}


/* 136. Single Number */
// https://leetcode.com/problems/single-number/submissions/958001607/
public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
        if (!map.containsKey(i)) {
            map.put(i, 1);
        } else{
            map.put(i, map.get(i) + 1);
        }
    }
    for (int i : nums) {
        if (map.get(i) == 1) {
            return i;
        }
    }
    return 0;
}



/*169. Majority Element */
// https://leetcode.com/problems/majority-element/submissions/958044347/
public int majorityElement(int[] nums) {
    int m = nums.length/2;
    for (int i : nums) {
        int count = 0;
        for (int j : nums) {
            if (i == j) {
                count += 1;
            }
        }
        if (count > m)
            return i;
    }

    return 0;
}




/* 1480. Running Sum of 1d Array */
// https://leetcode.com/problems/running-sum-of-1d-array/submissions/958008433/
public int[] runningSum(int[] nums) {

    for(int i=1;i<nums.length;i++){
        nums[i]=nums[i-1]+nums[i];
    }
    return nums;
}




/* 485. Max Consecutive Ones */
// https://leetcode.com/problems/max-consecutive-ones/submissions/958015329/
public int findMaxConsecutiveOnes(int[] nums) {
    int count=0, max=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]==1){
            count++;
            if(count>max){
                max=count;
            }
        }else{
            count=0;
        }
    }
    return max;
}




/* 55. Jump Game */
// https://leetcode.com/problems/jump-game/submissions/958026780/
public boolean canJump(int[] nums) {
    int maxDistance = nums[0];
    for (int i = 0; i < nums.length; i++) {
        if(i == nums.length - 1 ) return true;
        if(maxDistance == 0 && nums[i] == 0 ) return false;

        if ( nums[i] > maxDistance ) maxDistance = nums[i];
        maxDistance--;
    }
    return false;
}




/* 1470. Shuffle the Array */
// https://leetcode.com/problems/shuffle-the-array/submissions/958050857/
public int[] shuffle(int[] nums, int n) {
    int[] arrays = new int[2 * n];
    for (int i = 0; i < n; ++i) {
        arrays[2 * i] = nums[i];
        arrays[2 * i + 1] = nums[n+i];
    }
    return arrays;
}






}
