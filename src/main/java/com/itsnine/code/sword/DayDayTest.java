package com.itsnine.code.sword;

import com.itsnine.code.sword.base.ListNode;
import sun.security.util.Length;

import java.util.*;

/**
 * @author xu.sun
 * @create 2021-08-05-10:32 下午
 */
public class DayDayTest {
    /**
     * 从尾到头打印链表
     *
     * @param node
     * @return
     */
    public int[] reservePrint(ListNode node) {
        int count = 0;
        ListNode tmp = node;
        while (Objects.nonNull(tmp)) {
            count++;
            tmp = tmp.next;
            System.out.println();
        }
        int[] array = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }

    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public int minArray(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[j] > nums[m]) j = m;
            else if (nums[j] < nums[m]) i = m + 1;
            else j--;
        }
        return nums[i];
    }

    public int fib(int n) {
        if (n == 1 || n == 0)
            return n;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }

//    public static void main(String[] args) {
//        lengthOfLongestSubstring("abba");
//    }
//    public static int lengthOfLongestSubstring(String s) {
//        int length = s.length();
//        int max = 0;
//
//        Map<Character, Integer> map = new HashMap<>();
//        for(int start = 0, end = 0; end < length; end++){
//            char element = s.charAt(end);
//            if(map.containsKey(element)){
//                //获取当前重复字符的下标位置+1与start位值取最大，若是不取最大值会导致start又返回到start位置前的该重复节点。如abba
//                start = Math.max(map.get(element) + 1, start);
//            }
//            max = Math.max(max, end - start + 1);
//            map.put(element, end);
//        }
//        return max;
//    }


    public static boolean cycleString(String s) {
        ArrayList<Character> sList = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            sList.add(s.charAt(i));
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (sList.get(start) != sList.get(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(calculate("45+5*6"));
    }


    /**
     * 最长回文子串
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int strLen = s.length();
        int left;
        int right;
        int len = 1;
        int maxLeft = 0;
        int maxLen = 0;

        char[] chars = s.toCharArray();
        //中心扩散
        for (int i = 0; i < chars.length; i++) {
            //当前位置的左边
            left = i - 1;
            //当前位置的右边
            right = i + 1;

            //如果当前位置的左边大于左边界并且当前位置的左边的值与当前位置的值相同，长度+1，再向左移一位
            while (left >= 0 && chars[left] == chars[i]) {
                len++;
                left--;
            }
            //如果当前位置的右边小于右边界并且当前位置的右边的值与当前位置的值相同，长度+1，再向右移一位
            while (right < strLen && chars[right] == chars[i]) {
                len++;
                right++;
            }
            //如果左移与右移后，仍未达到左右边界并且左右两边的值还相同，长度+2，向左向右各移一位
            while (left >= 0 && right < strLen && chars[left] == chars[right]) {
                len = len + 2;
                left--;
                right++;
            }

            //如果位置的最长子串大于最大子串的长度，记录当前子串的最左边界与长度
            if (len > maxLen) {
                maxLeft = left;
                maxLen = len;
            }

            len = 1;
        }
        return s.substring(maxLeft + 1, maxLeft + maxLen + 1);
    }

    /**
     * 数组不相邻元素最大之和
     * 动态规划 d[k]+d[k-2] 与 d[k-1] 谁最大，谁就是数组的最大不相邻数字之和
     * 有 n 个房子，前 n 间能偷窃到的最高金额是 dp[n]，
     * 前 n−1 间能偷窃到的最高金额是 dp[n-1] ，此时向这些房子后加一间房，此房间价值为 num
     * dp[n+1]=max(dp[n] , dp[n-1]+num)
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int preMax = 0, curMax = 0, tmp;
        for (int num : nums) {
            //暂存当前最大之和
            tmp = curMax;
            //当前位置数字与他之前的最大和相加，再与他前一位的最大和即目前最大之和相比较，取最大为当前位置最大之和
            curMax = Math.max(num + preMax, curMax);
            //记录前一位最大之和
            preMax = tmp;
        }
        return curMax;
    }


    public static int calculate(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack();
        int ans = 0, i = 0;
        while (i < cs.length) {
            //当前字符为空格，直接跳过
            if (cs[i] == ' ') {
                i++;
                continue;
            }
            char tmp = cs[i];
            //当前字符为操作符，i++拿取下一个字符
            if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
                i++;
                //当下一个位置小于数组长度且该字符为空格，i++拿取下一个字符
                while (i < cs.length && cs[i] == ' ') {
                    i++;
                }
            }
            int num = 0;
            //当下一个位置小于数组长度且该字符为数字
            while (i < cs.length && Character.isDigit(cs[i])) {
                //将当前数字扩大10倍再加上原数字，解决十位以上数字问题
                num = num * 10 + cs[i] - '0';
                i++;
            }
            //加法直接入栈，减法将当前数字转为负数入栈，乘法将栈中第一个数字弹出与当前数字相乘入栈，除法同理
            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);
        }
        //将栈中所有数字累加
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }

    public static int calc(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int i = 0;
        while (i < chars.length) {
            char tmp = chars[i];
            if (tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/') {
                i++;
            }
            int num = 0;
            if (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
                i++;
            }

            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
            }
            st.push(num);
        }
        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }

}
