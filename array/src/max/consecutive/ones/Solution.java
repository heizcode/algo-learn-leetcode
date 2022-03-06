package max.consecutive.ones;

/**
 * @author hz
 * @version V1.0.0
 * @ClassName Solution
 * @Description TODO 485.最大连续 1 的个数
 * @Address https://leetcode-cn.com/problems/max-consecutive-ones/
 * @date 2022/3/3 14:52
 * @since JDK 1.8
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,0,0,0,1,1,1,0,1};
        System.out.println("解题一：结果：" + findMaxConsecutiveOnes(nums));
        System.out.println("解题二：结果：" + findMaxConsecutiveOnes02(nums));
        System.out.println("解题三：结果：" + findMaxConsecutiveOnes03(nums));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    //1,1,0,0,0,1,1,1,0,1
    public static int findMaxConsecutiveOnes02(int[] nums) {
        int count = 0; //临时统计变量，遇到 0 则变 0   3
        int maxcount = 0; //最终统计数,保存连续最大数     3
        //遍历参数数组
        for (int num : nums) {
            //如果当前元素是0，就把oneCount归0，否则就把
            //oneCount加1，然后更新max的值
            if (num == 0) {
                count = 0;
            } else {
                maxcount = Math.max(maxcount, ++count);
            }
        }
        return maxcount;
    }

    public static int findMaxConsecutiveOnes03(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            count = (nums[i] + count) * nums[i];
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    /**
    * 此题可能遇见的错误
    *   (1)、Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
    *      错误触发：在本题中循环遍历数组的时候，出现了nums[i + 1],导致数组下标越界
    * 此题业务场景
    *
    */
}
