package leetcode.everyday.april;

import org.springframework.util.Assert;

/**
 *q 154 寻找旋转排序数组中的最小值
 *
 *已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [1,3,5]
 * 输出：1
 *
 *
 * 示例 2：
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 *
 */
public class Solution_20210409_154 {


    /**
     * 就是 找数组中最小值，二分
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left =0;
        int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){ //右半部分找
                left=mid+1;
            }
            else if(nums[mid]<nums[right]){//左半部分找
                right=mid;
            }
            else{ //等于了,右边向里靠
                right=right-1;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        //Assert.isTrue(findMin(new int[]{3,4,5,1,2})==1,"程序异常");
        Assert.isTrue(findMin(new int[]{1,3,3})==1,"程序异常");
        //Assert.isTrue(findMin(new int[]{11,13,15,17})==11,"程序异常");
        System.out.println("-------------运行通过-------------");
    }
}
