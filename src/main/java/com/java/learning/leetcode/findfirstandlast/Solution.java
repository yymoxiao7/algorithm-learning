package com.java.learning.leetcode.findfirstandlast;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class Solution {
    /**
     * 思路：既然是升序排列
     * 首先拿最大最小 判断
     * 然后判断一半
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int endIndex = nums.length - 1;

        if (nums[0] > target || nums[endIndex] < target) {
            return new int[]{-1, -1};
        }

        return find(nums, 0, endIndex, target);
    }

    private int[] find(int[] nums, int startIndex, int endIndex, int target) {
        if (startIndex == endIndex) {
            if (nums[startIndex] == target) {
                return new int[]{startIndex, startIndex};
            } else {
                return new int[]{-1, -1};
            }
        }
        int mid = (startIndex + endIndex) / 2;
        //初始化
        int left, right;
        //如果比中间值大 那么就落在右边
        if (target >= nums[mid + 1] && nums[mid] < target) {
            return find(nums, mid + 1, endIndex, target);
        } else if (nums[mid] >= target && target < nums[mid + 1]) {
            return find(nums, startIndex, mid, target);
        }
        //这种就是左右两边都有的情况
        left = findLeft(nums, 0, mid, target);
        right = findRight(nums, mid + 1, endIndex, target);
        if (left == -1 && right != -1) left = right;
        if (right == -1 && left != -1) right = left;
        return new int[]{left, right};
    }

    //既然进来 就说明右边的 边界一定能等于target
    private int findLeft(int[] nums, int startIndex, int endIndex, int target) {
        //边界判断
        if (startIndex == endIndex && nums[startIndex] != target) return -1;
        if (nums[startIndex] == target) return startIndex;

        //找左边最小等于的
        int mid = (startIndex + endIndex) / 2;
        if (nums[startIndex] <= target && nums[mid] >= target)
            return findLeft(nums, startIndex, mid, target);
        else if (nums[mid + 1] <= target && nums[endIndex] >= target)
            return findLeft(nums, mid + 1, endIndex, target);
        return -1;
    }

    //最左边一定等于target
    private int findRight(int[] nums, int startIndex, int endIndex, int target) {
        //边界判断
        if (startIndex == endIndex && nums[startIndex] != target) return -1;
        if (nums[endIndex] == target) return endIndex;

        //找左边最小等于的
        int mid = (startIndex + endIndex) / 2;
        if (nums[mid + 1] <= target && nums[endIndex] >= target)
            return findRight(nums, mid + 1, endIndex, target);
        if (nums[startIndex] <= target && nums[mid] >= target)
            return findRight(nums, startIndex, mid, target);

        return -1;
    }
}
