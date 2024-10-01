package com.hramn.algo.binary_search;
/**
 * 162. Find Peak Element
 * 
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given a 0-indexed integer array nums, find a peak element, and return its 
 * index. If the array contains multiple peaks, return the index to any of the 
 * peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is 
 * always considered to be strictly greater than a neighbor that is outside the 
 * array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index 
 * number 2.
 * 
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak 
 * element is 2, or index number 5 where the peak element is 6.
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * -2**31 <= nums[i] <= 2**31 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */
public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = {1,2,1,3,5,6,4};
		Solution solution = new Solution();
		int result = solution.findPeak(nums);
		System.out.println(result);
		assert result == 1 || result == 5;
	}
	
	static class Solution {
		public int findPeak(int[] nums) {
			int l = 0, r = nums.length;
			while (r - l > 1) {
				int mid = l + (r - l) / 2;
				if (mid == 0 || nums[mid] > nums[mid - 1]) {
					if (mid ==nums.length - 1 || nums[mid] > nums[mid + 1]) {
						return mid;
					}
					l = mid;
				} else {
					r = mid;
				}
			}
			return l;
		}	
	}
}
