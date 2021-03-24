package leetcode.github.fastSlowPointer;

import org.springframework.util.Assert;

/**
 *q_141 快乐数
 *
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 *
 */
public class Solution202 {

    public static int getNext(int n){
        int total =0;
        while(n>0){
            int d= n%10;
            n=n/10;
            total =total+d*d;
        }
        return total;
    }

    /**
     * 思路一： 超时
     * 快慢指针判断环
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int slow =n;
        int fast = getNext(n);
        while(fast !=1 && slow!=fast){
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }
        return fast==1;
    }

    public static void main(String[] args) {
        System.out.println("-------------开始执行-------------");
        Assert.isTrue(isHappy(19)==true,"程序异常");
        System.out.println("-------------运行通过-------------");

    }
}
